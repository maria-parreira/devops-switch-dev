# Technical Report for Class Assignment 4 Part 2

- This technical report documents Class Assignment 4 part 2 about **Docker** and **Kubernetes**, completed by Maria Parreira (Student ID: 1231843), a student at ISEP and Switch.


## Introduction Docker Compose

- In this tutorial, will be used **Docker Compose** to create and manage two services: one is a SpringBoot application and another one is a H2 Database.

- Docker Compose allows to define and manage multi-container Docker applications using a single YAML file (docker-compose.yml). 
- Instead of manually starting and linking multiple containers, Docker Compose automates this process, making it easier to handle complex applications with several services.

![compose.png](images/compose.png)


### Prerequisites

1. [Docker](https://www.docker.com) installed on your machine.
2. [Docker Hub](https://hub.docker.com) account (if you want to publish the images).

### **Goal:** run and connect two different containers simultaneously using this [docker-compose.yaml](DockerCompose/docker-compose.yaml)

- This file defines both services (containers) and specifies how they should communicate with each other.
- To start both containers simultaneously, run the following command on terminal:

```bash
docker-compose up
```

## Introduction kubernetes

- In this tutorial, will be used **kubernetes** to create and manage two services: one is a SpringBoot application and another one is a H2 Database.
- Docker alone is great for running individual containers but lacks native tools for orchestrating and managing clusters of containers.
- Kubernetes automates the deployment, scaling, and management of containers across a cluster of machines, making it easier to manage large-scale applications.
- Kubernetes provides self-healing capabilities. It automatically restarts failed containers, replaces them, and reschedules Pods on healthy nodes if a node fails.
- Kubernetes has built-in service discovery and load balancing.
- You define the desired state of your application using YAML files. This includes the number of replicas (Pods), the container images to use, environment variables, and any other necessary configuration.

![kubernetes.png](images/kubernetes.png)

### Prerequisites

- [Minikube](https://minikube.sigs.k8s.io/docs/) installed on your machine with docker.

### **Goal:** run and connect multiple containers simultaneously using kubernetes .yaml files

- Run the following commands to apply the [h2.yaml](Kubernetes/h2.yaml) configuration to your Kubernetes cluster:
- This command will create the Deployment and Service defined in the database YAML file.
- [h2-config.yaml](Kubernetes/h2-config.yaml) store configurations and environment variables that are used by Pods without modifying the code.
- [h2-secret.yaml](Kubernetes/h2-secret.yaml) is is used to store sensitive information, such as passwords.
- 
```bash
kubectl apply h2-config.yaml
kubectl apply h2-secret.yaml
kubectl apply -f h2.yaml
```

- Run the following command to apply the [webapp.yaml](Kubernetes/webapp.yaml) configuration to your Kubernetes cluster:
- This command will create the Deployment and Service defined in the web application YAML file.

```bash
kubectl apply -f webapp.yaml
```

- Check the status of the deployment to ensure the Pods are created and running:

```
kubectl get deployments
```

- Verify that the Pods are running correctly:

```
kubectl get pods
```

- Ensure the service is running and exposing the correct ports:

```
kubectl get services
```

## SetUp Kubernetes dashboard 

-The Kubernetes Dashboard is a web-based user interface that allows you to manage and monitor your Kubernetes clusters.

- Run the following command to create a service account with [admin-user.yaml](Kubernetes/admin-user.yaml):

```
kubectl apply -f admin-user.yaml
```

- Run command to generate a token and copy the result:
```
kubectl -n kubernetes-dashboard create token admin-user
```

- Run command the following command to create a local proxy that connects to the Kubernetes API server:
- This allows you to access resources and services within the Kubernetes cluster via a local HTTP connection without exposing them publicly.
```
kubectl proxy
```

- Open this link http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/login
- Paste token result on enter token

## My Results

![dashboard.png](Kubernetes/images/dashboard.png)
![dash.png](Kubernetes/images/dash.png)
![result.png](Kubernetes/images/result.png)

## Key Concepts

### Pod

- The smallest and simplest Kubernetes object. 
- Pods are used to host containerized applications.
- A Pod can contain one or more containers that share the same network.
- Containers within a Pod run on the same node and have access to the same IP address and storage volumes.
- Ideal for running a single service or task.

### Deployment

- Deployment is a resource that manages the creation and updates of Pods. 
- It ensures a desired number of Pods are running at any time and facilitates updates and scaling.
- It uses an update strategy to replace old Pods with new ones, maintaining service availability.

### Service

- A Service is a Kubernetes object that provides a stable network endpoint to access a set of Pods.
- It abstracts and exposes the underlying Pods to ensure that network access remains consistent despite changes in Pod IP addresses.
- Services allow Pods to communicate with each other and with external clients reliably.
