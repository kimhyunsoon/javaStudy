class G
{
	int i =10;
	static int j = 20; //����, Ŭ���� ����

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