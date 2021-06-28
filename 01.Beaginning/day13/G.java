class G {
    G(){
        System.out.println("max: "+Thread.MAX_PRIORITY); //가장 세다
        System.out.println("min: "+Thread.MIN_PRIORITY);
        System.out.println("norm: "+Thread.NORM_PRIORITY);
    }
    
    public static void main(String[] args) {
        new G();
        
    }
}
