class Tip1 
{
	String path = "C:\\SOO\\행정\\가산_8강의실_210419.xls";
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
