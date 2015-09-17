-- 과제 출제 DB (t_adassignment_board)--
create table t_adassignment_board(
as_no number not null primary key,
as_startDate date not null,
as_endDate date not null,
as_title varchar2(500) not null,
as_content varchar2(3000),
as_file varchar2(1000)
);

-- 과제 제출 DB (t_userassignment_board)--
create table t_userassignment_board(
us_id varchar2(30) not null,
us_name varchar2(30) not null,
as_no number not null,
us_content varchar2(3000),
us_file varchar2(1000),
primary key(us_id,as_no)
);


 -- as_no sequence문 --
create sequence seq_adassignment_board_as_no;