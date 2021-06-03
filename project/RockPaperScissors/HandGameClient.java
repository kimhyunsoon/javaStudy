  
package RockPaperScissors;

import java.awt.*;
import java.awt.event.*;


import RockPaperScissors.MessageBox;
import RockPaperScissors.ClientThread;


public class HandGameClient extends Frame implements ActionListener, KeyListener,MouseListener{
	
	   public TextField cc_tfLogon; // 로그온 입력 텍스트 필드
	   public Button cc_btLogon; // 로그온 실행 버튼
	   private Button cc_btEnter; // 게임요청 버튼
	   private Button cc_btLogout; // 로그아웃 버튼
	   public TextField cc_tfStatus; // 로그온 개설 안내
	   public List cc_lstMember,cc_lstPlayer; //  로그온 참가자

	   public static ClientThread cc_thread;
	   public static HandGameClient client;
	   public String msg_logon="";
	   String targetID=null;  //게임 대상자 선택
	   
	   

	   public HandGameClient(String str){
	      super(str);
	      setLayout(new BorderLayout());


	      Panel bt_panel = new Panel();
	      bt_panel.setLayout(new FlowLayout());
	      cc_btLogon = new Button("로그온실행");
	      cc_btLogon.addActionListener(this);
	      bt_panel.add(cc_btLogon);
	      
	      cc_tfLogon = new TextField(10);
	      cc_tfLogon.addKeyListener(this);
	      bt_panel.add(cc_tfLogon);
	      
	      cc_btEnter = new Button("게임참여");
	      cc_btEnter.addActionListener(this);
	      bt_panel.add(cc_btEnter);
	      
	      
	      cc_btLogout = new Button("로그아웃");
	      cc_btLogout.addActionListener(this);
	      bt_panel.add(cc_btLogout);
	      add("Center", bt_panel);


	      Panel roompanel = new Panel();
	      roompanel.setLayout(new BorderLayout());

	      Panel northpanel = new Panel();
	      northpanel.setLayout(new FlowLayout());
	      cc_tfStatus = new TextField("게임을 시작하려면  ID를 입력하십시오.",43); 
	      cc_tfStatus.setEditable(false);
	      northpanel.add(cc_tfStatus);
	      
	      Panel centerpanel = new Panel();
	      centerpanel.setLayout(new FlowLayout());
	      
	      Panel playpanel = new Panel();
	      playpanel.setLayout(new BorderLayout());
	  

	      centerpanel.add(playpanel);

	      Panel southpanel = new Panel(); 
	      southpanel.setLayout(new BorderLayout());
	      Panel labelpanel = new Panel();
	      labelpanel.add(new Label("로그온 중 참여자"),BorderLayout.EAST) ;
	      labelpanel.add(new Label("게임참여자"),BorderLayout.WEST) ;
	      southpanel.add(labelpanel,BorderLayout.NORTH);
	      
	      Panel boardpanel = new Panel();
	      cc_lstMember = new List(10);  	      
	      boardpanel.add(cc_lstMember,BorderLayout.EAST);
	      cc_lstPlayer = new List(10);
	      cc_lstMember.addMouseListener(this);
	      boardpanel.add(cc_lstPlayer,BorderLayout.WEST);
	      southpanel.add(boardpanel,BorderLayout.SOUTH);
	      
	      roompanel.add("North", northpanel);
	      roompanel.add("Center", centerpanel);
	      roompanel.add("South", southpanel);
	      add("North", roompanel);


	      addWindowListener(new WinListener());
	   }

	   class WinListener extends WindowAdapter
	   {
	      public void windowClosing(WindowEvent we){ //로그아웃
	    	 
	    	  if(msg_logon==cc_thread.st_ID){
	    		  cc_thread.requestLogout(msg_logon);
	    	  }
	         System.exit(0); 
	      }
	   }

	   //버튼 리스너
	   public void actionPerformed(ActionEvent ae){
	      Button b = (Button)ae.getSource();
	      if(b.getLabel().equals("로그온실행")){

	         // 로그온 처리 루틴
	         msg_logon = cc_tfLogon.getText(); 
	         if(!msg_logon.equals("")){
	            cc_thread.requestLogon(msg_logon); 
	         }else{
	            MessageBox msgBox = new  MessageBox(this, "로그온", "로그온 id를 입력하세요.");
	            msgBox.show();
	         }
	         
	      }else if(b.getLabel().equals("게임참여")){
	    	  if(!msg_logon.equals("")){
	    		  // 게임요청 처리 루틴
	    		  msg_logon = cc_tfLogon.getText();
	           
   	      			if(msg_logon.equals(targetID) ) {
   	      				//자신을 클릭했을 시
   	      				cc_tfStatus.setText("자신과는 게임을 할 수 없습니다.\n");
   	      			}
   	      			else if(targetID ==null) {
   	      				//게임할 대상을 선택 안했을시
   	      				cc_tfStatus.setText("게임을 할 대상을 선택해 주세요.\n");
   	      			}
   	      			else{
   	      				//상대방에게 게임요청
   	      				cc_thread.requestPlayGame(targetID); 
   	      			}  	      		
   	      			targetID=null;
	    	  }else{
		            MessageBox msgBox = new  MessageBox(this, "로그온", "로그온 id를 입력하세요.");
		            msgBox.show();
	    	  }
	      }else if(b.getLabel().equals("로그아웃")){
   	    	  // 로그아웃 처리 루틴
   	    	  cc_thread.requestLogout(msg_logon);
	      }
	   }
	   
	   
	   //enter키로도 로그인 가능
	   public void keyPressed(KeyEvent ke){
		   msg_logon = cc_tfLogon.getText(); // 로그온 ID를 읽는다.
		   
		   if(ke.getKeyChar() == KeyEvent.VK_ENTER){
			   if(!msg_logon.equals("")){
				   cc_thread.requestLogon(msg_logon); // ClientThread의 메소드를 호출
				   
			   }else{
				   MessageBox msgBox = new  MessageBox(this, "로그온", "로그온 id를 입력하세요.");
				   msgBox.show();
			   }   
		   }
	   }

	   public static void main(String args[]){
	      client = new HandGameClient("가위바위보 게임");
	      client.setSize(350, 400);
	      client.show();

	      try{
	         cc_thread = new ClientThread(client); // 로컬 호스트용 생성자
	         cc_thread.start(); // 클라이언트의 스레드를 시작한다.
	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//게임하고 싶은 대상을 선택한다.
		targetID = cc_lstMember.getSelectedItem().toString();
		System.out.println(targetID);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


   	   
}