// package starHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TabPane extends JFrame{

    JTabbedPane tabs; //JTabbedPane
    JButton jb1, jb2;
    Container cp;
    JPanel register, inquiry, reserve, emp, medical;
    JLabel label;





    TabPane(){


        // Setting the JTabbedPane Position and Layout as Wrap


        tabs = new JTabbedPane(JTabbedPane.LEFT, JTabbedPane.WRAP_TAB_LAYOUT);

        register = new JPanel();
        inquiry = new JPanel();
        reserve = new JPanel();
        emp = new JPanel();
        medical = new JPanel();






        label = new JLabel();
        label.setIcon(new ImageIcon("C:\\KAEUN\\gitStudy\\Project\\src\\starHospital\\register.png"));
        // label.setBorderPainted(false);
        // label.setContentAreaFilled(false);
        // label.setHorizontalTextPosition(JLabel.TRAILING); // Set the text position regarding its icon
        // label.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        
        tabs.addTab(null, new JPanel());
        tabs.setTabComponentAt(0, label); // Here set the custom tab component
        tabs.addTab("ȸ������", register);
        tabs.addTab("��ȸ", inquiry);
        tabs.addTab("�������", reserve);
        tabs.addTab("��������", emp);
        tabs.addTab("����ī��", medical);




        jb1 = new JButton("Ȯ��");
        jb2 = new JButton("���");


        register.setLayout(new FlowLayout());
        register.add(jb1);
        register.add(jb2);




        


        // �̹��� �ְ� ���� ��

        // tabs.addTab("Welcome",new ImageIcon("resources\\1.png"),mainPanel,"Takes to the welcome page");

        // tabs.addTab(title, icon, component);



        getContentPane().add(tabs);
        setUI();
    }

    void setPanel(){





    }
    


    void setUI(){
		setTitle("JTable Test Ver 1.0");
		setSize(960, 540);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {
        new TabPane();
        
    }
    
}
