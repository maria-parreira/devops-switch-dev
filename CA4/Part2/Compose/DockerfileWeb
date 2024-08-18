FROM openjdk:21-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY demo-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

# Command to run the application
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar","./gradlew bootRun"]

