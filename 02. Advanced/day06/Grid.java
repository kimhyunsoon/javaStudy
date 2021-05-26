import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//GridLayout
public class Grid extends JFrame{
    JButton b1,b2,b3,b4;
    Container cp;
    
    void init(){
        b1 = new JButton("버튼1");
        b2 = new JButton("버튼2");
        b3 = new JButton("버튼3");
        b4 = new JButton("버튼4");

        setLayout(new GridLayout(2,3));
        cp = getContentPane();
        cp.add(b1);cp.add(b2);cp.add(b3);cp.add(b4);
        cp.add(new JButton("버튼5"));
        cp.add(new JButton("버튼6"));

        setUI();
    }


    void setUI(){
		setTitle("BorderLayout Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
        new Grid().init();
        
    }
    
}
