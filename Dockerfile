FROM openjdk:8

EXPOSE 8080

ADD target/book-details.jar book-details.jar

ENTRYPOINT ["java", "-jar", "book-details.jar"]
