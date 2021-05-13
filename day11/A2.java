public class A2 { //2. 자신의 객체를 다른 클래스에게 넘길 때
    
    int age = 36;
    String name = "이가은";
    A2(){
        A2Friend a2f= new A2Friend(this); 
        a2f.use();
    }

    void m(){
        System.out.println("A2의 메소드");
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
        System.out.println("나이: "+a2.age);
        System.out.println("이름: "+a2.name);
        a2.m();
    }
}


