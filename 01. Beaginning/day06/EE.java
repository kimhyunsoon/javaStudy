class EE {
    int a[] = {1,2}; //1차원 배열
    int b[] = {30,40,50,60}; //1차원 배열
    int c[][] = {a,b,{700,800,900},{1000}}; //2차원 배열
    //배열 c의 0번째 방에는 a배열, 1번째 방에는 b배열이 있고
    //0번째 방에는 2개의 방, 1번째 방에는 방 4개, 3번째 방에는 방 3개, 4번째 방에는 방 1개

    void aOut(){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    void bOut(){
        for(int i=0; i<b.length; i++){
            System.out.println(b[i]);
        }
    }

    void cOut(){ // 이차원 배열 c에서 데이터를 모두 뽑아내시오
        for(int i=0; i<c.length;i++){ //방 갯수
            for(int j=0; j<c[i].length; j++){ //각각의 방 번호 안에 방 갯수
                System.out.println("c["+i+"]["+j+"]: "+c[i][j]);
            }
        }
    }

    int d[][][] = {c, {{11,22},{33}}}; //3차원
    void dOut(){ // d의 데이터를 출력하시오
        for(int i=0; i<d.length; i++){
            for(int j=0; j<d[i].length; j++){
                for(int k=0; k<d[i][j].length; k++){
                    System.out.println("d["+i+"]["+j+"]["+k+"]:" +d[i][j][k]);
                }
            }
        }

    }

    public static void main(String[] args) {
        EE e = new EE();
        // e.aOut();
        // e.bOut();
        // e.cOut();
        e.dOut();
        
    }
    
}
