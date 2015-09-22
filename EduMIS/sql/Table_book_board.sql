create table t_book_board(
no number(38) primary key,
id varchar2(30) not null,
title varchar2(100) not null,
content varchar2(4000) not null,
org_File_Name varchar(120),
real_File_Name varchar2(120),
file_Path varchar(210),
reg_date date default sysdate
);

create sequence seq_t_book_board_no;

create table t_book_comment(
no number(38) not null,
id varchar2(30) not null,
comment_no number(38) primary key,
content varchar2(300) not null,
reg_date date default sysdate
);


create sequence seq_t_book_board_comment_no;
