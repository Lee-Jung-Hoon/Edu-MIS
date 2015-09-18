create table t_member(
	no number primary key,
	id varchar2(10) not null,
	pass varchar2(30) not null,
	name varchar2(30) not null,
	zcode varcahr2(7) not null,
	zaddr varchar2(100) not null,
	email varchar2(30) not null,
	birth varchar2(6) not null,
	phone varchar2(11) not null,
	major varchar2(10) not null,
	join_date date not null,
	drop_check varchar2(3),
	drop_date date,
	drop_reason varchar2(100),
	group varchar2(5)		 
);