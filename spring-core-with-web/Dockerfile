# Use official Tomcat base image
FROM tomcat:10.1-jdk17

# Remove default ROOT webapp (optional)
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR into Tomcat's webapps directory
COPY target/spring-core-war.war /usr/local/tomcat/webapps/spring-core-war.war

# Expose port 8080
EXPOSE 8080 5005

# Enable JPDA (Java Platform Debugger Architecture) for remote debugging
ENV JPDA_ADDRESS=*:5005
ENV JPDA_TRANSPORT=dt_socket

# Start Tomcat
CMD ["catalina.sh", "jpda", "run"]