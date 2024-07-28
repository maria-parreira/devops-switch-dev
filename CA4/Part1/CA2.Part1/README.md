# Technical Report for Class Assignment 2 - Part 1


## Introduction

This is a technical report for de Class Assignment 2 about **Gradle** (a build automation tool that is designed to automate the building, testing, publishing, and deployment of software projects), made by Maria Parreira n.º 1231843, ISEP and Switch student.

This report provides a detailed account of the steps taken to complete the assignment, including the commands used, the issues encountered, and the solutions implemented.

To support this assignment will be used an example application : gradle_basic_demo.

(source code available at https://bitbucket.org/pssmatos/gradle_basic_demo/).


### What is a Gradle Task and how can we use that?

A Gradle task is a unit of work that can be executed as part of a Gradle build process.
Tasks are the building blocks of Gradle builds, and they encapsulate actions such as compiling source code, running tests, generating documentation, or deploying artifacts.

Tasks can be defined in _build.gradle_ file of the project.
You can specify the task name, any dependencies it might have, and the actions it should perform.

This tutorial use _**the Gradle build task**_.
This task compiles, tests, and assembles the code into a _JAR file_ (a compressed file that contains Java files, such as classes, resources, metadata, and libraries).

Open a terminal and execute the following command from the project's root directory:

```gradle
./gradlew build
```
It allows to run the application without requiring that Gradle be installed on your system.
Add it to version control system, and everyone that clones this project can build it just the same.

The way you run a specific task is by passing its name (on Linux/Mac):
```gradle
./gradlew <task-name> 
```


## Gradle Tutorial

Description of the steps used to achieve the **Class Assignment 2 [Part 1]** requirements using Gradle build tool and **Groovy** (a programming language that runs on the Java Virtual Machine used for scripting and building applications on the Java platform).

1. **Clone the Example Application**

Begin by cloning the example application provided in the assignment **introduction** description using the following command:

```bash
git clone https://bitbucket.org/pssmatos/gradle_basic_demo/
```
Go to the project directory:

```bash
   cd path/to/gradle_basic_demo
   ```
Copy the application into a new CA2/Part1 folder:

   ```bash
   cp -r . ../CA2.Part1
   cd ../CA2.Part1
   ```
command cp copies the directories and files stated ('.', the current directory), the '-r' notation says it will be copied recursively (all its contents) and '../CA2.Part1' is the destination folder.

2. **Add a task to execute the server**

Open _build.gradle_ folder and add this script:
```gradle
task runServer(type: JavaExec, dependsOn: classes) {
    group = "DevOps"
    description = "A server on localhost 59001 waits for clients."
    classpath = sourceSets.main.runtimeClasspath
    mainClass = 'basic_demo.ChatServerApp'
    args '59001'
}
```
This task sets up and executes a Java application (ChatServerApp) as a server listening on port 59001.

Task of type **JavaExec**, indicating that it will execute a Java class. It depends on the **classes** task, meaning that Gradle will ensure that the classes task has been executed first.
It belongs to a **group** named "DevOps" and provides a **description** of what it does.
This specifies the **classpath** that the JavaExec will use (runtime classpath of the main source) and the **main class** that should be executed when running the task (basic_demo.ChatServerApp).

Open a terminal and execute the following command from the project's root directory in order to run the task:

```gradle
./gradlew runServer
```

3. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add runServer task closes #issueNumber"
```

4. Push the changes to the remote repository:
```bash
git push
```

5. **Add a simple unit test**

To write a quick test for this application, just to make sure it starts with a greeting, let’s create the directory structure with the same package structure:
```bash
   mkdir -p src/test/java/basic_demo
   touch src/test/java/basic_demo/ChatServerAppTest.java
   ```

Inside _AppTest.java_ class add JUnit imports and unit test:

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting()); }
}
```

Go to _build.gradle_ folder and add this dependency:

```gradle
dependencies {
testImplementation group: 'junit', name:'junit', version:'4.12'
}
```
The JUnit 4.12 library doesn’t come with Java, so we’ll have to add it separately as a dependency for Gradle to download and include on the Java classpath when our test is compiled and run.

6. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add test class and unit test closes #issueNumber"
```

7. Push the changes to the remote repository:
```bash
git push
```

8. **Add a new task of Copy**
   Open the _build.gradle_ folder and add this script:

```gradle
task backup(type: Copy) {
    group = "DevOps"
    description = "Copy the contents of the src folder to a new backup folder."
    from 'src'
    into 'backup'
}
```
Task of type **Copy**, indicating that it will perform copying operations with the Copy method (provided by Gradle API).
This will copy all files and directories from the src directory into backup directory.

Open a terminal and execute the following command from the project's root directory in order to run the task:

```gradle
./gradlew backup
```

9. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add copy task closes #issueNumber"
```

10. Push the changes to the remote repository:
```bash
git push
```

11. **Add a new task of Zip**

Open the _build.gradle_ folder and add this script:

```gradle
task archive(type: Zip) {
    group = "DevOps"
    description = "Copy the contents of the src folder to a new zip file."
    from 'src'
    archiveFileName = "app-source.zip"
    destinationDirectory = file('archives')
}
```
Task is of type **Zip**, indicating that the ZIP method (provided by Gradle API) will create a ZIP archive.
This will create a ZIP archive named "app-source.zip" containing all files and directories from the src directory and place it in the archives directory.

Open a terminal and execute the following command from the project's root directory in order to run the task:

```gradle
./gradlew archive
```

12. Add and commit the changes(the -a command adds the files to the staging area):
```bash
git commit -a -m "Add zip task closes #issueNumber"
```

13. Push the changes to the remote repository:
```bash
git push
```

14. **At the end of this part of this assignment mark your repository with a new tag**

```bash
 git tag -a ca2-part1 -m "ca2-part1 release"
```

15. Push the changes to the remote repository:

```bash
git push --tags
```

![gradle.png](images/gradle.png)

from:https://tomgregory.com/gradle/gradle-tutorial-for-complete-beginners/


