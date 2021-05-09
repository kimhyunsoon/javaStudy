class DDD {
    int multiple(int a, int b){
        return a*b;
    }

}

class DDDUser{
    public static void main(String[] args){
        DDD ddd = new DDD();
        int r=ddd.multiple(2,4);
        System.out.println("°á°ú´Â? "+r);


    }
}