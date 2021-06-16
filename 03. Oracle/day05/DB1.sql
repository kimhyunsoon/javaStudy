show user
create table DEPT3 as select * from DEPT;
create table DEPT2 as select * from DEPT;
create table EMP2 as select * from EMP;
alter table DEPT2 add constraint DEPT2_PK primary key(DEPTNO);
alter table EMP2 add constraint EMP2_PK primary key(EMPNO);
alter table EMP2 add constraint EMP2_FK foreign key(DEPTNO) references DEPT2(DEPTNO) 
on delete cascade;
desc DEPT2
desc EMP2
select * from DEPT2;
select * from EMP2;
select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints 
where TABLE_NAME='DEPT2' or TABLE_NAME='EMP2';
insert into DEPT2 values(50, 'DEVELOPMENT', 'SEOUL');
select * from DEPT2;
insert into EMP2 values(8000, 'KAEUN', 'DEVELOPER', 7839, SYSDATE, 5000, null, 50);
insert into EMP2 values(8000, 'KAEUN', 'DEVELOPER', 7839, SYSDATE, 5000, null, 50);
select * from EMP2;
insert into EMP2(EMPNO, ENAME, SAL, HIREDATE) values(8000, '이가은', 6000, SYSDATE);
insert into EMP2(ENAME, SAL, HIREDATE) values('곽치영', 6000, SYSDATE);
insert into EMP2(EMPNO, ENAME, SAL, HIREDATE) values(9000, '이가은', 6000, SYSDATE);
update EMP2 set ENAME='KAEUN', SAL=4500 where EMPNO=8000;
update EMP2 set EMPNO=8001, JOB='DESIGNER', MGR=7839, SAL=3500, DEPTNO=40 where EMPNO=9000;
update EMP2 set EMPNO=8001 where EMPNO=8000;
delete from DEPT2 where DEPTNO=30; 
roll back;
insert into EMP2 values(8000, 'KAEUN', 'DEVELOPER', 7839, SYSDATE, 5000, null, 50);
commit;
delete from EMP2 where EMPNO=(select EMPNO from EMP2 where ENAME='JONES');
roll back
select EMPNO from EMP2 where ENAME='JONES';
drop table DEPT2 cascade constraint;
roll back
insert into DEPT2 value (50, 'DEVELOPMENT', 'SEOUL');
insert into DEPT2 values(50, 'DEVELOPMENT', 'SEOUL');
create table DDLTEST(
	NO number(4) constraint DDLTEST_PK primary key,-- number(4): -9999~9999 
	ID varchar2(12), 
	PWD varchar2(12)
);
select * from tab;
drop table DEPT3;
purge recyclebin;
desc DDLTEST;




