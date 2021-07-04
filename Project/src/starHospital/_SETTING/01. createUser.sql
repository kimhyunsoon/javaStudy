--초반 셋팅
--1. sys 접속 : sqlplus / as sysdba
--2. 세션변경 : alter session set "_oracle_script"=true;
--3. 유저 삭제 : drop user project CASCADE;

alter session set "_oracle_script"=true;   
create user project identified by java;
grant connect, resource, unlimited tablespace to project; 
conn project/java;
select * from tab;