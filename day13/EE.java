class EET extends Thread { //쓰레드로부터 상속받은 클래스 ET
    
    public void run(){
        m1();
    }

    void m1(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("ET의 메소드");
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
                System.out.println("EE의 메소드");
            }catch(InterruptedException ie){}
        }
    }

    public static void main(String [] args) {
        EE ee = new EE();
    }
}

//멀티쓰레드 구현
//th2 추가했을 때는 ET의 메소드 두번, EE의 메소드 한번 나옴