class C {

	void m1(){ //������ ( byte, short, char, int ) + String (JDK7~)
		int i = 20;
		switch(i){
			case 10: System.out.println("10"); break;
			case 20: 
				System.out.println("20"); 
				break;
			case 30: System.out.println("30"); break;
			default: System.out.println("10�� 20�� 30�� �ƴϴ�");
		}//
	}
	void m2(){
		String str = "����";
		char c = 'Z';
		switch(str){
			case "��ħ": System.out.println("��ħ"); break;
			case "����": 
				 switch(c){
				    case 'A': System.out.println("A"); break;
					case 'B': System.out.println("B"); break;
					default: System.out.println("A�� B�� �ƴ�");
				 }
                 break;
			default: System.out.println("����"); 
		}//
	}
	void m3(){
		String str = "����";
		char c = 'Z';
		switch(str){
			case "��ħ": System.out.println("��ħ"); break;
			case "����": 
				if(c == 'A') System.out.println("A");
			    else if(c == 'B') System.out.println("B");
				else System.out.println("A�� B�� �ƴ�"); 

				break;
			default: System.out.println("����"); 
		}//
	}
	public static void main(String[] args) 
	{
		C c = new C();
		//c.m1();
		//c.m2();
		c.m3();
	}
}
