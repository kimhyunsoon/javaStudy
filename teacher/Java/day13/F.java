class FT extends Thread { //(1) ���1
	public void run(){
		while(true){
			System.out.println("������ �Ѵ�");
			try{ Thread.sleep(1000); }catch(Exception e){}
		}
	}
}
class FT2 implements Runnable { //(2) ���2

	public void run(){
		while(true){
			System.out.println("������ �����");
			try{ Thread.sleep(2000); }catch(Exception e){}
		}
	}
}
class F  
{
	F(){
		Thread th1 = new FT();
		th1.start();
		Thread th11 = new FT();
		th11.start();
		Thread th2 = new Thread(new FT2());
		th2.start();
		while(true){
			System.out.println("���� �޴´�");
			try{ Thread.sleep(3000); }catch(Exception e){}
		}
	}
	public static void main(String[] args) 
	{
		new F();
	}
}
