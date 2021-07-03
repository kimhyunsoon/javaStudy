
//package starHospital;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener{

    JPanel cp;
    public static CardLayout cLayout = new CardLayout();
    JButton regisBtn, serchBtn, resrvBtn, medicBtn, recptBtn, staffBtn;
    JButton mEnter,mCommit, mBack, dEnter, dCommit, dBack, mdEnter, mdCommit, mdBack; 
    JButton msearch, dsearch, mAll, dAll;
    JTextField mNumber, mPhone, mName, mAddr;
    JTextField dNumber, dName, dKinds, dAge, dWeight, dSex;
    JTextField mInputSearch, dInputSearch;
    JTable mJTable, dJTable, mdJTable;
    JPanel register, search, reserve, medical, receipt, staff;
    JPanel mData, dData, mtableP, dtableP, updateP, dupdateP;
    JPanel cardP, centerP;
    JLabel label;
    JTabbedPane tabs;

    String mcolNames[] = {"ȸ����ȣ","����ó","�ݷ��� ����", "�ּ�"};
    String dcolNames[] = {"�ݷ��߹�ȣ","�ݷ����̸�","����", "����", "����", "����", "���ʹ湮��", "ȸ����ȣ"};
    String dcombo[] = {"�ݷ��߹�ȣ","�ݷ����̸�","ȸ����ȣ"};
    String mdcombo[] = {"�����ȣ","�ݷ��߹�ȣ","ȸ����ȣ"};
    String mdcolNames[] = {"�����ȣ","�ݷ��߹�ȣ","���ᱸ��", "�����ڵ�", "ġ���ڵ�"};
    DefaultTableModel mModel = new DefaultTableModel(mcolNames, 0); //ȸ�� ���̺�
    DefaultTableModel dModel = new DefaultTableModel(dcolNames, 0); //ȸ�� ���̺�
    DefaultTableModel mdModel = new DefaultTableModel(mdcolNames, 0); //����ī�� ���̺�
    JComboBox cBox1, cBox2;


    GUI(){

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

        staffBtn = new JButton();
        staffBtn.setIcon(new ImageIcon("img\\menu6.png"));
        staffBtn.setBorderPainted(false);
        staffBtn.setContentAreaFilled(false);
        staffBtn.setMargin(new Insets(0,0,0,0));
        menuP.add(staffBtn);
      
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
        mNumberLabel = new JLabel("ȸ�� ��ȣ");
        mNumberLabel.setFont(cFont);
        mNumberLabel.setHorizontalAlignment(4);
        mNumber = new JTextField();
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
        dcenter.add(mNumberLabel);
        dcenter.add(mNumber);
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
        
        dData.add(dcenter, BorderLayout.CENTER);
        dData.add(dsouth, BorderLayout.SOUTH);


        //register �гο� �� �г��� �÷ο췹�̾ƿ����� ��
        register.add(mData);
        register.add(dData);

    }

    void setSearch(){
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
        msearch = new JButton(" �˻� ");
        mAll = new JButton("��ü����");
        northBot.add(cBox1);
        northBot.add(mInputSearch);
        northBot.add(msearch);
        northBot.add(mAll);
        mNorth.add(northBot, BorderLayout.CENTER);


        //���â ����
        JPanel mCenter = new JPanel(); //���̺�κ�
        mCenter.setLayout(new BoxLayout(mCenter, BoxLayout.Y_AXIS));
        mJTable = new JTable(mModel);
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
        dsearch = new JButton(" �˻� ");
        dAll = new JButton("��ü����");
        dnorthBot.add(cBox2);
        dnorthBot.add(dInputSearch);
        dnorthBot.add(dsearch);
        dnorthBot.add(dAll);
        dNorth.add(dnorthBot, BorderLayout.CENTER);

        //���â ����
        JPanel dCenter = new JPanel(); //���̺�κ�
        dCenter.setLayout(new BoxLayout(dCenter, BoxLayout.Y_AXIS));
        dJTable = new JTable(dModel);
        JScrollPane sp2 = new JScrollPane(dJTable);
        dCenter.add(sp2);

        dtableP.add(dNorth, BorderLayout.NORTH);
        dtableP.add(dCenter, BorderLayout.CENTER);


        //2-3. ��ȸ �� ������Ʈ
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        updateP = new JPanel();
        updateP.setLayout(new GridLayout(4,4,20,0));
        
        JButton mupBtn = new JButton("�⺻��������");
        JButton mccBtn = new JButton("���");

        JLabel mupnumLabel = new JLabel("ȸ�� ��ȣ");
        mupnumLabel.setFont(cFont);
        mupnumLabel.setHorizontalAlignment(4);
        JTextField mupnum = new JTextField();
        JLabel mupnameLabel = new JLabel("�̸�");
        mupnameLabel.setFont(cFont);
        mupnameLabel.setHorizontalAlignment(4);
        JTextField mupname = new JTextField();
        JLabel mupphoneLabel = new JLabel("����ó");
        mupphoneLabel.setFont(cFont);
        mupphoneLabel.setHorizontalAlignment(4);
        JTextField mupphone = new JTextField();
        JLabel mupaddrLabel = new JLabel("�ּ�");
        mupaddrLabel.setFont(cFont);
        mupaddrLabel.setHorizontalAlignment(4);
        JTextField mupaddr = new JTextField();

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
        
        JButton dupBtn = new JButton("�⺻��������");
        JButton dccBtn = new JButton("���");

        JLabel dupnumLabel = new JLabel("ȯ�� ��ȣ");
        dupnumLabel.setFont(cFont);
        dupnumLabel.setHorizontalAlignment(4);
        JTextField dupnum = new JTextField();

        JLabel dupnameLabel = new JLabel("ȯ�� �̸�");
        dupnameLabel.setFont(cFont);
        dupnameLabel.setHorizontalAlignment(4);
        JTextField dupname = new JTextField();
        JLabel dupkindsLabel = new JLabel("����");
        dupkindsLabel.setFont(cFont);
        dupkindsLabel.setHorizontalAlignment(4);
        JTextField dupkinds = new JTextField();

        JLabel dupwgLabel = new JLabel("����");
        dupwgLabel.setFont(cFont);
        dupwgLabel.setHorizontalAlignment(4);
        JTextField dupwg = new JTextField();
        JLabel dupageLabel = new JLabel("����");
        dupageLabel.setFont(cFont);
        dupageLabel.setHorizontalAlignment(4);
        JTextField dupage = new JTextField();
        JLabel dupsexLabel = new JLabel("����");
        dupsexLabel.setFont(cFont);
        dupsexLabel.setHorizontalAlignment(4);
        JTextField dupsex = new JTextField();



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
        dInputSearch = new JTextField("",30);
        dsearch = new JButton(" �˻� ");
        dAll = new JButton("��ü����");
        meNorthBot.add(cBox3);
        meNorthBot.add(dInputSearch);
        meNorthBot.add(dsearch);
        meNorthBot.add(dAll);
        meNorth.add(meNorthBot, BorderLayout.CENTER);

        JPanel meCenter = new JPanel();
        meCenter.setLayout(new BoxLayout(meCenter, BoxLayout.Y_AXIS));
        dJTable = new JTable(dModel);
        JScrollPane sp3 = new JScrollPane(dJTable);
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
        medicenter.setLayout(new GridLayout(3,4,20,10));
        medicenter.setBackground(Color.WHITE);
        medicenter.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 30 , 50));

        JLabel mdDnamelb = new JLabel("ȯ�� ��ȣ");
        mdDnamelb.setFont(cFont);
        mdDnamelb.setHorizontalAlignment(4);
        JTextField mdDname = new JTextField();

        JLabel mdDatelb = new JLabel("���� ��ȣ");
        mdDatelb.setFont(cFont);
        mdDatelb.setHorizontalAlignment(4);
        JTextField mdNumber = new JTextField();

        JLabel mdSeclb = new JLabel("���� ����");
        mdSeclb.setFont(cFont);
        mdSeclb.setHorizontalAlignment(4);
        JPanel radioadd = new JPanel();
        radioadd.setBackground(Color.WHITE);
        JRadioButton radioBtn1 = new JRadioButton("����",true);
        JRadioButton radioBtn2 = new JRadioButton("ġ��",false);
        radioBtn1.setBackground(Color.WHITE);
        radioBtn2.setBackground(Color.WHITE);
        radioadd.add(radioBtn1);
        radioadd.add(radioBtn2);

        JLabel mddscodelb = new JLabel("�����ڵ�");
        mddscodelb.setFont(cFont);
        mddscodelb.setHorizontalAlignment(4);
        JTextField mddscode = new JTextField();

        JLabel mdtrcodelb = new JLabel("ġ���ڵ�");
        mdtrcodelb.setFont(cFont);
        mdtrcodelb.setHorizontalAlignment(4);
        JTextField mdtrcode = new JTextField();

        medicenter.add(mdDnamelb);
        medicenter.add(mdDname);
        medicenter.add(mdDatelb);
        medicenter.add(mdNumber);
        medicenter.add(mdSeclb);
        medicenter.add(radioadd);
        medicenter.add(mddscodelb);
        medicenter.add(mddscode);
        medicenter.add(mdtrcodelb);
        medicenter.add(mdtrcode);

        
        JPanel medisouth = new JPanel();
        medisouth.setBackground(Color.WHITE);
        medisouth.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 10 , 50));
        medisouth.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
        mdEnter = new JButton("���Է�");
        mdCommit = new JButton("����");
        mdBack = new JButton("���");
        mdEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        mdCommit.setFont(new Font("���� ���", Font.BOLD, 14));
        mdBack.setFont(new Font("���� ���", Font.BOLD, 14));
        medisouth.add(mdEnter);
        medisouth.add(mdCommit);
        medisouth.add(mdBack);


        mediData.add(medicenter); //����ī�忡 �߰�
        mediData.add(medisouth, BorderLayout.SOUTH);
        
        medical.add(mediTb);
        medical.add(mediData);

    }

    void setReceipt(){
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
        JTextField mdInputSearch = new JTextField("",30);
        JButton mdsearch = new JButton(" �˻� ");
        JButton mdAll = new JButton("��ü����");
        mdNorthBot.add(cBox4);
        mdNorthBot.add(mdInputSearch);
        mdNorthBot.add(mdsearch);
        mdNorthBot.add(mdAll);
        mdNorth.add(mdNorthBot, BorderLayout.CENTER);

        //����ī�� ���̺� ����
        JPanel billCenter = new JPanel();
        billCenter.setLayout(new BoxLayout(billCenter, BoxLayout.Y_AXIS));
        mdJTable = new JTable(mdModel);
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
        JTextField bw1B = new JTextField();
        bw1B.setEditable(false);
        billWest.add(bw1A);
        billWest.add(bw1B);


        JLabel bw2A = new JLabel("ȯ���̸�");
        bw2A.setFont(cFont);
        JTextField bw2B = new JTextField();
        bw2B.setEditable(false);
        billWest.add(bw2A);
        billWest.add(bw2B);


        JLabel bw3A = new JLabel("����");
        bw3A.setFont(cFont);
        JTextField bw3B = new JTextField();
        bw3B.setEditable(false);
        billWest.add(bw3A);
        billWest.add(bw3B);


        JLabel bw4A = new JLabel("ġ���Ī");
        bw4A.setFont(cFont);
        JTextField bw4B = new JTextField();
        bw4B.setEditable(false);
        billWest.add(bw4A);
        billWest.add(bw4B);


        JPanel billEast = new JPanel();
        billEast.setBorder(BorderFactory.createEmptyBorder(20 , 20 , 20 , 20));
        billEast.setLayout(new GridLayout(4,2,10,10));


        JLabel be1A = new JLabel("���ܺ�");
        be1A.setFont(cFont);
        JTextField be1B = new JTextField();
        be1B.setEditable(false);
        billEast.add(be1A);
        billEast.add(be1B);


        JLabel be2A = new JLabel("ġ���");
        be2A.setFont(cFont);
        JTextField be2B = new JTextField();
        be2B.setEditable(false);
        billEast.add(be2A);
        billEast.add(be2B);

        JLabel be3A = new JLabel("����");
        be3A.setFont(cFont);
        JTextField be3B = new JTextField();
        be3B.setEditable(false);
        billEast.add(be3A);
        billEast.add(be3B);
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

        }else if(e.getSource()==mEnter){

        }else if(e.getSource()==mCommit){

        }
        
    }
    
}
