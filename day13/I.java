class ThI extends Thread {
    public void run(){
        I.m();
    }
}

class Th2 extends Thread {
    public void run(){
        I.m();
    }
}

class I{
    static int j = 0;
    I(){
        Thread t1 = new Th1();
        Thread t2 = new Th2();



    }



}