class FFFT extends Thread {
    public void run(){
        while (true) {
            System.out.println("1000");
            try { Thread.sleep(1000);} catch (Exception e) {}
        }
    }
}

class FFFT2 implements Runnable{
    public void run(){
        while (true) {
            System.out.println("2000");
            try { Thread.sleep(2000);} catch (Exception e) {}
        }
    }
}

public class FFF {
    FFF(){

        Thread th1 = new FFFT();
        Thread th2 = new Thread(new FFFT2());
        th1.start();
        th2.start();
        while (true) {
            System.out.println("6000");
            try { Thread.sleep(6000);} catch (Exception e) {}
        }
    }
    public static void main(String[] args) {
        new FFF();
        
    }    
}
