package aa.bb; //(1)패키지 선언 depth 제일 앞에 있어야됨

import java.lang.*; //(2)묵시적 임포트, 순서 바꾸면 안됨, 클래스보다는 적어도 앞에
/*import java.util.Random; //임포트 구문*/



class B {//(3)클래스 선언 Class declaration

	
	String str = "클래스구조"; //(4)멤버변수(member variable)
	B() { //(5)생성자(constructor)
		System.out.println("B()");
	}
	void m() {//(6)method
		System.out.println("B의 m()");
	}

	public static void main(String args[]){
		B b = new B();
		b.m();
		System.out.println("b.str: " + b.str);
	}
	
}

//OOP 객체지향프로그래밍 object-oriented programming
//영역, 클래스바디, 클래스블록
	//string : 문자열, 괄호는 일 행위
	//= 대입연산자(할당연산자) == equal
	//초기값 initial value
	//* 이 패키지의 모든 것을 갖다 쓰겠다.

	/*
	javac -d . B.java
	java aa.bb.B
	*/

	
class BUser {

	public static void main(String args[]){
		B b = new B();
		b.m();
		System.out.println("b.str: " + b.str);
	}
	
}