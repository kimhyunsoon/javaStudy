import java.sql.*;

//CallableStatement 
public class Cstmt1 {
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	Connection con;
    String user="scott";
    String pw="tiger";
    CallableStatement callStmt;
    //SQL 저장 프로 시저를 실행하는 데 사용되는 인터페이스
    String sql = "call incre(?,?)";


    Cstmt1(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pw);
            callStmt = con.prepareCall(sql);
            //데이터베이스 저장 프로 시저를 호출하기위한 CallableStatement 개체를 만듭니다.
        } catch (ClassNotFoundException cnfe) {
            pln("오라클 드라이버(오라클DBMS측에서 JDBC를 구현한 클래스)를 찾지 못함");
        }catch(SQLException se){}
    }

    void call(){
        try {
            callStmt.setInt(1, 7369);
            callStmt.setFloat(2, 0.1f);
            callStmt.execute();
            //모든 sql문을 수행할 수 있으나 반환값이 boolean이므로 ResultSet 객체에 결과값을 담을 수 없다
            pln("호출성공");
        } catch (SQLException se) {
            pln("호출 실패");
        }
    }

    void pln(String str){
        System.out.println(str);
    }



    public static void main(String[] args) {
        Cstmt1 c1= new Cstmt1();
        c1.call();
    }
    
}
