create table t_exam_grade(
	id varchar2(100) not null,
	name varchar2(30) not null,
	title varchar2(100) not null,
	content varchar2(300) not null,
	no number not null,
	score number not null,
	reg_date date default sysdate
)