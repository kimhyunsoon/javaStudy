import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.BorderFactory;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.text.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.border.*;
import javax.sound.sampled.*; 
import javafx.scene.media.*; 

class Login extends JFrame implements ActionListener{
  Font f1 = new Font("Serif.bold", Font.BOLD, 20);
  Font f2 = new Font("나눔고딕 Bold", Font.PLAIN, 20);
  Container cp;
  ImageIcon bgImage = new ImageIcon("image//loginBack6.png");
  ImageIcon imgTitle = new ImageIcon("image//card1.png"); 
  Image im=bgImage.getImage();
  JPanel jpCen;
  JLabel label_Id, label_Ip;
  JButton loB;
  JTextField tfId, tfIp;

  public static String ip, nickName;
     
  void init(){      
      cp = getContentPane();
      jpCen = new JPanel();
   
      cp.add(jpCen, BorderLayout.CENTER);
      jpCen.setBorder(BorderFactory.createEmptyBorder(385,27,0,0));
      jpCen.setOpaque(false);
      loB = new JButton(new ImageIcon("image//login3.png"));   
	  loB.setOpaque(true);
	  loB.setSize(10,3);
	  loB.setBorder(new LineBorder(Color.BLACK, 3 ,false));
	  loB.setBackground(new Color(0,156,255));
      loB.addActionListener(this);
	
   //id창구현
      label_Id = new JLabel("ID");      
      label_Id.setFont(f1);
      jpCen.add(label_Id);   
	
      tfId = new JTextField();
      tfId.setText("");     
      jpCen.add(tfId);
      tfId.setColumns(10);
	  tfId.setFont(f2);
	  tfId.addActionListener(this);     
      
	 //ip창구현
      label_Ip = new JLabel("IP");     
      label_Ip.setBounds(250, 0, 0, 0);
      label_Ip.setFont(f1);
      jpCen.add(label_Ip);

      tfIp = new JTextField();
      tfIp.setText("127.0.0.1");
      tfIp.setBounds(250, 10, 10, 0);
      jpCen.add(tfIp);
      tfIp.setColumns(10);
	  tfIp.setFont(f2);
	   jpCen.add(loB);
	   setUi();       
  }
	
    void setUi(){//컨테이너 세팅
      setBounds(300,100,1200,825);
      setTitle("BingMon_Login");
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setIconImage(imgTitle.getImage());
	  MyPanel backPan = new MyPanel();
      add(backPan);
	}
   
   public void actionPerformed(ActionEvent e){
         ImageIcon naongImg = new ImageIcon("Image//naong.png");
         ImageIcon pikaImg = new ImageIcon("Image//pikachu.png");
      Object obj = e.getSource();
	  tfId.requestFocus();
      if(obj == loB){
		 playSound("맞았을때1.wav");
         if (tfId.getText().equals("") || tfIp.getText().equals("")){         
            JOptionPane.showMessageDialog(null, "로그인 화면을 입력해주라옹!", "BinGokemon_Error", JOptionPane.QUESTION_MESSAGE, naongImg);
         }else if (tfId.getText().trim().length()>10){
            JOptionPane.showMessageDialog(null, "ID 최대 10자까지 입력해주라옹!", "BinGokemon_Error", JOptionPane.QUESTION_MESSAGE, naongImg);
            tfId.setText("");
			tfId.requestFocus();
         }else{
            nickName = tfId.getText().trim();
            String temp = tfIp.getText();
            if(temp.matches("(^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$)")){
               ip = temp;
			   playSound("맞았을때1.wav"); 
			  
               JOptionPane.showMessageDialog(null, " 로그인 성공츄! ", "JAVA BingMon LOGIN", JOptionPane.INFORMATION_MESSAGE, pikaImg);
               loB.setEnabled(false);
               tfId.setEnabled(false);
               tfIp.setEnabled(false);
               setVisible(false);           
			   MainBingoGame mb = new MainBingoGame();
            }else{
               JOptionPane.showMessageDialog(null, "IP 주소를 정확하게 입력하라옹! ", "ERROR!", JOptionPane.WARNING_MESSAGE, naongImg);
            }
         }        
      }
   }

   //내부클래스 이미지
    class MyPanel extends JPanel{      
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }

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
      Login lg = new Login();
	  playSound("로그인5.wav");
      lg.init();      
   }
}