import java.io.*;

class Listing  
{
	String fname = "�츮��.txt";
	Listing(){
		BufferedReader br = null;
		FileReader fr = null;
		String name = "";
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){
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
