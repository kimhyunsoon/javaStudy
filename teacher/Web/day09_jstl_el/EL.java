< EL( Expression Language ) >

<1> 모양 ${}

<2> 기능 
   1> 객체의 속성값을 얻어온다.
   2> 배열의 값을 얻어온다. 
   3> List 값을 얻어온다. 
   4> Map 값을 얻어온다.

<3> EL의 디폴트(내장) 객체 (11개)
   1> param 
	  paramValues

   2> header
	  headerValues   

   3> pageContext - 'EL에서 JSP의 디폴트객체 접근 사용'	

   4> requestScope 
      pageScope
	  sessionScope
	  applicationScope
	
   5> cookie 

   6> initParam - 'ServletContext에 대한 initParam 참조'

      정의) web.xml 
      <context-param>
         <param-name>siteName</param-name>
         <param-value>Soo Site</param-value>
      </context-param>

	  사용) jsp 
         ${initParam.siteName}

<4> EL 연산자 
	1> 산술 연산자 
		ex) +, -, * , / 와 div, %와 mod 
		cf1)/와 div사용시 0으로 나눌 수 있다(infinity)
		cf2)%와 mod사용시 0으로 나눌 수 없다.(오류)

	2> 논리 연산자 
		ex) &&와 and, ||와 or, !와 not

	3> 관계 연산자 
		ex) ==와 eq, !=과 ne, <와 lt, >와 gt, 
			<=와 le, >=와 ge 

	4> empty 
	   -> 비어있거나 null 일 경우 true 리턴 

		cf1) jsp의 변수(멤버/지역)는 EL에서 인식하지 못함
		cf2) 정의되지 않은 변수/값(null)일 경우 표현처리 
		case1) 공백 처리 (ex: ${str} )
		case2) 0 으로 처리 (ex: ${str + 10})
		case3) false 로 처리 (ex: ${true and str})


<5> EL Function 


