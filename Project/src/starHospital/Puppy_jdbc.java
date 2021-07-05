//package starHospital;
import java.sql.*;
import java.io.*;
import java.util.*;


public class Puppy_jdbc {
    //settig
    String tfile = "setting.txt";
    List<String> list = null;
    GUI gui;
    //DB연결
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String usr = "project";
	String pwd = "java";
    Connection con;
    Statement stmt;
    PreparedStatement pstmt01, pstmt02, pstmt03,pstmt04,pstmt05,pstmt06, pstmt07, pstmt08, pstmt09, pstmt10, pstmt11, pstmt12, pstmt13, pstmt14, pstmt15, pstmt16, pstmt17, pstmt18, pstmt19, pstmt20, pstmt21, pstmt22, pstmt23;
    String sql01 = "insert into MOM values(?,?,?,?)"; //회원테이블 insert
    String sql02 = "insert into DOGCARD values(?,?,?,?,?,?,SYSDATE,?)"; //회원테이블 insert
    String sql03 = "delete from MOM where M_NUMBER= ?"; //회원 데이타 삭제
    String sql04 = "delete from DOGCARD where D_NUMBER= ?"; //강아지 데이타 삭제
    String sql05 = "select * from MOM where M_NUMBER like ?"; //엄마테이블 콤보
    String sql06 = "select * from MOM where M_PHONE like ?"; //엄마테이블 콤보
    String sql07 = "select * from MOM where M_NAME like ?"; //엄마테이블 콤보
    String sql08 = "select * from MOM where M_ADDR like ?"; //엄마테이블 콤보

    String sql09 = "select * from DOGCARD where D_NUMBER like ?"; //댕테이블 콤보
    String sql10 = "select * from DOGCARD where D_NAME like ?"; //댕테이블 콤보
    String sql11 = "select * from DOGCARD where M_NUMBER like ?"; //댕테이블 콤보

    //업데이트문
    String sql12 = "update MOM set M_PHONE=?, M_NAME =?, M_ADDR=?" + "where M_NUMBER=?"; 
    String sql13 = "update DOGCARD set D_NAME=?, D_KINDS =?, D_AGE=?, D_WEIGHT=?, D_SEX=?" + "where D_NUMBER=?"; 
    String sql14 = "insert into MEDICAL values(TO_CHAR(SYSDATE,'yymmddhhmiss'),?,?,?,?)"; //회원테이블 insert
    String sql15 = "select * from MEDICAL where MD_DATE like ?"; //진료테이블 콤보
    String sql16 = "select * from MEDICAL where D_NUMBER like ?"; //진료테이블 콤보
    String sql17 = "select * from MEDICAL where MD_SEC like ?"; //진료테이블 콤보

    //영수증 select문
    String sql18 = "select DS_NAME from DISEASE where DS_CODE like ?";
    String sql19 = "select T_HOW from TREAT where T_CODE like ?";
    String sql20 = "select D_NAME from DOGCARD where D_NUMBER like ?";

    String sql21 = "select B_VCOST from BILL where MD_DATE like ?";
    String sql22 = "select B_TCOST from BILL where MD_DATE like ?";
    String sql23 = "update BILL set B_TCOST=(select T_COST from TREAT where T_CODE like ?)"+"where MD_DATE like ?";


    // String sql05 = "select * from DEPT where DNAME like ?"; //콤보박스가 DNAME
    // String sql06 = "select * from DEPT where LOC like ?"; //콤보박스가 LOC

