create or replace procedure INCRE2(n in EMP2.EMPNO%TYPE, r in NUMBER)
is 
    newPay number;
begin 
    select SAL into newPay from EMP2 where EMPNO=n;
    newPay := newPay + newPay*r/100;
    update EMP2 set SAL=newPay where EMPNO=n;
    commit;
end;
/

-- call INCRE2(7902, 20);