create table t_book_board(
no number(38) primary key,
id varchar2(20) not null,
title varchar2(40) not null,
content varchar2(200) not null,
reg_date date default sysdate
);

create sequence seq_t_book_board_no;

create table t_book_comment(
no number(38) not null,
id varchar2(20) not null,
comment_no number(38) primary key,
content varchar2(100) not null,
reg_date date default sysdate
);


create sequence seq_t_book_board_comment_no;
