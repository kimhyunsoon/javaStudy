import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class UI3 extends JFrame{
    JButton b;

    void init(){
        b = new JButton("자바의 버튼");
        UI3Handler a3= new UI3Handler(this);
        b.addActionListener(a3); 
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
        UI3 ui3= new UI3();
        ui3.init();

    }
}

class UI3Handler implements ActionListener{
    A3 a3;
    UI3Handler(UI3 ui3){
    }

    public void actionPerformed(ActionEvent e){
        //b.setText("클릭! by 유명 내부클래스");
        Object obj = e.getSource();
        JButton jb = (JButton)obj;
        jb.setText("클릭! by 제3클래스 이용"); 
        //이벤트가 발생한 객체에 한해서 해당
    }
}
