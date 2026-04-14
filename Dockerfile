FROM eclipse-temurin:17-jdk
WORKDIR /app
# CHANGE: YOUR-PROJECT-NAME-1.0.jar to match your artifactId in pom.xml
COPY target/ShoppingCart-1.0.jar app.jar
CMD ["java", "-jar", "app.jar"]
