FROM openjdk:17-jdk-alpine3.14
COPY ./target/ACCSetup-0.0.1-SNAPSHOT.jar ACCSetup-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","ACCSetup-0.0.1-SNAPSHOT.jar"]