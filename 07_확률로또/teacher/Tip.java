class Tip 
{
	String str = "   최동현  50  ";
    String name;
	int rate;
    void cut(){
		str = str.trim();
		//pln("str: " + str); //최동현  50
		int idx = str.indexOf(" ");
		//pln("idx: " + idx);
		name = str.substring(0, idx); //0<= val <idx
		//pln("name: " + name);
		String strRate = str.substring(idx); //idx <= val <=끝
        //pln("1) strRate: " + strRate);
		if(strRate.length() != 0) strRate = strRate.trim();
        //pln("strRate: " + strRate);
		rate = Integer.parseInt(strRate);
		//pln("rate : " + rate);
	}
	void showR(){
		pln("#name: " + name);
		pln("#rate : " + rate+1);
	}
    void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Tip t = new Tip();
		t.cut();
		t.showR();
	}
}
