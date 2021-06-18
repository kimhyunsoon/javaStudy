--alter session set "_oracle_script"=true;
--drop user VIDEO CASCADE;

alter session set "_oracle_script"=true;
create user VIDEO identified by JAVA;
grant connect, resource, unlimited tablespace to VIDEO;
conn VIDEO/JAVA;

