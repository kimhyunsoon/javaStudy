class BBBB {
    String name ="������";

    class BBBBInner1{
        String name1 = "�̰���";
        void m1(){
            System.out.println("ù��° �̳�Ŭ������ �޼ҵ�");
        }
    }

    static class BBBBInner2{
        String name2 = "����";
        void m2(){
            System.out.println("�ι�° �̳�Ŭ������ �޼ҵ�");
        }
    }
}


class BBBBUser{
    public static void main(String[] args) {
        BBBB.BBBBInner1 var1 = new BBBB().new BBBBInner1();
        var1.m1();
        System.out.println(var1.name1);

        BBBB.BBBBInner2 var2 = new BBBB.BBBBInner2();
        var2.m2();
        System.out.println(var2.name2);

    }

}