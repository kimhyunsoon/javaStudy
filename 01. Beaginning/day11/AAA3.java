class AAA3 {
    String name = "김현순";
    AAA3(String name){
        
        this.name = name;
    }
    
    AAA3(){
        this("이가은");
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
