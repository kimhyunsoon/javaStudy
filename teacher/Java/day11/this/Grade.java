import java.io.*;

class Grade {	
	String subjects[] = {"국어", "영어", "수학"}; //과목저장배열 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int is[]; //점수 저장 배열 
	int total;
	int avg;
	String grade = "F";

	Grade(){
		is = new int[subjects.length];
		
		InputObj iObj = new InputObj(this);
		iObj.input(); //입력 

		Cal c = new Cal(this);
		c.cal(); //총점, 평균 

        CalGrade cg = new CalGrade(this);
		cg.calG(); //학점 

		Showing s = new Showing(this);
		s.show();
	}
	public static void main(String[] args) {
		Grade g = new Grade();
	}
}

/*
  1. 성적을 입력 받음 
  2. 총점과 평균을 계산 
  3. 평균을 학점을 출력 
*/
