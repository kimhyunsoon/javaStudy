class EET extends Thread { //������κ��� ��ӹ��� Ŭ���� ET
    
    public void run(){
        m1();
    }

    void m1(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("ET�� �޼ҵ�");
            }catch(InterruptedException ie){}
        }
    }
}

class EE{
    
    EE(){

        Thread th1 = new EET();
        //Thread th2 = new EET();
        th1.start();
        //th2.start();
        m2();
    }

    void m2(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("EE�� �޼ҵ�");
            }catch(InterruptedException ie){}
        }
    }

    public static void main(String [] args) {
        EE ee = new EE();
    }
}

//��Ƽ������ ����
//th2 �߰����� ���� ET�� �޼ҵ� �ι�, EE�� �޼ҵ� �ѹ� ����