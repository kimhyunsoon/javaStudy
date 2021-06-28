class AAA2 //2. 자신의 객체를 다른 클래스에게 넘길 때
{
	String name = "홍길동";
	
	AAA2(){
		AAA2User u=new AAA2User(this); 
		u.use();
	}
		
	AAA2(String name){
		this.name = name;
	}

	void m(){
		System.out.println("AAA2의 메소드" );
	}
		
	public static void main(String[] args) 
	{
		
		AAA2 aaa2 = new AAA2("이순신");
		System.out.println("a의 네임" +aaa2.name);
		new AAA2();
	}
}

class AAA2User
{
	AAA2 aaa2;
	AAA2User(){}
	AAA2User( AAA2 aaa2){
		this.aaa2 = aaa2;
	}

	void use(){
		System.out.println("#name: " + aaa2.name);
		aaa2.m();
	}


}
