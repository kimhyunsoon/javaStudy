class C 
{
	//�������� �󸶳� �����°�

	int kb = 500000;
	int wel = 300000;
	int wb = 100000;
	double incomeTax = 0.165;
	

		

	void cal1(){ //kb ���ڰ��(�ܸ�)
		double rate = 0.05; //������
		int savingYear = kb*12;	//1�� �����	
		double tax = kb*rate*12; //���ڱݾ�
		double prevTax = savingYear+tax; //�����ݾ�
		
		
		System.out.println("�������� ����ȯ�ޱݾ�: " + (int)(prevTax-tax*incomeTax) +"��");
		System.out.println("�������� 1�������: " + savingYear+"��");
		System.out.println("�������� 1������: " + (int) tax+"��");
		System.out.println("�������� �����ݾ�: " + (int)(savingYear+tax)+"��");
		System.out.println("�������� ���ڼҵ漼: " + (int)(tax*incomeTax)+"��");
	}

	void cal2(){ //���� ���ڰ��(�ܸ�)
		double rate = 0.03; //������
		int savingYear = wel*12;	//1�� �����	
		double tax = wel*rate*12; //���ڱݾ�
		double prevTax = savingYear+tax; //�����ݾ�
		
		
		System.out.println("���Ĺ�ũ ����ȯ�ޱݾ�: " + (int)(prevTax-tax*incomeTax)+"��");
		System.out.println("���Ĺ�ũ 1�������: " + savingYear+"��");
		System.out.println("���Ĺ�ũ 1������: " + (int) tax+"��");
		System.out.println("���Ĺ�ũ �����ݾ�: " + (int)(savingYear+tax)+"��");
		System.out.println("���Ĺ�ũ ���ڼҵ漼: " + (int)(tax*incomeTax)+"��");
	}
	

	public static void main(String[] args) 
	{
		C c= new C();
		System.out.println("-----��������-----");
		c.cal1();
		System.out.println("-----���Ĺ�ũ-----");
		c.cal2();
	}

}





/* public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}*/