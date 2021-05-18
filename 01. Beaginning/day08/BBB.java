class 게임{
    void play(){
        System.out.println("게임을 한다");
    }
}

class 오버워치 extends 게임{
    void play(){
        System.out.println("오버워치를 한다");
    }
}

class 젤다 extends 게임{
    void play(){
        System.out.println("젤다를 한다");
    }
}

class 몬스터헌터 extends 게임{
    void play(){
        System.out.println("몬헌을 한다");
    }
}

class BBB{
    public static void main(String[] args){
        게임 oc = new 오버워치();
        게임 zd = new 젤다();
        게임 mh = new 몬스터헌터();
        oc.play();
        zd.play();
        mh.play();

    }
}