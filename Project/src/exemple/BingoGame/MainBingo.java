import java.io.*;
import java.io.File;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;
import javafx.embed.swing.*;
import java.util.*;
import java.util.Random;
import javax.sound.sampled.*; 
import javafx.scene.media.*;

class MainBingoGame extends JFrame implements ActionListener{ 

	Font f1 = new Font("������� ExtraBold", Font.BOLD, 13);//�÷��̾��̸�
	Font f2 = new Font("������� ExtraBold", Font.BOLD, 27);//������
	Font f3 = new Font("������� ExtraBold", Font.BOLD, 25);//subb
	Font f4 = new Font("������� ExtraBold", Font.BOLD, 60);//time

	JPanel contentPane, panel_Main, panel_Rank, panel_GameBoard, panel_Chat; 
	JButton btn_Ready, btn_Exit, btn_Bingo;
	JLabel label_Back;
	JLabel label_Logo, label_Notice, label_Timer;
	JLabel label_Client1, label_Client2, label_Client3, label_Client4, label_Client5;
	Label label_Client1_Sub, label_Client2_Sub, label_Client3_Sub, label_Client4_Sub, label_Client5_Sub;
	Label label_Client1_Subb, label_Client2_Subb, label_Client3_Subb, label_Client4_Subb, label_Client5_Subb;
	JTextField textField;
	JTextArea textArea;
	JScrollPane scrollPane;
	ImageIcon imgTitle = new ImageIcon("image//1.png");
	Cursor cursor;
	Image img;
	MediaPlayer p;
	Socket s;
	String nickName;

	static JButton[] buttons = new JButton[36];
	static String[] images = {
		"i1.png", "i2.png", "i3.png", "i4.png", "i5.png", "i6.png", "i7.png", "i8.png", "i9.png", "i10.png", "i11.png", "i12.png", "i13.png", "i14.png", "i15.png", "i16.png","i17.png", "i18.png",
		"i1.png", "i2.png", "i3.png", "i4.png", "i5.png", "i6.png", "i7.png", "i8.png", "i9.png", "i10.png", "i11.png", "i12.png", "i13.png", "i14.png", "i15.png", "i16.png","i17.png", "i18.png"
		};
	
	static int openCount = 0; 
	static int buttonIndexSave1 = 0;
	static int buttonIndexSave2 = 0; 
	static Timer timer; 
	static int tryCount = 0; 
	static int successCount = 0; 
	static int tempSuccess = 0;	

	int port = 7777;
	String playerName, playerScore, playerIdx; 
	boolean gameStart; 
	boolean scoreCheck = false;
	
	// �⺻ GUI ����
		MainBingoGame(){	
			//Ŀ��
			Toolkit tk = Toolkit.getDefaultToolkit();
			img = tk.getImage("image\\1.png");
			Point point = new Point(10,10);
			cursor = tk.createCustomCursor(img,point,"1");
			setCursor(cursor);

			setTitle("BingMon : Poket Monsters Bingo!");	
			setFont(new Font("�����ٸ����", Font.PLAIN, 13));
			setVisible(true);	
			setResizable(false);
			setBounds(300, 100, 1200, 825);			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);			
			setIconImage(imgTitle.getImage());  
			
			contentPane = new JPanel();
			contentPane.setBorder(null);
			setContentPane(contentPane);
			contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
			contentPane.setOpaque(true);
			
			panel_Main = new JPanel();			
			panel_Main.setOpaque(true);		
			contentPane.add(panel_Main);
			panel_Main.setLayout(null);

			label_Back = new JLabel(new ImageIcon("image\\back02.png"));
			label_Back.setOpaque(true);
			label_Back.setBounds(0, 0, 1200, 800);
			panel_Main.add(label_Back);
			panel_Main.setLayout(null);

	//1// ���� ���� ����		

			label_Logo = new JLabel(new ImageIcon("image\\logo.png"));					
			label_Logo.setOpaque(false);			
			label_Logo.setBounds(30, 30, 290, 150);
			label_Back.add(label_Logo);		

