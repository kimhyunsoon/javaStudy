import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalUI extends JFrame  
{
	Container cp;
	JFormattedTextField tf;
	JPanel p;
	JButton bs[] = new JButton[10];
	JButton bC, bD, bP, bM, bPM, bMP, bDV, bE, bDot;
	JButton b;
	
	void init(){
		setTf();
		setP();

        cp = getContentPane();
        cp.add(tf, BorderLayout.NORTH);
		cp.add(p, BorderLayout.CENTER);

		setUI();
	}
	void setTf(){
		tf = new JFormattedTextField();
		Dimension d = new Dimension(300, 60);
		tf.setPreferredSize(d);
		Font f = new Font("SansSerif", Font.PLAIN, 25);
		tf.setFont(f);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setValue(0);
		KeyListener listener = new KeyAdapter(){
			int i = 0; 
			public void keyPressed(KeyEvent e){
				if(i == 0) tf.setText("");
				i++;
			}
		};
		tf.addKeyListener(listener);
	}
	void setP(){
        p = new JPanel();
        p.setLayout(new GridLayout(5, 4));
		ButtonHandler handler = new ButtonHandler(this);

        b = new JButton("°¡Àº");
		bC = new JButton("Clear");
		bD = new JButton("Back");
		bDV = new JButton("¡À");
		bMP = new JButton("x");
		bM = new JButton("-");
		bP = new JButton("+");
		bE = new JButton("=");
		bDot = new JButton(".");
		bPM = new JButton("¡¾");

		p.add(b);
        p.add(bC);
		p.add(bD);
		p.add(bDV);

		for(int i=0; i<bs.length; i++){
			bs[i] = new JButton(""+i);
			bs[i].addActionListener(handler);
		}
        p.add(bs[7]);
		p.add(bs[8]);
		p.add(bs[9]);
		p.add(bMP);
		p.add(bs[4]);
		p.add(bs[5]);
		p.add(bs[6]);
		p.add(bM);
		p.add(bs[1]);
		p.add(bs[2]);
		p.add(bs[3]);
		p.add(bP);
		p.add(bPM);
		p.add(bs[0]);
		p.add(bDot);
		p.add(bE);

		b.addActionListener(handler);
		bC.addActionListener(handler);
		bD.addActionListener(handler);
		bDV.addActionListener(handler);
		bMP.addActionListener(handler);
		bM.addActionListener(handler);
		bP.addActionListener(handler);
		bE.addActionListener(handler);
		bDot.addActionListener(handler);
		bPM.addActionListener(handler);
	}
	void setUI(){
		setTitle("Cal Ver 1.0");
		setSize(300, 400);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new CalUI().init();
	}
}
