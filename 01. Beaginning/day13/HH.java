public class HH extends Thread{ //���Ἲ�� ����
    int i=0;
    HH(){
        start();

    }
    public void run(){
        m();
    }

    public void m(){
        i++;
    }
    void show(){
        System.out.println("i: "+i);
    }


    public static void main(String[] args) {
        H h = new H();
        h.m();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        h.show();
        
    }
    
}
