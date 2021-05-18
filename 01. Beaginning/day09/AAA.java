// class FoolException extends RuntimeException{
// //런타임익셉션을 미리 발생시켜놓는다

// }

class FoolException extends Exception{

}


class AAA {
    void m1(String nick) throws FoolException { 
        //throws로 예외 표식을 함. 이렇게 되면 예외를 처리해야 하는 대상이 AAA메소드에서 main메소드로 바뀌었다
        //main 메소드에서 반드시 예외처리를 해줘야 한다.
        if ("fool".equals(nick)) {
            //return; ->입력된 값이 fool일 때 호출한 곳(main 메소드)으로 돌림
            throw new FoolException(); //throw (예약어)로 예외 객체를 던짐
        }
        System.out.println("당신의 별명은"+nick+"입니다");
    }

    public static void main(String[] args) {
        AAA aaa= new AAA();
        try { //main 메소드로 떠넘겨진 예외 처리
            aaa.m1("fool");
            aaa.m1("genious");
            
        } catch (FoolException e) {
            System.out.println(e+" 에러가 발생"); //toString
            //TODO: handle exception
        }
    }


}
