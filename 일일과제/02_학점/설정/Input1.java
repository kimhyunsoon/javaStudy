class Input1 
{
	public static void main(String[] args) 
	{
		if(args.length != 4){
			System.out.println("����>java Input1 ��1 ��2 ��3 ��4");
			return;
		}
		System.out.println("args[0]: " + args[0]);
		System.out.println("args[1]: " + args[1]);
		System.out.println("args[2]: " + args[2]);
		System.out.println("args[3]: " + args[3]);

		int i1 = Integer.parseInt(args[0]);
        System.out.println("i1: " + (i1+1));
	}
}
