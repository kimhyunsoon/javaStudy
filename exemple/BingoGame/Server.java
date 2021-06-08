import java.io.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*; 
import javafx.scene.media.*; 

public class Server extends JFrame implements ActionListener{
	JPanel contentPane, panel_Main, panel_TextArea, panel_Btn;
	JScrollPane scrollPane;
	JTextArea textArea;
	JLabel label_ServerStatus, pikachu, naong;
	JButton btn_ServerStart, btn_ServerClose;
	ImageIcon imgTitle = new ImageIcon("image//bal.png");	
	ServerSocket ss;
	Socket s;
	int port = 7777;
	public static final int MAX_CLIENT = 5; 
	int readyPlayer; 
	int score;
	boolean gameStart;
	String line = "";
	LinkedHashMap<String, DataOutputStream> clientList = new LinkedHashMap<String, DataOutputStream>(); 
	LinkedHashMap<String, Integer> clientInfo = new LinkedHashMap<String, Integer>();
	
	public void init(){
		setTitle("BingMon Server");
		setIconImage(imgTitle.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 10, 0));	
		
		panel_Main = new JPanel();
		contentPane.add(panel_Main);
		panel_Main.setLayout(new BoxLayout(panel_Main, BoxLayout.Y_AXIS));
		
		label_ServerStatus = new JLabel("        [ BingMon Server ]        ");
		label_ServerStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_ServerStatus.setPreferredSize(new Dimension(96, 50));
		panel_Main.add(label_ServerStatus);
		label_ServerStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		label_ServerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		label_ServerStatus.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		label_ServerStatus.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));

		JLabel pikachu = new JLabel(new ImageIcon("image//pikachu.png"));
		pikachu.setOpaque(false);
		pikachu.setBorder(null);
		pikachu.setBounds(1, 1, 50, 50);
		label_ServerStatus.add(pikachu);

		JLabel naong = new JLabel(new ImageIcon("image//naong.png"));
		naong.setOpaque(false);
		naong.setBorder(null);
		naong.setBounds(210, 1, 50, 50);
		label_ServerStatus.add(naong);
	
		panel_TextArea = new JPanel();
		panel_Main.add(panel_TextArea);
		panel_TextArea.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_TextArea.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		panel_Btn = new JPanel();
		panel_Btn.setPreferredSize(new Dimension(10, 43));
		panel_Btn.setAutoscrolls(true);
		panel_Main.add(panel_Btn);
		panel_Btn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_ServerStart = new JButton(new ImageIcon("image//on.png"));
		btn_ServerStart.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_ServerStart.setPreferredSize(new Dimension(110, 40));
		btn_ServerStart.setFocusPainted(false);
		btn_ServerStart.setFont(new Font("Calibri", Font.BOLD, 17));
		btn_ServerStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_ServerStart.setForeground(Color.WHITE);
		btn_ServerStart.setBackground(Color.DARK_GRAY);		
	
		btn_ServerStart.setOpaque(false);
		
		btn_ServerStart.setBorder(null);
		
		panel_Btn.add(btn_ServerStart);
		btn_ServerStart.addActionListener(this);
		
		btn_ServerClose = new JButton(new ImageIcon("image//off.png"));
		btn_ServerClose.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_ServerClose.setPreferredSize(new Dimension(110, 40));
		btn_ServerClose.setFocusPainted(false);
		btn_ServerClose.setFont(new Font("Calibri", Font.BOLD, 17));
		btn_ServerClose.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn_ServerClose.setForeground(Color.WHITE);
		btn_ServerClose.setBackground(Color.DARK_GRAY);
		btn_ServerClose.setOpaque(false);
		btn_ServerClose.setBorder(null);
		panel_Btn.add(btn_ServerClose);
		btn_ServerClose.addActionListener(this);
		btn_ServerClose.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btn_ServerStart){
			playSound("맞았을때1.wav"); 
			new Thread(){
				public void run() {
					try{
						Collections.synchronizedMap(clientList);
						ss = new ServerSocket(port);
						label_ServerStatus.setText("[       Started ]");
						textArea.append(" [ 서버가 시작되었습니다. ]" + "\n");
						btn_ServerStart.setEnabled(false);
						btn_ServerClose.setEnabled(true);
						while(true){
							s = ss.accept();
							if((clientList.size() + 1) > MAX_CLIENT || gameStart == true){ 								
								s.close();
							}else{
								Thread gm = new GameManager(s);
								gm.start();
							}
						}
					}catch(IOException io){}
				}
			}.start();
		}else if(e.getSource() == btn_ServerClose){
			ImageIcon naongImg = new ImageIcon("image//naong.png");
			playSound("나옹11.wav"); 
			int select = JOptionPane.showConfirmDialog(null, "정말 종료할꺼나옹?", "BingoMon Server", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, naongImg);
			try{
				if(select == JOptionPane.YES_OPTION){
					ss.close();
					label_ServerStatus.setText("[       Closed ]");
					textArea.append(" [ 서버가 종료되었습니다. ]" + "\n");
					btn_ServerStart.setEnabled(true);
					btn_ServerClose.setEnabled(false);
				}
			}catch(IOException io){}
		}
	}
	
	public void showSystemMsg(String msg){ 
		Iterator<String> it = clientList.keySet().iterator();
		while(it.hasNext()){
			try{
				DataOutputStream dos = clientList.get(it.next());
				dos.writeUTF(msg);
				dos.flush();
			}catch(IOException io){}
		}
	}

	// 내부 클래스
	public class GameManager extends Thread{
		Socket s;
		DataInputStream dis;
		DataOutputStream dos;
							
		public GameManager(Socket s){
			this.s = s;
			try{
				dis = new DataInputStream(this.s.getInputStream());
				dos = new DataOutputStream(this.s.getOutputStream());
			}catch(IOException io){}
		}
		
		public void run(){
			String clientName = "";
			try{
				clientName = dis.readUTF();
				if(!clientList.containsKey(clientName)){ 
					clientList.put(clientName, dos);
					clientInfo.put(clientName, score);
				}else if(clientList.containsKey(clientName)){
					s.close(); 
				}
				showSystemMsg("[ " + clientName + " 님이 입장하셨습니다. ]\n(현재 접속자 수 : " + clientList.size() + "명 / 5명)");  
				textArea.append(" [ 현재 접속자 명단 (총 " + clientList.size() + "명 접속중) ]\n");
				Iterator<String> it1 = clientList.keySet().iterator();
				while(it1.hasNext()) textArea.append(" " + it1.next() + "\n");
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				setClientInfo(); 
				while(dis != null){
					String msg = dis.readUTF();
					filter(msg); 
				}
			}catch(IOException io){
				clientList.remove(clientName); clientInfo.remove(clientName); 
				closeAll();
				if(clientList.isEmpty() == true){
					try{
						ss.close(); System.exit(0);
					}catch(IOException e){}
				}
				showSystemMsg("[ " + clientName + "님이 퇴장하셨습니다. ]\n(현재 접속자 수 : " + clientList.size() + "명 / 5명)");  
				textArea.append("[ 현재 접속자 명단 (총 " + clientList.size() + "명 접속중) ]\n");
				Iterator<String> it1 = clientList.keySet().iterator();
				while(it1.hasNext()) textArea.append(" " + it1.next() + "\n");
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
				setClientInfo(); 
				readyPlayer = 0; 
				gameStart = false;
				showSystemMsg("//GmEnd"); 
			}
		}
		
		public void closeAll(){
			try{
				if(dos != null) dos.close();
				if(dis != null) dis.close();
				if(s != null) s.close();
			}catch(IOException ie){}
		}
		
		public void setClientInfo(){
			String[] keys = new String[clientInfo.size()];
			int[] values = new int[clientInfo.size()];
			int index = 0;
			for(Map.Entry<String, Integer> mapEntry : clientInfo.entrySet()){
			    keys[index] = mapEntry.getKey();
			    values[index] = mapEntry.getValue();
			    index++;
			}
			for(int i=0; i<clientList.size(); i++){
				showSystemMsg("//CList" + keys[i] + " " + values[i] + "#" + i); 
			}
		}
		
		public void filter(String msg) { 
			StopWatch tm = new StopWatch();
			String temp = msg.substring(0, 7);
			if(temp.equals("//Chat ")){ 				
				showSystemMsg(msg.substring(7));
			}else if(temp.equals("//Ready")){
				 readyPlayer++;
				 if(readyPlayer >= 2 && readyPlayer == clientList.size()){ 
					 showSystemMsg("[ 모든 참여자들이 준비되었습니다. ]");
					 showSystemMsg("//ReadyAll");
					 for(int i=3; i>0; i--){
						 try{
							showSystemMsg("[ " + i + "초 후 게임을 시작합니다 .. ]");						 	
						 	Thread.sleep(1000);
						 }catch(InterruptedException ie){}
					 }					
					 tm.start(); 
					 gameStart = true;
					 showSystemMsg("//Start"); 
				 }
			}else if(temp.equals("//Score")){ 
				String tempNick = msg.substring(7);
				clientInfo.put(tempNick, clientInfo.get(tempNick) + 1);
				showSystemMsg("//Showsc");				
			}else if(temp.equals("//Bingo")){ 
					readyPlayer = 0;
					gameStart = false;
					String tempNick = msg.substring(7);				
					showSystemMsg("[" + tempNick +"님이 빙고를 달성하였습니다. ]");						
					showSystemMsg("[ 게임이 종료되었습니다 ]");					
					showSystemMsg("//BiEnd");									
			}else if(temp.equals("//GmEnd")){ 
				showSystemMsg("[ 게임이 종료되었습니다 ]");				
				showSystemMsg(msg);
				readyPlayer = 0;
				gameStart = false;
			}
		}
	}//내부클래스 닫는 괄호
	
	// 내부 클래스 - 타이머
	class StopWatch extends Thread{
		long preTime = System.currentTimeMillis();
		
		public void run() {
			try{
				while(gameStart == true){
					sleep(10);
					long time = System.currentTimeMillis() - preTime;
					showSystemMsg("//Timer" + (toTime(time)));
					if(toTime(time).equals("00 : 00")){
						showSystemMsg("//GmEnd"); 
						readyPlayer = 0;
						gameStart = false;
						break;
					}else if(readyPlayer == 0){
						break;
					}
				}
			}catch (Exception e){}
		}
		
		String toTime(long time){
			int m = (int)(2-(time / 1000.0 / 60.0));
			int s = (int)(60-(time % (1000.0 * 60) / 1000.0));
			return String.format("%02d : %02d", m, s);
		}
	}//내부클래스 닫는 괄호

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
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Server server = new Server();
					server.init();
					server.setVisible(true);
					playSound("서버4.wav");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}//전체클래스 닫는 괄호