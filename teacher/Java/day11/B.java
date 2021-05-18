class B {
	int age = 10;
	B(int age){
		this.age = age;
	}
	void m(){
		System.out.println("B�� m()");
	}
}
class BChild extends B {
	int age = 100;
	BChild(){
		super(20); //1
	}
	void m(){ //�������̵� 
		System.out.println("BChild�� m()");
	}
	void use(){
		super.m(); //2 
	}
	void showAge(){
		System.out.println("super.age: " + super.age);
	}
}

class BUser {
	public static void main(String args[]){
		BChild bc = new BChild();
		bc.showAge();
		bc.m();
		bc.use();
	}
}
