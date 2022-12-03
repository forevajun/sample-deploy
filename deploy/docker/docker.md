```bash

# run

$ docker run -d \
    --name my-postgres \
    -e POSTGRES_DB=my-db \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -e PGDATA=/var/lib/postgresql/data/pgdata \
    -v /psqldata:/var/lib/postgresql/data \
    postgres:15.1-alpine

$ docker network create my-net
$ docker network connect my-net my-postgres

$ docker build -t forevajun/back:v1 .
$ docker run -it \
    --name my-back \
    --network=my-net \
    -e DB_HOSTNAME=my-postgres \
    -e DB_NAME=my-db \
    forevajun/back:v1

$ docker build -t forevajun/web:v1 .
$ docker run -it \
    --name my-web \
    --network=my-net \
    -p 8080:8080 \
    -e BACK_HOSTNAME=my-back \
    forevajun/web:v1


# check

$ docker network ls
$ docker images
$ docker ps -a
$ ls /psqldata/ -la


# rollback

$ docker network disconnect my-net my-web
$ docker network disconnect my-net my-back
$ docker network disconnect my-net my-postgres

$ docker stop my-web
$ docker stop my-back
$ docker stop my-postgres

$ docker rm my-web
$ docker rm my-back
$ docker rm my-postgres

$ docker rmi forevajun/web:v1
$ docker rmi forevajun/back:v1
$ docker rmi postgres

$ docker network rm my-net

$ rm -rf /psqldata/

```