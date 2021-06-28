class C { //배열의 디폴트값
    
    int is[] = new int [4];
    void out1(){
        for(int i=0; i<is.length; i++){
            System.out.println("is["+i+"]"+is[i]);

        }
    }

    double ds[] =  new double[2];
    void out2(){
        for(int i=0; i<ds.length; i++){
            System.out.println("ds["+i+"]"+ds[i]);
        }
    }

    boolean bs[]=new boolean[3];
    void out3(){
        for(int i=0; i<bs.length; i++){
            System.out.println("bs["+i+"]"+bs[i]);
        }
    }
    
    public static void main(String[] args) {
        C c = new C();
        c.out1();
        c.out2();
        c.out3();
        
    }
}
