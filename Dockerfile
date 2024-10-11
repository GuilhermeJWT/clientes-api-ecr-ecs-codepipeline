FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8081
COPY target/clientes-api.jar clientes-api.jar
ENTRYPOINT ["java", "-jar", "/clientes-api.jar"]