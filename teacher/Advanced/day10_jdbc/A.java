import java.sql.*;

class A
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	String usr = "scott";
	String pwd = "tiger";

	Connection con;
    Statement stmt;
	A(){
		//(1) Driver �ε� 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pln("(1) ����̹� �ε� ����");
		}catch(ClassNotFoundException cnfe){
			pln("(1) ����̹� �ε� ����");
		}
		//(2) DB ���� 
		try{
			con = DriverManager.getConnection(url, usr, pwd);
			pln("(2) DB�� ���� ���� con: " + con);
		}catch(SQLException se){
			pln("(2) DB�� ���� ����: " + se);
		}
		//(3) Statement ���� 
		try{
			stmt = con.createStatement();
			pln("(3) stmt ���� ����");
		}catch(SQLException se){
			pln("(3) stmt ���� ����");
		}
		
		//createT();
		//createTnoExist(); //�̼�!! 
		//dropT();

		//insertD(10, "ȫ�浿", "01012341234");
		//insertD(20, "�̼���", "01012341235");
		//insertD(30, "������", "01012341236");
		//updateD(20, "������", "01912341235");
        //deleteD(10);
		//deleteD("��");
  
        selectD();
		closeAll();
	}

    //[1] DDL 
	String tname = "JDBCT";
	void createT(){
		String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar2(10), PHONE varchar2(11), RDATE date)";
		//(4) Statement ���� 
		try{
			stmt.execute(sql);
			pln("(4) " +tname+"���̺� ���� ����");
		}catch(SQLException se){
            pln("(4) " +tname+"���̺� ���� ����");
		}
	}
	void createTnoExist(){
        String sql = "select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";
		//���߿� �� �غ�! 
	}
	void dropT(){
		String sql = "drop table "+tname;
		String purge = "purge recyclebin";
		try{
			stmt.execute(sql);
			stmt.execute(purge);
			pln("(4) " +tname+"���̺� ���� ����");
		}catch(SQLException se){
			pln("(4) " +tname+"���̺� ���� ����");
		}
	}

    //[2] DML 
	void insertD(int no, String name, String phone){
		String sql = "insert into "+tname+" values("+no+", '"+name+"', '"+phone+"', SYSDATE)";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+ i+"���� row �Է� ����");
			}else{
				pln(i+"���� row �Է� ����");
			}
		}catch(SQLException se){
			pln("�Է� ���� se: " + se); 
		}
	}
	void updateD(int no, String name, String phone){
		String sql = "update "+tname+" set name='"+name+"', phone='"+phone+"' where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"���� row ���� ����");
			}else{
				pln(i+"���� row ���� ����");
			}
		}catch(SQLException se){
			pln("���� ���� se: " + se); 
		}
	}
	void deleteD(int no){
		String sql = "delete from "+tname+" where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"���� row ���� ����");
			}else{
				pln(i+"���� row ���� ����");
			}
		}catch(SQLException se){
			pln("���� ���� se: " + se); 
		}
	}
	void deleteD(String name){
        String sql = "delete from "+tname+" where NAME like '%"+name+"%'";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"���� row ���� ����");
			}else{
				pln(i+"���� row ���� ����");
			}
		}catch(SQLException se){
			pln("���� ���� se: " + se); 
		}
	}

    //[DQL]
    void selectD(){
		ResultSet rs = null;
		String sql = "select * from "+tname+" order by RDATE desc";
		try{
			rs = stmt.executeQuery(sql);
			pln("(4) rs ���� ����");
			System.out.println("NO \t NAME \t PHONE \t RDATE");
			System.out.println("-----------------------------------------");
			while(rs.next()){
				//int no = rs.getInt(1);
				int no = rs.getInt("NO");
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Date rdate = rs.getDate(4);
				pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
			}
			pln("(5) ������ ���� ����");
		}catch(SQLException se){
			pln("selectD() ����: "+ se);
		}finally{
			try{
				rs.close();
				pln("(6) rs ��ü �ݱ� ����");
			}catch(SQLException se){}
		}
	}
	void closeAll(){
		try{
			stmt.close();
			con.close();
			pln("(6)���� ��ü �ݱ� ����");
		}catch(SQLException se){
			pln("(6)���� ��ü �ݱ� ����");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		new A();
	}
}
