class FT extends Thread //(1)java.lang.Thread ���
{
	public void run(){
        while(true){
            System.out.println("������ �Ѵ�");
            try{
                Thread.sleep(1000);
            }catch(Exception e){} //InterruptedException ���� �ʿ����� �ʾƼ�
        }
	}	
}

class FT2 implements Runnable{ //(2) java.lang.Runnable ���?����?
    public void run(){
        while(true){
            System.out.println("������ �����");
            try{
                Thread.sleep(2000);
            }catch(Exception e){} //InterruptedException ���� �ʿ����� �ʾƼ�
        }
    }
}


class F  
{
	F(){
		Thread th1 = new FT();
		th1.start();
        Thread th2 = new FT();
        th2.start();
        Thread th3 = new Thread(new FT2());
		th3.start();
		
		while(true){
			System.out.println("���� �޴´�");
            try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
	public static void main(String[] args) {
		F f = new F();
	}
}
