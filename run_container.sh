#!/bin/bash

docker run -it \
    -v $PWD/src/:/app/javatest/src/main/java/javatest/ \
    -v $PWD/test/:/app/javatest/src/test/java/javatest/ \
    java:test bash
