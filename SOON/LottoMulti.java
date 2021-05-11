import java.io.*;
import java.util.*;

class LottoMulti 
{
	String fName = "�츮�ݸ���Ʈ.txt"; //�ҷ��� ���� ����Ʈ��
	String list; //���� ���� �̸�
	FileReader fr;
	BufferedReader br;
	BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in)); 
	boolean numCheck;
	int count;
	
	TreeSet<String> set = new TreeSet<String>();
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	LottoMulti(){
		findFile();
		putMap();
		readCount();
		pln("");
		pln("������ ��÷�ڴ�....!!");
		pln("");
		showResult();
	}

	//1. �⼮ ����Ʈ���� �ҷ�����
	void findFile(){ 
		try{
			System.out.print("����Ʈ ����(�⺻ : �츮�ݸ���Ʈ.txt): ");
			list = brkey.readLine();
			if(list !=null){// ���� ����
				list = list.trim();
			};   
			if(list.length()==0){ //�Է¹��� ������ ����Ʈ���� list�� ����
				list = fName;
			};
			fr = new FileReader(list);
			File f = new File(list);
			readFile(f);
		}catch(FileNotFoundException fe){
			pln("������ ã�� ���߾�� :(");
			findFile();
		}catch(IOException ie){
		}
	}

	//2. ������ �а� set�� ����
	void readFile(File f){ 
		try{
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String name = "";
			while((name = br.readLine()) != null){
				name = name.trim();
				if(name.length() !=0){
					set.add(name);
				}
			}
		}catch(FileNotFoundException fe){
		}catch(IOException ie){
		}
	}

	//3. �̸������� ���ĵ� set�� ��ҵ��� map�� ��ȣ�� �Բ� �Է���
	void putMap(){
		int i =0;
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){ //������ �ִ�? ������ true�� ��ȯ, ������ false
		   map.put(i+1, iter.next());
		   i++;
		}
	  }

	//4. ��÷�ڼ� �Է¹ޱ�
	Scanner s = new Scanner(System.in);
	void readCount(){
		System.out.print("��÷�ڼ��� �Է��ϼ��� : ");
		String input = s.nextLine();
		
		// �߰��� �޽��_Scanner�� ���� ���ڰ� ����(����)���� Ȯ��
		numberCheck(input); 
		
		if(!numCheck || input.length() == 0) { // numberCheck(); ���� ������ numCheck�� false�ų� input�� ���̰� 0�̸�
			pln("��÷�ڼ��� ���ڷ� �Է����ּ���!");
			readCount();
		} else {
			count = Integer.parseInt(input); // �������� Ȯ���� ���� String���� �޾Ҵ� �Է°��� int�� ��ȯ��
			if(count<=0){
				pln("�ּ��� 1���� �̾��ֶ�!");
				readCount();
			}else if(set.size()<count){
				pln("��÷�ڼ��� " +set.size()+ " ���Ϸ� �Է����ּ���!");
				readCount();
			} else {
				readName();
			}
		}
	}

	//5. ���� ���� �� set�� ����
	void readName() {
		Random ran = new Random();
		set.clear(); //set�� ��� ��� ����(���� set�� �ѹ� �� ��Ȱ���ϱ� ����)
		while(set.size() < count) { 
			int j = ran.nextInt(map.size()); //���� ����
			set.add(map.get(j+1)); //map.get���� value�� �޾Ƽ� ���µ� set�� ����
		}
	}

	//6. set�� ����� ��ҿ� map�� ��� ��, �� ���
	void showResult(){	
		Iterator<String> iter = set.iterator();
		Set<Integer> keys = map.keySet();
		while(iter.hasNext()){
			String item = iter.next(); //���µ� set�� ����� ��Ҹ� item ������ ����
			for(Integer key: keys){ 
				if(item == map.get(key)){ //map�� �ִ� val���� item�� ���ٸ� 
					System.out.println(key+"�� : "+item); //item�� �ش�Ǵ� key�� ���
				}
			}
		}
		pln("");
		System.out.println(count+"�� �����մϴ�!");
	}


	//�߰��� �޽��_Scanner�� ���� ���ڰ� ����(����)���� Ȯ��
	void numberCheck(String a){ // �Ű������� ���ڿ�(�Է°�)�� ����
		numCheck = true;
		for (int i =0; i<a.length(); i++) { // �Ű����� �Է°��� ���ڿ� ���� ��ŭ ����
			char tmp = a.charAt(i); // �Ű����� �Է°��� i��° ���ڸ� tmp�� ����
			if(!Character.isDigit(tmp)){ // tmp�� ���ڰ� �ƴϸ�
				numCheck = false; // numCheck�� false�� �ٲ�
			} 
		}
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		new LottoMulti();
	}
}