load data
infile 'c:/zipcode.csv'
insert 
into table zipcode
fields terminated by ","
trailing nullcols
(zipcode,
sido,
gugun,
dong,
ri,
bunji,
seq)