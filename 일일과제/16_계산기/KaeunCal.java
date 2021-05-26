import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KaeunCal extends JFrame{
    Container calWrap;
    JPanel btnPad;
    JTextField input;
    String labelArr[] = {
        "%","CE","C","del",
        "1/x","x²","²√x","÷",
        "7","8","9","×",
        "4","5","6","?",
        "1","2","3","+",
        "+/-","0",".","="
    };
    JButton btnArr[];
    
    KaeunCal(){
        btnArr = new JButton[labelArr.length];
    }

    void init(){
        // pp = new JPanel();
        calWrap = getContentPane();
        //ContentPane은 JFrame 객체가 처음 생길 때 자동으로 생성되는데 그걸 알아내려고
        input = new JTextField(); //TextFiled 생성
        btnPad = new JPanel(); //컴포넌트가 붙을 패널 생성
        btnPad.setLayout(new GridLayout(6,4));

        for (int i = 0; i < labelArr.length; i++) {
            btnArr[i] = new JButton(labelArr[i]);
            if(labelArr[i].equals("")){
                btnArr[i].setVisible(false);
            }
            btnPad.add(btnArr[i]);
        }

        calWrap.add(input, BorderLayout.CENTER);
        calWrap.add(btnPad, BorderLayout.SOUTH);
        setUI();
    }
    
    
    void setUI(){
		setTitle("계산기");
		setSize(300, 260);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
        KaeunCal view = new KaeunCal();
        view.init();
    }
    
}
