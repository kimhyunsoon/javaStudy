--Q1) trigger1:회원가입을 하면 
     -- '로그인 테이블'에 ID/PWD입력, 
     -- '홈페이지 테이블'에 시퀀스와 ID/HNAME에 입력되는 트리거 

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


insert into TR_MEMBER values('kaeun', '1234', '깐따', 'kaeun@naver.com', SYSDATE);

--Q2) trigger2:회원 이름과 비밀번호 변경 시 
	--'로그인 테이블' 비밀번호 변경
	--'홈페이지 테이블' 이름 변경

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
update TR_MEMBER set NAME='가은' where ID='kaeun';