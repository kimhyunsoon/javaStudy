package ecardGame;

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
//import java.net.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	public static String IP, nickName;
	public String msg_logon="";
	
	//GUI����
	Container cp;
	Font f = new Font("���� ���", Font.BOLD, 20);
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
		tf_id.setBounds(110, 183, 306, 63);
		tf_id.setFont(f);
		tf_id.setForeground(Color.WHITE);
		tf_id.setText("");
		tf_id.setOpaque(false);
		tf_id.setBorder(null);
		frame.add(tf_id);
		
		//ip
		tf_ip = new JTextField("127.0.0.1");
		tf_ip.setBounds(110, 285, 306, 63);
		tf_ip.setFont(f);
		tf_ip.setForeground(Color.WHITE);
		tf_ip.setEnabled(true);
		tf_ip.setOpaque(false);
		tf_ip.setBorder(null);
		frame.add(tf_ip);
		
		//��ư
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
		if(obj == start) {//start ��ư ��������
			if(tf_id.getText().equals("") || tf_ip.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ID�� �Է����ּ���", "�����޽���", JOptionPane.ERROR_MESSAGE);
			}else if(tf_ip.getText().equals("")){
				JOptionPane.showMessageDialog(null, "IP�� �Է����ּ���", "�����޽���", JOptionPane.ERROR_MESSAGE);
			}else if(tf_id.getText().trim().length() > 7) {
				JOptionPane.showMessageDialog(null, "ID�� 7�� ���ܷ� �Է����ּ���", "�����޽���", JOptionPane.ERROR_MESSAGE);
				tf_id.setText("");
			}else {
				nickName = tf_id.getText().trim();
				String temp = tf_ip.getText();
				if(temp.matches("(^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$)")){
					IP = temp;
					JOptionPane.showMessageDialog(null, "�α��� ����!", "ECARD GAME LOGIN", JOptionPane.INFORMATION_MESSAGE);
					start.setEnabled(false);
					start.setBorderPainted(false); 
					start.setFocusPainted(false); 
					start.setContentAreaFilled(false);
					frame.setVisible(false);
					tf_id.setEnabled(false);
					setVisible(false);
					EcardGUI eg = new EcardGUI();
				}else{
					JOptionPane.showMessageDialog(null, "IP �ּҸ� ��Ȯ�ϰ� �Է��� �ּ���! ", "ERROR!", JOptionPane.WARNING_MESSAGE);
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
