# Fase de construcción con OpenJDK 21
FROM openjdk:21-jdk AS builder

WORKDIR /app

# 1. Instala Maven y configura el entorno
RUN apt-get update && \
    apt-get install -y maven && \
    rm -f mvnw* && \
    rm -rf .mvn/

# 2. Copia el POM primero para cachear dependencias
COPY pom.xml .

# 3. Descarga dependencias
RUN mvn dependency:go-offline -B

# 4. Copia el código fuente y compila
COPY src/ src/
RUN mvn clean package -DskipTests

# Fase de producción con JRE 21 (más ligero)
FROM openjdk:21-jre
WORKDIR /app

# Copia el JAR construido
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar

# Crea estructura de directorios
RUN mkdir -p /app/tokens && \
    chmod -R 755 /app

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]