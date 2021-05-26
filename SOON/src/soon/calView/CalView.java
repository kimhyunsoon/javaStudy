package soon.calView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//BorderLayout
public class CalView extends JFrame{
    Container calWrap;

    JPanel pad0, pad1, pad2, pad3, pad4;

    JTextField bPBN,bPBC;


    JTextField input;

    JButton empty0,empty1,empty2,div;
    JButton one,two,three,mul;
    JButton four,five,six,plus;
    JButton seven,eight,nine,minus;
    JButton remove, result;

    void init(){
        input = new JTextField();

        pad0 =new JPanel();
        pad0.setLayout(new BorderLayout());
        empty0 = new JButton("");
        empty1 = new JButton("");
        empty2 = new JButton("");
        div = new JButton("÷");

        pad0.add(empty0, BorderLayout.CENTER);
        p.add(empty1, BorderLayout.EAST);
        p.add(empty2, BorderLayout.WEST);
        p.add(empty3, BorderLayout.WEST);
        p.add(empty4, BorderLayout.WEST);

        pad1 =new JPanel();
        pad2 =new JPanel();
        pad3 =new JPanel();
        pad4 =new JPanel();
        


        pBaby = new JPanel();
        pBaby.setLayout(new BorderLayout());
        bPBC = new JTextField("베이비 센터");
        bPBN = new JTextField("베이비 북쪽");
        pBaby.add(bPBC, BorderLayout.CENTER);
        pBaby.add(bPBN, BorderLayout.NORTH);

        p = new JPanel();
        p.setLayout(new BorderLayout());
        bpc = new JButton("패널 센터");
        bpe = new JButton("패널 동쪽");
        bpw = new JButton("패널 서쪽");
        //p.add(bPC, BorderLayout.CENTER);
        p.add(pBaby, BorderLayout.CENTER);
        p.add(bpe, BorderLayout.EAST);
        p.add(bpw, BorderLayout.WEST);



        bn = new JButton("북");
        bs = new JButton("남");
        bw = new JButton("서");
        be = new JButton("동");
        //bc = new JButton("가운데");

        cp = getContentPane();
        // cp.add(bn, BorderLayout.NORTH);
        // cp.add(bs, BorderLayout.SOUTH);
        // cp.add(bw, BorderLayout.WEST);
        // cp.add(be, BorderLayout.EAST);
        
        cp.add(p,BorderLayout.CENTER);
        setUI();
    }
    
    
    void setUI(){
		setTitle("계산기");
		setSize(300, 600);
		setVisible(true);
		setLocation(200, 100);

	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
       CalView f = new CalView();
       f.init();
    }
    
}
