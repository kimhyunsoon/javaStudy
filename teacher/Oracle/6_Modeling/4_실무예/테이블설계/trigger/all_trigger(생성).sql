create or replace trigger atri_humember_ins
after
insert on hu_member
for each row  
begin
	 /*login table ...*/
	 insert into hu_login
	 values(:new.lid, :new.pwd);  

	 insert into hu_login_user (lid)
	 values(:new.lid);

	 /* group table ... */
	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'friend', '일촌', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'music', '기본음악', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'photo', '기본사진', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'bbs', '기본게시판', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'profile', '기본프로필', 'y', sysdate);

	/* mini home ...*/
	 insert into hu_myhome(idx, lid, hname, hmsg, haddr ,totcount, scrapcount, giftcount, idate)
	 values(humyhome_seq.nextval, :new.lid, :new.name || '님의 홈피입니다.', '내용을 입력해주세요', :new.lid, 0, 0, 0, sysdate );
	
	/* menu table ..*/
	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '홈', 'home', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '프로필', 'profile', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '쥬크박스', 'music', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '사진첩', 'photo', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '게시판', 'bbs', 0, sysdate);
	 
	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '방명록', 'guest', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '관리', 'manager', 0, sysdate);

end;
/

create or replace trigger atri_humember_upd
after
update of lid,pwd on hu_member  
for each row
begin
	 update hu_login 
	 set lid = :new.lid, pwd = :new.pwd
	 where lid = :old.lid;
end;
/


create or replace trigger atri_myhomescrap_ins
before
insert on hu_bbs
for each row

declare 
lid varchar2(15); 
oidx number := :new.oriidx;

begin
	if oidx != 0 then
		select melid into lid from hu_bbs where idx = :new.oriidx;

		update hu_myhome set scrapcount = scrapcount+1
		where lid = lid;

		update hu_bbs set scrapcount = scrapcount+1
		where idx = :new.oriidx;
	end if;
end;
/





create or replace trigger atri_myhometotcount_ins
after
insert on hu_today
for each row
begin
	/*tot up*/
	update hu_myhome set totcount = totcount+1
	where lid = :new.lid;
end;
/

create or replace trigger atri_myhometotcount_ups
after
update of lid on hu_today
for each row
begin
	/*tot up*/
	update hu_myhome set totcount = totcount+1
	where lid = :old.lid;
end;
/

create or replace trigger atri_myhomegiftcount_ins
after
insert on hu_gift
for each row
begin
	/*gift_count up*/
	update hu_myhome set giftcount = giftcount+1
	where lid = :new.receiveid;
end;
/
