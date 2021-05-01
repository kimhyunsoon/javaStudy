class G{ // 备备备窜
    void whileMultiply(String a){
      if(a == "for"){
		  for(int i = 2; i<=9; i++){
			  for(int j = 1; j<=9; j++){
				  for(int k = 1; k<=9; k++){
					  System.out.println(i + " * " + j + " * " + k + " = " + (long)(i*k*j));
				  }
			  }  
		  }

		  System.out.println(a+"肺 备备备窜");
	  } else if (a == "while") {
			int i = 2;
			while (i<10){
				int j = 1;
				while (j<10){
					int k = 1;
					while (k<10){
						System.out.println(i + " * " + j + " * " + k + " = " + (long)(i*k*j));
						k++;
					}
					j++;
				}
				i++;
			}
			System.out.println(a+"肺 备备备窜");
		}
		
    }
    public static void main(String[] args){
        new G().whileMultiply("while");
    }
}