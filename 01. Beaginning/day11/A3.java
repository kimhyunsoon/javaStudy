class A3 { //3. �ڽ��� �����ڸ� ȣ���� ��
    int i;
    A3(int i){
        this.i = i;

    }
    A3(){
        this(10);
    }

    
    public static void main(String[] args) {
        A3 a3 = new A3();
        System.out.println("i: "+a3.i);
        
    }
}
