import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EEVent03 extends JFrame{

    JButton b;
    
    void init(){
		b = new JButton("자바의 버튼");
		EEVent03Handler h = new EEVent03Handler(this);
		b.addActionListener(h);
		add(b);

		setUI();
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
        EEVent03 e3 = new EEVent03();
        e3.init();
        
    }
    
}

class EEVent03Handler implements ActionListener{

    EEVent03 e3;
    EEVent03Handler(EEVent03 e3){
        this.e3 = e3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        e3.b.setText("클릭! by 제3클래스");
        
    }
    
}
