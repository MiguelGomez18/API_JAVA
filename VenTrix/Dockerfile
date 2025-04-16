# Fase de construcción (con OpenJDK 21)
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# 1. Instala Maven (evita problemas con el wrapper)
RUN apt-get update && apt-get install -y maven

# 2. Copia solo los archivos necesarios para cachear dependencias
COPY pom.xml .

# 3. Descarga dependencias
RUN mvn dependency:go-offline -B

# 4. Copia el código fuente y compila
COPY src/ src/
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Fase de producción (con JRE 21, más ligero)
FROM openjdk:21-jre-slim
WORKDIR /app

# Copia el JAR desde la fase de construcción
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar

# Crea la carpeta para tokens
RUN mkdir -p /app/tokens

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]