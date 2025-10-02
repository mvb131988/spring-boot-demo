@echo off

@REM for /f "delims=" %%i in ('docker ps --filter "name=my-postgres" --filter "status=running" --format "{{.Names}}"') do echo %%i

set "result="
for /f "delims=" %%i in ('docker ps --filter "name=my-postgres" --filter "status=running" --format "{{.Names}}"') do set result=%%i
if "%result%"=="my-postgres" (
    echo === Container my-postgres is running ===
) else (
    call docker compose up -d
)

call mvn clean package

echo === Starting application with remote debug on port 4070 ===
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=4070 -jar .\target\spring-core-demo-1.0-SNAPSHOT.jar