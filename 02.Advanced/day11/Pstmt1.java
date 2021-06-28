import java.sql.*;

public class Pstmt1 {
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	Connection con;
    String user="scott";
    String pw="tiger";
    Statement stmt;
    PreparedStatement preStmt0, preStmt1, preStmt2;
    String tname = "TEST";

    //������ �������� �������ش�
    String sql0 = "insert into "+tname +" values(?,?,?, SYSDATE)"; //DML������ �������� ����
    String sql1 = "select * from "+tname+" where NAME like ?"; //DQL������ �ӵ��� ����
    String sql2 = "select * from "+tname+" order by NO desc";

    Pstmt1(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Driver  ����
            con=DriverManager.getConnection(url, user, pw); //DB����

            //PrepareStatement ���� : sql���� �����Ͱ� ����ִٸ� ���� ������
            preStmt0 = con.prepareStatement(sql0); //insert �� ��
            preStmt1 = con.prepareStatement(sql1); //select �� ��
            preStmt2 = con.prepareStatement(sql2);
        } catch (ClassNotFoundException cnfe) {
            pln("����Ŭ ����̹�(����ŬDBMS������ JDBC�� ������ Ŭ����)�� ã�� ����");
        }catch(SQLException se){}
    }

    void insertD(int no, String name, String phone){
        //�Ķ���� ������ ���� �����͵��� setXXX �޼ҵ带 �̿��� ����ǥ(?) �ڸ����� �־��ش�
        try {
            preStmt0.setInt(1,no); 
            preStmt0.setString(2, name);
            preStmt0.setString(3,phone);

            int i = preStmt0.executeUpdate(); //���ϰ��� int ��
            if(i>0) pln(i+"���� row �Է� ����"); //(1) SQL DML ���� �� �� �Ǵ�
            else pln(i+"���� row �Է� ����"); // (2) �ƹ��͵� ��ȯ���� �ʴ� SQL ���� ��� 0
        } catch (SQLException se) {
            pln("�Է� ���� se: " + se); 
        }
    }

    void selectD(String temp){
        ResultSet rs = null; //ResultSet �������̽�, ������ �����Ͽ� �����Ǵ� �����ͺ��̽� ��� ������ ��Ÿ���� ������ ���̺�
        try {
            temp = "%"+temp+"%"; //like �����ڿ� �Բ� ���� %
            preStmt1.setString(1, temp); //setString(�Ķ�����ε���, ������), ���⼭ �Ķ���ʹ� �Ѱ��ϱ�....
            rs = preStmt1.executeQuery(); //������ ���� ������ �����͸� �����ϴ� ResultSet ������Ʈ, null�� �� �� ����
            pln("NO \t NAME \t PHONE \t RDATE");
            System.out.println("-----------------------------------------");

            /** next() �޼ҵ�� next �޼ҵ�� Ŀ���� ���� ������ �̵��ϰ� 
             * ResultSet ��ü�� ���� �� �̻� ������ false�� ��ȯ�ϹǷ� 
             * while �������� ����Ͽ� ��� ������ �ݺ� �� �� �ֽ��ϴ�.*/

            while(rs.next()){
                int no = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                Date rDate = rs.getDate(4);
                pln(no+"\t"+name+"\t"+phone+"\t"+rDate);
            }
        } catch (SQLException se) {
            pln("selectD() ����: "+ se);
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
            pln("selectD() ����: "+ se);
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
        //a.insertD(40, "������", "01012341234");
        //a.selectD("��");
        a.selectD();
    }
    
}
