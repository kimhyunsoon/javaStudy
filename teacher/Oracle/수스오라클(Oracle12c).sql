< 오라클 12c > 

[ Part1 : 설치 및 접근 ]

1. 오라클 설치( 12c )
   (1) 디렉토리 이름이 '한글'이면 X
       1) Oracle 설치파일이 존재하는 경로에 한글X
       2) Oracle 설치경로에 한글X

   (2) 디렉토리에 '공백'이 있으면 X
       1) Oracle 설치 파일이 존재하는 경로에 공백X
       2) Oracle 설치 경로에 공백X

   (3) Windows 계정이 한글 이름이면 X     
   
   (4) 설치시에 에러 해결 방법 
       1) OS부터 밀고 다시 설치 
       2) Oracle 를 다시 설치 
          <1> 제어판 -> 프로그램 추가제거 -> 관련 프로그램 제거
	  <2> 관리도구 -> 서비스 -> 오라클 관련 서비스들을 정지
	  <3> Oracle 설치 디렉토리를 삭제
	     (만약, 삭제 안되면 '안전모드'에서 삭제 )
	  <4> 시작 -> 모든 프로그램에서 -> Oracle관련 메뉴 삭제 
	  <5> 실행 -> regedit -> oracle관련 파일을 모두 제거 
	  <6> 다시 설치

    cf) SID: JAVA 
        PWD: java1234

2. 오라클 접근 
   (1) 개발개정(scott) 활성화 
      1) 실행창(Win + R)
         <방법1> sqlplus / as sysdba
	 <방법2> sqlplus sys/java1234 as sysdba

      2) scott / tiger 계정 생성 
         <방법1> alter session set "_oracle_script"=true;   
                create user scott identified by tiger;

         (참고1) create user c##scott identified by tiger;
	 (참고2) 계정삭제 
	        drop user scott cascade;

      3) 권한부여 
         grant connect, resource, unlimited tablespace to scott; 

	 <참고>권한뺏기 
         revoke connect, resource, unlimited tablespace from scott; 
      
      4) scott접속 
         conn scott/tiger
	 select * from tab;

      5) 테이블생성 / 데이터입력  
         탐색기( C:\app\kosmo\virtual\product 에서 ) -> 파일찾기 
	   -> scott.sql열어서 -> 복사 실행 (line 28~96) 
         
	 <결과> C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin\scott.sql

      6) 테이블/데이터 생성 확인
         select * from tab;
	 select * from EMP;
         select * from DEPT;
	 
      7) 검색 예쁘게 
         set linesize 120;

      8) 세션 나오기 
         exit;

    
   (2) 오라클 접근법 
      1) sqlplus 법 
         실행 > sqlplus scott/tiger 

      2) utility 법 
         <1> sqlgate
	 <2> toad 
	 <3> orange 
	 <4> sql developer ( by Oracle ) 공짜 
	     .....

       
[ Part2 : Oracle 개요 ]
1. DBMS ( DataBase Management System )의 개념 
   (1) DB ( DataBase )
       - 지속적으로 유지 관리해야 할 '데이터의 집합' 

   (2) DBMS
       - DB를 효율적으로 관리하고, 효율적으로 저장하고
         검색할 수 있는 환경을 제공해 주는 '시스템 소프트웨어'   
	 ( ex: Oracle, MySql, Ms-sql, Maria, Db2, 사이베이스, ... )

2. DBMS 역사 
   (1) 1960 : File System
   (2) 1970 : Network-DBMS 
   (3) 1980 : 관계형-DBMS ( RDBMS )
   (4) 1990 : 관계형-DBMS, 객체관계형( ORDBMS )
   (5) 2000 : 관계형/객체관계형/객체지향  

       ex) oracle 6.X, 7.X -> 관계형 
           oracle 8.X, 11.X, 12c.X -> 객체관계형 

3. 데이터베이스 설계
   실세계(업무분석)  -> '개'념적 모델링  -> '논'리적 모델링 -> '물'리적 모델링 -> SQL작성 
                  (Entity/Attribute)  (ERD생성)    ( 구체적인 DBMS결정)

4. SQL ( Structured Query Language )

5. 기본 계정 
   (1) SYS
       오라클 super 사용자 ID이며, 데이터베이스에서 발생하는 
        '모든 문제'를 처리할 수 있는 권한    

   (2) SYSTEM 
       SYS과 같은데, 차이는 데이터베이스를 생성할 수 있는 
       권한이 없음 

   (3) SCOTT 
       처음 오라클을 사용하는 user들을 위한 SAMPLE 계정이며, 
       일반적으로 프로젝트를 구현할 때 사용하는 권한( for Developer )을 가진 계정

6. 주요 용어 
   (1) TABLE 
       관계형 DBMS에서 기본 데이터 저장 구조로써 'Entity(실체)'의 
       집합 저장소 ( ex: DEPT, EMP, SALGRADE, BONUS, ... ) 

   (2) ROW 
       테이블의 행 ( 하나의 유효한 데이터 ) 즉, Entity(실체)
       (ex : 10 ACCOUNTING     NEW YORK  )

   (3) COLUMN 
       테이블의 열명 ( Attibute 가 COLUMN이 됨 ) 
       (ex : DEPTNO,  DNAME, LOC )

   (4) FIELD 
       테이블에서 ROW와 COLUMN이 교차하는 데이터 

   (5) NULL
       데이터가 존재하지 않는 FIELD

   (6) PRIMARY-KEY
       테이블에서 각 ROW를 유일하게 구분하는 COLUMN 에 
       부여되는 '제약조건( Constraint )'

   (7) FOREIGN-KEY ( == 참조키, 외래키 )   
       부모테이블의 COLUMN값을 참조하는 테이블의 COLUMN에 
       부여되는 '제약조건( Constraint )' 

   (8) 무결성 : 데이터가 논리적으로 결함이 없는 성질 

    
7. SQL의 구분 
   (1) DQL( Data Query Language ) : 조회 
       ( ex: select ~ )
   (2) DML( Data Manipulation Language ) : 조작 
       ( ex: insert~,  update~,  delete~ )
   (3) TCL ( Transaction Control Language ): 트랜젝션 
       ( ex: commit, rollback, savepoint )
   (4) DDL ( Data Definition Language ) : 정의 
       ( ex: create~, alter~, drop~ , ..) 
   (5) DCL ( Data Control Language ) : 권한 
       ( ex: grant~, revoke~ )

8. PL-SQL
   제어문(조건문, 반복문)이 들어있는 SQL로써 오라클 DBMS에서 지원하는 확장된 SQL 
   (1) Stored Procedure
       -> 일련의 작업처리순서를 정의해 놓은 것으로 
         미리 DBMS에 컴파일되어져있어 프로그램 or 사용자로부터 
	 호출되면 실행되는 일종의 '작업처리순서' 
   (2) Anonymous Procedure 
       -> Stored Procedure 와의 차이점은 'DBMS에 자동으로 포함'되어 
         내부적으로 호출되는 프로시져 
   (3) Stored Function 
       -> 프로시져와 차이점은 'return값'이 존재해야 함 
   (4) Trigger 
       -> 어떤 조건에 만족되어지는 상황(DML)이 발생되면 
         자동으로 호출되어 작동되는 로직 
   (5) Package 
       -> 위의 것들을 기능별 묶어놓은 꾸러미 

