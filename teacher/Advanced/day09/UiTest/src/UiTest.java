package soo.ui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

class UiTest extends JFrame implements ActionListener { 
	JButton b1, b2, b3, b4;
	ImageIcon ii1, ii2, ii3, ii4;
    Container cp;
    JPanel p = new JPanel();

    void init(){
		loadImg();
		b1 = new JButton("동");
		b2 = new JButton("서");
		b3 = new JButton("남");
		b4 = new JButton("북");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		cp = getContentPane();
		cp.add(b1, BorderLayout.EAST);
		cp.add(b2, BorderLayout.WEST);
		cp.add(b3, BorderLayout.SOUTH);
		cp.add(b4, BorderLayout.NORTH);
        cp.add(p);
		p.setLayout(new GridLayout(2,2));
		p.add(new JButton(ii1));
		p.add(new JButton(ii2));
		p.add(new JButton(ii3));
		p.add(new JButton(ii4));

		setUI();
	}
	void setUI(){
		setTitle("JOptionPane Test");
		pack();
		setVisible(true);
		setLocation(500, 100); 

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void loadImg(){
		try{
			ii1 = new ImageIcon(ImageIO.read(new File("imgs/p_girl.png"))); 
			ii2 = new ImageIcon(ImageIO.read(new File("imgs/p_hello.png")));
			ii3 = new ImageIcon(ImageIO.read(new File("imgs/p_play.png")));
			ii4 = new ImageIcon(ImageIO.read(new File("imgs/p_study.png")));
		}catch(IOException ie){}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == b1){
			JOptionPane.showMessageDialog(null, "메세지 내용", "제목", JOptionPane.QUESTION_MESSAGE, ii1);
		}else if(obj == b2){
			int answer = JOptionPane.showConfirmDialog(
				null, "종료할까요?", "선택", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, ii2);
			if(answer == JOptionPane.YES_OPTION) System.exit(0);
		}else if(obj == b3){
			/*String msg = JOptionPane.showInputDialog(null, "오늘 기분 어때?", "질문", JOptionPane.QUESTION_MESSAGE);
			if(msg != null){
				msg = msg.trim();
				if(msg.length() != 0){
					JOptionPane.showMessageDialog(null, msg, "답변", JOptionPane.PLAIN_MESSAGE);
				}
			}*/

			Object[] selectionValues = {"Good", "Bad", "Normal"};
			Object objAs = JOptionPane.showInputDialog(
				null, "오늘 기분 어때?", "질문", JOptionPane.QUESTION_MESSAGE, ii3, selectionValues, selectionValues[0]);
			
			if(objAs != null){
				String msg = objAs.toString();
				String result = "";
				switch(msg){
				    case "Good": result = "좋아"; break;
			        case "Bad": result = "싫어"; break;
				    default: result = "그냥 그래";
				}
				JOptionPane.showMessageDialog(null, result, "답변", JOptionPane.PLAIN_MESSAGE);
			}
		}else{
			JLabel label = new JLabel(ii4);
			JOptionPane.showMessageDialog(null, label);
		}
	}
	public static void main(String[] args) {
		UiTest e = new UiTest();
		e.init();
	}
}
