FROM adoptopenjdk/openjdk11:jdk11u-alpine-nightly-slim 

RUN mkdir /app
COPY helidon-quickstart-mp.jar /app
COPY libs /app/libs

CMD ["java", "-jar", "/app/helidon-quickstart-mp.jar"]
