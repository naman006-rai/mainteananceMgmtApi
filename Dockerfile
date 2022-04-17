# Run the built JAR
FROM openjdk:8u181
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9092
ENTRYPOINT ["java","-jar","/app.jar"]