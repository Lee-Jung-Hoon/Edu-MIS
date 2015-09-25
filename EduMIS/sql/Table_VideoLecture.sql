create table t_lecture(
no number(4),
title varchar2(300),
contents varchar2(500),
video varchar2(400),
time date default sysdate
);

create sequence seq_user_lecture_no;

create table t_lecComment(
comno number(4),
no number(4),
id varchar2(100),
comments varchar2(500)
);

create sequence seq_t_lecComment_comno;