public class A1 { 
    //1. ���������� �̸��� ���� ��������� �ش��������� ������ ��
    int age;
    
    A1(int age){
        // age = age;  �� ��쿡�� age:0 �� ����.
        this.age = age;
        
    }

    public static void main(String[] args) {
        A1 a = new A1(20);
        System.out.println("age: "+a. age);
        
    }
    
}
