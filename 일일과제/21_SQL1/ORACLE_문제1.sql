< ���� (SELECT) >

(1) �μ���ȣ�� 10���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶� 
	SQL> select EMPNO, ENAME, SAL from EMP where DEPTNO = 10;

(2) �����ȣ�� 7369�� ��� �� �̸�, �Ի���, �μ���ȣ�� ����϶� 
	SQL> select ENAME, HIREDATE, DEPTNO from EMP where EMPNO = 7369;

(3) �̸��� ALLEN �� ����� ��� ������ ����϶� 
	SQL> select * from EMP where ENAME = 'ALLEN';
    
(4) �Ի����� 81/05/01 �� ����� �̸�, �μ���ȣ, ������ ����϶� 
	SQL> select ENAME, DEPTNO, SAL from EMP where HIREDATE = '81/05/01';

(5) ������ MANAGER �� �ƴ� ����� ��� ������ ����϶� 
	SQL> select * from EMP where JOB != 'MANAGER';

(6) �Ի����� 81/04/02 ���Ŀ� �Ի��� ����� ������ ����϶� 
	SQL> select * from EMP where HIREDATE > '81/04/02' order by HIREDATE;    

(7) �޿��� $800 �̻��� ����� �̸�, �޿�, �μ���ȣ�� ����϶� 
    	SQL> select ENAME, SAL "SAL($)" , DEPTNO from EMP where SAL > 800 order by SAL; 
    
(8) �μ���ȣ�� 20�� �̻��� ����� ��� ������ ����϶� 
	SQL> select * from EMP where DEPTNO >= 20 order by DEPTNO; 

(9) �̸��� K�� �����ϴ� ������� ���� �̸��� ���� ����� �̸��� ����϶� 
	SQL> select ENAME from EMP 
	     where ENAME > all(select ENAME from EMP where ENAME like 'K%');
    
(10) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶� 
	SQL> select * from EMP where HIREDATE <'81/12/09';
    
(11) �Ի��ȣ�� 7698���� �۰ų� ���� ������� �Ի��ȣ�� �̸��� ����϶�
	SQL> select EMPNO, ENAME from EMP where EMPNO <= 7698;
   
(12) �Ի����� 81/04/02 ���� �ʰ� 82/12/09 ���� ���� ����� �̸�, ����, �μ���ȣ, �Ի��ȣ�� ����϶� 
	SQL> select ENAME, SAL, DEPTNO, HIREDATE 
	     from EMP
	     where HIREDATE > '81/04/02' and HIREDATE < '82/12/09' order by HIREDATE;

(13) �޿��� 1,600 ���� ũ�� $3,000 ���� ���� ����� �̸�, ����, �޿��� ����϶�
	SQL> select ENAME, JOB, SAL "SAL($)"
	     from EMP
	     where SAL >1600 and SAL <3000;

(14) �����ȣ�� 7654�� 7782 ���� �̿��� ����� �Ի��ȣ, �̸��� ����϶� 
	SQL> select EMPNO, ENAME from EMP where EMPNO <7654
	      union
	     select EMPNO, ENAME from EMP where EMPNO >7782;

(15) �̸��� B�� J������ ��� ����� �̸��� ����϶� 
	SQL> select ENAME from EMP
	     where ENAME between 'C%' and 'J%';
   
(16) �Ի����� 81�� �̿ܿ� �Ի��� ����� �Ի��ϰ� �̸��� ����϶� 
	SQL> select HIREDATE, ENAME from EMP where not (HIREDATE like '81/__/__');
	
(17) ������ MANAGER�� SALESMAN�� ����� �̸��� ������ ����϶� 
	SQL> select ENAME, JOB from EMP where JOB='MANAGER'
		union
	     select ENAME, JOB from EMP where JOB='SALESMAN';
     
(18) �μ���ȣ�� 20, 30���� ������ ��� ����� �̸�, �����ȣ, �μ���ȣ�� ����϶� 
	SQL> select ENAME, EMPNO, DEPTNO from EMP 
	     where not (DEPTNO in(20,30));
     
(19) �̸��� S�� �����ϴ� ����� �����ȣ, �̸�, �Ի���, �μ���ȣ�� ����϶� 
	SQL> select EMPNO, ENAME, HIREDATE, DEPTNO from EMP
	     where ENAME like 'S%';
     
(20) �Ի����� 81�⵵�� ����� �Ի���, �̸��� ����϶�
	SQL> select HIREDATE, ENAME from EMP where HIREDATE like '81/__/__';
     
(21) �̸� �� A�ڰ� �� �ִ� ����� �Ի��ȣ, �̸��� ����϶�
	SQL> select EMPNO, ENAME from EMP where ENAME like '%A%';
     
(22) �̸��� S�� �����ϰ� ������ ���ڰ� T�� ����� �̸��� ����϶� 
	SQL> select ENAME from EMP where ENAME like 'S%T';
     

(23) �̸��� �� ��° ���ڰ� A�� ����� �̸��� ����϶� 
	SQL> select ENAME from EMP where ENAME like '_A%' order by ename;
	 cf) �̸��� �� ��° ���ڰ� A�� ����� �̸��� ����϶�
		SQL> select ENAME from EMP where ENAME like '__A%' order by ename;
         
(24) Ŀ�̼��� NULL�� ����� �̸��� Ŀ�̼��� ����϶� 
	SQL> select ENAME, COMM from EMP where COMM is null;

(25) Ŀ�̼��� NULL�� �ƴ� ����� �̸��� Ŀ�̼��� ����϶� 
	SQL> select ENAME, COMM from EMP where COMM is not null;

(26) �μ���ȣ�� 30�� �μ��̰�, �޿��� $1,500 �̻��� ����� �̸�, �μ���ȣ, ������ ����϶�
	SQL> select ENAME, DEPTNO, SAL from EMP where DEPTNO = 30
		intersect
	     select ENAME, DEPTNO, SAL from EMP where SAL>1500;
     
(27) �̸��� ù ���ڰ� K �� �����ϰų� �μ���ȣ�� 30�� ����� �����ȣ, �̸�, �μ���ȣ�� ����϶�
	SQL> select EMPNO, ENAME, DEPTNO from EMP where ENAME like 'K%'
		union
	     select EMPNO, ENAME, DEPTNO from EMP where DEPTNO = 30;
     

(28) �޿��� $1,500 �̻��̰�, �μ���ȣ�� 30���� ��� �� ������ MANAGER�� ����� �޿�, �μ���ȣ, ������ ����϶� 
	SQL> select SAL, DEPTNO, JOB from EMP
	     where SAL>1500 and DEPTNO = 30 and Job = 'MANAGER';
                                   
(29) �μ���ȣ�� 30�� ����� �̸�,�����ȣ,�μ���ȣ�� �����ȣ�� ���� SORT(����)�϶�
	SQL> select ENAME, EMPNO, DEPTNO from EMP 
	     where DEPTNO = 30 order by EMPNO;
     
(30) �̸��� �޿��� �����͸� �޿��� ���� ������ SORT �϶�
	SQL> select ENAME, SAL from EMP order by SAL desc;
     
(31) �μ���ȣ�� ASCENDING SORT�� �� �޿��� ���� ��� ������ �̸�, �μ���ȣ, �޿��� ����϶�
	SQL> select ENAME, DEPTNO, SAL from EMP order by DEPTNO, SAL desc;
     
(32) �μ���ȣ�� DESCENDING SORT�� ��, ���� ������ ASCENDING SORT, �޿� ������ DESCENDING SORT�϶�  
	SQL> select DEPTNO, JOB, SAL from EMP order by DEPTNO desc, JOB, SAL desc;     
     