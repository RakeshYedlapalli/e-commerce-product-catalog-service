# Use a base image for Java
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY target/ecommerce-product-catalog-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which the app runs
EXPOSE 8082

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
