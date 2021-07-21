--alter session set "_oracle_script"=true;
--create user servlet identified by java;
--grant connect, resource, unlimited tablespace to servlet;
--conn servlet/java;


drop table BOARD;
drop sequence BOARD_SEQ;
purge recyclebin;

create table BOARD(
   SEQ number constraint BOARD_PK primary key, 
   WRITER varchar2(12), 
   EMAIL varchar2(20),
   SUBJECT varchar2(20), 
   CONTENT varchar2(20), 
   RDATE date default SYSDATE
); 
create sequence BOARD_SEQ increment by 1 start with 1 nocache;

insert into BOARD values(BOARD_SEQ.nextval, '�����', 'kim@hanmail.net','����1', '����1', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '������', 'gang@hanmail.net','����2', '����2', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ڼҿ�', 'back@hanmail.net','����3', '����3', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '�ֹα�', 'choi@hanmail.net','����4', '����4', SYSDATE);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;

