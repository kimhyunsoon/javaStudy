
//package starHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class GUI extends JFrame{

    JPanel cp;
    public static CardLayout cLayout = new CardLayout();
    JButton regisBtn, serchBtn, resrvBtn, medicBtn, recptBtn, staffBtn;
    JButton mRenter,mEnter, dRenter, dEnter; 
    JTextField mNumber, mPhone, mName, mAddr;
    JTextField dNumber, dName, dKinds, dAge, dWeight, dSex;

    JPanel register, search, reserve, medical, receipt, staff;
    JPanel mData, dData;
    JPanel cardP, centerP;
    JLabel label;


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
        msouth.setLayout(new FlowLayout(FlowLayout.CENTER, 30,0));
        mRenter = new JButton("���Է�");
        mEnter = new JButton("���");
        mRenter.setFont(new Font("���� ���", Font.BOLD, 14));
        mEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        msouth.add(mRenter);
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
        dsouth.setLayout(new FlowLayout(FlowLayout.CENTER, 30,0));
        dRenter = new JButton("���Է�");
        dEnter = new JButton("���");
        dRenter.setFont(new Font("���� ���", Font.BOLD, 14));
        dEnter.setFont(new Font("���� ���", Font.BOLD, 14));
        dsouth.add(dRenter);
        dsouth.add(dEnter);
        
        dData.add(dtop, BorderLayout.NORTH);
        dData.add(dcenter, BorderLayout.CENTER);
        dData.add(dsouth, BorderLayout.SOUTH);


        //register �гο� �� �г��� �÷ο췹�̾ƿ����� ��
        register.add(mData);
        register.add(dData);


        


        search = new JPanel();
        reserve = new JPanel();
        medical = new JPanel();
        receipt = new JPanel();
        staff = new JPanel();







        
        

        

        centerP = new JPanel(cLayout);
        cp.add(centerP, BorderLayout.CENTER);


        centerP.add(register,"1");
        centerP.add(search,"2");
        search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
        centerP.add(reserve,"3");
        reserve.setLayout(new BoxLayout(reserve, BoxLayout.X_AXIS));













        // cp.add(westP, BorderLayout.WEST);
        setUI();

    }

    void setUI(){
		setTitle("JTable Test Ver 1.0");
		setSize(960, 540);
		setVisible(true);
		setLocationRelativeTo(null);
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    public static void main(String[] args) {
        new GUI();
        
    }
    
}
