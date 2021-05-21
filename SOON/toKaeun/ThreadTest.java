
public class ThreadTest extends Thread{
    int arg;

    public ThreadTest(int arg) {
        this.arg=arg;
    }

    @Override
    public void run() {//Thread.start()시 실행되는 함수,
        System.out.println("Thread Start: "+this.arg);
    
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread end :" + this.arg);

    }
    
    public static void main(String[] args) {

        for(int i=0; i<10; i++){
            ThreadTest th=new ThreadTest(i+1);
            th.start();
        }
    
        System.out.println("main end");
    
    }
}