[ Part3 : SQL ]
1. DQL
   #1 Base 
   (1) 기본 
       SQL> select TNAME from tab; 
       SQL> select TABLE_NAME from user_tables;
       SQL> desc DEPT
       SQL> select * from DEPT;
       SQL> select DEPTNO, DNAME from DEPT;

   (2) all / distinct
       SQL> select JOB from emp;
       SQL> select all JOB from emp;
       SQL> select distinct JOB from emp;

   (3) order by
       -- 모든 사원 사번과 급여 출력 
       SQL> select EMPNO, SAL from EMP;
       SQL> select EMPNO, SAL from EMP order by SAL; -- asc 
       SQL> select EMPNO, SAL from EMP order by SAL desc; -- desc
       -- 모든 사원의 사번과 급여를 출력 ( 급여가 높은 순, 같은 급여일 땐 EMPNO 오름차순 )
       SQL> select EMPNO, SAL from EMP order by SAL desc, EMPNO;

       -- 모든 사원의 사번과 커미션을 출력( 커미션 낮/높 순 )
       SQL> select EMPNO, COMM from EMP order by COMM; --null 뒤로 
       SQL> select EMPNO, COMM from EMP order by COMM desc; --null 앞으로 
       
       -- (null 제외한) 모든 사원의 사번과 커미션을 출력
       SQL> select EMPNO, COMM from EMP where COMM is not null 
            order by COMM desc;

       -- JOB에 대해서 오름차순 정렬한 후, 급여(SAL)가 높은 순으로 정렬
       SQL> select JOB, SAL from EMP order by JOB, SAL desc;

   (4) Alias 
       SQL> select JOB "직업", SAL "급여" from EMP; --추천
       SQL> select JOB as "직업", SAL as "급여" from EMP;
       SQL> select JOB 직업, SAL 급여 from EMP;
       SQL> select JOB 직업, SAL "1234" from EMP;
       SQL> select JOB 직업, SAL "!@#$" from EMP;
       SQL> select JOB 직업, SAL "급 여" from EMP;

       cf) 숫자 or 특수문자 or 공백포함 되면 ""로 묶어줘야 함 

   (5) where     
     -- 부서번호가 20인 사원의 사번과 부서번호를 출력
     SQL> select EMPNO, DEPTNO from EMP where DEPTNO=20;
       
     -- 30번 부서인 부서번호와 급여와 사번을 출력하라(단, 급여가 높으로 순)
     SQL> select EMPNO, DEPTNO, SAL from EMP 
          where DEPTNO=30 order by SAL desc;

     -- 입사일이 81년 12월 3일 이후의 사번과 이름과 입사일과 부서번호 출력 (단, 사번의 내림차순)
     SQL> select EMPNO, ENAME, HIREDATE, DEPTNO from EMP
        where HIREDATE>='81/12/3' order by EMPNO desc;
   
     -- 입사일이 81년 12월 3일이후의 사번과 이름과 입사일과 부서번호 출력(단.. 사번의 내림차순, 20번부서만 출력)
     SQL> select EMPNO, ENAME, HIREDATE, DEPTNO from EMP 
        where HIREDATE>='81/12/03' and DEPTNO=20 order by EMPNO desc;

  (6) 연산자( Operator )
     1) 산술연산자 ( + , -, * , / )
        --30번 부서 사원의 급여를 10% 인상해서 사번(EMPNO)과 급여(SAL)를 출력
        SQL> select EMPNO, SAL*1.1 from EMP where DEPTNO=30;

	--30번 부서 사원의 '연말보너스'를 이름과 연말보너스를 출력(연말보너스가 높은 순) 
        -- ( 단, 연말보너스는 급여의 2배와 커미션의 1/2의 합이다.)
	SQL> select ENAME, SAL, COMM from EMP where DEPTNO=30;
	SQL> select ENAME, SAL, NVL(COMM, 0) from EMP where DEPTNO=30;
	SQL> select ENAME, SAL*2+NVL(COMM, 0)/2 "연말보너스" from EMP where DEPTNO=30 order by "연말보너스" desc;

     2) 비교연산자 ( =, !=, >, >=, <, <= )
	-- 급여가 950인 사원의 이름(ENAME)과 급여(SAL)를 출력
	SQL> select ENAME, SAL from EMP where SAL=950;

	-- 급여가 3000 이상인 사원의 이름(ENAME)과 급여(SAL)를 출력
	SQL> select ENAME, SAL from EMP where SAL>=3000;

	-- 30부서가 아닌 사원의 이름(ENAME)과 급여(SAL)와 부서번호(DEPTNO)를 출력
	   -- ( 부서번호의 오름차순, 높은 급여순, 이름 오름차순 )
	SQL> select ENAME, SAL, DEPTNO from EMP where DEPTNO!=30
	    order by DEPTNO, SAL desc, ENAME;

     3) 논리연산자 ( and(곱), or(합), not ) 
	-- 20번 부서이면서 급여 3000이상인 사원의 이름, 급여, 부서번호를 출력
	SQL> select ENAME, SAL, DEPTNO
	     from EMP
	     where DEPTNO=20 and SAL >= 3000;

	-- 직업이 'SALESMAN'이고 부서번호가 30번인 이름, 직업, 부서번호를 출력
	SQL> select ENAME, JOB, DEPTNO
             from EMP
             where JOB='SALESMAN' and DEPTNO=30; 

	-- 급여가 1000 미만이거나, 4000 이상인 사원의 사번, 급여를 출력
        SQL> select EMPNO, SAL from EMP where SAL<1000 or SAL>=4000;
	SQL> select EMPNO, SAL from EMP where not (SAL>=1000 and SAL<4000);


     4) SQL연산자( in , any, all , between , like , is null , is not null , exists )   
	-- 부서번호가 10 or 20 or 100 인 사원의 부서번호과 이름을 출력
        SQL> select ENAME, DEPTNO from EMP where DEPTNO=10 or DEPTNO=20 or DEPTNO=100;
        SQL> select ENAME, DEPTNO from EMP where DEPTNO in(10, 20, 100);
	SQL> select ENAME, DEPTNO from EMP where DEPTNO=any(10, 20, 100);	

	-- 30부서의 최대 급여보다 더 큰 급여를 받는 사원의 이름, 급여 출력
	SQL> select ENAME, SAL from EMP where DEPTNO=30;
        SQL> select ENAME, SAL from EMP where SAL>all(select SAL from EMP where DEPTNO=30);
	     
	    cf) all은 전체값을 모두 만족해야만 true 가 됨 
	
        -- 급여가 1250 이상 3000 이하인 사원의 이름과 급여 출력
	SQL> select ENAME, SAL from EMP where SAL>=1250 and SAL<=3000;
	SQL> select ENAME, SAL from EMP where SAL between 1250 and 3000;

        -- 이름이 'FORD'와 'KING' 사이의 사원 이름을 출력!(단, 알파벳 순 정렬) 
	SQL> select ENAME from EMP where ENAME>='FORD' and ENAME<='KING' order by ENAME;
	SQL> select ENAME from EMP where ENAME between 'FORD' and 'KING' order by ENAME;

        -- 이름이 'J'로 시작되는 사원 이름을 출력(단, 오름차순 정렬)
        SQL> select ENAME from EMP where ENAME like 'J%' order by ENAME;

	-- 이름에 'T'로 시작되는 사원 이름을 출력
	SQL> select ENAME from EMP where ENAME like '%T%';

	-- 이름에 세번째 문자가 'A'인 사원의 이름을 출력
        SQL> select ENAME from EMP where ENAME like '__A%' order by ename;

	-- 급여의 십의 자리가 5인 사원의 급여를 출력
	SQL> select SAL from EMP where SAL like '%5_';

	-- 커미션이 NULL인 사원의 사번과 커미션을 출력
	SQL> select EMPNO, COMM from EMP where COMM is null;

	-- 커미션이 NULL이 아닌 사원의 사번과 커미션을 출력
	SQL> select EMPNO, COMM from EMP where COMM is not null;

        -- 이름이 'FORD'라는 사원이 존재하면 모든 사원의 이름을 출력
	SQL> select ENAME from EMP where ENAME='FORD';
	SQL> select ENAME from EMP where exists(select ENAME from EMP where ENAME='FORD'); 

	-- 이름이 'ford'라는 사원이 존재하면 모든 사원의 이름을 출력
	SQL> select ENAME from EMP where ENAME='ford';
	SQL> select ENAME from EMP where exists(select ENAME from EMP where ENAME='ford'); 
	
     5) 결합연산자 ( || )
        --SMITH의 급여는 800입니다
        SQL> select ENAME||'의 급여는 ', SAL||'입니다' from EMP;

     6) 집합연산자( union(합), union all, intersect(교), minus(차) )
        -- 사원의 사번과 이름 출력하고, 부서의 번호와 부서이름을 출력
	SQL> select EMPNO, ENAME from EMP;
	SQL> select DEPTNO, DNAME from DEPT;

	SQL> select EMPNO, ENAME from EMP
	      union
	     select DEPTNO, DNAME from DEPT;

        -- 사원의 사번과 이름 출력하고, 사원의 사번과 이름 출력 
        SQL> select EMPNO, ENAME from EMP;
        SQL> select EMPNO, ENAME from EMP;

        SQL> select EMPNO, ENAME from EMP
	      union
	     select EMPNO, ENAME from EMP;
        SQL> select EMPNO, ENAME from EMP
	      union all
	     select EMPNO, ENAME from EMP;

        -- 교집합 
	SQL> select EMPNO, ENAME from EMP
	      intersect
	     select DEPTNO, DNAME from DEPT; --0개 
	SQL> select EMPNO, ENAME from EMP
	      intersect
	     select EMPNO, ENAME from EMP where ENAME='FORD'; --1개 

        -- 차집합 
	SQL> select EMPNO, ENAME from EMP
	      minus
	     select EMPNO, ENAME from EMP where ENAME='FORD'; --11개

     cf) 연산자 우선 순위  
        <1> 1순위: 비교, SQL, 산술 
	<2> 2순위: not 
	<3> 3순위: and 
	<4> 4순위: or 
	<5> 5순위: ||, 집합

	SQL> select ENAME, SAL from EMP
	    where NOT SAL>1000 and SAL<3000;

	SQL> select ENAME, SAL from EMP
	    where NOT (SAL>1000 and SAL<3000);


