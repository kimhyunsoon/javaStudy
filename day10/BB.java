class BB 
{
	static int i;
	BB(){
	}
	static void m(){
		System.out.println("m()");
	}
	
}



class BBUser
{

    public static void main(String args[]){
        System.out.println("i: "+BB.i);
        BB.m();
        BB bb1 = new BB();
        BB bb2 = new BB();

        System.out.println("b1.i: "+bb1.i);
        bb1.i++;
        System.out.println("b2.i: "+bb2.i);
       
        
    }



}