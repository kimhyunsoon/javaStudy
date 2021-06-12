class Th1 extends Thread  {
	public void run(){
		I.m();
	}
}
class Th2 extends Thread  {
	public void run(){
		I.m();
	}
}

class I { //무결성이 깨진 예 
	static int j = 0;
	I(){
		Thread t1 = new Th1();
		Thread t2 = new Th2();
		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch(InterruptedException ie){}

		System.out.println("j: " + j);
	}
	synchronized static void m(){ //방법1
		for(int i=0; i<1000000; i++){
			j++;
		}
	}
	void mNor(){
		System.out.println("1"); //동기화가 필요없는 로직 
		synchronized(this){ //방법2
			System.out.println("2"); //동기화가 필요한 로직 
		}
	}
	public static void main(String args[]){
		new I().mNor();
	}
}

