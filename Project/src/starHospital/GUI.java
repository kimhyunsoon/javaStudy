
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

    String mcolNames[] = {"회원번호","연락처","반려인 성함", "주소"};
    String dcolNames[] = {"반려견번호","반려견이름","견종", "연령", "무게", "성별", "최초방문일", "회원번호"};
    DefaultTableModel mModel = new DefaultTableModel(mcolNames, 0); //회원 테이블
    DefaultTableModel dModel = new DefaultTableModel(dcolNames, 0); //회원 테이블
    JComboBox cBox1, cBox2;


    GUI(){

        Color color = new Color(0x234e85);
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        Font cFont = new Font("맑은 고딕", Font.PLAIN, 15);

        cp = new JPanel();
        setContentPane(cp);
        cp.setLayout(new BorderLayout(20, 20));


        // <-----메뉴 버튼------->
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

        



        //1. 회원등록 화면
        register = new JPanel();
        register.setBorder(BorderFactory.createEmptyBorder(20 , 0 , 20 , 50)); 
        register.setLayout(new BoxLayout(register, BoxLayout.Y_AXIS));


        //회원정보입력
        mData = new JPanel();
        mData.setLayout(new BorderLayout(0,30));
        
        JPanel mtop = new JPanel();
        mtop.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel topinfo = new JLabel("회원정보입력");
        topinfo.setFont(font);
        mtop.add(topinfo);


        //<---------------회원필드 구성요소----------------->
        JPanel mcenter = new JPanel();
        mcenter.setLayout(new GridLayout(3,4,20,10));
        JLabel mNumberLabel = new JLabel("회원 번호");
        mNumberLabel.setFont(cFont);
        mNumberLabel.setHorizontalAlignment(4);
        mNumber = new JTextField();
        JLabel mNameLabel = new JLabel("이름");
        mNameLabel.setFont(cFont);
        mNameLabel.setHorizontalAlignment(4);
        mName = new JTextField();
        JLabel mPhoneLabel = new JLabel("연락처");
        mPhoneLabel.setFont(cFont);
        mPhoneLabel.setHorizontalAlignment(4);
        mPhone = new JTextField();
        JLabel mAddrLabel = new JLabel("주소");
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
        mRenter = new JButton("재입력");
        mSave = new JButton("저장");
        mEnter = new JButton("등록");
        mRenter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        mSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        mEnter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        msouth.add(mRenter);
        msouth.add(mSave);
        msouth.add(mEnter);


        mData.add(mtop, BorderLayout.NORTH);
        mData.add(mcenter, BorderLayout.CENTER);
        mData.add(msouth, BorderLayout.SOUTH);


        //강아지 정보 입력
        dData = new JPanel();
        dData.setLayout(new BorderLayout(0,30));
        JPanel dtop = new JPanel();
        dtop.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel dtopinfo = new JLabel("회원정보입력");
        dtopinfo.setFont(font);
        dtop.add(dtopinfo);



        //<---------------강아지필드 구성요소----------------->
        JPanel dcenter = new JPanel();
        dcenter.setLayout(new GridLayout(4,4,20,10));
        JLabel dNumberLabel = new JLabel("환자 번호");
        dNumberLabel.setFont(cFont);
        dNumber = new JTextField();
        dNumberLabel.setHorizontalAlignment(4);
        mNumberLabel = new JLabel("회원 번호");
        mNumberLabel.setFont(cFont);
        mNumberLabel.setHorizontalAlignment(4);
        mNumber = new JTextField();
        JLabel dNameLabel = new JLabel("환자 이름");
        dNameLabel.setFont(cFont);
        dNameLabel.setHorizontalAlignment(4);
        dName = new JTextField();
        JLabel dKindsLabel = new JLabel("견종");
        dKindsLabel.setFont(cFont);
        dKindsLabel.setHorizontalAlignment(4);
        dKinds = new JTextField();
        JLabel dWeightLabel = new JLabel("무게");
        dWeightLabel.setFont(cFont);
        dWeightLabel.setHorizontalAlignment(4);
        dWeight = new JTextField();
        JLabel dAgeLabel = new JLabel("연령");
        dAgeLabel.setFont(cFont);
        dAgeLabel.setHorizontalAlignment(4);
        dAge = new JTextField();
        JLabel dSexLabel = new JLabel("성별");
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
        dRenter = new JButton("재입력");
        dSave = new JButton("저장");
        dEnter = new JButton("등록");
        dRenter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        dSave.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        dEnter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        dsouth.add(dRenter);
        dsouth.add(dSave);
        dsouth.add(dEnter);
        
        dData.add(dtop, BorderLayout.NORTH);
        dData.add(dcenter, BorderLayout.CENTER);
        dData.add(dsouth, BorderLayout.SOUTH);


        //register 패널에 두 패널이 플로우레이아웃으로 들어감
        register.add(mData);
        register.add(dData);



        //2. 회원관리 화면
        search = new JPanel();
        search.setBorder(BorderFactory.createEmptyBorder(0 , 0 , 10 , 10)); //투명 테두리
        search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));

        //2-1. 회원정보조회 (JTable)
        //회원 테이블 전체 구역
        mtableP = new JPanel(); 
        mtableP.setLayout(new BorderLayout(0,0));

        //검색창 구역
        JPanel mNorth = new JPanel(); 
        mNorth.setLayout(new BorderLayout(0,0));

        JLabel northTop = new JLabel("회원조회");
        northTop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        mNorth.add(northTop, BorderLayout.NORTH);

        JPanel northBot = new JPanel();
        northBot.setLayout(new BoxLayout(northBot, BoxLayout.X_AXIS));
        cBox1 = new JComboBox<String>(mcolNames); //콤보박스
        mInputSearch = new JTextField("",30);
        msearch = new JButton(" 검색 ");
        mAll = new JButton("전체보기");
        northBot.add(cBox1);
        northBot.add(mInputSearch);
        northBot.add(msearch);
        northBot.add(mAll);
        mNorth.add(northBot, BorderLayout.CENTER);


        //결과창 구역
        JPanel mCenter = new JPanel(); //테이블부분
        mCenter.setLayout(new BoxLayout(mCenter, BoxLayout.Y_AXIS));
        mJTable = new JTable(mModel);
        JScrollPane sp = new JScrollPane(mJTable);
        mCenter.add(sp);

        mtableP.add(mNorth, BorderLayout.NORTH);
        mtableP.add(mCenter, BorderLayout.CENTER);

        //2-2. 환자정보조회 (JTable)
        //환자 테이블 전체 구역
        dtableP = new JPanel(); 
        dtableP.setLayout(new BorderLayout(0,0));

        //검색창 구역
        JPanel dNorth = new JPanel(); 
        dNorth.setLayout(new BorderLayout(0,0));

        JLabel dnorthTop = new JLabel("환자조회");
        dnorthTop.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        dNorth.add(dnorthTop, BorderLayout.NORTH);

        JPanel dnorthBot = new JPanel();
        dnorthBot.setLayout(new BoxLayout(dnorthBot, BoxLayout.X_AXIS));
        cBox2 = new JComboBox<String>(dcolNames); //콤보박스
        dInputSearch = new JTextField("",30);
        dsearch = new JButton(" 검색 ");
        dAll = new JButton("전체보기");
        dnorthBot.add(cBox2);
        dnorthBot.add(dInputSearch);
        dnorthBot.add(dsearch);
        dnorthBot.add(dAll);
        dNorth.add(dnorthBot, BorderLayout.CENTER);

        //결과창 구역
        JPanel dCenter = new JPanel(); //테이블부분
        dCenter.setLayout(new BoxLayout(dCenter, BoxLayout.Y_AXIS));
        dJTable = new JTable(dModel);
        JScrollPane sp2 = new JScrollPane(dJTable);
        dCenter.add(sp2);

        dtableP.add(dNorth, BorderLayout.NORTH);
        dtableP.add(dCenter, BorderLayout.CENTER);


        //2-3. 조회 및 업데이트
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        updateP = new JPanel();
        updateP.setLayout(new GridLayout(4,4,20,0));
        
        JButton mupBtn = new JButton("기본정보변경");
        JButton mccBtn = new JButton("취소");

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
        
        JButton dupBtn = new JButton("기본정보변경");
        JButton dccBtn = new JButton("취소");


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







        tabs.addTab("회원정보변경", updateP);
        tabs.addTab("환자정보변경", dupdateP);



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
