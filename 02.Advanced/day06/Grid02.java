import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grid02 extends JFrame{

    String labels[] = {
        "7", "8", "9",
        "4", "5", "6",
        "1", "2", "3"
    };
    JButton bs[];
    Container cp;

    void init(){
        bs = new JButton[labels.length];
        setLayout(new GridLayout(3,3));
        cp = getContentPane();
        for(int i=0; i<labels.length; i++){
            bs[i] = new JButton(labels[i]);
            cp.add(bs[i]);
        }
        setUI();
    }
    
    void setUI(){
		setTitle("GridLayout Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args){
        new Grid02().init();

    }

    
}
