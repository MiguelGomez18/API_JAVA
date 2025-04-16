# Fase de construcción
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# 1. Copia archivos (incluyendo el wrapper)
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# 2. Da permisos al wrapper y ejecuta
RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline -B

# 3. Copia el código y construye
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# Fase de producción (igual que arriba)
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]