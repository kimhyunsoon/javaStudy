import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Tip extends JFrame implements ActionListener {
	JButton b1;
	JButton b2;

	void init(){
		b1 = new JButton("버튼1");
		b2 = new JButton("버튼2");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);
		add(b2, BorderLayout.SOUTH);

		setUI();
	}
    void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == b1){
			b2.setText("클릭1! by 자신의 객체 (상대방을 핸들링)");
		}else { //obj == b2
			b1.setText("클릭2! by 자신의 객체 (상대방을 핸들링)");
		}
	}
	public static void main(String[] args) 
	{
		Tip t = new Tip();
		t.init();
	}
}
