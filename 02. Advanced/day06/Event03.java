import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI3 extends JFrame{

    JButton b;
    
    
    void init(){
        b = new JButton("�ڹ��� ��ư");
        A3Handler a3= new A3Handler(this);
        b.addActionListener(a3); 
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
        UI3 ui3= new UI3();
        ui3.init();

    }
    
}

class A3Handler implements ActionListener{
    A3 a3;
    A3Handler(A3 a3){

    }
    public void actionPerformed(ActionEvent e){
        //b.setText("Ŭ��! by ���� ����Ŭ����");
        Object obj = e.getSource();
        JButton jb = (JButton)obj;
        jb.setText("Ŭ��! by ��3Ŭ���� �̿�"); 
        //�̺�Ʈ�� �߻��� ��ü�� ���ؼ� �ش�
    }
    
}
