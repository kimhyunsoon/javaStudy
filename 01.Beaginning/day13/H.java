class H  extends Thread{ //���Ἲ�� �߻��� Ŭ������ ��
    int i = 0;
    H(){
        start();
    }

    public void run(){
        m();

    }
    void m(){
        i++;
    }
    void show(){
        System.out.println("i: "+i);
    }

    public static void main(String[] args) {
        H h = new H();
        h.m();
        try{
            Thread.sleep(100);
        }catch(Exception e){}
        h.show();
    }
}
