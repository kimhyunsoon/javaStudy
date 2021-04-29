import java.util.Date;

class nowDate{
  Date nowDate = new Date();
  nowDate(){}
  void datePrint(){
    System.out.println("현재일시분초: "+nowDate);
  }
}

class time{
  public static void main(String[] args){
    nowDate zz = new nowDate();
    zz.datePrint();
  }
}



