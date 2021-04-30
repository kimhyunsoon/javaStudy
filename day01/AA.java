class AA 
{
	AA() { //(5)»ý¼ºÀÚ(constructor)
		System.out.println("B()");
	}
	void m(){
		System.out.println("¼øÀÌ¶Ë²¿");
	}

	
	public static void main(String[] args){
		AA SOON = new AA();
		SOON.m();
	}
	
}