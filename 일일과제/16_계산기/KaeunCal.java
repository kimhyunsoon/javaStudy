import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KaeunCal extends JFrame{
    Container calWrap;
    JPanel btnPad;
    JTextField input;
    String labelArr[] = {
        "%","CE","C","del",
        "1/x","x��","����x","��",
        "7","8","9","��",
        "4","5","6","?",
        "1","2","3","+",
        "+/-","0",".","="
    };
    JButton btnArr[];
    
    KaeunCal(){
        btnArr = new JButton[labelArr.length];
    }

    void init(){
        // pp = new JPanel();
        calWrap = getContentPane();
        //ContentPane�� JFrame ��ü�� ó�� ���� �� �ڵ����� �����Ǵµ� �װ� �˾Ƴ�����
        input = new JTextField(); //TextFiled ����
        btnPad = new JPanel(); //������Ʈ�� ���� �г� ����
        btnPad.setLayout(new GridLayout(6,4));

        for (int i = 0; i < labelArr.length; i++) {
            btnArr[i] = new JButton(labelArr[i]);
            if(labelArr[i].equals("")){
                btnArr[i].setVisible(false);
            }
            btnPad.add(btnArr[i]);
        }

        calWrap.add(input, BorderLayout.CENTER);
        calWrap.add(btnPad, BorderLayout.SOUTH);
        setUI();
    }
    
    
    void setUI(){
		setTitle("����");
		setSize(300, 260);
		setVisible(true);
		setLocation(200, 100);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public static void main(String [] args) {
        KaeunCal view = new KaeunCal();
        view.init();
    }
    
}
