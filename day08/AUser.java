class AUser 
{
	public static void main(String[] args) 
	{
		Human m = new Human("이순신"); //Human 생성자를 객체로 생성
		System.out.println("m.name: " + m.name); //이순신
		m.move();
        System.out.println("");
    
        SuperMan sm = new SuperMan(); //Superman 생성자를 객체로 생성
        System.out.println("csm.name: " + sm.name);
        System.out.println("m.power: " + sm.power);
        sm.move();
        sm.shotBeam();
        System.out.println("");

        SuperMan sm2 = new SuperMan(); //Superman 생성자를 객체로 생성
        System.out.println("csm.name: " + sm2.name);
        System.out.println("m.power: " + sm2.power);
        sm.move();
        sm.shotBeam();
        System.out.println("");
      
        RunningMan rMan= new RunningMan(200);
        System.out.println("rman.name: " + rMan.name);
        System.out.println("rman.speed: " + rMan.speed);
        rMan.move();

        Human m3= rMan;
        SuperMan sm3 = (SuperMan)m3; //잘못된 형변환, 컴파일은 되지만 런타임오류

       //런닝맨을 휴먼으로 바꿨다가 슈퍼맨으로 바꾸는건 가능
        

     



	}
}

