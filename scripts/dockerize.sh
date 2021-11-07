#!/bin/bash
cd .. || exit 1
docker build -f src/main/docker/Dockerfile.native-distroless -t mbodev/quarkus-sample-distroless .
#docker build -f src/main/docker/Dockerfile.native -t mbodev/quarkus-sample .
