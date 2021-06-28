class C 
{
	//Àû±ÝÀ¸·Î ¾ó¸¶³ª ¹ú¾ú´Â°¡

	int kb = 500000;
	int wel = 300000;
	int wb = 100000;
	double incomeTax = 0.165;
	

		

	void cal1(){ //kb ÀÌÀÚ°è»ê(´Ü¸®)
		double rate = 0.05; //ÀÌÀÚÀ²
		int savingYear = kb*12;	//1³â ÀúÃà¾×	
		double tax = kb*rate*12; //ÀÌÀÚ±Ý¾×
		double prevTax = savingYear+tax; //¼¼Àü±Ý¾×
		
		
		System.out.println("±¹¹ÎÀºÇà ¸¸±âÈ¯±Þ±Ý¾×: " + (int)(prevTax-tax*incomeTax) +"¿ø");
		System.out.println("±¹¹ÎÀºÇà 1³âÀúÃà¾×: " + savingYear+"¿ø");
		System.out.println("±¹¹ÎÀºÇà 1³âÀÌÀÚ: " + (int) tax+"¿ø");
		System.out.println("±¹¹ÎÀºÇà ¼¼Àü±Ý¾×: " + (int)(savingYear+tax)+"¿ø");
		System.out.println("±¹¹ÎÀºÇà ÀÌÀÚ¼Òµæ¼¼: " + (int)(tax*incomeTax)+"¿ø");
	}

	void cal2(){ //À£¹ð ÀÌÀÚ°è»ê(´Ü¸®)
		double rate = 0.03; //ÀÌÀÚÀ²
		int savingYear = wel*12;	//1³â ÀúÃà¾×	
		double tax = wel*rate*12; //ÀÌÀÚ±Ý¾×
		double prevTax = savingYear+tax; //¼¼Àü±Ý¾×
		
		
		System.out.println("À£ÄÄ¹ðÅ© ¸¸±âÈ¯±Þ±Ý¾×: " + (int)(prevTax-tax*incomeTax)+"¿ø");
		System.out.println("À£ÄÄ¹ðÅ© 1³âÀúÃà¾×: " + savingYear+"¿ø");
		System.out.println("À£ÄÄ¹ðÅ© 1³âÀÌÀÚ: " + (int) tax+"¿ø");
		System.out.println("À£ÄÄ¹ðÅ© ¼¼Àü±Ý¾×: " + (int)(savingYear+tax)+"¿ø");
		System.out.println("À£ÄÄ¹ðÅ© ÀÌÀÚ¼Òµæ¼¼: " + (int)(tax*incomeTax)+"¿ø");
	}
	

	public static void main(String[] args) 
	{
		C c= new C();
		System.out.println("-----±¹¹ÎÀºÇà-----");
		c.cal1();
		System.out.println("-----À£ÄÄ¹ðÅ©-----");
		c.cal2();
	}

}





/* public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}*/