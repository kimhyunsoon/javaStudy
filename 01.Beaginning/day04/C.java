class C 
{

	void m1(){ 
		/*byte, short, char, int �� �������� �� �� �ִ�.
		JDK7 ���ĺ��ʹ� String �� String str = " "; */

		
		int i = 20; 
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: System.out.println("20");
					 System.out.println("21");
					 System.out.println("22");
					 break;
			case 30: System.out.println("30"); break;
			default: System.out.println("10�� 20�� 30�� �ƴϴ�"); //��ġ�� ���谡 ����
			
		}
	} //����ġ��




	void m2(){
		String str = "����";
		int i = -10;
		switch(str) {
			case "��ħ": System.out.println("��ħ"); break;
			case "����": 
				if(i>0) System.out.println("����A"); 
				else if(i<0) System.out.println("����B");
				else System.out.println("A�� B�� �ƴ�");
				break;				
			default: System.out.println("����"); 
		}
	}

	void m3(){
		String str = "����";
		char c = 'A';
		switch(str) {
			case "��ħ": System.out.println("��ħ"); break;
			case "����": 
				switch(c){
				case 'A' : System.out.println("����A"); break;
				case 'B' : System.out.println("����B"); break;
				default : System.out.println("A�� B�� �ƴ�");
			}
				break;				
			default: System.out.println("����"); 
		
		
		}
	
	
	}



	public static void main(String[] args) 
	{
		C c = new C();
		c.m1();
		c.m2();
		c.m3();
	}
}
