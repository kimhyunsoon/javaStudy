class EE {
    void m1(){
        for(int i = 2; i<=9; i++){
           for(int j=1;j<=9;j++){
               for(int k=1;k<=9;k++){
                System.out.println(i+"*"+j+"*"+k+"="+i*j*k);
               }            
           }            
        }
        System.out.println("for로 돌린거임");
    }

    void m2(){
        int i=2;
        while(i<=9){
            int j=1;
            while(j<=9){
                int k=1;
                while(k<=9){
                    System.out.println(i+"*"+j+"*"+k+"="+i*j*k);
                    k++;
                }        
                j++;
            }    
            i++;           
        }
        System.out.println("while로 돌린거임");
    }

    public static void main(String args[]){
        EE ee = new EE();
        ee.m1();
        ee.m2();
    }
}
