import java.sql.*;

//���� Ŀ�� 
class C 
{
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
    Connection con;
	Statement stmt;
	String sql = "select * from JDBCT order by NO";
	C(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "scott", "tiger");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			/*
			 (1) ResultSet.TYPE_FORWARD_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE, or ResultSet.TYPE_SCROLL_SENSITIVE
             (2) ResultSet.CONCUR_READ_ONLY or ResultSet.CONCUR_UPDATABLE
			*/
		}catch(ClassNotFoundException cnfe){
			pln("����Ŭ ����̹�(����ŬDBMS������ JDBC�� ������ Ŭ����)�� ã�� ����");
		}catch(SQLException se){
			pln("con �Ǵ� stmt ���� ����: " + se); 
		}
	}
	void createRs(){
		ResultSet rs = null;
		try{
			rs = stmt.executeQuery(sql);
            
			forward(rs); // BOF -> EOF 
		}catch(SQLException se){
			pln("createRs() se: " + se);
		}
	}
	void forward(ResultSet rs){
		System.out.println("NO \t NAME \t PHONE \t RDATE");
		System.out.println("-----------------------------------------");
		try{
			pln("< ������ >");
			while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Date rdate = rs.getDate(4);
				pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
			}

			backward(rs);  //EOF -> BOF
			rs.afterLast(); //EOF
			backward(rs);  //EOF -> BOF
			rs.afterLast(); //EOF
            rs.beforeFirst();//BOF
		}catch(SQLException se){
			pln("createRs() se: " + se);
		}
	}
	void backward(ResultSet rs){ 
		System.out.println("NO \t NAME \t PHONE \t RDATE");
		System.out.println("-----------------------------------------");
		try{
			pln("< ������ >");
			while(rs.previous()){
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				Date rdate = rs.getDate(4);
				pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
			}
		}catch(SQLException se){
			pln("createRs() se: " + se);
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		C c = new C();
		c.createRs();
	}
}