///////////////////// 문제 1 /////////////////////////////////////// 
-- 최대 급여를 받는 사원의 이름을 출력 
-- SQL> select ENAME from EMP where SAL=(select max(SAL) from EMP); 

   #2 Function 
   (1) 함수(function)란 ? (처리/반환)
       어떠한 일을 수행하는 기능으로써 주어진 인수(argument)를 
        재료로 '처리'하여 그 결과를 '반환'하는 일

   (2) 기능 기준 분류 
       1) Data 계산 
       2) Data 변환 

   (3) 종류 
       1) 단일행 함수 (ex: nvl, ... )
           -> 하나의 행(row)당, 하나의 결과값을 리턴하는 함수 
       2) 복수행 함수 (ex: max, min, avg, .. )   
           -> 여러개의 행(row)당, 하나의 결과값을 리턴하는 함수

   (4) 단일행 함수
       1) 문자 함수 
          <1> chr(아스키코드)
	     SQL> select chr(65) from DUAL;

          <2> concat(컬럼명, '붙일문자열')
	     SQL> select ENAME||' is a ' || JOB from EMP;
	     SQL> select concat(ENAME, ' is a '), JOB from EMP; 

	  <3> initcap('문자열')
	     SQL> select initcap('the lion') from DUAL;

	  <4> lower('문자열') 
	     SQL> select lower('MY NAME IS KHS') from dual;
	     SQL> select lower(ENAME) from EMP;

	  <5> lpad('문자열1', 자리수, '문자열2')
	     SQL> select lpad('khs', 13, '*#') from DUAL;

	     설명) lpad("대상문자열", "총 문자길이", "채움문자")

	  <6> rpad('문자열1', 자리수, '문자열2')
	     SQL> select rpad('khs', 13, '*#') from DUAL;

	     설명) rpad("대상문자열", "총 문자길이", "채움문자")

	 <7> ltrim('문자열1', '문자열2') 
	     SQL> select ltrim('xyxXxyLAST WORDxy', 'xy') from DUAL;     
	     SQL> select ltrim('xyyXxyLAST WORDxy', 'xy') from DUAL;
	     SQL> select ltrim('xyyXxyLAST WORDxy', 'yx') from DUAL;
	     SQL> select ltrim('     LAST WORDxy', ' ') from DUAL;

	 <8> rtrim('문자열1', '문자열2') 
	     SQL> select rtrim('xyxXxyLAST WORDxy', 'xy') from DUAL;     
	     SQL> select rtrim('xyyXxyLAST WORDxyx', 'xy') from DUAL;
	     SQL> select rtrim('WORDxy   ', ' ') from DUAL;
	     SQL> select rtrim('WORDxy   ') from DUAL;
	     SQL> select length(rtrim('WORDxy   ')) from DUAL;

         <9> replace('문자열1', '문자열2', '문자열3')
	     SQL> select 'JACK and JUE' from DUAL;
	     SQL> select replace('JACK and JUE', 'J', 'BL') from DUAL;
	     SQL> select DNAME from DEPT;
	     SQL> select replace(DNAME, 'A', 'a') from DEPT;

	 <10> substr('문자열', 자리수, 갯수)
	     SQL> select substr('ABCDEFG', 3, 2) from DUAL;

	     -- ename의 두번째 자리가 'A'인 사원의 이름을 출력
	     SQL> select ENAME from EMP where ENAME like '_A%';
	     SQL> select ENAME from EMP where substr(ENAME, 2, 1)='A';

	 <11> ascii('문자')
	     SQL> select ascii('A') from dual;
	     SQL> select ascii('"') from DUAL;
	     SQL> select ascii(' ') from DUAL;
	     SQL> select ascii('#') from DUAL;
	     SQL> select ascii('3') from DUAL;

	 <12> length('문자열')
	     SQL> select length('진달래 꽃') from DUAL; 
	     SQL> select length('abc D') from DUAL;

	 <13> greatest('문자열1', '문자열2', '문자열3')
	     SQL> select greatest('CC', 'ABCDE', 'CA') from DUAL;
	     SQL> select greatest('12', '132', '119') from DUAL;
	     SQL> select greatest('가나', '가다', '가자') from DUAL; 

	 <14> least('문자열1', '문자열2', '문자열3')
	     SQL> select least('CC', 'ABCDE', 'CA') from DUAL; 
             SQL> select least('12', '132', '119') from DUAL;
             SQL> select least('가나', '가다', '가자') from DUAL;

	 <15> instr('문자열1', '문자열2', 자리수1, 자리수2)
	     SQL> select instr('CORPORATE FLOOR', 'OR', 3, 2) from DUAL;
	     SQL> select instr('CORPORATE FLOOR', 'OR', 6, 1) from DUAL;

	    cf) '문자열1'에서 '문자열2'를 찾는데.. '자리수1'부터 '자리수2'번째 것을 찾아 인덱스 리턴 

	 <16> nvl(컬럼명, 숫자) ** 
	     SQL> select ENAME, nvl(COMM, 100) from EMP; 
	     SQL> select ENAME, nvl(COMM, 0) from EMP; 

      2) 숫자 함수
	<1> abs(숫자)  
	    SQL> select abs(-10) from dual;
	
        <2> ceil(숫자) 
	    SQL> select ceil(11.012) from dual;
	    SQL> select ceil(-11.012) from dual;

        <3> floor(숫자)
	    SQL> select floor(12.999) from dual;
	    SQL> select floor(-12.999) from dual;

 	<4> round(숫자)
	    SQL> select round(12.5) from dual;
	    SQL> select round(-12.5) from dual;  
	    
	<5> cos(숫자[rad])
	    SQL> select cos(90* 3.141592/180) from dual;

        <6> sin(숫자[rad]) 
	    SQL> select sin(90* 3.141592/180) from dual;

	<7> tan(숫자[rad])
	    SQL> select sin(45* 3.141592/180) from dual;

        <8> exp(숫자)
	   SQL> select exp(2) from dual;

	<9> log(숫자1, 숫자2)
	   SQL> select log(10, 100) from dual;

	<10> mod(숫자1, 숫자2)
	   SQL> select mod(11, 4) from dual;
	
	<11> power(숫자1, 숫자2)
	   SQL> select power(3, 3) from dual;

	<12> trunc(숫자1, 숫자2)
	   SQL> select trunc(15.789, 2) from DUAL;
	   SQL> select trunc(15.789, 0) from DUAL;
	   SQL> select trunc(15.789) from DUAL;
	   SQL> select trunc(-15.789, 2) from DUAL;

     3) 날짜 함수 (***)
        <1> SYSDATE
	    SQL> select SYSDATE from DUAL; 
	<2> add_months(날짜컬럼 or 날짜데이터, 숫자)
	    SQL> select HIREDATE from EMP where EMPNO=7782;
	    SQL> select HIREDATE, add_months(HIREDATE, 7) from EMP where EMPNO=7782;
	<3> last_day(날짜컬럼 or 날짜데이터) 
	    SQL> select last_day('21/6/14') from dual;
	    SQL> select HIREDATE, last_day(HIREDATE) from EMP;
        <4> months_between(날짜컬럼or날짜데이터1, 날짜컬럼or날짜데이터2)
	    SQL> select MONTHS_BETWEEN('80/01/02', '81/02/04') from DUAL; 
	    -- empno가 7782인 사원의 현재까지의 근무월수
	    SQL> select MONTHS_BETWEEN(SYSDATE, HIREDATE) from EMP where EMPNO=7782;
	<5> next_day(날짜컬럼or날짜데이터, 숫자)
	    SQL> select SYSDATE, NEXT_DAY(SYSDATE,4) from DUAL;
	    SQL> select SYSDATE, NEXT_DAY(SYSDATE,1) from DUAL;
	    SQL> select SYSDATE, NEXT_DAY(SYSDATE,3) from DUAL;
	    -- 일(1) 월(2) 화(3) 수(4) 목(5) 금(6) 토(7)

     4) 문자 변환 함수 ( ***** )
         => to_char(날짜컬럼or날짜데이터, '변환포멧')

	<1> 'D' 
	    SQL> select SYSDATE, to_char(SYSDATE, 'D') from DUAL; --요일의 index 
	<2> 'DAY'
	    SQL> select SYSDATE, to_char(SYSDATE, 'DAY') from DUAL; 
	<3> 'DY'
	    SQL> select SYSDATE, to_char(SYSDATE, 'DY') from DUAL; 
	<4> 'DD'
	    SQL> select SYSDATE, to_char(SYSDATE, 'DD') from DUAL; --날짜 
	<5> 'MM'
	    SQL> select SYSDATE, to_char(SYSDATE, 'MM') from DUAL; 
	<6> 'MON'
	    SQL> select SYSDATE, to_char(SYSDATE, 'MON') from DUAL; 
	    SQL> select SYSDATE, to_char(SYSDATE, 'MONTH') from DUAL; 
	<7> 'YY'
	    SQL> select SYSDATE, to_char(SYSDATE, 'YY') from DUAL; 
	<8> 'YYYY'
	    SQL> select SYSDATE, to_char(SYSDATE, 'YYYY') from DUAL; --빈도높음
	    SQL> select SYSDATE, to_char(SYSDATE, 'YEAR') from DUAL; 
        <9> 'MM-DD-YY'
	    SQL> select SYSDATE, to_char(SYSDATE, 'MM-DD-YY') from DUAL; 
	<10> 'HH' or 'HH12'
	    SQL> select SYSDATE, to_char(SYSDATE, 'HH') from DUAL; 
	<11> 'HH24'
	    SQL> select SYSDATE, to_char(SYSDATE, 'HH24') from DUAL; 
	<12> 'MI'
	    SQL> select SYSDATE, to_char(SYSDATE, 'MI') from DUAL;
	<13> 'SS'
	    SQL> select SYSDATE, to_char(SYSDATE, 'SS') from DUAL;
        <14> 'AM' or 'PM'
	    SQL> select SYSDATE, to_char(SYSDATE, 'AM HH:MI:SS') from DUAL; --선호 
	    SQL> select SYSDATE, to_char(SYSDATE, 'fmAM HH:MI:SS') from DUAL;

	    --현재날짜를 '2021-06-14 오후 12:15:55 월요일' 식으로 출력
	<15> 'YYYY-MM-DD AM HH:MI:SS DAY'
	    SQL> select SYSDATE, to_char(SYSDATE, 'YYYY-MM-DD AM HH:MI:SS DAY') from dual;

	    cf) alter session set NLS_LANGUAGE='ENGLISH';

	    cf) Tip 
	        - one, two, three ..
		  SQL> select to_char(SYSDATE, 'DDSP') from DUAL;
	        - simple 서수  
		  SQL> select to_char(SYSDATE, 'DDTH') from DUAL; 
	        - 서수  
		  SQL> select to_char(SYSDATE, 'DDSPTH') from DUAL; 

   (5) 복수행 함수 ( group function ***** )	 
       1) count(컬럼명)
          SQL> select count(ENAME) from EMP;
	  SQL> select count(COMM) from EMP; --null은 세지 않음 
	  SQL> select count(*) from EMP; 
	  SQL> select count(EMPNO) from EMP; 

       2) sum(컬럼명)
	  SQL> select sum(SAL) from EMP;
	  SQL> select sum(COMM) from EMP;

       3) avg(컬럼명)
          SQL> select avg(SAL) from EMP;
	  SQL> select avg(COMM) from EMP; --null은 세지 않음 
	  SQL> select avg(nvl(COMM, 0)) from EMP;

       4) max(컬럼명) 과 min(컬럼명)
          SQL> select max(SAL) from EMP;
	  SQL> select min(SAL) from EMP;
	  SQL> select max(SAL)-min(SAL) from EMP;

	  -- 최저 급여자의 사원이름과 급여를 출력
          SQL> select ENAME, SAL from EMP where SAL=min(SAL);--(X) 그룹함수는 where절에 사용불가!
	  SQL> select ENAME, SAL from EMP where SAL=(select min(SAL) from EMP);

       5) variance(컬럼명)  
          SQL> select variance(COMM) from EMP;

       6) stddev(컬럼명) 
          SQL> select stddev(COMM) from EMP;


     < Question > 
     -- 부서별 평균연봉을 출력(*)
     Err> select DEPTNO, avg(SAL) from EMP;
     SQL1> select DEPTNO from EMP group by DEPTNO;
     SQL2> select DEPTNO, avg(SAL) from EMP group by DEPTNO;
     SQL3> select DEPTNO, round(avg(SAL)) from EMP group by DEPTNO;
     SQL> select avg(DEPTNO), avg(SAL) from EMP where DEPTNO=10
           union 
          select avg(DEPTNO), avg(SAL) from EMP where DEPTNO=20
	   union
          select avg(DEPTNO), avg(SAL) from EMP where DEPTNO=30;

     -- 급여 2000 이상인 사원들의 부서별 평균급여의 반올림값
     SQL> select DEPTNO, round(avg(SAL)) from EMP 
          where SAL>=2000 group by DEPTNO;
    
     -- 급여 2000 이상인 사원들의 부서별 평균급여의 반올림값 ( 부서번호의 오름차순 정렬 )
     SQL> select DEPTNO, round(avg(SAL)) from EMP 
          where SAL>=2000 group by DEPTNO order by DEPTNO;
 
     --급여 2000 이상인 사원들의 부서별 평균급여의 반올림값 (급여가 높은 순 정렬)
     SQL> select DEPTNO, round(avg(SAL)) from EMP 
          where SAL>=2000 group by DEPTNO order by round(avg(SAL)) desc;
     SQL> select DEPTNO, round(avg(SAL)) aa from EMP 
          where SAL>=2000 group by DEPTNO order by aa desc; 
     SQL> select DEPTNO, round(avg(SAL)) from EMP 
          where SAL>=2000 group by DEPTNO order by 2 desc;

     --급여 1000이상인 사원들의 부서별 평균급여의 반올림값을 부서번호로 내림차순 정렬하라
	   -- ( 단, 부서별 평균급여가 2000 이상인 값만 출력! )
     SQL> select DEPTNO, round(avg(SAL)) from EMP
          where SAL>=1000
	  group by DEPTNO
	  having round(avg(SAL)) >= 2000
	  order by DEPTNO desc;

     Err> select DEPTNO, round(avg(SAL)) aa from EMP
          where SAL>=1000
	  group by DEPTNO
	  having aa >= 2000
	  order by DEPTNO desc; -- 주의: having절에는 alias 사용 불가!

     --급여 1000이상인 사원들의 부서별 평균급여의 반올림값을 부서번호로 내림차순 정렬하라
	     --(단, 부서번호가 20이상인 값만 출력!) 
     SQL> select DEPTNO,round(avg(SAL)) from EMP 
          where SAL>=1000 
          group by DEPTNO 
          having DEPTNO>=20 
          order by DEPTNO desc;
  
     SQL> select DEPTNO,round(avg(SAL)) from EMP 
          where SAL>=1000 
          group by DEPTNO 
          having DEPTNO>20 or DEPTNO=20 --여러개 조건 가능 
          order by DEPTNO desc;

     SQL> select DEPTNO,round(avg(SAL)) from EMP 
          where SAL>=1000 and DEPTNO>=20
          group by DEPTNO 
          order by DEPTNO desc;

     --각 부서별 같은 업무를 하는 사원의 인원수를 구하여 부서번호, 업무명, 인원수를 출력하라
	 --(단, 부서번호과 업무명으로 각각 내림차순 정렬!) 
     SQL> select DEPTNO, JOB, count(EMPNO) from EMP
          group by DEPTNO, JOB
	  order by DEPTNO desc, JOB desc; 

     < 일반화 >
     [1] 순서 ( SF-WGHO )
         select -> from -> where -> group by -> having -> order by 
     [2] 그룹함수는 where절에 사용 불가!
     [3] having절에는 alias 사용 불가!
    
