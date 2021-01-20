FROM openjdk:8-jdk-alpine
WORKDIR /code
RUN apk add --no-cache maven
VOLUME /tmp
COPY  . .
CMD ["mvn", "spring-boot:run"]
EXPOSE 8081