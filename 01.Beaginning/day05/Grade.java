class Grade 
{
	public static void main(String[] args) 
	{
		if(args.length != 4){ //�迭�� ���̰� 4�� �ƴ϶�� �Ʒ��� ������ ����Ѵ�
			System.out.println("����>�������� �������� �������� ���������� �Է����ּ���");
			return;
		}
		System.out.println("����: " + args[0]);
		System.out.println("����: " + args[1]);
		System.out.println("����: " + args[2]);
		System.out.println("����: " + args[3]);

		int input1 = Integer.parseInt(args[0]); //String�� int�� ��ȯ�Ͽ� ������ �����ϰ� �Ѵ�
		int input2 = Integer.parseInt(args[1]);
		int input3 = Integer.parseInt(args[2]);
		int input4 = Integer.parseInt(args[3]);
        System.out.println("����: " + (input1+input2+input3+input4));

		System.out.println("���: " + (input1+input2+input3+input4)/4);
	}
}
