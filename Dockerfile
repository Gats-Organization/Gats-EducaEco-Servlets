# Etapa de construção: criar o arquivo .war
FROM maven:latest AS build
WORKDIR /educaeco
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package

# Etapa de execução: Tomcat para rodar o .war
FROM tomcat:10.0-jdk11
WORKDIR /usr/local/tomcat/webapps/
COPY --from=build /educaeco/target/Servlets-1.0-SNAPSHOT.war EducaEco.war

# Exponha as portas e inicie o Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
