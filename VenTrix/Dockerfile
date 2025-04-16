# Fase de construcción
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Cache de dependencias
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B

# Compilación
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# Fase de ejecución
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN mkdir -p /app/tokens  # Carpeta para tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]