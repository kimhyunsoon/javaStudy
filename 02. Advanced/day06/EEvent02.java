import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EEvent02 extends JFrame{

    JButton b;
    void init(){ //���� ����(1)
        b = new JButton("�ڹ��� ��ư");
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("Ŭ��! by ���� ����(1)");
            }
        };
        
        b.addActionListener(listener);
        add(b);
        setUI();
    }

    void init02(){
        b = new JButton("�ڹ��� ��ư");
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("Ŭ��! by ���� ����(2)");
            }
        });
        add(b);
        setUI();
    }
    
    void setUI(){
        setTitle("Event Test ver 1.0"); //����
        setSize(300,200); //������
        setVisible(true); 
        setLocation(250,100); //��ġ
        setResizable(false); //�������������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� �ݾ����� �׼� ����

    }
    public static void main(String[] args ){

        EEvent02 event01 = new EEvent02();
        event01.init02();
        
        
    }
    
}
