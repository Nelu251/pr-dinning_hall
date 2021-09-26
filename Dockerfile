FROM openjdk:11
ADD target/dinning_hall.jar dinning_hall.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/dinning_hall.jar"]