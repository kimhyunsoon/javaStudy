select * from EMP2;
select * from DEPT2;

create or replace procedure INCRE(n in EMP2.EMPNO%TYPE, r in NUMBER) -- �μ��� �ִ� ���ν���
--%TYPE ���� ���̺��� Į���� ����� ������Ÿ�԰� ũ�⸦ �����Ͽ� ������ ����
--������  ���̺��.Į����%TYPE
is 
    newPay number; --���ν��� ������ ����� ���� ����
begin --��� ����
    select SAL into newPay from EMP2 where EMPNO=n; --SAL�� newPay ������ �Ҵ�, EMPNO�� n�϶�
    newPay := newPay + newPay*r; -- := ����Ŭ���� ���Կ�����
    update EMP2 set SAL=newPay where EMPNO=n; --����
    commit;
end;
/
call INCRE(7369, 0.1);
exec INCRE(7369, 0.1);
select SAL from EMP2 where ENAME = 'SMITH';

create table EMP_TRI(
  EMPNO number(4) primary key,
  ENAME varchar2(10),
  SAL number(7,2)
);  

create or replace trigger TRI_SAL
after
  insert on EMP_TRI
begin 
  update EMP_TRI set SAL=2000;
end;
/
update EMP_TRI set SAL=2000 where EMPNO=8000;

select * from EMP_TRI;


select * from TR_MEMBER;
select * from TR_LOGIN;
select * from TR_MYHOME;

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

select * from TR_MYHOME;