class AAA2 //2. �ڽ��� ��ü�� �ٸ� Ŭ�������� �ѱ� ��
{
	String name = "ȫ�浿";
	
	AAA2(){
		AAA2User u=new AAA2User(this); 
		u.use();
	}
		
	AAA2(String name){
		this.name = name;
	}

	void m(){
		System.out.println("AAA2�� �޼ҵ�" );
	}
		
	public static void main(String[] args) 
	{
		
		AAA2 aaa2 = new AAA2("�̼���");
		System.out.println("a�� ����" +aaa2.name);
		new AAA2();
	}
}

class AAA2User
{
	AAA2 aaa2;
	AAA2User(){}
	AAA2User( AAA2 aaa2){
		this.aaa2 = aaa2;
	}

	void use(){
		System.out.println("#name: " + aaa2.name);
		aaa2.m();
	}


}
