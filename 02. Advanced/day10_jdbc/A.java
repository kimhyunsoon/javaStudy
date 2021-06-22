import java.sql.*;

class A
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
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
        createTable();
        //closeAll();
	}

    String tname = "JDBCT";
    void createTable(){       
        
        String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar2(10), PHONE varchar2(11), RDATE date)";

        //(4)Statement ����
        try {
            stmt.execute(sql);
            pln("(4) : "+tname+" ���̺� ���� ����");

        } catch (SQLException se) {
            pln("(4) " +tname+"���̺� ���� ����");
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
