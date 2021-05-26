package soon.calView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalView extends JFrame{
    Container calWrap;
    JPanel emptyNorth;
    JPanel btnPad;
    JTextField input;
    String labelArr[] = {
        "%","CE","C","del",
        "1/𝓍","𝓍²","²√𝓍","÷",
        "7","8","9","×",
        "4","5","6","−",
        "1","2","3","+",
        "+/-","0",".","="
    };
    JButton btnArr[] = new JButton[labelArr.length];
    

    void init(){
        // pp = new JPanel();
        calWrap = getContentPane();
        input = new JTextField();
        emptyNorth = new JPanel();
        btnPad = new JPanel();
        btnPad.setLayout(new GridLayout(6,4));

        for (int i = 0; i < labelArr.length; i++) {
            btnArr[i] = new JButton(labelArr[i]);
            if(labelArr[i].equals("")){
                btnArr[i].setVisible(false);
            }
            btnPad.add(btnArr[i]);
        }

        calWrap.add(emptyNorth, BorderLayout.NORTH);
        calWrap.add(input, BorderLayout.CENTER);
        calWrap.add(btnPad, BorderLayout.SOUTH);
        setUI();
    }
    
    
    void setUI(){
		setTitle("계산기");
		setSize(300, 260);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
        CalView view = new CalView();
        view.init();
    }
    
}
