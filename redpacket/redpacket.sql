drop table if exists t_user_red_packet;
drop table if exists t_red_packet;
create table t_red_packet(
id bigint primary key auto_increment,
user_id bigint not null,
amount double not null,
send_date datetime not null,
total bigint not null,
unit_amount double not null,
stock bigint not null,
version int default 0 not null,
note varchar(256) not null);


create table t_user_red_packet(
id bigint primary key auto_increment,
red_packet_id bigint not null,
user_id bigint not null,
amount double not null,
grab_time datetime not null,
note varchar(256)not null,
foreign key (red_packet_id) references t_red_packet(id)on delete restrict on update restrict
);
insert into t_red_packet(user_id,amount,send_date,total,unit_amount,stock,note)values(
1,20000.00,now(),2000,10,2000,'2万元金额，2千个小红包，每个10元'
);