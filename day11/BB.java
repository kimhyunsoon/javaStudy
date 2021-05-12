class BB 
{
	int age = 10;
	B(int age){
	
		this.age=age;
		//Áö¿ªÀ» ¸â¹ö·Î ²¨³»Áà¾ß ÀÇ¹Ì°¡ »ý±è
	}
	void m(){
		System.out.println("b¤·ÀÇ ¿¥");
	}
	
	
	
}


class BBChild extends B
{
	
	BChild(){
		super(20);
	}
	void m(){
		System.out.println("bÂ÷ÀÏµå¤·ÀÇ ¿¥");
	}
}

	void use(){
		super.m();
	}



class BBUser
{
	public static void main(String[] args) 
	{
		BChile bc = new BChild();
		System.out.println("b¤·ÀÇ ³ªÀÌ"+bc.age);
		bc.m();
		bc.use();
	}
}