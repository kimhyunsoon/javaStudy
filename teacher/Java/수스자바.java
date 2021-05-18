1. HW (+ OS + JVM + App1, App2, ... ) 
   (1) CPU, GPU : 두뇌 
   (2) RAM(메모리) : 책상 
   (3) HDD/SSD : 책꽃이 
   (4) MainBoard: 방 
   (5) Card : Audio, Video, Ran, WLRan, ... 
   (6) 주변기기: 키보드, 모니터, 마우스, 프린터, 본체... 

    
2. 환경 설정 
   (1) JDK 설치 
       - jdk 
       - jre 
   (2) 환경 변수 
       - JAVA_HOME => C:\Program Files\Java\jdk1.8.0_221
       - Path => %JAVA_HOME%\bin
       - classpath => . 

   (3) Editer
       - Editplus 
       - Eclipse
       - VSCode 
       - IntelliJ

   (4) API 
       - jdk-8u221-docs-all.zip 압축해제 / 즐겨찾기 

3. 실행 메커니즘
  (1) 작성(.java) -> 컴파일(javac.exe) -> 실행(java.exe)
  (2) .java ( for Man ) -> .class ( for Com )


4. 실행이 되는 클래스 ( 인입점이 있는 클래스 ) 
   public static void main(String args[]){}

   ex) day01/A.java 

5. 클래스 구조 
  (1) 패지키 선언
  (2) 임포트 구문
  (3) 클래스 선언 {
      (4) 멤버 변수 
      (5) 생성자 
      (6) 메소드 
    }

   ex) day01/B.java 

6. 패키지 컴파일 / 실행 
   javac -d . B.java
   java aa.bb.BUser

7. 주석( Comment )
  (1) 1라인 //
  (2) N라인 
      /*
         라인1
	 라인2... 
      */
  (3) 문서화주석 
      /**
         라인1
	 라인2... 
      */

8. 객체 지향(OOP) 용어 
  (1) 클래스( Class ) : '객체'를 만드는 틀 
      ex) 붕어빵틀 
  
  (2) 객체 ( Object ) : 클래스를 통해 나온 구현물 , 모든 것 
      ex) 붕어빵 

  (3) 생성자 ( Constructor ) : '객체'가 생성될 때 하는 일(행위)

  (4) 메소드 ( Method ) : '객체'가 할 수 있는 일(행위)
  
  (5) 속성 ( Attribute == Member ) : '객체'의 특성 
       ( 존재이유: 다양한 객체 ) 
       ( Attribute == 멤버 == Field )

      ex) day02/A.java

9. 클래스 설계 
/*
    일상의 어떤 현상을 상상해서.. 
    클래스 설계를 하고, 객체를 생성하여 표현(메소드/속성)하시오
*/
      ex) day02/B.java 

   
10. 변수( Variable )

	(1) 유효범위 
		1) 멤버(==전역) 
		   <1> 클래스소속
		   <2> 객체소속(==인스턴스) 
		2) 지역
		   <1> 파라미터(==매개==아큐먼트)
		   <2> 선언초기화

		ex) day03/A.java 

	(2) 메모리 
		1) 기본형(primitive==원시데이터): 8가지
		   <1> call by value 
		   <2> 형태: 모두 소문자 
		   <3> 종류 
			   byte ▶ short ▶ int ▶ long ▶ float ▶ double  
					   char ▶

			   boolean 

		   <4> 담을 수 있는 값의 범위 
			   1> byte(1): -2^7 ~ 2^7-1 (경우의수: 2^8)
			   2> short(2): -2^15 ~ 2^15-1 (경우의수: 2^16)
			   3> char(2): 0 ~ 2^16-1 (경우의수: 2^16)
			   4> int(4): -2^31 ~ 2^31-1 (경우의수: 2^32)
			   5> long(8): -2^63 ~ 2^63-1 (경우의수: 2^64)
			   6> float(4): 무한대 (경우의수: 2^32)
			   7> double(8): 무한대 (경우의수: 2^64)
			   8> boolean(1): false / true

			   ex) day03/B.java

		   <5> 형변환( Type Casting )
			   1> 자동(암시적/Implicit) by JVM 
				  - 범위 작은 Type -> 큰 Type 
				  - 

			   2> 강제(명시적/Explicit) by 개발자 
				  - 범위 큰 Type -> 작은 Type

			   ex) day03/B.java

		   <6> 예외 형변환 
			   -> 정수형(byte, short, char, int)끼리의 연산의 결과는 int 
			   ex) day03/B.java 

		   <7> 컴퓨터 소수 연산 오차 
			   -> float 오차가 double 보다 큼 
			   
			   ex) day03/C.java 

		   <8> 디폴트 초기값 
			   -> 정수(0), 실수(0.0f, 0.0), 불린(false)
			 
		   <9> 존재이유 
			   -> 실행의 효율성 

		   cf) Wrapper class 
		      Byte, Short, Character, Integer, Long, Float, Double, Boolean 
			   
		   
		2) 참조형(reference==레퍼런스): 무한대  
		   <1> call by reference
		   <2> 형태: 첫문자 대문자 
		   <3> 디폴트 초기값: null
		   <4> 형변환 
				  Object 
					▲
				  Human 
					▲
				  Woman 

	(3) 소유 
		1) 클래스(==정적==static)
		   static 붙으면 클래스 소유 
		   
		2) 객체(==동적) 

		   ex) day03/E.java

	(4) final 
		1) 상수
		   -> final 붙으면 초기값을 바꿀 수 없음 

		2) 변수 
		   
		   ex) day03/F.java 

		  
