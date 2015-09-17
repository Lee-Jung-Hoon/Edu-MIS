
create t_exam_grade(
	name varchar2(30) not null,
	title varchar2(200) not null,
	score number not null,
	reg_date date default sysdate
)
