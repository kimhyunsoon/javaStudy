import java.io.*;

class Listing  
{
	String fname = "�츮��.txt";
	Listing(){
		FileReader fr = null; // ������ �ҷ��´�
		BufferedReader br = null; //�� ���� �ҷ��´�
		String name = ""; //�ʱ�ȭ
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){ //while���� �ݺ��� ���� ���پ� �д´�
				pln(name);
				i++; 
			}
			pln("�� "+i+"�� �˻� �Ϸ�!!");
		}catch(FileNotFoundException fe){
			pln(fname+"������ ã�� ������");
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new Listing();
	}
}
