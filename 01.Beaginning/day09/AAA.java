// class FoolException extends RuntimeException{
// //��Ÿ���ͼ����� �̸� �߻����ѳ��´�

// }

class FoolException extends Exception{

}


class AAA {
    void m1(String nick) throws FoolException { 
        //throws�� ���� ǥ���� ��. �̷��� �Ǹ� ���ܸ� ó���ؾ� �ϴ� ����� AAA�޼ҵ忡�� main�޼ҵ�� �ٲ����
        //main �޼ҵ忡�� �ݵ�� ����ó���� ����� �Ѵ�.
        if ("fool".equals(nick)) {
            //return; ->�Էµ� ���� fool�� �� ȣ���� ��(main �޼ҵ�)���� ����
            throw new FoolException(); //throw (�����)�� ���� ��ü�� ����
        }
        System.out.println("����� ������"+nick+"�Դϴ�");
    }

    public static void main(String[] args) {
        AAA aaa= new AAA();
        try { //main �޼ҵ�� ���Ѱ��� ���� ó��
            aaa.m1("fool");
            aaa.m1("genious");
            
        } catch (FoolException e) {
            System.out.println(e+" ������ �߻�"); //toString
            //TODO: handle exception
        }
    }


}
