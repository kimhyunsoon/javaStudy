import java.util.*;
import java.io.*;

class Homework 
{
	String fName = "�츮��.txt";
	Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
	ArrayList<String> listInDir = new ArrayList<String>();
	
	void readF(){ //(1)
		File f = new File(fName);
		if(f.exists()) {
			saveToTable(f);
		}
		else pln("��� ����("+fName+")�� �־��ּ���");
	}
	void saveToTable(File f){
		BufferedReader brF = null;
		try{
			String line = "";
			brF = new BufferedReader(new FileReader(f));
			while((line = brF.readLine()) != null){
				line = line.trim();
				if(line.length() != 0){
					table.put(line, false);
				}
			}
			//testTable(); 
			readD();
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}
	}
	/*void testTable(){
		Set<String> keys = table.keySet();
		for(String key : keys) pln(key +" , " + table.get(key));
		int size = table.size();
		pln("��: " + size + "��");
	}*/


    BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in));
	void readD(){ //(2)
		String line = "";
		p("�����˻� ���丮: "); 
		try{
			line = brKey.readLine();
			File d = new File(line);
			if(d.exists()) {
				if(d.isFile()){
					pln("��.. ������ �ȵǿ�. ���丮�� �Է����ּ���");
					readD();
				}else{
					//pln("pass");	
					saveToListInDir(d);
				}
			}else {
				pln("�ٽ� �Է����ּ���..���丮�� ã�� ���߾��");
				readD();
			}
		}catch(IOException ie){
		}
	}
	void saveToListInDir(File d){
		File kids[] = d.listFiles();
		for(File kid : kids) {
			String name = kid.getName();
			if(!name.equals("teacher")){
				if(!kid.isFile()){
					listInDir.add(name);
				}
			}
		}

		//testListInDir();	
	}
	/*void testListInDir(){
		for(String name : listInDir) pln(name);
	}*/
	
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		Homework hw = new Homework();
		hw.readF();
	}
}

/*
 (1) �л���� ������ �о Map ���� 
     cf) Hashtable<String, Boolean>
 (2) ���� ���丮 �Է� 
     ( �ش� ���丮�� ���� ���� )
 (3) ���� ���丮 ������ ������ �о �迭(List)�� ���� 
     cf) ArrayList
 (4) Map(�л����)�� �����Ϳ� Array�����͸� ���ؼ� Map�� value�� ���� 
 (5) ����� Map�� key���� ��� 

*/