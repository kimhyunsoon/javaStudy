import java.sql.*;

public class Pstmt1 {
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	Connection con;
    String user="scott";
    String pw="tiger";
    Statement stmt;
    PreparedStatement preStmt0, preStmt1, preStmt2;
    String tname = "TEST";

    //쿼리를 전역에다 선언해준다
    String sql0 = "insert into "+tname +" values(?,?,?, SYSDATE)"; //DML문에서 가독성이 좋음
    String sql1 = "select * from "+tname+" where NAME like ?"; //DQL문에서 속도가 빠름
    String sql2 = "select * from "+tname+" order by NO desc";

    Pstmt1(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Driver  생성
            con=DriverManager.getConnection(url, user, pw); //DB연결

            //PrepareStatement 생성 : sql문에 데이터가 들어있다면 쓰기 유용함
            preStmt0 = con.prepareStatement(sql0); //insert 할 때
            preStmt1 = con.prepareStatement(sql1); //select 할 때
            preStmt2 = con.prepareStatement(sql2);
        } catch (ClassNotFoundException cnfe) {
            pln("오라클 드라이버(오라클DBMS측에서 JDBC를 구현한 클래스)를 찾지 못함");
        }catch(SQLException se){}
    }

    void insertD(int no, String name, String phone){
        //파라미터 변수로 받은 데이터들을 setXXX 메소드를 이용해 물음표(?) 자리에다 넣어준다
        try {
            preStmt0.setInt(1,no); 
            preStmt0.setString(2, name);
            preStmt0.setString(3,phone);

            int i = preStmt0.executeUpdate(); //리턴값이 int 형
            if(i>0) pln(i+"개의 row 입력 성공"); //(1) SQL DML 문의 행 수 또는
            else pln(i+"개의 row 입력 실패"); // (2) 아무것도 반환하지 않는 SQL 문의 경우 0
        } catch (SQLException se) {
            pln("입력 실패 se: " + se); 
        }
    }

    void selectD(String temp){
        ResultSet rs = null; //ResultSet 인터페이스, 쿼리를 실행하여 생성되는 데이터베이스 결과 집합을 나타내는 데이터 테이블
        try {
            temp = "%"+temp+"%"; //like 연산자와 함께 가는 %
            preStmt1.setString(1, temp); //setString(파라미터인덱스, 데이터), 여기서 파라미터는 한개니까....
            rs = preStmt1.executeQuery(); //쿼리에 의해 생성된 데이터를 포함하는 ResultSet 오브젝트, null이 될 수 없다
            pln("NO \t NAME \t PHONE \t RDATE");
            System.out.println("-----------------------------------------");

            /** next() 메소드는 next 메소드는 커서를 다음 행으로 이동하고 
             * ResultSet 객체에 행이 더 이상 없으면 false를 반환하므로 
             * while 루프에서 사용하여 결과 집합을 반복 할 수 있습니다.*/

            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date rDate = rs.getDate(4);
                pln(no+"\t"+name+"\t"+phone+"\t"+rDate);
            }
        } catch (SQLException se) {
            pln("selectD() 실패: "+ se);
        }finally{
            try {
                rs.close();
            } catch (SQLException se) {
                //TODO: handle exception
            }
        }
    }

    void selectD(){
        ResultSet rs = null;
        try {
            rs = preStmt2.executeQuery();
            System.out.println("NO \t NAME \t PHONE \t RDATE");
			System.out.println("-----------------------------------------");

            while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Date rdate = rs.getDate(4);
				pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
            }
        }catch (SQLException se) {
            pln("selectD() 실패: "+ se);
        }finally{
            try {
                rs.close();
            } catch (SQLException se) {
                //TODO: handle exception
            }
        }        
    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Pstmt1 a = new Pstmt1();
        //a.insertD(40, "가나다", "01012341234");
        //a.selectD("다");
        a.selectD();
    }
    
}
