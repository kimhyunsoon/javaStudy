class Grandfather {
    int age = 80;
    String name = "할아버지";
    String job = "농부";
    int income = 400;
    
    Grandfather(String name){
        this.name=name;
    }

    void showinfo(){
        System.out.println(name+"(은)는 "+job+"이고, "+age+"세 입니다");
    }
    void earn(){
        System.out.println(name+"은(는) "+income+"만원을 법니다");
    }
}

class father extends Grandfather {
    
    father(String job, int age,int income){
        super("아버지");
        this.age = age;
        this.job = job;
        this.income = income;
    }
}


class Child extends Grandfather {

    Child(String job, int age){
        super("아들");
        this.age = age;
        this.job = job;
    }
}

