class H{
    H(int a){
        System.out.println(a + " �Դϴ�.");
    }
    static int something(int a, int b){
        return a + b;
    }
    public static void main(String[] args){
        new H(something(1, 3));
    }
}