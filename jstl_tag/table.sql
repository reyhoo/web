drop table if exists t_user;
create table t_user(
id bigint primary key auto_increment,
user_name varchar(60) not null,
sex int(2) not null COMMENT '��-1��Ů-2',
posi int(2) not null COMMENT '��ְͨ��-1������-2���ܲ�-3',
birthday date not null,
note varchar(256) not null
);



insert into t_user(user_name,sex,posi,birthday,note)values('����',1,3,'1987-3-6','�ܲ��ܲ��ܲ��ܲ�');
insert into t_user(user_name,sex,posi,birthday,note)values('lucy',2,1,'1997-3-10','��ְͨ����ְͨ����ְͨ����ְͨ��');
insert into t_user(user_name,sex,posi,birthday,note)values('tom',1,2,'1987-3-6','����������');