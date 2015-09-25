create table t_member(
   no number primary key,
   id varchar2(10) not null,
   name varchar2(30) not null,
   pass varchar2(30) not null,
   year varchar2(4) ,
   month varchar2(4) ,
   day varchar2(4) ,
   post_no char(7) ,  
   basic_addr varchar2(100) ,
   detail_addr varchar2(100) ,
   phone1 char(3) ,
   phone2 char(4) ,
   phone3 char(4) ,
   email varchar2(30) ,
   email_domain varchar2(20) ,
   major varchar2(10) ,
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