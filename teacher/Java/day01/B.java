package aa.bb; //(1)패키지 선언

import java.lang.*; //(2)임포트 구문 

class B {//(3)클래스 선언 ( Class Declaration ) 
	String str = "클래스구조"; //(4)멤버변수 ( Member Variable ) 

	B(){ //(5)생성자( Constructor )
		System.out.println("B()");
	}
	void m(){ //(6)메소드( Method )
		System.out.println("B의 m()");
	}
}


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
