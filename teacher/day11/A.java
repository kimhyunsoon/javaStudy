class A 
{
	String name = "È«±æµ¿";
	
	A(){
		this("ÀÌ°ÇÈñ"); //3
		AUser u = new AUser(this); //2
		u.use();
	}
	A(String name) {
		this.name = name; //1
	}
	void m(){
		System.out.println("AÀÇ m()");
	}
	public static void main(String[] args) {
		new A();
	}
}
