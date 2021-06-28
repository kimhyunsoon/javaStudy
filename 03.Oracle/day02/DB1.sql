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
select deptno, round(avg(sal)) "평균급여" from emp where sal >=1000 group by deptno order by deptno;
select deptno, round(avg(sal)) from emp 
where sal >=1000 group by deptno having round(avg(sal))>=2000 
order by deptno desc;
select deptno, round(avg(sal)) "평균급여" from emp 
where sal >=1000 group by deptno having deptno>=20 
order by deptno desc;
select deptno, round(avg(sal)) "평균급여" from emp 
where sal >=1000 and deptno>=20 
group by deptno 
order by deptno desc;
select deptno, job, count(job) "인원수" from emp group by deptno, job order by deptno desc, job desc;
select ename "이름", sal "급여", comm "커미션 금액", sal+comm "총액" from emp 
where comm is not null order by "총액" desc;
select ename, sal, comm, sal+comm from emp;
select ename "이름", sal "급여", sal*0.13 "보너스금액", deptno "부서번호" from emp 
where deptno =10;
select * from emp;
select ename "이름", sal+"보너스금액" "급여+보너스", sal*0.13 "보너스금액", deptno "부서번호" from emp 
where deptno =10;
select ename "이름", sal+(sal*0.13) "급여+보너스", sal*0.13 "보너스금액", deptno "부서번호" from emp 
where deptno =10;
select ename "이름", deptno "부서번호", sal "급여", sal*12+sal*1.5 "연봉" from emp 
	 where deptno =30;
