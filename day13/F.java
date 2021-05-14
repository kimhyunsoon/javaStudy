class FT extends Thread //(1)java.lang.Thread 상속
{
	public void run(){
        while(true){
            System.out.println("서빙을 한다");
            try{
                Thread.sleep(1000);
            }catch(Exception e){} //InterruptedException 까지 필요하지 않아서
        }
	}	
}

class FT2 implements Runnable{ //(2) java.lang.Runnable 상속?구현?
    public void run(){
        while(true){
            System.out.println("음식을 만든다");
            try{
                Thread.sleep(2000);
            }catch(Exception e){} //InterruptedException 까지 필요하지 않아서
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
			System.out.println("돈을 받는다");
            try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
	public static void main(String[] args) {
		F f = new F();
	}
}
