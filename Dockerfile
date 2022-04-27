FROM openjdk:11
MAINTAINER kreznik

WORKDIR /src/main

ADD target/helloW-1.0-SNAPSHOT-jar-with-dependencies.jar /src/main/helloW-1.0-SNAPSHOT-jar-with-dependencies.jar
ADD hello.yaml /src/main/hello.yaml

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "helloW-1.0-SNAPSHOT-jar-with-dependencies.jar", "server", "hello.yaml"]