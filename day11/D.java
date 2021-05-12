class D 
{
	
	D(){
	
	
	}
	D(String str){
	
	
	}

	int m(int i){
	
	
	}
	String m(String str){
	
	
	}
}

class DChild extends D
{
	void m(int i, String str){
	} //메소드 오버로딩

	int m(byte b){
		return b;
	}
}

	
class DUser
{

	public static void main(String[] args) 
	{
		D d = new D("");
		D.m(10);
	}

}