class E 
{
	int i = 10;
    static int j = 20;
    
	void use(){
		System.out.print("m() i: " + i);
	}
}

class Euser
{
	public static void main(String[] args) 
	{
		E e = new E();
        System.out.println("e.i: " + e.i);
		System.out.println("E.j: " + E.j);
		e.use();
	}
}
