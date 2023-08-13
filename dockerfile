FROM eclipse-temurin:11
RUN mkdir /opt/app
COPY target/gatling-task.jar /opt/app
CMD ["java", "-jar", "/opt/app/gatling-task.jar"]