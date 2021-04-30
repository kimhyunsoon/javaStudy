class G{ // 구구구단
    void whileMultiply(String a){
      if(a == "for"){
		  for(int i = 2; i<=9; i++){
			  for(int j = 1; j<=9; j++){
				  for(int k = 1; k<=9; k++){
					  System.out.println(i + " * " + j + " * " + k + " = " + (long)(i*k*j));
				  }
			  }  
		  }
	  } else if (a == "while") {
			int i = 1;
			while (i<9){
				i++;
				int j = 0;
				while (j<9){
					j++;
					int k = 0;
					while (k<9){
						k++;
						System.out.println(i + " * " + j + " * " + k + " = " + (long)(i*k*j));
					}
				}
			}
		}
    }
    public static void main(String[] args){
        new G().whileMultiply("while");
    }
}