@echo off

call mvn clean package

echo === Starting application with remote debug on port 4070 ===
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=4070 -jar .\target\spring-core-demo-1.0-SNAPSHOT.jar