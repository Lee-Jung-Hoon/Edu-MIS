create table t_schedule(
no number primary key,
title varchar2(90),
content varchar2(300),
reg_date date default sysdate,
start_date varchar2(30) ,
end_date varchar2(30),
importance number(1) ,
latitude varchar2(30) ,
longitude varchar2(30)
);

create sequence seq_t_schedule_no;