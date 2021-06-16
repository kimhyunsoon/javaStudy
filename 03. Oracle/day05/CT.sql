select TABLE_NAME from user_tables;
create table CT_DEPT(
    DEPTNO number(2)constraint CT_DEPT_PK primary key, 
    DNAME varchar2(14) default '개발부',
    LOC char(1) constraint CT_DEPT_CK CHECK (LOC = '1' or loc = '2')
);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

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

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');

select * from CT_DEPT;
insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10);
select * from CT_EMP;

commit;

drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;
select TABLE_NAME from user_tables; 
create table CT_DEPT(
    DEPTNO number(2) primary key, 
    DNAME varchar2(14) default '개발부',
    LOC char(1) CHECK (LOC = '1' or loc = '2')
);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';
create table CT_EMP(
  NO number(4) primary key,
  ENAME varchar2(10) not null,
  ADDR varchar2(6) CHECK (addr = '서울' or addr = '부산'),
  JUMIN varchar2(13) unique,
  RDATE date default SYSDATE,
  DEPTNO NUMBER(2),
  constraint CT_EMP_FK references CT_DEPT(DEPTNO)
); 

create table CT_EMP(
  NO number(4) primary key,
  ENAME varchar2(10) not null,
  ADDR varchar2(6) CHECK (addr = '서울' or addr = '부산'),
  JUMIN varchar2(13) unique,
  RDATE date default SYSDATE,
  DEPTNO NUMBER(2) references CT_DEPT(DEPTNO)
); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP'; --제약조건 확인

drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;
select TABLE_NAME from user_tables;

create table CT_DEPT(
    
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1),

    constraint CT_DEPT_PK primary key(DEPTNO),
    constraint CT_DEPT_CK CHECK (LOC = '1' or loc = '2')

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; --제약조건 확인

create table CT_EMP(

    NO number(4),
    ENAME varchar2(10) constraint CT_EMP_NN not null,
    ADDR varchar2(6),
    JUMIN varchar2(13),
    RDATE date default SYSDATE,
    DEPTNO NUMBER(2),
    constraint CT_EMP_PK primary key (NO),
    constraint CT_EMP_CK CHECK (addr = '서울' or addr = '부산'),
    constraint CT_EMP_UK unique (JUMIN),
    constraint CT_EMP_FK foreign key(DEPTNO) references CT_DEPT(DEPTNO)

); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';

drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;
select TABLE_NAME from user_tables;

create table CT_DEPT(
    
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1),

    primary key(DEPTNO),
    CHECK (LOC = '1' or loc = '2')

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

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
where table_name='CT_EMP';

drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;
select TABLE_NAME from user_tables;

create table CT_DEPT(
    DEPTNO number(2) constraint CT_DEPT_PK primary key, 
    DNAME varchar2(14) default '개발부',
    LOC char(1) constraint CT_DEPT_CK CHECK (LOC = '1' or loc = '2')
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

create table CT_EMP(

  NO number(4) constraint CT_EMP_PK primary key,
  ENAME varchar2(10) constraint CT_EMP_NN not null,
  ADDR varchar2(6) constraint CT_EMP_CK CHECK (addr = '서울' or addr = '부산'),
  JUMIN varchar2(13) constraint CT_EMP_UK unique,
  RDATE date default SYSDATE,
  DEPTNO NUMBER(2) constraint CT_EMP_FK references CT_DEPT(DEPTNO)

); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';
insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10); 
select * from CT_DEPT;
select * from CT_EMP;

create table CT_DEPT(
    DEPTNO number(2) primary key, 
    DNAME varchar2(14) default '개발부',
    LOC char(1) CHECK (LOC = '1' or loc = '2')
);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; 

create table CT_EMP(
  NO number(4) primary key,
  ENAME varchar2(10) not null,
  ADDR varchar2(6) CHECK (addr = '서울' or addr = '부산'),
  JUMIN varchar2(13) unique,
  RDATE date default SYSDATE,
  DEPTNO NUMBER(2) references CT_DEPT(DEPTNO)
); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';
insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10);

create table CT_DEPT(
    
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1),

    constraint CT_DEPT_PK primary key(DEPTNO),
    constraint CT_DEPT_CK CHECK (LOC = '1' or loc = '2')

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; 

create table CT_EMP(

    NO number(4),
    ENAME varchar2(10) constraint CT_EMP_NN not null,
    ADDR varchar2(6),
    JUMIN varchar2(13),
    RDATE date default SYSDATE,
    DEPTNO NUMBER(2),
    constraint CT_EMP_PK primary key (NO),
    constraint CT_EMP_CK CHECK (addr = '서울' or addr = '부산'),
    constraint CT_EMP_UK unique (JUMIN),
    constraint CT_EMP_FK foreign key(DEPTNO) references CT_DEPT(DEPTNO)

); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';
insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10); 
select * from CT_DEPT; --데이터 출력
select * from CT_EMP;


create table CT_DEPT(
    
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1),

    primary key(DEPTNO),
    CHECK (LOC = '1' or loc = '2')

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

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
where table_name='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1'); 
insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10);

create table CT_DEPT(
    
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1)
);

alter table CT_DEPT add constraint CT_DEPT_PK primary key(DEPTNO); 
alter table CT_DEPT add constraint CT_DEPT_CK CHECK (LOC = '1' or loc = '2');
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; 

create table CT_EMP(

    NO number(4),
    ENAME varchar2(10) constraint CT_EMP_NN not null,
    ADDR varchar2(6),
    JUMIN varchar2(13),
    RDATE date default SYSDATE,
    DEPTNO NUMBER(2)
); 

alter table CT_EMP add constraint CT_EMP_PK primary key (NO);
alter table CT_EMP add constraint CT_EMP_CK CHECK (addr = '서울' or addr = '부산');
alter table CT_EMP add constraint CT_EMP_UK unique (JUMIN);
alter table CT_EMP add constraint CT_EMP_FK foreign key(DEPTNO) references CT_DEPT(DEPTNO);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP'; 

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');
insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '이가은', '서울', '8601012549874', 10);
select * from CT_DEPT; --데이터 출력
select * from CT_EMP;