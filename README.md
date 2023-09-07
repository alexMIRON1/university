# University

## Connect to Postgres Database
```
docker run --name university-db -p 5431:5432 -e POSTGRES_USERNAME=postgres -e POSTGRES_PASSWORD=postgres postgres:14.1
```
### Create database into container (using CLI)
```
docker exec -it university-db /bin/bash

psql -U postgres -d postgres

create database university;

\c university

create schema univesity
```

## Instruction to start application via IntelliJ IDEA
1. Click RCM on the main class

![main-class.png](images/main-class.png)

2. Run application

![run.png](images/run.png)