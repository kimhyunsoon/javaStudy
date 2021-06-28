import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI01 extends JFrame{

    JButton b;

    void init(){
        b = new JButton("자바의 버튼");
        add(b); //Component java.awt.Container.add(Component comp)
        setUI();
    }
    
    
    void setUI(){
        setTitle("GUI Test ver 1.0"); //제목
        setSize(300,200); //사이즈
        setVisible(true); 
        setLocation(250,100); //위치
        setResizable(false); //사이즈고정여부
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫았을때 액션 선택
    
    
    }

    public static void main(String[] args){

        UI01 ui = new UI01();
        ui.init();
        
    }
    
}
