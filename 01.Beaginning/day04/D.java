class D
{	
	void m1(){ // for while (�Ż�)
		int i = 0;  //�ʱ�� - ���Ϲ� �ۿ� �־���� ���ѷ���
		while(i<5){ //���ǽ�(���ѷ���)
			System.out.println("i: "+i);
			i++; //������
		}	
		System.out.println("while�� ����");
	}


	void m2(){ //for do while (����)
		int i = 0 ; //�ʱ��
		do{
			System.out.println("i: "+i);
			i++; //������
		
		}while(i<0); //���ǽ�
		System.out.println("do while�� ����");
	}


	void m3(){ //for for�� (�Ż�)
		 for (int i = 0; i<7;i++ ){
			 System.out.println("i: "+i);
		 }
	
		System.out.println("for�� ����");
		
	}

	public static void main(String[] args) 
	{
		D d = new D();
		d.m1();
		d.m2();
		d.m3();
	}
}
