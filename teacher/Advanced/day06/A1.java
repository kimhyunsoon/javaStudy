import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame {
	JButton b;

	class A1Handler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			b.setText("Ŭ��! by ���� ����");

			/*Object obj = e.getSource();
			JButton jb = (JButton)obj;
			jb.setText("Ŭ��! by ���� ���� (event��ü�̿�)");*/
		}
	}
	void init(){
		b = new JButton("�ڹ��� ��ư");
		ActionListener listener = new A1Handler();
		b.addActionListener(listener);
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
		A1 a1 = new A1();
		a1.init();
	}
}
