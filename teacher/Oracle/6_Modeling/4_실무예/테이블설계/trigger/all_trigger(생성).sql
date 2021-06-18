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
	 values(hugroup_seq.nextval, :new.lid, 'friend', '����', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'music', '�⺻����', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'photo', '�⺻����', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'bbs', '�⺻�Խ���', 'y', sysdate);

	 insert into hu_group(idx, lid, gdiv, gname, df, idate)
	 values(hugroup_seq.nextval, :new.lid, 'profile', '�⺻������', 'y', sysdate);

	/* mini home ...*/
	 insert into hu_myhome(idx, lid, hname, hmsg, haddr ,totcount, scrapcount, giftcount, idate)
	 values(humyhome_seq.nextval, :new.lid, :new.name || '���� Ȩ���Դϴ�.', '������ �Է����ּ���', :new.lid, 0, 0, 0, sysdate );
	
	/* menu table ..*/
	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, 'Ȩ', 'home', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '������', 'profile', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '��ũ�ڽ�', 'music', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '����ø', 'photo', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '�Խ���', 'bbs', 0, sysdate);
	 
	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '����', 'guest', 0, sysdate);

	 insert into hu_menu(idx, lid, name, div, huse, idate)
	 values(humenu_seq.nextval, :new.lid, '����', 'manager', 0, sysdate);

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
