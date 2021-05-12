class D 
{
	D(){
	}
	D(String str){
	}
	int m(int i){
		System.out.println("1");
		return i;
	}
	String m(String str){
		return str;
	}
}
class DChild extends D 
{
	void m(int i, String str){ 
	}
	int m(byte b){ //오버로딩인정? O  
	    System.out.println("2");
		return b;
	}
}

class DUser{
	public static void main(String[] args) {
		DChild d = new DChild();
		byte b = 10;
		int r = d.m(b);
		System.out.println("r: " + r);
	}
}
