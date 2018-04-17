drop table if exists exe_role;
drop table if exists exe_user;
create table exe_user(
id bigint primary key auto_increment,
username varchar(20) not null,
password varchar(20) not null
);
create table exe_role(
id bigint primary key auto_increment,
role_name varchar(60) NOT NULL,
note varchar(512) NOT NULL,
user_id bigint not null,
sex int(2) not null,
pic varchar(512),
foreign key (user_id) references exe_user(id) on delete restrict on update restrict
);

insert into exe_user(username,password)values('tom','123456');
insert into exe_user(username,password)values('yaolei','123456');

insert into exe_role(role_name,note,sex,user_id)values('role1','note1',1,1);
insert into exe_role(role_name,note,sex,user_id)values('role2','note2',0,1);
insert into exe_role(role_name,note,sex,user_id)values('role3','note3',1,1);
insert into exe_role(role_name,note,sex,user_id)values('role4','note4',0,1);



insert into exe_role(role_name,note,sex,user_id)values('role5','note5',1,2);
insert into exe_role(role_name,note,sex,user_id)values('role6','note6',0,2);
insert into exe_role(role_name,note,sex,user_id)values('role7','note7',0,2);
insert into exe_role(role_name,note,sex,user_id)values('role8','note8',0,2);