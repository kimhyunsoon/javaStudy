import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class JT2 extends JFrame 
{
	JTable t;
	/*String columnNames[] = {"��ȣ", "�̸�", "����ó", "��¥"};
	String rowData[][] = {
		{"10", "ȫ�浿", "01012341234", "21/06/24"}, 
		{"20", "�̼���", "01012341235", "21/06/24"},
		{"30", "������", "01012341236", "21/06/24"}, 
		{"40", "�����", "01012341237", "21/06/24"}, 
		{"50", "������", "01012341238", "21/06/24"}
	};*/

    Vector<String> columnNames;
	Vector<Vector> rowData;
	JT2(){
		columnNames = new Vector<String>();
		columnNames.add("��ȣ");
		columnNames.add("�̸�");
		columnNames.add("����ó");
		columnNames.add("��¥");

		rowData = new Vector<Vector>();
		Vector<String> v1 = new Vector<String>();
		v1.add("10");v1.add("ȫ�浿");v1.add("01012341234");v1.add("21/06/24"); 
		Vector<String> v2 = new Vector<String>();
		v2.add("20");v2.add("�̼���");v2.add("01012341235");v2.add("21/06/24"); 
		Vector<String> v3 = new Vector<String>();
		v3.add("30");v3.add("������");v3.add("01012341236");v3.add("21/06/24"); 
		Vector<String> v4 = new Vector<String>();
		v4.add("40");v4.add("�����");v4.add("01012341237");v4.add("21/06/24"); 
		Vector<String> v5 = new Vector<String>();
		v5.add("50");v5.add("������");v5.add("01012341238");v5.add("21/06/24"); 

		rowData.add(v1);rowData.add(v2);rowData.add(v3);rowData.add(v4);rowData.add(v5);
	}
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
		setTitle("JTable Test2");
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
		JT2 jt = new JT2();
		jt.init();
	}
}
