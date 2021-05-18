class ET extends Thread 
{
	@Override
	public void run(){
		m();
	}	
	void m(){
		while(true){
			try{
				Thread.sleep(1000);
				System.out.println("m()");
			}catch(InterruptedException ie){}
		}
	}
}


class E  
{
	E(){
		Thread th1 = new ET();
		Thread th2 = new ET();
		th1.start();
		th2.start();
		while(true){
			try{
				Thread.sleep(1000);
				System.out.println("E()");
			}catch(InterruptedException ie){}
		}
	}
	public static void main(String[] args) {
		E e = new E();
	}
}
