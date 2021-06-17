--Q1) trigger1:ȸ�������� �ϸ� 
     -- '�α��� ���̺�'�� ID/PWD�Է�, 
     -- 'Ȩ������ ���̺�'�� �������� ID/HNAME�� �ԷµǴ� Ʈ���� 

create or replace trigger MEMBER_INSERT
after
   insert on TR_MEMBER
   for each row
begin 
   insert into TR_LOGIN values (:new.ID, :new.PWD);
   insert into TR_MYHOME(SEQ, ID, HNAME, CDATE) 
   values (TR_MYHOME_SEQ.nextval, :new.ID, :new.NAME, :new.RDATE);
end;
/


insert into TR_MEMBER values('kaeun', '1234', '���', 'kaeun@naver.com', SYSDATE);

--Q2) trigger2:ȸ�� �̸��� ��й�ȣ ���� �� 
	--'�α��� ���̺�' ��й�ȣ ����
	--'Ȩ������ ���̺�' �̸� ����

create or replace trigger MEMBER_UPDATE
after
   update on TR_MEMBER
   for each row
begin
   update TR_LOGIN set PWD=:new.PWD where ID=:new.ID;
   update TR_MYHOME set HNAME=:new.NAME where ID=:new.ID;

end;
/
   
update TR_MEMBER set PWD='4321' where ID='kaeun';
update TR_MEMBER set NAME='����' where ID='kaeun';