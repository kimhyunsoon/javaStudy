class FFT extends Thread{
    public void run(){
        while (true) {
            System.out.println("유튜브를 본다");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }    
}

class FFT2 implements Runnable{
    //인스턴스가 스레드에 의해 실행되도록 의도된 모든 클래스에 의해 구현되어야 한다
    //클래스는 run이라는 인수가 없는 메소드를 정의해야 한다
    public void run(){
        while (true) {
            System.out.println("게임을 한다");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        }
    }  
}

public class FF {

    FF(){
        Thread th1 = new FFT();
        Thread th2 = new Thread(new FFT2());
        th1.start();
        th2.start();
        while (true) {
            System.out.println("요리를 한다");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        new FF();
        
    }

}
