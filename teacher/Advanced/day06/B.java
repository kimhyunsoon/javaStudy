import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class B extends JFrame
{
	Container cp;
	JButton bN, bS, bW, bE, bC;
	JButton bPC, bPE, bPW;
	JButton bPBN, bPBC;
	JPanel p;
	JPanel pBaby;

	void init(){
		pBaby = new JPanel();
		pBaby.setLayout(new BorderLayout());
		bPBC = new JButton("���̺� ����");
		bPBN = new JButton("���̺� ����");
		pBaby.add(bPBC, BorderLayout.CENTER);
		pBaby.add(bPBN, BorderLayout.NORTH);

		p = new JPanel();
		p.setLayout(new BorderLayout());
		bPC = new JButton("�г� ����");
		bPE = new JButton("�г� ����");
		bPW = new JButton("�г� ����");
        //p.add(bPC, BorderLayout.CENTER);
		p.add(pBaby, BorderLayout.CENTER);
		p.add(bPE, BorderLayout.EAST);
		p.add(bPW, BorderLayout.WEST);

		bN = new JButton("��");
		bS = new JButton("��");
		bW = new JButton("��");
		bE = new JButton("��");
		//bC = new JButton("���");

		cp =  getContentPane();
		cp.add(bN, BorderLayout.NORTH);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bE, BorderLayout.EAST);
		//cp.add(bC, BorderLayout.CENTER);
		cp.add(p, BorderLayout.CENTER);

		setUI();
	}
	void setUI(){
		setTitle("BorderLayout Test");
		setSize(400, 300);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new B().init();
	}
}
