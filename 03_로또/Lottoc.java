import java.io.*;
import java.util.*;


class Lottoc 
{
	
	String fname = "�츮��.txt"; //�����̸� ����
	String names[] = new String [32]; 
	Random r = new Random();

	BufferedReader br = null;
	FileReader fr = null;
	BufferedReader brKey = new BufferedReader(new InputStreamReader (system.in)); 
	
	int idx; //��÷�� �ε���
	Lotto(){
		idx = r.nextInt(names.length); //����� ��÷��ȣ�� ����
		
	}
	
	void readFileName(){//�����̸� �д� �Լ�
		String line="";
		try{
			System.out.println("���� ���� �̸� (�⺻ : �츮��.txt)");
			line = brKey.readLine();
			if(line !=null)
		
		}
	
	}	
	
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
