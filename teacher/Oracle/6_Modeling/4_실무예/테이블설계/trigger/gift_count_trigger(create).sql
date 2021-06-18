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
