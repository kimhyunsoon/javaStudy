package aa.bb; //(1)��Ű�� ���� depth ���� �տ� �־�ߵ�

import java.lang.*; //(2)������ ����Ʈ, ���� �ٲٸ� �ȵ�, Ŭ�������ٴ� ��� �տ�
/*import java.util.Random; //����Ʈ ����*/



class B {//(3)Ŭ���� ���� Class declaration

	
	String str = "Ŭ��������"; //(4)�������(member variable)
	B() { //(5)������(constructor)
		System.out.println("B()");
	}
	void m() {//(6)method
		System.out.println("B�� m()");
	}

	public static void main(String args[]){
		B b = new B();
		b.m();
		System.out.println("b.str: " + b.str);
	}
	
}

//OOP ��ü�������α׷��� object-oriented programming
//����, Ŭ�����ٵ�, Ŭ�������
	//string : ���ڿ�, ��ȣ�� �� ����
	//= ���Կ�����(�Ҵ翬����) == equal
	//�ʱⰪ initial value
	//* �� ��Ű���� ��� ���� ���� ���ڴ�.

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