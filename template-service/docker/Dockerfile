# FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.7_10-slim
FROM adoptopenjdk/openjdk11:jre-11.0.7_10

COPY maven/* /usr/local/

EXPOSE 8080

ENTRYPOINT ["/usr/local/run.sh"]
