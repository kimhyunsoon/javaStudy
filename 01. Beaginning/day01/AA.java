class AA 
{
	AA() { //(5)������(constructor)
		System.out.println("B()");
	}
	void m(){
		System.out.println("���̶˲�");
	}

	
	public static void main(String[] args){
		AA SOON = new AA();
		SOON.m();
	}
	
}