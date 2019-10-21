#!/usr/bin/env bash

cd $(dirname $0)
cd ../

JAR_FILE=$(ls target |grep jar)

echo $JAR_FILE

java \
  -cp target/${JAR_FILE}:target/lib/* \
  -Daeron.cluster.member.endpoints="0=localhost:20110,1=localhost:20111,2=localhost:20112" \
  -Daeron.cluster.session.timeout=30000000000 \
  -Daeron.cluster.leader.heartbeat.timeout=50000000000 \
  -Daeron.client.liveness.timeout=200000000000 \
  -Daeron.publication.unblock.timeout=300000000000 \
  -Daeron.driver.timeout=200000000000 \
  ${JVM_OPTS} io.scalecube.acpoc.InteractiveClient