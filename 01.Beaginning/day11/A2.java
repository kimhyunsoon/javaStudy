public class A2 { //2. �ڽ��� ��ü�� �ٸ� Ŭ�������� �ѱ� ��
    
    int age = 36;
    String name = "�̰���";
    A2(){
        A2Friend a2f= new A2Friend(this); 
        a2f.use();
    }

    void m(){
        System.out.println("A2�� �޼ҵ�");
    }

    public static void main(String[] args) {
        new A2();
    }
}

class A2Friend{
    
    A2 a2;
    A2Friend(A2 a2){
        this.a2 = a2;
    }
    
    void use(){
        System.out.println("����: "+a2.age);
        System.out.println("�̸�: "+a2.name);
        a2.m();
    }
}


