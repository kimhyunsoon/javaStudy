class Th1 extends Thread {
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
        t1.start();
        t2.start();
        try{
            t1.join(); //�����尡 ���� ������ ��ٸ�
            t2.join();
        }catch(InterruptedException ie){}

        System.out.println("j: "+j);
    }
    synchronized static void m(){ //���1
        for(int i=0;i<10000000;i++){
            j++;
        }
    }
    void mNor(){
        System.out.println("1"); //����ȭ�� �ʿ���� ����
        synchronized(this){//���2
            System.out.println("2");//����ȭ�� �ʿ��� ����
        }
    }

    public static void main(String[] args) {
        new I();
    }




}