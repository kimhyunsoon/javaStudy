public class A1 { 
    //1. 지역변수와 이름이 같은 멤버변수를 해당지역에서 접근할 때
    int age;
    
    A1(int age){
        // age = age;  이 경우에는 age:0 이 나옴.
        this.age = age;
        
    }

    public static void main(String[] args) {
        A1 a = new A1(20);
        System.out.println("age: "+a. age);
        
    }
    
}
