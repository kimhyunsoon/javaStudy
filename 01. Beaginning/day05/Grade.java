class Grade 
{
	public static void main(String[] args) 
	{
		if(args.length != 4){ //배열의 길이가 4가 아니라면 아래의 문구를 출력한다
			System.out.println("사용법>국어점수 수학점수 영어점수 과학점수를 입력해주세요");
			return;
		}
		System.out.println("국어: " + args[0]);
		System.out.println("수학: " + args[1]);
		System.out.println("영어: " + args[2]);
		System.out.println("과학: " + args[3]);

		int input1 = Integer.parseInt(args[0]); //String을 int로 변환하여 연산이 가능하게 한다
		int input2 = Integer.parseInt(args[1]);
		int input3 = Integer.parseInt(args[2]);
		int input4 = Integer.parseInt(args[3]);
        System.out.println("총점: " + (input1+input2+input3+input4));

		System.out.println("평균: " + (input1+input2+input3+input4)/4);
	}
}
