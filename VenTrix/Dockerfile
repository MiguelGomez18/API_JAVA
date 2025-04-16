# Fase de construcción con Java 21 y Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY src/ src/

RUN mvn clean package -DskipTests

# Fase de ejecución
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]
