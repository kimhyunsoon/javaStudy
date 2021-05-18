class DD {
    byte b=10;
    short s=20;
    char c='A';
    int i=30;
    float f=40.05f;

    int array[] = {b,s,c,i,(int)f};

    void out(){
        for(int i=0;i<array.length; i++){
            System.out.println(array[i]);
        }
    }
    
    public static void main(String[] args){
        DD d=new DD();
        d.out();
    }
}
