import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JT1 extends JFrame 
{
	JTable t;
	String columnNames[] = {"��ȣ", "�̸�", "����ó", "��¥"};
	String rowData[][] = {
		{"10", "ȫ�浿", "01012341234", "21/06/24"}, 
		{"20", "�̼���", "01012341235", "21/06/24"},
		{"30", "������", "01012341236", "21/06/24"}, 
		{"40", "�����", "01012341237", "21/06/24"}, 
		{"50", "������", "01012341238", "21/06/24"}
	};
	void init(){
        Container cp = getContentPane();
		t = new JTable(rowData, columnNames);
		JScrollPane sp = new JScrollPane(t);
		cp.add(sp);

        setUI();
		test();
	}
	void test(){
		//(1) ���� ������ ( set / get )
		t.setValueAt("Ŭ��", 2, 1);
		Object data = t.getValueAt(3, 1);
		pln("data: " + data);

		//(2) ���� 
		int rc = t.getRowCount();
		int cc = t.getColumnCount();
		pln("rc: " + rc + ", cc: " + cc);

		//(3) �÷��̸� 
		String cn = t.getColumnName(2);
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
	public static void main(String[] args) 
	{
		JT1 jt = new JT1();
		jt.init();
	}
}
