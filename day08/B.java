class ���� {

    void draw(){

        System.out.println("������ �׸���");
    }
    
}


class �簢�� extends ���� {

    void draw(){

        System.out.println("�簢���� �׸���");
    }
    
}

class �ﰢ�� extends ���� {

    void draw(){

        System.out.println("�ﰢ���� �׸���");
    }
    
}

class ���� extends ���� {

    void draw(){

        System.out.println("���� �׸���");
    }
    
}

class B {

    public static void main(String[] args) {
        
        ���� a = new �簢��();
        ���� b = new �ﰢ��();
        ���� c = new ����();
        a.draw();
        b.draw(); 
        c.draw();
            
    }

}



