# Etapa de compilación
FROM gradle:jdk21-alpine AS build

RUN apk update && apk add bash
RUN apk add --no-cache docker openrc

WORKDIR /app

COPY build.gradle.kts .
COPY gradlew .
COPY gradle gradle
COPY src src

RUN chmod +x ./gradlew

RUN ./gradlew build

# Etapa de ejecución
FROM eclipse-temurin:21-jre-alpine AS run

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/my-app.jar

COPY --from=build /app/build/docs/javadoc/ /app/docs/docs

COPY --from=build /app/build/jacocoHtml /app/docs/coverage

COPY --from=build /app/build/reports/tests/test /app/docs/test



ENTRYPOINT ["java", "-jar", "/app/my-app.jar"]