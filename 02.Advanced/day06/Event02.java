import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI2 extends JFrame{



    JButton b;
    void init(){
        b = new JButton("자바의 버튼");
        // ActionListener listener = new ActionListener(){

        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         b.setText("클릭! by 무명 내부(1)");
                
        //     }
        // };
        // b.addActionListener(listener);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b.setText("클릭! by 무명 내부(2)");
            }
        }); 
        add(b);
        setUI();


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
        UI2 ui2= new UI2();
        ui2.init();

    }
    
}
