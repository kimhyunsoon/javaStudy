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