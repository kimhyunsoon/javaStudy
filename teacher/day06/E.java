class E 
{
	/*
	int is1[] = {1, 2}; //1차
	int is2[] = {30, 40}; //1차  
	int iss[][] = {is1, is2}; //2차 
	void out1(){
		for(int i=0; i<iss.length; i++){
			for(int j=0; j<iss[i].length; j++){
				System.out.println(
					"iss["+i+"]["+j+"]: " + iss[i][j]);
			}
		}
	}*/
	int is1[] = {1, 2}; //1차
	int is2[] = {30, 40, 50, 60}; //1차
    int iss[][] = {is1, is2, {700, 800, 900}, {1000}}; //2차
	void out2(){ //2차원배열(iss)에서 데이터를 모두 뽑아내시오
        for(int i=0; i<iss.length; i++){
			for(int j=0; j<iss[i].length; j++){
				System.out.println(
					"iss["+i+"]["+j+"]: " + iss[i][j]);
			}
		}
	}

	int isss[][][] = {iss, {{11,22},{333}} }; //3차
	void out3(){
		for(int i=0; i<isss.length; i++){
			for(int j=0; j<isss[i].length; j++){
				for(int k=0; k<isss[i][j].length; k++){
					System.out.println(
					"isss["+i+"]["+j+"]["+k+"]: " 
						+ isss[i][j][k]);
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		E e = new E();
		//e.out1();
		//e.out2();
		e.out3();
	}
}
