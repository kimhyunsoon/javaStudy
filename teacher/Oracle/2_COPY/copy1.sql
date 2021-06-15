--drop table EMP2;
--drop table DEPT2;

create table DEPT2(
    DEPTNO NUMBER(2) constraint DEPT2_PK primary key, 
    DNAME VARCHAR2(14), 
    LOC VARCHAR2(13)
);

create table EMP2(
    EMP NUMBER(4) constraint DEPT2_PK primary key,
    ENAME VARCHAR2(10), 
    JOB VARCHAR2(9)
    MGR NUMBER(4)
    HIREDATE DATE
    SAL NUMBER(7,2)
    COMM NUMBER(7,2)
    DEPTNO NUMBER(2)	
);