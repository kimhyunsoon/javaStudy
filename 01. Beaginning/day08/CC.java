class CC {
    
    private String accountNum = "123456-1234567";
    private long balance = 541256L;
    String getAccountNum(){
        return accountNum;
    }
    long getBalance(){
        return balance;
    }

    void setAccountNum(String accountNum){
        this.accountNum=accountNum;
    }
    void setBalance(long balance){
        this.balance=balance;
    }


}

class CCUser{
    
    public static void main(String[] args) {
        CC cc = new CC();
        
        System.out.println("°èÁÂ¹øÈ£: "+cc.getAccountNum());
        System.out.println("ÀÜ¾×: "+cc.getBalance());

        cc.setBalance(1247456L);
        System.out.println("°èÁÂ¹øÈ£: "+cc.getAccountNum());
        System.out.println("ÀÜ¾×: "+cc.getBalance());
        
        
    }
}