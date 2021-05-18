class C 
{
	
	void m(){
	
		System.out.println("c의 메소드");
	}
	
	

}


class CChild extends C
{
	void m(){
	
		System.out.println("c차일드의 메소드");
	
	}
}


class CUser
{

		public static void main(String[] args){

			CChild cc= new CChild();
			cc.m();
	}
}