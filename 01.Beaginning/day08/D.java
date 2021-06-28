class D 
{
	int plus(int a, int b){
		return a+b; //1000? 
	}
}
class DUser 
{
	public static void main(String[] args) 
	{
		D d = new D();
		int r = d.plus(100, 200);
		System.out.println("??: " + r);
	}
}
