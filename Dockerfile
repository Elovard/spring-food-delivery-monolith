FROM eclipse-temurin:17.0.4_8-jre-alpine
COPY /target/food-pet-project-latest.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
