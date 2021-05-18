import java.io.*;
import java.util.*;

class Tip 
{
	String fName = "�츮��.txt";
    TreeSet<String> ts = new TreeSet<String>();
   
	void verifyF(){
		File f = new File(fName);
		if(f.exists()){
			//pln("����("+fName+") ����");
			if(f.isDirectory()){
				//pln("���丮");
			}else{
                //pln("����"); //�ǹ� ���� 
				readF(f);
			} 
		}else {
			//pln("����("+fName+") ��ã��");
		}
	}
	void readF(File f){
		FileReader fr = null;
		BufferedReader br = null;
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null){
				line = line.trim();
				if(line.length() != 0)
					ts.add(line);
			}

			//showResult();
			while(true) searchName();
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}
	}
	void showResult(){
		for(String name: ts) pln(name);
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	void searchName(){
		p("�˻��� �̸�: ");
		try{
			String sName = br.readLine();
			sName = sName.trim();
			if(sName.equals("list")){
				showResult();
				return;
			}else if(sName.equals("exit")){
				System.exit(0);
			}else {
				for(String name: ts) {
					if(name.equals(sName)){
						pln("�����ϴ� ȸ��");
						return;
					}
				}
				pln("�������� �ʴ� ȸ��");
			}
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void p(String str){
		System.out.print(str);
	}
	public static void main(String[] args) 
	{
		Tip t = new Tip();
		t.verifyF();
	}
}
