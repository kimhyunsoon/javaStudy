class Human 
{
	String name = "ȫ�浿";
	Human(String name){
			this.name = name;
	}

	void move(){
		System.out.println(name+"�� �ȴ´�");
	
	}
	
}

class SuperMan extends Human
{
	int porwer = 500;
	SuperMan(){
		super("Ŭ��");
	}

	void move(){
		System.out.println(name+"�� ����");
	}

	void showSpec(){
		System.out.println("power: "+power);
	}

}

class RunningMan extends Human
{
	int speed;
	RunningMan(int speed){
		super("����");
		this.speed=speed;
	}
	void move(){
		System.out.println(name+"�� �޸���");
	}
}

class AAAAAUser
{
	public static void main(String[]  args){
		Human man = new Human();
		System.out.println(man.name);
	
	
	}
}






