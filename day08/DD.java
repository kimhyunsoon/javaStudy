class DD {
    int plus(int a, int b){
        return a+b;

    }
}

class DDUser{
    public static void main(String[] args){
        DD dd = new DD();
        int r = dd.plus(100,200);
        System.out.println("°á°ú´Â? "+r);

    }
}
