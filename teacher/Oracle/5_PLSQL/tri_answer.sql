--Q1) trigger1:ȸ�������� �ϸ� 
     -- '�α��� ���̺�'�� ID/PWD�Է�, 
     -- 'Ȩ������ ���̺�'�� �������� ID/HNAME�� �ԷµǴ� Ʈ���� 
create or replace trigger MEM_INSERT
after
    insert on TR_MEMBER
    for each row 
begin
    insert into TR_LOGIN values(:new.ID, :new.PWD);
    insert into TR_MYHOME(SEQ, ID, HNAME) values(TR_MYHOME_SEQ.nextval, :new.ID, :new.NAME);
end;
/

insert into TR_MEMBER values('lee', '1234', '�̼���', 'lee@hanmail.net', SYSDATE);
select * from TR_LOGIN;
select SEQ, ID, HNAME from TR_MYHOME;


--Q2) trigger2:ȸ�����������.. �α� ���̺��� PWD�� �����Ǵ� Ʈ���� 
create or replace trigger MEM_UPDATE 
after
    update on TR_MEMBER
    for each row 
begin
    update TR_LOGIN set PWD=:new.PWD where ID=:new.ID;
end;
/

update TR_MEMBER set PWD='4321' where ID='lee';
select * from TR_LOGIN;