class E //������ 2��
{
	void m1(){
		for (int i=1; i<10; i++ )
		{
			System.out.println("2 * "+i+" = " + 2*i);
		}
	}


	
	void m2(){ //������
		for (int i=2; i<10; i++ )
		{
			System.out.println();
			for (int j=1; j<10 ; j++ )
			{
				System.out.println(i + " * " + j + " = " + i*j);
			}
						
		}
	}

	void m3(){ ///999��
		for (int i=2; i<10 ;i++ )
		{
			
			for (int j=1;j<10 ; j++ )
			{
				for (int k=1;k<10 ;k++ )
				{
					System.out.println(i+" * "+j+" * "+k+" = "+i*j*k);
				}
			}
			System.out.println();
		}
	}


	void m4(){ ///999��
		int i = 1; //�ʱ��
		while (i<9)
		{
			
			i++;
			int j = 0;
			while (j<9)
			{
				j++;
				int k = 1;
				while (k<=9)
				{
					System.out.println(i+" * "+j+" * "+k+" = "+i*j*k);
					k++;
				}
				System.out.println();
			}
			System.out.println();
		}
		

	}


	
	public static void main(String[] args) 
	{
		E e = new E();
		System.out.println("------��������-----");
		//e.m2();
		e.m4();
	}
}
