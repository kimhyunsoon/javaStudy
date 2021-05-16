public class Noname {

    
    void plus(int a, int b){
        System.out.println(a+b);
    }

    void multiple(int a,int b){
        System.out.println(a*b);
    }

    void m3(){
        System.out.println("");
    }



    public static void main(String[] args) {
        Noname nm = new Noname();
        nm.plus(3,5);
        nm.multiple(5,8);
        // nm.m3();
    }
}
