--MOM
select * from MOM;
update MOM set M_PHONE = '010-4568-3675' where M_NAME = 'm0001'; --MOM �޴�����ȣ ������Ʈ
update MOM set M_ADDR = '����Ư���� ������ �������33�� 2' where M_NAME = 'm0001'; --MOM �ּ� ������Ʈ

--DOGCARD
select * from DOGCARD;
update DOGCARD set D_NAME = '������' where D_NUMBER = 'd0001'; --���� �̸�
update DOGCARD set D_KINDS = '���̾� �ҵ�' where D_NUMBER = 'd0001'; --����
update DOGCARD set D_AGE = '23' where D_NUMBER = 'd0001'; --���� ����
update DOGCARD set D_WEIGHT = '8.13' where D_NUMBER = 'd0001'; --���� ������

--EMP
select * from EMP;
update EMP set E_NAME = '�̵���' where E_NUMBER = 'e0001'; --����̸�
update EMP set E_PHONE = '010-9670-0367' where E_NUMBER = 'e0001'; --�������
update EMP set E_NAME = '26' where E_NUMBER = 'e0001'; --�������
update EMP set E_SAL = 5000 where E_NUMBER = 'e0001'; --����޿�

--TREAT
--desc treat;
select * from TREAT;
update TREAT set T_COST ='123456' where T_CODE ='t01'; --ġ��ݾ�

--HOSPITAL
--desc hospital;
select * from HOSPITAL;
update HOSPITAL set H_MGR = '�赿��' where H_CODE = 'h01';

commit;
