import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.io.*;
import java.util.*;

public class JT extends JFrame implements ActionListener,MouseListener,KeyListener{
	Container cp;
	JPanel jp1,jp2,jp3;
	JTextField text1,text2,text3,text4;
	JButton btn1,btn2,btn3;
	JComboBox<String> box;
	JTable table;
	Vector<String> columnNames;
	Vector<Vector> rowData;
	
	File f;
	FileReader fr;
	BufferedReader br;
	ArrayList<String> list=new ArrayList<String>();
	String url,usr,pwd;
	Connection con;
	Statement stmt;
	
	JT(){
		try {
			f=new File("setting.txt");
			fr=new FileReader(f);
			br=new BufferedReader(fr);
			
			String line="";
			while((line=br.readLine())!=null) {
				list.add(line);
			}
			url=list.get(0);
			usr=list.get(1);
			pwd=list.get(2);
			
			//����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("(1) ����̹� �ε� ����");
			
			con=DriverManager.getConnection(url,usr,pwd);
			System.out.println("(2) DB�� ���� ����"+con);
			
			stmt=con.createStatement();
			System.out.println("(3) stmt ���� ����");
			
			init();
		}catch(SQLException se) {
			System.out.println("(2) DB�� ���� ����/(3) stmt ���� ����");
		}catch(ClassNotFoundException ce) {
			System.out.println("(1) ����̹� �ε� ����");
		}catch(IOException ie) {
			System.out.println("���� ����� ����");
		}finally {
			try {
				if(br!=null) br.close();
				if(fr!=null) fr.close();
			}catch(IOException ie) {
			}
		}
	}
	void selectT() {
		columnNames=new Vector<String>();
		rowData=new Vector<Vector>();
		
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		String sql="select * from dept";
		try {
			rs=stmt.executeQuery(sql);
			rsmd=rs.getMetaData();
			
			int columns=rsmd.getColumnCount();
			for(int i=1; i<=columns; i++) {
				columnNames.add(rsmd.getColumnName(i));
			}
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				
				for(int i=1; i<=columns; i++) {
					v.add(rs.getString(i));
				}
				rowData.add(v);
			}
		}catch(SQLException se) {
			System.out.println("select�� ����");
		}finally {
			try {
				rs.close();
			}catch(SQLException se) {
			}
		}
	}
	void reloadT() {
		rowData.clear();
		
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		String sql="select * from dept";
		try {
			rs=stmt.executeQuery(sql);
			rsmd=rs.getMetaData();
			
			int columns=rsmd.getColumnCount();
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				
				for(int i=1; i<=columns; i++) {
					v.add(rs.getString(i));
				}
				rowData.add(v);
			}
		}catch(SQLException se) {
			System.out.println("reload ����");
		}
	}
	void insertD(String deptno,String dname,String loc) {
		if(deptno.length()==0) {
			warning();
		}
		
		text2.setText("");
		text3.setText("");
		text4.setText("");
		
		String sql="insert into DEPT values("+deptno+",'"+dname+"','"+loc+"')";
		
		try {
			int i=stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println(i+"���� row ���� �Ϸ�");
			}else {
				System.out.println(i+"���� row ���� ����");
			}
		}catch(SQLException se) {
			System.out.println("DML�� ����");
		}
	}
	void updateD(String deptno,String dname,String loc) {
		if(deptno.length()==0) {
			warning();
		}
		
		text2.setText("");
		text3.setText("");
		text4.setText("");
		
		String sql="update DEPT set DNAME='"+dname+"',LOC='"+loc+"' where DEPTNO="+deptno;
		
		try {
			int i=stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("update �Ϸ�");
			}else {
				System.out.println("update ����");
			}
		}catch(SQLException se) {
			System.out.println("UPDATE�� ����");
		}
	}
	void deleteD(String deptno) {
		if(deptno.length()==0) {
			warning();
		}
		
		text2.setText("");
		text3.setText("");
		text4.setText("");
		
		String sql="delete DEPT where DEPTNO="+deptno;
		
		try {
			int i=stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println("delete �Ϸ�");
			}else {
				System.out.println("delete ����");
			}
		}catch(SQLException se) {
			System.out.println("DELETE�� ����");
		}
	}
	void warning() {
		JOptionPane.showMessageDialog(null, "�߸��� PK �÷��Դϴ�.","�޽���",
				JOptionPane.WARNING_MESSAGE);
	}
	void search(String ques) {
		String menu=box.getSelectedItem().toString();
		
		rowData.clear();
		
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		String sql="select * from DEPT where "+menu+" like '%"+ques+"%'";
		System.out.println(sql);
		try {
			rs=stmt.executeQuery(sql);
			rsmd=rs.getMetaData();
			
			int columns=rsmd.getColumnCount();
			while(rs.next()) {
				Vector<String> v=new Vector<String>();
				
				for(int i=1; i<=columns; i++) {
					v.add(rs.getString(i));
				}
				rowData.add(v);
			}
		}catch(SQLException se) {
			System.out.println("search ����");
		}
	}
	void init() {
		selectT();
		
		table=new JTable(rowData,columnNames);
		JScrollPane sp=new JScrollPane(table);
		table.addMouseListener(this);
		
		int rc=table.getRowCount();
		int cc=table.getColumnCount();
		System.out.println("rc: "+rc+", cc: "+cc);
		
		box=new JComboBox<String>(columnNames);
		text1=new JTextField();
		text1.addKeyListener(this);

		jp1=new JPanel();
		jp1.setLayout(new GridLayout(1,2));
		jp1.add(box);
		jp1.add(text1);
		
		jp2=new JPanel();
		jp2.add(sp);
		
		text2=new JTextField();
		text3=new JTextField();
		text4=new JTextField();
		btn1=new JButton("�߰�");
		btn2=new JButton("����");
		btn3=new JButton("����");
		jp3=new JPanel();
		jp3.setLayout(new GridLayout(2,3));
		jp3.add(text2); jp3.add(text3); jp3.add(text4);
		jp3.add(btn1); jp3.add(btn2); jp3.add(btn3);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(jp1,BorderLayout.NORTH);
		cp.add(jp2,BorderLayout.CENTER);
		cp.add(jp3,BorderLayout.SOUTH);

		setUI();
	}
	void setUI() {
		setTitle("JTable SQL");
		setSize(460,450);
		setVisible(true);
		setLocationRelativeTo(null);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		Object obj=ae.getSource();
		
		if(obj==btn1) { //�߰�
			insertD(text2.getText().trim(),text3.getText().trim(),text4.getText());
			reloadT();
			table.updateUI();
		}else if(obj==btn2) { //����
			updateD(text2.getText().trim(),text3.getText().trim(),text4.getText());
			reloadT();
			table.updateUI();
		}else if(obj==btn3) { //����
			deleteD(text2.getText().trim());
			reloadT();
			table.updateUI();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		System.out.println("row: "+row);
		String[] data=new String[3];
		data=(String[])rowData.get(row).toArray(data);
		text2.setText(data[0]);
		text2.setEnabled(false);
		text3.setText(data[1]);
		text4.setText(data[2]);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		String ques=text1.getText();
		search(ques);
		table.updateUI();
	}
	public static void main(String[] args) {
		new JT();
	}
}
