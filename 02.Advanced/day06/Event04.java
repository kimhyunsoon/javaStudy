import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI4 extends JFrame implements ActionListener{

    JButton b;
    
    
    void init(){
        b = new JButton("자바의 버튼");

        b.addActionListener(this); 
        add(b);
        setUI();


    }

    public void actionPerformed(ActionEvent e){
        b.setText("자기자신");
    }


    void setUI(){
        setTitle("GUI Test Ver 1.0"); //다 슈퍼와 디스가 생략되어 있다. JFram의 메소드다
        setSize(300,200); //사이즈
        setVisible(true);
        setLocation(200, 100); //위치
        setResizable(false); //창이 안늘어남
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 끄면 시스템을 나가버려라
    }




    public static void main(String[] args){
        UI4 ui4= new UI4();
        ui4.init();

    }


}


