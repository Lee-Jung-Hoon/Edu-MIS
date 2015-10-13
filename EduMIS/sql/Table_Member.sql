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


insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '박윤창', 'Penguins.jpg', 'memberFile');

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '김정우', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '안지원', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '김영재', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '오경석', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '이용수', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '윤경원', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '윤준호', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '이윤재', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '이정훈', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '정유성', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '정현빈', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '조보성', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '유희헌', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '김동욱', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '정현빈', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '이근우', 'pic3.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '김자영', 'pic2.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '김찬민', 'pic2.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '송혜원', 'pic2.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '윤수빈', 'pic2.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '어혜진', 'pic2.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '조아라', 'pic2.jpg', 'memberFile') ;

insert into t_member (no, name, real_File_Name, file_Path)
values(seq_t_member_no.nextVal, '김자영', 'pic2.jpg', 'memberFile') ;

commit;



