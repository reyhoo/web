drop table if exists t_user;
create table t_user(
id bigint primary key auto_increment,
user_name varchar(60) not null,
sex int(2) not null COMMENT '男-1，女-2',
posi int(2) not null COMMENT '普通职工-1，经理-2，总裁-3',
birthday date not null,
note varchar(256) not null
);



insert into t_user(user_name,sex,posi,birthday,note)values('老张',1,3,'1987-3-6','总裁总裁总裁总裁');
insert into t_user(user_name,sex,posi,birthday,note)values('lucy',2,1,'1997-3-10','普通职工普通职工普通职工普通职工');
insert into t_user(user_name,sex,posi,birthday,note)values('tom',1,2,'1987-3-6','经理经理经理经理');

select count(*) from t_user