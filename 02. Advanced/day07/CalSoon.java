import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.*;
import javax.script.ScriptEngineManager; 
import javax.script.ScriptEngine;


public class CalSoon extends JFrame{
    Container calWrap;
    JPanel emptyNorth;
    JPanel btnPad;
    JLabel info;
    JLabel input;
    String labelArr[] = {
        "%","CE","C","del",
        "1/x","x��","����x","��",
        "7","8","9","��",
        "4","5","6","-",
        "1","2","3","+",
        "+/-","0",".","="
    };
    JButton btnArr[] = new JButton[labelArr.length];

    ArrayList<Double> numbers = new ArrayList<>();
    ArrayList<String> fomulas = new ArrayList<>();
    

    

    void init(){
        Font font18 = new Font("���� ���", Font.BOLD, 18);
        Font font16 = new Font("���� ���", Font.PLAIN, 16);
        
        calWrap = getContentPane();
        info= new JLabel();
        input = new JLabel();
        emptyNorth = new JPanel();
        btnPad = new JPanel();
        btnPad.setLayout(new GridLayout(6,4));

        String infoMsg = "����� ���ּ���";

        info.setText(infoMsg);
        for (int i = 0; i < labelArr.length; i++) {
            btnArr[i] = new JButton(labelArr[i]);
            char tmp = labelArr[i].charAt(0);
            // input.setText("0");
            if (Character.isDigit(tmp) || labelArr[i] == ".") { // ���ڳ� . �϶�
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JButton btnArr = (JButton) e.getSource();
                        input.setText(input.getText()+btnArr.getText());
                    }
                });
            } else if(labelArr[i].equals("+") || labelArr[i].equals("-") || labelArr[i].equals("��") || labelArr[i].equals("��")){
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JButton btnArr = (JButton) e.getSource();

                        if(input.getText().length() != 0){
                            if(input.getText().indexOf(".") == 0 || input.getText().indexOf(".") == input.getText().length()-1){
                                info.setText(info.getText().replace(infoMsg, "") + input.getText().replace(".", "") + btnArr.getText());
                            }else {
                                info.setText(info.getText().replace(infoMsg, "") + input.getText() + btnArr.getText());
                            }
                            input.setText("");
                        }
                    }
                });
            }else if(labelArr[i].equals("CE")){
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        info.setText(infoMsg);
                        input.setText("");
                    }
                });
            } else if(labelArr[i].equals("C")){
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(input.getText().length() != 0){
                            input.setText(input.getText().substring(0, input.getText().length()-1));
                        }
                    }
                });
            } else if(labelArr[i].equals("=")){
                btnArr[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        info.setText(info.getText() + input.getText());
                        String s = info.getText().replace("��","/").replace("��","*");
                        
                        ArrayList<BigDecimal> numList = new ArrayList<BigDecimal>(); //���ڰ���
                        ArrayList<Character> opList = new ArrayList<Character>(); //������ ����
                        
                        String num = ""; 
                        for(int i = 0; i < s.length(); i++) {
                            char ch = s.charAt(i); //string�� char Ÿ�� ������ ����
        
                            if(ch == '+' || ch =='-' || ch == '*' || ch == '/') {
                                numList.add(new BigDecimal(num));
                                opList.add(ch); //�����ڸ� �����ڹ迭�� �߰�
                                num = ""; //�ӽ÷� ����� ���ڸ� ����ش�                   
                                continue; //���� ����� ��ɹ����� �̵�
                            }
                            num += ch; //������ �ձ����� ���ڸ� �ӽ÷� �־� ����
                        }
                        numList.add(new BigDecimal(num)); //������ ����
                        
                        int cnt = opList.size();
                        for (int k = 0; k < cnt; k++) {
                            int me = 0;
                            if(opList.contains('*')){
                                me = opList.indexOf('*');
                                numList.set(me, numList.get(me).multiply(numList.get(me+1)));
                            } else if(opList.contains('/')){
                                me = opList.indexOf('/');
                                numList.set(me, numList.get(me).divide(numList.get(me+1)));
                            } else if(opList.contains('+')){
                                me = opList.indexOf('+');
                                numList.set(me, numList.get(me).add(numList.get(me+1)));
                            } else if(opList.contains('-')){
                                me = opList.indexOf('-');
                                numList.set(me, numList.get(me).subtract(numList.get(me+1)));
                            }
                            opList.remove(me);
                            numList.remove(me+1);
                            cnt--;
                            k--;
                        }
                        input.setText(numList.get(0).toString());
                        info.setText("");
                    }
                });
            }
            btnPad.add(btnArr[i]);
        }

        info.setFont(font16);
        input.setFont(font18);
        btnPad.setFont(font16);

        info.setHorizontalAlignment(JLabel.RIGHT);
        input.setHorizontalAlignment(JLabel.RIGHT);
        calWrap.add(info, BorderLayout.NORTH);
        calWrap.add(input, BorderLayout.CENTER);
        calWrap.add(btnPad, BorderLayout.SOUTH);
        setUI();
    }
    
    
    void setUI(){
		setTitle("����");
		setSize(300, 280);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
        CalSoon view = new CalSoon();
        view.init();
    }
    
}
