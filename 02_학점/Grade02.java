import java.io.*;

class Grade02m 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum;
	int subjectNum;

	void input1(){
		System.out.print("����: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("������ ���� �Է� ����!!");
			input1();
		}
	}

	void input2(){
		System.out.print("����: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("������ ���� �Է� ����!!");
			input2();
		}
	}

	void input3(){
		System.out.print("����: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("������ ���� �Է� ����!!");
			input3();
		}
	}

	void input4(){
		System.out.print("����: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int score = Integer.parseInt(line);
			subjectNum +=1;
			sum += score;
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("������ ���� �Է� ����!!");
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
		System.out.println("����: "+ip.sum);
		System.out.println("���: "+ip.sum/ip.subjectNum);
	}
}
