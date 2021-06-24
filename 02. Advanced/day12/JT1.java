import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JT1 extends JFrame{
    JTable jt;
    String columnNames[] ={"��ȣ", "�̸�", "����ó", "��¥"};
    String rowData[][] ={
        {"10", "ȫ�浿", "01012345678", "21/06/24"},
        {"20", "�̰���", "01028232881", "21/06/24"},
        {"30", "������", "01084439554", "21/06/24"},
        {"40", "�����", "01012341237", "21/06/24"}, 
		{"50", "������", "01012341238", "21/06/24"}


    };

    void init(){
        Container cp = getContentPane();
		jt = new JTable(rowData, columnNames);
		JScrollPane sp = new JScrollPane(jt);
		cp.add(sp);

        setUI();
        test();
    }

    
	void test(){
		//(1) ���� ������ ( set / get )
		jt.setValueAt("Ŭ��", 2, 1);
		Object data = jt.getValueAt(3, 1);
		pln("data: " + data);

		//(2) ���� 
		int rc = jt.getRowCount();
		int cc = jt.getColumnCount();
		pln("rc: " + rc + ", cc: " + cc);

		//(3) �÷��̸� 
		String cn = jt.getColumnName(2);
		pln("cn: " + cn);
	}

    void setUI(){
		setTitle("JTable Test1");
		setSize(500, 200);
		setVisible(true);
		//setLocation(500, 100);
		setLocationRelativeTo(null); //�ػ󵵿� ������� ȭ���� ����� ����� 
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void pln(String str){
        System.out.println(str);

    }



    public static void main(String[] args) {

        JT1 jt1= new JT1();
        jt1.init();

        
    }
    
}
