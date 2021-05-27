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
    //���ڰ����� �ʱ� �뷮�� 16���� ���ڿ� ���۸� �����մϴ�.
    
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        JButton btn = (JButton) obj;
        //btn.setText("����"); //��ư �����ϱ� �������� �ٲ�
           
        String label = btn.getText();
        if(getNum(label) != -1L){ //���������� ���
            if(!(sb.length() == 0 && label.equals("0"))){
                sb.append(label); //�� ���� �������� ������ ���ڿ��� �߰��մϴ�.
            }
        }
        calui.tfield.setText(sb.toString());
        System.out.println(sb);




        pln(label); 



        
        
	}

    long getNum(String label){
        try {//���ڰ� �������� lo�� ��ȯ�ϰ�
            long lo = Long.parseLong(label);
            return lo;
            
        } catch (NumberFormatException ne) { //���ڿ��� ���̸� -1�� ��ȯ
            return -1L;
        }


        
    }


    



    void pln(String str){
        System.out.println(str);

    }
}