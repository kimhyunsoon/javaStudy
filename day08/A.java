class Human 
{
    String name = "ȫ�浿";

    Human(String name){
        
     
        this.name = name;
       
        
    }

    void move(){
        System.out.println("�ȴ´�");
    }
    
}

class SuperMan extends Human
{
    int power = 500;
   
    //String name = "Ŭ��";
    SuperMan(){
        super("Ŭ��");
    }

    void move(){ //�������̵� : �θ��� �޼ҵ带 �ڽĿ��� �ٲ۴�
        System.out.println("����");
    }

   
  
    void shotBeam(){
        System.out.println("������ ���");

    }
}

class RunningMan extends Human{

    int speed;
    RunningMan(int speed){
        super("���׸�");
        this.speed = speed;
    }
    void move(){
        System.out.println("�޸���");
    }


}  

