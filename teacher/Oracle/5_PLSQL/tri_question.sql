drop table TR_MYHOME;
drop table TR_LOGIN;
drop table TR_MEMBER;
drop sequence TR_MYHOME_SEQ;
purge recyclebin;

-- ȸ�� 
create table TR_MEMBER(
    ID varchar2(10) constraint TR_MEMBER_PK primary key, 
    PWD varchar2(10) constraint TR_MEMBER_PWD_NN not null, 
    NAME varchar2(20) constraint TR_MEMBER_NAME_NN not null, 
    EMAIL varchar2(20) constraint TR_MEMBER_UQ unique, 
    RDATE date default SYSDATE
);
-- �α��� 
create table TR_LOGIN(
    ID varchar2(10), 
    PWD varchar2(10), 
    constraint TR_LOGIN_PK primary key(ID), 
    constraint TR_LOGIN_FK foreign key(ID) references TR_MEMBER(ID) on delete cascade
);
-- Ȩ������ 
create table TR_MYHOME(
    SEQ number constraint TR_MYHOME_PK primary key, 
    ID varchar2(10) constraint TR_MYHOME_ID_NN not null, 
    HNAME varchar2(20) constraint TR_MYHOME_HNAME_NN not null, 
    TOTCOUNT number default 0, 
    HMSG varchar2(15), 
    CDATE date default SYSDATE, 
    constraint TR_MYHOME_FK foreign key(ID) references TR_MEMBER(ID) on delete cascade
);
create sequence TR_MYHOME_SEQ start with 1 increment by 1 nocache;

select TNAME from tab;
select SEQUENCE_NAME from seq;
--select TR_MYHOME_SEQ.nextval from DUAL;


--Q1) tigger1:ȸ�������� �ϸ� 
     -- '�α��� ���̺�'�� ID/PWD�Է�, 
     -- 'Ȩ������ ���̺�'�� �������� ID/HNAME�� �ԷµǴ� Ʈ���� 
             
