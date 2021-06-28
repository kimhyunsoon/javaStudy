import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EEvent02 extends JFrame{

    JButton b;
    void init(){ //무명 내부(1)
        b = new JButton("자바의 버튼");
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("클릭! by 무명 내부(1)");
            }
        };
        
        b.addActionListener(listener);
        add(b);
        setUI();
    }

    void init02(){
        b = new JButton("자바의 버튼");
        b.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("클릭! by 무명 내부(2)");
            }
        });
        add(b);
        setUI();
    }
    
    void setUI(){
        setTitle("Event Test ver 1.0"); //제목
        setSize(300,200); //사이즈
        setVisible(true); 
        setLocation(250,100); //위치
        setResizable(false); //사이즈고정여부
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫았을때 액션 선택

    }
    public static void main(String[] args ){

        EEvent02 event01 = new EEvent02();
        event01.init02();
        
        
    }
    
}
