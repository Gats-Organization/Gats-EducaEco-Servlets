# Etapa de construção: criar o arquivo .war
FROM maven:latest AS warfile
WORKDIR /educaeco
COPY pom.xml . 
RUN mvn -B -f pom.xml dependency:resolve
COPY . . 
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package

# Etapa de execução: Tomcat para rodar o .war
FROM tomcat:9.0-jre8-alpine
# Definindo o diretório de trabalho no Tomcat
WORKDIR /usr/local/tomcat

# Copiar o arquivo .war gerado na etapa de construção para o diretório de aplicativos do Tomcat
COPY --from=warfile /educaeco/target/Servlets-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/EducaEco.war

# Copiar o script de inicialização
COPY run.sh /usr/local/tomcat/bin/run.sh
RUN chmod +x /usr/local/tomcat/bin/run.sh

# Definir variáveis de ambiente para o JPDA (Java Platform Debugger Architecture)
ENV JPDA_ADDRESS="8000"
ENV JPDA_TRANSPORT="dt_socket"

# Expor as portas necessárias
EXPOSE 8080 8000

# Configurar o comando para inicializar o Tomcat no modo de depuração
CMD ["sh", "/usr/local/tomcat/bin/run.sh"]
