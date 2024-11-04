# Fase 1: Build do projeto
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Fase 2: Execução com Tomcat
FROM tomcat:10.1.19-jdk11
COPY --from=build /app/target/Servlets-1.0-SNAPSHOT/ /usr/local/tomcat/webapps/app/

EXPOSE 8080

CMD ["catalina.sh", "run"]
