class HHH extends Thread{ //���Ἲ�� Ȯ���� Ŭ����
    int i = 0;
    HHH(){
        start();
    }
    public void run() {
        m();
        
    }

    void m(){
        i++;
        try{
			Thread.sleep(100);
		}catch(Exception e){}

    }

    void show(){
        System.out.println("i: "+i);
    }

    public static void main(String[] args) {
        HHH hhh = new HHH();
        hhh.m();
        
        hhh.show();
        
    }
    
}
