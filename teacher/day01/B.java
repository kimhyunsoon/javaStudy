package aa.bb; //(1)��Ű�� ����

import java.lang.*; //(2)����Ʈ ���� 

class B {//(3)Ŭ���� ���� ( Class Declaration ) 
	String str = "Ŭ��������"; //(4)������� ( Member Variable ) 

	B(){ //(5)������( Constructor )
		System.out.println("B()");
	}
	void m(){ //(6)�޼ҵ�( Method )
		System.out.println("B�� m()");
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
