import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class JT3 extends JFrame implements ActionListener{
    //배열
    // Vector<String> columnNames;
    // Vector<Vector> rowData;
    String colNames[] = {"DEPTNO","DNAME","LOC"};  // 테이블 컬럼 값들
    
    //GUI 관련
    Container cp;
    JPanel southP, northP; 
    JLabel resultV;
    JTextField inputW, inputData1, inputData2, inputData3;
    JButton addD, modD, delD;
    JTable jtresult;
    DefaultTableModel model = new DefaultTableModel(colNames, 0); 
    //행단위로 수정, 삭제가 용이하도록 DefaultTableModel 객체 생성
    JComboBox cBox;


    //DB연결
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String usr = "scott";
	String pwd = "tiger";
    Connection con;
    Statement stmt;
    PreparedStatement pstmt01, pstmt02, pstmt03;
    String sql01 = "insert into DEPT values(?,?,?)"; //인서트
    String sql02 = "select * from DEPTNO where DEPTNO = ?"; //부서별
    String sql03 = "delete from DEPT where DEPTNO= ?"; //딜리트할때

    JT3(){
        //드라이버 로딩, DB연결
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, usr, pwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //select ALL
            pstmt01 = con.prepareStatement(sql01); //insert stmt
            pstmt02 = con.prepareStatement(sql02);
            pstmt03 = con.prepareStatement(sql03);//delete stmt

        } catch (ClassNotFoundException cnfe) {
            pln("클래스 찾지 못함");
        } catch(SQLException se){}

        setPanel(); 
        setUI();
        selectALL(); //기본 테이블

    }

    void selectALL(){
		ResultSet rs = null;
		String sql = "select * from DEPT order by DEPTNO";
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt(1), rs.getString(2), rs.getString(3)
                });
			}
            rs.afterLast();
		}catch(SQLException se){
		}finally{
			try{
				rs.close();
			}catch(SQLException se){}
		}
	}
    
    public void insertD(int DEPTNO, String DNANE, String LOC){
        try {
            pstmt01.setInt(1,DEPTNO);
            pstmt01.setString(2,DNANE);
            pstmt01.setString(3,LOC);
            int i =pstmt01.executeUpdate();
			if(i>0) pln(i+"개의 row 입력 성공");
			else pln(i+"개의 row 입력 실패");
        } catch (SQLException se) {
            pln("입력 실패 se: " + se);
        }
    }

    public void deleteD(int DEPTNO){
        try {
            pstmt03.setInt(1, DEPTNO);
            int i = pstmt03.executeUpdate();
        } catch (Exception e) {
            //TODO: handle exception
        }

    }



    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addD){
            //Int DEPTNO= (inputData1.getText());
            DefaultTableModel model2 = (DefaultTableModel)jtresult.getModel();
            int DEPTNO = Integer.parseInt(inputData1.getText().toString());
            String DNANE= inputData2.getText();
            String LOC= inputData3.getText();
            pln(DEPTNO+DNANE+LOC);
            insertD(DEPTNO,DNANE,LOC);
            model2.setRowCount(0);
            selectALL();
        }else if(e.getSource()==modD){

        }else if(e.getSource()==delD){
            DefaultTableModel model3 = (DefaultTableModel)jtresult.getModel();
            int row = jtresult.getSelectedRow();
            //Object data = jtresult.getValueAt(row, 0);
            String deptno = String.valueOf(model.getValueAt(row, 0));
            int DEPTNO = Integer.parseInt(deptno);
            System.out.println(DEPTNO);
            deleteD(DEPTNO);
            model3.setRowCount(0);
            selectALL();
        }
    }




    public void setPanel(){

        northP = new JPanel();
        northP.setLayout(new GridLayout(1,2));
        cBox = new JComboBox<String>(colNames);

        cBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pln("액션이벤트");
            }
        });

        inputW = new JTextField();
        northP.add(cBox);
        northP.add(inputW);

        southP = new JPanel();
        inputData1 = new JTextField();        
        inputData2 = new JTextField();
        inputData3 = new JTextField();
        addD = new JButton("추가");
        modD = new JButton("수정");
        delD = new JButton("삭제");
        southP.setLayout(new GridLayout(2,3));
        southP.add(inputData1);
        southP.add(inputData2);
        southP.add(inputData3);
        southP.add(addD);
        southP.add(modD);
        southP.add(delD);

        jtresult = new JTable(model);
        jtresult.addMouseListener(new JTableMouseListener()); //테이블에 마우스리스너 삽입
        //jtresult = new JTable(rowData, columnNames);
        //jtresult = new JTable(rowData, colNames); 
        JScrollPane sp = new JScrollPane(jtresult);

        cp = getContentPane();
        cp.add(northP, BorderLayout.NORTH);
        cp.add(sp, BorderLayout.CENTER);
        cp.add(southP, BorderLayout.SOUTH);

        addD.addActionListener(this);
        modD.addActionListener(this);
        delD.addActionListener(this);

    }
    void setUI(){
		setTitle("JTable Test Ver 1.0");
		setSize(400, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    void pln(String str){
        System.out.println(str);

    }

    public static void main(String[] args) {
        new JT3();

    }

    //마우스 클릭 이벤트
    class JTableMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent me){
            JTable jtresult = (JTable)me.getSource();
            
            //1.선택된 테이블의 행값
            int row= jtresult.getSelectedRow();
            //2. 선택된 테이블의 열값
            int column = jtresult.getSelectedColumn();
            //3. 선택된 위치의 값을 얻어내서 출력
            Object data = jtresult.getValueAt(row, column);

            String deptno = String.valueOf(model.getValueAt(row, 0));
            inputData1.setText(deptno);
            inputData1.setEditable(false);
            String dname = String.valueOf(model.getValueAt(row, 1));
            inputData2.setText(dname);
            String locate = String.valueOf(model.getValueAt(row, 2));
            inputData3.setText(locate);
            
        }
        public void mouseEntered(java.awt.event.MouseEvent e) {
        }
        public void mouseExited(java.awt.event.MouseEvent e) {    
        }
        public void mousePressed(java.awt.event.MouseEvent e) {
        }
        public void mouseReleased(java.awt.event.MouseEvent e) {
        }
    }
}

