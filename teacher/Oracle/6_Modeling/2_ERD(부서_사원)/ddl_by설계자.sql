drop table EMP;
drop table DEPT;
purge recyclebin;

create table DEPT(
    DEPTNO NUMBER(2) constraint DEPT2_PK primary key, 
    DNAME VARCHAR2(14), 
    LOC VARCHAR2(13)
);

create table EMP(
    EMPNO NUMBER(4) constraint EMP2_PK primary key,
    ENAME VARCHAR2(10), 
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2)	
);
alter table EMP2 add constraint EMP2_FK foreign key(DEPTNO) references DEPT2(DEPTNO) on delete cascade;