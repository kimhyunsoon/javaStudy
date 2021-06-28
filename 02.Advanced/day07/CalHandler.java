import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CalHandler implements ActionListener{

    CalGUI cg;
    CalHandler(CalGUI cg){
        this.cg = cg;

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // String infotext= cg.info.getText();
        // String iptext= cg.input.getText();
        cg.info.setText(cg.info.getText()+cg.input.getText());
        
        String s = cg.info.getText().replace("��","/").replace("��","*"); 

        ArrayList<Double> numList = new ArrayList<Double>(); //lable�� ���ڸ� ������ ArrayList
        ArrayList<Character> opList = new ArrayList<Character>(); //���� ������ ArrayList

        String num="";

        try {
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i); //String�� char Ÿ�� ������ ����
                
                if(ch == '+' || ch =='-' || ch == '*' || ch == '/'){
                    numList.add(Double.parseDouble(num)); //
                    opList.add(ch); //�����ڸ� ������ �迭�� �߰�
                    num =""; //�ӽ÷� ����� ���ڸ� ����ش�
                    continue; //���������� �ǳʶڴ�
                }
                num +=ch;
            }
            numList.add(Double.parseDouble(num)); //������ ����
            
            int cnt = opList.size();
            for(int j = 0; j<cnt; j++){
                int me = 0;
                Double tmp = 0.0;
    
                if(opList.contains('*')){
                    me = opList.indexOf('*'); 
                    tmp = numList.get(me)*numList.get(me+1);
                    numList.set(me, tmp); //me�� null�� �ٲ�
                }else if(opList.contains('/')){
                    me = opList.indexOf('/');
                    tmp = numList.get(me)/numList.get(me+1);
                    numList.set(me, tmp); //me�� null�� �ٲ�
                } else if(opList.contains('+')){
                    me = opList.indexOf('+');
                    tmp = numList.get(me)+numList.get(me+1);
                    numList.set(me, tmp);
                } else if(opList.contains('-')){
                    me = opList.indexOf('-');
                    tmp = numList.get(me)-numList.get(me+1);
                    numList.set(me, tmp);
                }
                opList.remove(me);
                numList.remove(me+1);
                cnt --;
                j--;
            }

            cg.input.setText(numList.get(0).toString());
            cg.info.setText("");

        } catch (NumberFormatException ne) {
            //TODO: handle exception
        }
        
        


    }

}
