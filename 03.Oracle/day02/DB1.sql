select * 
from EMP 
where deptno =10;
select * 
from EMP 
where deptno =10;
select * 
from EMP 
where deptno =10;
select count(comm)from EMP;

select ENAME, SAL from EMP where SAL=(select min(sal) from EMP);
select TNAME from tab;
select TABLE_NAME from user_tables;
desc DEPT;
select TNAME from tab;
desc DEPT;
select JOB from emp;
 select all JOB from emp;
 
select distinct JOB from emp;
select JOB, SAL from EMP order by JOB, SAL desc;
select ENAME, SAL, COMM from EMP where DEPTNO=30;
select ENAME, SAL, NVL(COMM, 0) from EMP where DEPTNO=30;
select EMPNO, ENAME from EMP
			union
			select EMPNO, ENAME from EMP;
      select EMPNO, ENAME from EMP
			union all
			select EMPNO, ENAME from EMP;
      select ENAME, SAL from EMP
where NOT SAL>1000 and SAL<3000; 
select ENAME, SAL from EMP
where NOT (SAL>1000 and SAL<3000);
select ENAME, SAL from EMP where SAL between 1000 and 3000;
select ENAME, SAL from EMP where not(SAL between 1000 and 3000);
select DEPTNO, avg(SAL) from EMP group by DEPTNO;
select avg(Deptno), avg(SAL) FROM emp where deptno=10;
select deptNO, round(avg(sal)) from emp where sal >= 2000 GROUP BY DEPTNO order by deptno;
select deptNO, round(avg(sal)) from emp where sal >= 2000 GROUP BY DEPTNO order by 2 desc;
select deptno, round(avg(sal)) "��ձ޿�" from emp where sal >=1000 group by deptno order by deptno;
select deptno, round(avg(sal)) from emp 
where sal >=1000 group by deptno having round(avg(sal))>=2000 
order by deptno desc;
select deptno, round(avg(sal)) "��ձ޿�" from emp 
where sal >=1000 group by deptno having deptno>=20 
order by deptno desc;
select deptno, round(avg(sal)) "��ձ޿�" from emp 
where sal >=1000 and deptno>=20 
group by deptno 
order by deptno desc;
select deptno, job, count(job) "�ο���" from emp group by deptno, job order by deptno desc, job desc;
select ename "�̸�", sal "�޿�", comm "Ŀ�̼� �ݾ�", sal+comm "�Ѿ�" from emp 
where comm is not null order by "�Ѿ�" desc;
select ename, sal, comm, sal+comm from emp;
select ename "�̸�", sal "�޿�", sal*0.13 "���ʽ��ݾ�", deptno "�μ���ȣ" from emp 
where deptno =10;
select * from emp;
select ename "�̸�", sal+"���ʽ��ݾ�" "�޿�+���ʽ�", sal*0.13 "���ʽ��ݾ�", deptno "�μ���ȣ" from emp 
where deptno =10;
select ename "�̸�", sal+(sal*0.13) "�޿�+���ʽ�", sal*0.13 "���ʽ��ݾ�", deptno "�μ���ȣ" from emp 
where deptno =10;
select ename "�̸�", deptno "�μ���ȣ", sal "�޿�", sal*12+sal*1.5 "����" from emp 
	 where deptno =30;
