FROM openjdk:11 as base

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
copy src/ ./src
RUN ./mvnw dependency:go-offline

FROM base as test
CMD ["./mvnw", "test"]

FROM base as build
RUN ./mvnw package

FROM openjdk:11-jre-slim as prod
EXPOSE 8080

COPY --from=build /app/target/gaggle_challenge*.jar /gaggle_challenge.jar

CMD ["java", "-jar", "/gaggle_challenge.jar"]