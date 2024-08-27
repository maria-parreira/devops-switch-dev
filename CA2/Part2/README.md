# Technical Report for Class Assignment 2 - Part 2


## Introduction

This is a technical report for de Class Assignment 2 about **Gradle** and **Maven**, made by Maria Parreira n.º 1231843, ISEP and Switch student.

This report provides a detailed account of the steps taken to complete the assignment, including the commands used, the issues encountered, and the solutions implemented.

To support this assignment will be used an example application : Tutorial React.js and Spring Data REST.

(source code available at https://github.com/spring-guides/tut-react-and-spring-data-rest)

The objective is to enhance the Tutorial application (described above) by transitioning its basic version WITH MAVEN, to a better version, by implementing a basic Gradle setup.
The aim is to introduce new features and streamline the development process.

### The report is divided into three sections:

1. Gradle Tutorial

2. Comparison: Maven vs. Gradle


## Gradle 

Description of the steps used to achieve the **Class Assignment 2-Part 2** requirements using Gradle build tool and **Groovy** (a programming language that runs on the Java Virtual Machine used for scripting and building applications on the Java platform).

1. The first step is to create a new branch called "tut-basic-gradle" in the repository to work on. To do so, open terminal and type in the command:

```bash
  git branch tut-basic-gradle
```

After creating the branch, switch to it by typing:

```bash
  git checkout tut-basic-gradle
```

2. Go to [this website](https://start.spring.io) to generate a new gradle spring boot project.

Fill in the necessary information and add the needed dependencies according to the image below:
![image.png](demoWithGradle/images/imagem.png)

Click on the "Generate" button and download the project. 

Extract the files to the CA2/Part2/demoWithGradle folder.

3. In the **Employee.java** class, change all *javax.persistence* imports to *jakarta.persistence*.

4. You can now experiment with the application by using (first navigate to the project folder):

```bash
  ./gradlew bootRun
```
Gradle will compile the project (if necessary) and then execute the Spring Boot application as if it were a regular Java application.


5. Open the build.gradle file and add the plugin org.siouan.frontend to the project:

```gradle
   id "org.siouan.frontend-jdk17" version "8.0.0"
```

By adding this plugin to build.gradle file, you can automate tasks related to the frontend, such as installing and configuring Node.js dependencies, as well as executing JavaScript scripts during the build process.


6. Configure the plugin added in the same build.gradle file:


```gradle
   frontend {
   nodeVersion = "16.20.2"
   assembleScript = "run build"
   cleanScript = "run clean"
   checkScript = "run check"
   }
```

These configurations enable customization and automation of various aspects of front-end development, such as building, cleaning, and checking, within the context of the org.siouan.frontend-jdk17 plugin.

7. Add the dependencies in the package.json file:
```gradle
   "scripts": {
   "webpack": "webpack",
   "build": "npm run webpack",
   "check": "echo Checking frontend",
   "clean": "echo Cleaning frontend",
   "lint": "echo Linting frontend",
   "test": "echo Testing frontend"
   }
```

These scripts are used to automate various development tasks, such as building, checking, cleaning, linting code quality, and running tests.

8. Add the package manager to the package.json file, before the scripts section:

```gradle
   "packageManager": "npm@9.6.7",
```

The npm is the default package for the Node.js environment, used for installing, managing, and sharing JavaScript code packages.
Defining the package manager in the package.json is useful to ensure that development team use the same npm version and have a consistent development environment configuration.

9. Compile the project in the terminal(first navigate to the project folder):

```bash
  ./gradlew build
```

The tasks related to the frontend are also executed and the frontend code is generated.


10. Open the build.gradle file and add the task:

```gradle
   task copyJarToDist(type: Copy, dependsOn: build) {
       from 'build/libs/'
       into 'dist'
       include '*.jar'
   }
```

11. Open the build.gradle file and add the task:

```gradle
   task deleteFilesWebpack(type: Delete) {
       delete 'src/main/resources/static/built'
   }
```

12. Add the following command to make sure this task is executed automatically by the task *clean*:

```gradle
   clean.dependsOn(deleteWebpackFiles)
```

13. Compile the project in the terminal(first navigate to the project folder):

```bash
  ./gradlew build
```

14. You may now execute the application by using (first navigate to the project folder):

```gradle
   ./gradlew bootRun
```

15. Open the web page http://localhost:8080 and you should view de next image:

![result1.png](demoWithGradle/images/result1.png)




### Comparison: Maven vs. Gradle

When it comes to choosing the right build automation tool for your Spring Boot application, understanding the differences and similarities between Maven and Gradle is essential.

#### Maven

Maven, a widely-used build automation tool, follows a convention-over-configuration approach.
It utilizes XML-based project configuration files (pom.xml) to define project structure, dependencies, and build settings.
Maven relies on a predefined lifecycle consisting of phases such as compile, test, package, and install, making it easy to understand and use.
However, Maven's XML configuration can become verbose, especially for complex projects, and its dependency management sometimes leads to conflicts or version mismatches.

#### Gradle

In contrast, Gradle offers a more flexible and concise build configuration using Groovy.
It provides a powerful scripting language that allows for fine-grained control over the build process.
Gradle's dependency management is more sophisticated, supporting transitive dependencies, dynamic versions, and conflict resolution.
It also allows for incremental builds, improving build performance for large projects.
However, the learning curve for Gradle can be steeper compared to Maven due to its scripting nature.

### Conclusion

Both Maven and Gradle have their strengths and weaknesses, making them suitable for different project requirements and team preferences.
Maven's simplicity and convention-driven approach make it a solid choice for smaller projects or teams familiar with XML configuration.
On the other hand, Gradle's flexibility and powerful scripting capabilities make it well-suited for larger, complex projects with specific customization needs.
Ultimately, the choice between Maven and Gradle depends on factors such as project complexity, team expertise, and desired level of control over the build process.




