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
update on hu_today
for each row
begin
	/*tot up*/
	update hu_myhome set totcount = totcount+1
	where lid = :old.lid;
end;
/