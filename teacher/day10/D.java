abstract class D {
	//abstract int i; 변수에 붙을 수 없음 
    //abstract D(); 생성자에도 붙을 수 없음 
	void m1(){
		System.out.println("일반메소드 m1()");
	}
	abstract void m2(); 
}
class DChild extends D {
	void m2(){
		System.out.println("DChild m2()");
	}
}

class DUser{
	public static void main(String args[]){
		D d = new DChild(); 
		d.m1();
		d.m2();
	}
}
