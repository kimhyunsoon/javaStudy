import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalGUI extends JFrame{

    Container cp;
	JPanel btnPad;
	JLabel input;
	JLabel info;
    int flag;
    String labelArr[] = {
        "CE","C","del","÷",
        "7","8","9","×",
        "4","5","6","-",
        "1","2","3","+",
        "+/-","0",".","="
    };
    JButton btnArr[] = new JButton[labelArr.length];

    void init(){
        cp = getContentPane();
        setLabel();
        setPad();
        cp.add(info, BorderLayout.NORTH);
		cp.add(input, BorderLayout.CENTER);
        cp.add(btnPad, BorderLayout.SOUTH);
        setUI();


    }


    void setLabel(){
		input = new JLabel();
        info = new JLabel();
		Dimension d = new Dimension(300, 60);
		input.setPreferredSize(d);

		Font font20 = new Font("SansSerif", Font.BOLD, 20);
        Font font16 = new Font("SansSerif", Font.PLAIN, 16);
		input.setFont(font20);
        info.setFont(font16);
		input.setHorizontalAlignment(JLabel.RIGHT);
        info.setHorizontalAlignment(JLabel.RIGHT);
		
	}


    void setPad(){
        btnPad = new JPanel();
        btnPad.setLayout(new GridLayout(5, 4));

        for(int i = 0; i<labelArr.length; i++){
            btnArr[i] = new JButton(labelArr[i]);
            char tmp = labelArr[i].charAt(0);

            if(Character.isDigit(tmp) || labelArr[i].equals(".")){ //지정된 문자가 숫자인지 판별
                //숫자나 .이 입력됐을 때
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        JButton btnArr =(JButton)e.getSource(); //명시적형변환
                        String btn = btnArr.getText();
                        String iptext = input.getText();
                        //pln(input);
                        input.setText(iptext+btn);  
                    }
                });

            }else if(labelArr[i].equals("+") ||labelArr[i].equals("-")|| labelArr[i].equals("×") ||labelArr[i].equals("÷")){ //연산기호
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        JButton btnArr = (JButton)e.getSource(); //명시적형변환
                        String btn = btnArr.getText();
                        String iptext = input.getText();
                        String infotext = info.getText();

                        if(iptext.length() != 0){
                            if(iptext.indexOf(".") == 0 || iptext.indexOf(".") ==iptext.length()-1){
                                info.setText(infotext+iptext.replace(".", "")+btn);
                            }else{
                                info.setText(infotext+iptext+btn);
                            }
                            input.setText("");
                        }
                    }
                });
                
            }else if(labelArr[i].equals("CE")){ //delete input
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        String iptext = input.getText();
                        if(iptext.length() != 0){
                            input.setText("");
                        }
                    }
                });

            }else if(labelArr[i].equals("C")){ //delete all
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        info.setText("");
                        input.setText("");
                    }
                });

            }else if(labelArr[i].equals("del")){ //delete one character
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        String iptext = input.getText();
                        if(iptext.length() != 0){
                            input.setText(iptext.substring(0,iptext.length()-1));
                        }
                    }
                });
            }else if(labelArr[i].equals("=")){
                CalHandler ch = new CalHandler(this);
                btnArr[i].addActionListener(ch);

            }
            btnPad.add(btnArr[i]);

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


    public static void main(String[] args) {
        new CalGUI().init();
    }
    
}
