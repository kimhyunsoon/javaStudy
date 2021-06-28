import java.sql.*;

//동적커서
public class Dynamic1 {
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	Connection con;
    String user="scott";
    String pw="tiger";
    Statement stmt;
    String sql = "select * from JDBCT order by NO";

    Dynamic1(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //주어진 문자열 이름을 가진 클래스 또는 인터페이스와 관련된 Class 객체를 반환
            con = DriverManager.getConnection(url, user, pw);
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            /** 
            int resultSetType
            1)ResultSet.TYPE_FORWARD_ONLY : scroll이 불가능한 forward only 형
            2)ResultSet.TYPE_SCROLL_INSENSITIVE : scroll은 가능, 변경된 사항 적용되지 않음
            3)ResultSet.TYPE_SCROLL_SENSITIVE : scroll 가능, 변경된 사항 적용
            
            int resultSetConcurrency
            1)ResultSet.CONCUR_READ_ONLY : resultset object의 변경이 불가능
            2)ResultSet.CONCUR_UPDATABLE : resultset object의 변경이 가능
            */
        } catch (ClassNotFoundException cnfe) {
            //TODO: handle exception
        }catch(SQLException se){
			pln("con 또는 stmt 생성 실패: " + se); 
		}
    }

    void createRs(){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql); //select문일 때 씀
            forward(rs); //BOF ->EOF
        } catch(SQLException se){
			pln("createRs() se: " + se);
		}
    }

    void forward(ResultSet rs){
        System.out.println("NO \t NAME \t PHONE \t RDATE");
		System.out.println("-----------------------------------------");
        try {
            pln("[순방향]");
            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date rDate = rs.getDate(4);
                pln(no+"\t"+name+"\t"+phone+"\t"+rDate);
            }
            backward(rs);
            rs.afterLast();
            rs.beforeFirst();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    /**
    1) ResultSet.next() : Cursor를 다음 Row로 이동
    2) ResultSet.previous() : Cursor를 이전 Row로 이동
    3) ResultSet.first() : Cursor를 ResulSet의 처음으로 이동
    4) ResultSet.last() : Cursor를 ResulSet의 마지막으로 이동
    5) ResultSet.isFirst() : 현재 Cursor가 첫 Row인지를 확인
    6) ResultSet.isLast() : 현재 Cursor가 마지막 Row인지를 확인
    7) ResultSet.getType() : ResultSet의 Type을 Return (Type은 아래 참조 (A))
    8) ResultSet.getCucurrency() : Concurrency의 Type을 Return (Type은 아래 참조 (B))
    9) ResultSet.getRow() : 현재 Cursor가 가리키고 있는 Row Number
     */
    
    void backward(ResultSet rs){
        System.out.println("NO \t NAME \t PHONE \t RDATE");
		System.out.println("-----------------------------------------");

        try {
            pln("[역방향]");
            while(rs.previous()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date rDate = rs.getDate(4);
                pln(no+"\t"+name+"\t"+phone+"\t"+rDate);
            }
        }catch(SQLException se){
			pln("createRs() se: " + se);
		}
    }

    /**
     * 
     * 
     */


	void pln(String str){
		System.out.println(str);
	}

    public static void main(String[] args) {
        Dynamic1 d1= new Dynamic1();
    }
    
}
