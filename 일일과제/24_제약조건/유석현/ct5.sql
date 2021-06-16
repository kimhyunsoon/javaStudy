drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    DEPTNO number(2), 
    DNAME varchar2(14) default '개발부',
    LOC char(1)
);
alter table CT_DEPT add primary key (DEPTNO);
alter table CT_DEPT add constraint LOC_CHECK check (LOC in(1,2));
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

create table CT_EMP(
    NO number(4),
    NAME varchar2(10),
    ADDR varchar2(6),
    JUMIN varchar2(13),
    RDATE date default SYSDATE,
    DEPTNO number(2)
);
alter table CT_EMP add primary key (NO);
alter table CT_EMP MODIFY NAME NOT NULL;
alter table CT_EMP add constraint ADDR_CHECK check (ADDR in('서울','부산'));
alter table CT_EMP add constraint JUMIN_UNIQUE unique(JUMIN);
alter table CT_EMP add constraint DEPTNO_FK 
FOREIGN KEY(DEPTNO) references CT_DEPT(DEPTNO) on delete cascade;

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';

insert into CT_DEPT(DEPTNO, LOC) values(10, '1');

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, '홍길동', '서울', '123456124567', 10);
insert into CONST_EMP
   values(2000, '이순신', '부산', '123456124568', SYSDATE, 10);

commit;

select * from CT_DEPT;
select * from CT_EMP;