import java.sql.*;

//CallableStatement 
public class Cstmt1 {
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	Connection con;
    String user="scott";
    String pw="tiger";
    CallableStatement callStmt;
    //SQL ���� ���� ������ �����ϴ� �� ���Ǵ� �������̽�
    String sql = "call incre(?,?)";


    Cstmt1(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pw);
            callStmt = con.prepareCall(sql);
            //�����ͺ��̽� ���� ���� ������ ȣ���ϱ����� CallableStatement ��ü�� ����ϴ�.
        } catch (ClassNotFoundException cnfe) {
            pln("����Ŭ ����̹�(����ŬDBMS������ JDBC�� ������ Ŭ����)�� ã�� ����");
        }catch(SQLException se){}
    }

    void call(){
        try {
            callStmt.setInt(1, 7369);
            callStmt.setFloat(2, 0.1f);
            callStmt.execute();
            //��� sql���� ������ �� ������ ��ȯ���� boolean�̹Ƿ� ResultSet ��ü�� ������� ���� �� ����
            pln("ȣ�⼺��");
        } catch (SQLException se) {
            pln("ȣ�� ����");
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
