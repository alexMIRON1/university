create table if not exists university.department
(id bigint not null, department_name varchar(255)
check (department_name in
('HUMAN_RESOURCES','RESEARCH_AND_DEVELOPMENT','SUPPORT','ENGINEERING','TRAINING','BUSINESS_DEVELOPMENT','LEGAL')),
 head_of_department varchar(255), primary key (id));