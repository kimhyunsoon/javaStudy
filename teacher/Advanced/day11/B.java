import java.sql.*;

//CallableStatement 
class B
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	Connection con;
	CallableStatement cstmt;
	String sql = "call incre(?, ?)";
	B(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			cstmt = con.prepareCall(sql);
		}catch(ClassNotFoundException cnfe){
			pln("����Ŭ ����̹�(����ŬDBMS������ JDBC�� ������ Ŭ����)�� ã�� ����");
		}catch(SQLException se){}
	}
	void call(){
		try{
			cstmt.setInt(1, 7369);
			cstmt.setFloat(2, 0.1f);
			cstmt.execute();
			pln("ȣ�� ����");
		}catch(SQLException se){
            pln("ȣ�� ����");
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		B b = new B();
		b.call();
	}
}
