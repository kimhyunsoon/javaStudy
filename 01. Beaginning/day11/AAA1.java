class AAA1 {

    String name = "�̰���";
    
    AAA1(String name){
        this.name = name;

    }
    
    
    void m(){
        System.out.println("AAAA�� �޼ҵ�");
    }


    public static void main(String[] args ) {
        AAA1 a = new AAA1("������");
        System.out.println("�̸���? "+a.name);
        a.m();
        
        
    }

}
