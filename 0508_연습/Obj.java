class E // Å¬·¡½º
{
	int i = 10;
    static int j = 20;
    
	void use(){
		System.out.print("m() i: " + i);
	}
}
class A {
    static int a = 40;
}
class Euser{

	public static void main(String[] args) 
	{
		E e = new E(); //°´Ã¼
        System.out.println("e.i: " + e.i);
		System.out.println("E.j: " + E.j);
		System.out.println("A.a: " + A.a);
        
		e.use();
	}
}