FROM openjdk:8
EXPOSE 8083
ADD /target/timesheet-0.2-SNAPSHOT.jar timesheet-0.2-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","timesheet-0.2-SNAPSHOT.jar"]
