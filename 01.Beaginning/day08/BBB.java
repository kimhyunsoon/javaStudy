class ����{
    void play(){
        System.out.println("������ �Ѵ�");
    }
}

class ������ġ extends ����{
    void play(){
        System.out.println("������ġ�� �Ѵ�");
    }
}

class ���� extends ����{
    void play(){
        System.out.println("���ٸ� �Ѵ�");
    }
}

class �������� extends ����{
    void play(){
        System.out.println("������ �Ѵ�");
    }
}

class BBB{
    public static void main(String[] args){
        ���� oc = new ������ġ();
        ���� zd = new ����();
        ���� mh = new ��������();
        oc.play();
        zd.play();
        mh.play();

    }
}