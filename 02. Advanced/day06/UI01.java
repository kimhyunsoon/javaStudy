import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI01 extends JFrame{

    JButton b;

    void init(){
        b = new JButton("�ڹ��� ��ư");
        add(b); //Component java.awt.Container.add(Component comp)
        setUI();
    }
    
    
    void setUI(){
        setTitle("GUI Test ver 1.0"); //����
        setSize(300,200); //������
        setVisible(true); 
        setLocation(250,100); //��ġ
        setResizable(false); //�������������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݾ����� �׼� ����
    
    
    }

    public static void main(String[] args){

        UI01 ui = new UI01();
        ui.init();
        
    }
    
}
