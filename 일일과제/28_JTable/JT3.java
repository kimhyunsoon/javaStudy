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
    PreparedStatement pstmt01, pstmt02, pstmt03,pstmt04,pstmt05,pstmt06;
    String sql01 = "insert into DEPT values(?,?,?)"; //�μ�Ʈ
    String sql02 = "update DEPT set DNAME=?, LOC=?" + "where DEPTNO=?"; 
    String sql03 = "delete from DEPT where DEPTNO= ?"; //����Ʈ�Ҷ�
    String sql04 = "select * from DEPT where DEPTNO like ?"; //�޺��ڽ��� DEPTNO
    String sql05 = "select * from DEPT where DNAME like ?"; //�޺��ڽ��� DNAME
    String sql06 = "select * from DEPT where LOC like ?"; //�޺��ڽ��� LOC

    JT3(){
        //����̹� �ε�, DB����
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, usr, pwd);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); //select ALL
            pstmt01 = con.prepareStatement(sql01); //insert stmt
            pstmt02 = con.prepareStatement(sql02); //update stmt
            pstmt03 = con.prepareStatement(sql03);//delete stmt
            pstmt04 = con.prepareStatement(sql04); 
            pstmt05 = con.prepareStatement(sql05);
            pstmt06 = con.prepareStatement(sql06);

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
		}catch(SQLException se){
		}
	}
    //1. JTextfield ���ؼ� ����Ʈ
    void selectDEPTNO(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt04.setString(1, temp1);
            rs = pstmt04.executeQuery();
            model.setRowCount(0);
			while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt(1), rs.getString(2), rs.getString(3)
                });
			}
        } catch (SQLException se) {
            pln("���н��н���");
        }
    }

    void selectDNAME(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt05.setString(1, temp1);
            rs = pstmt05.executeQuery();
            model.setRowCount(0);
			while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt(1), rs.getString(2), rs.getString(3)
                });
			}
        } catch (SQLException se) {
            pln("���н��н���");
        }
    }

    void selectLOC(String temp){
        ResultSet rs = null;
        try {
            String temp1 = "%"+temp+"%";
            //pln(temp1);
            pstmt06.setString(1, temp1);
            rs = pstmt06.executeQuery();
            model.setRowCount(0);
			while(rs.next()){
                model.addRow(new Object[]{
                    rs.getInt(1), rs.getString(2), rs.getString(3)
                });
			}
        } catch (SQLException se) {
            pln("���н��н���");
        }
    }

    //2. JTextfield ���ؼ� �� �� �μ�Ʈ    
    public void insertD(int DEPTNO, String DNANE, String LOC){
        try {
            pstmt01.setInt(1,DEPTNO);
            pstmt01.setString(2,DNANE);
            pstmt01.setString(3,LOC);
            int i =pstmt01.executeUpdate();
			if(i>0) pln(i+"���� row �Է� ����");
			else pln(i+"���� row �Է� ����");
            clearInputData();
        } catch (SQLException se) {
            clearInputData();
            pln("�Է� ���� se: " + se);
        } 
    }

    //3. ������ �� ����
    public void updateD(String DNANE, String LOC, int DEPTNO){
        try {
            pstmt02.setString(1, DNANE);
            pstmt02.setString(2, LOC);
            pstmt02.setInt(3, DEPTNO);
            int i = pstmt02.executeUpdate();
            clearInputData();
        } catch (Exception e) {
            clearInputData();
        }
    }

    //4. ������ �� ����Ʈ
    public void deleteD(int DEPTNO){
        try {
            pstmt03.setInt(1, DEPTNO);
            int i = pstmt03.executeUpdate();
            clearInputData();
        } catch (Exception e) {
            clearInputData();
        }
    }

    //���콺 Ŭ�� �̺�Ʈ
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==addD){ //1. JTextField�� �Է��ϰ� �߰� ��ư Ŭ��
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
            //1. JTextField�� �Է��ϰ� ������ư Ŭ��
            if(inputData1.getText() !=null){
                DefaultTableModel model3 = (DefaultTableModel)jtresult.getModel();
                String DNANE= inputData2.getText(); 
                String LOC= inputData3.getText();
                int DEPTNO = Integer.parseInt(inputData1.getText().toString());
                updateD(DNANE, LOC, DEPTNO);
                model3.setRowCount(0);
                selectALL();
            //2.���콺�� �� �� �����ϰ� ������ư Ŭ��
            }else if(jtresult.getSelectedRow() != -1){
                DefaultTableModel model3 = (DefaultTableModel)jtresult.getModel();
                int row = jtresult.getSelectedRow();
                String deptno = String.valueOf(model.getValueAt(row, 0));
                int DEPTNO = Integer.parseInt(deptno);
                String DNANE= inputData2.getText();
                String LOC= inputData3.getText();
                updateD(DNANE, LOC, DEPTNO);
                model3.setRowCount(0);
                selectALL();
            }
        }else if(e.getSource()==delD){//���� ��ư Ŭ��
            //1. JTextField�� �Է��ϰ� ������ư Ŭ��
            if(inputData1.getText() !=null){
                DefaultTableModel model3 = (DefaultTableModel)jtresult.getModel();
                int DEPTNO = Integer.parseInt(inputData1.getText().toString());
                deleteD(DEPTNO);
                model3.setRowCount(0);
                selectALL();
            //2.���콺�� �� �� �����ϰ� ������ư Ŭ��
            }else if(jtresult.getSelectedRow() != -1){
                DefaultTableModel model3 = (DefaultTableModel)jtresult.getModel();
                int row = jtresult.getSelectedRow();
                String deptno = String.valueOf(model.getValueAt(row, 0));
                int DEPTNO = Integer.parseInt(deptno);
                System.out.println(DEPTNO);
                deleteD(DEPTNO);
                model3.setRowCount(0);
                selectALL();
            }
        }
    }


    public void setPanel(){

        northP = new JPanel();
        northP.setLayout(new GridLayout(1,2));
        cBox = new JComboBox<String>(colNames); //�޺��ڽ�

        inputW = new JTextField();
        //select ~ where "" like what? ���� ���� �̺�Ʈ ������
        inputW.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent ke){
                //System.out.println(cBox.getSelectedItem().toString());
                String sName = cBox.getSelectedItem().toString();//�޺��ڽ� ������ �� String���� ����
                String temp = inputW.getText();
                if(!temp.equals("")){
                    if(sName.equals("DEPTNO")){                    
                        selectDEPTNO(temp);
                    }else if(sName.equals("DNAME")){
                        selectDNAME(temp);
                    }else if(sName.equals("LOC")){
                        selectLOC(temp);
                    }
                }else{
                    model.setRowCount(0);
                    selectALL();
                }
            }
        });
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

    void clearInputData(){
        inputData1.setEditable(true);
        inputData1.setText("");
        inputData2.setText("");
        inputData3.setText("");
    }



    public static void main(String[] args) {
        new JT3();

    }

    //���̺� ���콺 Ŭ�� �̺�Ʈ
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

