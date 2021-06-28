create table DEPT2(
    DEPTNO NUMBER(2) constraint DEPT2_PK primary key, 
    DNAME VARCHAR2(14), 
    LOC VARCHAR2(13)
);
drop table dept2;
select tname from tab;
purge RECYCLEBIN;

drop table EMP3;
drop table DEPT3;

purge recyclebin;

create table DEPT2 as select * from DEPT;
create table EMP2 as select * from EMP;

alter table DEPT2 add constraint DEPT2_PK primary key(DEPTNO);
alter table EMP2 add constraint EMP2_PK primary key(EMPNO);
alter table EMP2 add constraint EMP2_FK foreign key(DEPTNO) references DEPT2(DEPTNO) on delete cascade;

desc DEPT2;
desc EMP2;
select tname from tab;

select * from DEPT2;
select * from EMP2;

select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='DEPT2' or TABLE_NAME='EMP2';
insert into dept2 VALUES(50, 'DEVELOP', 'SEOUL');
select * from DEPT2;
delete from DEPT2 where DEPTNO=90;