/////////////////////////  문제2 (22_SQL2/teacher) ////////////////////////


-- 사원번호와 부서이름을 출력하라.
   #3 Join & SubQuery 
   (1) 조인( Join )   
      1) 설명 
          하나의 테이블로는 원하는 컬럼정보를 가져올 수 없는 경우,
	  관련된 테이블을 '논리적으로 결합'하여 원하는 컬럼정보를 가져오는 방법

      2) 조건 
          논리적으로 결합되는 2개 이상의 테이블에는 반드시 '공통컬럼'이 존재해야하며 
	  이 공통컬럼은 동일한 데이터 타입과 공통 데이터를 의미해야 함 
	   
      3) 예 -- 사원번호와 부서이름을 출력
          SQL> select EMP.EMPNO, DEPT.DNAME from EMP, DEPT where EMP.DEPTNO=DEPT.DEPTNO; --형태1
	  SQL> select e.EMPNO, d.DNAME from EMP e, DEPT d where e.DEPTNO=d.DEPTNO; --형태2
	  SQL> select e.EMPNO, d.DNAME from EMP e join DEPT d on e.DEPTNO=d.DEPTNO; --형태3
	  SQL> select e.EMPNO, d.DNAME from EMP e join DEPT d using(DEPTNO); --형태4
	  SQL> select EMPNO, DNAME from EMP join DEPT using(DEPTNO); --형태5
	  SQL> select EMPNO, DNAME from EMP natural join DEPT; --형태6

      4) 종류
          <1> Cross 조인 
	     2개 이상의 테이블이 조인될 때 'where절'에 의해 공통되는 컬럼에 의한 결합이 
	     '발생하지 않는 경우' 즉, 테이블 전체행의 전체컬럼이 조인에 사용되는
	     조인을 말한다 따라서, 모든 데이터가 검색결과가 됨 
	     SQL> select e.EMPNO, e.ENAME, d.DNAME from EMP e, DEPT d; -- where 절이 없는 경우 
	     SQL> select e.EMPNO, e.ENAME, s.GRADE from EMP e, SALGRADE s; -- 공통컬럼이 없는 경우 
	     SQL> select EMPNO, ENAME, GRADE from EMP, SALGRADE; -- 공통컬럼이 없는 경우 
	     
	  <2> Natural 조인 ( Equi 조인 ) : 가장 일반적 
	      where 절이 사용된 '공통컬럼'들이 동등 연산자(=)에 의해 비교되는 조인 

	      -- 사원번호와 부서이름을 출력 ( 단, 30번 부서만 )
	      1> 형태1 
	         SQL> select EMP.EMPNO, DEPT.DNAME from EMP, DEPT where EMP.DEPTNO=DEPT.DEPTNO; --형태1
		 SQL> select EMP.EMPNO, DEPT.DNAME from EMP, DEPT 
		      where EMP.DEPTNO=DEPT.DEPTNO and DEPT.DEPTNO=30;

              2> 형태2
	         SQL> select e.EMPNO, d.DNAME from EMP e, DEPT d where e.DEPTNO=d.DEPTNO; --형태2
                 SQL> select e.EMPNO, d.DNAME from EMP e, DEPT d 
		      where e.DEPTNO=d.DEPTNO and d.DEPTNO=30;

	      3> 형태3
                 SQL> select e.EMPNO, d.DNAME from EMP e join DEPT d on e.DEPTNO=d.DEPTNO;
		 SQL> select e.EMPNO, d.DNAME from EMP e join DEPT d 
		      on e.DEPTNO=d.DEPTNO
		      where d.DEPTNO=30;

	      4> 형태4
	         SQL> select e.EMPNO, d.DNAME from EMP e join DEPT d using(DEPTNO);
		 SQL> select e.EMPNO, d.DNAME from EMP e join DEPT d 
		      using(DEPTNO)
                      where DEPTNO=30;

	      5> 형태5
	         SQL> select EMPNO, DNAME from EMP join DEPT using(DEPTNO);
		 SQL> select EMPNO, DNAME from EMP join DEPT 
		      using(DEPTNO)
		      where DEPTNO=30;

	      6> 형태6
	         SQL> select EMPNO, DNAME from EMP natural join DEPT;
		 SQL> select EMPNO, DNAME from EMP natural join DEPT
		      where DEPTNO=30;

          <3> Self 조인 -- SMITH의 매니져는 FORD이다 
	     가져와야 할 컬럼이 '자신의 테이블에 있는 다른 컬럼'인 경우의 조인 
	      1> 형태1
	         SQL> select e.ENAME, m.ENAME from EMP e, EMP m where e.MGR = m.EMPNO;
		 SQL> select e.ENAME||'의 매니져는 ', m.ENAME||'이다' from EMP e, EMP m where e.MGR = m.EMPNO;
                 SQL> select e.ENAME||'의 매니져는 ', m.ENAME||'이다' from EMP e, EMP m 
		      where e.MGR = m.EMPNO and e.ENAME='SMITH';
              2> 형태2 
	         SQL> select e.ENAME, m.ENAME from EMP e join EMP m on e.MGR = m.EMPNO;
		 SQL> select e.ENAME, m.ENAME from EMP e join EMP m on e.MGR = m.EMPNO
		      where e.ENAME='SMITH';

          <4> Outer 조인
	     한쪽 테이블에는 해당하는 데이터가 존재하고, 
	     다른 쪽 테이블에는 데이터가 존재하지 않을 경우에 '기준 테이블'을 이용한 조인 
	      1> Left 
	         SQL> select T1.NO, T1.NAME, T2.NO, T2.NAME 
		      from T1 left outer join T2
                      on T1.NO = T2.NO;   
	      
	      2> Right 
	         SQL> select T1.NO, T1.NAME, T2.NO, T2.NAME 
		      from T1 right outer join T2
                      on T1.NO = T2.NO;  

	      3> Full 
	         SQL> select T1.NO, T1.NAME, T2.NO, T2.NAME 
		      from T1 full outer join T2
                      on T1.NO = T2.NO; 
	         
          <5> Inner 조인        
	    

	     cf) 일반화 : 배치와 실행순서 
	     - select XX      --------> 6
	     - from XX        --------> 1
	     - (join XX)      --------> 2
	     - where XX       --------> 3 
	     - group by XX    --------> 4 
	     - having XX      --------> 5
	     - order by XX    --------> 7

    
   (2) SubQuery
      1) 설명 
         하나의 select 문장에 포함된 또 다른 select 문장 
	  ( 두번 이상 질의를 해야 얻을 수 있는 결과를 한번의 질의로 통합한 쿼리 )

      2) 용어 
         <1> Main-Query or Outer-Query 
	 <2> Sub-Query or Inner-Query 
   
      3) 특징 
         <1> 괄호로 묶어야 함 
	 <2> 실생순서는 '대부분' Sub-Query 가 먼저 수행되고, Main-Query가 수행됨 
	 <3> SUB-QUERY는 MAIN-QUERY의 다음 부분에 위치된다.
	     - select/delete/update 문장의 from 절 / where 절 
	     - insert 문장의 into 절 
	     - update 문장의 set 절 
	 <4> SUB-QUERY는 order by 절을 사용할 수 없다.
	    (예외 : select/delete/update 문장의 from 절 )

      4) 종류
         <1> 단일행 Sub-Query
	     실행결과가 '하나의 데이터'만 리턴해주는 쿼리 

	     -- 사원번호가 7900인 사원의 부서이름 출력
             SQL> select e.EMPNO, d.DNAME from EMP e, DEPT d 
		  where e.DEPTNO=d.DEPTNO and e.EMPNO=7900;
       
             Sub> select DEPTNO from EMP where EMPNO=7900;
	     Main> select DNAME from DEPT where DEPTNO=30;
	     SQL> select DNAME from DEPT where DEPTNO=(select DEPTNO from EMP where EMPNO=7900);

	     -- 부서번호가 10번인 사원급여와 급여가 같은 사원의 이름과 커미션을 출력(X)
	     Sub> select SAL from EMP where DEPTNO=10;
	     Main> select ENAME, COMM from EMP where SAL=?;
	     Err> select ENAME, COMM from EMP where SAL=(select SAL from EMP where DEPTNO=10);

	     Sub> select SAL, COMM from EMP where EMPNO=7369;
	     Main> select ENAME, COMM from EMP where SAL=?;
	     Err> select ENAME, COMM from EMP where SAL=(select SAL, COMM from EMP where EMPNO=7369);

	     -- 평균급여보다 많은 받는 사원의 이름과 급여 출력!
	     Err> select ENAME, SAL from EMP where SAL>avg(SAL);
	     SQL> select ENAME, SAL from EMP where SAL>(select avg(SAL) from EMP);
              

	 <2> 복수행 Sub-Query
	     실행결과가 '둘 이상의 데이터행'을 리턴해주는 쿼리 

             -- 부서번호가 10번인 사원급여와 급여가 같은 사원의 이름과 급여을 출력
             1> in
	     
	        Sub> select SAL from EMP where DEPTNO=10;
	        Main> select ENAME, SAL from EMP where SAL=?
	        Err> select ENAME, SAL from EMP where SAL=(select SAL from EMP where DEPTNO=10);

	        SQL> select ENAME, SAL from EMP where SAL in (select SAL from EMP where DEPTNO=10);
	        SQL> select ENAME, SAL from EMP where SAL=any(select SAL from EMP where DEPTNO=10);
	        효과> select ENAME, SAL from EMP where SAL=2450 or SAL=5000 or SAL=1300;

             -- (급여가 가장 많은) 'MANAGER'보다 급여가 같거나 많은 사원의 JOB,SAL을 출력!!
             2> all 
	        Sub> select SAL from EMP where JOB='MANAGER';
		Main> select JOB, SAL from EMP where SAL>=?;
		Err> select JOB, SAL from EMP where SAL>=(select SAL from EMP where JOB='MANAGER');
		SQL> select JOB, SAL from EMP where SAL>=all(select SAL from EMP where JOB='MANAGER');
		효과> select JOB, SAL from EMP where SAL>=2975 and SAL>=2850 and SAL>=2450;

             -- (급여가 가장 큰) 'SALESMAN' 보다 급여가 작은 사원의 JOB, SAL을 출력!
             3> any
	        Sub> select SAL from EMP where JOB='SALESMAN';
		Main> select JOB, SAL from EMP where SAL<?;
		SQL> select JOB, SAL from EMP where SAL<all(select SAL from EMP where JOB='SALESMAN');
		SQL> select JOB, SAL from EMP where SAL<any(select SAL from EMP where JOB='SALESMAN');

             -- '부서번호'가 10인 사원이 존재하면 모든 부서의 이름을 출력! 
             4> exists
	        Sub> select * from EMP where DEPTNO=10;
		Main> select DNAME from DEPT;
                SQL> select DNAME from DEPT where exists(select * from EMP where DEPTNO=40);

	 <3> 복수컬럼 Sub-Query
	     실행결과가 '둘 이상의 컬럼' 데이터를 리턴주는 쿼리 

             --'부서번호'가 30인 사원의 (SAL과 COMM)이 같은 사원들의 '이름'과 '부서번호' 출력!
	     Sub> select SAL, COMM from EMP where DEPTNO=30;
	     SQL> select ENAME, DEPTNO from EMP where (SAL, COMM) 
	          in(select SAL, COMM from EMP where DEPTNO=30); --4개 
             비교> select ENAME, DEPTNO from EMP where (SAL, nvl(COMM, 0)) 
	          in(select SAL, nvl(COMM, 0) from EMP where DEPTNO=30); --6개 

	 <4> 상호관련 Sub-Query
	     Main-Query 절에 사용된 테이블이 Sub-Query절에 다시 재사용되는 쿼리 

	     Sub> select avg(e1.SAL) from EMP e1, EMP e2
	          where e1.DEPTNO=e2.DEPTNO;
             Sub-Err> select avg(SAL) from EMP e2
	          where e1.DEPTNO=e2.DEPTNO;
	     Main> select e1.EMPNO, e1.SAL from EMP e1
	           where SAL>(select avg(SAL) from EMP e2
	           where e1.DEPTNO=e2.DEPTNO);


     < Question >   
     -- 부서번호가 10번인 사원 평균급여 보다 급여가 적은 사원의 이름과 급여
	   -- ( 단, 급여가 높은 순으로 정렬 )
     Sub> select avg(SAL) from EMP where DEPTNO=10;
     SQL> select ENAME, SAL from EMP 
          where SAL<(select avg(SAL) from EMP where DEPTNO=10)
          order by SAL desc;

     --부서번호가 10번인 사원 평균급여 보다 급여가 적은 사원들의 부서별 평균 급여
	    --( 단 10번부서는 출력제외할 것, 부서번호 역정렬, 급여는 반올림할 것 ) 
     Sub> select avg(SAL) from EMP where DEPTNO=10;
     SQL> select DEPTNO, round(avg(SAL)) from EMP
          where SAL<(select avg(SAL) from EMP where DEPTNO=10)
          group by DEPTNO
          having DEPTNO!=10
	  order by DEPTNO desc;
     
