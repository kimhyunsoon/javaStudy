import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//GridLayout
public class Card extends JFrame{
    Container cp;
    String lables[] = {"��1","��","��","��","��","��","��","��2"};
    JButton bs[];
    
    Card(){
        bs = new JButton[8];
    }
    
    void init(){
        setLayout(new CardLayout());
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


    public void actionPerformed(ActionEvent e){
		b.setText("Ŭ��! by �ڽ��� ��ü");
	}
    

    public static void main(String [] args) {
        new Card().init();
        
    }
    
}
