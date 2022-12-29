FROM openjdk:8
EXPOSE 8080
ADD target/springboot-mongo-atlas-statistic.jar springboot-mongo-atlas-statistic.jar
ENTRYPOINT ["java","-jar","/springboot-mongo-atlas-statistic.jar"]