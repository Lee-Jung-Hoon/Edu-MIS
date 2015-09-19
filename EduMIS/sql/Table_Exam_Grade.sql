
create table t_exam_grade(
	name varchar2(30) not null,
	no number not null,
	score number not null,
	reg_date date default sysdate
)
