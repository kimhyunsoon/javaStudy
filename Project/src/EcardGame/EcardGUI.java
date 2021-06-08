package EcardGame;

import java.awt.Graphics;
import EcardGame.Login;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EcardGUI extends JFrame implements ActionListener {
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
	String playerName1, playerScore, playerIdx,playerName2; 
	
	int port = 4004;
	public static LinkedList<String> playerName = new LinkedList<String>();
	String path = GameServer.class.getResource("").getPath();
	
	public EcardGUI() {
		loadImg();
		frame = new JFrame();
		try {
			background = new JPanel() {
				Image img_background = new ImageIcon(ImageIO.read(new File(path+"img/BG.png"))).getImage();
				public void paint(Graphics g) {//그리는 함수
					g.drawImage(img_background, 0, 0, null);
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btn_myKing = new JButton(change_img_king); btn_mySlav = new JButton(change_img_slav);
		btn_myCtzn1 = new JButton(change_img_ctzn1); btn_myCtzn2 = new JButton(change_img_ctzn2);
		btn_myCtzn3 = new JButton(change_img_ctzn3); btn_myCtzn4 = new JButton(change_img_ctzn4);
		
		btn_yourKing = new JButton(change_img_king); btn_yourSlav = new JButton(change_img_slav);
		btn_yourCtzn1 = new JButton(change_img_ctzn1); btn_yourCtzn2 = new JButton(change_img_ctzn2);
		btn_yourCtzn3 = new JButton(change_img_ctzn3); btn_yourCtzn4 = new JButton(change_img_ctzn4);
		
		btn_Ready = new JButton(change_img_ready); btn_exit = new JButton(change_img_exit);
		
		btn_myBack = new JButton(change_img_backCard); btn_yourBack = new JButton(change_img_backCard);
		
		text_chatLog = new JTextArea(); text_msg = new JTextField();
		
		background.setBounds(0, 0, 1580, 960);
		
		btn_yourKing.setBounds(390, 80, 150, 238); btn_yourCtzn1.setBounds(550, 80, 150, 238);
		btn_yourCtzn2.setBounds(710, 80, 150, 238); btn_yourCtzn3.setBounds(870, 80, 150, 238);
		btn_yourCtzn4.setBounds(1030, 80, 150, 238); btn_yourSlav.setBounds(390, 80, 150, 238);
		

		
		
		btn_myKing.setBounds(390, 640, 150, 238); btn_myCtzn1.setBounds(550, 640, 150, 238);
		btn_myCtzn2.setBounds(710, 640, 150, 238); btn_myCtzn3.setBounds(870, 640, 150, 238);
		btn_myCtzn4.setBounds(1030, 640, 150, 238); btn_mySlav.setBounds(390, 640, 150, 238);
		btn_myKing.setVisible(false);   btn_mySlav.setVisible(false);
		btn_yourKing.setVisible(false);   btn_yourSlav.setVisible(false);
		
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
		
		btn_exit.addActionListener(this);
		//btn_myKing.addActionListener(this);
		//btn_mySlav.addActionListener(this);
		
		
		revalidate();
		repaint();
		frame.getContentPane().setLayout(null);
		frame.setSize(1580,960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		startChat();
	}
	void newClass() {
		
		
		init();
	}
	void init() {
		
	}
	void setUi() {
		
	}

	void loadImg() {
		try {
			img_king = new ImageIcon(ImageIO.read(new File(path+"img/king.png")));
			i_king = img_king.getImage();
			change_i_king = i_king.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_king = new ImageIcon(change_i_king);
			
			img_slav = new ImageIcon(ImageIO.read(new File(path+"img/slav.png")));
			i_slav = img_slav.getImage();
			change_i_slav = i_slav.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_slav = new ImageIcon(change_i_slav);
			
			img_ctzn1 = new ImageIcon(ImageIO.read(new File(path+"img/ctzn1.png")));
			i_ctzn1 = img_ctzn1.getImage();
			change_i_ctzn1 = i_ctzn1.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn1 = new ImageIcon(change_i_ctzn1);
			
			img_ctzn2 = new ImageIcon(ImageIO.read(new File(path+"img/ctzn2.png")));
			i_ctzn2 = img_ctzn2.getImage();
			change_i_ctzn2 = i_ctzn2.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn2 = new ImageIcon(change_i_ctzn2);
			
			img_ctzn3 = new ImageIcon(ImageIO.read(new File(path+"img/ctzn3.png")));
			i_ctzn3 = img_ctzn3.getImage();
			change_i_ctzn3 = i_ctzn3.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_ctzn3 = new ImageIcon(change_i_ctzn3);
			
			img_ctzn4 = new ImageIcon(ImageIO.read(new File(path+"img/ctzn4.png")));
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
			
			img_ready = new ImageIcon(ImageIO.read(new File(path+"img/read.png")));
			i_ready = img_ready.getImage();
			change_i_ready = i_ready.getScaledInstance(320, 90, Image.SCALE_SMOOTH);
			change_img_ready = new ImageIcon(change_i_ready);

			img_exit = new ImageIcon(ImageIO.read(new File(path+"img/exit.png")));
			i_exit = img_exit.getImage();
			change_i_exit = i_exit.getScaledInstance(320, 90, Image.SCALE_SMOOTH);
			change_img_exit = new ImageIcon(change_i_exit);
			
			img_backCard = new ImageIcon(ImageIO.read(new File(path+"img/backCard.png")));
			i_backCard = img_backCard.getImage();
			change_i_backCard = i_backCard.getScaledInstance(150, 238, Image.SCALE_SMOOTH);
			change_img_backCard = new ImageIcon(change_i_backCard);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if(e.getSource()==btn_exit) {
			System.exit(0);
		}
		if(e.getSource()==btn_myKing) {
			
		}
		if(e.getSource()==btn_mySlav) {
			
		}
	}
// 채팅 소켓 생성
	public void startChat() {
		
		String nickName = Login.nickName; // Login 에서 nickName 를 받아옴.
		String ip = Login.IP1; // Login 에서 ip를 받아옴
		
		try {
			Socket s = new Socket(ip,port); //소켓입장
			Sender sender = new Sender(s, nickName); //Sender에 소켓과 nickName 전송
			Listener listener = new Listener(s, nickName); // Listener에 소켓 전송 
			new Thread(sender).start(); // Sender 쓰레드 시작.
			new Thread(listener).start(); //Listener 쓰레드 시작.
			text_msg.addKeyListener(new Sender(s,nickName));
			btn_exit.addActionListener(this);

		}catch(UnknownHostException ue) {	
		}catch(IOException ie) {}
	}
// 내부 클래스 수신
	class Listener extends Thread{
		Socket s;
		InputStream is;
		DataInputStream dis;
		BufferedReader br;
		String nickName;
		String firstName;
		String lastName;
		//HashMap<Socket, String> map = new HashMap<Socket, String>();
		public Listener(Socket s,String nickName) {
			this.s = s;
			this.nickName = nickName;

			try {
					dis = new DataInputStream(this.s.getInputStream());
					is = s.getInputStream();
					br = new BufferedReader(new InputStreamReader(is));
			}catch(IOException ie) {}
		}
		public void run() {
			while(dis != null) {
				try {
					String pName = dis.readUTF(); 
				
					if(pName.startsWith("//Kings") && pName.indexOf(playerName.get(0)) != -1) {
						System.out.println("내 ID확인: "playerName.get(0));
						System.out.println("황제를 셋팅합니다");
					}
					else if(pName.startsWith("//Slavs") && pName.indexOf(playerName.get(0)) != -1) {
						//System.out.println("내 ID확인: "playerName.get(0));
						System.out.println("노예를 셋팅합니다");
					}

					while(true){
						String msg = dis.readUTF(); //클라이언트로부터 수신되는 메세지 읽음
						filter(msg); //메세지or게임진행 브로드캐스트
					}

				}catch(IOException ie) {}
			}
		}

		void filter(String msg){
			String temp = msg.substring(0,7);
			if((msg.startsWith("//Start"))) {
						
			}
			if((msg.startsWith("//CList"))) {
				//playerName1 = msg.substring(7, msg.indexOf(" "));
				//playerScore = msg.substring(msg.indexOf(" ") + 1);
			}
			if((msg.startsWith("//Wcard"))) {
				
			}
			if((temp.equals("//Chat "))) {
				System.out.println("내용 입력했듬");
				System.out.println(msg);
				//text_chatLog.append(playerName1+">>"+msg+"\n");
			}else {
				text_chatLog.append(msg+"\n");
			}
		}

		void king(String msg, String firstName) {
				playerName1 = msg.substring(7);
				btn_myKing.setVisible(true);
				btn_yourSlav.setVisible(true);
		}
		void slav(String msg, String lastName) {
				System.out.println("아아아아ㅏ오냐아아아앙");
				playerName2 = msg.substring(7);
				btn_mySlav.setVisible(true);
				btn_yourKing.setVisible(true);
		}
	}
	class Sender extends Thread implements KeyListener, ActionListener{
		DataOutputStream dos;
		Socket s;
		String nickName;
		Sender(Socket s, String nickName) {
			this.s = s;
			try {
				dos = new DataOutputStream(this.s.getOutputStream());
				this.nickName = nickName;
				playerName.add(nickName);
			}catch(IOException ie) {}
		}
		public void run() {
			try {
				dos.writeUTF(nickName);
			}catch(IOException ie) {}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btn_Ready) {
				try {
					dos.writeUTF("//Chat "+"["+nickName+"님 준비 완료 !]");
					dos.flush();
					dos.writeUTF("//Ready");
					dos.flush();
					btn_Ready.setEnabled(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(e.getSource()==btn_myKing) {
				try {
					dos.writeUTF("//Timer"+"//king"+nickName);
					dos.flush();
				} catch (IOException e1) {}
			}else if(e.getSource()==btn_mySlav) {
				try {
					dos.writeUTF("//Timer"+"//Slav"+nickName);
					dos.flush();
				} catch (IOException e1) {}
			}else if(e.getSource()==btn_myCtzn1) {
				try {
					dos.writeUTF("//Timer"+"//Ctzn"+nickName);
					dos.flush();
				}catch(IOException ie) {}
			}else if(e.getSource()==btn_myCtzn2) {
				try {
					dos.writeUTF("//Timer"+"//Ctzn"+nickName);
					dos.flush();
				}catch(IOException ie) {}
			}else if(e.getSource()==btn_myCtzn3) {
				try {
					dos.writeUTF("//Timer"+"//Ctzn"+nickName);
					dos.flush();
				}catch(IOException ie) {}
			}else if(e.getSource()==btn_myCtzn4) {
				try {
					dos.writeUTF("//Timer"+"//Ctzn"+nickName);
					dos.flush();
				}catch(IOException ie) {}
			}else if(e.getSource()==btn_exit) {
				System.exit(0);
			}
		}

		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				
				String chat = text_msg.getText();
				System.out.println(chat+"afsfsa");
				text_msg.setText("");
				try {
					dos.writeUTF("//Chat "+nickName+" : "+ chat);
					dos.flush();
				}catch(IOException ie) {}
			}
		}
	}
}











