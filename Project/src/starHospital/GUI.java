
//package starHospital;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener{

    Puppy_jdbc pJdbc;

    JPanel cp;
    public static CardLayout cLayout = new CardLayout();
    JButton regisBtn, serchBtn, resrvBtn, medicBtn, recptBtn, staffBtn;
    JButton mEnter,mCommit, mBack, dEnter, dCommit, dBack, mdEnter, mdCommit, mdreset; 
    JButton mupBtn, mccBtn, dupBtn, dccBtn;
    JButton msearch, dsearch, mAll, dAll, mdAll, dogAll, mdAll2;
    JTextField mNumber, mPhone, mName, mAddr;
    JTextField dNumber, dName, dKinds, dAge, dWeight, dSex, dmNumber, mdDname, mdSec, mddscode, mdtrcode;
    JTextField mInputSearch, dInputSearch, dInputSearch2, mdInputSearch;
    JTextField mupnum, mupname, mupphone, mupaddr;
    JTextField dupnum, dupname, dupkinds, dupwg, dupage, dupsex;
    static JTextField bw1B, bw2B, bw3B, bw4B, be1B, be2B, be3B;
    JTable mJTable, dJTable, dJTable2, mdJTable;
    JPanel register, search, reserve, medical, receipt, staff;
    JPanel mData, dData, mtableP, dtableP, updateP, dupdateP;
    JPanel cardP, centerP;
    JLabel label;
    JTabbedPane tabs;

    static String mcolNames[] = {"ȸ����ȣ","����ó","�ݷ��� ����", "�ּ�"};
    static String dcolNames[] = {"�ݷ��߹�ȣ","�ݷ����̸�","����", "����", "����", "����", "���ʹ湮��", "ȸ����ȣ"};
    static String dcombo[] = {"�ݷ��߹�ȣ","�ݷ����̸�","ȸ����ȣ"};
    static String mdcombo[] = {"�����ȣ","�ݷ��߹�ȣ","�����ȣ"};
    static String mdcolNames[] = {"�����ȣ","�ݷ��߹�ȣ","���ᱸ��", "�����ڵ�", "ġ���ڵ�"};
    static String bcolNames[] = {"�����ȣ","���ܺ�","ġ���"};
    static DefaultTableModel mModel = new DefaultTableModel(mcolNames, 0); //ȸ�� ���̺�
    static DefaultTableModel dModel = new DefaultTableModel(dcolNames, 0); //�� ���̺�
    static DefaultTableModel mdModel = new DefaultTableModel(mdcolNames, 0); //����ī�� ���̺�
    static DefaultTableModel bModel = new DefaultTableModel(bcolNames, 0);
    JComboBox cBox1, cBox2;




    GUI(){

        pJdbc = new Puppy_jdbc();



        Color color = new Color(0x234e85);
        Font font = new Font("���� ���", Font.BOLD, 20);
        Font cFont = new Font("���� ���", Font.PLAIN, 15);

        cp = new JPanel();
        setContentPane(cp);
        cp.setLayout(new BorderLayout(20, 20));

        setRegister();
        setSearch();
        setMedical();
        setReceipt();

        // <-----�޴� ��ư------->
        JPanel westP = new JPanel();
        westP.setBackground(color);
        cp.add(westP, BorderLayout.WEST);
        westP.setLayout(new BorderLayout(0, 0));

        JPanel menuP = new JPanel();
        menuP.setPreferredSize(new Dimension(200,0));
        menuP.setBackground(color);
        westP.add(menuP);
        menuP.setLayout(new BoxLayout(menuP, BoxLayout.Y_AXIS));

        regisBtn = new JButton();
        //regisBtn.setIcon(new ImageIcon("img\\starHospital\\menu1.png"));
        regisBtn.setIcon(new ImageIcon("img\\menu1.png"));
        regisBtn.setBorderPainted(false);
        regisBtn.setContentAreaFilled(false);
        regisBtn.setMargin(new Insets(0,0,0,0));
        menuP.add(regisBtn);

        serchBtn = new JButton();
        serchBtn.setIcon(new ImageIcon("img\\menu2.png"));
        serchBtn.setBorderPainted(false);
        serchBtn.setContentAreaFilled(false);
        serchBtn.setMargin(new Insets(0,0,0,0));
        menuP.add(serchBtn);



        medicBtn = new JButton();
        medicBtn.setIcon(new ImageIcon("img\\menu4.png"));
        medicBtn.setBorderPainted(false);
        medicBtn.setContentAreaFilled(false);
        medicBtn.setMargin(new Insets(0,0,0,0));
        menuP.add(medicBtn);

        recptBtn = new JButton();
        recptBtn.setIcon(new ImageIcon("img\\menu5.png"));
        recptBtn.setBorderPainted(false);
        recptBtn.setContentAreaFilled(false);
        recptBtn.setMargin(new Insets(0,0,0,0));
        menuP.add(recptBtn);

        // staffBtn = new JButton();
        // staffBtn.setIcon(new ImageIcon("img\\menu6.png"));
        // staffBtn.setBorderPainted(false);
        // staffBtn.setContentAreaFilled(false);
        // staffBtn.setMargin(new Insets(0,0,0,0));
        // menuP.add(staffBtn);
      
        centerP = new JPanel(cLayout);
        cp.add(centerP, BorderLayout.CENTER);
        centerP.add(register,"1");
        centerP.add(search,"2");
        centerP.add(medical,"3");
        centerP.add(receipt,"4");



        regisBtn.addActionListener(this);
        serchBtn.addActionListener(this);
        medicBtn.addActionListener(this);
        recptBtn.addActionListener(this);


        setUI();

    }

    void setRegister(){
        Color color = new Color(0x234e85);
        Font font = new Font("���� ���", Font.BOLD, 20);
        Font cFont = new Font("���� ���", Font.PLAIN, 15);
        //1. ȸ����� ȭ��
        //ȸ����� ��ü ����
        register = new JPanel();
        register.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 20 , 20)); 
        register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));


        //1-1. ȸ�������Է�
        //���� ���� �Է� ����
        mData = new JPanel();
        mData.setLayout(new BorderLayout(0,30));
        mData.setBorder(new TitledBorder(null, "ȸ�������Է�", TitledBorder.LEADING, TitledBorder.TOP, font, null));
        mData.setBackground(Color.WHITE);

        //<---------------ȸ���ʵ� �������----------------->
        JPanel mcenter = new JPanel();
        mcenter.setLayout(new GridLayout(3,4,20,10));
        mcenter.setBackground(Color.WHITE);
        mcenter.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 0 , 50));
        JLabel mNumberLabel = new JLabel("ȸ�� ��ȣ");
        mNumberLabel.setFont(cFont);
        mNumberLabel.setHorizontalAlignment(4);
        mNumber = new JTextField();
        JLabel mNameLabel = new JLabel("�̸�");
        mNameLabel.setFont(cFont);
        mNameLabel.setHorizontalAlignment(4);
        mName = new JTextField();
        JLabel mPhoneLabel = new JLabel("����ó");
        mPhoneLabel.setFont(cFont);
        mPhoneLabel.setHorizontalAlignment(4);
        mPhone = new JTextField();
        JLabel mAddrLabel = new JLabel("�ּ�");
        mAddrLabel.setFont(cFont);
        mAddrLabel.setHorizontalAlignment(4);
        mAddr = new JTextField();

        mcenter.add(mNumberLabel);
        mcenter.add(mNumber);
        mcenter.add(new JLabel());
        mcenter.add(new JLabel());
        mcenter.add(mNameLabel);
        mcenter.add(mName);
        mcenter.add(mPhoneLabel);
        mcenter.add(mPhone);
        mcenter.add(mAddrLabel);
        mcenter.add(mAddr);
        mcenter.add(new JLabel());
        mcenter.add(new JLabel());


        JPanel msouth = new JPanel();
        msouth.setBackground(Color.WHITE);
        msouth.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 10 , 50));
        msouth.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
        mEnter = new JButton("����");
        mCommit = new JButton("���");
        mBack = new JButton("���");

        mBack.addActionListener(this);
        mEnter.addActionListener(this);
        mCommit.addActionListener(this);

        mEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        mCommit.setFont(new Font("���� ���", Font.BOLD, 14));
        mBack.setFont(new Font("���� ���", Font.BOLD, 14));
        msouth.add(mBack);
        msouth.add(mEnter);
        msouth.add(mCommit);


        mData.add(mcenter, BorderLayout.CENTER);
        mData.add(msouth, BorderLayout.SOUTH);


        //������ ���� �Է�
        dData = new JPanel();
        dData.setLayout(new BorderLayout(0,30));
        dData.setBorder(new TitledBorder(null, "ȯ�������Է�", TitledBorder.LEADING, TitledBorder.TOP, font, null));
        dData.setBackground(Color.WHITE);

        //<---------------�������ʵ� �������----------------->
        JPanel dcenter = new JPanel();
        dcenter.setLayout(new GridLayout(4,4,20,10));
        dcenter.setBackground(Color.WHITE);
        dcenter.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 0 , 50));
        JLabel dNumberLabel = new JLabel("ȯ�� ��ȣ");
        dNumberLabel.setFont(cFont);
        dNumber = new JTextField();
        dNumberLabel.setHorizontalAlignment(4);
        JLabel dmNumberLabel = new JLabel("ȸ�� ��ȣ");
        dmNumberLabel.setFont(cFont);
        dmNumberLabel.setHorizontalAlignment(4);
        dmNumber = new JTextField();
        JLabel dNameLabel = new JLabel("ȯ�� �̸�");
        dNameLabel.setFont(cFont);
        dNameLabel.setHorizontalAlignment(4);
        dName = new JTextField();
        JLabel dKindsLabel = new JLabel("����");
        dKindsLabel.setFont(cFont);
        dKindsLabel.setHorizontalAlignment(4);
        dKinds = new JTextField();
        JLabel dWeightLabel = new JLabel("����");
        dWeightLabel.setFont(cFont);
        dWeightLabel.setHorizontalAlignment(4);
        dWeight = new JTextField();
        JLabel dAgeLabel = new JLabel("����");
        dAgeLabel.setFont(cFont);
        dAgeLabel.setHorizontalAlignment(4);
        dAge = new JTextField();
        JLabel dSexLabel = new JLabel("����");
        dSexLabel.setFont(cFont);
        dSexLabel.setHorizontalAlignment(4);
        dSex = new JTextField();

        dcenter.add(dNumberLabel);
        dcenter.add(dNumber);
        dcenter.add(dmNumberLabel);
        dcenter.add(dmNumber);
        dcenter.add(dNameLabel);
        dcenter.add(dName);
        dcenter.add(new JLabel());
        dcenter.add(new JLabel());
        dcenter.add(dKindsLabel);
        dcenter.add(dKinds);
        dcenter.add(dWeightLabel);
        dcenter.add(dWeight);
        dcenter.add(dAgeLabel);
        dcenter.add(dAge);
        dcenter.add(dSexLabel);
        dcenter.add(dSex);


        JPanel dsouth = new JPanel();
        dsouth.setBackground(Color.WHITE);
        dsouth.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 10 , 50));
        dsouth.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
        dEnter = new JButton("����"); //enter
        dCommit = new JButton("���"); //commit
        dBack = new JButton("���"); //rollback
        dEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        dCommit.setFont(new Font("���� ���", Font.BOLD, 14));
        dBack.setFont(new Font("���� ���", Font.BOLD, 14));
        dsouth.add(dBack);
        dsouth.add(dEnter);
        dsouth.add(dCommit);
        dBack.addActionListener(this);
        dEnter.addActionListener(this);
        dCommit.addActionListener(this);
        
        dData.add(dcenter, BorderLayout.CENTER);
        dData.add(dsouth, BorderLayout.SOUTH);


        //register �гο� �� �г��� �÷ο췹�̾ƿ����� ��
        register.add(mData);
        register.add(dData);

    }

    void setSearch(){
        pJdbc.selectMOMAll();
        //pJdbc.selectDOGAll();
        Color color = new Color(0x234e85);
        Font font = new Font("���� ���", Font.BOLD, 20);
        Font cFont = new Font("���� ���", Font.PLAIN, 15);
        
        //2. ȸ������ ȭ��
        search = new JPanel();
        search.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 10 , 10)); //���� �׵θ�
        search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));

        //2-1. ȸ��������ȸ (JTable)
        //ȸ�� ���̺� ��ü ����
        mtableP = new JPanel(); 
        mtableP.setLayout(new BorderLayout(0,0));

        //�˻�â ����
        JPanel mNorth = new JPanel(); 
        mNorth.setLayout(new BorderLayout(0,0));

        JLabel northTop = new JLabel("ȸ����ȸ");
        northTop.setFont(new Font("���� ���", Font.BOLD, 15));
        mNorth.add(northTop, BorderLayout.NORTH);

        JPanel northBot = new JPanel();
        northBot.setLayout(new BoxLayout(northBot, BoxLayout.X_AXIS));
        cBox1 = new JComboBox<String>(mcolNames); //�޺��ڽ�
        mInputSearch = new JTextField("",30);
        mInputSearch.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent ke){
                //System.out.println(cBox.getSelectedItem().toString());
                String sName = cBox1.getSelectedItem().toString();//�޺��ڽ� ������ �� String���� ����
                String temp = mInputSearch.getText();
                if(!temp.equals("")){
                    if(sName.equals("ȸ����ȣ")){                    
                        pJdbc.selectMOM1(temp);
                    }else if(sName.equals("����ó")){
                        pJdbc.selectMOM2(temp);
                    }else if(sName.equals("�ݷ��� ����")){
                        pJdbc.selectMOM3(temp);
                    }else if(sName.equals("�ּ�")){
                        pJdbc.selectMOM4(temp);
                    }
                }else{
                    mModel.setRowCount(0);
                    pJdbc.selectMOMAll();
                }
            }
        });


        msearch = new JButton(" �˻� ");
        mAll = new JButton("��ü����");
        mAll.addActionListener(this);
        northBot.add(cBox1);
        northBot.add(mInputSearch);
        //northBot.add(msearch);
        northBot.add(mAll);
        mNorth.add(northBot, BorderLayout.CENTER);


        //���â ����
        JPanel mCenter = new JPanel(); //���̺�κ�
        mCenter.setLayout(new BoxLayout(mCenter, BoxLayout.Y_AXIS));
        mJTable = new JTable(mModel);
        mJTable.addMouseListener(new MJTableMouseListener());
        JScrollPane sp = new JScrollPane(mJTable);
        mCenter.add(sp);

        mtableP.add(mNorth, BorderLayout.NORTH);
        mtableP.add(mCenter, BorderLayout.CENTER);

        //2-2. ȯ��������ȸ (JTable)
        //ȯ�� ���̺� ��ü ����
        dtableP = new JPanel(); 
        dtableP.setLayout(new BorderLayout(0,0));

        //�˻�â ����
        JPanel dNorth = new JPanel(); 
        dNorth.setLayout(new BorderLayout(0,0));

        JLabel dnorthTop = new JLabel("ȯ����ȸ");
        dnorthTop.setFont(new Font("���� ���", Font.BOLD, 15));
        dNorth.add(dnorthTop, BorderLayout.NORTH);

        JPanel dnorthBot = new JPanel();
        dnorthBot.setLayout(new BoxLayout(dnorthBot, BoxLayout.X_AXIS));
        cBox2 = new JComboBox<String>(dcombo); //�޺��ڽ�
        dInputSearch = new JTextField("",30);
        dInputSearch.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent ke){
                //System.out.println(cBox.getSelectedItem().toString());
                String sName = cBox2.getSelectedItem().toString();//�޺��ڽ� ������ �� String���� ����
                String temp1 = dInputSearch.getText();
                if(!temp1.equals("")){
                    if(sName.equals("�ݷ��߹�ȣ")){                    
                        pJdbc.selectDOG1(temp1);
                    }else if(sName.equals("�ݷ����̸�")){
                        pJdbc.selectDOG2(temp1);
                    }else if(sName.equals("ȸ����ȣ")){
                        pJdbc.selectDOG3(temp1);
                    }
                }else{
                    dModel.setRowCount(0);
                    pJdbc.selectDOGAll();
                }
            }
        });

        dsearch = new JButton(" �˻� ");
        dogAll = new JButton("��ü����");
        dogAll.addActionListener(this);
        dnorthBot.add(cBox2);
        dnorthBot.add(dInputSearch);
        // dnorthBot.add(dsearch);
        dnorthBot.add(dogAll);
        dNorth.add(dnorthBot, BorderLayout.CENTER);

        //���â ����
        JPanel dCenter = new JPanel(); //���̺�κ�
        dCenter.setLayout(new BoxLayout(dCenter, BoxLayout.Y_AXIS));
        dJTable = new JTable(dModel);
        dJTable.addMouseListener(new DJTableMouseListener());
        JScrollPane sp2 = new JScrollPane(dJTable);
        dCenter.add(sp2);

        dtableP.add(dNorth, BorderLayout.NORTH);
        dtableP.add(dCenter, BorderLayout.CENTER);


        //2-3. ��ȸ �� ������Ʈ
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        updateP = new JPanel();
        updateP.setLayout(new GridLayout(4,4,20,0));
        
        mupBtn = new JButton("�⺻��������");
        mccBtn = new JButton("����");
        mupBtn.addActionListener(this);
        mccBtn.addActionListener(this);

        JLabel mupnumLabel = new JLabel("ȸ�� ��ȣ");
        mupnumLabel.setFont(cFont);
        mupnumLabel.setHorizontalAlignment(4);
        mupnum = new JTextField();
        




        JLabel mupnameLabel = new JLabel("�̸�");
        mupnameLabel.setFont(cFont);
        mupnameLabel.setHorizontalAlignment(4);
        mupname = new JTextField();
        JLabel mupphoneLabel = new JLabel("����ó");
        mupphoneLabel.setFont(cFont);
        mupphoneLabel.setHorizontalAlignment(4);
        mupphone = new JTextField();
        JLabel mupaddrLabel = new JLabel("�ּ�");
        mupaddrLabel.setFont(cFont);
        mupaddrLabel.setHorizontalAlignment(4);
        mupaddr = new JTextField();

        updateP.add(mupnumLabel);
        updateP.add(mupnum);
        updateP.add(mupnameLabel);
        updateP.add(mupname);
        updateP.add(mupphoneLabel);
        updateP.add(mupphone);
        updateP.add(mupaddrLabel);
        updateP.add(mupaddr);
        updateP.add(new JLabel());
        updateP.add(new JLabel());
        updateP.add(new JLabel());
        updateP.add(new JLabel());
        updateP.add(new JLabel());
        updateP.add(new JLabel());
        updateP.add(mupBtn);
        updateP.add(mccBtn);


        dupdateP = new JPanel();
        dupdateP.setLayout(new GridLayout(4,4,20,0));
        
        dupBtn = new JButton("�⺻��������");
        dupBtn.addActionListener(this);
        dccBtn = new JButton("����");
        dccBtn.addActionListener(this);
        

        JLabel dupnumLabel = new JLabel("ȯ�� ��ȣ");
        dupnumLabel.setFont(cFont);
        dupnumLabel.setHorizontalAlignment(4);
        dupnum = new JTextField();

        JLabel dupnameLabel = new JLabel("ȯ�� �̸�");
        dupnameLabel.setFont(cFont);
        dupnameLabel.setHorizontalAlignment(4);
        dupname = new JTextField();
        JLabel dupkindsLabel = new JLabel("����");
        dupkindsLabel.setFont(cFont);
        dupkindsLabel.setHorizontalAlignment(4);
        dupkinds = new JTextField();

        JLabel dupwgLabel = new JLabel("����");
        dupwgLabel.setFont(cFont);
        dupwgLabel.setHorizontalAlignment(4);
        dupwg = new JTextField();
        JLabel dupageLabel = new JLabel("����");
        dupageLabel.setFont(cFont);
        dupageLabel.setHorizontalAlignment(4);
        dupage = new JTextField();
        JLabel dupsexLabel = new JLabel("����");
        dupsexLabel.setFont(cFont);
        dupsexLabel.setHorizontalAlignment(4);
        dupsex = new JTextField();



        dupdateP.add(dupnumLabel);
        dupdateP.add(dupnum);
        dupdateP.add(dupnameLabel);
        dupdateP.add(dupname);
        dupdateP.add(dupkindsLabel);
        dupdateP.add(dupkinds);
        dupdateP.add(dupwgLabel);
        dupdateP.add(dupwg);
        dupdateP.add(dupageLabel);
        dupdateP.add(dupage);
        dupdateP.add(dupsexLabel);
        dupdateP.add(dupsex);
        dupdateP.add(new JLabel());
        dupdateP.add(new JLabel());
        dupdateP.add(dupBtn);
        dupdateP.add(dccBtn);

        tabs.addTab("ȸ����������", updateP);
        tabs.addTab("ȯ����������", dupdateP);

        search.add(mtableP);
        search.add(dtableP);
        search.add(tabs);


    }

    void setMedical(){
        pJdbc.selectDOGAll();
        Color color = new Color(0x234e85);
        Font font = new Font("���� ���", Font.BOLD, 20);
        Font cFont = new Font("���� ���", Font.PLAIN, 15);
        //3. ����ī�� ȭ��
        medical = new JPanel();
        medical.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 10 , 20)); //���� �׵θ�
        medical.setLayout(new BoxLayout(medical, BoxLayout.Y_AXIS));

        //3-1. ȯ��������ȸ
        //ȯ�� ���̺� ��ü ����
        JPanel mediTb = new JPanel();
        mediTb.setLayout(new BorderLayout(0,0));

        //�˻�â ����
        JPanel meNorth = new JPanel(); 
        meNorth.setLayout(new BorderLayout(0,0));
        
        JLabel meNorthTop = new JLabel("ȯ�ڱ⺻������ȸ");
        meNorthTop.setFont(font);
        meNorth.add(meNorthTop,BorderLayout.NORTH);

        JPanel meNorthBot = new JPanel();
        meNorthBot.setLayout(new BoxLayout(meNorthBot, BoxLayout.X_AXIS));
        JComboBox cBox3 = new JComboBox<String>(dcombo); //�޺��ڽ�
        dInputSearch2 = new JTextField("",30);
        dInputSearch2.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent ke){
                String sName = cBox3.getSelectedItem().toString();//�޺��ڽ� ������ �� String���� ����
                String temp1 = dInputSearch2.getText();
                if(!temp1.equals("")){
                    if(sName.equals("�ݷ��߹�ȣ")){                    
                        pJdbc.selectDOG1(temp1);
                    }else if(sName.equals("�ݷ����̸�")){
                        pJdbc.selectDOG2(temp1);
                    }else if(sName.equals("ȸ����ȣ")){
                        pJdbc.selectDOG3(temp1);
                    }
                }else{
                    dModel.setRowCount(0);
                    pJdbc.selectDOGAll();
                }
            }
        });
        //dsearch = new JButton(" �˻� ");
        mdAll = new JButton("��ü����");
        mdAll.addActionListener(this);
        meNorthBot.add(cBox3);
        meNorthBot.add(dInputSearch2);
        //meNorthBot.add(dsearch);
        meNorthBot.add(mdAll);
        meNorth.add(meNorthBot, BorderLayout.CENTER);

        JPanel meCenter = new JPanel();
        meCenter.setLayout(new BoxLayout(meCenter, BoxLayout.Y_AXIS));
        dJTable2 = new JTable(dModel);
        JScrollPane sp3 = new JScrollPane(dJTable2);
        dJTable2.addMouseListener(new DJTable2MouseListener());
        meCenter.add(sp3);

        mediTb.add(meNorth, BorderLayout.NORTH);
        mediTb.add(meCenter, BorderLayout.CENTER);





        //����ī�� ��ü ����
        JPanel mediData = new JPanel();
        mediData.setLayout(new BorderLayout(0,0));
        mediData.setBorder(new TitledBorder(null, "����ī���Է�", TitledBorder.LEADING, TitledBorder.TOP, font, null));
        mediData.setBackground(Color.WHITE);

        //����ī�� �Է��ϴ� �κ�
        JPanel medicenter = new JPanel();
        medicenter.setLayout(new GridLayout(2,4,20,10));
        medicenter.setBackground(Color.WHITE);
        medicenter.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 30 , 50));

        JLabel mdDnamelb = new JLabel("ȯ�� ��ȣ");
        mdDnamelb.setFont(cFont);
        mdDnamelb.setHorizontalAlignment(4);
        mdDname = new JTextField();

        JLabel mdSeclb = new JLabel("���� ����");
        mdSeclb.setFont(cFont);
        mdSeclb.setHorizontalAlignment(4);
        mdSec = new JTextField();

        JLabel mddscodelb = new JLabel("�����ڵ�");
        mddscodelb.setFont(cFont);
        mddscodelb.setHorizontalAlignment(4);
        mddscode = new JTextField();

        JLabel mdtrcodelb = new JLabel("ġ���ڵ�");
        mdtrcodelb.setFont(cFont);
        mdtrcodelb.setHorizontalAlignment(4);
        mdtrcode = new JTextField();

        medicenter.add(mdDnamelb);
        medicenter.add(mdDname);
        // medicenter.add(mdDatelb);
        // medicenter.add(mdNumber);
        medicenter.add(mdSeclb);
        medicenter.add(mdSec);
        medicenter.add(mddscodelb);
        medicenter.add(mddscode);
        medicenter.add(mdtrcodelb);
        medicenter.add(mdtrcode);

        
        JPanel medisouth = new JPanel();
        medisouth.setBackground(Color.WHITE);
        medisouth.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 10 , 50));
        medisouth.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
        mdreset = new JButton("���Է�");
        mdreset.addActionListener(this);
        mdEnter = new JButton("����");
        mdEnter.addActionListener(this);
        mdCommit = new JButton("���");
        mdEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        mdCommit.setFont(new Font("���� ���", Font.BOLD, 14));
        mdreset.setFont(new Font("���� ���", Font.BOLD, 14));
        medisouth.add(mdreset);
        medisouth.add(mdEnter);
        medisouth.add(mdCommit);


        mediData.add(medicenter); //����ī�忡 �߰�
        mediData.add(medisouth, BorderLayout.SOUTH);
        
        medical.add(mediTb);
        medical.add(mediData);

    }

    void setReceipt(){
        pJdbc.selectMDAll();
        Color color = new Color(0x234e85);
        Font font = new Font("���� ���", Font.BOLD, 20);
        Font cFont = new Font("���� ���", Font.PLAIN, 15);
        //4. ���� ȭ��
        receipt = new JPanel();
        receipt.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 10 , 20)); //���� �׵θ�
        receipt.setLayout(new BoxLayout(receipt, BoxLayout.Y_AXIS));


        //4-1. ����ī����ȸ
        //����ī�� ���̺� ��ü ����
        JPanel mdTb = new JPanel();
        mdTb.setLayout(new BorderLayout(0,0));

        //�˻�â ����
        JPanel mdNorth = new JPanel(); 
        mdNorth.setLayout(new BorderLayout(0,0));

        JLabel mdNorthTop = new JLabel("����ī����ȸ");
        mdNorthTop.setFont(font);
        mdNorth.add(mdNorthTop,BorderLayout.NORTH);

        JPanel mdNorthBot = new JPanel();
        mdNorthBot.setLayout(new BoxLayout(mdNorthBot, BoxLayout.X_AXIS));
        JComboBox cBox4 = new JComboBox<String>(mdcombo); //�޺��ڽ�
        mdInputSearch = new JTextField("",30);
        mdInputSearch.addKeyListener(new KeyAdapter(){
            public void keyReleased(KeyEvent ke){
                //System.out.println(cBox.getSelectedItem().toString());
                String sName = cBox4.getSelectedItem().toString();//�޺��ڽ� ������ �� String���� ����
                String temp = mdInputSearch.getText();
                if(!temp.equals("")){
                    if(sName.equals("�����ȣ")){                    
                        pJdbc.selectMD1(temp);
                    }else if(sName.equals("�ݷ��߹�ȣ")){
                        pJdbc.selectMD2(temp);
                    }else if(sName.equals("���ᱸ��")){
                        pJdbc.selectMD3(temp);
                    }
                }else{
                    mdModel.setRowCount(0);
                    pJdbc.selectMDAll();
                }
            }
        });
        JButton mdsearch = new JButton(" �˻� ");
        mdAll2 = new JButton("��ü����");
        mdAll2.addActionListener(this);
        mdNorthBot.add(cBox4);
        mdNorthBot.add(mdInputSearch);
        //mdNorthBot.add(mdsearch);
        mdNorthBot.add(mdAll2);
        mdNorth.add(mdNorthBot, BorderLayout.CENTER);

        //����ī�� ���̺� ����
        JPanel billCenter = new JPanel();
        billCenter.setLayout(new BoxLayout(billCenter, BoxLayout.Y_AXIS));
        mdJTable = new JTable(mdModel);
        mdJTable.addMouseListener(new mdJTableMouseListener());
        JScrollPane sp4 = new JScrollPane(mdJTable);
        billCenter.add(sp4);

        mdTb.add(mdNorth, BorderLayout.NORTH);
        mdTb.add(billCenter, BorderLayout.CENTER);


        //����� ��꼭 ����
        JPanel billP = new JPanel();

        billP.setLayout(new BoxLayout(billP, BoxLayout.X_AXIS));
        billP.setBorder(new TitledBorder(null, "����񳻿���", TitledBorder.LEADING, TitledBorder.TOP, font, null));
        billP.setPreferredSize(new Dimension(0,300));
        //billP.setBackground(Color.WHITE);

        JPanel billWest = new JPanel();
        billWest.setBorder(BorderFactory.createEmptyBorder(20 , 20 , 20 , 20)); 
        billWest.setLayout(new GridLayout(4,2,10,10));



        JLabel bw1A = new JLabel("�����ȣ");
        bw1A.setFont(cFont);
        bw1B = new JTextField();
        bw1B.setEditable(false);
        billWest.add(bw1A);
        billWest.add(bw1B);


        JLabel bw2A = new JLabel("ȯ���̸�");
        bw2A.setFont(cFont);
        bw2B = new JTextField();
        bw2B.setEditable(false);
        billWest.add(bw2A);
        billWest.add(bw2B);


        JLabel bw3A = new JLabel("����");
        bw3A.setFont(cFont);
        bw3B = new JTextField();
        bw3B.setEditable(false);
        billWest.add(bw3A);
        billWest.add(bw3B);


        JLabel bw4A = new JLabel("ġ���Ī");
        bw4A.setFont(cFont);
        bw4B = new JTextField();
        bw4B.setEditable(false);
        billWest.add(bw4A);
        billWest.add(bw4B);


        JPanel billEast = new JPanel();
        billEast.setBorder(BorderFactory.createEmptyBorder(20 , 20 , 20 , 20));
        billEast.setLayout(new GridLayout(4,2,10,10));


        JLabel be1A = new JLabel("���ܺ�");
        be1A.setFont(cFont);
        be1B = new JTextField();
        be1B.setEditable(false);
        billEast.add(be1A);
        billEast.add(be1B);


        JLabel be2A = new JLabel("ġ���");
        be2A.setFont(cFont);
        be2B = new JTextField();
        be2B.setEditable(false);
        billEast.add(be2A);
        billEast.add(be2B);

        JLabel be3A = new JLabel("����");
        be3A.setFont(cFont);
        be3B = new JTextField();
        be3B.setEditable(false);
        billEast.add(new JLabel(""));
        billEast.add(new JLabel(""));
        billEast.add(new JLabel(""));
        billEast.add(new JLabel(""));

        billP.add(billWest);
        billP.add(billEast);

        receipt.add(mdTb);
        receipt.add(billP);
        
    }

    void setUI(){
		setTitle("JTable Test Ver 1.0");
		setSize(960, 580);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {
        new GUI();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==regisBtn){
            cLayout.show(centerP,"1");
        }else if(e.getSource()==serchBtn){
            cLayout.show(centerP,"2");
        }else if(e.getSource()==medicBtn){
            cLayout.show(centerP,"3");
        }else if(e.getSource()==recptBtn){
            cLayout.show(centerP,"4");
        }
        
        
        if(e.getSource()==mBack){
            //rollback    
        }else if(e.getSource()==mEnter){
            DefaultTableModel mModel = (DefaultTableModel)mJTable.getModel();
            String M_NUMBER = mNumber.getText();
            String M_NAME= mName.getText();
            String M_PHONE= mPhone.getText();
            String M_ADDR = mAddr.getText();
            pln(M_NUMBER+M_NAME+M_PHONE+M_ADDR);
            pJdbc.insertMOM(M_NUMBER,M_PHONE,M_NAME,M_ADDR);
            mModel.setRowCount(0);
            mNumber.setText("");
            mName.setText("");
            mPhone.setText("");
            mAddr.setText("");

        }else if(e.getSource()==mCommit){
            //commit
        }
        
        if(e.getSource()==dBack){
            //rollback    
        }else if(e.getSource()==dEnter){
            DefaultTableModel dModel = (DefaultTableModel)dJTable.getModel();
            String D_NUMBER = dNumber.getText();
            String D_NAME= dName.getText();
            String D_KINDS= dKinds.getText();
            String D_AGE= dAge.getText();
            String D_WEIGHT= dWeight.getText();
            String D_SEX= dSex.getText();
            String M_NUMBER= dmNumber.getText();
            pln(D_NUMBER+D_NAME+D_KINDS+D_AGE+D_WEIGHT+D_SEX);
            pJdbc.insertDOG(D_NUMBER,D_NAME,D_KINDS,D_AGE,D_WEIGHT,D_SEX,M_NUMBER);
            dModel.setRowCount(0);
            dNumber.setText("");
            dName.setText("");
            dKinds.setText("");
            dAge.setText("");
            dWeight.setText("");
            dSex.setText("");
            dmNumber.setText("");

        }else if(e.getSource()==dCommit){
            //commit
        }
        if(e.getSource()==mupBtn){

            if(mJTable.getSelectedRow() != -1){
                DefaultTableModel mModel = (DefaultTableModel)mJTable.getModel();
                int row = mJTable.getSelectedRow();
                String M_NUMBER = mupnum.getText();
                String M_NAME = mupname.getText();
                String M_PHONE= mupphone.getText();
                String M_ADDR= mupaddr.getText();

                pJdbc.updateMOM(M_PHONE, M_NAME, M_ADDR,M_NUMBER);
                mModel.setRowCount(0);
                pJdbc.selectMOMAll();
                mupnum.setText("");
                mupname.setText("");
                mupphone.setText("");
                mupaddr.setText("");

            }
        }else if(e.getSource()==mAll){
            mModel.setRowCount(0);
            mInputSearch.setText("");
            pJdbc.selectMOMAll();
        }else if(e.getSource()==mccBtn){
            if(mJTable.getSelectedRow() != -1){
                DefaultTableModel mModel = (DefaultTableModel)mJTable.getModel();
                int row = mJTable.getSelectedRow();
                String M_NUMBER = String.valueOf(mJTable.getValueAt(row, 0));
                pJdbc.deleteMOM(M_NUMBER);

                mModel.setRowCount(0);
                pJdbc.selectMOMAll();
            }
        }
        if(e.getSource()==dupBtn){
            DefaultTableModel dModel = (DefaultTableModel)dJTable.getModel();
            int row = dJTable.getSelectedRow();
            String D_NUMBER = dupnum.getText();
            String D_NAME = dupname.getText();
            String D_KINDS= dupkinds.getText();
            String D_WEIGHT = dupwg.getText();
            String D_AGE = dupage.getText();
            String D_SEX= dupsex.getText();
            
            pJdbc.updateDOG(D_NAME, D_KINDS, D_AGE, D_WEIGHT, D_SEX, D_NUMBER);
            dModel.setRowCount(0);
            pJdbc.selectDOGAll();
            dupnum.setText("");
            dupname.setText("");
            dupkinds.setText("");
            dupwg.setText("");
            dupage.setText("");
            dupsex.setText("");

        }else if(e.getSource()==dccBtn){
            if(dJTable.getSelectedRow() != -1){
                DefaultTableModel dModel = (DefaultTableModel)dJTable.getModel();
                int row = dJTable.getSelectedRow();
                String D_NUMBER = String.valueOf(dJTable.getValueAt(row, 0));
                pJdbc.deleteDOG(D_NUMBER);
                dModel.setRowCount(0);
                pJdbc.selectDOGAll();
            }
        }


        if(e.getSource()==dogAll){
            dModel.setRowCount(0);
            dInputSearch.setText("");
            pJdbc.selectDOGAll();
        }
        if(e.getSource()==mdAll){
            dModel.setRowCount(0);
            dInputSearch2.setText("");
            pJdbc.selectDOGAll();
        }

        if(e.getSource()==mdEnter){
            DefaultTableModel mdModel = (DefaultTableModel)mdJTable.getModel();
            String MD_SEC = mdSec.getText();
            String D_NUMBER= mdDname.getText();
            String DS_CODE= mddscode.getText();
            String T_CODE = mdtrcode.getText();
            pln(MD_SEC+D_NUMBER+DS_CODE+T_CODE);
            pJdbc.insertMED(MD_SEC, D_NUMBER, DS_CODE, T_CODE);
            mdModel.setRowCount(0);
            mdDname.setText("");
            mdSec.setText("");
            mddscode.setText("");
            mdtrcode.setText("");
        }else if(e.getSource()==mdreset){
            mdDname.setText("");
            mdSec.setText("");
            mddscode.setText("");
            mdtrcode.setText("");

        }

        if(e.getSource()==mdAll2){
            mdModel.setRowCount(0);
            mdInputSearch.setText("");
            pJdbc.selectMDAll();
        }



    }

    public void pln(String str){
        System.out.println(str);
    }

    //���̺� ���콺 Ŭ�� �̺�Ʈ
    class MJTableMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent me) {
            JTable mJTable = (JTable)me.getSource();
            //1.���õ� ���̺��� �ప
            int row= mJTable.getSelectedRow();
            //2. ���õ� ���̺��� ����
            int column = mJTable.getSelectedColumn();
            //3. ���õ� ��ġ�� ���� ���� ���
            Object data = mJTable.getValueAt(row, column);

            String M_NUMBER = String.valueOf(mModel.getValueAt(row, 0));
            mupnum.setText(M_NUMBER);
            mupnum.setEditable(false);
            String M_PHONE = String.valueOf(mModel.getValueAt(row, 1));
            mupphone.setText(M_PHONE);
            String M_NAME = String.valueOf(mModel.getValueAt(row, 2));
            mupname.setText(M_NAME);
            String M_ADDR = String.valueOf(mModel.getValueAt(row, 3));
            mupaddr.setText(M_ADDR);
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }

    
    class DJTableMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            JTable dJTable = (JTable)me.getSource();
            
            //1.���õ� ���̺��� �ప
            int row= dJTable.getSelectedRow();
            //2. ���õ� ���̺��� ����
            int column = dJTable.getSelectedColumn();
            //3. ���õ� ��ġ�� ���� ���� ���
            Object data = dJTable.getValueAt(row, column);

            String D_NUMBER = String.valueOf(dModel.getValueAt(row, 0));
            dupnum.setText(D_NUMBER);
            dupnum.setEditable(false);
            String D_NAME = String.valueOf(dModel.getValueAt(row, 1));
            dupname.setText(D_NAME);
            String D_KINDS = String.valueOf(dModel.getValueAt(row, 2));
            dupkinds.setText(D_KINDS);
            String D_AGE = String.valueOf(dModel.getValueAt(row, 3));
            dupage.setText(D_AGE);
            String D_WEIGHT = String.valueOf(dModel.getValueAt(row, 4));
            dupwg.setText(D_WEIGHT);
            String D_SEX = String.valueOf(dModel.getValueAt(row, 5));
            dupsex.setText(D_SEX);
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }


    class DJTable2MouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            JTable dJTable2 = (JTable)me.getSource();
            
            //1.���õ� ���̺��� �ప
            int row= dJTable2.getSelectedRow();
            //2. ���õ� ���̺��� ����
            int column = dJTable2.getSelectedColumn();
            //3. ���õ� ��ġ�� ���� ���� ���
            Object data = dJTable2.getValueAt(row, column);

            String D_NUMBER = String.valueOf(dModel.getValueAt(row, 0));
            mdDname.setText(D_NUMBER);
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    class mdJTableMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            JTable mdJTable = (JTable)me.getSource();


            // //1.���õ� ���̺��� �ప
            int row= mdJTable.getSelectedRow();
            // //2. ���õ� ���̺��� ����
            int column = mdJTable.getSelectedColumn();
            // //3. ���õ� ��ġ�� ���� ���� ���
            Object data = mdJTable.getValueAt(row, column);

            String MD_DATE = String.valueOf(mdModel.getValueAt(row, 0));
            bw1B.setText(MD_DATE);
            pJdbc.selectBVCOST(MD_DATE);


            String D_NUMBER = String.valueOf(mdModel.getValueAt(row, 1));
            pJdbc.selectDname(D_NUMBER);
            String DS_CODE = String.valueOf(mdModel.getValueAt(row, 3));
            pJdbc.selectDsname(DS_CODE);
            String T_CODE = String.valueOf(mdModel.getValueAt(row, 4));
            pJdbc.selectThname(T_CODE);
            pJdbc.updateBill(T_CODE,MD_DATE);
            pJdbc.selectBTCOST(MD_DATE);

            //bw4B.setText(T_CODE);
            // String D_WEIGHT = String.valueOf(dModel.getValueAt(row, 4));
            // dupwg.setText(D_WEIGHT);
            // String D_SEX = String.valueOf(dModel.getValueAt(row, 5));
            // dupsex.setText(D_SEX);
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }





        
    }
}
