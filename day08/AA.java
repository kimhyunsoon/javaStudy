class Grandfather {
    int age = 80;
    String name = "�Ҿƹ���";
    String job = "���";
    int income = 400;
    
    Grandfather(String name){
        this.name=name;
    }

    void showinfo(){
        System.out.println(name+"(��)�� "+job+"�̰�, "+age+"�� �Դϴ�");
    }
    void earn(){
        System.out.println(name+"��(��) "+income+"������ ���ϴ�");
    }
}

class father extends Grandfather {
    
    father(String job, int age,int income){
        super("�ƹ���");
        this.age = age;
        this.job = job;
        this.income = income;
    }
}


class Child extends Grandfather {

    Child(String job, int age){
        super("�Ƶ�");
        this.age = age;
        this.job = job;
    }
}

