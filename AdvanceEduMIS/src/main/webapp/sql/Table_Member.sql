create table t_member(
   no number primary key,
   id varchar2(10) not null,
   name varchar2(30) not null,
   pass varchar2(30) not null,
   year varchar2(4) not null,
   month varchar2(4) not null,
   day varchar2(4) not null,
   post_no char(7) not null,  
   basic_addr varchar2(100) not null,
   detail_addr varchar2(100) not null,
   phone1 char(3) not null,
   phone2 char(4) not null,
   phone3 char(4) not null,
   email varchar2(30) not null,
   email_domain varchar2(20) not null,
   major varchar2(10) not null,
   join_date date default sysdate,
   drop_check varchar2(3),
   drop_date date,
   drop_reason varchar2(100),
   team varchar2(5),
   tech_leader char(1),
   grade varchar2(1) default 2,
   org_File_Name varchar2(1000),
   real_File_Name varchar2(1000),
   file_Path varchar2(1000)
);
create sequence seq_member_no

insert into t_member (no, id, name, pass, grade) values (seq_member_no.nextVal, 'admin', '관리자', '1234', '1');