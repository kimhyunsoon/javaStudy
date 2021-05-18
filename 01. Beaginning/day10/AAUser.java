package kaeun.game;
import kaeun.name.AA; // 다른 패키지의 클래스 접근

public class AAUser extends AA {

    AAUser(){
        super();
        System.out.println(name+"이는 오버워치를 합니다");
        call();

    }

    public static void main(String[] args) {
        new AAUser();
        
    }
    
}
