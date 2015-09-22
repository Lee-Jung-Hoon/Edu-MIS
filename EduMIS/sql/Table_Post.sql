create table zipcode (
seq        number(5,0) not null,
zipcode  varchar2(7) not null,
sido       varchar2(6) not null,
gugun    varchar2(30) not null,
dong      varchar2(50) not null,
ri           varchar2(80),
bunji      varchar2(20),
constraint  zipcode_pk  primary key(seq) )