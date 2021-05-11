package aa.cc;

import aa.bb.A; //클래스 접근 

class AUser extends A
{
	AUser(){
		super(); //부모의 생성자 
		System.out.println("이름: " + name); //멤버 접근 
		m(); //메소드 접근
	}
	public static void main(String[] args) 
	{
		new AUser();
	}
}
