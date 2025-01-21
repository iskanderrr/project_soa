# Use the official Tomcat 10 image as the base image
FROM tomcat:10.1

# Set the environment variables for proper Jakarta namespace
ENV CATALINA_OPTS="-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager"

# Copy the WAR file into the webapps directory of Tomcat
COPY ./Lineo_Donations_Pure_Java/target/test4.war /usr/local/tomcat/webapps/

# Expose port 8080 for the application
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
