class EEEET extends Thread{
    public void run(){
        m();
    }
    void m(){
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("EEEET�� �޼ҵ�");
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}

class EEEE {

    EEEE(){

        Thread th1 = new EEEET();
        th1.start();
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("EEEE�� �޼ҵ�");
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        EEEE var = new EEEE();

    }
}
