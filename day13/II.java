class II1 extends Thread{
    public void run() {
        II.m();
    }
}

class II2 extends Thread{
    public void run() {
        II.m();
    }
}




class II {
    static int j = 0;
    II(){
        Thread th1 = new II1();
        Thread th2 = new II2();
        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (Exception e) {}
        System.out.println("j: " + j);

    }

    synchronized static void m(){
        for (int i = 0; i < 1000000; i++) {
            j++;
        }
    }

    void mNor(){
        System.out.println("1¹ø");
        synchronized(this){
            System.out.println("2¹ø");
        }
    }

    public static void main(String[] args) {
        new I();
        
    }
    
}
