## Starten des Containers:

docker pull mariadb

docker run --name iet_mariadb -e MYSQL_ROOT_PASSWORD=passme -d -v ~/docker/data/mysql:/var/lib/mysql -p 4306:3306 mariadb:latest

## Stoppen des Containers
docker stop iet_mariadb

## Welche Container haben wir
docker ps
auch die gestoppten Container werden angezeigt: docker ps -a 

## Container löschen
docker rm iet_mariadb

## Images anzeigen
docker images

## Logs anzeigen
docker logs iet_mariadb

## Container build
docker build -t ooe/iet_service:latest .

## Container run
docker run --name iet_service -e MYSQL_USER=root -e MYSQL_PASSWORD=passme -e MYSQL_DATABASE=testdb --link iet_mariadb:mysql_container -p 8080:8080 -p 9990:9990 ooe/iet_service

## Container stoppen und löschen
docker ps && docker stop iet_service && docker rm iet_service
docker ps && docker stop iet_mariadb && docker rm iet_mariadb



## Ergebnisse testen
curl http://localhost:8080/ietservice/rs
curl http://localhost:8080/ietservice/rs/tickets
curl -X GET -H "Accept: application/json" http://localhost:8080/ietservice/rs/tickets



https://goldmann.pl/blog/2014/07/23/customizing-the-configuration-of-the-wildfly-docker-image/
http://blog.arungupta.me/wildfly-javaee7-mysql-link-two-docker-container-techtip65/
https://github.com/arun-gupta/docker-images/tree/master/wildfly-mysql-javaee7


Troubleshooting:
Auf laufenden Container mit Terminal zugreifen
docker exec -it <containername> /bin/bash

