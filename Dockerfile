#运行此项目还需要基于java镜像
FROM frolvlad/alpine-oraclejdk8:slim
#将本地文件夹挂载到当前容器
VOLUME /tmp
ADD service-feign-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
