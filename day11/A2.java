public class A2 {
    String name = "�̰���";
    A2(){
        use();

    }

    void m(){
        System.out.println("A�� �޼ҵ�");
    }
    
    void use(){
        System.out.println(name);
        m();
    }

    public static void main(String[] args) {
        new A2();
    }
}



