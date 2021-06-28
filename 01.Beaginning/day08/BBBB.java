class Game{
    String name;

    Game(String name){
        this.name=name;
    }
    void play(){
        System.out.println(name+"을(를) 한다");
    }
}

class Overwatch extends Game{
    Overwatch(){
        super("오버워치");
    }

}

class zelda extends Game{
    zelda(){
        super("젤다");
    }

}

class MonsterHunter extends Game{
    MonsterHunter(){
        super("몬헌");
    }
}


class BBBB{
    public static void main(String[] args){
        Game oc = new Overwatch();
        Game zd = new zelda();
        Game mh = new MonsterHunter();
        oc.play();
        zd.play();
        mh.play();

    }
}