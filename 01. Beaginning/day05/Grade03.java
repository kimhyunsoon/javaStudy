import java.util.Scanner;

class Grade03 
{
	Scanner s = new Scanner(System.in);
	void input(){
		System.out.print("����: ");
		String str1 = s.next();
		System.out.print("����: ");
		String str2 = s.next();
		System.out.print("����: ");
		String str3 = s.next();
		System.out.print("����: ");
		String str4 = s.next();
		try{
			int i = Integer.parseInt(str1);
			int j = Integer.parseInt(str2);
			int k = Integer.parseInt(str3);
			int l = Integer.parseInt(str4);
			System.out.println("����: " + (i+j+k+l));
			System.out.println("���: " + (i+j+k+l)/4);
		}catch(NumberFormatException ne){
			System.out.println("���� ���¸� �Է� ����!!");
			input();
		}
	}
	public static void main(String[] args) 
	{
		new Grade03().input();
	}
}
