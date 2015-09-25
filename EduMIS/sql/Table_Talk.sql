create table t_talk(
no number primary key,
p_no number,
send_member_no number,
receive_member_no number,
content varchar2(300),
send_date date default sysdate,
check_yn char(1) default 'n',
send_del char(1) default 'n' 
receive_del char(1) default 'n' 

);

create sequence seq_t_talk_no;