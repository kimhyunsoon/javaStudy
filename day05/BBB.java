class BBB {
    boolean flag = true;
    BBB(){
        m1();
        System.out.println("B()");
    }
    
    void m1(){
        System.out.println("m1(): 1");
        if(flag) return;
        System.out.println("m1(): 2");
    }

    void m2(){
        for(int j=0;j<3; j++){
            for(int i=0; j<3; i++){
                if(i==2) return;
                System.out.println("j: " + j + ", i: " + i);
            }
        }
    }

    int m3(){
        int i=5;
        System.out.println("m3");
        return i;
    }

    public static void main(String[] args){
        BBB b = new BBB();
        b.m1();
        b.m2();
        int r = b.m3();
        System.out.println("main(): 1, r: "+r);
    }
}
