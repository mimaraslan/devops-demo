FROM openjdk:11
#VOLUME /tmp
EXPOSE 8080
ADD target/*.jar devops-automation.jar
ENTRYPOINT ["java","-jar","/devops-automation.jar"]





##JDK sürümü
#FROM openjdk:17
#
## projenin JAR dosyasinin image icindeki adresi
#ARG JAR_FILE=target/*.jar
#
## image icindeki JAR dosyasinin ad
#COPY ${JAR_FILE} application.jar
#
##Linux gucellemesi
#CMD apt-get update-y
#
## projenin calisacagi ic port
#EXPOSE 8080
#
## Container icin projedeki JAR dosyasi  calistiriliyor
#ENTRYPOINT ["java", "-jar", "application.jar"]