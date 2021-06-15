show user
select * from dept;
SELECT * FROM EMP;
select EMP.EMPNO, DEPT.DNAME from EMP, DEPT where EMP.DEPTNO=DEPT.DEPTNO;
select EMP.EMPNO, DEPT.DNAME from EMP, DEPT 
		where EMP.DEPTNO=DEPT.DEPTNO and DEPT.DEPTNO=30;
select e.EMPNO, e.ENAME, d.DNAME from EMP e, DEPT d;    
select e.EMPNO, e.ENAME, d.DNAME from EMP e, DEPT d;
select EMP.EMPNO, DEPT.DNAME, emp.deptno from EMP, DEPT where EMP.DEPTNO=DEPT.DEPTNO;
select EMP.EMPNO, DEPT.DNAME, emp.deptno from EMP, DEPT;
select e.ENAME, m.ENAME from EMP e, EMP m where e.MGR = m.EMPNO;
select e.ENAME||'의 매니져는 ', m.ENAME||'이다' from EMP e, EMP m where e.MGR = m.EMPNO;
select ename from emp;
select e.ename, e.mgr, m.empno, m.ename, m.mgr from emp e, emp m where e.mgr = m.empno;
select e.ENAME||'의 매니져는 ', m.ENAME||'이다' from EMP e, EMP m 
where e.MGR = m.EMPNO and e.ENAME='SMITH';
select e.ENAME, m.ENAME from EMP e join EMP m on e.MGR = m.EMPNO;
select e.EMPNO, d.DNAME from EMP e, DEPT d 
		where e.DEPTNO=d.DEPTNO and e.EMPNO=7900;
    select DEPTNO from EMP where EMPNO=7900;
    select DNAME from DEPT where DEPTNO=30;
    select DNAME from DEPT where DEPTNO=(select DEPTNO from EMP where EMPNO=7900);
    select ENAME, DNAME from DEPT where DEPTNO=(select DEPTNO from EMP where EMPNO=7900);
    select sal from emp where deptno=10;
    select ENAME, COMM from EMP where SAL=(select SAL from EMP where DEPTNO=10);
    select SAL, COMM from EMP where EMPNO=7369;
    select ENAME, COMM from EMP where SAL=(select SAL, COMM from EMP where EMPNO=7369);
    select ENAME, SAL from EMP where SAL>(select avg(SAL) from EMP);
    select ENAME, SAL from EMP where SAL>avg(SAL);
    select ENAME, SAL from EMP where SAL;
    select avg(sal) from emp;
    select ENAME, SAL from EMP where SAL>(select avg(SAL) from EMP);
    select sal from emp where deptno=10;
    select ENAME, SAL from EMP where SAL=(select SAL from EMP where DEPTNO=10);
select ENAME, SAL from EMP where SAL in (select SAL from EMP where DEPTNO=10);
select ENAME, SAL from EMP where SAL=2450 or SAL=5000 or SAL=1300;
select SAL from EMP where DEPTNO=10;
select ENAME, SAL from EMP where DEPTNO=10;
select ENAME, SAL from EMP 
			where SAL=any(select SAL from EMP where DEPTNO=10);
select sal from emp where job='manager';      
select SAL from EMP where JOB='MANAGER';
select JOB, SAL from EMP where SAL>=all(select SAL from EMP where JOB='MANAGER');
select JOB, SAL from EMP where SAL>=(select SAL from EMP where JOB='MANAGER');
select JOB, SAL from EMP where SAL<all(select SAL from EMP where JOB='SALESMAN');
select JOB, SAL from EMP where SAL<any(select SAL from EMP where JOB='SALESMAN');
select JOB, SAL from EMP where SAL<all(select SAL from EMP where JOB='SALESMAN');
select SAL from EMP where JOB='SALESMAN';
select JOB, SAL from EMP
		where SAL<all(select SAL from EMP where JOB='SALESMAN');
    select * from EMP where DEPTNO=10;
    select DNAME from DEPT;
    select DNAME from DEPT where exists(select * from EMP where DEPTNO=10);
    select sal, comm from emp where deptno=30;
    select ename, deptno from emp;
select ENAME, DEPTNO from EMP where (SAL, COMM) 
in(select SAL, COMM from EMP where DEPTNO=30);    
select ENAME, DEPTNO from EMP where (SAL, nvl(COMM, 0)) 
in(select SAL, nvl(COMM, 0) from EMP where DEPTNO=30);
 select avg(e1.SAL) from EMP e1, EMP e2
where e1.DEPTNO=e2.DEPTNO;
select e1.EMPNO, e1.SAL from EMP e1
where SAL>(select avg(SAL) from EMP e2 
where e1.DEPTNO=e2.DEPTNO);
select e1.EMPNO, e1.SAL from EMP e1
			where SAL>(select avg(SAL) from EMP e2 where e1.DEPTNO=e2.DEPTNO);
      select avg(SAL) from EMP where DEPTNO=10; 
select deptno, ename, sal from emp;  
select dname from dept;
select e.DEPTNO, e.ENAME, e.SAL, d.DNAME from EMP e join DEPT d on e.DEPTNO=d.DEPTNO;
select deptno from emp where ename = 'ALLEN';
select DNAME from EMP, DEPT where ENAME = 'ALLEN';
select DNAME from EMP join DEPT 
using(DEPTNO)
where ENAME = 'ALLEN';
select e.ENAME||'의 매니저는 ', m.ENAME||'이다.' from EMP e
join EMP m on e.MGR = m = EMPNO
where e.ENAME='SMITH';
select e.ENAME, m.ENAME from EMP e 
join EMP m on e.MGR = m.EMPNO
where e.ENAME='SMITH';
select e.ENAME||'의 매니저는 ', m.ENAME||'이다.' from EMP e
join EMP m on e.MGR = m.EMPNO
where e.ENAME='SMITH';
select e.ENAME||'의 매니져는 ', m.ENAME||'이다' from EMP e, EMP m 
where e.MGR = m.EMPNO and e.ENAME='SMITH';
select JOB from EMP where ENAME= 'ALLEN'
		select e.ENAME,d.DNAME,e.SAL,e.JOB From EMP e,DEPT d
		where e.JOB = (select JOB from EMP where ENAME= 'ALLEN')
		and e.DEPTNO = d.DEPTNO;
    select ename from emp where ename = 'ALLEN';
select ENAME, DNAME, SAL, JOB from EMP, DEPT where JOB=(select JOB from emp where ename = 'ALLEN');   
select e.ENAME, d.DNAME, e.SAL, e.JOB from EMP e 
join DEPT e on e.DEPTNO=d.DEPTNO where e.JOB=(select JOB from emp where ename = 'ALLEN');
select e.ENAME, d.DNAME, e.SAL, e.JOB from EMP e 
join DEPT d on e.DEPTNO=d.DEPTNO 
where e.JOB=(select JOB from emp where ename = 'ALLEN');