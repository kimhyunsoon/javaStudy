class BBBB {
   boolean flag = true;
   BBBB(){
       m1();
       System.out.println("B()");
   }
   
   void m1(){
        System.out.println("m1(): 1");
        if (flag) return;
        System.out.println("m1(): 2");
   }

   void m2(){
       for(int j=0; j<2; j++){
           for(int i=0; i<3; i++){
               if(i==2) return;
               System.out.println("j: " + j + ", i: " + i);
           }
       }
   }

   int m3(){
       int i=5;
       System.out.println("m3()");
       return i;
   }

   public static void main(String[] args){
       BBBB b = new BBBB();
       b. m1();
       b. m2();
       System.out.println("main(): 1");
       int r=b.m3();
       System.out.println("main(): 2, r: "+r);
   }


}
