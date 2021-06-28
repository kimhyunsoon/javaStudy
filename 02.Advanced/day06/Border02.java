import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Border02 extends JFrame{
    
    Container cp;
    JPanel p;
    JPanel pSub;
    JButton bN, bS, bE, bW,bC;
    JButton bPC, bPN, bPE, bPW, bPS;
    JButton bPSN, bPSS,bPSC;
    


    
    void init(){
        
        pSub = new JPanel();
        pSub.setLayout(new BorderLayout());
        bPSN = new JButton("�����гκ�");
        bPSS = new JButton("�����гγ�");
        bPSC = new JButton("�����гμ���");
        pSub.add(bPSN, BorderLayout.NORTH);
        pSub.add(bPSS, BorderLayout.SOUTH);
        pSub.add(bPSC);


        
        p = new JPanel();
        p.setLayout(new BorderLayout());
        bPC = new JButton("�г� ����");
        bPN = new JButton("�г� ��");
        bPE = new JButton("�г� ��");
        bPW = new JButton("�г� ��");
        bPS = new JButton("�г� ��");
        p.add(pSub);
        p.add(bPN,BorderLayout.NORTH);
        p.add(bPE,BorderLayout.EAST);
        p.add(bPW,BorderLayout.WEST);
        p.add(bPS,BorderLayout.SOUTH);
        
        

        
        
        
        bN = new JButton("��");
        bS = new JButton("��");
        bE = new JButton("��");
        bW = new JButton("��");
        bC = new JButton("���");
        cp = getContentPane();
        cp.add(bN, BorderLayout.NORTH);
        cp.add(bS, BorderLayout.SOUTH);
        cp.add(bE, BorderLayout.EAST);
        cp.add(bW, BorderLayout.WEST);
        cp.add(p);

        
        setUI();

    }
    
    void setUI(){
		setTitle("BorderLayout Ver 1.0");
		setSize(500, 300);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args){
        Border02 b2 = new Border02();
        b2.init();

    }
}
