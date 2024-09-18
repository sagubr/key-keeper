FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew shadowJar --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*-all.jar /app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
