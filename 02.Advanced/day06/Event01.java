import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Event01 extends JFrame{
    JButton b;

    class Event01Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //b.setText("Ŭ��! by ���� ����Ŭ����");
            Object obj = e.getSource();
            JButton jb = (JButton)obj;
            jb.setText("Ŭ��! by ���� ����Ŭ����(event ��ü �̿�)"); 
            //�̺�Ʈ�� �߻��� ��ü�� ���ؼ� �ش�
        }
        
    }



    void init(){
        b = new JButton("�ڹ��� ��ư");
        ActionListener listener = new Event01Handler();
        b.addActionListener(listener); //javax.swing�� ����, 
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
        Event01 event01= new Event01();
        event01.init();

    }
    
}
