class Star {

    void x(){

        System.out.println("x");
    }
}

class Wars extends Star {

    void x(){

        System.out.println("���� �ٺ�");
    }

    void �й�����(){
        System.out.println("�������");
    }
}


class God {

    public static void main(String[] args) {
        
        Star a = new Wars();
        a.x();
        a.�й�����();
      
    }

}