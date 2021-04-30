class G
{
	int i =10;
	static int j = 20; //정적, 클래스 소유

	void use(){
		System.out.print("m() i :" +i);


	
	}
}

class GUser
{
	public static void main(String[] args){
	
		G g = new G();
		System.out.println("e.i: "+g.i);
		System.out.println("E.i: "+G.j);
		g.use();
	}





}