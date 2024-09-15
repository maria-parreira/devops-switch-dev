# DevOps Class Assignments

This project represents the assignments I developed during the DevOps course in the Switch program at the Instituto Superior de Engenharia do Porto in 2024.

The assignments are divided into five folders, each representing tasks with different objectives, as described below.

## Class Assignment 1 

### Objective [see more details](CA1)

- The assignment aimed to develop practical skills in using **Git and GitHub for version control** through a React.js and Spring Data REST application. 
- I used branches to develop new features (like an `email` field) and fix bugs, merging them into the master branch and tagging new versions.

## Class Assignment 2

### Part 1 Objective [see more details](CA2/Part1)

- This part aimed to develop practical skills using GitHub for **issue tracking** and **Gradle for build automation** through a simple example application. 


### Part 2 Objective [see more details](CA2/Part2)

- This part aimed to develop practical skills in using **GitHub for issue tracking** and **Gradle for build automation** by converting a basic version of a tutorial application from Maven to Gradle. 
- I added the necessary Gradle plugins and scripts to manage frontend tasks, configured Gradle to handle frontend builds, and created tasks to copy the generated JAR file to a `dist` folder and clean up webpack-generated files.

## Class Assignment 3

### Part 1 Objective [see more details](CA3/Part1)

- The assignment aimed to develop practical skills in using **UTM (for Apple with ARM64)** to run the projects from previous assignments inside a **VM with Ubuntu**. 
- I created a VM, cloned my repository inside it, and attempted to build and execute the Spring Boot tutorial and the Gradle Basic Demo project. 
- I installed the necessary dependencies and reported any issues encountered. 
- For web projects, I accessed the applications from the host machine's browser, and for projects like the simple chat application, I ran the server in the VM and clients on the host machine.

### Part 2 Objective [see more details](CA3/Part2)

- This part aimed to develop practical skills using **Vagrant** for setting up a virtual environment to run the Spring Boot application and the Gradle "basic" version. 
- I used the provided GitHub repository as an initial solution and studied the Vagrantfile to understand the creation and provisioning of two VMs: one for running Tomcat and the Spring Boot application, and another for the H2 server database. 


## Class Assignment 4

### Part 1 Objective [see more details](CA4/Part1)

- The first part of this assignment aimed to practice using **Docker** by creating **Docker images** and running **containers** with the chat application from CA2.
- I created a Docker image using a Dockerfile, tagged the image, and published it on Docker Hub. 
- I ensured the chat client could run on my host computer and connect to the chat server in the container. 
- Additionally, I explored Docker image concepts by creating two versions: one where the chat server was built inside the Dockerfile, and another where it was built on the host computer and the JAR file was copied into the Dockerfile.

### Part 2 Objective [see more details](CA4/Part2)

- The second part of this assignment aimed to use **docker-compose** to create two services/containers: web (running the SpringBoot application) and database (running the H2 server). 
- The task included publishing the images to Docker Hub and using a volume with the db container to copy the database file.
- Also in this part I used **Kubernetes** and create YAML files to define and manage the deployment of applications and databases in a cluster.

## Class Assignment 5

### Objective [see more details](CA5)

- For this assignment, I practiced **Continuous Integration/Continuous Deployment (CI/CD) with Jenkins**.
- I set up a Jenkins pipeline in my public repository to automate the build, test, and deployment process. 
- The pipeline stages included checking out the code, assembling the project, running tests, generating Javadoc, archiving artifacts, and publishing a Docker image to Docker Hub.
- The setup involved installing Jenkins, configuring necessary plugins, and managing credentials for accessing private repositories. 

---

This README provides an overview of the DevOps assignments I completed during the course. Each assignment folder contains further details and specific README files for more in-depth information.
