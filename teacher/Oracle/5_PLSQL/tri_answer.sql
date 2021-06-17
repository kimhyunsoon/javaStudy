--Q1) trigger1:회원가입을 하면 
     -- '로그인 테이블'에 ID/PWD입력, 
     -- '홈페이지 테이블'에 시퀀스와 ID/HNAME에 입력되는 트리거 
create or replace trigger MEM_INSERT
after
    insert on TR_MEMBER
    for each row 
begin
    insert into TR_LOGIN values(:new.ID, :new.PWD);
    insert into TR_MYHOME(SEQ, ID, HNAME) values(TR_MYHOME_SEQ.nextval, :new.ID, :new.NAME);
end;
/

insert into TR_MEMBER values('lee', '1234', '이순신', 'lee@hanmail.net', SYSDATE);
select * from TR_LOGIN;
select SEQ, ID, HNAME from TR_MYHOME;


--Q2) trigger2:회원비번수정시.. 로긴 테이블의 PWD도 수정되는 트리거 
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