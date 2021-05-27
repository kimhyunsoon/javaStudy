import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EEvent01 extends JFrame{

    JButton b;
    
    //ActionListener 인터페이스로부터 구현된 내부클래스 
    //ActionListener(interface) : 내부클래스 생성하여 인터페이스를 구현하고
    //해당 클래스에서 생성된 객체는 컴포넌트의 addActionListener 메소드를 사용하여
    //컴포넌트에 등록됩니다. 이벤트가 발생하면 해당 개체의 actionPerformed 메서드가
    // 호출됩니다.
    class EEvent01Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {  
            b.setText("클릭! by 유명 내부클래스");
            //ActionEvent 클래스 : addActionListener 메소드를 사용하여 
            //해당 이벤트를 수신하도록 등록된 모든 ActionListener 개체에 전달
            
            
            // Object obj= e.getSource(); //반환타입: 이벤트가 처음 발생한 Object
            // JButton jb = (JButton)obj;
            // jb.setText("클릭! by 유명 내부클래스(event 객체 이용)");
            //이벤트가 발생한 객체에 한해서 해당
        } 
    }
    
    
    void init(){

        b = new JButton("자바의 버튼");
        ActionListener listener = new EEvent01Handler(); //이벤트핸들러 클래스로부터 액션리스너 구현해서 생성?
        b.addActionListener(listener);
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

        EEvent01 event01 = new EEvent01();
        event01.init();
        
        
    }
    
}
