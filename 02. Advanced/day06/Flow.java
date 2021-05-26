import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//GridLayout
public class Flow extends JFrame{
    Container cp;
    String lables[] = {"도1","레","미","파","솔","라","시","도2"};
    JButton bs[];
    
    Flow(){
        bs = new JButton[8];
    }
    
    void init(){
        setLayout(new flowLayout());
        cp = getContentPane();
        for(int i=0;i<lables.length;i++){
            bs [i]= new JButton(lables[i]);
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

    public static void main(String [] args) {
        new Flow().init();
        
    }
    
}
