# Use the base image from OpenJDK
FROM openjdk:17-jdk-slim

# Install Git
RUN apt-get update && apt-get install -y git

# Set the working directory
WORKDIR /app

# Clone the repository
RUN git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git

# Set the working directory for the cloned application
WORKDIR /app/gradle_basic_demo/

# Grant execution permission to the Gradle script
RUN chmod +x gradlew

# Build the application
RUN ./gradlew build

# Expose the port that the server will use
EXPOSE 5900

# Command to start the server
CMD ["./gradlew", "runServer"]

