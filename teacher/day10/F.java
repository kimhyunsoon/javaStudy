class F 
{
	int $i= 0;
	void m_(){}

	void show(){
		System.out.println("int 최대값: " + Integer.MAX_VALUE);
		System.out.println("int 최소값: " + Integer.MIN_VALUE);
	}
	public static void main(String[] args) 
	{
		new F().show();
	}
}

