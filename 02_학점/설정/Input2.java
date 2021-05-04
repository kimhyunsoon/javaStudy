import java.io.*;

class Input2 
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void input(){
		System.out.print("국어: ");
		try{
			String line = br.readLine();
			line = line.trim();
			int jumsu = Integer.parseInt(line);
			System.out.println("jumsu: " + (jumsu+1));
		}catch(IOException ie){
		}catch(NumberFormatException ne){
			System.out.println("점수는 숫자 입력 가능!!");
			input();
		}
	}
	public static void main(String[] args) 
	{
		Input2 ip = new Input2();
		ip.input();
	}
}
