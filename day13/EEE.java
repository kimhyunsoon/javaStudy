class EEET extends Thread { //������κ��� ��ӹ��� Ŭ���� EEET
    public void run(){
        m1();
    }

    void m1(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("EEET�� �޼ҵ�");
            }catch(Exception e){}
        }
    }
}

class EEE{

    EEE(){
        Thread th1 = new EEET();
        th1.start();
        Thread th2 = new EEET();
        
        th2.start();
        m2();
    }

    void m2(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("EEE�� �޼ҵ�");
            }catch(Exception e){}
        }
    }

    public static void main(String[] args){
        EEE eee = new EEE();

    }



}
