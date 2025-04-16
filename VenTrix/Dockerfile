# Fase de construcción con OpenJDK 21
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# 1. Instala Maven y elimina completamente el uso del wrapper
RUN apt-get update && \
    apt-get install -y maven && \
    rm -f mvnw* && \
    rm -rf .mvn/

# 2. Copia solo los archivos necesarios para cachear dependencias
COPY pom.xml .

# 3. Descarga dependencias
RUN mvn dependency:go-offline -B

# 4. Copia el código fuente y compila
COPY src/ src/
RUN mvn clean package -DskipTests

# Fase de producción
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]