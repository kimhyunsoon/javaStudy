class C 
{
	
	void m(){
	
		System.out.println("c�� �޼ҵ�");
	}
	
	

}


class CChild extends C
{
	void m(){
	
		System.out.println("c���ϵ��� �޼ҵ�");
	
	}
}


class CUser
{

		public static void main(String[] args){

			CChild cc= new CChild();
			cc.m();
	}
}