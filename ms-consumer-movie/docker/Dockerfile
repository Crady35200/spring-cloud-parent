FROM java:8
LABEL author="crady35200@163.com"
LABEL desciption="movice service"
VOLUME /tmp
COPY movie.jar .
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' > /etc/timezone
EXPOSE 9200
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=${port}","-jar","movie.jar"]