select ename "�̸�", sal "�޿�", round(sal/12/5) "�ð��� �ӱ�" from emp 
where deptno =20;
select ename "�̸�", sal "�޿�", round(sal*0.15,1) "ȸ��" from emp 
where sal between 1500 and 3000;
select ename "�̸�", sal "�޿�", floor(sal*0.15) "������" from emp 
where sal > 2000;
select HIREDATE from EMP where EMPNO=7782;
select HIREDATE, add_months(HIREDATE, 7) from EMP where EMPNO=7782;
select HIREDATE "�Ի���", SYSDATE "������", trunc((SYSDATE-HIREDATE+1)/7) as "�ټӿ���" from EMP;
select deptno "�μ� ��ȣ", ename "�̸�", HIREDATE "�Ի���", SYSDATE "������", 
trunc(SYSDATE-HIREDATE+1)"�ٹ��ϼ�", 
round(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "�ٹ����", 
round(MONTHS_BETWEEN(SYSDATE, HIREDATE))"�ٹ�����",
round((SYSDATE-HIREDATE+1)/7) "�ٹ��ּ�" from emp;
select ENAME, SAL, SAL-SAL*0.1 "�Ǽ��ɾ�" from EMP order by sal desc;
select ENAME, HIREDATE, last_day(HIREDATE) "90�� ���� ��", SAL from EMP;
select ENAME, HIREDATE, last_day(HIREDATE) "90�� ���� ��", SAL*90 "90�� ���� ���� �޿�" from EMP;
select ENAME, HIREDATE, last_day(HIREDATE) "90�� ���� ��", SAL "�޿�", SAL*3 "90�� ���� ���� �޿�" from EMP;
select HIREDATE, last_day(HIREDATE) from EMP;
select ENAME, HIREDATE, add_months(HIREDATE,3) "90�� ���� ��", SAL "�޿�", SAL*90 "�׵��� ���� �޿�" 
	from EMP;
  select HIREDATE, add_months(HIREDATE,6) "90�� ���� ��", SAL "�޿�", SAL*90 "�׵��� ���� �޿�" 
	from EMP;
  select ENAME, HIREDATE, add_months(HIREDATE,3) "90�� ���� ��", SAL "�޿�", SAL*3 "�׵��� ���� �޿�" 
	from EMP;
select HIREDATE, add_months(HIREDATE,6) "6���� ��", SAL "�޿�", SAL*6 "�׵��� ���� �޿�" 
	from EMP;
  select DEPTNO, ENAME, HIREDATE, last_day(HIREDATE)- HIREDATE "�Ի��� ���� �ٹ��ϼ�"
	from EMP;
  select DEPTNO "�μ���ȣ", ENAME "�̸�", HIREDATE "�Ի���", last_day(HIREDATE)- HIREDATE "�Ի��� ���� �ٹ��ϼ�"
	from EMP;
  select ENAME "�̸�", DEPTNO "�μ���ȣ",  HIREDATE "�Ի���", last_day(HIREDATE)- HIREDATE "�Ի��� ���� �ٹ��ϼ�"
	from EMP;
  select ENAME "�̸�",   HIREDATE "�Ի���", last_day(HIREDATE)- HIREDATE "�Ի��� ���� �ٹ��ϼ�" ,DEPTNO "�μ���ȣ"
	from EMP;
  select HIREDATE, next_day(add_months(HIREDATE,3),2) from EMP;
  select HIREDATE, add_months(HIREDATE,3), next_day(add_months(HIREDATE,3),2) from EMP;
  select ENAME, HIREDATE, next_day(add_months(HIREDATE,3),2) "MONDAY" from EMP;
  select ENAME "�̸�", HIREDATE "�Ի���", round(SYSDATE-HIREDATE+1) "�ٹ��ϼ�"
	from emp;
  select ENAME, HIREDATE from EMP;
select ENAME, to_char( HIREDATE, 'YYYY-MM-DD' )from EMP;
select ENAME, to_char(HIREDATE,'YYYY')||"��"
   from EMP;
select ENAME, to_char(HIREDATE,'YYYY')||'��'
   from EMP;   
select ENAME, to_char(HIREDATE,'YYYY')||'��', to_char(HIREDATE,'MM')||'��', to_char(HIREDATE,'DD')||'��'
   from EMP;   
select ENAME, to_char(HIREDATE,'YYYY'||'��', HIREDATE,'MM'||'��', HIREDATE,'DD'||'��')
   from EMP;   
   select ENAME, to_char(HIREDATE,'YYYY')||'��' to_char(HIREDATE,'MM')||'��' to_char(HIREDATE,'DD')||'��'
   from EMP; 
select ENAME, to_char( HIREDATE, 'YEAR-MM-DD' )from EMP;  
alter session set NLS_LANGUAGE='KOREAN';
select ENAME, to_char( HIREDATE, 'YEAR-MM-DD' )from EMP; 
select ENAME, to_char(HIREDATE, '""YYYY'�� HIREDATE,'MM')||'��' to_char(HIREDATE,'DD')||'��'
   from EMP;
select ENAME, to_char(HIREDATE, '""YYYY"�� "MM"�� "DD"��"') from EMP;
select ENAME from EMP where length(ENAME)>=6;
select substr(ENAME, 1, 3) from EMP where length(ENAME)>6;
select substr(ENAME, 0, 3) from EMP where length(ENAME)>6;
select lower(ENAME) from EMP where length(ENAME)>6;
select substr(lower(ENAME),1,3) from EMP where length(ENAME)>=6;
select avg(SAL) "���"
	from EMP where DEPTNO=10 group by DEPTNO;
select round(avg(SAL)) "���", max(SAL) "�ְ�", min(SAL) "����", count(EMPNO) "�ο���"
	from EMP where DEPTNO=10 group by DEPTNO;  
select DEPTNO, round(avg(SAL)) "���", max(SAL) "�ְ�", min(SAL) "����", count(EMPNO) "�ο���"
	from EMP group by DEPTNO order by DEPTNO;
select DEPTNO, JOB, count(JOB) "�ο���"
	from EMP group by DEPTNO,JOB order by DEPTNO;  
select JOB, count(JOB) "�ο���"
	from EMP Where count(JOB)>=4 group by DEPTNO,JOB order by DEPTNO;   
  select JOB, count(JOB) "�ο���"
	from EMP having count(JOB)>=4 group by DEPTNO,JOB order by DEPTNO;  
  select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", max(SAL) "�ְ� ����", min(SAL) "���� ����", 
	from EMP group by DEPTNO order by "���";
  select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", max(SAL) "�ְ� ����", min(SAL) "���� ����", 
	from EMP group by DEPTNO order by "��տ���";
  select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", max(SAL) "�ְ� ����", min(SAL) "���� ����", 
	from EMP group by DEPTNO order by round(avg(SAL));
  select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", max(SAL) "�ְ� ����", min(SAL) "���� ����" 
	from EMP group by DEPTNO order by round(avg(SAL));
  select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", max(SAL) "�ְ� ����", min(SAL) "���� ����" 
	from EMP group by DEPTNO order by "��տ���" desc;
  select ENAME "�̸�", SAL "�޿�", COMM "Ŀ�̼� �ݾ�", SAL+COMM "�Ѿ�" 
	from EMP 
	where COMM is not null order by "�Ѿ�" desc;
  select ENAME "�̸�", SAL "�޿�", SAL*0.13 "���ʽ��ݾ�", DEPTNO "�μ���ȣ" 
	 from EMP 
	 where DEPTNO =10;
   select ENAME "�̸�", DEPTNO "�μ���ȣ", SAL "�޿�", SAL*SAL*1.5 "����" 
	from EMP 
	where DEPTNO =30;
  select ENAME "�̸�", SAL "�޿�", round(SAL/12/5) "�ð��� �ӱ�" 
	from EMP 
	where DEPTNO =20;
  select ENAME "�̸�", SAL "�޿�", round(SAL*0.15,1) "ȸ��" 
	from EMP 
	where SAL between 1500 and 3000;
  select ENAME "�̸�", SAL "�޿�", floor(SAL*0.15) "������" 
	from EMP 
	where SAL > 2000;
  select DEPTNO "�μ� ��ȣ", ENAME "�̸�", HIREDATE "�Ի���", SYSDATE "������", 
	trunc(SYSDATE-HIREDATE+1)"�ٹ��ϼ�", 
	round(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "�ٹ����", 
	round(MONTHS_BETWEEN(SYSDATE, HIREDATE))"�ٹ�����",
	round((SYSDATE-HIREDATE+1)/7) "�ٹ��ּ�" 
	from EMP;
  select ENAME, SAL, SAL-SAL*0.1 "�Ǽ��ɾ�" 
	from EMP order by SAL desc;
  select ENAME, HIREDATE, add_months(HIREDATE,3) "90�� ���� ��", 
	SAL "�޿�", SAL*3 "�׵��� ���� �޿�" 
	from EMP;
  select HIREDATE, add_months(HIREDATE,6) "6���� ��", SAL "�޿�", SAL*6 "�׵��� ���� �޿�" 
	from EMP;
  select ENAME "�̸�",   HIREDATE "�Ի���", 
	last_day(HIREDATE)- HIREDATE "�Ի��� ���� �ٹ��ϼ�" ,DEPTNO "�μ���ȣ"
	from EMP;
  select ENAME, HIREDATE, next_day(add_months(HIREDATE,3),2) "MONDAY" 
	from EMP;
  select ENAME "�̸�", HIREDATE "�Ի���", round(SYSDATE-HIREDATE+1) 
	from EMP;
  select ENAME, to_char(HIREDATE, '""YYYY"�� "MM"�� "DD"��"') 
	from EMP;
   select substr(lower(ENAME),1,3) 
	from EMP 
	where length(ENAME)>=6;
  select round(avg(SAL)) "���", max(SAL) "�ְ�", min(SAL) "����", count(EMPNO) "�ο���"
	from EMP 
	where DEPTNO=10 group by DEPTNO;
  select DEPTNO, round(avg(SAL)) "���", max(SAL) "�ְ�", min(SAL) "����", count(EMPNO) "�ο���"
	from EMP group by DEPTNO 
	order by DEPTNO;
  select DEPTNO, JOB, count(JOB) "�ο���"
	from EMP group by DEPTNO,JOB 
	order by DEPTNO;
  select JOB, count(JOB) "�ο���"
	from EMP having count(JOB)>=4 group by DEPTNO,JOB 
	order by DEPTNO;  
  select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", 
	max(SAL) "�ְ� ����", min(SAL) "���� ����" 
	from EMP group by DEPTNO 
	order by "��տ���" desc;
   