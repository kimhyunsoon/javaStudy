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

    //키보드로 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    
    
    KAEUNsqlplus(){
        connect();
        //(1) Driver 로딩
        url = ""+"jdbc:oracle:thin:@"+ip+":1521:"+sid+"";
        usr = ""+usr+"";
        pwd = ""+pwd+"";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //pln("(1) 드라이버 로딩 성공");
        } catch (ClassNotFoundException cnfe) {
            //pln("(1) 드라이버 로딩 실패");
        }
        //(2) DB 연결
        try{
			con = DriverManager.getConnection(url, usr, pwd);
			//pln("(2) DB와 연결 성공 con: " + con);
		}catch(SQLException se){
			//pln("(2) DB와 연결 실패: " + se);
		}
		//(3) Statement 생성 
		try{
			stmt = con.createStatement();
			//p("(3) stmt 생성 성공");
		}catch(SQLException se){
			//p("(3) stmt 생성 실패");
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
            pln("(4) " +tname+"테이블 생성 성공");
        } catch (Exception e) {
            pln("(4) " +tname+"테이블 생성 실패");
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
			pln("(4) " +tname+"테이블 삭제 성공");
		}catch(SQLException se){
			pln("(4) " +tname+"테이블 삭제 실패");
		}
	}

    void insertD(String temp){
        sql = ""+temp+"";
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0) {
                pln("(4) "+ i+"개의 row 입력 성공");
            }else{
                pln(i+"개의 row 입력 실패");
            }
        } catch (SQLException se) {
            pln("입력 실패 se: " + se);
        }        
    }

    void updateD(String temp){
        sql = ""+temp+"";
        try {
            int i = stmt.executeUpdate(sql);
            if(i>0) {
                pln("(4) "+i+"개의 row 수정 성공");
            }else{
                pln(i+"개의 row 수정 실패");
            }
        } catch (SQLException se) {
            pln("수정 실패 se: " + se);
        }
    }

    void deleteD(String temp){
		sql = ""+temp+"";
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


    void selectD(String temp){
        ResultSet rs = null;
        sql = ""+temp+"";
		try{
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            boolean b = rsmd.isSearchable(numberOfColumns);
			pln("(4) rs 생성 성공");
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

            pln("가변배열 만들다 시간 부족으로 포기....");

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
    void p(String str){
        System.out.print(str);
    }


    public static void main(String[] args) {
        new KAEUNsqlplus();
    }


}
