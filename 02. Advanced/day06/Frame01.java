import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//BorderLayout
public class Frame01 extends JFrame{
    Container cp;
    JPanel p;
    JPanel pBaby;

    JButton bn,bs,bw,be,bc;
    JButton bpc,bpe,bpw;
    JButton bPBN,bPBC;

    void init(){

        pBaby = new JPanel();
        pBaby.setLayout(new BorderLayout());
        bPBC = new JButton("���̺� ����");
        bPBN = new JButton("���̺� ����");
        pBaby.add(bPBC, BorderLayout.CENTER);
        pBaby.add(bPBN, BorderLayout.NORTH);

        p = new JPanel();
        p.setLayout(new BorderLayout());
        bpc = new JButton("�г� ����");
        bpe = new JButton("�г� ����");
        bpw = new JButton("�г� ����");
        //p.add(bPC, BorderLayout.CENTER);
        p.add(pBaby, BorderLayout.CENTER);
        p.add(bpe, BorderLayout.EAST);
        p.add(bpw, BorderLayout.WEST);



        bn = new JButton("��");
        bs = new JButton("��");
        bw = new JButton("��");
        be = new JButton("��");
        //bc = new JButton("���");

        cp = getContentPane();
        cp.add(bn, BorderLayout.NORTH);
        cp.add(bs, BorderLayout.SOUTH);
        cp.add(bw, BorderLayout.WEST);
        cp.add(be, BorderLayout.EAST);
        //cp.add(bc, BorderLayout.CENTER);
        cp.add(p,BorderLayout.CENTER);
        setUI();
    }
    
    
    void setUI(){
		setTitle("BorderLayout Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
       Frame01 f = new Frame01();
       f.init();
        
    }
    
}
