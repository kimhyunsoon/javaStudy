 --ġ����� ���������� ġ���ڵ�� �����ȣ Ȯ��
select MD_DATE, T_CODE from MEDICAL where MD_SEC='ġ��';

--''�� �������� ġ��� ������Ʈ
update BILL set B_TCOST=(select T_COST from TREAT where T_CODE ='t08') 
where MD_DATE='210621114848';

select * from BILL;

