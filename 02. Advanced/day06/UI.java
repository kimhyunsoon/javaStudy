import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI extends JFrame{

    JButton b;
    void init(){
        b = new JButton("�ڹ��� ��ư");
        add(b);
        setUI();


    }

    void setUI(){
        setTitle("GUI Test Ver 1.0"); //�� ���ۿ� �𽺰� �����Ǿ� �ִ�. JFram�� �޼ҵ��
        setSize(300,200); //������
        setVisible(true);
        setLocation(200, 100); //��ġ
        setResizable(false); //â�� �ȴþ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� ���� �ý����� ����������
    }

    public static void main(String[] args){
        UI ui= new UI();
        ui.init();

    }
    
}
