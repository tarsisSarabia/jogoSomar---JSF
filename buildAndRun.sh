#!/bin/sh
mvn clean package && docker build -t com.tarsissarabia/Aula4Pratica4 .
docker rm -f Aula4Pratica4 || true && docker run -d -p 9080:9080 -p 9443:9443 --name Aula4Pratica4 com.tarsissarabia/Aula4Pratica4