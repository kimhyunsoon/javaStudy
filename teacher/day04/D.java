class D 
{
	void m1(){ //for while�� ( �Ż� )
		int i = 0 ;  //�ʱ�� 
		while(i<0){ //���ǽ� 
			System.out.println("i: " + i);
			i++; //������
		}

		System.out.println("while�� ����");
	}
	void m2(){ //for do while�� ( ���� )
		int i = 0 ;  //�ʱ�� 
		do{  
			System.out.println("i: " + i);
			i++; //������
		}while(i<0); //���ǽ�

		System.out.println("do while�� ����");
	}
	void m3(){ //for for�� ( �Ż� )
		for(int i=0; i<5; i++){
			System.out.println("i: " + i);
		}

		System.out.println("for�� ����");
	}
	void m4(){
		for(;;){ //== while(true){}
			System.out.println("���ѷ���");
		}
	}
	public static void main(String[] args) 
	{
		D d = new D();
		//d.m1();
		//d.m2();
		//d.m3();
		d.m4();
	}
}