class Tip1 
{
	String path = "C:\\SOO\\����\\����_8���ǽ�_210419.xls";
	String fname = "";
	void cut(){
		int idx = path.lastIndexOf("\\");
		
		fname = path.substring(idx+1);
		System.out.println("fname: " + fname);
	}
	public static void main(String[] args) 
	{
		Tip1 t = new Tip1();
		t.cut();
	}
}
