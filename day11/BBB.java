class BBB 
{
	int age = 10;
	BBB(int age){
	
		this.age=age;
		//������ ����� ������� �ǹ̰� ����
	}
	void m(){
		System.out.println("b���� ��");
	}

}


class BBBChild extends BBB
{
	int age = 100;
	
	BBBChild(){
		super(20);
	}

	void m(){ //�������̵�
		System.out.println("b���ϵ夷�� ��");
	}


	void use(){
		super.m();
	}

	void showAge(){
		System.out.println("b���� ����"+super.age);
	}
}

class BBBUser
{
	public static void main(String[] args) 
	{
		BBBChild bc = new BBBChild();
		bc.ShowAge();
		bc.m();
		bc.use();
	}
}