import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI extends JFrame{
    JButton b;

    class A1Handler implements ActionListener{
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
        ActionListener listener = new A1Handler();
        b.addActionListener(listener); //javax.swing�� ����, 
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