11. 제어 
    어떤 프로그램이 실행되고 있을 때..
	어느 한 시점의 CPU연산은 어떤 특정 코드부분을 실행하고 있을 것이다
	그 코드부분을 '제어점'이라하고, 그 제어점들의 집합을 '제어'라 한다
    즉 "프로그램의 실행흐름(line)'

    JVM -> main() -> .... -> main() -> JVM 

	cf) 비유: '부메랑' 

    ex) day04/A.java 


12. 제어문 
    (1) 조건문 
	    1) if(boolean형){}
		2) if(boolean형){} .. else if(boolean형){} .. else{}
        3) switch(정수형){ case: .. default: } 문 
		   => 정수형+String, break, default위치, case블럭 생략 가능  
		   
		ex) day04/B.java , C.java 

	(2) 반복문 
	    -> 초기식(밖), 조건식(안), 증감식(안)을 갖추어야 '유한루프'가 됨 
		
	    1) while(boolean형){} //신사 

		2) do{} while(boolean형); //조폭 

		3) for(초기식; 조건식; 증감식){} //신사 

		ex) day04/D.java 

	  
13. 제어 예약어 
   (1) break
       1) switch블럭 or loop 안에서만 나올 수 있음 
       2) 자신을 둘러싼 첫번째 블럭을 '나간다'
	   3) labled break 

	    ex) day05/A.java  

   (2) continue
       1) loop 안에서만 나올 수 있음
	   2) (조건에 맞으면) '건너뛴다'
	   3) labled continue

	    ex) day05/A.java

   (3) return 
       1) 생성자나 메소드 안에서는 어디에서나 나올수 있음 
	   2) 호출한 곳 or 놈으로 '되돌린다'

       ex) day05/B.java

14. 연산자( Operator ) 
   (1) (데이터들을) 연산하게 하는 '기호'

   (2) 종류
       1) 산술 ex) +, -, *, /, %
	       cf) 연산자오버라이딩: 문자열과 만날때는 +는 '결합연산자' 

	   2) 증감 ex) ++, -- 
	   3) 대입 ex) = 
	   4) 산술대입 ex) +=, -=, *=, /=, %=
       5) 비트 ex) &, |, ^, ~, 시프트(<<, >>, >>>)
	   6) 비교 ex) ==, !=, <, <=, >, >=
	   7) 논리 ex) &, &&, |, ||
	   8) 논리대입 ex) &=, |=
	   9) 조건 ex) A? B:C
	   10) instanceof ex) 객체 instanceof 클래스 

	   ex) day5/C.java 

