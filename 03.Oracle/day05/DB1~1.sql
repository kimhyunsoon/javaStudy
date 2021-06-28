select * from tab;
desc DDLTEST;
select CONSTRAINT_NAME, TABLE_NAME from user_constraints 
where TABLE_NAME='DDLTEST';
alter table DDLTEST add(ADDR varchar2(20));
insert into DDLTEST values(2000, 'scott', 'tiger', 'seoul');
select * from DDLTEST;
alter table DDLTEST drop column ADDR;
alter table DDLTEST modify(ID varchar2(15), PWD varchar2(15));
alter table DDLTEST rename column PWD to PASS;
alter table DDLTEST drop constraint DDLTEST_PK;
desc DDLTEST
select CONSTRAINT_NAME, TABLE_NAME from user_constraints 
				where TABLE_NAME='DDLTEST';
drop table DDLTEST;        
select * from tab;
purge recyclebin;
purge recyclebin;
desc user_tables
select TABLE_NAME from user_tables;
desc user_indexes
select INDEX_NAME, INDEX_TYPE, TABLE_NAME from user_indexes;
desc user_constraints
select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints;
select VIEW_NAME, TEXT from user_views;
