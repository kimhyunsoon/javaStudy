import java.sql.*;

class A
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
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
		
		//createT();
		//createTnoExist(); //미션!! 
		//dropT();

		//insertD(10, "홍길동", "01012341234");
		//insertD(20, "이순신", "01012341235");
		//insertD(30, "강감찬", "01012341236");
		//updateD(20, "김지아", "01912341235");
        //deleteD(10);
		//deleteD("감");
  
        selectD();
		closeAll();
	}

    //[1] DDL 
	String tname = "JDBCT";
	void createT(){
		String sql = "create table "+tname+"(NO number(2) primary key, NAME varchar2(10), PHONE varchar2(11), RDATE date)";
		//(4) Statement 실행 
		try{
			stmt.execute(sql);
			pln("(4) " +tname+"테이블 생성 성공");
		}catch(SQLException se){
            pln("(4) " +tname+"테이블 생성 실패");
		}
	}
	void createTnoExist(){
        String sql = "select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";
		//나중에 함 해봐! 
	}
	void dropT(){
		String sql = "drop table "+tname;
		String purge = "purge recyclebin";
		try{
			stmt.execute(sql);
			stmt.execute(purge);
			pln("(4) " +tname+"테이블 삭제 성공");
		}catch(SQLException se){
			pln("(4) " +tname+"테이블 삭제 실패");
		}
	}

    //[2] DML 
	void insertD(int no, String name, String phone){
		String sql = "insert into "+tname+" values("+no+", '"+name+"', '"+phone+"', SYSDATE)";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+ i+"개의 row 입력 성공");
			}else{
				pln(i+"개의 row 입력 실패");
			}
		}catch(SQLException se){
			pln("입력 실패 se: " + se); 
		}
	}
	void updateD(int no, String name, String phone){
		String sql = "update "+tname+" set name='"+name+"', phone='"+phone+"' where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"개의 row 수정 성공");
			}else{
				pln(i+"개의 row 수정 실패");
			}
		}catch(SQLException se){
			pln("수정 실패 se: " + se); 
		}
	}
	void deleteD(int no){
		String sql = "delete from "+tname+" where NO="+no;
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"개의 row 삭제 성공");
			}else{
				pln(i+"개의 row 삭제 실패");
			}
		}catch(SQLException se){
			pln("삭제 실패 se: " + se); 
		}
	}
	void deleteD(String name){
        String sql = "delete from "+tname+" where NAME like '%"+name+"%'";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"개의 row 삭제 성공");
			}else{
				pln(i+"개의 row 삭제 실패");
			}
		}catch(SQLException se){
			pln("삭제 실패 se: " + se); 
		}
	}

    //[DQL]
    void selectD(){
		ResultSet rs = null;
		String sql = "select * from "+tname+" order by RDATE desc";
		try{
			rs = stmt.executeQuery(sql);
			pln("(4) rs 생성 성공");
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
			pln("(5) 데이터 추출 성공");
		}catch(SQLException se){
			pln("selectD() 실패: "+ se);
		}finally{
			try{
				rs.close();
				pln("(6) rs 객체 닫기 성공");
			}catch(SQLException se){}
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
