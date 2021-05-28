import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalKaeun extends JFrame  
{
	Container cp;
	JPanel btnPad;
	JLabel label;
	JLabel info;
	int flag  = 0;
	int check = 0;
	JButton b1, b2, b3, b4;
	String labelArr[] = {
        "del","CE","C","¡À",
        "7","8","9","¡¿",
        "4","5","6","-",
        "1","2","3","+",
        "+/-","0",".","="
    };
	JButton btnArr[] = new JButton[labelArr.length];
	String eventText;
	

	
	void init(){
		setTextField();
		setPanel();
        cp = getContentPane();
        cp.add(label, BorderLayout.NORTH);
		cp.add(btnPad, BorderLayout.CENTER);
		setUI();
	}


	void setTextField(){
		label = new JLabel();
		Dimension d = new Dimension(300, 60);
		label.setPreferredSize(d);
		Font font = new Font("SansSerif", Font.PLAIN, 20);
		label.setFont(font);
		label.setHorizontalAlignment(JLabel.RIGHT);
		//label.setText("0");
		MouseAdapter listener = new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if (e.getClickCount() == 2) {
					flag = 0;
					label.setText(""); 
				}
			}
		}; 
		label.addMouseListener(listener);
	}
	
	
	
	void setPanel(){
        btnPad = new JPanel();
        btnPad.setLayout(new GridLayout(5, 4));
		MyListener01 myListener01 = new MyListener01(this);
		
		b1 = new JButton("del");
		b2 = new JButton("CE");
		b3 = new JButton("C");
		b4 = new JButton("¡À");

		btnPad.add(b1);
		btnPad.add(b2);
		btnPad.add(b3);
		btnPad.add(b4);

		btnArr[0] = new JButton("7");
		btnArr[1] = new JButton("8");
		btnArr[2] = new JButton("9");
		btnArr[3] = new JButton("¡¿");

		btnArr[4] = new JButton("4");
		btnArr[5] = new JButton("5");
		btnArr[6] = new JButton("6");
		btnArr[7] = new JButton("-");

		btnArr[8] = new JButton("1");
		btnArr[9] = new JButton("2");
		btnArr[10] = new JButton("3");
		btnArr[11] = new JButton("+");

		btnArr[12] = new JButton("+/-");
		btnArr[13] = new JButton("0");
		btnArr[14] = new JButton(".");
		btnArr[15] = new JButton("=");

		for(int i=0;i <btnArr.length ;i++){
			if(i%4 !=3 && i<11){
				btnPad.add(btnArr[i]);
				ActionListener listener = new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(flag ==0){
						
							JButton btn = (JButton)e.getSource();
							String oldText = label.getText();
							String text = btn.getText();
							String newText = oldText+text;
							pln(newText);
							label.setText(newText);
						}
						

						
					}
				};
				btnArr[i].addActionListener(listener);
				

			}else if (i%4 ==3 && i<15){
				btnPad.add(btnArr[i]);
				btnArr[i].addActionListener(myListener01);
			}
			else if (i==12){
				btnPad.add(btnArr[i]);
				btnArr[i].addActionListener(myListener01);
			}else if(i==13){
				btnPad.add(btnArr[i]);
				btnArr[i].addActionListener(myListener01);
			}else if(i==14){
				btnPad.add(btnArr[i]);
				btnArr[i].addActionListener(myListener01);
			}
			else if(i==15){
				btnPad.add(btnArr[i]);

				btnArr[i].addActionListener(myListener01);
			}



		}


	}


	void setUI(){
		setTitle("Cal Ver 1.0");
		setSize(300, 400);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new CalKaeun().init();
	}
}



class Handler implements ActionListener
{
	CalKaeun calk;
	Handler(CalKaeun calk){
		this.calk = calk;
	}


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();
        int n = calk.label.getText().length();
		Character c = calk.label.getText().charAt(n-1);
        
    }


	void pln(String str){
        System.out.println(str);

    }


}









	
	
	
// 	btnPad.add(btnArr[i]);
// }