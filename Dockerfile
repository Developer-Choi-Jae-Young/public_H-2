FROM tomcat:9.0
COPY ./hobbyharvest/target/hobbyharvest-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
WORKDIR /usr/local/tomcat/bin
ENTRYPOINT ["catalina.sh", "run"]