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
		bPBC = new JButton("베이비 센터");
		bPBN = new JButton("베이비 북쪽");
		pBaby.add(bPBC, BorderLayout.CENTER);
		pBaby.add(bPBN, BorderLayout.NORTH);

		p = new JPanel();
		p.setLayout(new BorderLayout());
		bPC = new JButton("패널 센터");
		bPE = new JButton("패널 동쪽");
		bPW = new JButton("패널 서쪽");
        //p.add(bPC, BorderLayout.CENTER);
		p.add(pBaby, BorderLayout.CENTER);
		p.add(bPE, BorderLayout.EAST);
		p.add(bPW, BorderLayout.WEST);

		bN = new JButton("북");
		bS = new JButton("남");
		bW = new JButton("서");
		bE = new JButton("동");
		//bC = new JButton("가운데");

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
