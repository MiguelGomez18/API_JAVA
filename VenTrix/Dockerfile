# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

COPY pom.xml .
COPY src/ src/

# Sin wrapper, usando Maven directo
RUN mvn -B -DskipTests clean package

# Etapa de ejecución
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]
