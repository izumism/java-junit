FROM ubuntu:18.04

SHELL ["/bin/bash", "-c"]

RUN apt update

WORKDIR /app

# java environment
RUN apt install -y openjdk-11-jdk maven

# Japanese locale
RUN apt install -y language-pack-ja-base language-pack-ja && \
    locale-gen ja_JP.UTF-8 

ENV LANG ja_JP.UTF-8

RUN mvn archetype:generate \
    -DgroupId=javatest \
    -DartifactId=javatest \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.4 \
    -DinteractiveMode=false

WORKDIR /app/javatest
COPY pom.xml /app/javatest
RUN mvn install