			panel_Rank = new JPanel();		
			panel_Rank.setOpaque(false);					
			panel_Rank.setBounds(30, 190, 290, 500);		
			label_Back.add(panel_Rank);		
			panel_Rank.setLayout(null);

			JLabel label_Rank_back = new JLabel(new ImageIcon("image\\playerBoard.png"));
			label_Rank_back.setOpaque(false);
			label_Rank_back.setBounds(0, 0, 290, 500);
			panel_Rank.add(label_Rank_back);	

			label_Client1 = new JLabel(new ImageIcon("image\\waiting.png"));		
			label_Client1.setBounds(5, 8, 140, 90);
			label_Rank_back.add(label_Client1);
			
			label_Client1_Sub = new Label();
			label_Client1_Sub.setFont(f1);
			label_Client1_Sub.setAlignment(Label.CENTER);
			label_Client1_Sub.setBackground((new Color(255,230,144)));
			label_Client1_Sub.setBounds(145, 8, 140, 45);
			label_Rank_back.add(label_Client1_Sub);

			label_Client1_Subb = new Label("0");
			label_Client1_Subb.setFont(f3);
			label_Client1_Subb.setAlignment(Label.CENTER);
			label_Client1_Subb.setForeground((new Color(237,28,36)));
			label_Client1_Subb.setBackground((new Color(255,230,144)));
			label_Client1_Subb.setBounds(145, 53, 140, 45);
			label_Rank_back.add(label_Client1_Subb);
			
			label_Client2 = new JLabel(new ImageIcon("image\\waiting.png"));	
			label_Client2.setBounds(5, 106, 140, 90);
			label_Rank_back.add(label_Client2);
			
			label_Client2_Sub = new Label();
			label_Client2_Sub.setFont(f1);
			label_Client2_Sub.setAlignment(Label.CENTER);			
			label_Client2_Sub.setBackground((new Color(255,230,144)));
			label_Client2_Sub.setBounds(145, 106, 140, 45);
			label_Rank_back.add(label_Client2_Sub);

			label_Client2_Subb = new Label("0");
			label_Client2_Subb.setFont(f3);
			label_Client2_Subb.setAlignment(Label.CENTER);
			label_Client2_Subb.setForeground((new Color(237,28,36)));
			label_Client2_Subb.setBackground((new Color(255,230,144)));
			label_Client2_Subb.setBounds(145, 151, 140, 45);
			label_Rank_back.add(label_Client2_Subb);
			
			label_Client3 = new JLabel(new ImageIcon("image\\waiting.png"));		
			label_Client3.setBounds(5, 204, 140, 90);
			label_Rank_back.add(label_Client3);
			
			label_Client3_Sub = new Label();
			label_Client3_Sub.setFont(f1);
			label_Client3_Sub.setAlignment(Label.CENTER);			
			label_Client3_Sub.setBackground((new Color(255,230,144)));
			label_Client3_Sub.setBounds(145, 204, 140, 45);
			label_Rank_back.add(label_Client3_Sub);

			label_Client3_Subb = new Label("0");
			label_Client3_Subb.setFont(f3);
			label_Client3_Subb.setAlignment(Label.CENTER);
			label_Client3_Subb.setForeground((new Color(237,28,36)));
			label_Client3_Subb.setBackground((new Color(255,230,144)));
			label_Client3_Subb.setBounds(145, 249, 140, 45);
			label_Rank_back.add(label_Client3_Subb);
			
			label_Client4 = new JLabel(new ImageIcon("image\\waiting.png"));		
			label_Client4.setBounds(5, 302, 140, 90);
			label_Rank_back.add(label_Client4);
			
			label_Client4_Sub = new Label();
			label_Client4_Sub.setFont(f1);
			label_Client4_Sub.setAlignment(Label.CENTER);
			label_Client4_Sub.setBackground((new Color(255,230,144)));
			label_Client4_Sub.setBounds(145, 302, 140, 45);
			label_Rank_back.add(label_Client4_Sub);		

