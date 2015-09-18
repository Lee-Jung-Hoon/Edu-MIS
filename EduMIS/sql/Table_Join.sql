create table t_member(
mNo number primary key,
mId varchar2(30) not null,
mPw varchar2(30) not null,
mName varchar2(30) not null,
mZcode varchar2(7) not null,
mZaddr varchar2(100) not null,
mEmail varchar2(30) not null,
mBirth varchar2(6) not null,
mPhone varchar2(11) not null,
mMajor varchar2(10) not null,
mGroup varchar2(10) not null
);

