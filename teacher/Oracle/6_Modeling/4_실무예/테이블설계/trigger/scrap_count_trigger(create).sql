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
