#!/bin/bash

cd ../../project/back
mvn clean install
cd ../../deploy/compose

cd ../../project/web
mvn clean install
cd ../../deploy/compose

docker compose build

docker compose up
