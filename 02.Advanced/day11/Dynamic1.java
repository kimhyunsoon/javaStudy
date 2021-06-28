import java.sql.*;

//����Ŀ��
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
            //�־��� ���ڿ� �̸��� ���� Ŭ���� �Ǵ� �������̽��� ���õ� Class ��ü�� ��ȯ
            con = DriverManager.getConnection(url, user, pw);
            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            /** 
            int resultSetType
            1)ResultSet.TYPE_FORWARD_ONLY : scroll�� �Ұ����� forward only ��
            2)ResultSet.TYPE_SCROLL_INSENSITIVE : scroll�� ����, ����� ���� ������� ����
            3)ResultSet.TYPE_SCROLL_SENSITIVE : scroll ����, ����� ���� ����
            
            int resultSetConcurrency
            1)ResultSet.CONCUR_READ_ONLY : resultset object�� ������ �Ұ���
            2)ResultSet.CONCUR_UPDATABLE : resultset object�� ������ ����
            */
        } catch (ClassNotFoundException cnfe) {
            //TODO: handle exception
        }catch(SQLException se){
			pln("con �Ǵ� stmt ���� ����: " + se); 
		}
    }

    void createRs(){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql); //select���� �� ��
            forward(rs); //BOF ->EOF
        } catch(SQLException se){
			pln("createRs() se: " + se);
		}
    }

    void forward(ResultSet rs){
        System.out.println("NO \t NAME \t PHONE \t RDATE");
		System.out.println("-----------------------------------------");
        try {
            pln("[������]");
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
    1) ResultSet.next() : Cursor�� ���� Row�� �̵�
    2) ResultSet.previous() : Cursor�� ���� Row�� �̵�
    3) ResultSet.first() : Cursor�� ResulSet�� ó������ �̵�
    4) ResultSet.last() : Cursor�� ResulSet�� ���������� �̵�
    5) ResultSet.isFirst() : ���� Cursor�� ù Row������ Ȯ��
    6) ResultSet.isLast() : ���� Cursor�� ������ Row������ Ȯ��
    7) ResultSet.getType() : ResultSet�� Type�� Return (Type�� �Ʒ� ���� (A))
    8) ResultSet.getCucurrency() : Concurrency�� Type�� Return (Type�� �Ʒ� ���� (B))
    9) ResultSet.getRow() : ���� Cursor�� ����Ű�� �ִ� Row Number
     */
    
    void backward(ResultSet rs){
        System.out.println("NO \t NAME \t PHONE \t RDATE");
		System.out.println("-----------------------------------------");

        try {
            pln("[������]");
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
