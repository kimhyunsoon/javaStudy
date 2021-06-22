import java.sql.*;

class A
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String usr = "scott";
	String pwd = "tiger";

	Connection con;
    Statement stmt;
	A(){
		//(1) Driver 로딩 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			pln("(1) 드라이버 로딩 성공");
		}catch(ClassNotFoundException cnfe){
			pln("(1) 드라이버 로딩 실패");
		}
		//(2) DB 연결 
		try{
			con = DriverManager.getConnection(url, usr, pwd);
			pln("(2) DB와 연결 성공 con: " + con);
		}catch(SQLException se){
			pln("(2) DB와 연결 실패: " + se);
		}
		//(3) Statement 생성 
		try{
			stmt = con.createStatement();
			pln("(3) stmt 생성 성공");
		}catch(SQLException se){
			pln("(3) stmt 생성 실패");    
		}
        createTable();
        //closeAll();
	}

    String tname = "JDBCT";
    void createTable(){       
        
        String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar2(10), PHONE varchar2(11), RDATE date)";

        //(4)Statement 실행
        try {
            stmt.execute(sql);
            pln("(4) : "+tname+" 테이블 생성 성공");

        } catch (SQLException se) {
            pln("(4) " +tname+"테이블 생성 실패");
        }


    }
    void closeAll(){
		try{
			stmt.close();
			con.close();
			pln("(6)연결 객체 닫기 성공");
		}catch(SQLException se){
			pln("(6)연결 객체 닫기 실패");
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
