class EE {
    int a[] = {1,2}; //1���� �迭
    int b[] = {30,40,50,60}; //1���� �迭
    int c[][] = {a,b,{700,800,900},{1000}}; //2���� �迭
    //�迭 c�� 0��° �濡�� a�迭, 1��° �濡�� b�迭�� �ְ�
    //0��° �濡�� 2���� ��, 1��° �濡�� �� 4��, 3��° �濡�� �� 3��, 4��° �濡�� �� 1��

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

    void cOut(){ // ������ �迭 c���� �����͸� ��� �̾Ƴ��ÿ�
        for(int i=0; i<c.length;i++){ //�� ����
            for(int j=0; j<c[i].length; j++){ //������ �� ��ȣ �ȿ� �� ����
                System.out.println("c["+i+"]["+j+"]: "+c[i][j]);
            }
        }
    }

    int d[][][] = {c, {{11,22},{33}}}; //3����
    void dOut(){ // d�� �����͸� ����Ͻÿ�
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
