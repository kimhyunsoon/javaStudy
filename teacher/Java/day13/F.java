class FT extends Thread { //(1) 방법1
	public void run(){
		while(true){
			System.out.println("서빙을 한다");
			try{ Thread.sleep(1000); }catch(Exception e){}
		}
	}
}
class FT2 implements Runnable { //(2) 방법2

	public void run(){
		while(true){
			System.out.println("음식을 만든다");
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
			System.out.println("돈을 받는다");
			try{ Thread.sleep(3000); }catch(Exception e){}
		}
	}
	public static void main(String[] args) 
	{
		new F();
	}
}
