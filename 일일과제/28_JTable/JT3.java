import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class JT3 extends JFrame implements ActionListener{
    //�迭
    // Vector<String> columnNames;
    // Vector<Vector> rowData;
    String colNames[] = {"DEPTNO","DNAME","LOC"};  // ���̺� �÷� ����
    
    //GUI ����
    Container cp;
    JPanel southP, northP; 
    JLabel resultV;
    JTextField inputW, inputData1, inputData2, inputData3;
    JButton addD, modD, delD;
    JTable jtresult;
    DefaultTableModel model = new DefaultTableModel(colNames, 0); 
    //������� ����, ������ �����ϵ��� DefaultTableModel ��ü ����
    JComboBox cBox;


    //DB����
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String usr = "scott";
	String pwd = "tiger";
    Connection con;
    Statement stmt;
    PreparedStatement pstmt01, pstmt02, pstmt03;
    String sql01 = "insert into DEPT values(?,?,?)"; //�μ�Ʈ
    String sql02 = "select * from DEPTNO where DEPTNO = ?"; //�μ���
    String sql03 = "delete from DEPT where DEPTNO= ?"; //����Ʈ�Ҷ�

    JT3(){
        //����̹� �ε�, DB����
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, usr, pwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //select ALL
            pstmt01 = con.prepareStatement(sql01); //insert stmt
            pstmt02 = con.prepareStatement(sql02);
            pstmt03 = con.prepareStatement(sql03);//delete stmt

        } catch (ClassNotFoundException cnfe) {
            pln("Ŭ���� ã�� ����");
        } catch(SQLException se){}

        setPanel(); 
        setUI();
        selectALL(); //�⺻ ���̺�

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
			if(i>0) pln(i+"���� row �Է� ����");
			else pln(i+"���� row �Է� ����");
        } catch (SQLException se) {
            pln("�Է� ���� se: " + se);
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
                pln("�׼��̺�Ʈ");
            }
        });

        inputW = new JTextField();
        northP.add(cBox);
        northP.add(inputW);

        southP = new JPanel();
        inputData1 = new JTextField();        
        inputData2 = new JTextField();
        inputData3 = new JTextField();
        addD = new JButton("�߰�");
        modD = new JButton("����");
        delD = new JButton("����");
        southP.setLayout(new GridLayout(2,3));
        southP.add(inputData1);
        southP.add(inputData2);
        southP.add(inputData3);
        southP.add(addD);
        southP.add(modD);
        southP.add(delD);

        jtresult = new JTable(model);
        jtresult.addMouseListener(new JTableMouseListener()); //���̺� ���콺������ ����
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

    //���콺 Ŭ�� �̺�Ʈ
    class JTableMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent me){
            JTable jtresult = (JTable)me.getSource();
            
            //1.���õ� ���̺��� �ప
            int row= jtresult.getSelectedRow();
            //2. ���õ� ���̺��� ����
            int column = jtresult.getSelectedColumn();
            //3. ���õ� ��ġ�� ���� ���� ���
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

