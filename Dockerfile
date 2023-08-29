# Use a base image with Java and Alpine Linux
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file into the container
COPY target/prime-number-finder-api-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
