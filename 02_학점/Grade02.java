import java.io.*;

class Grade02m 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum;
	int subjectNum;

	void input1(){
		System.out.print("국어: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("점수는 숫자 입력 가능!!");
			input1();
		}
	}

	void input2(){
		System.out.print("수학: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("점수는 숫자 입력 가능!!");
			input2();
		}
	}

	void input3(){
		System.out.print("영어: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("점수는 숫자 입력 가능!!");
			input3();
		}
	}

	void input4(){
		System.out.print("과학: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("점수는 숫자 입력 가능!!");
			input4();
		}
	}

	public static void main(String[] args) 
	{
		Grade02m ip = new Grade02m();
		ip.input1();
		ip.input2();
		ip.input3();
		ip.input4();
		System.out.println("총점: "+ip.sum);
		System.out.println("평균: "+ip.sum/ip.subjectNum);
	}
}
