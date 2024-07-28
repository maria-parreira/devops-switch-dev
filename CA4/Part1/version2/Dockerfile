# Use the base image from OpenJDK
FROM openjdk:21-jdk-slim as builder

# Set the working directory
WORKDIR /CA4/Part1

# Copy the JAR file to the working directory
COPY ./CA2/Part1/build/libs/basic_demo-0.1.0.jar .

# Command to run the application
CMD ["java", "-cp", "basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]