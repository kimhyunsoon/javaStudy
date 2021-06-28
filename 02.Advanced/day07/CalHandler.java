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
        
        String s = cg.info.getText().replace("÷","/").replace("×","*"); 

        ArrayList<Double> numList = new ArrayList<Double>(); //lable의 숫자를 저장할 ArrayList
        ArrayList<Character> opList = new ArrayList<Character>(); //연산 저장할 ArrayList

        String num="";

        try {
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i); //String을 char 타입 단위로 나눔
                
                if(ch == '+' || ch =='-' || ch == '*' || ch == '/'){
                    numList.add(Double.parseDouble(num)); //
                    opList.add(ch); //연산자를 연산자 배열에 추가
                    num =""; //임시로 저장된 숫자를 비워준다
                    continue; //증감식으로 건너뛴다
                }
                num +=ch;
            }
            numList.add(Double.parseDouble(num)); //마지막 숫자
            
            int cnt = opList.size();
            for(int j = 0; j<cnt; j++){
                int me = 0;
                Double tmp = 0.0;
    
                if(opList.contains('*')){
                    me = opList.indexOf('*'); 
                    tmp = numList.get(me)*numList.get(me+1);
                    numList.set(me, tmp); //me를 null로 바꿈
                }else if(opList.contains('/')){
                    me = opList.indexOf('/');
                    tmp = numList.get(me)/numList.get(me+1);
                    numList.set(me, tmp); //me를 null로 바꿈
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
