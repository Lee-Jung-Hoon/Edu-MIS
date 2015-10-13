-- 과제 출제 DB (t_adassignment_board)--
create table t_adm_assignment_board(
no number not null primary key,
start_Date date not null,
end_Date date not null,
title varchar2(500) not null,
content varchar2(3000),
org_File_Name varchar2(1000),
real_File_Name varchar2(1000),
file_Path varchar2(1000)
);

 -- as_no sequence문 --
create sequence seq_adm_assignment_board_no;