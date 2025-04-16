# Usamos la imagen oficial de Eclipse Temurin con JDK 21
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

COPY . .

RUN apt-get update && \
    apt-get install -y maven && \
    mvn -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean package

# Construimos la aplicación
RUN ./mvnw clean package -DskipTests

# Etapa de producción
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
RUN mkdir -p /app/tokens
EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]