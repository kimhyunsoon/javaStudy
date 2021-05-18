class MyExc extends Exception {//Exception : ���α׷����� ó���ϴ� ���� Ŭ������ �ֻ��� Ŭ����
	void f1(){
		System.out.println("MyException�� ���");
	}
	public String toString(){
		return "MyException";
	}
}
class YourExc extends Exception {
	void f2(){
		System.out.println("YourException�� ���");
	}
	public String toString(){
		return "YourException";
	}	
}


class AA {
	boolean b;
	boolean b1 = true;
	boolean b2 = true; 
	AA() throws Exception {
        if(b) throw new Exception();
	}
	void use1() throws MyExc {
		if(b1) throw new MyExc();
	}
	void use2() throws YourExc {
		if(b2) throw new YourExc();
	}
}
class AAUser {
	void call() //throws MyException, YourException, Exception 
	{
		try{
			AA a = new AA();
			a.use1();
			a.use2();
		}catch(MyExc me){
			me.f1();
		}catch(YourExc ye){
			ye.f2();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public static void main(String args[]) {
		new AAUser().call();
	}
}

