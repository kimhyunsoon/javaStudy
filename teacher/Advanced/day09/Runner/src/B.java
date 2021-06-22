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
		laMsg.setText("    열심히 달리는 것만이 전부는 아냐");
		Font f = new Font("굴림", Font.BOLD, 20);
		laMsg.setFont(f);
		cp.add(laMsg, BorderLayout.SOUTH);

		setUI();
	}
	void setUI(){
		setTitle("움직이는 이미지 테스팅");
		//setSize(400, 400);
		pack(); 
		setVisible(true);
		//setLocation(200, 100);
		setLocationRelativeTo(null); //해상도와 관계없이 화면의 가운데에 띄워줌 

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	public static void main(String[] args) 
	{
		new B().init();
	}
}
