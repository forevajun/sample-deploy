#!/bin/bash

cd ../../project/back
mvn clean install
cd ../../deploy/docker

cd ../../project/web
mvn clean install
cd ../../deploy/docker

docker network create my-net

docker run -d \
  --name my-postgres \
  --rm \
  --network=my-net \
  -e POSTGRES_DB=my-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  -v /psqldata:/var/lib/postgresql/data \
  postgres:15.1-alpine

docker build -t forevajun/back:v1 ../../project/back
docker run -d \
  --name my-back \
  --rm \
  --network=my-net \
  -e DB_HOSTNAME=my-postgres \
  -e DB_NAME=my-db \
  forevajun/back:v1

docker build -t forevajun/web:v1 ../../project/web
docker run -d \
  --name my-web \
  --rm \
  --network=my-net \
  -p 8080:8080 \
  -e BACK_HOSTNAME=my-back \
  forevajun/web:v1
