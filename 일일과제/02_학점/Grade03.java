import java.util.Scanner;

class Grade03 
{
	Scanner s = new Scanner(System.in);
	void input(){
		System.out.print("국어: ");
		String str1 = s.next();
		System.out.print("수학: ");
		String str2 = s.next();
		System.out.print("영어: ");
		String str3 = s.next();
		System.out.print("과학: ");
		String str4 = s.next();
		try{
			int i = Integer.parseInt(str1);
			int j = Integer.parseInt(str2);
			int k = Integer.parseInt(str3);
			int l = Integer.parseInt(str4);
			System.out.println("총합: " + (i+j+k+l));
			System.out.println("평균: " + (i+j+k+l)/4);
		}catch(NumberFormatException ne){
			System.out.println("숫자 형태만 입력 가능!!");
			input();
		}
	}
	public static void main(String[] args) 
	{
		new Grade03().input();
	}
}
