import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI4 extends JFrame implements ActionListener{

    JButton b;
    
    
    void init(){
        b = new JButton("�ڹ��� ��ư");

        b.addActionListener(this); 
        add(b);
        setUI();


    }

    public void actionPerformed(ActionEvent e){
        b.setText("�ڱ��ڽ�");
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
        UI4 ui4= new UI4();
        ui4.init();

    }


}