15. 배열(Array) ( 비유: 냉장고 )
    같은 타입의 데이터 '저장소'로써 생성될 때 그 크기가 고정되는 '객체'
    
	(1) 선언 
	    type 배열변수[];
	    ( ex: int is[];  String strs[]; .. )
		
	(2) 생성 
	    배열변수 = new type[크기];
		( ex: strs = new String[4]; )

	(3) 초기화 
	    배열변수[인덱스] = 데이터;
		( ex: strs[0]="봄"; )

	    ex) day06/A.java 

    (4) 선언 및 생성 
	    type 배열변수[] =  new type[크기];
	    ( ex: String strs[] = new String[4]; ) 
       
    (5) 선언 및 생성 및 초기화 
	    type 배열변수[] = {데이터1, 데이터2, ...}
		( ex: String strs[] = {"봄", "여름", "가을", "겨울"}; ) 

	    ex) day06/B.java 

    (6) 배열방 default 값 ( by JVM )
	    byte, short, char, int: 0
 		long: 0L
		float: 0.0f
		double: 0.0
		boolean: false
		참조형: null 

		ex) day06/C.java 

    (7) 형변환 
        자동형변환이 가능한 데이터라면 변환되어져서 저장 됨 
        ( ex: int is[] = {b, s, c, i, (int)f};  )

	    ex) day06/D.java 

    (8) 2차원 
	    1차원 배열을 데이터(element)로 갖는 배열
	    ex) day06/E.java 

    (9) N차원 
	    (N-1)차원 배열을 데이터(element)로 갖는 배열

16. 컬렉션(Collection) 계열 ( Data Structure , 가변배열 )
    같은 타입의 '참조형'데이터 '저장소'로써 그 크기가 변하는 '객체'

	(1) 종류 
	    1)        java.util.Collection
		          |                  | 
               java.util.List   java.util.Set
			    |                   | 
	     ArrayList, Vector,..    TreeSet, SortedSet,.. 
		

		2)      java.util.Map 
		             | 
				Hashtable, HashMap,..


	(2) 특징 
	    1) List
		   - 순서를 보존 O
		   - 중복을 허용 O 

		   ex) day07/A1.java  

		2) Set 
		   - 순서를 보존 X 
		   - 중복을 허용 X

		   ex) day07/B1.java 

		3) Map 
		   - key와 value쌍으로 저장 
		   - 순서를 보존 X
		   - key는 중복 X, value는 중복 O
		     ( key가 중복이된다면.. value는 새로운 값으로 덮어쓰기 ) 

		   ex) day07/C1.java 

17. OOP(Object Oriented Programming) 특성 
	(1) 상속성( Inheritance ) 
	    부모의 '모든 것'을 자식에서 '상속'받는 것(=='사용'할 수 있는 것) 
	    
		1) 다른 생성자가 하나도 없을 때에만 JVM이 기본생성자를 만들어줌 
	       자식 객체가 생성되려면 먼저 부모객체가 생성되어야 함
		2) 모든 생성자의 첫라인에는 super();가 생략되어 있음 
		  ( 단, 다른 super(..)가 있다면 예외 )
		3) 자식메소드에서 부모메소드의 내용을 바꿀 수 있음( Overriding )
		4) 모든 객체는 Object 자식( 묵시적 상속 )
		5) 형변환 
		   - 자동 by JVM ( 자식 -> 부모 ) 
		   - 강제 by 개발자 ( 부모 -> 자식 ) 
        6) 형제관계(남남)는 상속과 무관 ( 형변환 X ) 
		 
		ex) day08/A.java 

	(2) 다형성( Polimorphism )
	    같은 타입 객체의 같은 메소드가 다른 일을 하는 것 

	    ex) day08/B.java 

	(3) 은닉성( Information Hiding ) 
	    외부프로그램으로부터 속성값을 감추는 것
	    ( 멤버를 private으로 놓고 선택적으로 메소드(getter/setter)를 정의해서 접근 )

	    ex) day08/C.java 

	(4) 캡슐화( Encapsulation ) 
        메소드의 구현 내용을 몰라도 그 형태만 알면 호출해서 사용할 수 있는 것
		
	    ex) day08/D.java 

