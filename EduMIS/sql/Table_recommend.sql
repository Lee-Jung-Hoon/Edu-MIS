--vote DB --
create table t_recommend(
no number not null primary key,
MID varchar2(30) not null,
VNAME varchar2(30) not null,
VCOUNT number
);