  
package RockPaperScissors;

import java.awt.*;
import java.awt.event.*;


import RockPaperScissors.MessageBox;
import RockPaperScissors.ClientThread;


public class HandGameClient extends Frame implements ActionListener, KeyListener,MouseListener{
	
	   public TextField cc_tfLogon; // �α׿� �Է� �ؽ�Ʈ �ʵ�
	   public Button cc_btLogon; // �α׿� ���� ��ư
	   private Button cc_btEnter; // ���ӿ�û ��ư
	   private Button cc_btLogout; // �α׾ƿ� ��ư
	   public TextField cc_tfStatus; // �α׿� ���� �ȳ�
	   public List cc_lstMember,cc_lstPlayer; //  �α׿� ������

	   public static ClientThread cc_thread;
	   public static HandGameClient client;
	   public String msg_logon="";
	   String targetID=null;  //���� ����� ����
	   
	   

	   public HandGameClient(String str){
	      super(str);
	      setLayout(new BorderLayout());


	      Panel bt_panel = new Panel();
	      bt_panel.setLayout(new FlowLayout());
	      cc_btLogon = new Button("�α׿½���");
	      cc_btLogon.addActionListener(this);
	      bt_panel.add(cc_btLogon);
	      
	      cc_tfLogon = new TextField(10);
	      cc_tfLogon.addKeyListener(this);
	      bt_panel.add(cc_tfLogon);
	      
	      cc_btEnter = new Button("��������");
	      cc_btEnter.addActionListener(this);
	      bt_panel.add(cc_btEnter);
	      
	      
	      cc_btLogout = new Button("�α׾ƿ�");
	      cc_btLogout.addActionListener(this);
	      bt_panel.add(cc_btLogout);
	      add("Center", bt_panel);


	      Panel roompanel = new Panel();
	      roompanel.setLayout(new BorderLayout());

	      Panel northpanel = new Panel();
	      northpanel.setLayout(new FlowLayout());
	      cc_tfStatus = new TextField("������ �����Ϸ���  ID�� �Է��Ͻʽÿ�.",43); 
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
	      labelpanel.add(new Label("�α׿� �� ������"),BorderLayout.EAST) ;
	      labelpanel.add(new Label("����������"),BorderLayout.WEST) ;
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
	      public void windowClosing(WindowEvent we){ //�α׾ƿ�
	    	 
	    	  if(msg_logon==cc_thread.st_ID){
	    		  cc_thread.requestLogout(msg_logon);
	    	  }
	         System.exit(0); 
	      }
	   }

	   //��ư ������
	   public void actionPerformed(ActionEvent ae){
	      Button b = (Button)ae.getSource();
	      if(b.getLabel().equals("�α׿½���")){

	         // �α׿� ó�� ��ƾ
	         msg_logon = cc_tfLogon.getText(); 
	         if(!msg_logon.equals("")){
	            cc_thread.requestLogon(msg_logon); 
	         }else{
	            MessageBox msgBox = new  MessageBox(this, "�α׿�", "�α׿� id�� �Է��ϼ���.");
	            msgBox.show();
	         }
	         
	      }else if(b.getLabel().equals("��������")){
	    	  if(!msg_logon.equals("")){
	    		  // ���ӿ�û ó�� ��ƾ
	    		  msg_logon = cc_tfLogon.getText();
	           
   	      			if(msg_logon.equals(targetID) ) {
   	      				//�ڽ��� Ŭ������ ��
   	      				cc_tfStatus.setText("�ڽŰ��� ������ �� �� �����ϴ�.\n");
   	      			}
   	      			else if(targetID ==null) {
   	      				//������ ����� ���� ��������
   	      				cc_tfStatus.setText("������ �� ����� ������ �ּ���.\n");
   	      			}
   	      			else{
   	      				//���濡�� ���ӿ�û
   	      				cc_thread.requestPlayGame(targetID); 
   	      			}  	      		
   	      			targetID=null;
	    	  }else{
		            MessageBox msgBox = new  MessageBox(this, "�α׿�", "�α׿� id�� �Է��ϼ���.");
		            msgBox.show();
	    	  }
	      }else if(b.getLabel().equals("�α׾ƿ�")){
   	    	  // �α׾ƿ� ó�� ��ƾ
   	    	  cc_thread.requestLogout(msg_logon);
	      }
	   }
	   
	   
	   //enterŰ�ε� �α��� ����
	   public void keyPressed(KeyEvent ke){
		   msg_logon = cc_tfLogon.getText(); // �α׿� ID�� �д´�.
		   
		   if(ke.getKeyChar() == KeyEvent.VK_ENTER){
			   if(!msg_logon.equals("")){
				   cc_thread.requestLogon(msg_logon); // ClientThread�� �޼ҵ带 ȣ��
				   
			   }else{
				   MessageBox msgBox = new  MessageBox(this, "�α׿�", "�α׿� id�� �Է��ϼ���.");
				   msgBox.show();
			   }   
		   }
	   }

	   public static void main(String args[]){
	      client = new HandGameClient("���������� ����");
	      client.setSize(350, 400);
	      client.show();

	      try{
	         cc_thread = new ClientThread(client); // ���� ȣ��Ʈ�� ������
	         cc_thread.start(); // Ŭ���̾�Ʈ�� �����带 �����Ѵ�.
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
		//�����ϰ� ���� ����� �����Ѵ�.
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