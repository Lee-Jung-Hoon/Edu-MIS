
/* att_type의 1: 출석  2: 지각   3: 조퇴   4: 결석   */
create table t_attend(
	mNo number ,
	att_date date default sysdate, 
	att_type number
	primary key(mNo, att_date)
)
