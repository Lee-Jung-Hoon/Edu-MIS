create table t_schedule(
title varchar2(90),
reg_date date default sysdate,
start_date varchar2(30) ,
end_date varchar2(30),
importance number(1) ,
content varchar2(300),
latitude varchar2(30) ,
longitude varchar2(30) ,
no number primary key,
);

create sequence seq_t_schedule_no;