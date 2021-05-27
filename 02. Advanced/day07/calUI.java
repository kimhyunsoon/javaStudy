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

		for (int i = 0; i < labelArr.length; i++) {
            btnArr[i] = new JButton(labelArr[i]);
            if(labelArr[i].equals("")){
                btnArr[i].setVisible(false);
            }
            p.add(btnArr[i]);
			btnArr[i].addActionListener(handler);
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
		new CalUI().init();
	}
}
