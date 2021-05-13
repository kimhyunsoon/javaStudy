public class AA2 {
    int age = 29;
    String name = "김현순";

    AA2(){
        AA2Friend aa2f = new AA2Friend(this);
        aa2f.use();

    }

    void m2(){
        System.out.println("AA2의 메소드");
    }

    public static void main(String[] args) {
        AA2 aa2 = new AA2();
        
    }
    
}

class AA2Friend{

    AA2 aa2;
    AA2Friend(AA2 aa2){
        this.aa2 = aa2;

    }
    
    void use(){
        System.out.println("AA2의 나이"+aa2.age);
        System.out.println("AA2의 이름"+aa2.name);
        aa2.m2();
    }

}
