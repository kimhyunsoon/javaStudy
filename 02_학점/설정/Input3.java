import java.util.Scanner;

class Input3 
{
	Scanner s = new Scanner(System.in);
	void input(){
		System.out.print("국어: ");
		//int i = s.nextInt();
		//System.out.println("i: " + (i+1));

		String str = s.next();
		try{
			int i = Integer.parseInt(str);
			System.out.println("i: " + (i+1));
		}catch(NumberFormatException ne){
			System.out.println("숫자 형태만 입력 가능!!");
			input();
		}
	}
	public static void main(String[] args) 
	{
		new Input3().input();
	}
}
