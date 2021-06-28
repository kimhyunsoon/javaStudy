package aa.cc;
import aa.bb.A; //다른 패키지일지라도 상속관계의 부모의 자원 접근 가능

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


