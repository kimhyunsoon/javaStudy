class AAAA {

    String name = "�̰���";
    
    AAAA(String name){
        this.name = name;

    }
    
    
    void m(){
        System.out.println("AAAA�� �޼ҵ�");
    }


    public static void main(String[] args ) {
        AAAA a = new AAAA("������");
        System.out.println("�̸���?"+a.name);
        a.m();
        
        
    }

}
