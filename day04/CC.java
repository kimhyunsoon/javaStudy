class CC // ����ġ ���� �ݺ����� 
{
	void m1(){
	
		int i = 30;
		switch(i){
		case 10: System.out.println("10"); break;
		case 20: System.out.println("20"); break;
		case 30: System.out.println("30"); break;
		default : System.out.println("�ش���� �ʴ´�"); break;
		
		}
	}



	void m2(){
		String str = "��ħ";
		int i = 10;  
		switch(str){
			case "��ħ": System.out.println("��ħ");break;
			case "����": 
				if(i>0) System.out.println("����A");
				else if(i<0) System.out.println("����B");
				else System.out.println("�ȸ���");break;
			default: System.out.println("����");
		
		}
	}
	
	void m3(){
		String str = "����";
		char c = 'A';
		switch(str){
			case "��ħ": System.out.println("��ħ");break;
			case "����":
				switch (c){
					case 'A': System.out.println("����A");break;
					case 'B': System.out.println("����B");break;
					default : System.out.println("�ȸ���");
				}
					break;
				default: System.out.println("����");

		
		}
	
	
	
	}




	public static void main(String[] args){
		CC c = new CC();
		c.m1();
		c.m2();
		c.m3();
	}
}

