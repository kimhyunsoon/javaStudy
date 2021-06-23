import java.sql.*;

//PreparedStatement 
class A 
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	Connection con;
	PreparedStatement pstmt0, pstmt1, pstmt2;
	String tname = "JDBCT";
	String sql0 = "insert into "+tname + " values(?,?,?, SYSDATE)"; //������
	String sql1 = "select * from "+ tname + " where NAME like ?"; //�ӵ� 
	String sql2 = "select * from "+ tname + " order by NO desc";
	
	A(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			pstmt0 = con.prepareStatement(sql0);
            pstmt1 = con.prepareStatement(sql1);
            pstmt2 = con.prepareStatement(sql2);
		}catch(ClassNotFoundException cnfe){
			pln("����Ŭ ����̹�(����ŬDBMS������ JDBC�� ������ Ŭ����)�� ã�� ����");
		}catch(SQLException se){}
	}
	void insertD(int no, String name, String phone){
		try{
			pstmt0.setInt(1, no);
			pstmt0.setString(2, name);
			pstmt0.setString(3, phone);
			int i = pstmt0.executeUpdate();
			if(i>0) pln(i+"���� row �Է� ����");
			else pln(i+"���� row �Է� ����");
		}catch(SQLException se){
			pln("�Է� ���� se: " + se); 
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
			pln("selectD() ����: "+ se);
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
			pln("selectD() ����: "+ se);
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
		//a.insertD(10, "������", "01012341234");
		//a.insertD(20, "�ٶ�", "01012341235");
		//a.insertD(30, "���ٻ�", "01012341236");

		//a.selectD("��");
		a.selectD();

		a.closeAll();
	}
}
