class A  
{
	boolean flag = true;

	void m1(){
		aa:
		for (int j=0; j<2; j++){
			for (int i=0; i<5; i++){
				if(i==3) break aa; //break �ڽ��� �ѷ��� ù ��° ������ ������
				System.out.println("j: " + j + ", i: " + i);
			}
			System.out.println("���� for ����");
		}
		System.out.println("�ٱ��� for ����");
	}
	void m2(){
		bb:
		for (int j =0; j<2;j++){
			for (int i=0;i<5 ;i++ ){
				if(i==2) continue bb; //���ǿ� ������ �ǳʶڴ�(�������� �ʴ´�?) ���ǰ� �Բ� ���´�
				System.out.println("j: " + j + ", i: " + i);

			}
			System.out.println("���� for ����");;
		}

		System.out.println("�ٱ��� for ����");
	}
	void m3(){
		System.out.println("m3(): 1");
		if(flag) return; 
		System.out.println("m3(): 2");
	}
	
	A(){
		m3();
		System.out.println("B()");
	}
	
	
	

	public static void main(String[] args) 
	{
		A a = new A();
		a.m1();
		a.m2();
		a.m3();
		
	}
}
