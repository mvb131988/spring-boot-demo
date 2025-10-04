@echo off

@REM http://localhost:8080/spring-core-war/hello

@REM for /f "delims=" %%i in ('docker ps --filter "name=my-tomcat" --filter "status=running" --format "{{.ID}}"') do echo %%i

call mvn clean package

set "result="
for /f "delims=" %%i in ('docker ps --filter "name=my-tomcat" --filter "status=running" --format "{{.ID}}"') do set result=%%i
if not "%result%"=="" (
    echo === Stop my-tomcat container ===
    docker kill %result%
)
docker rm my-tomcat
docker build -t my-tomcat .
docker run -d -p 8080:8080 -p 5005:5005 --name my-tomcat my-tomcat