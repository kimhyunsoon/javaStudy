class MyExc extends Exception {//Exception : 프로그램에서 처리하는 예외 클래스의 최상위 클래스
	void f1(){
		System.out.println("MyException의 기능");
	}
	public String toString(){
		return "MyException";
	}
}
class YourExc extends Exception {
	void f2(){
		System.out.println("YourException의 기능");
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

