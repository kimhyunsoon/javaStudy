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

insert into BOARD values(BOARD_SEQ.nextval, '김명훈', 'kim@hanmail.net','제목1', '내용1', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '강정구', 'gang@hanmail.net','제목2', '내용2', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '박소연', 'back@hanmail.net','제목3', '내용3', SYSDATE);
insert into BOARD values(BOARD_SEQ.nextval, '최민규', 'choi@hanmail.net','제목4', '내용4', SYSDATE);

commit;

select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints where TABLE_NAME='BOARD';
select * from BOARD order by SEQ desc;

