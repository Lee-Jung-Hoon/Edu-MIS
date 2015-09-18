create table t_talk(
no number primary key,
p_no number,
send_member_no number,
receive_member_no number,
talk varchar2(300),
send_date date default sysdate,
is_check char(2) default 0,
is_del char(2) default 0 
);

create sequence seq_t_talk_no;