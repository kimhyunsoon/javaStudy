class MyException extends Exception
{
	void print1(){
		System.out.println("MyException의 기능");
	}
	public String toString(){
		return "MyException";
	}
}


class YourException extends Exception
{
	void print2(){
		System.out.println("YourException의 기능");
	}
	public String toString(){
		return "YourException";
	}
}

class A
{
	boolean b;
	boolean b1;
	boolean b2 = true;

	A() throws Exception{
		if(b) throw new Exception();
	}
	void use1() throws MyException{
		if(b1) throw new MyException();
	}
	void use2() throws YourException{
		if(b2) throw new YourException();
	}
}

class AUser
{
	void call(){
		try{
			A a = new A();
			a.use1();
			a.use2();
		}catch(MyException me){
			me.f1();
		}catch(YourException ye){
			ye.f2();
		}catch(Exception e){
			System.out.println(e);
		}
	
	}
	public static void main(String[] args) 
	{
		new AUser().call();
	}
}


