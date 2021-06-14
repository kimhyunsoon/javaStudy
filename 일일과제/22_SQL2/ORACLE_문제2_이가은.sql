< ���� (FUNCTION) >

(1) EMP Table���� �̸�, �޿�, Ŀ�̼� �ݾ�, �Ѿ�(sal+comm)�� ���Ͽ� �Ѿ��� 
    ���� ������ ����϶�. ��, Ŀ�̼��� NULL�� ����� �����Ѵ�. 

   SQL> select ENAME "�̸�", SAL "�޿�", COMM "Ŀ�̼� �ݾ�", SAL+COMM "�Ѿ�" 
	from EMP 
	where COMM is not null order by "�Ѿ�" desc;
	
 
(2) 10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���.
    �̸�, �޿�, ���ʽ� �ݾ�, �μ� ��ȣ�� ����϶�.

   SQL1> select ENAME "�̸�", SAL "�޿�", SAL*0.13 "���ʽ��ݾ�", DEPTNO "�μ���ȣ" 
	 from EMP 
	 where DEPTNO =10;
   SQL2> select ENAME "�̸�", SAL+(SAL*0.13) "�޿�+���ʽ�", SAL*0.13 "���ʽ��ݾ�", DEPTNO "�μ���ȣ" 
	 from EMP 
	 where DEPTNO =10;

(3) 30�� �μ��� ������ ����Ͽ� �̸�, �μ���ȣ, �޿�, ������ ����϶�.
    ��, ������ �޿��� 150%�� ���ʽ��� �����Ѵ�. 
   
   SQL> select ENAME "�̸�", DEPTNO "�μ���ȣ", SAL "�޿�", SAL*SAL*1.5 "����" 
	from EMP 
	where DEPTNO =30;

   
(4) �μ� ��ȣ�� 20�� �μ��� �ð��� �ӱ��� ����Ͽ� ����϶�. ��, 1���� �ٹ��ϼ��� 12���̰�, 1�� �ٹ��ð��� 5�ð��̴�.
    ��¾���� �̸�, �޿�, �ð��� �ӱ�(�Ҽ����� 1��° �ڸ����� �ݿø�)
    �� ����϶�. 
   SQL> select ENAME "�̸�", SAL "�޿�", round(SAL/12/5) "�ð��� �ӱ�" 
	from EMP 
	where DEPTNO =20;

(5) �޿��� $1,500 ���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���.
    �̸� �̸�, �޿�, ȸ��(-2�ڸ����� �ݿø�)�� ����϶�.
   SQL> select ENAME "�̸�", SAL "�޿�", round(SAL*0.15,1) "ȸ��" 
	from EMP 
	where SAL between 1500 and 3000;

	   
(6) �޿��� $2,000 �̻��� ��� ����� �޿��� 15%�� ������� ����� �Ͽ���. 
    �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
   SQL> select ENAME "�̸�", SAL "�޿�", floor(SAL*0.15) "������" 
	from EMP 
	where SAL > 2000;


