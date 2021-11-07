#!/bin/bash
export COMPOSE_PROJECT_NAME=planner-prod
docker-compose -f docker-compose-cloud.yml stop
docker-compose -f docker-compose-cloud.yml rm -f
docker-compose -f docker-compose-cloud.yml up -d
