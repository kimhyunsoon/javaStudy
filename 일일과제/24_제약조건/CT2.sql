select TABLE_NAME from user_tables; --user�� ������ ���̺� �̸� Ȯ��

drop table CT_EMP;
drop table CT_DEPT;
purge recyclebin;

create table CT_DEPT(
    
    DEPTNO number(2) primary key, 
    DNAME varchar2(14) default '���ߺ�',
    LOC char(1) CHECK (LOC = '1' or loc = '2')

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_DEPT'; --�������� Ȯ��

create table CT_EMP(
  
  NO number(4) primary key,
  ENAME varchar2(10) not null,
  ADDR varchar2(6) CHECK (addr = '����' or addr = '�λ�'),
  JUMIN varchar2(13) unique,
  RDATE date default SYSDATE,
  DEPTNO NUMBER(2) references CT_DEPT(DEPTNO)

); 

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='CT_EMP'; --�������� Ȯ��

insert into CT_DEPT(DEPTNO, LOC) values(10, '1'); --������ ����

insert into CT_EMP(NO, ENAME, ADDR, JUMIN, DEPTNO) 
values(1000, '�̰���', '����', '8601012549874', 10); --������ ����


commit;

select * from CT_DEPT; --������ ���
select * from CT_EMP; --������ ���