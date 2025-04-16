# Fase de construcción
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

# Copiar archivos de Maven primero para aprovechar la caché
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Descargar dependencias
RUN ./mvnw dependency:go-offline -B

# Copiar código fuente
COPY src/ src/

# Construir la aplicación (saltando tests)
RUN ./mvnw clean package -DskipTests

# Fase de producción
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar el jar desde la fase de construcción
COPY --from=builder /app/target/*.jar app.jar

# Crear directorio para tokens
RUN mkdir -p /app/tokens

EXPOSE 8890

ENTRYPOINT ["java", "-jar", "app.jar"]