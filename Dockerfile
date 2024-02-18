FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=build /app/target/final-exam.0.0.1-SNAPSHOT.jar final-exam.jar 

EXPOSE 8080 

ENTRYPOINT ["java", "jar", "final-exam.jar"]
