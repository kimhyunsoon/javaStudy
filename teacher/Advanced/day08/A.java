import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class A extends JFrame implements ActionListener 
{
	ImageIcon ii1, ii2;
	JButton b;
	JLabel la;
	Container cp;

	void init(){
		setLayout(new GridLayout(1, 2));
		cp = getContentPane();
		loadImg();
		b = new JButton(ii1);
		b.addActionListener(this);
		la = new JLabel(ii1);
		//la.addActionListener(this);
		cp.add(b);
		cp.add(la);

		setUI();
	}
	void loadImg(){
		try{
			/*File f = new File("imgs/puppy.gif");
			BufferedImage bi = ImageIO.read(f);
			ii = new ImageIcon(bi);*/

			ii1 = new ImageIcon(ImageIO.read(new File("teacher/Advanced/day08/imgs/puppy.gif")));
			ii2 = new ImageIcon(ImageIO.read(new File("teacher/Advanced/day08/imgs/p_play.png")));
		}catch(IOException ie){}
	}
	void setUI(){
		setTitle("Image Test");
		setSize(300, 300);
		//pack(); //이미지 크기에 맞춰서 크기 생성
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	@Override 
	public void actionPerformed(ActionEvent ae){
		//int answer = JOptionPane.showConfirmDialog(null, "아침 먹었니?");
		int answer = JOptionPane.showConfirmDialog(null, 
			"재밌나요? 이미지", "질문", 
			JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, ii2);

        if(answer == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "네.. 먹었군요");
		}else if(answer == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "안 먹었군요ㅠㅠ");
		}else{ //CANCEL_OPTION
			JOptionPane.showMessageDialog(null, "엥? 무시하시넹");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new A().init();
	}
}
