# University

## Connect to Postgres Database
```
docker run --name university-db --restart=on-failure -d --rm -p 5431:5432 -e POSTGRES_USERNAME=postgres -e POSTGRES_PASSWORD=postgres postgres:14.1
```
### Create database into container (using CLI)
```
docker exec -it local-postgres-container /bin/bash

psql -U postgres -d postgres

create database university;

\c university
```
