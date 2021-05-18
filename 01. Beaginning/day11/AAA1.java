class AAA1 {

    String name = "이가은";
    
    AAA1(String name){
        this.name = name;

    }
    
    
    void m(){
        System.out.println("AAAA의 메소드");
    }


    public static void main(String[] args ) {
        AAA1 a = new AAA1("김현순");
        System.out.println("이름은? "+a.name);
        a.m();
        
        
    }

}
