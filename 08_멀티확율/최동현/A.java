import java.io.*;
import java.util.*;

class A{
		A(){
			readFile1();
			readFile2();
			calRateT();
			manipulate();
			RandomizeRest();
		}
	String Fname = "�츮��.txt";
	String line;
	String rName;
	String key1;
	int s;
	int i;
	int rate;
	int idx;
	int rateT;
	BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();
	Hashtable<String,Integer> map1 = new Hashtable<String,Integer>();
	FileReader fr = null;
	Random r = new Random();
	void readFile1(){		
		try{
			FileReader fr = new FileReader(Fname);
			BufferedReader br = new BufferedReader(fr);
			while((line=br.readLine())!=null){
				line = line.trim();
				if(line.length()>3){
					try{
						int idx = line.indexOf(" ");
						String name =line.substring(0,idx);
						String strRate = line.substring(idx);
						if(strRate.length()!=0) strRate = strRate.trim();
						rate = Integer.parseInt(strRate);
						rName=name;
						map1.put(rName,rate);
						}catch(StringIndexOutOfBoundsException se){
							System.out.println("�����Ϸ��� �̸��� ���ڻ��̿� ������ �����ؾ��ؿ�");
							System.exit(0);
						}catch(NumberFormatException ne){
								System.out.println("Ȯ���� �߸��Ǿ����ϴ�. ������ Ȯ�����ּ���");
								System.exit(0);
						}
				}
			}	
		}catch(IOException ie){}
	}
	void readFile2(){
		
		try{
			FileReader fr = new FileReader(Fname);
			BufferedReader br = new BufferedReader(fr);
			i = 0;
			while((line=br.readLine())!=null){
				line = line.trim();
				if(line.length()==3){
					i++;
					map.put(i,line);	
				}	
			}
		}catch(IOException ie){}
	}
	void calRateT(){
		Set<String> keys1 = map1.keySet();
		for(String key1 : keys1){
			if(map1.get(key1)<0){
			System.out.println("�Է��Ͻ� ����Ȯ�� �߿� 0���� ������ ����ֳ׿� �ٽ��ϼ���");
			System.exit(0);
			}
			else{
			rateT +=map1.get(key1);
			}
		}
		if(rateT>100){
			System.out.println("�����ҷ��»���� �ʹ����� 100�� �Ѿ���Ƚ��ϴ�. �ٽ� �����ϼ���");
			System.exit(0);
		}
		else{
			return;
		}
	}
	void manipulate(){
		Set<String> keys1 = map1.keySet();
		for(String key1 : keys1){
			idx = r.nextInt(100);
			if(idx==0){
				manipulate();
			}
			else{
				if(idx<=map1.get(key1)){
				System.out.println("��÷�ڴ�"+key1+"�Դϴ�");
				System.exit(0);
				}
				else if(idx>map1.get(key1)){
					continue;
				}
			}
		}
		if(rateT==100){
			manipulate();
		}
	}
	void RandomizeRest(){
		idx = r.nextInt(i);
		Set<Integer>keys = map.keySet();
		for(int key : keys){
			if(idx==key){
				System.out.println("��÷�ڴ�"+map.get(key)+"�Դϴ�");
			}
		}
	}
	public static void main(String args[]){
		new A();
	}
}


 