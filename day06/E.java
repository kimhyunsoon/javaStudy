class E {

    int is1[]={1,2}; //1��
    int is2[]={30,40,50,60}; //1��
    int iss[][]={is1,is2,{700,800,900},{1000}}; //2��

    // void out1(){
    //     for(int i=0;i<2;i++){
    //         for(int j=0; j<2;j++){
    //             System.out.println("iss[0][0]: "+iss[i][j]);
    //         }
 
    //     }

    // }

    void out2(){ //2�����迭 iss���� �����͸� ��� �̾Ƴ��ÿ�
        for(int i=0;i<iss.length;i++){
            for(int j=0; j<iss[i].length;j++){
                
                    System.out.println("iss["+i+"]["+j+"]: "+iss[i][j]);
            }
        }
    }
    
    int isss[][][] = {iss,{{11,22}, {33}} }; //3����
    void out3(){//iss�� �����͸� ����Ͻÿ�
        for(int i=0;i<isss.length;i++){
            for(int j=0; j<isss[i].length; j++){
                for(int k=0; k<isss[i][j].length; k++){
                    System.out.println("isss["+i+"]["+j+"]["+k+"]:" +isss[i][j][k]); 
                }
            }
        }

    }


    public static void main(String[] args) {
        E e = new E();
        
        // e.out1();
        e.out2();
        e.out3();
    }
}
