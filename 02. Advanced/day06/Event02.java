import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI2 extends JFrame{



    JButton b;
    void init(){
        b = new JButton("�ڹ��� ��ư");
        // ActionListener listener = new ActionListener()
        // {
        //     public void actionPerformed(ActionEvent e){
        //         b.setText("Ŭ��! by ���� ����Ŭ����");}
        // }

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b.setText("Ŭ��! by ���� ����Ŭ����");
            }
        }); 
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
        UI2 ui2= new UI2();
        ui2.init();

    }
    
}