//////////////////////////// 문제3 풀기 //////////////////////////////// 

2. DML ( Data Manipulation Language )
   (1) 설명 
       테이블내의 데이터를 '입력', '수정', '삭제'하는 SQL문 

   (2) 종류 
       1) insert 
          SQL> insert into DEPT2 values(50, '개발', '서울');
	  Err> insert into EMP2 values(8000, '강정구', '개발자', 7839, SYSDATE, 5000, null, 60); --에러(FK)
	  SQL> insert into EMP2 values(8000, '강정구', '개발자', 7839, SYSDATE, 5000, null, 50); 
	  Err> insert into EMP2(EMPNO, ENAME, SAL, HIREDATE) values(8000, '곽치영', 6000, SYSDATE);--에러(PK)
	  Err> insert into EMP2(ENAME, SAL, HIREDATE) values('곽치영', 6000, SYSDATE); --에러(NN)
          SQL> insert into EMP2(EMPNO, ENAME, SAL, HIREDATE) values(9000, '곽치영', 6000, SYSDATE); 

          확인> select * from EMP2 where EMPNO>=8000;

       2) update 
          SQL> update EMP2 set ENAME='강짱구', SAL=4500 where EMPNO=8000;
	  SQL> update EMP2 set EMPNO=8001 where EMPNO=8000; --PK컬럼도 변경가능
	  SQL> update EMP2 set DEPTNO=40 where EMPNO=8001; --FK컬럼도 변경가능

       3) delete
          SQL> delete from DEPT2 where DEPTNO=30; 
	  -- on delete cascade 옵션으로 제약조건이 부여되었다면 자식데이터존재유무와 상관없이 삭제 됨
	  
	  SQL> delete from EMP2 where EMPNO=(select EMPNO from EMP2 where ENAME='JONES'); 

	
       cf1) cascade 를 이용한 부모 테이블 삭제 
          SQL> drop table DEPT2 cascade constraint;

       cf2) column 핸들링 
          SQL> alter table DEPT2 add(ADDCOL varchar2(10) constraint DEPT2_UQ unique); --추가 
	  SQL> insert into DEPT2 values(60, 'a', 'b', 'c');
	  SQL> select DEPTNO, DNAME, ADDCOL from DEPT2;
          SQL> alter table DEPT2 modify(ADDCOL varchar2(20)); --타입변경
          SQL> alter table DEPT2 rename column ADDCOL to ADDCOL2; --이름변경
	  SQL> alter table DEPT2 drop column ADDCOL2; --삭제 

