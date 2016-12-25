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
import da.DriverScheduleTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import control.*;
import da.*;
import domain.DriverScheduleClass;
import java.util.ArrayList;

public class DriverMgmt extends JFrame
{
    public static String now(String dateFormat) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(cal.getTime());
  }
     
    private DriverScheduleTable tableModel;
    private JTable productTable;
    DriverScheduleControl dsControl;
    ArrayList<DriverScheduleClass> scheduleList = new ArrayList<DriverScheduleClass>();
     
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
     
     ImageIcon iconHome=new ImageIcon(getClass().getResource("../images/homepageicon.png"));
     
     Font buttonFont=new Font("French Script MT",Font.ITALIC,45);
     Font buttonFont2=new Font("Century",Font.ITALIC,18);
     Font buttonFont3=new Font("Century",Font.ITALIC,17);
     JLabel jtrip=new JLabel("Driver Schedule Management"); 
     JPanel jp2=new JPanel(new GridLayout(1,5));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.LEFT));
     
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton jbtCreateDS=new JButton("Create DRV Schedule");
    JButton jbtViewDS=new JButton("View DRV Schedule");
    //JButton jbtRetrieveDS=new JButton("Retrieve DRV Schedule");
    JButton jbtUpdateDS=new JButton("Update DRV Schedule");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    
    JTextField jtfSearch=new JTextField("Please enter Driver ID to search",40);
    JButton jbtSearch=new JButton("Search");
    JButton jbtViewAll=new JButton("View All");
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
     public DriverMgmt(final char accType)
    {
     this.accType=accType;   
     dsControl=new DriverScheduleControl();   
     autoDetectDate();   
     setLayout(new BorderLayout());
     
     jtrip.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jtrip);
     jtrip.setFont(buttonFont);
     
     jbtCreateDS.setPreferredSize(new Dimension(190, 40));
     jbtViewDS.setPreferredSize(new Dimension(190, 40));
     //jbtRetrieveDS.setPreferredSize(new Dimension(170, 40));
     jbtUpdateDS.setPreferredSize(new Dimension(190, 40));
     jbtMenu.setPreferredSize(new Dimension(190, 40));
     jbtHome.setPreferredSize(new Dimension(190, 40));
     jbtSearch.setPreferredSize(new Dimension(100, 28));
     jbtViewAll.setPreferredSize(new Dimension(100, 28));
     
      jbtCreateDS.setFont(buttonFont3);
      jbtViewDS.setFont(buttonFont3);
      //jbtRetrieveDS.setFont(buttonFont3);
      jbtUpdateDS.setFont(buttonFont3);
      jbtMenu.setFont(buttonFont3);
      jbtHome.setFont(buttonFont3);
      jbtSearch.setFont(buttonFont2);
      jbtViewAll.setFont(buttonFont2);
      //jtfSearch.setFont(buttonFont2);
      
      jbtCreateDS.setBackground(Color.WHITE);
      jbtViewDS.setBackground(Color.WHITE);
      //jbtRetrieveDS.setBackground(Color.WHITE);
      jbtUpdateDS.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtSearch.setBackground(Color.WHITE);
      jbtViewAll.setBackground(Color.WHITE);
      
       jbtCreateDS.setBorder(buttonBorder);
       jbtViewDS.setBorder(buttonBorder);
       //jbtRetrieveDS.setBorder(buttonBorder);
       jbtUpdateDS.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtSearch.setBorder(buttonBorder2);
       jbtViewAll.setBorder(buttonBorder2);
      
      jbtCreateDS.setMnemonic('C');
      jbtViewDS.setMnemonic('V');
      //jbtRetrieveDS.setMnemonic('R');
      jbtUpdateDS.setMnemonic('U');
      jbtMenu.setMnemonic('B');
      jbtHome.setMnemonic('M');
      
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
       /*jbtRetrieveDS.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtRetrieveDS.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtRetrieveDS.setBackground(Color.WHITE);
        
    }
});*/
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
         jbtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSearch.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSearch.setBackground(Color.WHITE);
        
    }
});
         jbtViewAll.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtViewAll.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtViewAll.setBackground(Color.WHITE);
        
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
          /*jbtRetrieveDS.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               //new RetrieveTrip();
           }
       });*/
          jbtUpdateDS.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new UpdateDriverSchedule(accType);
               
           }
       });
       jbtSearch.addActionListener(new SearchListener());
       jtfSearch.addActionListener(new SearchListener());
       jbtViewAll.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               refreshTable();
           }
       });    
     
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
     // menuPanel_r6.setOpaque(false);
      
      subPanel_r1.setOpaque(false);
      subPanel_r2.setOpaque(false);
      
      jtfSearch.setPreferredSize( new Dimension( 200, 28 ) );
      jtfSearch.setForeground(Color.GRAY);
      jtfSearch.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                jtfSearch.setText("");
            }
            
        }); 
      
      jp3.addMouseListener(new MouseAdapter()
       {
            public void mouseClicked(MouseEvent e)
            {
                jtfSearch.setText("Please enter Driver ID to search");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
      
      jpanel.addMouseListener(new MouseAdapter()
       {
            public void mouseClicked(MouseEvent e)
            {
                jtfSearch.setText("Please enter Driver ID to search");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
  
      menuPanel_r1.add(jbtCreateDS);
      menuPanel_r2.add(jbtViewDS);
      //menuPanel_r3.add(jbtRetrieveDS);
      menuPanel_r3.add(jbtUpdateDS);
      menuPanel_r4.add(jbtMenu);
      menuPanel_r5.add(jbtHome);
      
      subPanel_r1.add(jtfSearch);
      jtfSearch.addKeyListener(new KeyAdapter() {

  public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
  }
});
      subPanel_r2.add(jbtSearch);
      subPanel_r2.add(jbtViewAll);
      
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
      //jp2.add( menuPanel_r6);
      
      jp3.setOpaque(false);
      jp3.add(subPanel_r1);
      jp3.add(subPanel_r2);
      
      tableModel=new DriverScheduleTable();
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
   
      subPanel_r3.add(pane);
      subPanel_r3.setOpaque(false);
      pane.getViewport().setBackground(new Color(255,255,255));
      pane.setPreferredSize(new Dimension(1050,185));
      
     jp4.add(subPanel_r3);
     //jp4.add(subPanel_r4);
     //subPanel_r4.setOpaque(false);
     jp4.setOpaque(false);
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp3,BorderLayout.CENTER);
     jpanel.add(jp4,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Driver Schedule Management");
     setSize(1100,640);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
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
     
      private void autoDetectDate()
      {
     try{     
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    Date convertedDate = dateFormat.parse(DriverMgmt.now("yyyy-MM-dd")); 
  
    java.sql.Date sqlDate=new java.sql.Date(convertedDate.getTime());
    scheduleList=dsControl.getScheduleList();
    
    //System.out.println(sqlDate);
    
    for(int i=0;i<scheduleList.size();i++)
    {
    if(sqlDate.compareTo(new java.sql.Date(scheduleList.get(i).getScheduledate().getTime()))!=0)
    {
    //System.out.println(new java.sql.Date(scheduleList.get(i).getScheduledate().getTime()));
        //if(scheduleList.get(i).getAvailability().compareTo("AVL")==0){
    dsControl.renewRecord(scheduleList.get(i).getScheduleid(),"INC");
    //}
    
    }
    
    }
     }catch(ParseException ex)
     {
         JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
     }
    
      
     }
     private class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             if(jtfSearch.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter driver ID to search.","WARNING",JOptionPane.WARNING_MESSAGE);
            }
             else
            {
                  tableModel.retrieveRecordsByCode(jtfSearch.getText());
            }
             
        }
        }
      public void refreshTable()
      {
      subPanel_r3.removeAll();
      tableModel=new DriverScheduleTable();
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
      subPanel_r3.add(pane);
      subPanel_r3.setOpaque(false);
      pane.getViewport().setBackground(new Color(255,255,255));
      pane.setPreferredSize(new Dimension(1050,185));
      subPanel_r3.revalidate();
      subPanel_r3.repaint();
      jp4.add(subPanel_r3);
      //jp4.add(subPanel_r4);
     
      }
      public void closeFrame() {
                this.dispose();
        }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      public static void main(String[]args)
    {
        new DriverMgmt('U');
    }
}