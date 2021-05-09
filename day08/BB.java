class Star {

    void x(){

        System.out.println("x");
    }
}

class Wars extends Star {

    void x(){

        System.out.println("순이 바보");
    }

    void 패버린다(){
        System.out.println("까불지맛");
    }
}


class God {

    public static void main(String[] args) {
        
        Star a = new Wars();
        a.x();
        a.패버린다();
      
    }

}