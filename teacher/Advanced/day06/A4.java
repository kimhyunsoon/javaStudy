import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A4 extends JFrame implements ActionListener {
	JButton b;

	void init(){
		b = new JButton("자바의 버튼");
		b.addActionListener(this);
		add(b);

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
		b.setText("클릭! by 자신의 객체");
	}
	public static void main(String[] args) 
	{
		A4 a4 = new A4();
		a4.init();
	}
}
