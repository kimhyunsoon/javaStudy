package ecardGame;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import java.net.*;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

public class EcardGUI extends JFrame{

    //GUI 관련
    Font font;
	JFrame frame;
    static JTextArea text_chatLog;
	static JTextField text_msg;
	static JScrollPane scroll;
    JPanel background;
    static JLabel jTimer,tenTimer;
	static JLabel jSlave, jKing;
	static JLabel yLabel, mLabel;
	static JLabel btn_myBack, btn_yourBack;
	static JLabel laftKing, laftSlav, laftCtzn;
	static JLabel rightKing, rightSlav, rightCtzn;
	static JLabel yourScore1, yourScore2, myScore1, myScore2;
	ImageIcon img_king, img_slav, img_ctzn1, img_ctzn2, img_ctzn3, img_ctzn4, img_background, img_ready, img_exit, img_backCard, slaveSet, kingSet;
	
	static JButton btn_myKing, btn_mySlav, btn_myCtzn1, btn_myCtzn2, btn_myCtzn3, btn_myCtzn4;
	static JButton btn_Ready, btn_exit;

    //지우면 안됨
	private static final long serialVersionUID = 1L;
    public static ClientThread ccThread; //ClientThread 객체
    public static EcardGUI ecardGUI; //자기 자신의 객체

	
	
	EcardGUI() {
		loadImg();
		setPanel();

		ClientThread ccThread= new ClientThread();
		ccThread.startChat();
	}
	static void dialog(){
		JOptionPane.showConfirmDialog(null, "카드를 변경합니다.", "EcardGame", JOptionPane.PLAIN_MESSAGE);
	}

	static void gameEnd(){
		int answer = JOptionPane.showConfirmDialog(null, "게임이 종료되었습니다. \n 점수를 확인해 주세요!", "EcardGame", JOptionPane.PLAIN_MESSAGE);


		if(answer ==JOptionPane.YES_OPTION){
			String my ="";
			String your ="";
			text_chatLog.append("게임이 종료되었습니다. \n 점수를 확인해 주세요!");
			if(myScore1.isVisible()){
				my= myScore1.getText();
				your= yourScore1.getText();
			}else if(myScore2.isVisible()){
				my= myScore2.getText();
				your= yourScore2.getText();
			}
	

			if(Integer.parseInt(my)>Integer.parseInt(your)){
				System.out.println("당신이 이겼어!!");
			}else if(Integer.parseInt(my)<Integer.parseInt(your)){
				System.out.println("당신이 졌어!!");
			}else if(Integer.parseInt(my)==Integer.parseInt(your)){
				System.out.println("무승부로 끝났습니다");
			}



		}
	}

