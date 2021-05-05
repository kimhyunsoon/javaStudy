class BBB {
    String strs[] = {"봄","여름", "가을", "겨울"};

    void out2(){
        for(int i=0; i<strs.length; i++){
            System.out.println("계절: "+strs[i]);
        }
    }

    public static void main(String[] args){
        BBB b = new BBB();
        b.out2();
    }

    
}
