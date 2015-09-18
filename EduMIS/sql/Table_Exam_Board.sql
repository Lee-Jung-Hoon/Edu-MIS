create table t_exam_board(
title varchar2(100),
content varchar2(300),
no number,
reg_date date default sysdate
);

create sequence seq_t_exam_board_no;
