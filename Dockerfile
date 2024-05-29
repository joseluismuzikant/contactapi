# Use the official Maven image with OpenJDK 17 to build the application
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and any other necessary files
COPY pom.xml .

# Copy the source code to the working directory
COPY src ./src

# Package the application (skip tests if needed)
RUN mvn clean package

# Use the official OpenJDK 22 image as the base image for running the application
FROM openjdk:22-jdk-slim

# Create a volume pointing to /tmp
VOLUME /tmp

# Copy the packaged jar file from the build stage
COPY --from=build /app/target/contactapi-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Entry point to run the application
ENTRYPOINT ["java","-jar","/app.jar"]
