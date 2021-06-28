class DDDD {

    String str(String a, String b){
        return a+b;
    }
}

class DDDDUser{
    public static void main(String[] args) {
        DDDD dddd = new DDDD();
        String r = dddd.str("가은", "현순");
        System.out.println("결과는"+r);
        
    }
}