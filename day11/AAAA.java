class AAAA {

    String name = "이가은";
    
    AAAA(String name){
        this.name = name;

    }
    
    
    void m(){
        System.out.println("AAAA의 메소드");
    }


    public static void main(String[] args ) {
        AAAA a = new AAAA("김현순");
        System.out.println("이름은?"+a.name);
        a.m();
        
        
    }

}