18. 예외 처리 
	(1) 예외( Exception )  
		프로그램이 정상적으로 진행되지 못하게 하는 '돌발 상황'

		ex) 숫자가 아닌형태 문자열을 숫자로 바꾸려할 때 
		    채팅하다가 상대방이 나가버릴 때 
			온라인 게임하고 있는 중에 전원케이블이 빠짐 
			게임 서버 다운됨 
			.. 
	(2) 처리 목적 
	    프로그램 진행시 발생할 수 있는 '돌발 상황'을 예외로 미리 정해놓고, 
        해당하는 예외가 발생했을 경우 적절한 조치를 취해서, 프로그램이 
		'정상 작동'하도록 하는 것 

    (3) 계층도 
	                    Object 
						  | 
					  Throwable 
					  |        | 
					 Error  Exception 
					        |       | 
			   CompileException    RuntimeException 
			   CheckedException 

			 ex) IOException  is a CompileException
			     NumberFormatException is a RuntimeException 

	(4) 특징 
	     1) 생성자나 메소드에서만 발생할 수 있음 
		 2) throw 로 예외 객체를 던짐(발생시킴)
		 3) throws 로 예외 표식을 함 ( == (소극적으로) 떠넘김 )
		 4) try catch 로 잡을 수 있음 (== (적극적으로) 때려 잡음 ) 
		 
		 ex) day09/A.java 

    (5) 방법 
	     1) 때려 잡는 법 
		    try{
				예외가 발생할 수 있는 구문(생성자 or 메소드)
			}catch(예외타입 예외객체){
				처리 로직 
			}

		 2) 떠넘기는 법 
		    throws 예외타입 

			ex) day09/A.java

    (6) 순서( try절 안에 2개 이상의 예외가 발생시 )
	     1) 상속관계X
            [순서존재X] 아무예외나 먼저 잡아줌
		    catch(MyException me)
		    catch(YourException me)

		 2) 상속관계O
		    [순서존재]하위예외부터 잡아 줌 
		    catch(MyException me)
		    catch(Exception e)

	     cf) 자식예외를 먼저 잡는 이유: 세련된 예외처리를 위해서

		 ex) day09/A.java
		 
    (7) 2이상의 예외를 떠넘길 때 
	    throws MyException, YourException, ..., Exception

		 ex) day09/A.java
	
	(8) finally 절 
	    1) 항상 수행하는 절 
		   - 예외 발생과 상관없이 수행  
		   - 심지어.. return 을 만나더라도 finally절을 수행 후 리턴 
		   
		2) try절이 나오면 
		   catch절이나 finally절이 나오거나.. 
		   둘다 나오거나 해야 함 

		3) 얘는 못 이김 
		   System.exit(0); //normal termination
		   System.exit(-1); //abnormal termination

		 ex) day09/B.java 


19. 제한자 ( Modifier ) 
    클래스(인터페이스), 변수, 생성자, 메소드 앞에 붙어서 기능을 '제한'하는 예약어 

   (1) 접근제한자( Access Modifier ) 
       1) 종류 
	      <1> public: 제한이 없음 
		  <2> protected: 같은 패키지의 자원 or 상속관계의 부모 자원 
		  <3> default ( friendly, package ): 같은 패키지의 자원 
		  <4> private: 클래스 안 

	   2) 특성 
	      <1> 클래스나 인터페이스 앞의 접근제한자는 public 과 default 만 가능
		  <2> public 클래스는 파일이름과 이름이 같아야 함 
		  
	   3) 범위 
	      <1> 넓은 순위: public > protected > default > private
		  <2> 강력 순위: public < protected < default < private
	      

		  ex) day10/A.java, AUser.java

   (2) 소유제한자( static ) 
       -> 붙으면 클래스 소유가 됨
       1) 멤버와 메소드에만 붙을 수 있음
	   2) static 자원 접근시에는 클래스이름으로 접근 가능 
	   3) static 메소드에서는 자원접근시 자신의 클래스 이름이 생략됨
	      ( 단, 다른 클래스에서 접근할 때는 생략 불가 )
	   4) static 자원 메모리에 1개 생성되어 모든 객체에게 공유됨 

          ex) day10/B.java 

   (3) 수정제한자( final )
       -> 붙으면 수정을 못하게 함  
       1) 클래스, 변수(지역변수 포함), 메소드 앞에 붙을 수 있음 
	   2) 클래스 붙으면 자식을 못낳고, 
	      변수 붙으면 상수가 되고, 메소드 붙으면 오버라이딩을 막음 
	   
	      ex) day10/C.java 

   (4) 추상제한자( abstract )
       -> 붙으면 추상화(化) 됨 

       1) 클래스와 메소드 앞에서만 붙을 수 있음 
	   2) 하나 이상의 '추상메소드'를 가진 클래스는 반드시 '추상클래스'가 되어야 함 
	   3) 추상클래스 객체는 완벽한 자식클래스 객체를 생성해서 형변환하여 만듬  

	     - 추상클래스: abstract 붙은 클래스 
		 - 추상메소드: abstract 붙은 메소드 

	      ex) day10/D.java, E.java 

   (5) 기타제한자
       synchronized(쓰레드), transient(보안), native(OS자원) 


