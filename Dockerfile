FROM openjdk:8-jre-alpine

COPY aeron-cluster-poc-examples/target /app/target
COPY aeron-cluster-poc-examples/scripts /app/scripts

WORKDIR /app

ENV NUMBER="0"

RUN ["chmod", "+x", "scripts/node-0.sh"]
RUN ["chmod", "+x", "scripts/node-1.sh"]
RUN ["chmod", "+x", "scripts/node-2.sh"]
CMD ["/bin/sh", "-c", "scripts/node-${NUMBER}.sh"]