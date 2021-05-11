import java.io.*;
import java.util.*;

class LottoMulti 
{
	String fName = "우리반리스트.txt"; //불러올 파일 디폴트값
	String list; //읽은 파일 이름
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
		String input = s.nextLine();
		
		// 추가된 메쏘드_Scanner로 받은 문자가 숫자(정수)인지 확인
		numberCheck(input); 
		
		if(!numCheck || input.length() == 0) { // numberCheck(); 에서 저장한 numCheck가 false거나 input의 길이가 0이면
			pln("당첨자수를 숫자로 입력해주세요!");
			readCount();
		} else {
			count = Integer.parseInt(input); // 숫자인지 확인을 위해 String으로 받았던 입력값을 int로 변환함
			if(count<=0){
				pln("최소한 1명은 뽑아주라구!");
				readCount();
			}else if(set.size()<count){
				pln("당첨자수는 " +set.size()+ " 이하로 입력해주세요!");
				readCount();
			} else {
				readName();
			}
		}
	}

	//5. 랜덤 추출 후 set에 저장
	void readName() {
		Random ran = new Random();
		set.clear(); //set의 모든 요소 제거(기존 set을 한번 더 재활용하기 위해)
		while(set.size() < count) { 
			int j = ran.nextInt(map.size()); //난수 생성
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


	//추가된 메쏘드_Scanner로 받은 문자가 숫자(정수)인지 확인
	void numberCheck(String a){ // 매개변수로 문자열(입력값)을 받음
		numCheck = true;
		for (int i =0; i<a.length(); i++) { // 매개변수 입력값의 문자열 길이 만큼 실행
			char tmp = a.charAt(i); // 매개변수 입력값의 i번째 문자를 tmp에 저장
			if(!Character.isDigit(tmp)){ // tmp가 숫자가 아니면
				numCheck = false; // numCheck를 false로 바꿈
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