	void loadImg() {
		try {
			img_king = new ImageIcon(ImageIO.read(new File("img/king.png")));
			img_slav = new ImageIcon(ImageIO.read(new File("img/slav.png")));
			img_ctzn1 = new ImageIcon(ImageIO.read(new File("img/ctzn1.png")));
			img_ctzn2 = new ImageIcon(ImageIO.read(new File("img/ctzn2.png")));
			img_ctzn3 = new ImageIcon(ImageIO.read(new File("img/ctzn3.png")));
			img_ctzn4 = new ImageIcon(ImageIO.read(new File("img/ctzn4.png")));
			img_ready = new ImageIcon(ImageIO.read(new File("img/ready.png")));
			img_exit = new ImageIcon(ImageIO.read(new File("img/exit.png")));
			img_backCard = new ImageIcon(ImageIO.read(new File("img/backCard.png")));
			slaveSet = new ImageIcon(ImageIO.read(new File("img/slaveSet.png")));
			kingSet = new ImageIcon(ImageIO.read(new File("img/kingSet.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setPanel(){

        frame = new JFrame();
        font = new Font("고딕체", Font.PLAIN, 70);
		try {
			background = new JPanel() {
				private static final long serialVersionUID = 1L;
				Image img_background = new ImageIcon(ImageIO.read(new File("img/BG.png"))).getImage();
				public void paint(Graphics g) {//그리는 함수
					g.drawImage(img_background, 0, 0, null);
				}
			};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jTimer = new JLabel("30");
		jTimer.setFont(font);
		jTimer.setLayout(null);
		jTimer.setBounds(1300, 120, 150, 150);

		jKing = new JLabel(kingSet);
		jKing.setBounds(390,80,790,238);
		jSlave = new JLabel(slaveSet);
		jSlave.setBounds(390,80,790,238);

		Color color = new Color(0xf4ead0);
		
		yLabel = new JLabel("[ 상대방 점수 ]");
		yLabel.setForeground(color);
		yLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		yLabel.setBounds(155, 270, 300, 150);
		mLabel = new JLabel("[ 내 점수 ]");
		mLabel.setForeground(color);
		mLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mLabel.setBounds(170, 430, 300, 150);


		yourScore1 = new JLabel("0");
		yourScore1.setForeground(color);
		yourScore1.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		yourScore1.setBounds(200, 325, 150, 150);
		yourScore2 = new JLabel("0");
		yourScore2.setForeground(color);
		yourScore2.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		yourScore2.setBounds(200, 325, 150, 150);
		myScore1 = new JLabel("0");
		myScore1.setForeground(color);
		myScore1.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		myScore1.setBounds(200, 485, 150, 150);
		myScore2 = new JLabel("0");
		myScore2.setForeground(color);
		myScore2.setFont(new Font("맑은 고딕", Font.BOLD, 70));
		myScore2.setBounds(200, 485, 150, 150);
		btn_myKing = new JButton(img_king); 
		btn_mySlav = new JButton(img_slav);
		btn_myCtzn1 = new JButton(img_ctzn1); 
		btn_myCtzn2 = new JButton(img_ctzn2);
		btn_myCtzn3 = new JButton(img_ctzn3); 
		btn_myCtzn4 = new JButton(img_ctzn4);
		
		btn_Ready = new JButton(img_ready); 
		btn_exit = new JButton(img_exit);
		btn_myBack = new JLabel(img_backCard); 
		btn_yourBack = new JLabel(img_backCard);
		laftKing = new JLabel(img_king);
		laftSlav = new JLabel(img_slav);
		laftCtzn = new JLabel(img_ctzn1);
		rightKing = new JLabel(img_king);
		rightSlav = new JLabel(img_slav);
		rightCtzn = new JLabel(img_ctzn1);
        
        text_chatLog = new JTextArea(); 
		text_msg = new JTextField();
		// text_msg.setBorder(null);
		scroll = new JScrollPane(text_chatLog);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// scroll.setBorder(null);
		background.setBounds(0, 0, 1580, 960);
		
		
		btn_myKing.setBounds(390, 640, 150, 238); 
		btn_myCtzn1.setBounds(550, 640, 150, 238);
		btn_myCtzn2.setBounds(710, 640, 150, 238); 
		btn_myCtzn3.setBounds(870, 640, 150, 238);
		btn_myCtzn4.setBounds(1030, 640, 150, 238); 
		btn_mySlav.setBounds(390, 640, 150, 238);
		btn_yourBack.setBounds(610, 328, 150, 238); 
		laftKing.setBounds(610, 328, 150, 238); 
		laftSlav.setBounds(610, 328, 150, 238); 
		laftCtzn.setBounds(610, 328, 150, 238); 
		btn_myBack.setBounds(810, 392, 150, 238);
		rightKing.setBounds(810, 392, 150, 238);
		rightSlav.setBounds(810, 392, 150, 238);
		rightCtzn.setBounds(810, 392, 150, 238);
		btn_Ready.setBounds(60, 660, 320, 90); 
		btn_exit.setBounds(60, 780, 320, 90);
		
		scroll.setBounds(1200, 318, 300, 510);

		text_msg.setBounds(1200, 828, 300, 50);
		
		frame.add(btn_myKing); frame.add(btn_myCtzn1); frame.add(btn_myCtzn2);
		frame.add(btn_myCtzn3); frame.add(btn_myCtzn4); frame.add(btn_mySlav);

		frame.add(jKing); frame.add(jSlave);
		frame.add(yLabel); frame.add(mLabel);
		frame.add(yourScore1); frame.add(yourScore2);
		frame.add(myScore1); frame.add(myScore2);
		
		frame.add(btn_myBack); frame.add(btn_yourBack);
		frame.add(laftKing); frame.add(laftSlav); frame.add(laftCtzn);
		frame.add(rightKing); frame.add(rightSlav); frame.add(rightCtzn);
		frame.add(btn_Ready); frame.add(btn_exit);
		frame.add(scroll);
		//frame.add(text_chatLog); 
		frame.add(text_msg);
		frame.add(jTimer);
		frame.add(background);

		revalidate();
		repaint();
		frame.setTitle("Ecard Game");
		// frame.setLocationRelativeTo(null);	
		frame.getContentPane().setLayout(null);
		frame.setSize(1580,960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
    }

}



	// @Override
	// public void actionPerformed(ActionEvent e) {

	// 	// TODO Auto-generated method stub
	// 	if(e.getSource()==btn_exit) {
	// 		System.exit(0);
	// 	}
	// 	if(e.getSource()==btn_myKing) {
			
	// 	}
	// 	if(e.getSource()==btn_mySlav) {
			
	// 	}
	// }
// 채팅 소켓 생성
	// public void startChat() {
		
	// 	String nickName = Login.nickName; // Login 에서 nickName 를 받아옴.
	// 	String ip = Login.IP1; // Login 에서 ip를 받아옴
		
	// 	try {
	// 		Socket s = new Socket(ip,port); //소켓입장
	// 		Sender sender = new Sender(s, nickName); //Sender에 소켓과 nickName 전송
	// 		Listener listener = new Listener(s, nickName); // Listener에 소켓 전송 
	// 		new Thread(sender).start(); // Sender 쓰레드 시작.
	// 		new Thread(listener).start(); //Listener 쓰레드 시작.
	// 		text_msg.addKeyListener(new Sender(s,nickName));
	// 		btn_exit.addActionListener(new Sender(s,nickName));
	// 		btn_Ready.addActionListener(new Sender(s,nickName));
	// 		btn_myKing.addActionListener(new Sender(s,nickName));
	// 		btn_mySlav.addActionListener(new Sender(s,nickName));
	// 		btn_myCtzn1.addActionListener(new Sender(s,nickName));
	// 		btn_myCtzn2.addActionListener(new Sender(s,nickName));
	// 		btn_myCtzn3.addActionListener(new Sender(s,nickName));
	// 		btn_myCtzn4.addActionListener(new Sender(s,nickName));

	// 	}catch(UnknownHostException ue) {	
	// 	}catch(IOException ie) {}
	// }
// 내부 클래스 수신
// 	class Listener extends Thread{
// 		Socket s;
// 		InputStream is;
// 		DataInputStream dis;
// 		DataOutputStream dos;
// 		BufferedReader br;
// 		String nickName;
// 		String firstName;
// 		String lastName;
		
// 		public Listener(Socket s,String nickName) {
// 			this.s = s;
// 			this.nickName = nickName;
			
// 			try {
// 					dis = new DataInputStream(this.s.getInputStream());
// 					dos = new DataOutputStream(this.s.getOutputStream());
// 					is = s.getInputStream();
// 					br = new BufferedReader(new InputStreamReader(is));
// 			}catch(IOException ie) {}
// 		}
// 		public void setTimer() {
// 	    	int i=5;
// 	        while(i >= 0)
// 	        {              
// 	            try {
// 	                System.out.println(i);       
// 	                jTimer.setText(i+"Sec");
// 	                Thread.sleep(1000);
// 	                if(i == 0) {
// 	                	break;
// 	                }
	                
// 	            } catch (InterruptedException e) {
// 	                e.printStackTrace();
// 	            }
// 	            i--;     
// 	        }
// 	        jTimer.setVisible(false);
//         	tenTimer.setVisible(true);
//         	new TimeOut(i,s,nickName);
//         	Runnable r2 = new TimeOut(i,s,nickName);
//         	Thread t2 = new Thread(r2);
//         	t2.start();
// 	    }
// 		public void tenTimer() {
// 			int i=3;
// 	        while(i >= 0)
// 	        {              
// 	            try {
// 	                System.out.println(i);       
// 	                tenTimer.setText(i+"Sec");
// 	                Thread.sleep(1000);
// 	                if(i == 0) {
// 	                	btn_Ready.setEnabled(true);
// 	                	break;
// 	                }
	                
// 	            } catch (InterruptedException e) {
// 	                e.printStackTrace();
// 	            }
// 	            i--;     
// 	        }
	        
// 		}
// 		public void run() {

// 			while(dis != null) {
// 				try {
// 					String msg = dis.readUTF(); 	
// 					//String temp = msg.substring(0,7);
// 					if(msg.startsWith("//King ") && msg.indexOf(playerName.get(0)) != -1) {
// 						//playerName1 = msg.substring(7);
// 						btn_yourKing.setVisible(false);
// 						btn_mySlav.setVisible(false);
// 						btn_myBack.setVisible(false);
// 						btn_yourBack.setVisible(false);
// 					}
// 					if(msg.startsWith("//Slav ") && msg.indexOf(playerName.get(0)) != -1) {
// 						//System.out.println(nickName);
// 						nickName = msg.substring(7);
// 						btn_myKing.setVisible(false);
// 						btn_yourSlav.setVisible(false);
// 						btn_myBack.setVisible(false);
// 						btn_yourBack.setVisible(false);
// 					}else if((msg.substring(0,7).equals("//Start"))) {
// 						jTimer.setVisible(true);
// 						tenTimer.setVisible(false);
// 						Runnable r2 = new TimeCount(this);
// 						Thread t2 = new Thread(r2);
// 						t2.start();
// 					}else if((msg.startsWith("//CList"))) {
// 						//playerName1 = msg.substring(7, msg.indexOf(" "));
// 						//playerScore = msg.substring(msg.indexOf(" ") + 1);
// 					}else if((msg.startsWith("//Wcard"))) {
						
// 					}else if((msg.substring(0,7).equals("//Chat "))) {
// 						System.out.println(msg);
// 						//text_chatLog.append(playerName1+">>"+msg+"\n");
// 					}else if(msg.equals("//King")) {
						
// 					}else if(msg.substring(0,7).equals("//Back ") && msg.indexOf(playerName.get(0)) != 1) {
// 						System.out.println(playerName);
// 						btn_yourBack.setVisible(true);
// 					}else if(msg.substring(0,7).equals("//TimeO")) {
// 						System.out.println(msg.substring(0,7));
// 						text_chatLog.append(msg.substring(7));
// 					}else if(msg.substring(0,7).equals("//Draw ")) {
// 						text_chatLog.append(msg.substring(7)+"\n");
// 						text_chatLog.append("10초 뒤에 다시 시작하겠습니다.");
// 						Runnable r3 = new TenTimeCount(this);                                      
// 						Thread t3 = new Thread(r3);
// 						t3.start();
// 					}else if(msg.substring(0,8).equals("//Round2")) {
// 						String name1 =""; String name2 ="";
// 						if(msg.substring(8,15).equals("//King ")) {
// 							name1 = msg.substring(15);
// 						}if(msg.substring(8,15).equals("//Slav ")) {
// 							name2 = msg.substring(15);
// 						}
// 						if(nickName.equals(name1)) {
// 							btn_myKing.setVisible(true);
// 							btn_myCtzn1.setVisible(true);
// 							btn_myCtzn2.setVisible(true);
// 							btn_myCtzn3.setVisible(true);
// 							btn_myCtzn4.setVisible(true);
// 						}
// 						if(nickName.equals(name2)) {
// 							btn_mySlav.setVisible(true);
// 							btn_myCtzn1.setVisible(true);
// 							btn_myCtzn2.setVisible(true);
// 							btn_myCtzn3.setVisible(true);
// 							btn_myCtzn4.setVisible(true);
// 						}
// 						tenTimer.setVisible(false);
// 						jTimer.setVisible(true);
// 						dos.writeUTF("//Ready");
// 					}else if(msg.substring(0,8).equals("//Round3")) {
// 						String name1 =""; String name2 ="";
// 						if(msg.substring(8,15).equals("//King ")) {
// 							name1 = msg.substring(15);
// 						}if(msg.substring(8,15).equals("//Slav ")) {
// 							name2 = msg.substring(15);
// 						}
// 						if(nickName.equals(name1)) {
// 							btn_myKing.setVisible(true);
// 							btn_myCtzn1.setVisible(true);
// 							btn_myCtzn2.setVisible(true);
// 							btn_myCtzn3.setVisible(true);
// 							btn_myCtzn4.setVisible(true);
// 							dos.writeUTF("//Ready");
// 						}
// 						if(nickName.equals(name2)) {
// 							btn_mySlav.setVisible(true);
// 							btn_myCtzn1.setVisible(true);
// 							btn_myCtzn2.setVisible(true);
// 							btn_myCtzn3.setVisible(true);
// 							btn_myCtzn4.setVisible(true);
// 							dos.writeUTF("//Ready");
// 						}
// 						tenTimer.setVisible(false);
// 						jTimer.setVisible(true);
						
// 					}else if(msg.substring(0,8).equals("//Round4")) {
// 						String name1 =""; String name2 ="";
// 						if(msg.substring(8,15).equals("//Slav ")) {
// 							name1 = msg.substring(15);
// 						}if(msg.substring(8,15).equals("//King ")) {
// 							name2 = msg.substring(15);
// 						}
// 						if(nickName.equals(name1)) {
// 							btn_myKing.setVisible(false);
// 							btn_mySlav.setVisible(true);
// 							btn_myCtzn1.setVisible(true);
// 							btn_myCtzn2.setVisible(true);
// 							btn_myCtzn3.setVisible(true);
// 							btn_myCtzn4.setVisible(true);
// 							System.out.println("Roun4 1>>>>"+msg);
// 							dos.writeUTF("//Ready");
// 						}
// 						if(nickName.equals(name2)) {
// 							btn_mySlav.setVisible(false);
// 							btn_myKing.setVisible(true);
// 							btn_myCtzn1.setVisible(true);
// 							btn_myCtzn2.setVisible(true);
// 							btn_myCtzn3.setVisible(true);
// 							btn_myCtzn4.setVisible(true);
// 							System.out.println("Roun4 2>>>>"+msg);
// 							dos.writeUTF("//Ready");
							
// 						}
// 					}
// 					else {
// 						text_chatLog.append(msg+"\n");
// 						System.out.println("else>>>>"+msg);
// 					}
// 				}catch(IOException ie) {}
// 			}
// 		}
// 	}
// 	class Sender extends Thread implements KeyListener, ActionListener{
// 		DataOutputStream dos;
// 		Socket s;
// 		String nickName;
// 		Sender(Socket s, String nickName) {
// 			this.s = s;
// 			try {
// 				dos = new DataOutputStream(this.s.getOutputStream());
// 				this.nickName = nickName;
// 			}catch(IOException ie) {}
			
			
// 		}
		
// 		public void timeinit() {
// 			try {
// 				dos.writeUTF("//timee");
// 				dos.flush();
// 				System.out.println("30초 지남..");
// 			}catch(IOException ie) {
				
// 			}
// 		}
// 		public void run() {
// 			try {
// 				playerName.add(nickName);
// 				dos.writeUTF(nickName);
// 				dos.flush();
// 			}catch(IOException ie) {}
// 		}
// 		void allTrue() {
// 			btn_myKing.setEnabled(true);
// 			btn_mySlav.setEnabled(true);
// 			btn_myCtzn1.setEnabled(true);
// 			btn_myCtzn2.setEnabled(true);
// 			btn_myCtzn3.setEnabled(true);
// 			btn_myCtzn4.setEnabled(true);
// 		}
// 		@Override
// 		public void actionPerformed(ActionEvent e) {
// 			// TODO Auto-generated method stub
// 			if(e.getSource() == btn_Ready) {
// 				try {
// 					dos.writeUTF("//Chat "+"["+nickName+"님 준비 완료 !]");
// 					dos.flush();
// 					dos.writeUTF("//Ready");
// 					dos.flush();
// 					btn_Ready.setEnabled(false);
// 				} catch (IOException e1) {
// 					// TODO Auto-generated catch block
// 					e1.printStackTrace();
// 				}
// 			}/*else if(e.getSource()==btn_myKing || e.getSource()==btn_mySlav || e.getSource()==btn_myCtzn1 || e.getSource()==btn_myCtzn2 || e.getSource()==btn_myCtzn3
// 					|| e.getSource()==btn_myCtzn4 ) {
// 				try {
// 					dos.writeUTF("//Click");
// 					//dos.writeUTF("//Timer"+"//king"+nickName);
// 					dos.flush();
// 					//btn_myBack.setVisible(true);
// 				} catch (IOException e1) {}
// 			}*/else if(e.getSource()== btn_myKing) {
// 				if(map.get(nickName)==null) {
// 					allTrue();
// 					btn_myKing.setEnabled(false);
// 					map.put(nickName, "//King");
// 				}else {
// 					allTrue();
// 					btn_myKing.setEnabled(false);
// 					map.remove(nickName);
// 					map.put(nickName, "//King");
// 				}
// 			}
// 			else if(e.getSource()==btn_mySlav) {
				
// 				if(map.get(nickName)==null) {
// 					allTrue();
// 					btn_mySlav.setEnabled(false);
// 					map.put(nickName, "//Slav");
// 				}else {
// 					allTrue();
// 					btn_mySlav.setEnabled(false);
// 					map.remove(nickName);
// 					map.put(nickName, "//Slav");
// 				}
// 			}else if(e.getSource()==btn_myCtzn1) {
// 					if(map.get(nickName)==null) {
// 						allTrue();
// 						btn_myCtzn1.setEnabled(false);
// 						map.put(nickName, "//Ctzn");
// 						ctzn.put(nickName, "//Ctz1");
// 					}else {
// 						allTrue();
// 						btn_myCtzn1.setEnabled(false);
// 						map.remove(nickName);
// 						map.put(nickName, "//Ctzn");
// 						ctzn.remove(nickName);
// 						ctzn.put(nickName, "//Ctz1");
// 					}
				
// 			}else if(e.getSource()==btn_myCtzn2) {
// 				if(map.get(nickName)==null) {
// 					allTrue();
// 					btn_myCtzn2.setEnabled(false);
// 					map.put(nickName, "//Ctzn");
// 					ctzn.put(nickName, "//Ctz2");
// 				}else {
// 					allTrue();
// 					btn_myCtzn2.setEnabled(false);
// 					map.remove(nickName);
// 					map.put(nickName, "//Ctzn");
// 					ctzn.remove(nickName);
// 					ctzn.put(nickName, "//Ctz2");
// 				}
// 			}else if(e.getSource()==btn_myCtzn3) {
				
// 				if(map.get(nickName)==null) {
// 					allTrue();
// 					btn_myCtzn3.setEnabled(false);
// 					map.put(nickName, "//Ctzn");
// 					ctzn.put(nickName, "//Ctz3");
// 				}else {
// 					allTrue();
// 					btn_myCtzn3.setEnabled(false);
// 					map.remove(nickName);
// 					map.put(nickName, "//Ctzn");
// 					ctzn.remove(nickName);
// 					ctzn.put(nickName, "//Ctz3");
// 				}
// 			}else if(e.getSource()==btn_myCtzn4) {
// 				if(map.get(nickName)==null) {
// 					allTrue();
// 					btn_myCtzn4.setEnabled(false);
// 					map.put(nickName, "//Ctzn");
// 					ctzn.put(nickName, "//Ctz4");
// 				}else {
// 					allTrue();
// 					btn_myCtzn4.setEnabled(false);
// 					map.remove(nickName);
// 					map.put(nickName, "//Ctzn");
// 					ctzn.remove(nickName);
// 					ctzn.put(nickName, "//Ctz4");
// 				}
// 			}else if(e.getSource()==btn_exit) {
// 				System.exit(0);
// 			}
// 		}

// 		public void keyTyped(KeyEvent e) {}
// 		public void keyPressed(KeyEvent e) {}
// 		public void keyReleased(KeyEvent e) {
// 			// TODO Auto-generated method stub
// 			if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				
// 				String chat = text_msg.getText();
// 				System.out.println(chat+"afsfsa");
// 				text_msg.setText("");
// 				try {
// 					dos.writeUTF("//Chat "+nickName+" : "+ chat);
// 					dos.flush();
// 				}catch(IOException ie) {}
// 			}
// 		}
// 	}
// 	class TimeOut implements Runnable{
// 		String count;
// 		Socket s;
// 		int i;
// 		DataOutputStream dos;
// 		Listener listener;
// 		String nickName;
// 		public TimeOut(int i,Socket s,String nickName) {
// 			// TODO Auto-generated constructor stub
// 			this.i = i;
// 			this.s = s;
// 			this.nickName = nickName;
// 			try {
// 				dos = new DataOutputStream(this.s.getOutputStream());
// 			} catch (IOException e) {
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}
// 		}
// 		@Override
// 		public void run() {
// 			// TODO Auto-generated method stub
// 			try {
// 				dos.writeUTF("//Timer"+map.get(nickName)+""+nickName);
// 				dos.flush();
// 				if(map.get(nickName)=="//King") {
// 					btn_myKing.setVisible(false);
// 				}else if(map.get(nickName)=="//Slav") {
// 					btn_mySlav.setVisible(false);
// 				}else if(ctzn.get(nickName)=="//Ctzn1") {
// 					btn_myCtzn1.setVisible(false);
// 				}else if(ctzn.get(nickName)=="//Ctzn2") {
// 					btn_myCtzn2.setVisible(false);
// 				}else if(ctzn.get(nickName)=="//Ctzn3") {
// 					btn_myCtzn3.setVisible(false);
// 				}else if(ctzn.get(nickName)=="//Ctzn4") {
// 					btn_myCtzn4.setVisible(false);
// 				}
// 			}catch(IOException ie) {
				
// 			}
// 		}
// 	}
// }

// class TimeCount implements Runnable{
// 	Listener listener;
	
// 	public TimeCount(Listener listener) {
// 		this.listener = listener;
// 	}
// 	@Override
// 	public void run() {
// 		listener.setTimer();
// 	}
// }
// //10초후...
// class TenTimeCount implements Runnable{
// 	Listener listener;
	
// 	public TenTimeCount(Listener listener) {
// 		this.listener = listener;
// 	}
// 	@Override
// 	public void run() {
// 		listener.tenTimer();
// 	}
// }











