class D {
    byte b=10;
    short s =20;
    char c='A'; //문자를 표현하는 아스키코드
    int i=30;
    float f=40.5f;

    int fs[] = {b,s,c,i, (int)f};

    void out(){
        for(int i=0;i<fs.length;i++){
            System.out.println(fs[i]);
        }


    }

    public static void main(String[] args) {
        D d = new D();
        
        d.out();
    }
    
}