/////////////////////////////// 미션 //////////////////////////////
  -- 복사된 emp2, dept2, emp3, dept3를 맘껏 DML을 연습해오시오 

          
3. TCL ( Transaction Control Language ) 
   
   cf) 트랜잭션(Transaction) :  

   (1) 설명 
       DML(insert, update, delete)문이 실행되어 DBMS에 '저장'되거나, 
       '되돌리기'위해서 실행하는 SQL

   (2) 트랜잭션(Transaction) 
       1) 정의 
          분리되어서는 안될 (논리적인) '작업 단위'

       2) 시작 
          <1> DBMS에 처음 접속했을 때 
	  <2> 하나 or 여러개의 DML문을 실행한 후 commit 또는 rollback 한 직후 
	  <3> DDL 이나 DCL 실행된 직후 

       3) 끝 
          <1> commit 또는 rollback 실행 직후 
	  <2> DDL 이나 DCL 문이 실행 직후  
	  <3> 세션이 종료 직후 
	      1> 정상
	        - exit; 또는 quit;
	        - commit 되고 종료 

	      2> 비정상
	         - 오른쪽 상단 X 버튼 종료 
		 - rollback 되고 종료 

          <4> 해당 세션에서 계정 변경 직후 
	      - conn system/java1234 ( commit; 된후 계정 변경됨)

	  <5> DB를 닫은 후 
	      세션1> 
	        - sqlplus scott/tiger 
	        SQL> delete from DEPT2 where DEPTNO=50;

	      세션2> 
	        - sqlplus system/java1234 as sysdba
		- shutdown immediate
		- startup
                 
	      세션3>
	        - sqlplus scott/tiger
		SQL> select * from DEPT2 order by DEPTNO;

	      결과) 세션1>의 작업은 rollback 됨 

	       
   (3) TCL의 종류	   
       1) commit; 
          DML문을 영구적으로 DBMS에 '반영'하는 SQL 

       2) rollback;
          DML문을 (이전 Transaction 끝부분) DBMS에 '취소'하는 SQL

       3) savepoint; 
           
	  세션1> 
	     SQL> insert into DEPT2 values(1, 'a1', 'b1');
	     SQL> insert into DEPT2 values(2, 'a2', 'b2');
	     SQL> savepoint a;
	     SQL> insert into DEPT2 values(3, 'a3', 'b3');
	     SQL> savepoint b;
	     SQL> insert into DEPT2 values(4, 'a4', 'b4');
	     SQL> rollback to a; 
	     SQL> commit;

	     참고> rollback to b; --안됨(이미늦음)


	  세션2> 
            SQL> select  * from DEPT2; -- 세션1> rollback to a; 후 
	    SQL> select  * from DEPT2; -- 세션1> commit; 후 

  (4) TCL 관련 특성
      1) Read Consistency ( 읽기 일관성 ) : '해당 row'  
         어떤 사용자(세션)가 변경중(트랜잭션진행중)인 행을 다른 사용자(세션)가 변경할 수 없게 하는 것 

          <예>
	  세션1> update DEPT2 set DNAME='영업' where DEPTNO=50;
	  세션2> update DEPT2 set DNAME='총무' where DEPTNO=50;
	  세션1> commit; 또는 rollback; 
	  세션2> 1 행이 업데이트되었습니다.
        
      2) Lock ( 잠금 ) : '해당 table'

         <예>
	 세션1> delete from DEPT2; -- 테이블 전체 lock 
	 세션2> update DEPT2 set LOC='광주' where DEPTNO=50; --안됨 

	
      결론> Read Consistency 나 Lock 해제 방법: 진행중인 Transaction을 종료해야 함 