20. 식별자( Identifier )
    프로그래머가 임의로 설정하는 패키지, 클래스, 변수, 생성자, 메소드 '이름'
   (1) 규칙 
       1) 숫자가 맨 앞에 나올 수 없음 
	   2) 특수문자는 _ 와 $ 만 가능 ( 맨앞에 나와도 됨 )
	   3) 길이의 제약은 없음 

   (2) 관례 
       1) 클래스와 인터페이스의 첫문자는 대문자 
	   2) 상수는 전체 문자를 대문자 
	   3) 패키지, 변수, 메소드 이름은 첫문자를 소문자로 시작 
	   4) 2개 이상의 단어의 조합은 다음 단어의 첫문자를 '대문자'로 하거나 '_'로 연결 
	   5) _와 $는 자제함
	   6) 의미있는 단어로 생성함 

	      ex) day10/F.java 
 
21. this
    (1) 정의 
        자신의 '객체' or '생성자'를 가르키는 '대명사'

	(2) 케이스 
	   1) 지역변수와 이름이 같은 멤버변수를 해당 지역에 접근할 때 
	   2) 자신의 객체를 다른 클래스에게 넘길 때 
	   3) 자신의 생성자를 호출할 때 

	    ex) day11/A.java 

22. super 
    (1) 정의 
        부모의 '객체' or '생성자'를 가르키는 '대명사'

	(2) 케이스 
	    1) 부모의 생성자를 호출할 때  
		2) 오버라이딩되기 전의 부모메소드를 호출할 때
		3) 이름이 동일한 부모의 멤버를 자식에서 호출할 때 
 
        ex) day11/B.java 

23. (메소드)오버라이딩( Overriding )
    (1) (상속관계에서) 부모 메소드의 일을 자식에서 바꾸는 것 

	(2) 조건 
	    1) 메소드 이름이 같아야 함 
		2) 반환타입이 일치해야 함 
		3) 파라미터의 타입과 순서와 갯수가 모두 일치 
		4) 생성자는 불가 
		5) 자식메소드의 접근제한자가 부모메소드의 접근제한자보다 같거나 넓어야 함 

		ex) day11/C.java 


24. 오버로딩( OverLoading )
             ( with 스스로, 인터넷, 책 .. ) 
    (1) 정의:  
	    - 명훈(스): 이름은 같지만 구별되는 생성자 메소드를 정의하는 것 
		- 건희(인): 접근할 수 있는 같은 이름의 생성자 또는 메소드들을 
		           다양한 기능으로 구현해 내는 것  
		- 동현(스): 이름은 같지만 서로 다른 타입인 파라미터의 생성자나 메소드끼리 
		          구별할 수 있는 것 
	    - 석현(인): 한 클래스내에 같은 이름의 메소드를 '여러개 정의하는 것' 
		- 정구(책): 메서드 이름이 같고 매개변수만 다른 경우
		- 민규(스): 같은이름의 메소드나 생성자를, 매개변수의 갯수 혹은 타입만으로 
		          다양한 기능을 처리할 수 있게 해 주는 것
		- 가은(스): 이름만 같고 다른 일을 하는 생성자나 메소드를 여러개 정의하여 사용하는 것
		- 형수(스): ( 그 형태에 따라 매핑되어 호출되도록 )
		         파라미터의 종류나 순서나 갯수가 다른 생성자나 같은 이름의 메소드를 '여러개 정의하는 것' 

	(2) 종류 
        1) 생성자 
		2) 메소드 

	(3) 특징 
        1) 반환타입과 관련 없음 
		2) 상속관계라면 다른 클래스에서도 로버로딩이 가능
		3) 형변환이 가능한 파라미터라도 오버로딩으로 인정 

	     ex) day11/D.java  

25. 인터페이스( interface )
	(1) 정의 
	    - JDK7이하: '상수'와 '추상메소드'로 구성된 껍데기
		- JDK8이상: '상수'와 '추상메소드'와 'static메소드'와 'default메소드'로 구성된 껍데기

         ex) day12/A.java 

	(2) 특징 
	    1) 객체는 완벽한 자식클래스를 만들어서 그 객체 생성 후 형변환 만듬
		2) interface 의 static 메소드는 인터페이스 이름으로만 접근 가능 
		3) 자식 클래스를 만들때는 implements 사용하고 다중상속도 가능 
		   ( 예: class ABChild implements A, B, ... )
		4) 인터페이스끼리의 상속은 extends 사용하고 다중상속도 가능 
		   ( 예: interface C extends A, B, ... )
		5) 일반적인 형태의 자식클래스 
		   ( 예: class AChild extends Human implements A, B, ..) 

