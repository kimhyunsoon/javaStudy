import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Border02 extends JFrame{
    
    Container cp;
    JPanel p;
    JButton bN, bS, bE, bW;
    


    
    void init(){
        cp = getContentPane();

        bN = new JButton("ºÏ");
        bS = new JButton("³²");
        bE = new JButton("µ¿");
        bW = new JButton("¼­");

        cp.add(bN, BorderLayout.NORTH);
        cp.add(bS, BorderLayout.NORTH);
        cp.add(bN, BorderLayout.NORTH);
        cp.add(bN, BorderLayout.NORTH);
        setUI();

    }
    
    void setUI(){
		setTitle("BorderLayout Ver 1.0");
		setSize(500, 300);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args){
        Border02 b2 = new Border02();

    }
}
