select * from EMP2;
select * from DEPT2;

create or replace procedure INCRE(n in EMP2.EMPNO%TYPE, r in NUMBER) -- 인수가 있는 프로시저
--%TYPE 기존 테이블의 칼럼에 선언된 데이터타입과 크기를 참조하여 변수를 선언
--변수명  테이블명.칼럼명%TYPE
is 
    newPay number; --프로시저 내에서 사용할 변수 선언
begin --기능 구현
    select SAL into newPay from EMP2 where EMPNO=n; --SAL을 newPay 변수에 할당, EMPNO가 n일때
    newPay := newPay + newPay*r; -- := 오라클에서 대입연산자
    update EMP2 set SAL=newPay where EMPNO=n; --수정
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