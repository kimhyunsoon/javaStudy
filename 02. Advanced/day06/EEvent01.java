import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EEvent01 extends JFrame{

    JButton b;
    
    //ActionListener �������̽��κ��� ������ ����Ŭ���� 
    //ActionListener(interface) : ����Ŭ���� �����Ͽ� �������̽��� �����ϰ�
    //�ش� Ŭ�������� ������ ��ü�� ������Ʈ�� addActionListener �޼ҵ带 ����Ͽ�
    //������Ʈ�� ��ϵ˴ϴ�. �̺�Ʈ�� �߻��ϸ� �ش� ��ü�� actionPerformed �޼��尡
    // ȣ��˴ϴ�.
    class EEvent01Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {  
            b.setText("Ŭ��! by ���� ����Ŭ����");
            //ActionEvent Ŭ���� : addActionListener �޼ҵ带 ����Ͽ� 
            //�ش� �̺�Ʈ�� �����ϵ��� ��ϵ� ��� ActionListener ��ü�� ����
            
            
            // Object obj= e.getSource(); //��ȯŸ��: �̺�Ʈ�� ó�� �߻��� Object
            // JButton jb = (JButton)obj;
            // jb.setText("Ŭ��! by ���� ����Ŭ����(event ��ü �̿�)");
            //�̺�Ʈ�� �߻��� ��ü�� ���ؼ� �ش�
        } 
    }
    
    
    void init(){

        b = new JButton("�ڹ��� ��ư");
        ActionListener listener = new EEvent01Handler(); //�̺�Ʈ�ڵ鷯 Ŭ�����κ��� �׼Ǹ����� �����ؼ� ����?
        b.addActionListener(listener);
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

        EEvent01 event01 = new EEvent01();
        event01.init();
        
        
    }
    
}
