class Game{
    String name;

    Game(String name){
        this.name=name;
    }
    void play(){
        System.out.println(name+"��(��) �Ѵ�");
    }
}

class Overwatch extends Game{
    Overwatch(){
        super("������ġ");
    }

}

class zelda extends Game{
    zelda(){
        super("����");
    }

}

class MonsterHunter extends Game{
    MonsterHunter(){
        super("����");
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