			label_Client4_Subb = new Label("0");
			label_Client4_Subb.setFont(f3);
			label_Client4_Subb.setAlignment(Label.CENTER);
			label_Client4_Subb.setForeground((new Color(237,28,36)));
			label_Client4_Subb.setBackground((new Color(255,230,144)));
			label_Client4_Subb.setBounds(145, 347, 140, 45);
			label_Rank_back.add(label_Client4_Subb);		

			label_Client5 = new JLabel(new ImageIcon("image\\waiting.png"));		
			label_Client5.setBounds(5, 400, 140, 90);
			label_Rank_back.add(label_Client5);
			
			label_Client5_Sub = new Label();
			label_Client5_Sub.setFont(f1);
			label_Client5_Sub.setAlignment(Label.CENTER);
			label_Client5_Sub.setBackground((new Color(255,230,144)));
			label_Client5_Sub.setBounds(145, 400, 140, 45);
			label_Rank_back.add(label_Client5_Sub);
			
			label_Client5_Subb = new Label("0");
			label_Client5_Subb.setFont(f3);
			label_Client5_Subb.setAlignment(Label.CENTER);
			label_Client5_Subb.setForeground((new Color(237,28,36)));
			label_Client5_Subb.setBackground((new Color(255,230,144)));
			label_Client5_Subb.setBounds(145, 445, 140, 45);
			label_Rank_back.add(label_Client5_Subb);

			btn_Exit = new JButton(new ImageIcon("image\\exit01.png"));
			btn_Exit.setPressedIcon(new ImageIcon("image\\exit02.png"));			
			btn_Exit.setFocusPainted(false);
			btn_Exit.setBorderPainted(false);
			btn_Exit.setContentAreaFilled(false);
			btn_Exit.setOpaque(false);			
			btn_Exit.setBounds(30, 700, 290, 70);
			label_Back.add(btn_Exit);
			btn_Exit.addActionListener(this);			

	//2// ���� ���� ����
	
			label_Notice = new JLabel();		
			label_Notice.setFont(f2);
			label_Notice.setOpaque(false);
			label_Notice.setForeground((new Color(249, 45, 0)));
			label_Notice.setBounds(350, 25, 500, 150);
			label_Notice.setHorizontalAlignment(JLabel.CENTER);	
			label_Back.add(label_Notice);
			label_Notice.setText("���� �����ֶ��~~~");

			panel_GameBoard = new JPanel();
			panel_GameBoard.setOpaque(true);
			panel_GameBoard.setBackground((new Color(254, 204, 4)));
			panel_GameBoard.setBorder(new LineBorder(new Color(254, 204, 4), 4, true));		
			panel_GameBoard.setBounds(350, 190, 500, 500);			
			panel_GameBoard.setLayout(new GridLayout(6, 6, 6, 6));
					
			for(int i = 0; i < 36; i++){ 
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(new Dimension(83, 83));
			buttons[i].setIcon(changeImage("ball.png")); 
			buttons[i].setEnabled(false);				
			buttons[i].addActionListener(this); 
			panel_GameBoard.add(buttons[i]);				
			}			
			mixCard();
			label_Back.add("Center", panel_GameBoard);
									
			btn_Bingo = new JButton(new ImageIcon("image\\bingo01.png"));
			btn_Bingo.setPressedIcon(new ImageIcon("image\\bingo02.png"));
			btn_Bingo.setFocusPainted(false);
			btn_Bingo.setBorderPainted(false);
			btn_Bingo.setContentAreaFilled(false);
			btn_Bingo.setOpaque(false);			
			btn_Bingo.setEnabled(false);
			btn_Bingo.setBounds(455, 700, 290, 70);
			label_Back.add(btn_Bingo);		
			btn_Bingo.addActionListener(this);

		//3// ä�� ����

			JPanel panel_Time_back = new JPanel();
			panel_Time_back.setBounds(880, 30, 290, 150);		
			panel_Time_back.setOpaque(false);

