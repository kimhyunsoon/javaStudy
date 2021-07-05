create or replace trigger BILL_INSERT
after
   insert on MEDICAL
   for each row
begin 
   insert into BILL (MD_DATE,B_VCOST) values (:new.MD_DATE,default);
end;
/

select trigger_name from user_triggers where trigger_name = 'BILL_INSERT';
--insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'Ä¡·á', 'd0002', 'd22', 't06');
--drop trigger BILL_INSERT;