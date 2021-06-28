create table MOM (
	  
  M_NUMBER NUMBER(4),             --회원번호(PK)
	M_PHONE NVARCHAR2(13) NOT NULL, --연락처(UK,NN)
	M_NAME NVARCHAR2(10) NOT NULL,  --회원이름(NN)
	M_ADDR NVARCHAR2(50) NOT NULL,  --회원주소(NN)
  
  constraint MOM_PK primary key(M_NUMBER),
  constraint MOM_UK unique (M_PHONE)

);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='MOM';


create table DOGCARD (
	
  D_NUMBER NUMBER(4),               --강아지번호(PK)
	D_NAME NVARCHAR2(10) NOT NULL,    --강아지이름(NN)
	D_AGE NUMBER(2),                  --강아지나이
	D_WEIGHT NVARCHAR2(10),           --강아지무게
	D_SEX NVARCHAR2(2),               --강아지성별(CK)
	D_FDATE DATE default SYSDATE,     --첫방문일
	M_NUMBER NUMBER(4) NOT NULL,      --회원번호(FK)
  
  constraint DOGCARD_PK primary key(D_NUMBER),
  constraint DOGCARD_CK check (D_SEX = '수컷' or D_SEX = '암컷'),
  constraint DOGCARD_FK foreign key(M_NUMBER) references MOM(M_NUMBER)
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='DOGCARD';

create table DISEASE (
	DS_CODE NUMBER(2),                --병명코드(PK)
	DS_NAME NVARCHAR2(50) NOT NULL,   --병이름(NN)
  
  constraint DISEASE_PK primary key(DS_CODE)
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='DISEASE';

create table TREAT (
	T_CODE NUMBER(2),                 --치료코드(PK)
	T_HOW NVARCHAR2(50) NOT NULL,     --치료방법(NN)
	T_COST NUMBER NOT NULL,           --치료금액
	T_INS NVARCHAR2(1),               --보험(CK)
	DS_CODE NUMBER(2) NOT NULL,       --병명코드(FK)
  
  constraint TREAT_PK primary key(T_CODE),
  constraint TREAT_CK check (T_INS = '유' or T_INS = '무'),
  constraint TREAT_FK foreign key(DS_CODE) references DISEASE(DS_CODE)
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='TREAT';

create table MEDICAL (

	MD_DATE DATE default SYSDATE,     --진료번호(PK)
	MD_SEC NVARCHAR2(2) NOT NULL,     --진료구분(CK,NN)
	D_NUMBER NUMBER(4)NOT NULL,       --강아지번호(FK,NN)
	DS_CODE NUMBER(2),                --병명코드(FK)
  
  constraint MEDICAL_PK primary key(MD_DATE),
  constraint MEDICAL_CK check (MD_SEC = '진단' or MD_SEC = '치료'),
  constraint MEDICAL_FK1 foreign key(D_NUMBER) references DOGCARD(D_NUMBER),
  constraint MEDICAL_FK2 foreign key(DS_CODE) references DISEASE(DS_CODE)
  
);


select constraint_name, constraint_type, table_name from user_constraints 
where table_name='MEDICAL';


create table BILL (
	MD_DATE DATE constraint BILL_PK primary key,--진료번호(PK,FK)
	B_VCOST NUMBER NOT NULL,                    --진단비(NN)
	B_COST NUMBER,                              --치료비 
	T_CODE NUMBER(2),                           --치료코드(FK)
  
  constraint BILL_FK1 foreign key(MD_DATE) references MEDICAL(MD_DATE),
  constraint BILL_FK2 foreign key(T_CODE) references TREAT(T_CODE)
  
);


select constraint_name, constraint_type, table_name from user_constraints 
where table_name='BILL';


create table HOSPITAL (
	H_CODE NUMBER(2),                 --부서코드(PK)
	H_JOB NVARCHAR2(10) NOT NULL,     --업무내용(NN)
	H_MGR NVARCHAR2(10),              --부서장
  
  constraint HOSPITAL_PK primary key(H_CODE)
  
);

select constraint_name, constraint_type, table_name from user_constraints 
where table_name='HOSPITAL';



create table EMP (
	E_NUMBER NUMBER(4),               --직원사번(PK)
	E_NAME NVARCHAR2(10) NOT NULL,    --직원이름(NN)
  E_PHONE NVARCHAR2(13) NOT NULL,   --직원전화번호(NN)
	E_HIREDATE DATE default SYSDATE,  --입사일
	E_AGE NUMBER(2),                  --직원나이
  E_SAL NUMBER,                     --급여
	H_CODE NUMBER(2) NOT NULL,        --부서코드(FK)
  
  constraint EMP_PK primary key(E_NUMBER), 
  constraint EMP_FK foreign key(H_CODE) references HOSPITAL(H_CODE)

);
