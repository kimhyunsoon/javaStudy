create table CT_DEPT (
  DEPTNO NUMBER(2) constraint CT_DEPT_PK primary key, 
  DNAME VARCHAR2(14) default '개발부',
  LOC CHAR(1) constraint CT_DEPT_CK CHECK (LOC = '1' and loc = '2')
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; --제약조건 확인




create table CT_EMP(
  NO number(4) constraint CT_EMP_PK primary key,
  ENAME varchar2(10) constraint CT_EMP_NN not null,
  ADDR varchar2(6) constraint CT_EMP_CK CHECK (addr = '서울' or addr = '부산'),
  JUMIN varchar2(13) constraint CT_EMP_UK unique,
  RDATE date default SYSDATE,
  DEPTNO NUMBER(2),
  constraint CT_EMP_FK foreign key(DEPTNO) references CT_DEPT(DEPTNO)
); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';