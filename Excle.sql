create table personnel (
id varchar(20) primary key, 
name varchar(20), 
sex varchar(6), 
education varchar(20), 
wages int
);
select * from personnel;
select * from personnel into outfile 'd:f.xls' character set gbk;
