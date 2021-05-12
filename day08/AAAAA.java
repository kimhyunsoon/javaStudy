class Human 
{
	String name = "홍길동";
	Human(String name){
			this.name = name;
	}

	void move(){
		System.out.println(name+"은 걷는다");
	
	}
	
}

class SuperMan extends Human
{
	int porwer = 500;
	SuperMan(){
		super("클락");
	}

	void move(){
		System.out.println(name+"은 난다");
	}

	void showSpec(){
		System.out.println("power: "+power);
	}

}

class RunningMan extends Human
{
	int speed;
	RunningMan(int speed){
		super("광수");
		this.speed=speed;
	}
	void move(){
		System.out.println(name+"은 달린다");
	}
}

class AAAAAUser
{
	public static void main(String[]  args){
		Human man = new Human();
		System.out.println(man.name);
	
	
	}
}






