class A3 
{
	int i;
	A3(int i){
		this.i = i;
	}
	A3(){
		this(10); //(3) 자신의 생성자 호출  
	}
	public static void main(String[] args) 
	{
		System.out.println("i: " + new A3().i);
	}
}
