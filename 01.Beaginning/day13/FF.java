class FFT extends Thread{
    public void run(){
        while (true) {
            System.out.println("��Ʃ�긦 ����");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }    
}

class FFT2 implements Runnable{
    //�ν��Ͻ��� �����忡 ���� ����ǵ��� �ǵ��� ��� Ŭ������ ���� �����Ǿ�� �Ѵ�
    //Ŭ������ run�̶�� �μ��� ���� �޼ҵ带 �����ؾ� �Ѵ�
    public void run(){
        while (true) {
            System.out.println("������ �Ѵ�");
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
            System.out.println("�丮�� �Ѵ�");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        new FF();
        
    }

}
