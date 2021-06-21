--MEDICAL
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '진단', 'd0001', 'd01', null);
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0002', 'd02', 't02');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0003', 'd03', 't02');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '진단', 'd0004', 'd04', null);
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0005', 'd11', 't04');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0006', 'd12', 't08');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0007', 'd21', 't07');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0008', 'd22', 't07');
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '진단', 'd0009', 'd31', null);
insert into MEDICAL values((to_char(SYSDATE,'yymmddhhmiss')), '치료', 'd0010', 'd41', 't03');

select * from MEDICAL;	--'MEDICAL' 테이블의 데이터 확인
select * from BILL;	--trigger로 생성된 'BILL' 테이블의 데이터 확인