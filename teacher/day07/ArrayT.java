class ArrayT 
{
	String items[] = {"��", "����", "����", "�ܿ�"};

	void out(){
		for(String item: items){
			System.out.println("item: " + item);
		}
	}
	public static void main(String[] args) 
	{
		new ArrayT().out();
	}
}
