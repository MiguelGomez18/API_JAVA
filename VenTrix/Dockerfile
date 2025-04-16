# Fase de construcción con OpenJDK 21 y Maven instalado
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# 1. Instala Maven
RUN apt-get update && \
    apt-get install -y maven

# 2. Copia los archivos del proyecto
COPY pom.xml .
COPY src/ src/

# 3. Descarga dependencias y construye (sin usar el wrapper)
RUN mvn dependency:go-offline -B && \
    mvn clean package -DskipTests

# Fase de producción
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]