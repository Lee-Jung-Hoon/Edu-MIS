
insert into table_name
(date_field)
values
(to_date('2008/04/14 22:02:14', 'yyyy/mm/dd hh24:mi:ss'));

/* att_type의 1: 출석  2: 지각   3: 조퇴   4: 결석   */
create table t_attend(
	mNo number ,
	mName varchar2(40),
	att_date date default sysdate,	
	att_type number,				
	primary key(mNo, att_date)
)
