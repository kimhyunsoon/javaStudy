import org.graalvm.compiler.nodes.NodeView.Default;

class CCC { //switch, case
            //
    void m1(int i){

        switch(i){
            case 10: System.out.println("샌프란시스코 쇼크 우승입니다");break; 
            case 20: System.out.println("상하이드래곤즈 우승입니다");break;
            case 30: System.out.println("필라델피아 퓨전 우승입니다");break;
            default: System.out.println("셋 중에 우승팀이 없습니다");
        }
    }

    void m2(String str, int i){
        
        switch(str){
            case "아침": System.out.println("아침"); break;
            case "점심": 
                if(i>0) System.out.println("점심A");
                else if(i<0) System.out.println("점심B");
                else System.out.println("안먹음");
                break;
            default: System.out.println("저녁");
 
        }
   }

   void m3(String str, char c){
        switch(str){
            case "아침": System.out.println("아침");break;
            case "점심":
                switch(c){
                    case 'A': System.out.println("점심A");break;
                    case 'B': System.out.println("점심B");break;
                    default : System.out.println("안먹음");
                }break;
            default: System.out.println("저녁");
            
        }

   }

    public static void main(String[] args){
        CCC ccc = new CCC();
        ccc.m1(10);
        ccc.m2("점심", 15);
        ccc.m3("아침", 'B');
    }
}
