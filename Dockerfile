FROM openjdk:17 AS BUILD
COPY . /project
WORKDIR /project
RUN ./gradlew test bootJar --no-daemon

FROM eclipse-temurin:17-jre-alpine
COPY --from=BUILD /project/build/libs/gitlab-java-microservice.jar /app/
WORKDIR /app
EXPOSE 8080
USER nobody:nobody

# Specified in k8's probes
HEALTHCHECK NONE

ENTRYPOINT ["java", "-jar", "gitlab-java-microservice.jar"]
