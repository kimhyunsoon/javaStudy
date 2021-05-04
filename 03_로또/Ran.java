import java.util.*;

class Ran 
{
	Random r = new Random();
	void m(){
		int i = r.nextInt(32); //0~(n-1)
		System.out.println("i: " + i);
	}
	public static void main(String[] args) 
	{
		new Ran().m();
	}
}

//#>java Lotto

