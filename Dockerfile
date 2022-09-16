FROM harbor.lianlianlvyou.com/library/openjdk11:alpine-font
 
ARG PROFILES
 
ENV SPRING_PROFILES_ACTIVE ${PROFILES}
 
COPY target/*.jar app.jar
 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-Dserver.port=8088","-Dfile.encoding=UTF-8","-Duser.timezone=Asia/Shanghai","-XX:MaxDirectMemorySize=1024m","-XX:MetaspaceSize=256m","-XX:MaxMetaspaceSize=512m","-XX:MaxRAMPercentage=80.0","-jar","app.jar"]