			JLabel label_Time = new JLabel(new ImageIcon("image\\time.png"));
			label_Time.setBounds(880, 30, 290, 70);

			label_Timer = new JLabel("00 : 00");
			label_Timer.setBounds(880, 90, 290, 70);
			label_Timer.setFont(f4);
			label_Timer.setForeground(Color.WHITE);
			label_Timer.setHorizontalTextPosition(SwingConstants.CENTER);
			label_Timer.setHorizontalAlignment(SwingConstants.CENTER);
			
			label_Back.add(panel_Time_back);
			panel_Time_back.add(label_Time);	
			panel_Time_back.add(label_Timer);		

			panel_Chat = new JPanel();		
			panel_Chat.setBounds(880, 190, 290, 500);			
			label_Back.add(panel_Chat);
			panel_Chat.setLayout(null);

			scrollPane = new JScrollPane(textArea);
			scrollPane.setFont(f1);			
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 0, 290, 470);
			scrollPane.setBorder(null);
			panel_Chat.add(scrollPane);

			textArea = new JTextArea();		
			textArea.setBorder(new LineBorder(new Color(254, 204, 4), 4, true));
			textArea.setFont(f1);
			textArea.setEditable(false);
			textArea.setLineWrap(true);
			scrollPane.setViewportView(textArea);
			textArea.setBackground(new Color(255, 230, 144));
			

			textField = new JTextField();
			textField.setBorder(new LineBorder(new Color(81, 227, 0), 4, true));
			textField.setBackground(Color.WHITE);
			textField.setBounds(0, 470, 290, 30);
			panel_Chat.add(textField);
			textField.setColumns(10);			
			
			
			btn_Ready = new JButton(new ImageIcon("image\\ready01.png"));
			btn_Ready.setPressedIcon(new ImageIcon("image\\ready02.png"));
			btn_Ready.setFocusPainted(false);
			btn_Ready.setBorderPainted(false);
			btn_Ready.setContentAreaFilled(false);
			btn_Ready.setOpaque(false);			
			btn_Ready.setBounds(880, 700, 290, 70);
			label_Back.add(btn_Ready);
			btn_Ready.addActionListener(this);			
				
			startChat();		
		}//������ �ݴ� ��ȣ
	
// �÷��̾� ����
	public void updateClientList(){ 
		ImageIcon ii;		
		if(Integer.parseInt(playerIdx) == 0){			
			ii = new ImageIcon("image\\player3.png");
			ii.getImage().flush();
			label_Client1.setIcon(ii);
			label_Client1_Sub.setText(playerName + "��");
			label_Client1_Subb.setText(playerScore);
			deleteClientList();
		}else if(Integer.parseInt(playerIdx) == 1){			
			ii = new ImageIcon("image\\player2.png");
			ii.getImage().flush();
			label_Client2.setIcon(ii);
			label_Client2_Sub.setText(playerName + "��");
			label_Client2_Subb.setText(playerScore);
			deleteClientList();
		}else if(Integer.parseInt(playerIdx) == 2){			
			ii = new ImageIcon("image\\player1.png");
			ii.getImage().flush();
			label_Client3.setIcon(ii);
			label_Client3_Sub.setText(playerName + "��");
			label_Client3_Subb.setText(playerScore);
			deleteClientList();
		}else if(Integer.parseInt(playerIdx) == 3){			
			ii = new ImageIcon("image\\player5.png");
			ii.getImage().flush();
			label_Client4.setIcon(ii);
			label_Client4_Sub.setText(playerName + "��");
			label_Client4_Subb.setText(playerScore);
			deleteClientList();
		}else if(Integer.parseInt(playerIdx) == 4){			
			ii = new ImageIcon("image\\player4.png");
			ii.getImage().flush();
			label_Client5.setIcon(ii);
			label_Client5_Sub.setText(playerName + "��");
			label_Client5_Subb.setText(playerScore);
			deleteClientList();
		}
	}

