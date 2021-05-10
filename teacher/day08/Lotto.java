import java.io.*;
import java.util.*;

class Lotto  
{
	String fname = "�츮��.txt";
	String names[];
	Random r = new Random();
    int count;
	BufferedReader br = null;
	FileReader fr = null;
	BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
    String line = ""; //���� �����̸� 

	int idx;  //��÷��ȣ 
	Lotto(){
        readFileName();
		names = new String[count]; //�迭��ü ���� 
		idx = r.nextInt(names.length); //��÷�� �ε��� 

		showResult();
		showNames(); //���� ���� ����Ʈ
		showLotto();
	}
	void readFileName(){
		
		try{
			p("���� ���� �̸�(�⺻:�츮��.txt): "); 
	     	line = brKey.readLine();
		    if(line != null) line = line.trim();
			if(line.length() == 0) line = fname; 
			fr = new FileReader(line);
			//pln(line+"������ ã��");
			readFileCount();
		}catch(FileNotFoundException fe){
			//pln(line+"������ ã�� ������");
			readFileName();
		}catch(IOException ie){
		}
	}
	void readFile(){
		BufferedReader br = null;
		String name = "";
		try{
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){
				names[i] = name;
				i++;
			}
		}catch(IOException ie){
		}
	}
	void readFileCount(){
		BufferedReader br = null;
		String name = "";
		try{
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){
				i++;
			}
			count = i;
		}catch(IOException ie){
			count = -1;
		}
	}
	void showResult(){
		FileReader fr = null;
		BufferedReader br = null;
		String name = "";
		try{
			fr = new FileReader(line);
			br = new BufferedReader(fr);
			int i = 0; 
			while((name = br.readLine()) != null){
				names[i++] = name;
			}
		}catch(IOException ie){}
	}
	void showNames(){
		for(int i=0; i<names.length; i++){
			pln("names["+i+"]: " + names[i]);
		}
	} 
    void showLotto(){
		//for(int i=0; i<names.length; i++){
			pln("��÷��: " + names[idx]);
		//}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		new Lotto();
	}
}
