class B 
{
	int age = 10;
	B(int age){
	
		this.age=age;
		//������ ����� ������� �ǹ̰� ����
	}
	void m(){
		System.out.println("b���� ��");
	}

}

class BChild extends B
{
	
	BChild(){
		super(20);
	}
	void m(){
		System.out.println("b���ϵ夷�� ��");
	}
}

	void use(){
		super.m();
	}



class BUser
{
	public static void main(String[] args) 
	{
		BChile bc = new BChild();
		System.out.println("b���� ����"+bc.age);
		bc.m();
		bc.use();
	}
}