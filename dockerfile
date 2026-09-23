FROM tomcat:11-jdk21

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/employee-leave-management.war \
     /usr/local/tomcat/webapps/employee-leave-management.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
