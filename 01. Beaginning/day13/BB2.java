public class BB2 {

    private String name = "가은";
    private void m(){
        System.out.println("BB1의 메소드");
    }

    class BB2In1{
        int a = 1;
        void m1(){
            System.out.println("이너클래스1의 메소드");
        }
        void use(){
            System.out.println("name: "+name); //외부클래스의 멤버 이용 가능
            m(); //외부클래스의 메소드 이용 가능
        }

    }

    static class BB2In2{ //클래스 소유
        int b = 5;
        void m2(){
            System.out.println("이너클래스2의 메소드");
        }
        void use2(){
            System.out.println("name: "+name); 
            //static 클래스에서는 private 멤버를 이용하지 못하는 이유가 뭐냐!!
            
        }
    }
}

class BB2User{
    public static void main(String[] args) {
        BB2.BB2In1 inner1 = new BB2().new BB2In1();
        System.out.println("inner1.a: "+inner1.a);
        inner1.m1(); 
        inner1.use(); 

        BB2.BB2In2 inner2 = new BB2.BB2In2();
        System.out.println("inner2.b: "+inner2.b);
        inner2.use2();
        
    }
}


