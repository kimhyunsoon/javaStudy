class Human 
{

    String name = "홍길동";
    Human(){}
    Human(String name){
        this.name = name;
    }

    void move(){
        System.out.println("걷는다");
    }
}

class SuperMan extends Human
{
    int power = 500;
    SuperMan(){
        super("클락");
    }

    void move(){ //오버라이딩 : 부모의 메소드를 자식에서 바꾼다
        System.out.println("난다");
    }
  
    void shotBeam(){
        System.out.println("광선을 쏜다");

    }
}

