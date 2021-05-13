public class A2 {
    String name = "이가은";
    A2(){
        use();

    }

    void m(){
        System.out.println("A의 메소드");
    }
    
    void use(){
        System.out.println(name);
        m();
    }

    public static void main(String[] args) {
        new A2();
    }
}



