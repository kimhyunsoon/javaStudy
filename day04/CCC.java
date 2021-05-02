import org.graalvm.compiler.nodes.NodeView.Default;

class CCC { //switch, case
            //
    void m1(int i){

        switch(i){
            case 10: System.out.println("�������ý��� ��ũ ����Դϴ�");break; 
            case 20: System.out.println("�����̵巡���� ����Դϴ�");break;
            case 30: System.out.println("�ʶ��Ǿ� ǻ�� ����Դϴ�");break;
            default: System.out.println("�� �߿� ������� �����ϴ�");
        }
    }

    void m2(String str, int i){
        
        switch(str){
            case "��ħ": System.out.println("��ħ"); break;
            case "����": 
                if(i>0) System.out.println("����A");
                else if(i<0) System.out.println("����B");
                else System.out.println("�ȸ���");
                break;
            default: System.out.println("����");
 
        }
   }

   void m3(String str, char c){
        switch(str){
            case "��ħ": System.out.println("��ħ");break;
            case "����":
                switch(c){
                    case 'A': System.out.println("����A");break;
                    case 'B': System.out.println("����B");break;
                    default : System.out.println("�ȸ���");
                }break;
            default: System.out.println("����");
            
        }

   }

    public static void main(String[] args){
        CCC ccc = new CCC();
        ccc.m1(10);
        ccc.m2("����", 15);
        ccc.m3("��ħ", 'B');
    }
}
