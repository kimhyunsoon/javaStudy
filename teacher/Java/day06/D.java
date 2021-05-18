class D 
{
	byte b = 10;
	short s = 20;
	char c = 'A'; 
    int i = 30;
	float f = 40.5f;

     
	int is[] = {b, s, c, i, (int)f}; //¼±+»ý+ÃÊ 
	
	void out(){
		for(int i=0; i<is.length; i++)
			System.out.println("is["+i+"]: " + is[i]);
	}
	public static void main(String[] args) 
	{
		D d = new D();
		d.out();
	}
}
