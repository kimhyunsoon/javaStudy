class B 
{
	static int i;
	B(){
	}
	static void m(){
		System.out.println("m()");
	}
	
}



class BUser
{

    public static void main(String args[]){
		System.out.println("i: " + B.i);
		B.m();
	}



}
