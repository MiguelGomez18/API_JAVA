# Fase de construcción con Java 21
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

COPY pom.xml .
COPY src/ src/

RUN ./mvnw clean package -DskipTests

# Fase de ejecución
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]