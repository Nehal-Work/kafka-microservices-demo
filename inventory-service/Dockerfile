# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Add metadata labels (optional)
LABEL maintainer="yourname@example.com"
LABEL app="order-service"

# Add the JAR file to the container
COPY target/*.jar app.jar

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]