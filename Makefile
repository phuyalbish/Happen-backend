PROJECT_NAME=happen-app

.PHONY: build up down logs clean restart

build:
	./mvnw clean package -DskipTests
	docker-compose build

up:
	docker-compose up -d

down:
	docker-compose down

logs:
	docker-compose logs -f

restart: down up

clean:
	docker-compose down -v
	docker volume rm $$(docker volume ls -q | grep ${PROJECT_NAME}_mysql_data) || true