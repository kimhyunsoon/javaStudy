class AAA3 {
    String name = "������";
    AAA3(String name){
        
        this.name = name;
    }
    
    AAA3(){
        this("�̰���");
    }

    void m3(){
        System.out.println("#name: "+name);
    }
    
    public static void main(String[] args) {
        AAA3 aaa3 = new AAA3();
        //aaa3.m3();
        System.out.println("#name: "+aaa3.name);
        
        
    }
}
