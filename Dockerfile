# Utiliser une image officielle Java avec OpenJDK 17
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier jar compilé dans le conteneur
COPY target/smart-clinic-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel Spring Boot écoute
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
