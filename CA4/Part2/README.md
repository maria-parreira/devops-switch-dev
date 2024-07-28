# Technical Report for Class Assignment 4 Part 2

- This technical report documents Class Assignment 4 part 1 about **Docker**, completed by Maria Parreira (Student ID: 1231843), a student at ISEP and Switch.


## Introduction

- This tutorial aims to demonstrate how to set up a **Dockerized environment** to run the basic Spring application using Gradle, as requested in the assignment. 
- In this tutorial, will be used **Docker** and **Docker Compose** to create two services: one to run the Spring application and another to run the H2 Database server.

- ### Requirements

1. [Docker](https://www.docker.com) installed on your machine
2. [Docker Hub](https://hub.docker.com) account (if you want to publish the images)


### The report is divided into sections:

1. **Clone the Repository**
2. **Dockerfile for Web Service**
3. **Dockerfile for Database Service**
4. **Docker Compose**
5. **Build and Run the Containers**
6. **Accessing the Application and Database**
7. **Kubernetes**


## Step 1: Clone the Repository

- Clone the repository with the Spring application:

```bash
git clone https://github.com/mariaparreira-code/devops-23-24-JPE-1231843.git
```

## Step 2: Dockerfile for Web Service

```Dockerfile
FROM openjdk:17-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory
WORKDIR /CA4/Part1

# Clone the repository
RUN git clone https://github.com/mariaparreira-code/devops-23-24-JPE-1231843.git

# Set the working directory for the cloned application
WORKDIR /CA4/Part1/devops-23-24-JPE-1231843/CA2.Part2/demoWithGradle

# Grant execution permission to the Gradle script
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Command
CMD ["./gradlew", "bootRun"]
```

## Step 3: Dockerfile for Database Service (H2)

```Dockerfile
FROM openjdk:17-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory
WORKDIR /CA4/Part1

# Clone the repository
RUN git clone https://github.com/mariaparreira-code/devops-23-24-JPE-1231843.git

# Set the working directory for the cloned application
WORKDIR /CA4/Part1/devops-23-24-JPE-1231843/CA2.Part2/demoWithGradle

# Grant execution permission to the Gradle script
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Command
CMD ["./gradlew", "bootRun"]
```

## Step 4: Build the Docker Image

- Build the Docker image by running the following command in the terminal, while in the project root:

```bash
docker build -t web -f DockerfileWeb .

docker build -t db -f DockerfileDb .
```

## Step 5: Docker Compose

- Create a docker-compose.yml file with the following configuration:

```yml
version: '3'  # Specify the version of the Docker Compose file format

services: # Define the services that make up the application

  db: # Define the database service
    build:
      context: .  # Use the current directory as the build context
      dockerfile: DataBase/Dockerfile
    container_name: database  # Name the container as "database"
    ports: # Map the container's ports to the host
      - "8082:8082"  # Map port 8082 on the host to port 8082 in the container (for H2 console)
      - "9092:9092"  # Map port 9092 on the host to port 9092 in the container (for H2 database connections)
    environment: # Set environment variables for the container
      - H2_OPTIONS=-tcp -tcpAllowOthers -ifNotExists  # Configure H2 database options to allow TCP connections
    volumes:
      - h2-data:/opt/h2-data  # Mount the "h2-data" volume to /opt/h2-data in the container to persist H2 database data

  web: # Define the web application service
    build:
      context: .  # Use the current directory as the build context
      dockerfile: Web/Dockerfile  # Specify the Dockerfile to use for building the web application image
    container_name: spring-web-application
    ports:
      - "8080:8080"  # Map port 8080 on the host to port 8080 in the container (for the Spring Boot application)
    environment:
      - SPRING_DATASOURCE_URL=jdbc:h2:tcp://database:9092/./jpadb  # Configure Spring Boot to use the H2 database hosted in the "database" container
    depends_on: # Specify service dependencies
      - db  # Ensure the "db" service starts before the "web" service to ensure the database is available

volumes:
  h2-data:
    driver: local
```
- Docker Compose simplifies the deployment of multi-container Docker applications by allowing users to define and manage all required services in a single file. 
- It streamlines environment setup, enabling easy replication across different stages, while ensuring consistency and portability.

## Step 6: Build and Run the Containers

- In the terminal, execute the following command in the root of your project:

```bash
docker-compose up --build
```
- This will build and run the containers defined in the docker-compose.yml file.

## Step 7: Accessing the Application and Database

   - Spring Application: Access http://localhost:8080/basic-0.0.1-SNAPSHOT
   - H2 Database Console: Access http://localhost:9092 and enter the credentials as configured in the Spring application

- To publish your images to Docker Hub, follow the steps described in the official Docker documentation.

## Kubernetes

- Kubernetes is an open-source container orchestration system that automates the deployment, scaling, and management of containerized applications. 
- It complements Docker by adding advanced orchestration capabilities, such as automatic scaling, load balancing, and fault recovery. 
- Kubernetes leverages Docker's popularity and knowledge while providing centralized and efficient management of distributed containers across clusters. 
- Its flexibility in supporting various containerization technologies makes it a valuable addition to Docker, enabling seamless management of containerized applications at scale.

## How to deploy and connect servers in Kubernetes using Minikube


### Step 1: Minikube Installation

- To install Minikube on your MacBook, you can use Homebrew. Run the following commands in the terminal:

```bash
brew install minikube
minikube start
```
- The first command will install Minikube, while the second will initialize a local Kubernetes cluster using Minikube.


### Step 2: Apply YAML Files

- With Minikube running, you can apply YAML files to define and deploy resources in the Kubernetes cluster. 

- For example, consider the following YAML files for a web service and a database:

**web-server.yaml:**

- This YAML configuration file defines a Kubernetes Pod named web-server.

```yaml
apiVersion: v1 # Specifies the API version for Kubernetes resources
kind: Pod # Defines the kind of resource, which is a Pod in this case
metadata:
  name: web-server # Metadata section includes the name of the Pod
spec:
  containers:
    - name: web # Defines a container named 'web' within the Pod
      image: web # Specifies the Docker image to use for this container
      ports:
        - containerPort: 8080 # Exposes port 8080 on the container
      env:
        - name: SPRING_DATASOURCE_URL # Sets an environment variable for the container
          value: jdbc:h2:tcp://database-service:9092/./jpadb # JDBC URL for the H2 database service
      imagePullPolicy: Never # Specifies that the image should not be pulled from a registry, assuming it is present locally
```

**database.yaml:**

- This YAML configuration file defines a Kubernetes Pod named database-server.

```yaml
apiVersion: v1 # Specifies the API version for Kubernetes resources
kind: Pod # Defines the kind of resource, which is a Pod in this case
metadata:
  name: database-server # Metadata section includes the name of the Pod
spec:
  containers:
    - name: database # Defines a container named 'database' within the Pod
      image: db # Specifies the Docker image to use for this container
      ports:
        - containerPort: 8082 # Exposes port 8082 on the container
        - containerPort: 9092 # Exposes port 9092 on the container
      env:
        - name: H2_OPTIONS # Sets an environment variable for the container
          value: "-tcp -tcpAllowOthers -ifNotExists" # Options for H2 database configuration
      resources: # Resource requests and limits section
        requests:
          memory: "64Mi" # Requests 64 MiB of memory
          cpu: "250m" # Requests 250 millicores of CPU
        limits:
          memory: "128Mi" # Limits the memory usage to 128 MiB
          cpu: "500m" # Limits the CPU usage to 500 millicores
      imagePullPolicy: Never # Specifies that the image should not be pulled from a registry, assuming it is present locally
```

- Apply these YAML files using the kubectl apply -f <yaml-file> command:
- It creates new resources in the cluster, such as pods. 
- A Pod is an abstraction that encapsulates one or more containers and provides a way to manage them as a single unit in Kubernetes.

```bash
kubectl apply -f web-server.yaml
kubectl apply -f database-server.yaml
```

- These commands will display a list of pods and services running in the Kubernetes cluster.

**Note: Deployment and Services**

Deployment: The YAML files provided here define individual Pods.
In a production environment, it's common to use Deployment resources instead, which manage Pod lifecycle, scaling, and updates. 
You can create a Deployment using YAML files similar to the ones provided, but with the kind changed to Deployment.

Services: While Pods are individual instances of an application, Services provide a way to access a set of Pods. 
They can load balance traffic across multiple Pods and provide a stable endpoint for accessing your application. 
You can create Services to expose your Pods using YAML files with kind: Service.

### Step 3: Check Status

- After applying the YAML files, you can check the status of deployed resources using the kubectl get <resource> command:

- This will display a list of pods and services running in the Kubernetes cluster.

```bash
kubectl get pods
```

### Step 4: Access Pod Logs

- To view logs from a specific container within a pod, you can use the kubectl logs command. Here's how you can do it:

```bash
kubectl logs <pod-name> 
```

### Step 5: Stop Minikube

- When you're done using Minikube, you can stop it with the following command:

```bash
minikube stop
```

- This will stop the local Kubernetes cluster and free up system resources.