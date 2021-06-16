drop table EMP2;
drop table DEPT2;

purge recyclebin;

create table DEPT2(
    DEPTNO NUMBER(2) constraint DEPT2_PK primary key, 
    DNAME VARCHAR2(14), 
    LOC VARCHAR2(13)
);

create table EMP2(
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



insert into DEPT2 select * from DEPT;
insert into EMP2 select * from EMP;

commit;

-- 1) 테이블 구조 확인 
desc DEPT2
desc EMP2

-- 2) 테이블 데이터 확인
select * from DEPT2;
select * from EMP2;

-- 3) 제약조건확인 
select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='DEPT2' or TABLE_NAME='EMP2';