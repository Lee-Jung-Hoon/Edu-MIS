create table t_exam_board(
title varchar2(100) not null,
content varchar2(300) not null,
no number primary key not null,
ck varchar2(10) not null,
reg_date date default sysdate
);

create sequence seq_t_exam_board_no;