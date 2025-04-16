# Fase de construcción con OpenJDK 21
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# 1. Copia solo los archivos necesarios para cachear dependencias
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# 2. Instala Maven manualmente (evita problemas con el wrapper)
RUN apt-get update && \
    apt-get install -y maven && \
    mvn dependency:go-offline -B

# 3. Copia el código fuente y compila
COPY src/ src/
RUN mvn clean package -DskipTests

# Fase de producción con JRE de OpenJDK 21 (más ligero)
FROM openjdk:21-jre-slim
WORKDIR /app

# Copia el JAR desde la fase de construcción
COPY --from=builder /app/target/*.jar app.jar

# Crea la carpeta para tokens (como lo necesitas)
RUN mkdir -p /app/tokens

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]