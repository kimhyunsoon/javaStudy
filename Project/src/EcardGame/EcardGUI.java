package EcardGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EcardGUI extends JFrame implements ActionListener,KeyListener  {
	JFrame frame;
	
	ImageIcon img_king, img_slav, img_ctzn1, img_ctzn2, img_ctzn3, img_ctzn4, img_chatLog, img_msg, img_background, img_ready, img_exit, img_backCard; //기본 이미지
	ImageIcon change_img_king, change_img_slav, change_img_ctzn1, change_img_ctzn2, change_img_ctzn3, change_img_ctzn4, change_img_chatLog, change_img_msg,
				change_img_background, change_img_ready, change_img_exit, change_img_backCard; //크기 변경후 이미지
	Image i_king, i_slav, i_ctzn1, i_ctzn2, i_ctzn3, i_ctzn4, i_chatLog, i_msg, i_background, i_ready, i_exit, i_backCard; // 기본 아이콘 -> 이미지
	Image change_i_king, change_i_slav, change_i_ctzn1, change_i_ctzn2, change_i_ctzn3, change_i_ctzn4, change_i_chatLog, change_i_msg, change_i_background,
			change_i_ready, change_i_exit, change_i_backCard; // 이미지 크기 변경후 -> 아이콘으로 이동
	JButton btn_myKing, btn_mySlav, btn_myCtzn1, btn_myCtzn2, btn_myCtzn3, btn_myCtzn4;
	JButton btn_yourKing, btn_yourSlav, btn_yourCtzn1, btn_yourCtzn2, btn_yourCtzn3, btn_yourCtzn4;
	JButton btn_myBack, btn_yourBack;
	JButton btn_Ready, btn_exit;
	
	JTextArea text_chatLog;
	JTextField text_msg;
	
	JPanel background;
	
	EcardClient ec;
	public EcardGUI(EcardClient ec) throws IOException {
		newClass();
		this.ec = ec;
	}
	void newClass() throws IOException{
		loadImg();
		frame = new JFrame();
		
		background = new JPanel() {
			Image img_background = new ImageIcon(ImageIO.read(new File("img/BG.png"))).getImage();
			public void paint(Graphics g) {//그리는 함수
				//g.drawImage(background, 0, 0, null);//background를 그려줌	
				g.drawImage(img_background, 0, 0, null);
			}
		};
		
		btn_myKing = new JButton(change_img_king); btn_mySlav = new JButton(change_img_slav);
		btn_myCtzn1 = new JButton(change_img_ctzn1); btn_myCtzn2 = new JButton(change_img_ctzn2);
		btn_myCtzn3 = new JButton(change_img_ctzn3); btn_myCtzn4 = new JButton(change_img_ctzn4);
		
		btn_yourKing = new JButton(change_img_king); btn_yourSlav = new JButton(change_img_slav);
		btn_yourCtzn1 = new JButton(change_img_ctzn1); btn_yourCtzn2 = new JButton(change_img_ctzn2);
		btn_yourCtzn3 = new JButton(change_img_ctzn3); btn_yourCtzn4 = new JButton(change_img_ctzn4);
		
		btn_Ready = new JButton(change_img_ready); btn_exit = new JButton(change_img_exit);
		
		btn_myBack = new JButton(change_img_backCard); btn_yourBack = new JButton(change_img_backCard);
		
		text_chatLog = new JTextArea(); text_msg = new JTextField();
		
		init();
	}
	void init() {
		background.setBounds(0, 0, 1580, 960);
		btn_yourKing.setBounds(390, 80, 150, 238); btn_yourCtzn1.setBounds(550, 80, 150, 238);
		btn_yourCtzn2.setBounds(710, 80, 150, 238); btn_yourCtzn3.setBounds(870, 80, 150, 238);
		btn_yourCtzn4.setBounds(1030, 80, 150, 238); btn_yourSlav.setBounds(390, 80, 150, 238);
		
		
		
		btn_myKing.setVisible(false);   btn_mySlav.setVisible(false);
		
		btn_yourSlav.setVisible(false);   btn_yourKing.setVisible(false);
		
		
		btn_mySlav.setBounds(390, 640, 150, 238); btn_myCtzn1.setBounds(550, 640, 150, 238);
		btn_myCtzn2.setBounds(710, 640, 150, 238); btn_myCtzn3.setBounds(870, 640, 150, 238);
		btn_myCtzn4.setBounds(1030, 640, 150, 238);
		btn_myKing.setBounds(390, 640, 150, 238);
		
		btn_yourBack.setBounds(630, 328, 150, 238); btn_myBack.setBounds(790, 392, 150, 238);
		
		btn_Ready.setBounds(60, 660, 320, 90); btn_exit.setBounds(60, 780, 320, 90);
		
		text_chatLog.setBounds(1200, 318, 330, 510); text_msg.setBounds(1200, 828, 330, 50);
		
		frame.add(btn_myKing); frame.add(btn_myCtzn1); frame.add(btn_myCtzn2);
		frame.add(btn_myCtzn3); frame.add(btn_myCtzn4);
		
		frame.add(btn_yourSlav); frame.add(btn_yourCtzn1); frame.add(btn_yourCtzn2);
		frame.add(btn_yourCtzn3); frame.add(btn_yourCtzn4);
		
		frame.add(btn_myBack); frame.add(btn_yourBack);
		
		frame.add(btn_Ready); frame.add(btn_exit);
		
		frame.add(text_chatLog); frame.add(text_msg);
		
		//frame.add(lab_score);
		frame.add(background);
		
		btn_Ready.addActionListener(this);
		btn_myKing.addActionListener(this);
		btn_mySlav.addActionListener(this);
		text_msg.addKeyListener(this);
		
		setUi();
	}
	void setUi() {
		revalidate();
		repaint();
		frame.getContentPane().setLayout(null);
		frame.setSize(1580,960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	void loadImg() {
		try {
			img_king = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/king.png")));
			i_king = img_king.getImage();
			change_i_king = i_king.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_king = new ImageIcon(change_i_king);
			
			img_slav = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/slav.png")));
			i_slav = img_slav.getImage();
			change_i_slav = i_slav.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_slav = new ImageIcon(change_i_slav);
			
			img_ctzn1 = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/ctzn1.png")));
			i_ctzn1 = img_ctzn1.getImage();
			change_i_ctzn1 = i_ctzn1.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn1 = new ImageIcon(change_i_ctzn1);
			
			img_ctzn2 = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/ctzn2.png")));
			i_ctzn2 = img_ctzn2.getImage();
			change_i_ctzn2 = i_ctzn2.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn2 = new ImageIcon(change_i_ctzn2);
			
			img_ctzn3 = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/ctzn3.png")));
			i_ctzn3 = img_ctzn3.getImage();
			change_i_ctzn3 = i_ctzn3.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn3 = new ImageIcon(change_i_ctzn3);
			
			img_ctzn4 = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/ctzn4.png")));
			i_ctzn4 = img_ctzn4.getImage();
			change_i_ctzn4 = i_ctzn4.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn4 = new ImageIcon(change_i_ctzn4);
			
			/*img_chatLog = new ImageIcon(ImageIO.read(new File("")));
			i_chatLog = img_chatLog.getImage();
			change_i_chatLog = i_chatLog.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_chatLog = new ImageIcon(change_i_chatLog);
			
			img_msg = new ImageIcon(ImageIO.read(new File("")));
			i_msg = img_msg.getImage();
			change_i_msg = i_msg.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_msg = new ImageIcon(change_i_msg);
			
			img_background = new ImageIcon(ImageIO.read(new File("")));
			i_background = img_background.getImage();
			change_i_background = i_background.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_background = new ImageIcon(change_i_background);*/
			
			img_ready = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/read.png")));
			i_ready = img_ready.getImage();
			change_i_ready = i_ready.getScaledInstance(320, 90, Image.SCALE_SMOOTH);
			change_img_ready = new ImageIcon(change_i_ready);

			img_exit = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/exit.png")));
			i_exit = img_exit.getImage();
			change_i_exit = i_exit.getScaledInstance(320, 90, Image.SCALE_SMOOTH);
			change_img_exit = new ImageIcon(change_i_exit);
			
			img_backCard = new ImageIcon(ImageIO.read(new File("C:/KAEUN/gitStudy/Project/src/EcardGame/img/backCard.png")));
			i_backCard = img_backCard.getImage();
			change_i_backCard = i_backCard.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_backCard = new ImageIcon(change_i_backCard);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		try {
			new EcardGUI(ec);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_Ready) {
			ec.speakready();
			//new Test(this);
		}
		if(e.getSource()==btn_myKing) {
			ec.speakKing();;
		}
		if(e.getSource()==btn_mySlav) {
			ec.speakSlav();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			ec.speakchat();
			text_msg.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class Speak1 implements Runnable{
	EcardClient ec;
	
	Speak1(EcardClient ec){
		this.ec = ec;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ec.speak();
	}
	
}