(7) �Ի��Ϻ��� ���ݱ����� ��¥���� ����϶�.
    �μ� ��ȣ, �̸�, �Ի���, ������, �ٹ��ϼ�(�Ҽ��� ���� ����), 
	�ٹ����(�ݿø�),�ٹ�����(30�� ����,�ݿø�), �ٹ��ּ�(�ݿø�)�� ����϶�.

   SQL> select DEPTNO "�μ� ��ȣ", ENAME "�̸�", HIREDATE "�Ի���", SYSDATE "������", 
	trunc(SYSDATE-HIREDATE+1)"�ٹ��ϼ�", 
	round(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "�ٹ����", 
	round(MONTHS_BETWEEN(SYSDATE, HIREDATE))"�ٹ�����",
	round((SYSDATE-HIREDATE+1)/7) "�ٹ��ּ�" 
	from EMP;

--trunc(MONTHS_BETWEEN(SYSDATE, HIREDATE))+trunc(mod(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12,1)*12) "�ٹ�����", 

(8) ��� ����� �Ǽ��ɾ��� ����Ͽ� ����϶�.
    ��, �޿��� ���� ������ �̸�, �޿�, �Ǽ��ɾ��� ����϶�
    (�Ǽ��ɾ��� �޿��� ���� 10%�� ������ �� �ݾ�)
   SQL> select ENAME, SAL, SAL-SAL*0.1 "�Ǽ��ɾ�" 
	from EMP order by SAL desc;

(9) �Ի��Ϸκ��� 90���� ���� ���� ��� �̸�, �Ի���, 90�� ���� ��, �޿��� ����϶�.
   SQL> select ENAME, HIREDATE, add_months(HIREDATE,3) "90�� ���� ��", 
	SAL "�޿�", SAL*3 "�׵��� ���� �޿�" 
	from EMP;

(10) �Ի��Ϸκ��� 6������ ���� ���� �Ի���, 6���� ���� ��¥, �޿��� ����϶�.
   SQL> select HIREDATE, add_months(HIREDATE,6) "6���� ��", SAL "�޿�", SAL*6 "�׵��� ���� �޿�" 
	from EMP;

(11) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �Ի���, �ٹ��ϼ��� ����϶�.
   SQL> select ENAME "�̸�",   HIREDATE "�Ի���", 
	last_day(HIREDATE)- HIREDATE "�Ի��� ���� �ٹ��ϼ�" ,DEPTNO "�μ���ȣ"
	from EMP;

(12) ��� ����� 60���� ���� ���� 'MONDAY'�� �� ��, �� ��, �� �� �ΰ��� ���Ͽ�
     �̸�, �Ի���, 'MONDAY'�� ����϶�.
   SQL> select ENAME, HIREDATE, next_day(add_months(HIREDATE,3),2) "MONDAY" 
	from EMP;


(13) �Ի��Ϸκ��� ���ñ����� �ϼ��� ���Ͽ� �̸�, �Ի���, �ٹ��ϼ�(�ݿø�)�� ����϶�.
   SQL> select ENAME "�̸�", HIREDATE "�Ի���", round(SYSDATE-HIREDATE+1) 
	from EMP;

(14) �Ի����� '1996�� 5�� 14��'�� ���·� �̸�, �Ի����� ����϶�.
   SQL> select ENAME, to_char(HIREDATE, '""YYYY"�� "MM"�� "DD"��"') 
	from EMP;


(15) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
   SQL> select substr(lower(ENAME),1,3) 
	from EMP 
	where length(ENAME)>=6;


(16) 10�� �μ� ������ ���, �ְ�, ����, �ο����� ���Ͽ� ����϶�.
   SQL> select round(avg(SAL)) "���", max(SAL) "�ְ�", min(SAL) "����", count(EMPNO) "�ο���"
	from EMP 
	where DEPTNO=10 group by DEPTNO;
 

(17) �� �μ��� �޿��� ���, �ְ�, ����, �ο����� ���Ͽ� ����϶�.
     (�μ���ȣ�� ���)
   SQL> select DEPTNO, round(avg(SAL)) "���", max(SAL) "�ְ�", min(SAL) "����", count(EMPNO) "�ο���"
	from EMP group by DEPTNO 
	order by DEPTNO;


(18) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ, ������, �ο����� ����϶�.
   SQL> select DEPTNO, JOB, count(JOB) "�ο���"
	from EMP group by DEPTNO,JOB 
	order by DEPTNO;

(19) ���� ������ �ϴ� ����� ���� 4�� �̻��� ������ �ο����� ����϶�.
   SQL> select JOB, count(JOB) "�ο���"
	from EMP having count(JOB)>=4 group by DEPTNO,JOB 
	order by DEPTNO;   

(20) �� �μ��� ��� ����, ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ 
     ���� ������ ����϶�. (�μ���ȣ�� ���)
   SQL> select DEPTNO, round(avg(SAL)) "��տ���", sum(SAL) "��ü����", 
	max(SAL) "�ְ� ����", min(SAL) "���� ����" 
	from EMP group by DEPTNO 
	order by "��տ���" desc;
   



