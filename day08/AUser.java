class AUser 
{
	public static void main(String[] args) 
	{
		Human m = new Human("�̼���"); //Human �����ڸ� ��ü�� ����
		System.out.println("m.name: " + m.name); //�̼���
		m.move();
        System.out.println("");
    
        SuperMan sm = new SuperMan(); //Superman �����ڸ� ��ü�� ����
        System.out.println("csm.name: " + sm.name);
        System.out.println("m.power: " + sm.power);
        sm.move();
        sm.shotBeam();
        System.out.println("");

        SuperMan sm2 = new SuperMan(); //Superman �����ڸ� ��ü�� ����
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
        SuperMan sm3 = (SuperMan)m3; //�߸��� ����ȯ, �������� ������ ��Ÿ�ӿ���

       //���׸��� �޸����� �ٲ�ٰ� ���۸����� �ٲٴ°� ����
        

     



	}
}

