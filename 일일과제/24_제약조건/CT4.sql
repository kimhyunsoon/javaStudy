select TABLE_NAME from user_tables; --user가 생성한 테이블 이름 확인

drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1),

    primary key(DEPTNO),
    CHECK (LOC = '1' or loc = '2')

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; --제약조건 확인

create table CT_EMP(

    NO number(4),
    ENAME varchar2(10) not null,
    ADDR varchar2(6),
    JUMIN varchar2(13),
    RDATE date default SYSDATE,
    DEPTNO NUMBER(2),

    primary key (NO),
    CHECK (addr = '서울' or addr = '부산'),
    unique (JUMIN),
    foreign key(DEPTNO) references CT_DEPT(DEPTNO)

); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP'; --제약조건 확인

insert into CT_DEPT(DEPTNO, LOC) values(10, '1'); --데이터 삽입

insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10); --데이터 삽입


commit;

select * from CT_DEPT; --데이터 출력
select * from CT_EMP; --데이터 출력