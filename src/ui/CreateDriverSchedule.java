package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;
import javax.swing.*;
//import java.sql.*;
import da.DriverScheduleDA;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import domain.Driver;
import da.DriverScheduleDA;
import control.DriverScheduleControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
//import java.sql.Date;
import java.util.Date;


public class CreateDriverSchedule extends JFrame
{
    public static String now(String dateFormat) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(cal.getTime());
  }
    private ArrayList<Driver> driverList = new ArrayList<Driver>();
    private ArrayList<String> avaList=new ArrayList<String>();
     ArrayList<String> driverIDOnSameDate = new ArrayList<String>();
    DriverScheduleControl dsControl;
    
    private String host = "jdbc:derby://localhost:1527/ezwaydb";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    DriverScheduleDA d=new DriverScheduleDA();
    
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
     
     ImageIcon iconHome=new ImageIcon(getClass().getResource("../images/homepageicon.png"));
     
     Font buttonFont=new Font("French Script MT",Font.ITALIC,45);
     Font buttonFont2=new Font("Century",Font.PLAIN,18);
     Font buttonFont3=new Font("Century",Font.ITALIC,17);
     Font buttonFont4=new Font("French Script MT",Font.ITALIC,28);
     JLabel jds=new JLabel("Driver Schedule Management"); 
     
     JPanel jp2=new JPanel(new GridLayout(1,5));
     JPanel jp3=new JPanel(new GridLayout(6,2));
     JPanel jp4=new JPanel(new GridLayout(1,2));
     JPanel jp5=new JPanel(new FlowLayout(FlowLayout.LEFT));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton jbtCreateDS=new JButton("Create DRV Schedule");
    JButton jbtViewDS=new JButton("View DRV Schedule");
    //JButton jbtRetrieveDS=new JButton("Retrieve DRV Schedule");
    JButton jbtUpdateDS=new JButton("Update DRV Schedule");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    
    JLabel jlbNewDS=new JLabel("New Driver Schedule Details");
    JLabel jlbScheduleID=new JLabel("Schedule ID");
    JLabel jlbScheduleDate=new JLabel("Schedule Date");
    JLabel jlbAvailability=new JLabel("Availability");
    JLabel jlbDriverID=new JLabel("Driver ID");
    
    JTextField jtfScheduleID=new JTextField(15);
    JTextField jtfScheduleDate=new JTextField(15);
    
    private DefaultComboBoxModel dcbomDSList= new DefaultComboBoxModel();
    private JComboBox jcboDSList = new JComboBox(dcbomDSList);
    
    private DefaultComboBoxModel dcbomDriverList= new DefaultComboBoxModel();
    private JComboBox jcboDriverList = new JComboBox(dcbomDriverList);
    
    JButton jbtCreate=new JButton("Create");
    JButton jbtClear=new JButton("Reset");
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
     private char accType;
     public CreateDriverSchedule(final char accType)
    {
        this.accType=accType;
     dsControl = new DriverScheduleControl();
     initComboBox();
     
     setLayout(new BorderLayout());
     
     jds.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jds);
     jds.setFont(buttonFont);
     
     jbtCreateDS.setPreferredSize(new Dimension(190, 40));
     jbtViewDS.setPreferredSize(new Dimension(190, 40));
     //jbtRetrieveDS.setPreferredSize(new Dimension(170, 40));
     jbtUpdateDS.setPreferredSize(new Dimension(190, 40));
     jbtMenu.setPreferredSize(new Dimension(190, 40));
     jbtHome.setPreferredSize(new Dimension(190, 40));
     
     jbtCreate.setPreferredSize(new Dimension(100, 28));
     jbtClear.setPreferredSize(new Dimension(100, 28));
    
      jbtCreateDS.setFont(buttonFont3);
      jbtViewDS.setFont(buttonFont3);
      //jbtRetrieveDS.setFont(buttonFont3);
      jbtUpdateDS.setFont(buttonFont3);
      jbtMenu.setFont(buttonFont3);
      jbtHome.setFont(buttonFont3);
      
      jbtCreate.setFont(buttonFont2);
      jbtClear.setFont(buttonFont2);
      
      jlbNewDS.setFont(buttonFont4);
      jlbScheduleID.setFont(buttonFont2);
      jlbScheduleDate.setFont(buttonFont2);
      jlbAvailability.setFont(buttonFont2);
      jlbDriverID.setFont(buttonFont2);
      
      jtfScheduleID.setFont(buttonFont2);
      jtfScheduleDate.setFont(buttonFont2);
      jcboDSList.setFont(buttonFont2);
      jcboDriverList.setFont(buttonFont2);
     
      jbtCreateDS.setBackground(Color.WHITE);
      jbtViewDS.setBackground(Color.WHITE);
      //jbtRetrieveDS.setBackground(Color.WHITE);
      jbtUpdateDS.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtCreate.setBackground(Color.WHITE);
      jbtClear.setBackground(Color.WHITE);
     
      jbtCreateDS.setBorder(buttonBorder);
      jbtViewDS.setBorder(buttonBorder);
      //jbtRetrieveDS.setBorder(buttonBorder);
      jbtUpdateDS.setBorder(buttonBorder);
      jbtMenu.setBorder(buttonBorder);
      jbtHome.setBorder(buttonBorder);
      
      jbtCreate.setBorder(buttonBorder2);
      jbtClear.setBorder(buttonBorder2);
     
      jbtCreateDS.setMnemonic('C');
      jbtViewDS.setMnemonic('V');
      //jbtRetrieveDS.setMnemonic('R');
      jbtUpdateDS.setMnemonic('U');
      jbtMenu.setMnemonic('B');
      jbtHome.setMnemonic('M');
      
      jtfScheduleID.setEditable(false);
      jtfScheduleID.setText(automatedCode());
      
      jtfScheduleDate.setEditable(false);
      jtfScheduleDate.setText(CreateDriverSchedule.now("yyyy-MM-dd"));
      
       jbtCreateDS.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCreateDS.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCreateDS.setBackground(Color.WHITE);
        
    }
});
       jbtViewDS.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtViewDS.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtViewDS.setBackground(Color.WHITE);
        
    }
});
     
       jbtUpdateDS.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtUpdateDS.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtUpdateDS.setBackground(Color.WHITE);
        
    }
});
        jbtMenu.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtMenu.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtMenu.setBackground(Color.WHITE);
        
    }
});
         jbtHome.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtHome.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtHome.setBackground(Color.WHITE);
        
    }
});
         jbtCreate.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCreate.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCreate.setBackground(Color.WHITE);
        
    }
});
         jbtClear.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtClear.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtClear.setBackground(Color.WHITE);
        
    }
});
      
          jbtMenu.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new ScheduleMenu(accType);
           }
       });
          
          jbtHome.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new homePage(accType);
           }
       });
          jbtCreateDS.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new CreateDriverSchedule(accType);
           }
       });
          
          jbtViewDS.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new DriverMgmt(accType);
           }
       });
         
          jbtUpdateDS.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new UpdateDriverSchedule(accType);
           }
       });
          
     
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
      //menuPanel_r6.setOpaque(false);
      
      subPanel_r1.setOpaque(false);
      subPanel_r2.setOpaque(false);
      
     
      menuPanel_r1.add(jbtCreateDS);
      menuPanel_r2.add(jbtViewDS);
      //menuPanel_r3.add(jbtRetrieveDS);
      menuPanel_r3.add(jbtUpdateDS);
      menuPanel_r4.add(jbtMenu);
      menuPanel_r5.add(jbtHome);
   
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
      //jp2.add( menuPanel_r6);
      
      jp3.setOpaque(false);
      jp3.add(jlbNewDS);
      jp3.add(new JLabel(""));
      jp3.add(jlbScheduleID);
      jp3.add(jtfScheduleID);
      jp3.add(jlbScheduleDate);
      jp3.add(jtfScheduleDate);
      jp3.add(jlbAvailability);
      jp3.add(jcboDSList);
      jp3.add(jlbDriverID);
      jp3.add(jcboDriverList);
     
      jp5.add(jbtClear);
      jp5.add(jbtCreate);
      jp5.setOpaque(false);
      jp3.add(jp5);
      
      jbtClear.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
          {
              jcboDSList.setSelectedIndex(0);
              jcboDriverList.setSelectedIndex(0);
          }
      });
      
      jbtCreate.addActionListener(new CreateListener());
      
      avaList.add("Available");
      avaList.add("On Duty");
      avaList.add("On Leave");
      
     for(int i=0; i<avaList.size(); i++){
            dcbomDSList.addElement(avaList.get(i));
        }
      
      jp4.add(jp3);
      jp4.add(subPanel_r4);
      subPanel_r4.setOpaque(false);
     jp4.setOpaque(false);
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp4,BorderLayout.CENTER);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Create Driver Schedule");
     setSize(1100,640);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
     
     createConnection();
     
    }
      private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
         int confirm = JOptionPane.showConfirmDialog(null, "Confirm return to the Home Page?", "Confirm?", JOptionPane.WARNING_MESSAGE);
           if(confirm == JOptionPane.YES_OPTION){
           dispose();
           new homePage(accType);
           }
        
        }
       
       }
      public String automatedCode()
      {
          String automatedCode="";
         automatedCode=d.displayAutomatedCode();
          return automatedCode;
      }
      private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
       private void initComboBox(){
        
        driverList = dsControl.getDriverList();
        String dsDate=jtfScheduleDate.getText();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        dsDate = df.format(d);
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        driverIDOnSameDate=dsControl.selectDriverIDbyDate(sqlDate);
        System.out.println(driverIDOnSameDate);
        
        for(int i=0; i<driverList.size(); i++){
            
            dcbomDriverList.addElement(driverList.get(i).getDriverid());
            for(int j=0;j<driverIDOnSameDate.size();j++)
            {
            if(driverIDOnSameDate.get(j).compareTo(driverList.get(i).getDriverid())==0)
            {
            String str = driverIDOnSameDate.get(j);
            Object obj = str;
            int index=dcbomDriverList.getIndexOf(obj);
            
            if(index!=-1)
            {
                dcbomDriverList.removeElementAt(index);
            }
            }
            
            }
        }
    }
      public void closeFrame() {
                this.dispose();
        }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      private class CreateListener implements ActionListener
       {
          public void actionPerformed(ActionEvent e)
       {
        String dsDate=jtfScheduleDate.getText();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date();
        dsDate = df.format(d);
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        
        String status="";
        if(jcboDSList.getSelectedIndex()==0)
        {
            status="AVL";
        }
        else if(jcboDSList.getSelectedIndex()==1)
        {
            status="DTY";
        }
        else
        {
            status="LEA";
        }
        
        if(jcboDriverList.getSelectedItem()!=null){
        dsControl.createRecord(jtfScheduleID.getText(), sqlDate, status, jcboDriverList.getSelectedItem().toString());
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Driver schedules for "+CreateDriverSchedule.now("dd-MMM-yyyy")+" are successfully created");
        }
        //System.out.println(jtfScheduleID.getText());
        //System.out.println(sqlDate);
        //System.out.println(status);
        //System.out.println(jcboDriverList.getSelectedItem().toString());
        closeFrame();
        new DriverMgmt(accType);
        }
       }
      
      public static void main(String[]args)
    {
        new CreateDriverSchedule('U');
         
    }
}