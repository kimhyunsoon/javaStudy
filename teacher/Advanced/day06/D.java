import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//CardLayout
class D extends JFrame implements ActionListener
{
	Container cp;
	String labels[] = {"도1", "레", "미", "파", "솔", "라", "시", "도2"};
	JButton bs[]; 

    D(){
		bs = new JButton[8];
	}
	void init(){
		//setLayout(new FlowLayout());
		setLayout(new CardLayout());
		cp = getContentPane();
        for(int i=0; i<labels.length; i++){
			bs[i] = new JButton(labels[i]);
			bs[i].addActionListener(this);
			cp.add(bs[i]);
		}

		setUI();
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		/*if(obj == bs[0]){
			cp.remove(bs[0]);
		}else if(obj == bs[1]){
			cp.remove(bs[1]);
		}else if(obj == bs[2]){
			cp.remove(bs[2]);
		}else if(obj == bs[3]){
			cp.remove(bs[3]);
		}else if(obj == bs[4]){
			cp.remove(bs[4]);
		}else if(obj == bs[5]){
			cp.remove(bs[5]);
		}else if(obj == bs[6]){
			cp.remove(bs[6]);
		}else {
			cp.remove(bs[7]);
		}*/
		cp.remove((JButton)obj);

        revalidate();
		repaint();
	}
	void setUI(){
		//setTitle("FlowLayout Test");
		setTitle("CardLayout Test");
		setSize(300, 300);
		setVisible(true);
		setLocation(200, 100);

	    //setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		new D().init();
	}
}
