drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    DEPTNO number(2)constraint CT_DEPT_PK primary key, -- primary key 조건 
    DNAME varchar2(14) default '개발부',
    LOC char(1)constraint CT_DEPT_CHK check (LOC=1 or LOC=2) -- check 조건: '1' 이나 '2' 
);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

create table CT_EMP(
    NO number(4) constraint CT_EMP_PK primary key, -- primary key 조건
    NAME varchar2(10) constraint 난널 not null, -- not null 조건 
    ADDR varchar2(6)constraint CT_EMP_CHK check (ADDR='서울' or ADDR='부산'), -- check 조건: '서울' or '부산'
    JUMIN varchar2(13)constraint CT_EMP_유닠 unique, -- unique 
    RDATE date default sysdate, -- default 현재날짜
    DEPTNO number(2)constraint CT_EMP_FK REFERENCES CT_DEPT(DEPTNO) -- foreign key 조건
);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';


insert into CT_DEPT(DEPTNO, LOC) values(10, '1');

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, '홍길동', '서울', '123456124567', 10);
insert into CT_EMP
   values(2000, '이순신', '부산', '123456124568', SYSDATE, 10);

commit;

select * from CT_DEPT;
select * from CT_EMP;
