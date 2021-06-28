import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JT1 extends JFrame{
    JTable jt;
    String columnNames[] ={"번호", "이름", "연락처", "날짜"};
    String rowData[][] ={
        {"10", "홍길동", "01012345678", "21/06/24"},
        {"20", "이가은", "01028232881", "21/06/24"},
        {"30", "김현순", "01084439554", "21/06/24"},
        {"40", "김명훈", "01012341237", "21/06/24"}, 
		{"50", "강정구", "01012341238", "21/06/24"}


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

        JT1 jt1= new JT1();
        jt1.init();

        
    }
    
}
