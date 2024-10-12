FROM eclipse-temurin:17-jdk-alpine
RUN apk add curl
VOLUME /tmp
EXPOSE 8081
ADD target/clientes-api.jar clientes-api.jar
ENTRYPOINT ["java", "-jar", "/clientes-api.jar"]