select ename "이름", sal "급여", round(sal/12/5) "시간당 임금" from emp 
where deptno =20;
select ename "이름", sal "급여", round(sal*0.15,1) "회비" from emp 
where sal between 1500 and 3000;
select ename "이름", sal "급여", floor(sal*0.15) "경조비" from emp 
where sal > 2000;
select HIREDATE from EMP where EMPNO=7782;
select HIREDATE, add_months(HIREDATE, 7) from EMP where EMPNO=7782;
select HIREDATE "입사일", SYSDATE "현재일", trunc((SYSDATE-HIREDATE+1)/7) as "근속월수" from EMP;
select deptno "부서 번호", ename "이름", HIREDATE "입사일", SYSDATE "현재일", 
trunc(SYSDATE-HIREDATE+1)"근무일수", 
round(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "근무년수", 
round(MONTHS_BETWEEN(SYSDATE, HIREDATE))"근무월수",
round((SYSDATE-HIREDATE+1)/7) "근무주수" from emp;
select ENAME, SAL, SAL-SAL*0.1 "실수령액" from EMP order by sal desc;
select ENAME, HIREDATE, last_day(HIREDATE) "90일 후의 날", SAL from EMP;
select ENAME, HIREDATE, last_day(HIREDATE) "90일 후의 날", SAL*90 "90일 동안 받은 급여" from EMP;
select ENAME, HIREDATE, last_day(HIREDATE) "90일 후의 날", SAL "급여", SAL*3 "90일 동안 받은 급여" from EMP;
select HIREDATE, last_day(HIREDATE) from EMP;
select ENAME, HIREDATE, add_months(HIREDATE,3) "90일 후의 날", SAL "급여", SAL*90 "그동안 받은 급여" 
	from EMP;
  select HIREDATE, add_months(HIREDATE,6) "90일 후의 날", SAL "급여", SAL*90 "그동안 받은 급여" 
	from EMP;
  select ENAME, HIREDATE, add_months(HIREDATE,3) "90일 후의 날", SAL "급여", SAL*3 "그동안 받은 급여" 
	from EMP;
select HIREDATE, add_months(HIREDATE,6) "6개월 후", SAL "급여", SAL*6 "그동안 받은 급여" 
	from EMP;
  select DEPTNO, ENAME, HIREDATE, last_day(HIREDATE)- HIREDATE "입사한 달의 근무일수"
	from EMP;
  select DEPTNO "부서번호", ENAME "이름", HIREDATE "입사일", last_day(HIREDATE)- HIREDATE "입사한 달의 근무일수"
	from EMP;
  select ENAME "이름", DEPTNO "부서번호",  HIREDATE "입사일", last_day(HIREDATE)- HIREDATE "입사한 달의 근무일수"
	from EMP;
  select ENAME "이름",   HIREDATE "입사일", last_day(HIREDATE)- HIREDATE "입사한 달의 근무일수" ,DEPTNO "부서번호"
	from EMP;
  select HIREDATE, next_day(add_months(HIREDATE,3),2) from EMP;
  select HIREDATE, add_months(HIREDATE,3), next_day(add_months(HIREDATE,3),2) from EMP;
  select ENAME, HIREDATE, next_day(add_months(HIREDATE,3),2) "MONDAY" from EMP;
  select ENAME "이름", HIREDATE "입사일", round(SYSDATE-HIREDATE+1) "근무일수"
	from emp;
  select ENAME, HIREDATE from EMP;
select ENAME, to_char( HIREDATE, 'YYYY-MM-DD' )from EMP;
select ENAME, to_char(HIREDATE,'YYYY')||"년"
   from EMP;
select ENAME, to_char(HIREDATE,'YYYY')||'년'
   from EMP;   
select ENAME, to_char(HIREDATE,'YYYY')||'년', to_char(HIREDATE,'MM')||'월', to_char(HIREDATE,'DD')||'일'
   from EMP;   
select ENAME, to_char(HIREDATE,'YYYY'||'년', HIREDATE,'MM'||'월', HIREDATE,'DD'||'일')
   from EMP;   
   select ENAME, to_char(HIREDATE,'YYYY')||'년' to_char(HIREDATE,'MM')||'월' to_char(HIREDATE,'DD')||'일'
   from EMP; 
select ENAME, to_char( HIREDATE, 'YEAR-MM-DD' )from EMP;  
alter session set NLS_LANGUAGE='KOREAN';
select ENAME, to_char( HIREDATE, 'YEAR-MM-DD' )from EMP; 
select ENAME, to_char(HIREDATE, '""YYYY'년 HIREDATE,'MM')||'월' to_char(HIREDATE,'DD')||'일'
   from EMP;
select ENAME, to_char(HIREDATE, '""YYYY"년 "MM"월 "DD"일"') from EMP;
select ENAME from EMP where length(ENAME)>=6;
select substr(ENAME, 1, 3) from EMP where length(ENAME)>6;
select substr(ENAME, 0, 3) from EMP where length(ENAME)>6;
select lower(ENAME) from EMP where length(ENAME)>6;
select substr(lower(ENAME),1,3) from EMP where length(ENAME)>=6;
select avg(SAL) "평균"
	from EMP where DEPTNO=10 group by DEPTNO;
select round(avg(SAL)) "평균", max(SAL) "최고", min(SAL) "최저", count(EMPNO) "인원수"
	from EMP where DEPTNO=10 group by DEPTNO;  
select DEPTNO, round(avg(SAL)) "평균", max(SAL) "최고", min(SAL) "최저", count(EMPNO) "인원수"
	from EMP group by DEPTNO order by DEPTNO;
select DEPTNO, JOB, count(JOB) "인원수"
	from EMP group by DEPTNO,JOB order by DEPTNO;  
select JOB, count(JOB) "인원수"
	from EMP Where count(JOB)>=4 group by DEPTNO,JOB order by DEPTNO;   
  select JOB, count(JOB) "인원수"
	from EMP having count(JOB)>=4 group by DEPTNO,JOB order by DEPTNO;  
  select DEPTNO, round(avg(SAL)) "평균월급", sum(SAL) "전체월급", max(SAL) "최고 월급", min(SAL) "최저 월급", 
	from EMP group by DEPTNO order by "평균";
  select DEPTNO, round(avg(SAL)) "평균월급", sum(SAL) "전체월급", max(SAL) "최고 월급", min(SAL) "최저 월급", 
	from EMP group by DEPTNO order by "평균월급";
  select DEPTNO, round(avg(SAL)) "평균월급", sum(SAL) "전체월급", max(SAL) "최고 월급", min(SAL) "최저 월급", 
	from EMP group by DEPTNO order by round(avg(SAL));
  select DEPTNO, round(avg(SAL)) "평균월급", sum(SAL) "전체월급", max(SAL) "최고 월급", min(SAL) "최저 월급" 
	from EMP group by DEPTNO order by round(avg(SAL));
  select DEPTNO, round(avg(SAL)) "평균월급", sum(SAL) "전체월급", max(SAL) "최고 월급", min(SAL) "최저 월급" 
	from EMP group by DEPTNO order by "평균월급" desc;
  select ENAME "이름", SAL "급여", COMM "커미션 금액", SAL+COMM "총액" 
	from EMP 
	where COMM is not null order by "총액" desc;
  select ENAME "이름", SAL "급여", SAL*0.13 "보너스금액", DEPTNO "부서번호" 
	 from EMP 
	 where DEPTNO =10;
   select ENAME "이름", DEPTNO "부서번호", SAL "급여", SAL*SAL*1.5 "연봉" 
	from EMP 
	where DEPTNO =30;
  select ENAME "이름", SAL "급여", round(SAL/12/5) "시간당 임금" 
	from EMP 
	where DEPTNO =20;
  select ENAME "이름", SAL "급여", round(SAL*0.15,1) "회비" 
	from EMP 
	where SAL between 1500 and 3000;
  select ENAME "이름", SAL "급여", floor(SAL*0.15) "경조비" 
	from EMP 
	where SAL > 2000;
  select DEPTNO "부서 번호", ENAME "이름", HIREDATE "입사일", SYSDATE "현재일", 
	trunc(SYSDATE-HIREDATE+1)"근무일수", 
	round(MONTHS_BETWEEN(SYSDATE, HIREDATE)/12) "근무년수", 
	round(MONTHS_BETWEEN(SYSDATE, HIREDATE))"근무월수",
	round((SYSDATE-HIREDATE+1)/7) "근무주수" 
	from EMP;
  select ENAME, SAL, SAL-SAL*0.1 "실수령액" 
	from EMP order by SAL desc;
  select ENAME, HIREDATE, add_months(HIREDATE,3) "90일 후의 날", 
	SAL "급여", SAL*3 "그동안 받은 급여" 
	from EMP;
  select HIREDATE, add_months(HIREDATE,6) "6개월 후", SAL "급여", SAL*6 "그동안 받은 급여" 
	from EMP;
  select ENAME "이름",   HIREDATE "입사일", 
	last_day(HIREDATE)- HIREDATE "입사한 달의 근무일수" ,DEPTNO "부서번호"
	from EMP;
  select ENAME, HIREDATE, next_day(add_months(HIREDATE,3),2) "MONDAY" 
	from EMP;
  select ENAME "이름", HIREDATE "입사일", round(SYSDATE-HIREDATE+1) 
	from EMP;
  select ENAME, to_char(HIREDATE, '""YYYY"년 "MM"월 "DD"일"') 
	from EMP;
   select substr(lower(ENAME),1,3) 
	from EMP 
	where length(ENAME)>=6;
  select round(avg(SAL)) "평균", max(SAL) "최고", min(SAL) "최저", count(EMPNO) "인원수"
	from EMP 
	where DEPTNO=10 group by DEPTNO;
  select DEPTNO, round(avg(SAL)) "평균", max(SAL) "최고", min(SAL) "최저", count(EMPNO) "인원수"
	from EMP group by DEPTNO 
	order by DEPTNO;
  select DEPTNO, JOB, count(JOB) "인원수"
	from EMP group by DEPTNO,JOB 
	order by DEPTNO;
  select JOB, count(JOB) "인원수"
	from EMP having count(JOB)>=4 group by DEPTNO,JOB 
	order by DEPTNO;  
  select DEPTNO, round(avg(SAL)) "평균월급", sum(SAL) "전체월급", 
	max(SAL) "최고 월급", min(SAL) "최저 월급" 
	from EMP group by DEPTNO 
	order by "평균월급" desc;
   