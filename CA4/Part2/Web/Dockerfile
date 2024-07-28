FROM openjdk:17-jdk-slim
LABEL author="mariaparreira-code"

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

