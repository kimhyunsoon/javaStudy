import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonHandler implements ActionListener
{
	CalUI calui;
	ButtonHandler(CalUI c){
		this.calui = calui;
	}

    StringBuffer sb = new StringBuffer(); 
    //문자가없고 초기 용량이 16자인 문자열 버퍼를 구성합니다.
    
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        JButton btn = (JButton) obj;
        //btn.setText("가은"); //버튼 누르니까 가은으로 바뀜
           
        String label = btn.getText();
        if(getNum(label) != -1L){ //숫자형태인 경우
            if(!(sb.length() == 0 && label.equals("0"))){
                sb.append(label); //이 문자 시퀀스에 지정된 문자열을 추가합니다.
            }
        }
        calui.tfield.setText(sb.toString());
        System.out.println(sb);




        pln(label); 



        
        
	}

    long getNum(String label){
        try {//숫자가 써있으면 lo로 반환하고
            long lo = Long.parseLong(label);
            return lo;
            
        } catch (NumberFormatException ne) { //숫자외의 것이면 -1로 반환
            return -1L;
        }


        
    }


    



    void pln(String str){
        System.out.println(str);

    }
}