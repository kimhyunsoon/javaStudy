import java.io.*;
import java.util.*;

class Lotto 
{
	String fname = "�츮��.txt";
	Lotto(){
		FileReader fr = null; // ������ �ҷ��´�
		BufferedReader br = null; //�� ���� �ҷ��´�
		String name = ""; //�ʱ�ȭ
		try{
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			int i =0; 
			while((name = br.readLine()) != null){ //while���� �ݺ��� ���� ���پ� �д´�
				pln("name: "+name);
				i++; 
			}
			pln("�� "+i+"�� �˻� �Ϸ�!!");
		}catch(FileNotFoundException fe){
			pln(fname+"������ ã�� ������");
		}catch(IOException ie){
		}
	}
    
    String strs[] = {"��ũ","ǻ��","�ƿ�����","�巡����"}; //����� ����
    void out1(){
        for(int i=0;i<strs.length; i++){
            System.out.println("strs[0]: "+strs[i]);
        }
     }

	void pln(String str){
		System.out.println(str);
	}

    Random r = new Random();
	void m(){
		int i = r.nextInt(32); //0~(n-1)
		System.out.println("i: " + i);
	}
	public static void main(String[] args) 
	{
		new Ran().m();
        new Lotto();
	}

	
}
