# Usando a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Definir diretório de trabalho dentro do container
WORKDIR /app

# Copiar o JAR gerado pelo Maven para dentro do container
COPY target/*.jar app.jar

# Comando para rodar o serviço
ENTRYPOINT ["java", "-jar", "app.jar"]
