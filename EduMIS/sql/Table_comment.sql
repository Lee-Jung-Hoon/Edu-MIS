
--수강생 관리--
create table t_comment(
		 no number not null primary key,
		 id varchar2(10) not null,
		 reg_data date default sysdate,
     content varchar2(3000)
);