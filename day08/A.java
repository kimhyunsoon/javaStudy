class Human 
{

    String name = "ȫ�浿";
    Human(){}
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

