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
	String Fname = "우리반.txt";
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
							System.out.println("주작하려면 이름과 숫자사이에 공백이 존재해야해용");
							System.exit(0);
						}catch(NumberFormatException ne){
								System.out.println("확률이 잘못되었습니다. 파일을 확인해주세요");
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
			System.out.println("입력하신 주작확률 중에 0보다 작은게 들어있네용 다시하세용");
			System.exit(0);
			}
			else{
			rateT +=map1.get(key1);
			}
		}
		if(rateT>100){
			System.out.println("주작할려는사람이 너무많아 100이 넘어버렸습니다. 다시 조정하세욤");
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
				System.out.println("당첨자는"+key1+"입니다");
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
				System.out.println("당첨자는"+map.get(key)+"입니다");
			}
		}
	}
	public static void main(String args[]){
		new A();
	}
}


 