package guitest;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI1 extends JFrame{

    Container cp;
    ImageIcon imageIcon1, imageIcon2,imageIcon3, imageIcon4, imageIcon5;
    JButton bn,bs,bw,be;
    JPanel p,pBaby;
    JLabel jl1,jl2;
    Handler01 handler01;

    void init(){

        loadImg();
        setPanel();
        Handler01 handler01 = new Handler01(this);
        bn.addActionListener(handler01);
        Handler02 handler02= new Handler02(this);
        bs.addActionListener(handler02);
        Handler03 handler03= new Handler03(this);
        bw.addActionListener(handler03);
        Handler04 handler04= new Handler04(this);
        be.addActionListener(handler04);

        
        setUI();
    }

    void setPanel(){
        pBaby = new JPanel();
        pBaby.setLayout(new GridLayout(1,2));
        jl1 = new JLabel(imageIcon1);
        jl2 = new JLabel(imageIcon2);
        pBaby.add(jl1);
        pBaby.add(jl2);

        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(pBaby);

        bn = new JButton("물렸나요?");
        bs = new JButton("수업은 다 이해했나요?");
        bw = new JButton("종료");
        be = new JButton("made by");
        
        cp = getContentPane();
        cp.add(p,BorderLayout.CENTER);
        cp.add(bn, BorderLayout.NORTH);
        cp.add(bs, BorderLayout.SOUTH);
        cp.add(bw, BorderLayout.WEST);
        cp.add(be, BorderLayout.EAST);
    }

    void loadImg(){

        try {
            File f1 = new File("image/031.jpg");
            File f2 = new File("image/041.jpg");
            File f3 = new File("image/01.jpg");
            File f4 = new File("image/02.jpg");
            File f5 = new File("image/05.jpg");
            // BufferedImage bi =  ImageIO.read(f); 

            // imageIcon = new ImageIcon(bi); //이미지 개체에서 ImageIcon 생성
            // //getClass(); 오브젝트 생략, 모든 클래스에 있는 메소드
            imageIcon1 = new ImageIcon(ImageIO.read(f1));
            imageIcon2 = new ImageIcon(ImageIO.read(f2));
            imageIcon3 = new ImageIcon(ImageIO.read(f3));
            imageIcon4 = new ImageIcon(ImageIO.read(f4));
            imageIcon5 = new ImageIcon(ImageIO.read(f5));

        } catch (IOException ie) {
        }
    }




    void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(700, 450);
        //pack(); //이미지 크기에 맞춰서 사이즈 생성
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    void pln(String str){
        System.out.println(str);

    }


    public static void main(String[] args){
        new GUI1().init();
    }

    
}




class Handler01 implements ActionListener{

    GUI1 i3;
    Handler01(GUI1 i3){
        this.i3 = i3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = "Yes or No";
        int answer = JOptionPane.showConfirmDialog(null, null, title, JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,i3.imageIcon4);

        if(answer ==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "저두요..존버합시다");

        }else if(answer == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "익절은 진리!");
        }
    }

}

class Handler02 implements ActionListener{

    GUI1 i3;
    Handler02(GUI1 i3){
        this.i3 = i3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = "질문";
        String[] answer = {"당장 취업해도 됨", "비기닝만 이해 가능", "비기닝도 아직..","굳이 말해야 하나요","답변을 선택해주세요!"};
        Object selected = JOptionPane.showInputDialog(null,"수업 내용 다 이해하셨나요?",title,JOptionPane.QUESTION_MESSAGE,i3.imageIcon3,answer,answer[4]);


        if(selected  ==null){
            return;

        }else if(selected == answer[0]){
            JOptionPane.showMessageDialog(null, "자,하산하세요");
        }else if(selected == answer[1]){
            JOptionPane.showMessageDialog(null, "짝짝짝! 칭찬드립니다>.<");
        }else if(selected == answer[2]){
            JOptionPane.showMessageDialog(null, "5번코딩 열심히 합시다^^");
        }else if(selected == answer[3]){
            JOptionPane.showMessageDialog(null, i3.imageIcon5);
        }else{
            return;
        }

        
    }

}


class Handler03 implements ActionListener{

    GUI1 i3;
    Handler03(GUI1 i3){
        this.i3 = i3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = "종료";
        int answer = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", title, JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null);

        if(answer ==JOptionPane.YES_OPTION){

            System.exit(JFrame.EXIT_ON_CLOSE);
        }else if(answer == JOptionPane.NO_OPTION){
            return;
        }
    }

}

class Handler04 implements ActionListener{

    GUI1 i3;
    Handler04(GUI1 i3){
        this.i3 = i3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String title = "GUI Test Ver 1.0";
        int answer = JOptionPane.showConfirmDialog(null, "made by Kaeun", title, JOptionPane.PLAIN_MESSAGE);

    }

}


