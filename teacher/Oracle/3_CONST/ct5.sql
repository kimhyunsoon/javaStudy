drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    DEPTNO number(2), -- primary key ���� 
    DNAME varchar2(14) default '���ߺ�',
    LOC char(1) -- check ����: '1' �̳� '2' 
);
alter table CT_DEPT add constraint CT_DEPT_PK primary key(DEPTNO);
alter table CT_DEPT add constraint CT_DEPT_CK check(LOC in('1','2'));
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT';

create table CT_EMP(
    NO number(4), -- primary key ����
    NAME varchar2(10), -- not null ���� 
    ADDR varchar2(6), -- check ����: '����' or '�λ�'
    JUMIN varchar2(13), -- unique 
    RDATE date, -- default ���糯¥
    DEPTNO number(2) -- foreign key ����
);
alter table CT_EMP add constraint CT_EMP_PK primary key(NO);
alter table CT_EMP add constraint CT_EMP_CK check(ADDR in('����','�λ�'));
alter table CT_EMP add constraint CT_EMP_UQ unique(JUMIN);
alter table CT_EMP add constraint CT_EMP_FK foreign key(DEPTNO) references CT_DEPT(DEPTNO);
select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP';


insert into CT_DEPT(DEPTNO, LOC) values(10, '1');

insert into CT_EMP(NO, NAME, ADDR, JUMIN, DEPTNO) 
   values(1000, 'ȫ�浿', '����', '123456124567', 10);
insert into CT_EMP
   values(2000, '�̼���', '�λ�', '123456124568', SYSDATE, 10);

commit;

select * from CT_DEPT;
select * from CT_EMP;