//�÷��̾� ����
	public void deleteClientList(){
		ImageIcon ii2;
		ii2 = new ImageIcon("image\\waiting.png");
		if(Integer.parseInt(playerIdx) == 0){
			label_Client2.setIcon(ii2);
			label_Client2_Sub.setText("�� ��������!");
			label_Client2_Sub.setFont(f1);
			label_Client3.setIcon(ii2);
			label_Client3_Sub.setFont(f1);
			label_Client3_Sub.setText("�� ��������!");
			label_Client4.setIcon(ii2);
			label_Client4_Sub.setFont(f1);
			label_Client4_Sub.setText("�� ��������!");
			label_Client5.setIcon(ii2);
			label_Client5_Sub.setFont(f1);
			label_Client5_Sub.setText("�� ��������!");
		}else if(Integer.parseInt(playerIdx) == 1){
			label_Client3.setIcon(ii2);
			label_Client3_Sub.setFont(f1);
			label_Client3_Sub.setText("�� ��������!");
			label_Client4.setIcon(ii2);
			label_Client4_Sub.setFont(f1);
			label_Client4_Sub.setText("�� ��������!");
			label_Client5.setIcon(ii2);
			label_Client5_Sub.setFont(f1);
			label_Client5_Sub.setText("�� ��������!");
		}else if(Integer.parseInt(playerIdx) == 2){
			label_Client4.setIcon(ii2);
			label_Client4_Sub.setText("�� ��������!");
			label_Client5.setIcon(ii2);
			label_Client5_Sub.setText("�� ��������!");
		}else if(Integer.parseInt(playerIdx) == 3){	
			label_Client5_Sub.setFont(f1);
			label_Client5.setIcon(ii2);
			label_Client5_Sub.setText("�� ��������!");		
		}
	}
	
	public void actionPerformed(ActionEvent e) { 		
		ImageIcon naongImg = new ImageIcon("image//naong.png");
		if(e.getSource() == btn_Ready){
			
		}else if(e.getSource() == btn_Bingo){
			
		}else if(e.getSource() == btn_Exit){
			playSound("����11.wav");			
			int select = JOptionPane.showConfirmDialog(null, "���� ������ �����Ҳ�����?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, naongImg);
			if(select == JOptionPane.YES_OPTION) System.exit(0);
		}else{
			if(openCount == 2){ 
				return; 
			}	
			JButton btn = (JButton)e.getSource();
			int index = getButtonIndex(btn); 	

			btn.setIcon(changeImage(images[index])); 													 
													
			openCount++;				
			if(openCount == 1){ 
				buttonIndexSave1 = index; 
			}else if(openCount == 2){
				buttonIndexSave2 = index;
				tryCount++; 
				tempSuccess++;
				if(tryCount == 5){
						label_Notice.setText("���� �� ã�����Ŀ�!!!!!");
				}else{
					label_Notice.setText("���� ���� ���͸� ã�����!!!");	
				}				
				boolean isBingo = checkCard(buttonIndexSave1, buttonIndexSave2);
				if(isBingo == true) { 
				playSound("�¾�����1.wav"); 
				label_Notice.setText("ã����!!! ��ī!! ��ī!!");
				scoreCheck = true; 
				openCount = 0; 
				successCount++; 		
				if(successCount == 3){
					label_Notice.setText("3�޺�!! ���� ������ Ǯ����!!");
				}else if(successCount == 5){					
					label_Notice.setText("������ �Ѱ�!!! �������!!");
				}else if(successCount == 6){
					playSound("�¸�1.wav"); 
					label_Notice.setText("��ī��!! ���� �޼�!!!");
					btn_Bingo.setEnabled(true);	
					}
				}else{ 
					backToQuestion();
				}
			}
		}
		if(scoreCheck == true){
			buttons[buttonIndexSave1].setEnabled(false); 
			buttons[buttonIndexSave2].setEnabled(false);
		}
		scoreCheck = false;
	}//actionPerformed�޼ҵ� �ݴ� ��ȣ

	public void backToQuestion(){
		timer = new Timer(500, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){ 
			playSound("����8.wav"); 			
			openCount = 0; 
			buttons[buttonIndexSave1].setIcon(changeImage("ball.png")); 
			buttons[buttonIndexSave2].setIcon(changeImage("ball.png"));
			timer.stop(); 
			}
		}); 
		timer.start();
	}		
	public boolean checkCard(int index1, int index2){
		if(index1 == index2){
			return false;
		}
		if(images[index1].equals(images[index2])){ 
			return true;
		}else{
			return false;
		}
	}

	public int getButtonIndex(JButton btn){
		int index = 0;
		for(int i = 0; i < 36; i++) {
			if(buttons[i] == btn) { 
				index = i;
			}
		}
		return index;
	}

	static void mixCard(){
		Random rand = new Random();
		for(int i = 0; i < 1000; i++) { 
			int random = rand.nextInt(35) + 1; 
		
			String temp = images[0];
			images[0] = images[random];
			images[random] = temp;
		}
	}
	static ImageIcon changeImage(String filename) {
		ImageIcon icon = new ImageIcon("./image/" + filename);
		Image originImage = icon.getImage();
		Image changedImage = originImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH); //�����ܿ� ���� �׸� ������ ����
		ImageIcon icon_new = new ImageIcon(changedImage);
		return icon_new;
	}		

  // ����
	static void playSound(String filename){
		File file = new File("./waves/" + filename);
		if(file.exists()){ 
			try{
				AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(stream);
				clip.start();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{ 
			System.out.println("File Not Found!");
		}
	}

  // BGM ��� & ����
	public void bgm(String play){
		try{
			if(play.equals("//Play")){
				JFXPanel panel = new JFXPanel();
				File f = new File("./waves/����10.wav");
				Media bgm = new Media(f.toURI().toURL().toString());
				p = new MediaPlayer(bgm);
				p.play();
			}else if(play.equals("//Stop")){
				p.stop();
				p.setMute(true);
				p.dispose();
			}
		}catch(Exception e){
		}
	}	

  // ä�� ���� ����
	public void startChat(){
		String nickName = Login.nickName;
		String ip = Login.ip;

		try{
			Socket s = new Socket(ip, port);
			Sender sender = new Sender(s, nickName);
			Listener listener = new Listener(s);
			new Thread(sender).start();
			new Thread(listener).start();			
			
			textField.addKeyListener(new Sender(s, nickName));
			btn_Ready.addActionListener(new Sender(s, nickName));
			btn_Bingo.addActionListener(new Sender(s, nickName));
			buttons[buttonIndexSave2].addActionListener(new Sender(s, nickName));

		}catch(UnknownHostException uh){
			JOptionPane.showMessageDialog(null, "ȣ��Ʈ�� ã�� �� �����ϴ�!", "ERROR", JOptionPane.WARNING_MESSAGE);
		}catch(IOException io){
			JOptionPane.showMessageDialog(null, "���� ���� ����!\n������ ���� �ִ� �� �����ϴ�.", "ERROR", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}

// ���� Ŭ���� - ����
	class Listener extends Thread{
		Socket s;
		DataInputStream dis;
		InputStream is;
		BufferedReader br; 

		Listener(Socket s){
			this.s = s;
			try{
				dis = new DataInputStream(this.s.getInputStream());
				is = s.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
			}catch(IOException io){}
		}

		public void run(){
			while(dis != null){
				try{
					String msg = dis.readUTF();
					if(msg.startsWith("//CList")){
						playerName = msg.substring(7, msg.indexOf(" "));						
						playerScore = msg.substring(msg.indexOf(" ") + 1, msg.indexOf("#"));
						playerIdx = msg.substring(msg.indexOf("#") + 1);
						updateClientList(); 					
					}else if(msg.startsWith("//ReadyAll")){
						label_Notice.setText("��ε� ���� �Ϸ���!!!");
						 for(int i=3; i>0; i--){
							 try{							
								label_Notice.setText( i + "�� �� ������ �����Ѵٿ�!");							
								Thread.sleep(1000);
							 }catch(InterruptedException ie){}
						 }
					}else if(msg.startsWith("//Start")){ 
						gameStart = true;
						label_Notice.setText("GAME START!");
						label_Notice.setText("�ʱ� : 6�޺�!");
						for(int i = 0; i < 36; i++)
							buttons[i].setEnabled(true);						
						bgm("//Play");
					}else if(msg.startsWith("//Timer")){ 
						label_Timer.setText(msg.substring(7));
					}else if(msg.startsWith("//Showsc")){ 
						if(idxcheck == 1){
							label_Client1_Subb.setText(playerScore);
						}else if(idxcheck == 2){
							label_Client2_Subb.setText(playerScore);
						}else if(idxcheck == 3){
							label_Client3_Subb.setText(playerScore);
						}else if(idxcheck == 4){
							label_Client4_Subb.setText(playerScore);
						}else if(idxcheck == 5){
							label_Client5_Subb.setText(playerScore);
						}
					}else if(msg.startsWith("//Winner")){
						String tempNick = br.readLine();
						label_Notice.setText("WINNER :"+ tempNick+"�� ������!! ������!!^.^");
					}else if(msg.startsWith("//BiEnd")){ 
						playSound("����2.wav");
						gameStart = false;						
						for(int i = 0; i < 36; i++){
							buttons[i].setEnabled(false);
						}						
						btn_Ready.setEnabled(true);	
						label_Timer.setText("00 : 00");	
						bgm("//Stop");
					}else{ 
						textArea.append(msg + "\n");
						scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
					}
					}catch(IOException io){
					textArea.append("[ �������� ������ ���������ϴ�. �г��� �ߺ�, ���� ���� �ʰ�, ���� �������� ��� ������ �źε˴ϴ�. ]\n[ 3�� �� ���α׷��� �����մϴ� .. ]");
					try{
						Thread.sleep(3000);
						System.exit(0);
					}catch(InterruptedException it){}
				}
			}
		}
	}//����Ŭ���� ���� �ݴ� ��ȣ

// ���� Ŭ���� - �۽�
	class Sender extends Thread implements KeyListener, ActionListener/*, MouseMotionListener */
	{	DataOutputStream dos;
		Socket s;
		String nickName;
		
		Sender(Socket s, String nickName){
			this.s = s;
			try{
				dos = new DataOutputStream(this.s.getOutputStream());
				this.nickName = nickName;
			}catch(IOException io){}
		}
		public void run(){
			try{
				dos.writeUTF(nickName);
				if(successCount != tempSuccess){
				dos.writeUTF("//Score");
				dos.flush();
				textArea.append("�׽�Ʈ");
				}
			}catch(IOException io){}
		}		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == btn_Ready){ 
				playSound("����2.wav"); 

				try{
					for(int i = 0; i < 36; i++){ 
						buttons[i].setIcon(changeImage("ball.png")); 
						buttons[i].setEnabled(false);	
					}
					dos.writeUTF("//Chat " + "[ " + nickName + " �� �غ� �Ϸ� ! ]");
					dos.flush();
					dos.writeUTF("//Ready");
					dos.flush();
					btn_Ready.setEnabled(false);					
				}catch(IOException io){
				}				
			}else if(e.getSource() == btn_Bingo){
				playSound("����2.wav");
				
				try{
					dos.writeUTF("//Bingo "+ nickName);
					dos.flush();
					btn_Bingo.setEnabled(false);
				}catch(IOException io){
				}			
			}
		}//�۽� ����Ŭ���� actionPerformed�޼ҵ� �ݴ� ��ȣ
			
		public void keyReleased(KeyEvent e){ 
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				String chat = textField.getText();
				textField.setText("");
				try{
					dos.writeUTF("//Chat " + nickName + " >> : " + chat);
					dos.flush();
				}catch(IOException io){}
			}
		}
		public void keyTyped(KeyEvent e){}
		public void keyPressed(KeyEvent e){}
	}//����Ŭ���� �۽� ��ü �ݴ� ��ȣ
}//��ü Ŭ���� �ݴ� ��ȣ	