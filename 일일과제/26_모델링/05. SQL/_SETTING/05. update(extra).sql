--MOM
select * from MOM;
update MOM set M_PHONE = '010-4568-3675' where M_NAME = 'm0001'; --MOM 휴대폰번호 업데이트
update MOM set M_ADDR = '서울특별시 강남구 테헤란로33길 2' where M_NAME = 'm0001'; --MOM 주소 업데이트

--DOGCARD
select * from DOGCARD;
update DOGCARD set D_NAME = '동동이' where D_NUMBER = 'd0001'; --강쥐 이름
update DOGCARD set D_KINDS = '파이어 불독' where D_NUMBER = 'd0001'; --견종
update DOGCARD set D_AGE = '23' where D_NUMBER = 'd0001'; --강쥐 나이
update DOGCARD set D_WEIGHT = '8.13' where D_NUMBER = 'd0001'; --강쥐 몸무게

--EMP
select * from EMP;
update EMP set E_NAME = '이동연' where E_NUMBER = 'e0001'; --사원이름
update EMP set E_PHONE = '010-9670-0367' where E_NUMBER = 'e0001'; --사원폰번
update EMP set E_NAME = '26' where E_NUMBER = 'e0001'; --사원나이
update EMP set E_SAL = 5000 where E_NUMBER = 'e0001'; --사원급여

--TREAT
--desc treat;
select * from TREAT;
update TREAT set T_COST ='123456' where T_CODE ='t01'; --치료금액

--HOSPITAL
--desc hospital;
select * from HOSPITAL;
update HOSPITAL set H_MGR = '김동연' where H_CODE = 'h01';

commit;
