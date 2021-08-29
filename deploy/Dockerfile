FROM openjdk:8u181-jdk-alpine

ARG workdir=/app
RUN mkdir ${workdir}
VOLUME ${workdir}
WORKDIR ${workdir}

ADD weather-0.0.1-SNAPSHOT.jar weather.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","weather.jar"]