abstract class D {
	//abstract int i; ������ ���� �� ���� 
    //abstract D(); �����ڿ��� ���� �� ���� 
	void m1(){
		System.out.println("�Ϲݸ޼ҵ� m1()");
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
