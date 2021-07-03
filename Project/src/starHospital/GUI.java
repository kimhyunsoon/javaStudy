
//package starHospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame{

    JPanel cp;
    public static CardLayout cLayout = new CardLayout();
    JButton regisBtn, serchBtn, resrvBtn, medicBtn, recptBtn, staffBtn;
    JButton mRenter,mSave, mEnter, dRenter, dSave, dEnter; 
    JButton msearch, dsearch, mAll, dAll;
    JTextField mNumber, mPhone, mName, mAddr;
    JTextField dNumber, dName, dKinds, dAge, dWeight, dSex;
    JTextField mInputSearch, dInputSearch;
    JTable mJTable, dJTable;

    JPanel register, search, reserve, medical, receipt, staff;
    JPanel mData, dData, mtableP, dtableP, updateP, dupdateP;
    JPanel cardP, centerP;
    JLabel label;
    JTabbedPane tabs;

    String mcolNames[] = {"ȸ����ȣ","����ó","�ݷ��� ����", "�ּ�"};
    String dcolNames[] = {"�ݷ��߹�ȣ","�ݷ����̸�","����", "����", "����", "����", "���ʹ湮��", "ȸ����ȣ"};
    DefaultTableModel mModel = new DefaultTableModel(mcolNames, 0); //ȸ�� ���̺�
    DefaultTableModel dModel = new DefaultTableModel(dcolNames, 0); //ȸ�� ���̺�
    JComboBox cBox1, cBox2;


    GUI(){

        Color color = new Color(0x234e85);
        Font font = new Font("���� ���", Font.BOLD, 20);
        Font cFont = new Font("���� ���", Font.PLAIN, 15);

        cp = new JPanel();
        setContentPane(cp);
        cp.setLayout(new BorderLayout(20, 20));


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

        resrvBtn = new JButton();
        resrvBtn.setIcon(new ImageIcon("img\\menu3.png"));
        resrvBtn.setBorderPainted(false);
        resrvBtn.setContentAreaFilled(false);
        resrvBtn.setMargin(new Insets(0,0,0,0));
        menuP.add(resrvBtn);

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

        



        //1. ȸ����� ȭ��
        register = new JPanel();
        register.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 20 , 50)); 
        register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));


        //ȸ�������Է�
        mData = new JPanel();
        mData.setLayout(new BorderLayout(0,30));
        
        JPanel mtop = new JPanel();
        mtop.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel topinfo = new JLabel("ȸ�������Է�");
        topinfo.setFont(font);
        mtop.add(topinfo);


        //<---------------ȸ���ʵ� �������----------------->
        JPanel mcenter = new JPanel();
        mcenter.setLayout(new GridLayout(3,4,20,10));
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
        msouth.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
        mRenter = new JButton("���Է�");
        mSave = new JButton("����");
        mEnter = new JButton("���");
        mRenter.setFont(new Font("���� ���", Font.BOLD, 14));
        mSave.setFont(new Font("���� ���", Font.BOLD, 14));
        mEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        msouth.add(mRenter);
        msouth.add(mSave);
        msouth.add(mEnter);


        mData.add(mtop, BorderLayout.NORTH);
        mData.add(mcenter, BorderLayout.CENTER);
        mData.add(msouth, BorderLayout.SOUTH);


        //������ ���� �Է�
        dData = new JPanel();
        dData.setLayout(new BorderLayout(0,30));
        JPanel dtop = new JPanel();
        dtop.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel dtopinfo = new JLabel("ȸ�������Է�");
        dtopinfo.setFont(font);
        dtop.add(dtopinfo);



        //<---------------�������ʵ� �������----------------->
        JPanel dcenter = new JPanel();
        dcenter.setLayout(new GridLayout(4,4,20,10));
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
        dsouth.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
        dRenter = new JButton("���Է�");
        dSave = new JButton("����");
        dEnter = new JButton("���");
        dRenter.setFont(new Font("���� ���", Font.BOLD, 14));
        dSave.setFont(new Font("���� ���", Font.BOLD, 14));
        dEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        dsouth.add(dRenter);
        dsouth.add(dSave);
        dsouth.add(dEnter);
        
        dData.add(dtop, BorderLayout.NORTH);
        dData.add(dcenter, BorderLayout.CENTER);
        dData.add(dsouth, BorderLayout.SOUTH);


        //register �гο� �� �г��� �÷ο췹�̾ƿ����� ��
        register.add(mData);
        register.add(dData);



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
        cBox2 = new JComboBox<String>(dcolNames); //�޺��ڽ�
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

        updateP.add(mNumberLabel);
        updateP.add(mNumber);
        updateP.add(mNameLabel);
        updateP.add(mName);
        updateP.add(mPhoneLabel);
        updateP.add(mPhone);
        updateP.add(mAddrLabel);
        updateP.add(mAddr);
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


        dupdateP.add(dNumberLabel);
        dupdateP.add(dNumber);
        dupdateP.add(dNameLabel);
        dupdateP.add(dName);
        dupdateP.add(dKindsLabel);
        dupdateP.add(dKinds);
        dupdateP.add(dWeightLabel);
        dupdateP.add(dWeight);
        dupdateP.add(dAgeLabel);
        dupdateP.add(dAge);
        dupdateP.add(dSexLabel);
        dupdateP.add(dSex);
        dupdateP.add(new JLabel());
        dupdateP.add(new JLabel());
        dupdateP.add(dupBtn);
        dupdateP.add(dccBtn);







        tabs.addTab("ȸ����������", updateP);
        tabs.addTab("ȯ����������", dupdateP);



        search.add(mtableP);
        search.add(dtableP);
        search.add(tabs);





        reserve = new JPanel();
        medical = new JPanel();
        receipt = new JPanel();
        staff = new JPanel();







        
        

        

        //centerP = new JPanel(cLayout);
        cp.add(search, BorderLayout.CENTER);


        // centerP.add(register,"1");
        // centerP.add(search,"2");
        // search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
        // centerP.add(reserve,"3");
        // reserve.setLayout(new BoxLayout(reserve, BoxLayout.X_AXIS));











        setUI();

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
    
}
