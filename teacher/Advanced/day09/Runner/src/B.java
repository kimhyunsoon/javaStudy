package soo.ani;

import java.awt.*;
import javax.swing.*;

class B extends JFrame
{
	Container cp;
	ImageIcon ii;
	JLabel laImg;
	JLabel laMsg;

	void init(){
		cp = getContentPane();
		
		ii  = new ImageIcon(getClass().getResource("imgs/move.gif"));
		laImg = new JLabel(ii);
		cp.add(laImg);

		laMsg = new JLabel();
		laMsg.setText("    ������ �޸��� �͸��� ���δ� �Ƴ�");
		Font f = new Font("����", Font.BOLD, 20);
		laMsg.setFont(f);
		cp.add(laMsg, BorderLayout.SOUTH);

		setUI();
	}
	void setUI(){
		setTitle("�����̴� �̹��� �׽���");
		//setSize(400, 400);
		pack(); 
		setVisible(true);
		//setLocation(200, 100);
		setLocationRelativeTo(null); //�ػ󵵿� ������� ȭ���� ����� ����� 

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	public static void main(String[] args) 
	{
		new B().init();
	}
}
