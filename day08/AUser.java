class AUser 
{
	public static void main(String[] args) 
	{
		Human m = new Human("이순신");
		System.out.println("m.name: " + m.name); //이순신
		m.move();
        System.out.println("");
    
        SuperMan sm = new SuperMan();
        System.out.println("csm.name: " + sm.name);
        System.out.println("m.name: " + sm.power);
        sm.move();
        sm.shotBeam();
        System.out.println("");
      

	}
}

