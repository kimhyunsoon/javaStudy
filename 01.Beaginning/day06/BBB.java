class BBB {
    String strs[] = {"��","����", "����", "�ܿ�"};

    void out2(){
        for(int i=0; i<strs.length; i++){
            System.out.println("����: "+strs[i]);
        }
    }

    public static void main(String[] args){
        BBB b = new BBB();
        b.out2();
    }

    
}
