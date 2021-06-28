import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//BorderLayout
public class Border extends JFrame{
    Container cp;
    JPanel p;
    JPanel pBaby;

    JButton bn,bs,bw,be,bc;
    JButton bpc,bpe,bpw;
    JButton bPBN,bPBC;

    void init(){

        pBaby = new JPanel();
        pBaby.setLayout(new BorderLayout());
        bPBC = new JButton("베이비 센터");
        bPBN = new JButton("베이비 북쪽");
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
        cp.add(bn, BorderLayout.NORTH);
        cp.add(bs, BorderLayout.SOUTH);
        cp.add(bw, BorderLayout.WEST);
        cp.add(be, BorderLayout.EAST);
        //cp.add(bc, BorderLayout.CENTER);
        cp.add(p,BorderLayout.CENTER);
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

    public static void main(String [] args) {
       Border f = new Border();
       f.init();
        
    }
    
}
