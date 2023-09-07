create table if not exists
university.department_lector (department_id bigint not null,
lector_id bigint not null, primary key (department_id, lector_id));



alter table if exists university.department_lector
add constraint FKi5jwkssy8kawtqunhx7q3ui87 foreign key (lector_id) references university.lector;

alter table if exists university.department_lector add constraint
FK57g67o2p8vdphk23xbk7o5gy foreign key (department_id) references university.department;