class A 
{
	String name = "ȫ�浿";
	
	A(){
		this("�̰���"); //3
		AUser u = new AUser(this); //2
		u.use();
	}
	A(String name) {
		this.name = name; //1
	}
	void m(){
		System.out.println("A�� m()");
	}
	public static void main(String[] args) {
		new A();
	}
}
