/* public class B {
    int[] arr = new int[5];

    void m1(){
        for(int i=0; i<=5; i++){ //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
            arr[i] = i;
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.m1();
    }
    
    
} */



class B{ //ArrayException ����ó��
    int[] arr = new int[5];

    void m1(){
        try {
            for(int i=0; i<=5; i++){ 
            arr[i] = i;
            System.out.println(arr[i]);
        }
            
        } catch (ArrayIndexOutOfBoundsException e) { 
            //java.lang.ArrayIndexOutOfBoundsException ����Ŭ������ ��Ÿ��. ������ �� ����
            //�ε����� �����̰ų� �迭 ũ�⺸�� ũ�ų� ����
            System.out.println(e);
            System.out.println("����ó�� �κ�");
        }
        System.out.println("���α׷� ����");
    }

    public static void main(String[] args) {
        B b = new B();
        b.m1();
    }
}