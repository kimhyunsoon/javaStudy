import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jdk.internal.platform.Container;

import java.io.*;

public class GUI22 extends JPanel{

    Container cp;
    JPanel bp;
    JButton clearBtn, openBtn, closeBtn;
    JFileChooser jf;
    JTextArea jt;
    Strign newline = "\n";
    
    void init(){
        clearBtn = new JButton();
        clearBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jt.setText("");
            }
        });

        openBtn = new JButton();
        openBtn.addAc
    }
    
    



    void setUI(){
		setTitle("FileChooser");
		setSize(500, 800);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String[] args){
        new GUI22();

    }
    
}
