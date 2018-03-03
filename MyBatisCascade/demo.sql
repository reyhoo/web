drop table if exists t_female_health_form;
drop table if exists t_male_health_form;
drop table if exists t_task;
drop table if exists t_work_card;
drop table if exists t_employee_task;
drop table if exists t_employee;
create table t_employee(
id bigint not null auto_increment,
real_name varchar(60) not null,
sex int(2) not null,
birthday date not null,
mobile varchar(20) not null,
position varchar(20) not null,
note varchar(256),
constraint pk_t_emp primary key(id)
);

create table t_female_health_form(
id bigint not null auto_increment,
emp_id bigint not null,
heart varchar(64) not null,
liver varchar(64) not null,
spleen varchar(64) not null,
lung varchar(64) not null,
kidney varchar(64) not null,
uterus varchar(64) not null,
note varchar(256) not null,
primary key (id),
foreign key (emp_id) references  t_employee(id) on delete restrict on update restrict
);
create table t_male_health_form(
id bigint not null auto_increment,
emp_id bigint not null,
heart varchar(64) not null,
liver varchar(64) not null,
spleen varchar(64) not null,
lung varchar(64) not null,
kidney varchar(64) not null,
prostate varchar(64) not null,
note varchar(256) not null,
primary key (id),
foreign key (emp_id) references  t_employee(id) on delete restrict on update restrict
);
create table t_task(
id bigint not null auto_increment,
title varchar(60) not null,
context varchar(256) not null,
note varchar(256) not null,
primary key(id)
);
create table t_work_card(
id bigint not null auto_increment,
emp_id bigint not null,
real_name varchar(60) not null,
department varchar(20) not null,
mobile varchar(20) not null,
position varchar(30) not null,
note varchar(256) not null,
primary key(id),
constraint fk_work_card_emp foreign key (emp_id) references t_employee(id) on delete restrict on update restrict
);
create table t_employee_task(
id bigint not null auto_increment,
emp_id bigint not null,
task_id bigint not null,
task_name varchar(60) not null,
note varchar(256) not null,
primary key(id)
);
alter table t_employee_task add constraint fk_emp_task foreign key(emp_id) references t_employee(id) on delete restrict on update restrict;
alter table t_employee_task add constraint fk_emp_task_task foreign key(task_id) references t_task(id) on delete restrict on update restrict;
