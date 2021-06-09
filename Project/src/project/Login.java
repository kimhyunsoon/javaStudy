package project;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import javax.swing.text.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.border.*;
import javax.sound.sampled.*; 
import javax.imageio.*;
import java.net.InetAddress;
import java.net.UnknownHostException;



class Login extends JFrame implements ActionListener {
	Container cp;
	Font f = new Font("맑은 고딕", Font.BOLD, 20);
	JPanel jpcen, background;
	JLabel label_id, label_ip;
	JTextField tf_id, tf_ip;
	JButton start, button_ip;
	String ipcheak;
	JFrame frame;
	ImageIcon i1;
	JLabel laImg;
	String path = GameServer.class.getResource("").getPath();
	public static String IP, ID;
	public static String nickName, IP1;
	Login() {
		try {
			background = new JPanel() {
				Image img = new ImageIcon(ImageIO.read(new File(path + "image/login_BG.png"))).getImage();
				public void paint(Graphics g) {
					g.drawImage(img, 0, 0,null);
				}
			};
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	void init() {
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
		tf_ip = new JTextField(" IP버튼을 누르세요");
		tf_ip.setBounds(95, 290, 306, 63);
		tf_ip.setFont(f);
		tf_ip.setEnabled(false);
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
		Ipcheak();
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

	//ip 가져오기
	void Ipcheak() {
		InetAddress local; 
		try { 
		local = InetAddress.getLocalHost(); 
		 ipcheak = local.getHostAddress(); 
		}catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == start) {
			if(tf_id.getText().equals("") || tf_ip.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ID와  IP를 입력주세요", "에러메시지", JOptionPane.ERROR_MESSAGE);
			}else if(tf_id.getText().trim().length() > 7) {
				JOptionPane.showMessageDialog(null, "ID는 7자 내외로 입력해주세요", "에러메시지", JOptionPane.ERROR_MESSAGE);
				tf_id.setText("");
			}
			else {
				nickName = tf_id.getText().trim();
				IP1 = tf_ip.getText().trim();
				start.setBorderPainted(false); 
				start.setFocusPainted(false); 
				start.setContentAreaFilled(false);
				frame.setVisible(false);
				EcardGUI eg = new EcardGUI();
			}
		}
		
		if(obj == button_ip) {
			JOptionPane.showMessageDialog(null, "귀하의 IP \n"+ipcheak, "ip 확인창", JOptionPane.INFORMATION_MESSAGE);
			tf_ip.setText(ipcheak);
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
		Login lo = new Login();
		lo.init();
	}
}
