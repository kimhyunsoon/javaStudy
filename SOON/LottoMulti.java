import java.io.*;
import java.util.*;

class LottoMulti 
{
	String fName = "우리반리스트.txt"; //불러올 파일 디폴트값
	String list; //읽은 파일 이름
	FileReader fr;
	BufferedReader br;
	BufferedReader brkey = new BufferedReader(new InputStreamReader(System.in)); 
	int count;
	
	TreeSet<String> set = new TreeSet<String>();
	Hashtable<Integer,String> map = new Hashtable<Integer,String>();

	LottoMulti(){
		findFile();
		putMap();
		readCount();
		pln("");
		pln("오늘의 당첨자는....!!");
		pln("");
		showResult();
	}

	//1. 출석 리스트파일 불러오기
	void findFile(){ 
		try{
			System.out.print("리스트 파일(기본 : 우리반리스트.txt): ");
			list = brkey.readLine();
			if(list !=null){// 공백 삭제
				list = list.trim();
			};   
			if(list.length()==0){ //입력받지 않으면 디폴트값을 list에 넣음
				list = fName;
			};
			fr = new FileReader(list);
			File f = new File(list);
			readFile(f);
		}catch(FileNotFoundException fe){
			pln("파일을 찾지 못했어요 :(");
			findFile();
		}catch(IOException ie){
		}
	}

	//2. 파일을 읽고 set에 저장
	// try 삭제_ 상위 findFile()에서 중복되어 삭제함)
	void readFile(File f){ 
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		String name = "";
		while((name = br.readLine()) != null){
			name = name.trim();
			if(name.length() !=0){
				set.add(name);
			}
		}
	}

	//3. 이름순으로 정렬된 set의 요소들을 map에 번호와 함께 입력함
	void putMap(){
		int i =0;
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){ //다음이 있니? 있으면 true값 반환, 없으면 false
		   map.put(i+1, iter.next());
		   i++;
		}
	  }

	//4. 당첨자수 입력받기
	Scanner s = new Scanner(System.in);
	void readCount(){
		System.out.print("당첨자수를 입력하세요 : ");
		count = s.nextInt();
		if(count==0){
			pln("최소한 1명은 뽑아주라구!");
			readCount();
		}
		else if(set.size()<count){
			pln("당첨자수는 " +set.size()+ " 이하로 입력해주세요!");
			readCount();
		} else{
			readName();
		}
	}

	//5. 랜덤 추출 후 set에 저장
	void readName() {
		Random ran = new Random();
		set.clear(); //set의 모든 요소 제거(기존 set을 한번 더 재활용하기 위해)
		while(set.size() < count) { 
			int j = ran.nextInt(map.size()-1); //난수 생성
			set.add(map.get(j+1)); //map.get으로 value값 받아서 리셋된 set에 저장
		}
	}

	//6. set에 저장된 요소와 map의 요소 비교, 값 출력
	void showResult(){	
		Iterator<String> iter = set.iterator();
		Set<Integer> keys = map.keySet();
		while(iter.hasNext()){
			String item = iter.next(); //리셋된 set에 저장된 요소를 item 변수에 저장
			for(Integer key: keys){ 
				if(item == map.get(key)){ //map에 있는 val값과 item이 같다면 
					System.out.println(key+"번 : "+item); //item과 해당되는 key값 출력
				}
			}
		}
		pln("");
		System.out.println(count+"분 축하합니다!");
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args) 
	{
		new LottoMulti();
	}
}