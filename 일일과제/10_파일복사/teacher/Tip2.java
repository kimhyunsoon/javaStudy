import java.io.*;

class Tip2
{
	String fname = "C:/SOO/[��]����_8���ǽ�_210430.xls";
	void del(){
		File f = new File(fname);
		f.delete();
	}
	public static void main(String[] args) 
	{
		new Tip2().del();
	}
}
