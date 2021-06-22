package ecardGame;

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	public static String IP, nickName;
	public String msg_logon="";
	
	//GUI관련
	Container cp;
	Font f = new Font("맑은 고딕", Font.BOLD, 20);
	JPanel jpcen, background;
	JLabel laImg;
	JLabel label_id, label_ip;
	JTextField tf_id, tf_ip;
	JButton start, button_ip;
	JFrame frame;
	ImageIcon i1;
	
	public Login(){
		try {
			background = new JPanel() {
				Image img = new ImageIcon(ImageIO.read(new File("image/login_BG.png"))).getImage();
				public void paint(Graphics g) {
					g.drawImage(img, 0, 0,null);
				}
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
		init();

		
	}
	
	public void init() {
		background.setBounds(0, 0, 500, 550);
		frame = new JFrame();
		laImg = new JLabel(i1);
		laImg.setBounds(0, 0, 500, 550);
		
		jpcen = new JPanel();
		
		//id
		tf_id = new JTextField();
		tf_id.setBounds(95, 180, 306, 63);
		tf_id.setFont(f);
		tf_id.setText("");
		frame.add(tf_id);
		
		//ip
		tf_ip = new JTextField("127.0.0.1");
		tf_ip.setBounds(95, 290, 306, 63);
		tf_ip.setFont(f);
		tf_ip.setEnabled(true);
		frame.add(tf_ip);
		
		//버튼
		button_ip = new JButton(new ImageIcon("image/getiP.png"));
		button_ip.setBounds(300, 365, 83, 40);
		frame.add(button_ip);
		button_ip.addActionListener(this);
		
		start = new JButton(new ImageIcon("image/loginBtn.png"));
		start.addActionListener(this);
		frame.add(start);
		frame.add(background);
		frame.add(laImg);
		setUi();
		//sound();
	
		start.setBounds(95, 440, 300, 60);
		
		
		
		//cp.add(background);
		
	}
	
	void setUi() {
		revalidate();
		repaint();
		frame.getContentPane().setLayout(null);
		frame.setSize(500,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		tf_id.requestFocus();
		if(obj == start) {//start 버튼 눌렀을때
			if(tf_id.getText().equals("") || tf_ip.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ID를 입력해주세요", "에러메시지", JOptionPane.ERROR_MESSAGE);
			}else if(tf_ip.getText().equals("")){
				JOptionPane.showMessageDialog(null, "IP를 입력해주세요", "에러메시지", JOptionPane.ERROR_MESSAGE);
			}else if(tf_id.getText().trim().length() > 7) {
				JOptionPane.showMessageDialog(null, "ID는 7자 내외로 입력해주세요", "에러메시지", JOptionPane.ERROR_MESSAGE);
				tf_id.setText("");
			}else {
				nickName = tf_id.getText().trim();
				String temp = tf_ip.getText();
				if(temp.matches("(^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$)")){
					IP = temp;
					JOptionPane.showMessageDialog(null, "로그인 성공!", "ECARD GAME LOGIN", JOptionPane.INFORMATION_MESSAGE);
					start.setEnabled(false);
					start.setBorderPainted(false); 
					start.setFocusPainted(false); 
					start.setContentAreaFilled(false);
					frame.setVisible(false);
					tf_id.setEnabled(false);
					setVisible(false);
					ClientThread ct = new ClientThread();
				}else{
					JOptionPane.showMessageDialog(null, "IP 주소를 정확하게 입력해 주세요! ", "ERROR!", JOptionPane.WARNING_MESSAGE);
				}
				// IP1 = tf_ip.getText().trim();
				// start.setBorderPainted(false); 
				// start.setFocusPainted(false); 
				// start.setContentAreaFilled(false);
				// frame.setVisible(false);

			}
		} 

		
	}
	
	
	void sound() {
		File f = new File("sound/bgm.wav");
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			Clip c = AudioSystem.getClip();
			c.open(ais);
			c.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login();


	}
}
