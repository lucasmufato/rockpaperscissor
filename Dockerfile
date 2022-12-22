# BUILDER
FROM gradle:7.6-jdk17 AS builder
WORKDIR /app

COPY build.gradle.kts settings.gradle.kts  ./
RUN mkdir src
COPY src/ src/

RUN gradle clean build

# RUNNER
FROM eclipse-temurin:17-jdk

EXPOSE 8080

WORKDIR /home/api
COPY --from=builder app/build/libs/rockpaperscissor-*[0-9].jar /home/api/rockpaperscissor.jar
ENTRYPOINT ["java","-jar","/home/api/rockpaperscissor.jar"]