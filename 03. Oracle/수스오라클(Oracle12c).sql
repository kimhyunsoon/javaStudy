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
         sqlplus / as sysdba

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
	
      7) 세션 나오기 
         exit;
    
   (2) 
