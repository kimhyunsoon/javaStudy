import java.io.*;
import java.sql.*;

public class KimSqlplus {
	String url="jdbc:oracle:thin:@";
	String usr="scott";
	String pwd="tiger";
	String userip;
	String usersid;
	String userid;
	String userpwd;
	
	Connection con;
	Statement stmt;
	String command;
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	KimSqlplus(){
		try {
			System.out.print("Oracle IP(default: 127.0.0.1) : ");
			userip=br.readLine();
			if(userip!=null) {
				userip=userip.trim();
			}
			if(userip.length()==0) {
				userip="127.0.0.1";
			}
			System.out.print("Oracle SID(default: JAVA) : ");
			usersid=br.readLine();
			if(usersid!=null) {
				usersid=usersid.trim();
			}
			if(usersid.length()==0) {
				usersid="JAVA";
			}
			url=url+userip+":1521:"+usersid;
			System.out.print("ID(default: scott) : ");
			userid=br.readLine();
			if(userid!=null) {
				userid=userid.trim();
			}
			if(userid.length()==0) {
				userid=usr;
			}
			System.out.print("PWD(default: tiger) : ");
			userpwd=br.readLine();
			if(userpwd!=null) {
				userpwd=userpwd.trim();
			}
			if(userpwd.length()==0) {
				userpwd=pwd;
			}
			connect();
		}catch(IOException ie) {
		}
	}
	void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("(1) ����̹� �ε� ����");
		}catch(ClassNotFoundException ce) {
			//System.out.println("(1) ����̹� �ε� ����");
		}
		
		try {
			con=DriverManager.getConnection(url,userid,userpwd);
			//System.out.println("(2) DB�� ���� ����"+con);
		}catch(SQLException se) {
			//System.out.println("(2) DB�� ���� ����");
		}
		
		try {
			stmt=con.createStatement();
			//System.out.println("(3) stmt ���� ����");
		}catch(SQLException se) {
			//System.out.println("(3) stmt ���� ����");
		}
		
		loadSQL();
	}
	void loadSQL() {
		try {
			System.out.print("SQL>");
			command=br.readLine();
			if(command!=null) {
				command=command.trim();
			}
			if(command.length()==0) {
				loadSQL();
			}
			if(command.contains(";")) {
				command=command.substring(0,command.length()-1);
			}
			if(command.startsWith("create table")) {
				createTnoExist();
			}else if(command.startsWith("drop table")) {
				dropT();
			}else if(command.startsWith("alter table")) {
				alterT();
			}else if(command.startsWith("insert")) {
				conductDML();
			}else if(command.startsWith("update")) {
				conductDML();
			}else if(command.startsWith("delete")) {
				conductDML();
			}else if(command.startsWith("select")) {
				selectD();
			}else if(command.equals("exit")) {
				closeAll();
				System.exit(0);
			}else {
				System.out.println("�߸��� SQL�� �Դϴ�.");
				loadSQL();
			}
		}catch(IOException ie) {
			//System.out.println("����� ����");
		}
	}
	void createTnoExist() {
		ResultSet rs=null;
		try {
			int idx=command.indexOf(' ',13);
			String tname=command.substring(13,idx);
			System.out.println(tname);
			String sql="select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";
			
			rs=stmt.executeQuery(sql);
			boolean flag=rs.next();
			if(!flag) {
				createT();
			}
		}catch(StringIndexOutOfBoundsException be) {
			System.out.println("�߸��� SQL�� �Դϴ�.");
			loadSQL();
		}catch(SQLException se) {
		}finally {
			try {
				if(rs!=null) rs.close();
			}catch(SQLException se) {
				
			}
		}
	}
	void createT() {
		String sql=command;
		try {
			stmt.execute(sql);
			System.out.println("create�� ����");
			loadSQL();
		}catch(SQLException se) {
			System.out.println("create�� ����");
			loadSQL();
		}
	}
	void dropT() {
		String sql=command;
		String purge="purge recyclebin";
		try {
			stmt.execute(sql);
			stmt.execute(purge);
			System.out.println("drop�� ����");
			loadSQL();
		}catch(SQLException se) {
			System.out.println("drop�� ����");
			loadSQL();
		}
	}
	void alterT() {
		String sql=command;
		try {
			stmt.execute(sql);
			System.out.println("alter�� ����");
			loadSQL();
		}catch(SQLException se) {
			System.out.println(se);
			System.out.println("alter�� ����");
			loadSQL();
		}
	}
	void conductDML() {
		String sql=command;
		try {
			int i=stmt.executeUpdate(sql);
			if(i>0) {
				System.out.println(i+"���� row ���� �Ϸ�");
			}else {
				System.out.println(i+"���� row ���� ����");
			}
			loadSQL();
		}catch(SQLException se) {
			System.out.println("DML�� ����");
			loadSQL();
		}
	}
	void selectD() {
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		String sql=command;
		try {
			rs=stmt.executeQuery(sql);
			 rsmd=rs.getMetaData();
			
			int columns=rsmd.getColumnCount();
			for(int i=1; i<=columns; i++) {
				String name=rsmd.getColumnName(i);
				System.out.print(name+"\t");
			}
			System.out.println();
			for(int i=0; i<columns; i++) {
				System.out.print("----------");
			}
			System.out.println();
			while(rs.next()) {
				for(int i=1; i<=columns; i++) {
					//System.out.println(rsmd.getColumnType(i));
					if(rsmd.getColumnType(i)==2) { 
						System.out.print(rs.getInt(i)+"\t");
					}else if(rsmd.getColumnType(i)==12) {
						System.out.print(rs.getString(i)+"\t");
					}else if(rsmd.getColumnType(i)==93) {
						System.out.print(rs.getDate(i)+"\t");
					}else {
						System.out.print(rs.getString(i)+"\t");
					}
				}
				System.out.println();
			}
			loadSQL();
		}catch(SQLException se) {
			System.out.println(se);
			System.out.println("�߸��� SQL�� �Դϴ�.");
			loadSQL();
		}finally {
			try {
				rs.close();
			}catch(SQLException se) {
			}
		}
	}
	void closeAll() {
		try {
			stmt.close();
			con.close();
			//System.out.println("���� ��ü �ݱ� ����");
		}catch(SQLException se) {
			//System.out.println("���� ��ü �ݱ� ����");
		}
	}
	public static void main(String[] args) {
		new KimSqlplus();
	}
}
