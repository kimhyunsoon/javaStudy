import java.sql.*;

//PreparedStatement 
class A 
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	Connection con;
	PreparedStatement pstmt0, pstmt1, pstmt2;
	String tname = "JDBCT";
	String sql0 = "insert into "+tname + " values(?,?,?, SYSDATE)"; //가독성
	String sql1 = "select * from "+ tname + " where NAME like ?"; //속도 
	String sql2 = "select * from "+ tname + " order by NO desc";
	
	A(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt0 = con.prepareStatement(sql0);
            pstmt1 = con.prepareStatement(sql1);
            pstmt2 = con.prepareStatement(sql2);
		}catch(ClassNotFoundException cnfe){
			pln("오라클 드라이버(오라클DBMS측에서 JDBC를 구현한 클래스)를 찾지 못함");
		}catch(SQLException se){}
	}
	void insertD(int no, String name, String phone){
		try{
			pstmt0.setInt(1, no);
			pstmt0.setString(2, name);
			pstmt0.setString(3, phone);
			int i = pstmt0.executeUpdate();
			if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");
		}catch(SQLException se){
			pln("입력 실패 se: " + se); 
		}
	}
	void selectD(String na){
		ResultSet rs = null;
		try{
            na = "%"+na+"%";
			pstmt1.setString(1, na);
			rs = pstmt1.executeQuery();
			System.out.println("NO \t NAME \t PHONE \t RDATE");
			System.out.println("-----------------------------------------");
			while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Date rdate = rs.getDate(4);
				pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
			}
		}catch(SQLException se){
			pln("selectD() 실패: "+ se);
		}finally{
			try{
				rs.close();
			}catch(SQLException se){}
		}
	}
	void selectD(){
		ResultSet rs = null;
		try{
			rs = pstmt2.executeQuery();
			System.out.println("NO \t NAME \t PHONE \t RDATE");
			System.out.println("-----------------------------------------");
			while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Date rdate = rs.getDate(4);
				pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
			}
		}catch(SQLException se){
			pln("selectD() 실패: "+ se);
		}finally{
			try{
				rs.close();
			}catch(SQLException se){}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	void closeAll(){
		try{
			pstmt0.close();
			pstmt1.close();
			pstmt2.close();
			con.close();
		}catch(SQLException se){}
	}
	public static void main(String[] args) 
	{
		A a = new A();
		//a.insertD(10, "가나다", "01012341234");
		//a.insertD(20, "다라마", "01012341235");
		//a.insertD(30, "마바사", "01012341236");

		//a.selectD("다");
		a.selectD();

		a.closeAll();
	}
}
