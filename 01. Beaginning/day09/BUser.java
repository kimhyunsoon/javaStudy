class BUser 
{
	boolean flag = true;
	void call() //throws Exception 
	{
		try{
			pln("1");
			AA1 a = new AA1();
			pln("2");
			a.use1();
			pln("3");
			a.use2();
			pln("4");
		}catch(MyException me){
			pln("5-1");			
			me.f1();
			pln("5-2");	
		}catch(YourException ye){
			pln("6-1");
			ye.f2();
			//if(flag) return;
			if(flag) System.exit(0);
			pln("6-2");
		}catch(Exception e){
			pln("7-1");
			System.out.println(e);
			pln("7-2");
		}finally{
			pln("8");
		}

		pln("9");
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String args[]) //throws Exception 
    {
		// new BUser().call();

		BUser bb = new BUser();
		bb.call();
		System.out.println("10");
	}
}
