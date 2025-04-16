# Fase de construcción (con JDK 21)
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copia solo los archivos necesarios para cachear dependencias
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Descarga dependencias (usa caché de Docker)
RUN ./mvnw dependency:go-offline -B

# Copia el código fuente y compila
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# Fase de ejecución (con JRE 21, más ligero)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia el JAR desde la fase de construcción
COPY --from=builder /app/target/*.jar app.jar

# Crea la carpeta para tokens (como solicitaste)
RUN mkdir -p /app/tokens

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]