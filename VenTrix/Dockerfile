# Fase de construcción con OpenJDK 21
FROM openjdk:21-jdk AS builder

WORKDIR /app

# 1. Instalar Maven directamente (sin usar el wrapper)
RUN apt-get update && \
    apt-get install -y maven

# 2. Copiar solo el POM primero para cachear dependencias
COPY pom.xml .

# 3. Descargar dependencias
RUN mvn dependency:go-offline -B

# 4. Copiar el código fuente y compilar
COPY src/ src/
RUN mvn clean package -DskipTests

# Fase de producción con JRE 21 (más ligero)
FROM openjdk:21-jre
WORKDIR /app

# Copiar el JAR construido
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar

# Crear estructura de directorios necesaria
RUN mkdir -p /app/tokens

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]