    Puppy_jdbc(){
        

        //gui = new GUI();
        //드라이버 로딩, DB연결
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, usr, pwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //select ALL
            pstmt01 = con.prepareStatement(sql01); //insert stmt
            pstmt02 = con.prepareStatement(sql02);
            pstmt03 = con.prepareStatement(sql03);//delete stmt
            pstmt04 = con.prepareStatement(sql04);
            pstmt05 = con.prepareStatement(sql05); //select combo
            pstmt06 = con.prepareStatement(sql06);
            pstmt07 = con.prepareStatement(sql07);
            pstmt08 = con.prepareStatement(sql08);  
            pstmt09 = con.prepareStatement(sql09);
            pstmt10 = con.prepareStatement(sql10);
            pstmt11 = con.prepareStatement(sql11);
            pstmt12 = con.prepareStatement(sql12);
            pstmt13 = con.prepareStatement(sql13);
            pstmt14 = con.prepareStatement(sql14);
            pstmt15 = con.prepareStatement(sql15);
            pstmt16 = con.prepareStatement(sql16);
            pstmt17 = con.prepareStatement(sql17);
            pstmt18 = con.prepareStatement(sql18);
            pstmt19 = con.prepareStatement(sql19);
            pstmt20 = con.prepareStatement(sql20);
            pstmt21 = con.prepareStatement(sql21);
            pstmt22 = con.prepareStatement(sql22);
            pstmt23 = con.prepareStatement(sql23);

            pln("연결 성공");

        } catch (ClassNotFoundException cnfe) {
            pln("클래스 찾지 못함");
        } catch(SQLException se){}

    }

    public void updateBill(String T_CODE, String MD_DATE){
        try {
            pstmt23.setString(1, T_CODE);
            pstmt23.setString(2, MD_DATE);
            int i = pstmt23.executeUpdate();
            if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");
        } catch (Exception e) {
        }
    }
    
    void selectDsname(String temp){
        ResultSet rs = null;
        String DS_NAME="";
        try {
            String temp1 = "%"+temp+"%";
            pstmt18.setString(1, temp1);
            rs = pstmt18.executeQuery();
            while(rs.next()){
                DS_NAME = rs.getString(1);

            }
            GUI.bw3B.setText(DS_NAME);
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectThname(String temp){
        ResultSet rs = null;
        String T_HOW="";
        try {
            //String temp1=temp;
            String temp1 = "%"+temp+"%";
            pstmt19.setString(1, temp1);
            rs = pstmt19.executeQuery();
            while(rs.next()){
                T_HOW = rs.getString(1);

            }
            GUI.bw4B.setText(T_HOW);
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectDname(String temp){
        ResultSet rs = null;
        String D_NAME="";
        try {
            //String temp1=temp;
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt20.setString(1, temp1);
            rs = pstmt20.executeQuery();
            while(rs.next()){
                D_NAME = rs.getString(1);
                //pln(D_NAME);

            }
            GUI.bw2B.setText(D_NAME);
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectBVCOST(String temp){
        ResultSet rs = null;
        String B_VCOST ="";
        try {
            //String temp1=temp;
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt21.setString(1, temp1);
            rs = pstmt21.executeQuery();
            while(rs.next()){
                B_VCOST = rs.getString(1);
                //pln(B_VCOST);

            }
            GUI.be1B.setText(B_VCOST);
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectBTCOST(String temp){
        ResultSet rs = null;
        String B_TCOST ="";
        try {
            //String temp1=temp;
            String temp1 = "%"+temp+"%";
            pln(temp1);
            pstmt22.setString(1, temp1);
            rs = pstmt22.executeQuery();
            while(rs.next()){
                B_TCOST = rs.getString(1);
                pln(B_TCOST);

            }
            GUI.be2B.setText(B_TCOST);
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }


    public void selectMOMAll(){
		ResultSet rs = null;
		String sql = "select * from MOM order by M_NUMBER";
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
                gui.mModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)
                });
			}
		}catch(SQLException se){
		}
	}

    public void selectDOGAll(){
		ResultSet rs = null;
		String sql = "select * from DOGCARD order by D_NUMBER";
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
                gui.dModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getDate(7),rs.getString(8)
                });
			}
		}catch(SQLException se){
		}
	}

    public void selectMDAll(){
		ResultSet rs = null;
		String sql = "select * from MEDICAL";
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
                gui.mdModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(3), rs.getString(2),rs.getString(4),rs.getString(5)

                });
                pln("여기까지오나?");
			}
		}catch(SQLException se){
		}
	}

    void selectMOM1(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt05.setString(1, temp1);
            rs = pstmt05.executeQuery();
            gui.mModel.setRowCount(0);
			while(rs.next()){
                gui.mModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectMOM2(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt06.setString(1, temp1);
            rs = pstmt06.executeQuery();
            gui.mModel.setRowCount(0);
			while(rs.next()){
                GUI.mModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectMOM3(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt07.setString(1, temp1);
            rs = pstmt07.executeQuery();
            gui.mModel.setRowCount(0);
			while(rs.next()){
                GUI.mModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectMOM4(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt08.setString(1, temp1);
            rs = pstmt08.executeQuery();
            gui.mModel.setRowCount(0);
			while(rs.next()){
                GUI.mModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectDOG1(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt09.setString(1, temp1);
            rs = pstmt09.executeQuery();
            gui.dModel.setRowCount(0);
			while(rs.next()){
                gui.dModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getDate(7),rs.getString(8)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectDOG2(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt10.setString(1, temp1);
            rs = pstmt10.executeQuery();
            gui.dModel.setRowCount(0);
			while(rs.next()){
                gui.dModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getDate(7),rs.getString(8)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    
    void selectDOG3(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt11.setString(1, temp1);
            rs = pstmt11.executeQuery();
            gui.dModel.setRowCount(0);
			while(rs.next()){
                gui.dModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getString(6),rs.getDate(7),rs.getString(8)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectMD1(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt15.setString(1, temp1);
            rs = pstmt15.executeQuery();
            gui.mdModel.setRowCount(0);
			while(rs.next()){
                gui.mdModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }
    void selectMD2(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt16.setString(1, temp1);
            rs = pstmt16.executeQuery();
            gui.mdModel.setRowCount(0);
			while(rs.next()){
                gui.mdModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }

    void selectMD3(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt17.setString(1, temp1);
            rs = pstmt17.executeQuery();
            gui.mdModel.setRowCount(0);
			while(rs.next()){
                gui.mdModel.addRow(new Object[]{
                    rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5)
                });
			}
        } catch (SQLException se) {
            pln("실패실패실패");
        }
    }




    public void updateMOM(String M_PHONE, String M_NAME, String M_ADDR, String M_NUMBER){
        try {
            pstmt12.setString(1, M_PHONE);
            pstmt12.setString(2, M_NAME);
            pstmt12.setString(3, M_ADDR);
            pstmt12.setString(4, M_NUMBER);
            int i = pstmt12.executeUpdate();
            if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");
        } catch (Exception e) {
        }
    }
    public void updateDOG(String D_NAME, String D_KINDS, String D_AGE, String D_WEIGHT, String D_SEX, String D_NUMBER){
        try {
            pstmt13.setString(1, D_NAME);
            pstmt13.setString(2, D_KINDS);
            pstmt13.setString(3, D_AGE);
            pstmt13.setString(4, D_WEIGHT);
            pstmt13.setString(5, D_SEX);
            pstmt13.setString(6, D_NUMBER);
            pln(D_NUMBER);
            int i = pstmt13.executeUpdate();
            if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");
        } catch (Exception e) {
        }
    }



    //2. JTextfield 통해서 한 줄 인서트    
    public void insertMOM(String M_NUMBER, String M_PHONE, String M_NAME, String M_ADDR){
        try {
            pstmt01.setString(1,M_NUMBER);
            pstmt01.setString(2,M_PHONE);
            pstmt01.setString(3,M_NAME);
            pstmt01.setString(4,M_ADDR);
            int i =pstmt01.executeUpdate();
			if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");

        } catch (SQLException se) {
            pln("입력 실패 se: " + se);
        } 
    }

    public void insertDOG(String D_NUMBER, String D_NAME, String D_KINDS, String D_AGE, String D_WEIGHT, String D_SEX, String M_NUMBER){
        try {
            pstmt02.setString(1,D_NUMBER);
            pstmt02.setString(2,D_NAME);
            pstmt02.setString(3,D_KINDS);
            pstmt02.setString(4,D_AGE);
            pstmt02.setString(5,D_WEIGHT);
            pstmt02.setString(6,D_SEX);
            pstmt02.setString(7,M_NUMBER);
            int i =pstmt02.executeUpdate();
			if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");

        } catch (SQLException se) {
            pln("입력 실패 se: " + se);
        } 
    }

    public void insertMED(String MD_SEC, String D_NUMBER, String DS_CODE, String T_CODE){
        try {
            pln(MD_SEC);
            pln(D_NUMBER);
            pln(DS_CODE);
            pln(T_CODE);

            pstmt14.setString(1,MD_SEC);
            pstmt14.setString(2,D_NUMBER);
            pstmt14.setString(3,DS_CODE);
            pstmt14.setString(4,T_CODE);
            int i =pstmt14.executeUpdate();
			if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");

        } catch (SQLException se) {
            pln("입력 실패 se: " + se);
        } 
    }


    public void deleteMOM(String M_NUMBER){
        try {
            pstmt03.setString(1, M_NUMBER);
            int i = pstmt03.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteDOG(String D_NUMBER){
        try {
            pstmt04.setString(1, D_NUMBER);
            int i = pstmt04.executeUpdate();
        } catch (Exception e) {
        }
    }









    public void pln(String str){
        System.out.println(str);
    }




    void readT(){
        list = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(tfile);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            while(data !=null){
                list.add(data);
            }
            System.out.println(list);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
