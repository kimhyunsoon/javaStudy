class ET { //쓰레드로부터 상속받은 클래스 ET
    
    public void run(){
        m();
    }
    
    
    void m(){
        while(true){
            try{
                Thread.sleep(1000);
                System.out.println("메소드 m");
            }catch(InterruptedException ie){}
        }
    }



    public static void main(String [] args) {
        ET et = new ET();
        et.m();
    }
}

//싱글쓰레드 구현