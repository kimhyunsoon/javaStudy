--�ʹ� ����
--1. sys ���� : sqlplus / as sysdba
--2. ���Ǻ��� : alter session set "_oracle_script"=true;
--3. ���� ���� : drop user project CASCADE;

alter session set "_oracle_script"=true;   
create user project identified by java;
grant connect, resource, unlimited tablespace to project; 
conn project/java;
select * from tab;