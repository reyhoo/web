drop table ec_order_product;
drop table ec_product;
drop table ec_order;
drop table ec_user_addr;
drop table ec_user;
create table if not exists ec_user(
	id bigint primary key auto_increment,
	username  varchar(100) not null unique,
	password varchar(255) not null,
	balance double default 10000.00 not null
);
create table if not exists ec_user_addr(
	id bigint primary key auto_increment,
	nickname varchar(50) not null,
	addr  varchar(100) not null,
	mobile varchar(50) not null,
	user_id bigint not null,
	foreign key (user_id) references ec_user(id) on delete restrict on update restrict
);
create table ec_order(
	id bigint primary key auto_increment,
	create_time datetime not null,
	pay_time datetime,
	status varchar(10) not null,
	addr  varchar(100) not null,
	mobile varchar(50) not null,
	nickname varchar(50)not null,
	consume_id bigint not null,
	merchant_id bigint not null,
	foreign key (consume_id) references ec_user(id) on delete restrict on update restrict,
	foreign key (merchant_id) references ec_user(id) on delete restrict on update restrict
);
create table ec_product(
	id bigint primary key auto_increment,
	product_name varchar(50) not null,
	stock int not null default 0,
	price double not null
);
create table ec_order_product(
	id bigint primary key auto_increment,
	product_id bigint not null,
	product_name varchar(255) not null,
	product_unit_price double not null,
	product_quantity int not null,
	product_amount double not null,
	order_id bigint not null,
	foreign key (product_id) references ec_product(id) on delete restrict on update restrict,
	foreign key (order_id) references ec_order(id) on delete restrict on update restrict
);
insert into ec_user(username,password) values('15129237121@163.com','e10adc3949ba59abbe56e057f20f883e');
insert into ec_user(username,password) values('373561022@qq.com','e10adc3949ba59abbe56e057f20f883e');
insert into ec_user(username,password) values('670870716@qq.com','e10adc3949ba59abbe56e057f20f883e');
insert into ec_user(username,password) values('13032162523@163.com','e10adc3949ba59abbe56e057f20f883e');
insert into ec_user(username,password) values('571888977@qq.com','e10adc3949ba59abbe56e057f20f883e');

insert into ec_user_addr(nickname,addr,mobile,user_id)values('姚磊','哈雷路','15129237121',1);
insert into ec_user_addr(nickname,addr,mobile,user_id)values('姚磊reyhoo','北艾路1200弄','15129237121',2);
insert into ec_user_addr(nickname,addr,mobile,user_id)values('魏碧云','北艾路1200弄','13032162523',4);
insert into ec_user_addr(nickname,addr,mobile,user_id)values('魏碧云','公司地址我不知道','13032162523',5);