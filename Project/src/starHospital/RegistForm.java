package starHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistForm extends JPanel{

    JButton regisBtn, serchBtn, resrvBtn, medicBtn, recptBtn, staffBtn;
    JButton mRenter,mEnter, dRenter, dEnter; 
    JTextField mNumber, mPhone, mName, mAddr;
    JTextField dNumber, dName, dKinds, dAge, dWeight, dSex;

    JPanel register, search, reserve, medical, receipt, staff;
    JPanel mData, dData;
    JPanel cardP, centerP;
    JLabel label;
    public RegistForm(){
        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        Font cFont = new Font("맑은 고딕", Font.PLAIN, 15);

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
        msouth.setLayout(new FlowLayout(FlowLayout.CENTER, 30,0));
        mRenter = new JButton("재입력");
        mEnter = new JButton("등록");
        mRenter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        mEnter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        msouth.add(mRenter);
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
        dsouth.setLayout(new FlowLayout(FlowLayout.CENTER, 30,0));
        dRenter = new JButton("재입력");
        dEnter = new JButton("등록");
        dRenter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        dEnter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        dsouth.add(dRenter);
        dsouth.add(dEnter);
        
        dData.add(dtop, BorderLayout.NORTH);
        dData.add(dcenter, BorderLayout.CENTER);
        dData.add(dsouth, BorderLayout.SOUTH);


        //register 패널에 두 패널이 플로우레이아웃으로 들어감
        register.add(mData);
        register.add(dData);


    }


}
