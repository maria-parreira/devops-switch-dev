# Use the base image from OpenJDK
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY basic_demo-0.1.0.jar .

RUN java -jar basic_demo-0.1.0.jar

# Command to run the application
CMD ["java", "-cp", "basic_demo-0.1.0.jar", "basic_demo.ChatServerApp", "59001"]