4. DDL ( Data Definition Language )
   (1) 설명   
       DBMS 내의 객체(Object)를 '생성', '변경', '삭제'를 위한 SQL

   (2) 객체(Object)
       1) table 
       2) index
       3) view 
       4) sequence 
       5) synonym 
       6) session 
       7) user 
          ... 

   (3) 종류 
       1) create : 객체를 생성할 때 
          생성> create table DDLTEST(
	          NO number(4) constraint DDLTEST_PK primary key, -- number(4): -9999~9999 
                  ID varchar2(12), 
		  PWD varchar2(12)
	       );
	  
          제약조건확인> select CONSTRAINT_NAME, TABLE_NAME from user_constraints 
	        where TABLE_NAME='DDLTEST'

 	  복사방법1> 
             create table DDLTEST2(
	          NO number(4) constraint DDLTEST2_PK primary key, 
                  ID varchar2(12), 
		  PWD varchar2(12)
	     );
             insert into DDLTEST2 select * from DDLTEST;

	  복사방법2>  
	     create table DDLTEST3 as select * from DDLTEST;
	     alter table DDLTEST3 add constraint DDLTEST3_PK primary key(NO);
 
       2) alter : 객체를 변경할 때 
           ( 옵션: add, modify, rename column, drop column, 
	          add constraint, drop constraint, disable constraint, enable constraint )
          <1> add 
	      SQL> alter table DDLTEST add(ADDR varchar2(20));
	      SQL> insert into DDLTEST values(2000, 'scott', 'tiger', 'seoul');
	      SQL> select * from DDLTEST;
	      
	  <2> modify
	      SQL> alter table DDLTEST modify(ID varchar2(15), PWD varchar2(15));
	      SQL> desc DDLTEST

	  <3> rename column
	      SQL> alter table DDLTEST rename column PWD to PASS;
              SQL> desc DDLTEST

	  <4> drop column
	      SQL> alter table DDLTEST drop column ADDR;
              SQL> select * from DDLTEST;

	  <5> drop constraint
	      SQL> alter table DDLTEST drop constraint DDLTEST_PK;
	      SQL> desc DDLTEST
      
       3) drop : 객체를 삭제할 때 
          SQL> drop table EMP3;
	  SQL> select TNAME from tab; 
	  --SQL> purge recyclebin; --휴지통비우기 
	  --SQL> flashback table EMP3 to before drop; --휴지통에서 복구 

       4) rename : 객체 이름 변경시 
          SQL> rename DDLTEST to DDLTEST2;

       5) comment : 객체에 대한 주석 저장시 
          <1> 테이블 주석
	      SQL> comment on table DDLTEST2 is 'DDL테스트용 테이블';
	      SQL> desc user_tab_comments
	      SQL> select TABLE_NAME, COMMENTS from user_tab_comments where TABLE_NAME='DDLTEST2';

	  <2> 컬럼 주석 
	      SQL> comment on column DDLTEST2.ID is '회원 아이디';
	      SQL> desc user_col_comments
	      SQL> select TABLE_NAME, COLUMN_NAME, COMMENTS from user_col_comments 
	           where TABLE_NAME='DDLTEST2';

       6) truncate : '모든' 행(row)을 삭제시 
          SQL> truncate table DDLTEST2;
	  SQL> select * from DDLTEST2;

	  질문) delete 문과 차이점 
	   - 되돌릴 수 없음 ( rollback 안됨! )
	   - where 절 사용 X
	   - when ? 속도가 무쟈게 빠름 
          

5. DCL ( Data Control Language )     
   (1) 설명 
       계정에 권한을 부여하거나 빼앗을 때 사용하는 SQL 

   (2) 계정생성  
      1) 실행창(Win + R)
         <방법1> sqlplus / as sysdba
	 <방법2> sqlplus sys/java1234 as sysdba

      2) scott / tiger 계정 생성 
         SQL> alter session set "_oracle_script"=true;   
         SQL> create user TEST1 identified by JAVA1;

   (3) 권한 부여 
       SQL> grant CONNECT, RESOURCE, CREATE VIEW to TEST1;
       SQL> conn TEST1/JAVA1;
       SQL> show user;

   (4) 권한 제거 
       SQL> revoke CONNECT from TEST1;
       SQL> conn TEST1/JAVA1; -- 불가!

   (5) 계정 수정  
       1) 접속 
          실행창(Win + R)에서 
	  sqlplus sys/java1234 as sysdba;

       2) 비번수정 
          SQL> alter user TEST1 identified by JAVAC1;

       3) 수정확인 
	  SQL> grant CONNECT to TEST1;
	  SQL> conn TEST1/JAVAC1;
   
    (6) 계정 삭제
        SQL> drop user TEST1; -- 안됨 


       1) 해당 user의 테이블이 없는 경우 
	   SQL> alter session set "_oracle_script"=true; 
	   SQL> drop user TEST1; -- 삭제됨

       2) 해당 user의 테이블이 있는 경우
	   SQL> alter session set "_oracle_script"=true; 
	   SQL> drop user TEST1 cascade; -- 삭제됨

         
------------------------- SQL 끝 ---------------------------------
	  
         
[ Part4 : SQL외.. ]      
1. Data Dictionary  
    (1) 설명 
       Oracle 테이블은 2가지 종류가 있다 
       첫번째, DB가 생성될 때 기본적으로 만들어지는 '자료사전테이블'
       두번째, User가 데이터를 저장하고 관리하기 위한 '사용자정의테이블'
       전자가 Data Dictionary 이다    
       
    (2) 종류 
       1) DBA_XXX : DB전체의 관련정보를 저장한 테이블 
       2) ALL_XXX : 자신이 볼 수 있는 Object 정보 테이블 
       3) USER_XXX : 자신이 생성한 Object 정보 테이블 
       4) X$_XXX : DB의 성능 분석/통계 정보 테이블 ( DB튜닝시 수정함 )
       5) V$_XXX : X$_XXX의 VIEW ( 성능 참조 ) 
       
       <예1>
          SQL> select * from dictionary;
	  SQL> select * from dict_columns;

	     cf) Ctl + C : 명령실행 정지 

       <예2> user_( ***** )
          SQL> desc user_tables
	  SQL> select TABLE_NAME from user_tables;

          SQL> desc user_indexes
	  SQL> select INDEX_NAME, INDEX_TYPE, TABLE_NAME from user_indexes;

	  SQL> desc user_constraints 
	  SQL> select TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints;

	  SQL> desc user_views
	  SQL> select VIEW_NAME, TEXT from user_views;

	  cf) view 생성예 
	  SQL> conn system/java1234;
	  SQL> grant create view to scott;
	  SQL> conn scott/tiger;
	  SQL> create or replace view VIEW1 as 
	          select DEPTNO "부서번호", round(avg(SAL)) "평균급여" from EMP
	          where SAL<(select avg(SAL) from EMP where DEPTNO=10)
	          group by DEPTNO
	          having DEPTNO!=10
	          order by DEPTNO desc;
          SQL> select VIEW_NAME, TEXT from user_views;
          SQL> select * from VIEW1;
	  
       <예3> all_
          SQL> select * from all_tables;
	  SQL> select OWNER, TABLE_NAME from all_tables where TABLE_NAME='DUAL';
	  SQL> desc all_tables
	    
       <예4> dba_
          SQL> select * from dba_tables; --이런 테이블은 없음 
	  SQL> conn system/java1234
	  SQL> select * from dba_tables;


