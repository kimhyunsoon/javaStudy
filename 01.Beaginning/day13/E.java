class ET { //������κ��� ��ӹ��� Ŭ���� ET
    
    public void run(){
        m();
    }
    
    
    void m(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("�޼ҵ� m");
            }catch(InterruptedException ie){}
        }
    }



    public static void main(String [] args) {
        ET et = new ET();
        et.m();
    }
}

//�̱۾����� ����