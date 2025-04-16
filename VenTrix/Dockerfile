# Fase de construcción con OpenJDK 21
FROM openjdk:21-jdk AS builder

WORKDIR /app

RUN rm -rf ~/.m2/repository/org/apache/maven/wrapper

# 1. Copiar los archivos del wrapper Maven primero
COPY .mvn/ .mvn/
COPY mvnw .

# 2. Dar permisos ejecutables al wrapper
RUN chmod +x mvnw

# 3. Copiar el POM para cachear dependencias
COPY pom.xml .

# 4. Descargar dependencias usando el wrapper
RUN ./mvnw dependency:go-offline -B

# 5. Copiar el código fuente y compilar
COPY src/ src/
RUN ./mvnw clean package -DskipTests

# Fase de producción con JRE 21
FROM openjdk:21-jre
WORKDIR /app

# Copiar el JAR construido
COPY --from=builder /app/target/VenTrix-0.0.1-SNAPSHOT.jar app.jar

# Crear estructura de directorios necesaria
RUN mkdir -p /app/tokens

EXPOSE 8890
ENTRYPOINT ["java", "-jar", "app.jar"]