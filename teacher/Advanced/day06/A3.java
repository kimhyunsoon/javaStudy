import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A3 extends JFrame {
	JButton b;

	void init(){
		b = new JButton("자바의 버튼");
		A3Handler h = new A3Handler(this);
		b.addActionListener(h);
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
	public static void main(String[] args) 
	{
		A3 a3 = new A3();
		a3.init();
	}
}
class A3Handler implements ActionListener
{
	A3 a3;
	A3Handler(A3 a3){
		this.a3 = a3;
	}
	public void actionPerformed(ActionEvent e){
		a3.b.setText("클릭! by 제3클래스");
	}
}