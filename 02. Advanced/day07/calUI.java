import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalUI extends JFrame  
{
	Container cp;
	JFormattedTextField tfield;
	JPanel p;
	String labelArr[] = {
       
        "del","CE","C","��",
        "7","8","9","��",
        "4","5","6","-",
        "1","2","3","+",
        "+/-","0",".","="
    };
	JButton btnArr[] = new JButton[labelArr.length];


	
	void init(){
		setTextField();
		setPanel();

        cp = getContentPane();
        cp.add(tfield, BorderLayout.NORTH);
		cp.add(p, BorderLayout.CENTER);

		setUI();
	}
	void setTextField(){
		tfield = new JFormattedTextField();
		Dimension d = new Dimension(300, 60);
		tfield.setPreferredSize(d);
		Font font = new Font("SansSerif", Font.PLAIN, 20);
		tfield.setFont(font);
		tfield.setHorizontalAlignment(JTextField.RIGHT);
		tfield.setValue(0);
		KeyListener listener = new KeyAdapter(){
			int i=0;
			public void keyTyped(KeyEvent e){
				if(i==0) tfield.setText("");
				i++;
			}
		}; 
		//KeyListener: Ű �Է��� �����ϱ� ���� �������̽�
		//keyAdapter : Ű�����̺�Ʈ�� �ޱ� ���� �߻�Ŭ����. �� Ŭ������ Ȯ���Ͽ� 
		//KeyEventListener�� ����� �����ִ� �̺�Ʈ�� ���ؼ��� �����Ͽ� ����ϸ� ��
		
		tfield.addKeyListener(listener);
	}
	
	void setPanel(){
        p = new JPanel();
        p.setLayout(new GridLayout(5, 4));
		ButtonHandler handler = new ButtonHandler(this);




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
		new CalUI().init();
	}
}





// btnArr[0] = new JButton("del");
// btnArr[1] = new JButton("CE");
// btnArr[2] = new JButton("C");
// btnArr[3] = new JButton("��");

// btnArr[4] = new JButton("7");
// btnArr[5] = new JButton("8");
// btnArr[6] = new JButton("9");
// btnArr[7] = new JButton("��");

// btnArr[8] = new JButton("4");
// btnArr[9] = new JButton("5");
// btnArr[10] = new JButton("6");
// btnArr[11] = new JButton("-");

// btnArr[12] = new JButton("+/-");
// btnArr[13] = new JButton("0");
// btnArr[14] = new JButton(".");
// btnArr[15] = new JButton("=");

// btnArr[16] = new JButton("1");
// btnArr[17] = new JButton("2");
// btnArr[18] = new JButton("3");
// btnArr[19] = new JButton("+");
