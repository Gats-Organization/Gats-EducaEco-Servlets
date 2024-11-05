# Fase 1: Build do projeto
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM tomcat:10.1.19-jdk11
WORKDIR /usr/local/tomcat/bin
COPY run.sh run.sh
RUN chmod +x run.sh
#Copy war file
WORKDIR /usr/local/tomcat/webapps
COPY --from=build /app/target/Servlets-1.0-SNAPSHOT.war educaeco.war

# Expose ports
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"
EXPOSE 8080
WORKDIR /usr/local/tomcat/bin
CMD ["run.sh"]
