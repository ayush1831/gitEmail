# define base docker image
FROM openjdk:11
LABEL maintainer="task2.rategain"
ADD target/task2-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]