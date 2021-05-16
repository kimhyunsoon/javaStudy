class BBBB {
    String name ="김현순";

    class BBBBInner1{
        String name1 = "이가은";
        void m1(){
            System.out.println("첫번째 이너클래스의 메소드");
        }
    }

    static class BBBBInner2{
        String name2 = "똥이";
        void m2(){
            System.out.println("두번째 이너클래스의 메소드");
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