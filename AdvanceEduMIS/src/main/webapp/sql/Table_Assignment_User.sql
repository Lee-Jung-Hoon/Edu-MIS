
-- 과제 제출 DB (t_userassignment_board)--
create table t_user_assignment_board(
id varchar2(30) not null,
name varchar2(30) not null,
no number not null,
content varchar2(3000),
org_File_Name varchar2(1000),
real_File_Name varchar2(1000),
file_Path varchar2(1000),
primary key(id,no)
);