2. Data Type 
  (1) 설명 
     Oracle에서 제공하는 데이터 타입 

  (2) 종류
     1) 스칼라(Scalar) 타입	 
        cf) Scalar : 실수로 표시할 수 있는 수량 

	<1> '하나의 데이터 타입컬럼'에 오직, '하나의 데이터'만 저장할 수 있는 타입 
	<2> '문자/숫자/날짜' 데이터를 저장 
	<3> 종류 
	    1> number ( -38 ~ +38 자리수 )
	    2> binary_integer ( -2^31 ~ 2^31-1 )
	    3> char(0~255), nchar 
	       - char(10) -> 나머지 공간을 space 로 채움 
	       - nchar(10) -> 다양한 언어의 문자값을 저장 
            4> varchar, varchar2(4000), nvarchar2(4000)
	       - varchar2(10) -> 필요한 공간만 채움 
	       - nvarchar2(10) -> 다양한 언어의 문자값을 저장 
            5> blob, long row, clob, long 
	       - blob -> 바이어리 데이터를 4G
	       - long row -> 바이어리 데이터를 2G
	       - clob -> 문자 데이터를 4G
	       - long -> 문자 데이터를 2G
	    6> date ( 초단위 데이터 저장 )
	    7> timestamp ( 마이크로초 저장 )
	       - timestamp with time zone
	       - timestamp with local zone 
	       - interval year to month 

	       cf1) java.sql.Timestamp 를 이용 
	       cf2) '1/10^6'초까지 저장은 가능하나 
	            컴퓨터에 생성할 수 있는 유효한 시간은 
		    '1/10^3'초이므로 실제저장시간은 '1/1000'초 임 
            8> boolean ( true / false 저장 ) 

	   
     2) 모음(Collection) 타입
        <1> 하나의 데이터 타입 컬럼에 
	    '여러개의 데이터(배열/테이블)'을 저장할 수 있는 타입 
	<2> 배열/테이블 데이터를 저장 
	<3> 종류 
	    1> varray
	    2> nested table 

  (3) 시간 관련 함수 
      1) current_date 함수 ( sysdate )

         cf1) 시간 포멧 수정 
	 SQL> alter session set 
	      NLS_DATE_FORMAT='YYYY-MM-DD AM HH:MI:SS DAY';
	 SQL> alter session set NLS_LANGUAGE='ENGLISH';

	 cf2) NLS( National Language Support ) 

      2) current_timestamp ( ***** )
         SQL> select current_timestamp from dual;
	 SQL> alter session set TIME_ZONE='-08:00';
	 SQL> select current_timestamp from dual;
	 SQL> alter session set TIME_ZONE='00:00';
	 SQL> select current_timestamp from dual;
   
      3) localtimestamp
         SQL> select current_timestamp, localtimestamp from dual;

	 cf) TST 테이블 
	 SQL> create table TST(
	     NO number, 
	     RDATE date, 
	     TS timestamp);
	 SQL> insert into TST values(10, sysdate, current_timestamp);
	 SQL> insert into TST values(20, sysdate, current_timestamp);
	 SQL> insert into TST values(30, sysdate, current_timestamp);
	 SQL> select * from TST;
   
  (4) ROWID 와 ROWNUM 컬럼 ( ***** )
      1) 설명 
         oracle 에서 테이블을 생성하면 기본적으로 제공되는 컬럼 
  
      2) 종류
         1) ROWID
	     -> ROW 의 고유 ID 
	       ( 중간에 row 수정해도 불변 )
	 2) ROWNUM
	     -> 행의 index 
	       ( 중간에 row 삭제시 변함 )

	   SQL> select NO, ROWID, ROWNUM from TST; 
	   SQL> select count(*) from TST;
	   SQL> select max(ROWNUM) from TST;


3. 일련번호 ( Sequence )
   (1) 설명 
       연속적인 숫자값을 자동으로 증감해주는 객체(Object)
       즉, 시퀀스는 생성한 후, 호출만하면 연속적으로 번호를 
       증가 or 감소시켜 제공해 줌   
 
   (2) 문법 
       create sequence 시퀀스명 
        [ increment by N ]
	[ start with N ]
	[ maxvalue N | nomaxvalue ]
	[ minvalue N | nominvalue ]
	[ cycle | nocycle ]
	[ cache | nocache ]

   (3) 생성 예 
       SQL> create sequence DEPT2_SEQ increment by 1 start with 1 nocache;
       SQL> desc seq
       SQL> select SEQUENCE_NAME, INCREMENT_BY, MIN_VALUE, MAX_VALUE from seq;

   (4) 사용 
       1) nextval 
           SQL> select DEPT2_SEQ.nextval from DUAL;

       2) currval 
           SQL> select DEPT2_SEQ.currval from DUAL;

	   cf) 시퀀스 생성 후 '적어도 한번은' nextval 호출해줘야 값이 셋팅됨

   (5) 삭제 
       SQL> drop sequence DEPT2_SEQ;
       SQL> select SEQUENCE_NAME, INCREMENT_BY, MIN_VALUE, MAX_VALUE from seq;


4. 제약조건 ( Constraint )    
   (1) 설명 
       테이블에 컬럼에 '원치않는 데이터를 입력/변경/삭제되는 것을 방지'
       하기위해 테이블 생성(create)시 또는 변경(alter)시 설정하는 조건  
       
       cf) 제약 조건명(constraint 변수명)을 개발자가 직접부여하면 
           추후 해당 constraint 관리가 용이 

   (2) 종류 
       1) primary key ( 기본키 == 식별키 )
          하나의 ROW 데이터를 특정하는 키
           - 하나의 테이블에 오직 '하나'만 존재 가능 ( 0 or 1 )
	   - 제약조건 이름과 같은 인덱스 객체가 자동으로 생성되어 부여됨 
	   
       2) foreign key ( 참조키 == 외래키 )
          부모 테이블의 'PK/UK'를 참조하는 키 
	   - 여러개 가능 

       3) unique key ( 유일키 )
          PK가 아니더라고 컬럼의 모든 값이 유일해야 하는 경우에 사용되는 키 
	  ( 즉, 중복데이터를 허용하지 않는 컬럼에 부여 )

	  cf) PK와 차이점 
	  - null 을 입력하 수 있음 
          - 하나의 테이블에 '여러개' 생성 가능 

       4) check 
          조건에 맞는 입력되도록 조건을 부여한 제약조건 
          cf) 조건이란 ? 
	    - 데이터 값의 범위
	    - 특정 패턴 숫자 
	    - 문자값 설정
	     ... 

       5) not null 
          null이 입력되어서는 안되는 컬럼에 부여하는 제약조건 
	  ( 컬럼 레벨에서만 부여 가능 )

	  cf) Tip 
	   - PK는 not null 포함 
	   - default 는 제약조건이 아님 
	   - not null 조건도 contraint_type이 'C'로 표시 
   
   (3) 특징 
       1) 제약조건 수정하려면, 삭제하고 다시 만들어야 함 
       2) disable constraint, enable constraint 는 왠만하면 사용 안하는 걸 추천 

   (4) 제약 조건 부여 방법 
       1) column level
           <1> 이름을 부여 X 
	      방법1) ct1.sql
	   <2> 이름을 부여 O 
	      방법2) ct2.sql

       2) table level 
           <1> 테이블 생성 
              1> 이름을 부여 X
                 방법3) ct3.sql
              2> 이름을 부여 O
	         방법4) ct4.sql
	       
	   <2> 테이블 변경 ( alter table ) 
	      방법5) ct5.sql



	  

	  
	      