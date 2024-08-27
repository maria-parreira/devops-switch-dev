# DevOps Class Assignments

This project represents the assignments I developed during the DevOps course in the Switch program at the Instituto Superior de Engenharia do Porto in 2024.

The assignments are divided into five folders, each representing tasks with different objectives, as described below.

## Class Assignment 1 

### Objective [see](CA1)

- The assignment aimed to develop practical skills in using Git and GitHub for version control through a React.js and Spring Data REST application. 
- In the first week, I worked on the master branch, adding a `jobYears` field, implementing unit tests, and tagging versions. 
- In the second week, I used branches to develop new features (like an `email` field) and fix bugs, merging them into the master branch and tagging new versions.

## Class Assignment 2

### Part 1 Objective [see](CA2/Part1)

- This part aimed to develop practical skills using GitHub for issue tracking and Gradle for build automation through a simple example application. 
- I downloaded and committed the example application from the provided link into my repository under CA2/Part1. 
- I read the instructions, experimented with the application, added a new task to execute the server, created a simple unit test, updated the Gradle script to run the test, and created tasks to back up the source files and create a zip archive of the source files.

### Part 2 Objective [see](CA2/Part2)

- This part aimed to develop practical skills in using GitHub for issue tracking and Gradle for build automation by converting a basic version of a tutorial application from Maven to Gradle. 
- I created a new branch `tut-basic-gradle`, initialized a Gradle Spring Boot project, and replaced its source files with those from the basic tutorial. 
- I added the necessary Gradle plugins and scripts to manage frontend tasks, configured Gradle to handle frontend builds, and created tasks to copy the generated JAR file to a `dist` folder and clean up webpack-generated files.

## Class Assignment 3

### Part 1 Objective [see](CA3/Part1)

- The assignment aimed to develop practical skills in using UTM (for Apple with ARM64) to run the projects from previous assignments inside a VM with Ubuntu. 
- I created a VM, cloned my repository inside it, and attempted to build and execute the Spring Boot tutorial and the Gradle Basic Demo project. 
- I installed the necessary dependencies and reported any issues encountered, particularly those related to running GUI tasks in the VM. 
- For web projects, I accessed the applications from the host machine's browser, and for projects like the simple chat application, I ran the server in the VM and clients on the host machine, explaining why this setup was needed.

### Part 2 Objective [see](CA3/Part2)

- This part aimed to develop practical skills using Vagrant for setting up a virtual environment to run the Spring Boot application and the Gradle "basic" version. 
- I used the provided GitHub repository as an initial solution and studied the Vagrantfile to understand the creation and provisioning of two VMs: one for running Tomcat and the Spring Boot application, and another for the H2 server database. 
- I copied the Vagrantfile to my repository and updated its configuration to use my Gradle version of the Spring application. 
- Additionally, I made the necessary changes for the Spring application to use the H2 server in the DB VM.

## Class Assignment 4

### Part 1 Objective [see](CA4/Part1)

- The first part of this assignment aimed to practice using Docker by creating Docker images and running containers with the chat application from CA2.
- I created a Docker image using a Dockerfile, tagged the image, and published it on Docker Hub. 
- I ensured the chat client could run on my host computer and connect to the chat server in the container. 
- Additionally, I explored Docker image concepts by creating two versions: one where the chat server was built inside the Dockerfile, and another where it was built on the host computer and the JAR file was copied into the Dockerfile.

### Part 2 Objective [see](CA4/Part2)

- The second part of this assignment aimed to use docker-compose to create two services/containers: web (running the SpringBoot application) and database (running the H2 server). 
- The task included publishing the images to Docker Hub and using a volume with the db container to copy the database file.
- Also in this part I used Kubernetes and create YAML files to define and manage the deployment of applications and databases in a cluster.

## Class Assignment 5

### Objective [see](CA5)

- For this assignment, I practiced Continuous Integration/Continuous Deployment (CI/CD) with Jenkins.
- I set up a Jenkins pipeline in my public repository to automate the build, test, and deployment process. The pipeline stages included checking out the code, assembling the project, running tests, generating Javadoc, archiving artifacts, and publishing a Docker image to Docker Hub.
- The setup involved installing Jenkins, configuring necessary plugins, and managing credentials for accessing private repositories. 
- I explored advanced integrations between Jenkins and Docker.
- This assignment emphasized the importance of comprehensive documentation and frequent commits to the repository, ensuring a well-documented and iterative development process.

---

This README provides an overview of the DevOps assignments I completed during the course. Each assignment folder contains further details and specific README files for more in-depth information.
