import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class JTvector extends JFrame{
    JTable jt;
    Vector<String> columnNames;
    Vector<Vector> rowData;


    JTvector(){
        columnNames = new Vector<String>();
		columnNames.add("번호");
		columnNames.add("이름");
		columnNames.add("연락처");
		columnNames.add("날짜");

		rowData = new Vector<Vector>();
		Vector<String> v1 = new Vector<String>();
		v1.add("10");v1.add("홍길동");v1.add("01012341234");v1.add("21/06/24"); 
		Vector<String> v2 = new Vector<String>();
		v2.add("20");v2.add("이순신");v2.add("01012341235");v2.add("21/06/24"); 
		Vector<String> v3 = new Vector<String>();
		v3.add("30");v3.add("강감찬");v3.add("01012341236");v3.add("21/06/24"); 
		Vector<String> v4 = new Vector<String>();
		v4.add("40");v4.add("김명훈");v4.add("01012341237");v4.add("21/06/24"); 
		Vector<String> v5 = new Vector<String>();
		v5.add("50");v5.add("강정구");v5.add("01012341238");v5.add("21/06/24"); 

		rowData.add(v1);rowData.add(v2);rowData.add(v3);rowData.add(v4);rowData.add(v5);
    }

    void init(){
        Container cp = getContentPane();
		jt = new JTable(rowData, columnNames);
		JScrollPane sp = new JScrollPane(jt);
		cp.add(sp);

        setUI();
        test();
    }

    
	void test(){
		//(1) 임의 데이터 ( set / get )
		jt.setValueAt("클락", 2, 1);
		Object data = jt.getValueAt(3, 1);
		pln("data: " + data);

		//(2) 갯수 
		int rc = jt.getRowCount();
		int cc = jt.getColumnCount();
		pln("rc: " + rc + ", cc: " + cc);

		//(3) 컬럼이름 
		String cn = jt.getColumnName(2);
		pln("cn: " + cn);
	}

    void setUI(){
		setTitle("JTable Test1");
		setSize(500, 200);
		setVisible(true);
		//setLocation(500, 100);
		setLocationRelativeTo(null); //해상도와 관계없이 화면의 가운데에 띄워줌 
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void pln(String str){
        System.out.println(str);

    }



    public static void main(String[] args) {

        JTvector jt2= new JTvector();
        jt2.init();

        
    }
    
}
