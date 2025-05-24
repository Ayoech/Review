# Stage 1: Build the application
FROM gradle:8.5-jdk21 AS builder

# Set the working directory
WORKDIR /app

# Copy everything to the container
COPY . .

# Make the Gradle wrapper executable and build the project
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon --stacktrace --info


# Stage 2: Run the application
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the default port for Spring Boot
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
