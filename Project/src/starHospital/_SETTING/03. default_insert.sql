--MOM
insert into MOM values	 ('m0001', '010-2251-4546', '������', '����Ư���� ��õ�� ���������1�� 5');
insert into MOM values	 ('m0002', '010-4115-4563', '�����', '����Ư���� ��õ�� ���������2�� 10');
insert into MOM values	 ('m0003', '010-5464-7787', '�����', '����Ư���� ��õ�� ���������2�� 5');
insert into MOM values	 ('m0004', '010-2800-2800', '�̰���', '����Ư���� ���Ǳ� �Ÿ��� 000');
insert into MOM values	 ('m0005', '010-8784-5452', '��ڻ�', '����Ư���� ��õ�� ���������2�� 331');
insert into MOM values	 ('m0006', '010-1112-2215', '������', '�λ걤���� �߱� �ʷ���� 1-4');
insert into MOM values	 ('m0007', '010-5487-5641', '�̺���', '����ϵ� ���ֽ� ������ ����õ���� 455');
insert into MOM values	 ('m0008', '010-8444-9444', '���ﰳ', '����ϵ� ���ֽ� �ϻ걸 ���ְ���3�� 67');
insert into MOM values	 ('m0009', '010-7111-7222', '�����', '����Ư���� ���ϱ� ����6�� 5');
insert into MOM values	 ('m0010', '010-8878-5541', '�鳪��', '����Ư���� ���α� �����27�� 7-3');

--DOGCARD
insert into DOGCARD values	('d0001', '����������', '��Ƽ��', 3,  3.5 , '����', SYSDATE, 'm0001');
insert into DOGCARD values	('d0002', '�Ƹ���'	, '������'	, 4, 10.6, '����'	, SYSDATE, 'm0002');
insert into DOGCARD values	('d0003', '����'	, '�����Ʈ', 1, 32.7, '����', SYSDATE, 'm0003');
insert into DOGCARD values	('d0004', '����'	, '����', 13, 5.8 , '����', SYSDATE, 'm0004');
insert into DOGCARD values	('d0005', '������'	, '�ҵ�'	, 2, 8.9 , '����'	, SYSDATE, 'm0005');
insert into DOGCARD values	('d0006', '�Ժ�'	, 'ġ�Ϳ�'	, 7, 3.1, '����', SYSDATE, 'm0006');
insert into DOGCARD values	('d0007', '�ٴ�'	, '�ڽ���Ʈ', 10, 7.1, '����', SYSDATE, 'm0007');
insert into DOGCARD values	('d0008', 'Ÿ��'	, '��� ��Ʈ����', 2	, 6.1, '����', SYSDATE, 'm0008');
insert into DOGCARD values	('d0009', '������'	, '��찳'	, 1, 22.1, '����', SYSDATE, 'm0009');
insert into DOGCARD values	('d0010', '�Ͼ���'	, '��������', 6, 32.1, '����', SYSDATE, 'm0010');
insert into DOGCARD values	('d0011', '�Ͼ���', '��������', 8, 31.1, '����', SYSDATE, 'm0010');

--DISEASE
insert into DISEASE values	('d01'	, '��ȭ����ȯ');
insert into DISEASE values	('d02'	, '��������');
insert into DISEASE values	('d03'	, '�ĺ����̷���');
insert into DISEASE values	('d04'	, '�����');
insert into DISEASE values	('d11'	, '������');
insert into DISEASE values	('d12'	, '���� �� ����');
insert into DISEASE values	('d21'	, '�Ǻκ�');
insert into DISEASE values	('d22'	, '�� ����');
insert into DISEASE values	('d31'	, '�汤��');
insert into DISEASE values	('d41'	, '�鳻��');

--TREAT
insert into TREAT values	('t01'	, '���� �˻�'	, 100000	, '��޿�');
insert into TREAT values	('t02'	, '��������'	, 700000	, '�޿�');
insert into TREAT values	('t03'	, '�Ȱ�����'	, 500000	, '�޿�');
insert into TREAT values	('t04'	, '�����ܰ�����'	, 100000	, '�޿�');
insert into TREAT values	('t05'	, '��������'	, 20000		, '��޿�');
insert into TREAT values	('t06'	, '�๰ �ֻ�'	, 30000		, '�޿�');
insert into TREAT values	('t07'	, '����'	, 	 15000		, '��޿�');
insert into TREAT values	('t08'	, '����ġ��'	, 35000		, '�޿�');
insert into TREAT values	('t09'	, '������ ġ��'	, 150000	, '�޿�');
insert into TREAT values	('t10'	, '�ѹ� ħ'	, 30000		, '��޿�');

--HOSPITAL
insert into HOSPITAL values	('h01'	, '�ǻ��'	, '������');
insert into HOSPITAL values	('h02'	, '��ȣ��'	, '�����ҳ�');
insert into HOSPITAL values	('h03'	, '�繫��'	, '������');

--EMP
insert into EMP values	('e0001', '���ȶ�'	, '010-3564-6545', SYSDATE, 35	, DEFAULT, 'h01');
insert into EMP values	('e0002', '���Ǽ�'	, '010-4574-4531', SYSDATE, 55	, DEFAULT, 'h01');
insert into EMP values	('e0003', 'JSON', '010-9941-6547', SYSDATE, 52	, DEFAULT, 'h01');
insert into EMP values	('e0004', '����'	, '010-5564-9951', SYSDATE, 22	, DEFAULT, 'h02');
insert into EMP values	('e0005', '���̻�'	, '010-3553-6844', SYSDATE, 28	, DEFAULT, 'h02');
insert into EMP values	('e0006', '�ſ���'	, '010-8615-6550', SYSDATE, 31	, DEFAULT, 'h02');
insert into EMP values	('e0007', '���ѳ�'	, '010-9518-1526', SYSDATE, 33	, DEFAULT, 'h02');
insert into EMP values	('e0008', '�迹��'	, '010-6518-1556', SYSDATE, 22	, DEFAULT, 'h03');
insert into EMP values	('e0009', '������'	, '010-6524-7778', SYSDATE, 58	, DEFAULT, 'h03');
insert into EMP values	('e0010', '���ѹ�'	, '010-4553-4551', SYSDATE, 40	, DEFAULT, 'h03');
insert into EMP values	('e0011', '������'	, '010-2475-7431', SYSDATE, 30	, DEFAULT, 'h01');
insert into EMP values	('e0012', '�����ҳ�', '010-2475-7432', SYSDATE, 30, DEFAULT, 'h02');
insert into EMP values	('e0013', '������'	, '010-2475-7433', SYSDATE, 30	, DEFAULT, 'h03');

commit;

select * from MOM;
select * from DOGCARD;
select * from DISEASE;
select * from TREAT;
select * from HOSPITAL;
select * from EMP;