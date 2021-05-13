class A2 
{
	int age = 27;
	String name = "홍길동";
	A2(){
		A2Friend f = new A2Friend(this); //(2) 자신의 객체를 의미
		f.use();
	}
	void m(){
		System.out.println("A2의 m()");
	}
	public static void main(String[] args) {
		new A2();
	}
}
class A2Friend 
{
	A2 a2;
	A2Friend(A2 a2){
		this.a2 = a2;
	}
	void use(){
		System.out.println("#age: " + a2.age);
		System.out.println("#name: " + a2.name);
		a2.m();
	}
}
