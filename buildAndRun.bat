@echo off
call mvn clean package
call docker build -t com.tarsissarabia/Aula4Pratica4 .
call docker rm -f Aula4Pratica4
call docker run -d -p 9080:9080 -p 9443:9443 --name Aula4Pratica4 com.tarsissarabia/Aula4Pratica4