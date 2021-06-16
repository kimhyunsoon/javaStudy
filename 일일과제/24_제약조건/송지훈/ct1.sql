drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;
create table CT_DEPT(
    DEPTNO number(2), -- primary key 조건 
    DNAME varchar2(14),
    LOC char(1) -- check 조건: '1' 이나 '2' 
);

alter table CT_DEPT add primary key(DEPTNO);
alter table CT_DEPT add check (LOC=1 or LOC=2 );
alter table CT_DEPT modify(DNAME default '개발부');

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

create table CT_EMP(
    NO number(4), -- primary key 조건
    NAME varchar2(10) , -- not null 조건 
    ADDR varchar2(6), -- check 조건: '서울' or '부산'
    JUMIN varchar2(13) , -- unique 
    RDATE date , -- default 현재날짜
    DEPTNO number(2)  -- foreign key 조건
);

alter table CT_EMP add primary key(NO);
alter table CT_EMP modify(NAME not null);
alter table CT_EMP add check (ADDR='서울' or ADDR='부산' );
alter table CT_EMP add unique(JUMIN);
alter table CT_EMP modify(RDATE default sysdate);
alter table CT_EMP add foreign key (DEPTNO) REFERENCES CT_DEPT(DEPTNO);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, 2);
insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, '홍길동', '서울', '123456124567', 10);
insert into CT_EMP
   values(2000, '이순신', '부산', '123456124568', SYSDATE, 10);

commit;

select * from CT_DEPT;
select * from CT_EMP;
