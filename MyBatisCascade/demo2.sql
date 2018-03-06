drop table if exists t_role;
drop table if exists t_user;
drop table if exists t_user_role;
create table t_role(
id bigint primary key auto_increment,
role_name varchar(60) not null,
note varchar(512)not null
);
create table t_user(
id bigint primary key auto_increment,
user_name varchar(60) not null,
real_name varchar(60)not null,
sex int(2) not null,
mobile varchar(20) not null,
email varchar(60) not null,
note varchar(512)not null
);
create table t_user_role(
id bigint primary key auto_increment,
user_id bigint not null,
role_id bigint not null,
constraint fk_ur_u foreign key(user_id) references t_user(id) on delete restrict on update restrict,
foreign key(role_id) references t_role(id) on delete restrict on update restrict
);



insert into t_role(role_name,note)values('role1','role111111111111111111111111111111');
insert into t_role(role_name,note)values('role2','role22222222222222222');
insert into t_role(role_name,note)values('role3','role333333333333333333');
insert into t_role(role_name,note)values('role4','role4444444444444444444');
insert into t_role(role_name,note)values('role5','role5555555555555555555555555');
insert into t_role(role_name,note)values('role6','role66666666666666666666666');
insert into t_role(role_name,note)values('role7','role777777777777777777777777');
insert into t_role(role_name,note)values('role8','role8888888888888888888888888888888');
insert into t_role(role_name,note)values('role9','role9999999999999999999999999');
insert into t_role(role_name,note)values('role10','role000000000000000000000000000000');


insert into t_user_role(user_id,role_id)values(1,1);
insert into t_user_role(user_id,role_id)values(1,10);
insert into t_user_role(user_id,role_id)values(1,4);
insert into t_user_role(user_id,role_id)values(1,3);
insert into t_user_role(user_id,role_id)values(1,2);



insert into t_user_role(user_id,role_id)values(2,10);
insert into t_user_role(user_id,role_id)values(2,8);
insert into t_user_role(user_id,role_id)values(2,5);
insert into t_user_role(user_id,role_id)values(2,7);


insert into t_user_role(user_id,role_id)values(3,2);
insert into t_user_role(user_id,role_id)values(3,8);
insert into t_user_role(user_id,role_id)values(3,6);
insert into t_user_role(user_id,role_id)values(3,1);
insert into t_user_role(user_id,role_id)values(3,10);



