drop table EMP;
drop table HOSPITAL;
drop table BILL;
drop table MEDICAL;
drop table TREAT;
drop table DISEASE;
drop table DOGCARD;
drop table MOM;
purge recyclebin;

create table MOM(
	M_NUMBER CHAR(5),			--회원번호(PK)
	M_PHONE NVARCHAR2(13) NOT NULL,		--연락처(UK,NN)
	M_NAME NVARCHAR2(5) NOT NULL,		--회원이름(NN)
	M_ADDR NVARCHAR2(30) NOT NULL,		--회원주소(NN)
	constraint MOM_PK primary key(M_NUMBER),
	constraint MOM_UK unique (M_PHONE)
);
create table DOGCARD(	
	D_NUMBER CHAR(5),			--강아지번호(PK)
	D_NAME NVARCHAR2(5) NOT NULL,		--강아지이름(NN)
	D_KINDS NVARCHAR2(10) default NULL,	--견종
	D_AGE NUMBER(2) default NULL,		--강아지나이
	D_WEIGHT NUMBER(3,1) default NULL,	--강아지무게
	D_SEX NVARCHAR2(2) default NULL,	--강아지성별(CK)
	D_FDATE DATE default SYSDATE,		--첫방문일
	M_NUMBER CHAR(5) NOT NULL,		--회원번호(FK,NN)
	constraint DOGCARD_PK primary key(D_NUMBER),
	constraint DOGCARD_CK check (D_SEX = '수컷' or D_SEX = '암컷'),
	constraint DOGCARD_FK foreign key(M_NUMBER) references MOM(M_NUMBER) on delete cascade
);
create table DISEASE(
	DS_CODE CHAR(3),			--병명코드(PK)
	DS_NAME NVARCHAR2(10) NOT NULL,		--병이름(NN)
	constraint DISEASE_PK primary key(DS_CODE)
);
create table TREAT(
	T_CODE CHAR(3),				--치료코드(PK)
	T_HOW NVARCHAR2(10) NOT NULL,		--치료방법(NN)
	T_COST NUMBER NOT NULL,			--치료금액(NN)
	T_INS NVARCHAR2(5) default NULL,	--보험(CK)
	constraint TREAT_PK primary key(T_CODE),
	constraint TREAT_CK check (T_INS = '급여' or T_INS = '비급여')
);
create table MEDICAL(
	MD_DATE VARCHAR2(12),			--진료번호(PK)
	MD_SEC NVARCHAR2(2) NOT NULL,		--진료구분(CK,NN)
	D_NUMBER CHAR(5) NOT NULL,		--강아지번호(FK,NN)
	DS_CODE CHAR(3) default NULL,		--병명코드(FK)
	T_CODE CHAR(3) default NULL,		--치료코드(FK)
	constraint MEDICAL_PK primary key(MD_DATE),
	constraint MEDICAL_CK check (MD_SEC = '진단' or MD_SEC = '치료'),
	constraint MEDICAL_DOGCARD_FK foreign key(D_NUMBER) references DOGCARD(D_NUMBER) on delete cascade,
	constraint MEDICAL_DISEASE_FK foreign key(DS_CODE) references DISEASE(DS_CODE),
	constraint MEDICAL_TREAT_FK foreign key(T_CODE) references TREAT(T_CODE)
);
CREATE TABLE BILL (
	MD_DATE VARCHAR2(12) constraint BILL_PK primary key,	--진료번호(PK,FK)
	B_VCOST NUMBER default '15000',				--진단비
	B_TCOST NUMBER default NULL,				--치료비
	constraint BILL_FK foreign key(MD_DATE) references MEDICAL(MD_DATE) on delete cascade
);
create table HOSPITAL(
	H_CODE CHAR(3),				--부서코드(PK)
	H_JOB NVARCHAR2(10) NOT NULL,		--업무내용(NN)
	H_MGR NVARCHAR2(5) default NULL,	--부서장
	constraint HOSPITAL_PK primary key(H_CODE)
);
create table EMP (
	E_NUMBER CHAR(5),			--직원사번(PK)
	E_NAME NVARCHAR2(5) NOT NULL,		--직원이름(NN)
	E_PHONE NVARCHAR2(13) NOT NULL,		--직원전화번호(UK,NN)
	E_HIREDATE DATE default SYSDATE,	--입사일
	E_AGE NUMBER(2) default NULL,		--직원나이
	E_SAL NUMBER default NULL,		--급여
	H_CODE CHAR(3) NOT NULL,		--부서코드(FK)
  	constraint EMP_PK primary key(E_NUMBER), 
	constraint EMP_UK unique (E_PHONE),
	constraint EMP_FK foreign key(H_CODE) references HOSPITAL(H_CODE) on delete cascade
);


--확인
select TNAME from TAB;