26. 추상클래스와 인터페이스 공통점/차이점 
    (1) 공통점  
	    1) 추상메소드를 가질 수 있음 
		2) 완벽한 자식객체를 생성해서 형변환 객체를 생성 
	
	(2) 차이점 
	    1) 클래스이고 인터페이스 임 
		2) 추상클래스는 일반멤버와 일반메소드와 생성자를 가질 수 있음   

27. 추상클래스나 인터페이스의 사용 목적 
     -> 생각 : 하산하시오!! 

28. 내부클래스 ( Inner Class ) 
    클래스안의 클래스 

	(1) 모양 
        ex) day13/A.java 

    (2) 객체 생성 방법 
	    1) 외클.내클 변수 = new 외클().new 내클();
		   (예: B.BIn1 in1 = new B().new BIn1() ) 

	        ex) day13/B.java 

	    2) 외클.내클 변수 = new 외클.내클();
		   (예: B.BIn2 in2 = new B.BIn2() )

		    ex) day13/B.java

    (3) 왜 쓰는가?
	    외부클래스의 자원(멤버/메소드)을 자기 것처럼 사용하기 위해서 
		( 심지어는 private 자원도 가능 )
 
            ex) day13/B.java
	
	/////////////////// 선택 ///////////////////////
	(4) 접근제한자 
        내부클래스는 모든 접근제한자가 허용 

    (5) main 위치 ( 옵션 )
	     1) static 이 아닌 내부클래스는 main()을 가질 수 없음 
             ( static 자원(멤버/메소드)을 아예 가질 수 없음 )
		 2) static Inner class 안에서는 main을 가질 수 있음 
		     ( Outter의 static 자원만 접근 가능 )
		 
		    ex) day13/C.java 

29. @ 어노테이션 
    (1) 모양: @ 
    (2) 기능 
	    1) 클래스나 생성자 , 메소드에 붙어서 '정체성을 부여'
		2) 기능을 확장하는 표식 
		3) xml을 대신해서 서버에 배치(deploy)하는 역할 
	(3) jdk 6부터 지원 

	        ex) day13/D.java 

30. 쓰레드 ( Thread )	
    (1) 정의 
	    Process 를 구성하는 '제어의 흐름'

	(2) Process 와 Thread 
        1) Process: 프로그램 '실행단위'
		2) Thread : Process 를 구성하는 '작업단위'

    (3) 장점 
	    쓰레드 '경량 프로세스'라고 불리움 
		그 이유는 공통 Resource를 공유하기 때문에 빠름 
 
        ex) day13/E.java 

    (4) 생성법 
	    1) java.lang.Thread 상속 

		2) java.lang.Runnable 상속 

		ex) day13/F.java

    (5) 시작 
	    th.start();

    (6) 비유: '피고용인'( Emploee ) 

	(7) LifeCycle 
	    1) 5가지 상태 
		2) 각 상태는 '메소드'나 '스케쥴러'나 '시간'에 의해 이동함 
		3) 한번 돌아가시면 살아나지 못함 

    (8) Priority 
	    1) Ready상태의 쓰레드 중에서 
		    우선적으로 CPU를 점유할 수 있는 쓰레드를 판별하기 위한 LEVEL값 
		2) 범위 
		    1 ~ 10 
	    3) Thread.MAX_PRIORITY //10
		   Thread.MIN_PRIORITY //1
		   Thread.NORM_PRIORITY //5
        4) 부여/조회 
		   th.setPriority(int newPriority)
		   th.getPriority();
		  
		    ex) day13/G.java 

	(9) 동기화 
        1) 무결성이 깨진 예  
		   int i = 0; 
		   i++;

		   # CPU 연산단계 #
           <1> 현재의 i값을 읽는 단계      i==0     i==0  
		   <2> i를 증가시키는 단계        i==0      i==0
		   <3> 증가된 값을 i에 저장 단계    i==1     i==1

	        ex) day13/H.java 
	    
		2) 비유: 화장실의 문꼬리 

        3) 설명: 하나 이상의 쓰레드가 어떤 연산 or 로직에 동시에 접근했을 때, 
		    그 연산에 대한 값의 무결성을 보장하기 위해서 수행영역에 대한 lock을 걸어주는 것 

		4) 방법 
		   <1> synchronized void m(){
			        동기화가 필요한 로직;
		       }

           <2> void m(){
			        일반로직;
					synchronized(this){
			        동기화가 필요한 로직;
					}
		       }
		
		     ex) day13/I.java 