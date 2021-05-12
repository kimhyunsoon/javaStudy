class BBB 
{
	int age = 10;
	BBB(int age){
	
		this.age=age;
		//지역을 멤버로 꺼내줘야 의미가 생김
	}
	void m(){
		System.out.println("bㅇ의 엠");
	}

}


class BBBChild extends BBB
{
	int age = 100;
	
	BBBChild(){
		super(20);
	}

	void m(){ //오버라이딩
		System.out.println("b차일드ㅇ의 엠");
	}


	void use(){
		super.m();
	}

	void showAge(){
		System.out.println("bㅇ의 나이"+super.age);
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