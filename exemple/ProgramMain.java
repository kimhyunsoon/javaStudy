public class ProgramMain extends JFrame {
    
    public static ProgramMain frame;
    public static RegistFormP rfp_1;
    public static Change_Search_FormP csfp_1;
    public static RecordFormP rcfp_1;
    public static ReportLogP rlp;
    private static JPanel contentPane;
    private static JPanel cardP;
    public static JPanel centerP;
    public static DataBase db;
    public static CardLayout cl = new CardLayout();
    public static void main(String[] args) {
            
    try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            frame = new ProgramMain();
            frame.setVisible(true);
        }catch (Exception e) {
            e.printStackTrace();    
        }
    }
 
    public ProgramMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        db = new DataBase();
        rfp_1 = new RegistFormP();
        csfp_1 = new Change_Search_FormP();
        rcfp_1 = new RecordFormP();
        //rlp = new ReportLogP();
                
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel westP = new JPanel();
        westP.setBackground(Color.WHITE);
        contentPane.add(westP, BorderLayout.WEST);
        westP.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.ORANGE);
        FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        westP.add(panel_2, BorderLayout.NORTH);
        
        JLabel label = new JLabel("\uBA54\uB274");
        label.setFont(new Font("±¼¸²", Font.PLAIN, 18));
        panel_2.add(label);
        
        JPanel westP_menuP = new JPanel();
        westP_menuP.setPreferredSize(new Dimension(200,0));
        westP_menuP.setBackground(Color.WHITE);
        westP.add(westP_menuP);
        westP_menuP.setLayout(new BoxLayout(westP_menuP, BoxLayout.Y_AXIS));
        
        JButton registButton = new JButton();
        registButton.setIcon(new ImageIcon("img\\regist.gif"));
        registButton.setBorderPainted(false);
        registButton.setContentAreaFilled(false);
        registButton.setMargin(new Insets(0,0,0,0));
        registButton.addActionListener(new PRigistListener());
        westP_menuP.add(registButton);
        
        JButton searchChangeButton = new JButton();
        searchChangeButton.setIcon(new ImageIcon("img\\change.gif"));
        searchChangeButton.setBorderPainted(false);
        searchChangeButton.setContentAreaFilled(false);
        searchChangeButton.setMargin(new Insets(0,0,0,0));
        searchChangeButton.addActionListener(new PSearchListener());
        westP_menuP.add(searchChangeButton);
        
        JButton enterButton = new JButton();
        enterButton.setIcon(new ImageIcon("img\\enter.gif"));
        enterButton.setBorderPainted(false);
        enterButton.setContentAreaFilled(false);
        enterButton.setMargin(new Insets(0,0,0,0));
        enterButton.addActionListener(new PEnterListener());
        westP_menuP.add(enterButton);
        
        JButton searchLogButton = new JButton();
        searchLogButton.setIcon(new ImageIcon("img\\log.gif"));
        searchLogButton.setBorderPainted(false);
        searchLogButton.setContentAreaFilled(false);
        searchLogButton.setMargin(new Insets(0,0,0,0));
        searchLogButton.addActionListener(new PLogListener());
        westP_menuP.add(searchLogButton);
        
        JPanel panel_1 = new JPanel();
        westP.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
        
        JPanel panel_10 = new JPanel();
        panel_10.setBackground(Color.WHITE);
        panel_10.setPreferredSize(new Dimension(0, 100));
        panel_1.add(panel_10);
        
        centerP = new JPanel(cl);
        contentPane.add(centerP, BorderLayout.CENTER);
        centerP.add(rfp_1,"1");
        rfp_1.setLayout(new BoxLayout(rfp_1, BoxLayout.X_AXIS));
        centerP.add(csfp_1,"2");
        csfp_1.setLayout(new BoxLayout(csfp_1, BoxLayout.X_AXIS));
        centerP.add(rcfp_1,"3");
        rcfp_1.setLayout(new BoxLayout(rcfp_1, BoxLayout.X_AXIS));
    //centerP.add(rlp,"4");
    //    rlp.setLayout(new BoxLayout(rlp, BoxLayout.X_AXIS));
        
        JPanel northP = new JPanel();
        northP.setBackground(Color.WHITE);
        contentPane.add(northP, BorderLayout.NORTH);
        northP.setLayout(new BoxLayout(northP, BoxLayout.Y_AXIS));
        
        setBounds(0,0,1024,700);
        setUndecorated(false);
        setLocationByPlatform(false);
        setResizable(false);
 
    }
 
    class PRigistListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(centerP, "1");
            rfp_1.refrash();
        }
    }
    
    class PSearchListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(centerP, "2");
            csfp_1.refrash();
        }
    }
    
    class PEnterListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
 
            cl.show(centerP, "3");
            rcfp_1.refrash();
    }
}
 
    class PLogListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            cl.show(centerP, "4");
        }
    }
}