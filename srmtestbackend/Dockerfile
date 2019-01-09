FROM java:8
VOLUME /tmp
ADD /build/libs/SRMTest.jar SRMTest.jar
## THE LIFE SAVER
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
CMD /wait 
RUN bash -c 'touch /SRMTest.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SRMTest.jar"]
