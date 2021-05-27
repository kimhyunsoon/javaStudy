import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EEvent04 extends JFrame implements ActionListener{

    JButton b;
    
    void init(){
		b = new JButton("자바의 버튼");
		b.addActionListener(this);
		add(b);

		setUI();
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        b.setText("자기자신");
        
    }

    
    void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args) {
        EEvent04 e4 = new EEvent04();
        e4.init();
        
    }
}
