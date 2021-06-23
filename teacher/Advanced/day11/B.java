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
			pln("오라클 드라이버(오라클DBMS측에서 JDBC를 구현한 클래스)를 찾지 못함");
		}catch(SQLException se){}
	}
	void call(){
		try{
			cstmt.setInt(1, 7369);
			cstmt.setFloat(2, 0.1f);
			cstmt.execute();
			pln("호출 성공");
		}catch(SQLException se){
            pln("호출 실패");
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
