import java.io.BufferedReader;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class KAEUNsqlplus {
    String url;
	String usr;
	String pwd;
    String ip;
    int port;
    String sid;

    String tname ;
    String sql;
    String temp;

    InputStream is;
    OutputStream os;

	Connection con;
    Statement stmt;

    //Ű����� �Է�
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
    
    KAEUNsqlplus(){
        connect();
        //(1) Driver �ε�
        url = ""+"jdbc:oracle:thin:@"+ip+":1521:"+sid+"";
        usr = ""+usr+"";
        pwd = ""+pwd+"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //pln("(1) ����̹� �ε� ����");
        } catch (ClassNotFoundException cnfe) {
            //pln("(1) ����̹� �ε� ����");
        }
        //(2) DB ����
        try{
			con = DriverManager.getConnection(url, usr, pwd);
			//pln("(2) DB�� ���� ���� con: " + con);
		}catch(SQLException se){
			//pln("(2) DB�� ���� ����: " + se);
		}
		//(3) Statement ���� 
		try{
			stmt = con.createStatement();
			//p("(3) stmt ���� ����");
		}catch(SQLException se){
			//p("(3) stmt ���� ����");
		}

        filter();
    }

    void connect(){
        try {
            p("Oracle IP(default:127.0.0.1) : ");
            ip = br.readLine();
            ip = ip.trim();
            if(ip.length()==0) ip = "127.0.0.1";
            p("Oracle SID(default:JAVA) : ");
            sid = br.readLine();
            sid = sid.trim();
            if(sid.length()==0) sid = "JAVA";
            p("ID(default:scott) : ");
            usr = br.readLine();
            usr = usr.trim();
            if(usr.length()==0) usr = "scott";
            p("PWD(default:tiger) : ");
            pwd = br.readLine();
            pwd = pwd.trim();
            if(pwd.length()==0) pwd = "tiger";
        } catch (IOException ie) {
        }
    }

    void filter(){
        try {
            while(br.readLine() !=null){
                p("SQL>");
                temp= br.readLine();

                if(temp.startsWith("create")) createT(temp);
                else if(temp.startsWith("drop")) dropT(temp); 
                else if(temp.startsWith("insert")) insertD(temp);
                else if(temp.startsWith("update")) updateD(temp);
                else if(temp.startsWith("delete")) deleteD(temp);
                else if(temp.startsWith("select")) selectD(temp);
                else if(temp.startsWith("exit")) break;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
	void createT(String temp){
        sql = ""+temp+"";
        try {
            stmt.execute(sql);
            pln("(4) " +tname+"���̺� ���� ����");
        } catch (Exception e) {
            pln("(4) " +tname+"���̺� ���� ����");
        }
	}

	void createTnoExist(){
        String sql = "select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";

        ResultSet rs = null;
        try{
			rs = stmt.executeQuery(sql);  
			boolean flag = rs.next();
			if(!flag) createT(sql);
		}catch(SQLException se){
		}finally{
			try{
				rs.close();
			}catch(SQLException se){}
		}
	}

    void dropT(String temp){
		sql = ""+temp+"";
		String purge = "purge recyclebin";
		try{
			stmt.execute(sql);
			stmt.execute(purge);
			pln("(4) " +tname+"���̺� ���� ����");
		}catch(SQLException se){
			pln("(4) " +tname+"���̺� ���� ����");
		}
	}

    void insertD(String temp){
        sql = ""+temp+"";
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0) {
                pln("(4) "+ i+"���� row �Է� ����");
            }else{
                pln(i+"���� row �Է� ����");
            }
        } catch (SQLException se) {
            pln("�Է� ���� se: " + se);
        }        
    }

    void updateD(String temp){
        sql = ""+temp+"";
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0) {
                pln("(4) "+i+"���� row ���� ����");
            }else{
                pln(i+"���� row ���� ����");
            }
        } catch (SQLException se) {
            pln("���� ���� se: " + se);
        }
    }

    void deleteD(String temp){
		sql = ""+temp+"";
		try{
			int i = stmt.executeUpdate(sql);
			if(i>0) {
				pln("(4) "+i+"���� row ���� ����");
			}else{
				pln(i+"���� row ���� ����");
			}
		}catch(SQLException se){
			pln("���� ���� se: " + se); 
		}
	}


    void selectD(String temp){
        ResultSet rs = null;
        sql = ""+temp+"";
		try{
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            boolean b = rsmd.isSearchable(numberOfColumns);
			pln("(4) rs ���� ����");
			// System.out.println("NO \t NAME \t PHONE \t RDATE");
			// System.out.println("-----------------------------------------");

            String ColumnName1=rsmd.getColumnName(1);
            String ColumnName2=rsmd.getColumnName(2);
            String ColumnName3=rsmd.getColumnName(3);

            System.out.println(ColumnName1+"\t"+ColumnName2+"\t"+ColumnName3);
            System.out.println("-----------------------------------------");


            int ColumnType1= rsmd.getColumnType(1);
            int ColumnType2= rsmd.getColumnType(2);
            int ColumnType3= rsmd.getColumnType(3);

            pln("�����迭 ����� �ð� �������� ����....");

            // while(rs.next){
            //     int no = rs.getInt(1);
			// 	String name = rs.getString(2);
			// 	String phone = rs.getString(3);
			// 	Date rdate = rs.getDate(4);
            //     pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
            // }
            
            
            
            
            
            // while(rs.next()){
			// 	int no = rs.getInt(1);
			// 	String name = rs.getString(2);
			// 	String phone = rs.getString(3);
			// 	Date rdate = rs.getDate(4);
			// 	pln(no+"\t"+name+"\t"+phone+"\t"+rdate);
			// }
			pln("(5) ������ ���� ����");
		}catch(SQLException se){
			pln("selectD() ����: "+ se);
		}finally{
			try{
				rs.close();
				pln("(6) rs ��ü �ݱ� ����");
			}catch(SQLException se){}
		}
    }

	void closeAll(){
		try{
			stmt.close();
			con.close();
			pln("(6)���� ��ü �ݱ� ����");
		}catch(SQLException se){
			pln("(6)���� ��ü �ݱ� ����");
		}
	}



    void pln(String str){
        System.out.println(str);
    }
    void p(String str){
        System.out.print(str);
    }


    public static void main(String[] args) {
        new KAEUNsqlplus();
    }


}
