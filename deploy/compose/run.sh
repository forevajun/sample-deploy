#!/bin/bash

cd ../../project/back
mvn clean install
cd ../../deploy/docker

cd ../../project/web
mvn clean install
cd ../../deploy/docker

docker compose build

docker compose up
