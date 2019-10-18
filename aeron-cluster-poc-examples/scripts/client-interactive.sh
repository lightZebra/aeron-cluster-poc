#!/usr/bin/env bash

cd $(dirname $0)
cd ../

JAR_FILE=$(ls target |grep jar)

echo $JAR_FILE

java \
  -cp target/${JAR_FILE}:target/lib/* \
  -Daeron.cluster.member.endpoints="0=mpp-vysochyn:20110,1=mpp-habryiel:20111" \
  ${JVM_OPTS} io.scalecube.acpoc.InteractiveClient