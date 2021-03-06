import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Event01 extends JFrame{
    JButton b;

    class Event01Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //b.setText("클릭! by 유명 내부클래스");
            Object obj = e.getSource();
            JButton jb = (JButton)obj;
            jb.setText("클릭! by 유명 내부클래스(event 객체 이용)"); 
            //이벤트가 발생한 객체에 한해서 해당
        }
        
    }



    void init(){
        b = new JButton("자바의 버튼");
        ActionListener listener = new Event01Handler();
        b.addActionListener(listener); //javax.swing에 있음, 
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
        Event01 event01= new Event01();
        event01.init();

    }
    
}
