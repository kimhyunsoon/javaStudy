import java.io.*;

class Grade {	
	String subjects[] = {"����", "����", "����"}; //��������迭 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int is[]; //���� ���� �迭 
	int total;
	int avg;
	String grade = "F";

	Grade(){
		is = new int[subjects.length];
		
		InputObj iObj = new InputObj(this);
		iObj.input(); //�Է� 

		Cal c = new Cal(this);
		c.cal(); //����, ��� 

        CalGrade cg = new CalGrade(this);
		cg.calG(); //���� 

		Showing s = new Showing(this);
		s.show();
	}
	public static void main(String[] args) {
		Grade g = new Grade();
	}
}

/*
  1. ������ �Է� ���� 
  2. ������ ����� ��� 
  3. ����� ������ ��� 
*/
