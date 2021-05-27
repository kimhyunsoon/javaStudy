package soon.calView;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame{
	private int a = 0, b = 12;
	JButton[] label = new JButton[16];
	String[] cal = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "CE", "계산", "+", "-", "*", "/"};
	JPanel up = new JPanel();
	JPanel mid = new JPanel();
	JPanel down = new JPanel();
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	
	public Calculator() {
		setTitle("산술 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		up.setLayout(new FlowLayout());
		mid.setLayout(new GridLayout(4, 4, 5, 5));
		down.setLayout(new FlowLayout());

		up.setBackground(Color.LIGHT_GRAY);
		mid.setBackground(Color.WHITE);
		down.setBackground(Color.YELLOW);
		
		up.add(new JLabel("연산수식"));
		up.add(tf1);
		
		for(int i = 0 ; i < 16 ; i++) {
			label[i] = new JButton(cal[i]);
			if(i >=12 ) 
				label[i].setBackground(Color.CYAN);
			mid.add(label[i]);
		}
		
		
		for(int i = 0 ; i < 16 ; i++) {
			if(i <= 9 || i >= 12) { 
				label[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton tempButton = (JButton) e.getSource();
						String s1 = tf1.getText();
						tf1.setText(s1 + tempButton.getText());
					}
				});
			}
		}
		
		// 버튼 처리
		label[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
			}
		});
		
		// 자바스크립트에서 eval 함수 가져옴
		label[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			    	ScriptEngineManager mgr = new ScriptEngineManager();
			        ScriptEngine engine = mgr.getEngineByName("JavaScript");
			        String evalValue = tf1.getText();
			        String tfOutput = String.valueOf(engine.eval(evalValue));
			        tf2.setText(tfOutput);

				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		down.add(new JLabel("계산결과"));
		down.add(tf2);
		
		c.add(up, BorderLayout.NORTH);
		c.add(mid, BorderLayout.CENTER);
		c.add(down, BorderLayout.SOUTH);
		
		setSize(400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}