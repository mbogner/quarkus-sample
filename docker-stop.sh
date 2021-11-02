#!/bin/bash
docker-compose -f docker-compose-cloud.yml stop
docker-compose -f docker-compose-cloud.yml rm -f
