package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Game extends JFrame implements ActionListener {
    JLabel jTimer = new JLabel();//Showing time
    JLabel jScore = new JLabel("");//Showing  score
    Game() {
        JFrame Gframe = new JFrame("Game play");
        Gframe.setBounds(400, 400, 800, 800);
        Gframe.setLayout(null);
        JPanel pScore = new JPanel();
        EtchedBorder border = new EtchedBorder();
        JLabel score = new JLabel(" Score ");
        Font font1 = new Font("±º∏≤", Font.PLAIN, 20);
        jScore.setPreferredSize(new Dimension(5, 5));
        score.setFont(font1);
        score.setBounds(330, 30, 100, 100);
        score.setBorder(border);
        Font font2 = new Font("∞ÌµÒ√º", Font.PLAIN, 20);
        JLabel ttime = new JLabel(" Time ");
        JButton start = new JButton("START");
        start.setFont(font2);
        start.setBounds(150, 40, 100, 100);
        start.setBorder(border);
        start.addActionListener(this);
        jTimer.setLayout(null);
        jTimer.setBounds(330, 30, 300, 300);
        ttime.setFont(font2);
        ttime.setBounds(200, 15, 100, 100);
        ttime.setBorder(border);
        pScore.setLayout(new GridLayout(2, 2));
        pScore.setBounds(330, 30, 200, 100);
        pScore.add(score);
        pScore.add(ttime);
        pScore.add(jScore);
        pScore.add(jTimer);
        add(start);
        Gframe.add(pScore);//Including Score&Time
        Gframe.add(start);//Adding Start Butto
        Gframe.setVisible(true);
    }
    public void setTimer() {
    	int i=0;
        while(i <= 60)
        {              
            try {
                System.out.println(i);       
                jTimer.setText(i+"Sec");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;     
        }
    }
    // When this method is performed,
    // The result indicates that The println(i) shows correctly as a timer 
    // but jTimer.setText() don't show at all.
    // What's more During the playing time, Jbutton(Start) is clicked until it's finished completely.
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("START")) {
            System.out.println("Counting");
            Runnable r1 = new Thr(this);
            Thread t1 = new Thread(r1);
            t1.start();
        }
    }
    public static void main(String args[]) {
        Game ga = new Game();
     }
}
class Thr implements Runnable{

	Game ga;
	Thr(Game ga){
		this.ga = ga;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ga.setTimer();
	}
	
}
