create table if not exists university.lector
(salary float(53), id bigint not null, lector_degree varchar(255)
check (lector_degree in ('ASSISTANT','ASSOCIATE_PROFESSOR','PROFESSOR')), lector_full_name varchar(255), primary key (id));