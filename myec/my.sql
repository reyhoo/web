drop table ec_user_addr;
drop table ec_user;
create table if not exists ec_user(
	id bigint primary key auto_increment,
	username  varchar(100) not null,
	password varchar(255) not null,
	balance double default 10000.00
);
create table if not exists ec_user_addr(
	id bigint primary key auto_increment,
	addr  varchar(100) not null,
	mobile varchar(255) not null,
	user_id bigint not null,
	foreign key (user_id) references ec_user(id) on delete restrict on update restrict
);
