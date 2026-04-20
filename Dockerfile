# Step 1: Build stage
# We use a Maven + Java 17 image to build the app
FROM maven:3.9.6-amazoncorretto-17 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the parent pom first (for dependency caching)
COPY pom.xml .

# Copy all module poms
COPY exchange-api/pom.xml exchange-api/
COPY exchange-core/pom.xml exchange-core/
COPY exchange-infra/pom.xml exchange-infra/

# Download dependencies (this layer is cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy all source code
COPY exchange-api/src exchange-api/src
COPY exchange-core/src exchange-core/src
COPY exchange-infra/src exchange-infra/src

# Build the app, skip tests (tests run in CI separately)
RUN mvn clean package -DskipTests -B

# Step 2: Run stage
# We use a lightweight Java 17 image just to RUN the app
# This keeps the final image small - no Maven, no build tools
FROM amazoncorretto:17-alpine

WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /app/exchange-api/target/*.jar app.jar

# The port your Spring Boot app runs on
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]