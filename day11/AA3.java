class AA3 extends Object
{
	String name = "홍길동";
	
	AA3(){

		this("이건희");
		AA3User aa3u=new AA3User(this);
		aa3u.use();
	}
	
	AA3(String name){
		super();
		this.name = name;
	}

	void m(){
		System.out.println("A의 메소드" );
	}
	
	public static void main(String[] args) 
	{
		new AA3();
	}
}


class AA3User
{
	
	AA3 aa3;
	AA3User(){}
	AA3User(AA3 aa3){
		this.aa3 = aa3;
	}
	
	void use(){

		System.out.println("#의 네임" +aa3.name);
		aa3.m();
	}
}
