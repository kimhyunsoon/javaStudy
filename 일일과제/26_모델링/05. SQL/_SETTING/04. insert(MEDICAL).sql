--MEDICAL
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '����', 'd0001', 'd01', null);
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0002', 'd02', 't02');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0003', 'd03', 't02');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '����', 'd0004', 'd04', null);
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0005', 'd11', 't04');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0006', 'd12', 't08');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0007', 'd21', 't07');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0008', 'd22', 't07');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '����', 'd0009', 'd31', null);
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), 'ġ��', 'd0010', 'd41', 't03');

select * from MEDICAL;	--'MEDICAL' ���̺��� ������ Ȯ��
select * from BILL;	--trigger�� ������ 'BILL' ���̺��� ������ Ȯ��