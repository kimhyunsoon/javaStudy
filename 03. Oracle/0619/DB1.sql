create table MOM (
	  
  M_NUMBER NUMBER(4),             --ȸ����ȣ(PK)
	M_PHONE NVARCHAR2(13) NOT NULL, --����ó(UK,NN)
	M_NAME NVARCHAR2(10) NOT NULL,  --ȸ���̸�(NN)
	M_ADDR NVARCHAR2(50) NOT NULL,  --ȸ���ּ�(NN)
  
  constraint MOM_PK primary key(M_NUMBER),
  constraint MOM_UK unique (M_PHONE)

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='MOM';


create table DOGCARD (
	
  D_NUMBER NUMBER(4),               --��������ȣ(PK)
	D_NAME NVARCHAR2(10) NOT NULL,    --�������̸�(NN)
	D_AGE NUMBER(2),                  --����������
	D_WEIGHT NVARCHAR2(10),           --����������
	D_SEX NVARCHAR2(2),               --����������(CK)
	D_FDATE DATE default SYSDATE,     --ù�湮��
	M_NUMBER NUMBER(4) NOT NULL,      --ȸ����ȣ(FK)
  
  constraint DOGCARD_PK primary key(D_NUMBER),
  constraint DOGCARD_CK check (D_SEX = '����' or D_SEX = '����'),
  constraint DOGCARD_FK foreign key(M_NUMBER) references MOM(M_NUMBER)
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='DOGCARD';

create table DISEASE (
	DS_CODE NUMBER(2),                --�����ڵ�(PK)
	DS_NAME NVARCHAR2(50) NOT NULL,   --���̸�(NN)
  
  constraint DISEASE_PK primary key(DS_CODE)
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='DISEASE';

create table TREAT (
	T_CODE NUMBER(2),                 --ġ���ڵ�(PK)
	T_HOW NVARCHAR2(50) NOT NULL,     --ġ����(NN)
	T_COST NUMBER NOT NULL,           --ġ��ݾ�
	T_INS NVARCHAR2(1),               --����(CK)
	DS_CODE NUMBER(2) NOT NULL,       --�����ڵ�(FK)
  
  constraint TREAT_PK primary key(T_CODE),
  constraint TREAT_CK check (T_INS = '��' or T_INS = '��'),
  constraint TREAT_FK foreign key(DS_CODE) references DISEASE(DS_CODE)
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='TREAT';

create table MEDICAL (

	MD_DATE DATE default SYSDATE,     --�����ȣ(PK)
	MD_SEC NVARCHAR2(2) NOT NULL,     --���ᱸ��(CK,NN)
	D_NUMBER NUMBER(4)NOT NULL,       --��������ȣ(FK,NN)
	DS_CODE NUMBER(2),                --�����ڵ�(FK)
  
  constraint MEDICAL_PK primary key(MD_DATE),
  constraint MEDICAL_CK check (MD_SEC = '����' or MD_SEC = 'ġ��'),
  constraint MEDICAL_FK1 foreign key(D_NUMBER) references DOGCARD(D_NUMBER),
  constraint MEDICAL_FK2 foreign key(DS_CODE) references DISEASE(DS_CODE)
  
);


select constraint_name, constraint_type, table_name from user_constraints 
where table_name='MEDICAL';


create table BILL (
	MD_DATE DATE constraint BILL_PK primary key,--�����ȣ(PK,FK)
	B_VCOST NUMBER NOT NULL,                    --���ܺ�(NN)
	B_COST NUMBER,                              --ġ��� 
	T_CODE NUMBER(2),                           --ġ���ڵ�(FK)
  
  constraint BILL_FK1 foreign key(MD_DATE) references MEDICAL(MD_DATE),
  constraint BILL_FK2 foreign key(T_CODE) references TREAT(T_CODE)
  
);


select constraint_name, constraint_type, table_name from user_constraints 
where table_name='BILL';


create table HOSPITAL (
	H_CODE NUMBER(2),                 --�μ��ڵ�(PK)
	H_JOB NVARCHAR2(10) NOT NULL,     --��������(NN)
	H_MGR NVARCHAR2(10),              --�μ���
  
  constraint HOSPITAL_PK primary key(H_CODE)
  
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='HOSPITAL';



create table EMP (
	E_NUMBER NUMBER(4),               --�������(PK)
	E_NAME NVARCHAR2(10) NOT NULL,    --�����̸�(NN)
  E_PHONE NVARCHAR2(13) NOT NULL,   --������ȭ��ȣ(NN)
	E_HIREDATE DATE default SYSDATE,  --�Ի���
	E_AGE NUMBER(2),                  --��������
  E_SAL NUMBER,                     --�޿�
	H_CODE NUMBER(2) NOT NULL,        --�μ��ڵ�(FK)
  
  constraint EMP_PK primary key(E_NUMBER), 
  constraint EMP_FK foreign key(H_CODE) references HOSPITAL(H_CODE)

);
