class EEET extends Thread { //쓰레드로부터 상속받은 클래스 EEET
    public void run(){
        m1();
    }

    void m1(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("EEET의 메소드");
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
                System.out.println("EEE의 메소드");
            }catch(Exception e){}
        }
    }

    public static void main(String[] args){
        EEE eee = new EEE();

    }



}
