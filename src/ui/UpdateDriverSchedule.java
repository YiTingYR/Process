package ui; //Author:Teh Yi Ting
import domain.DriverScheduleClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;
import javax.swing.*;
import control.DriverScheduleControl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class UpdateDriverSchedule extends JFrame
{
    DriverScheduleControl dsControl;
    public static int counter=0;
    private ArrayList<String> avaList=new ArrayList<String>();
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
     Font buttonFont4=new Font("French Script MT",Font.ITALIC,28);
     JLabel jtrip=new JLabel("Driver Schedule Management-Update Driver Schedule"); 
     JPanel jp2=new JPanel(new GridLayout(1,5));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new GridLayout(1,2,5,5));
     JPanel jp5=new JPanel(new GridLayout(6,2));
     JPanel jp6=new JPanel(new GridLayout(6,2));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.LEFT));
     
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton jbtCreateDS=new JButton("Create DRV Schedule");
    JButton jbtViewDS=new JButton("View DRV Schedule");
    JButton jbtUpdateDS=new JButton("Update DRV Schedule");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    JButton jbtUpdate=new JButton("Update");
    JButton jbtClear=new JButton("Clear");
    JButton jbtInactive=new JButton("Inactive");
    
    JLabel jlbCurrentDS=new JLabel("Current Driver Schedule Details");
    JLabel jlbScheduleID=new JLabel("Schedule ID");
    JLabel jlbScheduleDate=new JLabel("Schedule Date");
    JLabel jlbAvailability=new JLabel("Availability");
    JLabel jlbDriverID=new JLabel("Driver ID");
    
    JLabel jlbUpdateDS=new JLabel("Update Driver Schedule Details");
    JLabel jlbScheduleID2=new JLabel("Schedule ID");
    JLabel jlbScheduleDate2=new JLabel("Schedule Date");
    JLabel jlbAvailability2=new JLabel("Availability");
    JLabel jlbDriverID2=new JLabel("Driver ID");
    
    JTextField jtfScheduleID=new JTextField(20);
    JTextField jtfScheduleDate=new JTextField(15);
    JTextField jtfAvailability=new JTextField(15);
    JTextField jtfDriverID=new JTextField(15);
    
    JTextField jtfScheduleID2=new JTextField(15);
    JTextField jtfScheduleDate2=new JTextField(15);
    JTextField jtfDriverID2=new JTextField(15);
    
    private DefaultComboBoxModel dcbomDSList= new DefaultComboBoxModel();
    private JComboBox jcboDSList = new JComboBox(dcbomDSList);
    
    JTextField jtfSearch=new JTextField("Please enter Schedule ID to read",40);
    JButton jbtRead=new JButton("Read");
    JButton jbtReset=new JButton("Reset");
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
     public UpdateDriverSchedule(final char accType)
    {
     this.accType=accType;  
     dsControl=new DriverScheduleControl();   
     setLayout(new BorderLayout());
      avaList.add("Available");
      avaList.add("On Duty");
      avaList.add("On Leave");
      
     jtrip.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jtrip);
     jtrip.setFont(buttonFont);
     
     jbtCreateDS.setPreferredSize(new Dimension(190, 40));
     jbtViewDS.setPreferredSize(new Dimension(190, 40));
     //jbtRetrieveDS.setPreferredSize(new Dimension(170, 40));
     jbtUpdateDS.setPreferredSize(new Dimension(190, 40));
     jbtMenu.setPreferredSize(new Dimension(190, 40));
     jbtHome.setPreferredSize(new Dimension(190, 40));
     jbtRead.setPreferredSize(new Dimension(100, 28));
     jbtReset.setPreferredSize(new Dimension(100, 28));
     jbtUpdate.setPreferredSize(new Dimension(100, 28));
     jbtClear.setPreferredSize(new Dimension(100, 28));
     jbtInactive.setPreferredSize(new Dimension(100, 28));
     
      jbtCreateDS.setFont(buttonFont3);
      jbtViewDS.setFont(buttonFont3);
      //jbtRetrieveDS.setFont(buttonFont3);
      jbtUpdateDS.setFont(buttonFont3);
      jbtMenu.setFont(buttonFont3);
      jbtHome.setFont(buttonFont3);
      jbtRead.setFont(buttonFont2);
      jbtReset.setFont(buttonFont2);
      jbtUpdate.setFont(buttonFont2);
      jbtClear.setFont(buttonFont2);
      jbtInactive.setFont(buttonFont2);
      //jtfSearch.setFont(buttonFont2);
      
      jbtCreateDS.setBackground(Color.WHITE);
      jbtViewDS.setBackground(Color.WHITE);
      //jbtRetrieveDS.setBackground(Color.WHITE);
      jbtUpdateDS.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtRead.setBackground(Color.WHITE);
      jbtReset.setBackground(Color.WHITE);
      jbtUpdate.setBackground(Color.WHITE);
      jbtClear.setBackground(Color.WHITE);
      jbtInactive.setBackground(Color.WHITE);
      
       jbtCreateDS.setBorder(buttonBorder);
       jbtViewDS.setBorder(buttonBorder);
       //jbtRetrieveDS.setBorder(buttonBorder);
       jbtUpdateDS.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtRead.setBorder(buttonBorder2);
       jbtReset.setBorder(buttonBorder2);
       jbtUpdate.setBorder(buttonBorder2);
       jbtClear.setBorder(buttonBorder2);
       jbtInactive.setBorder(buttonBorder2);
      
      jbtCreateDS.setMnemonic('C');
      jbtViewDS.setMnemonic('V');
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
         jbtRead.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtRead.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtRead.setBackground(Color.WHITE);
        
    }
});
         jbtReset.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtReset.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtReset.setBackground(Color.WHITE);
        
    }
});
         jbtUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtUpdate.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtUpdate.setBackground(Color.WHITE);
        
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
         jbtInactive.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtInactive.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtInactive.setBackground(Color.WHITE);
        
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
          
        jbtRead.addActionListener(new ReadListener());
        jtfSearch.addActionListener(new ReadListener());
        jtfSearch.addKeyListener(new KeyAdapter() {

  public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
  }
});
        
        jbtReset.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               jtfSearch.setText("");
           }
       });
        jbtClear.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
                jtfScheduleID.setText("");
                jtfScheduleDate.setText("");
                jtfDriverID.setText("");
                jtfAvailability.setText("");
                jtfScheduleID2.setText("");
                jtfScheduleDate2.setText("");
                jtfDriverID2.setText("");
                jcboDSList.setSelectedIndex(0);
           }
       });
        jbtUpdate.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
           if(jtfScheduleID.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Please enter the schedule ID.","WARNING",JOptionPane.WARNING_MESSAGE); 
           }
           else
           {
              //int dialogResult=JOptionPane.showConfirmDialog(null,"Are you sure you want to inactive schedule ID "+jtfScheduleID.getText()+" 's records","Inactive Confirmation",JOptionPane.YES_NO_OPTION);
              //if(dialogResult == 0) 
              //{
              String selectedItem=jcboDSList.getSelectedItem().toString();
              String ava="";
              if(selectedItem.compareTo("Available")==0)
              {
              ava="AVL";
              }
              else if(selectedItem.compareTo("On Duty")==0)
              {
              ava="DTY";    
              }
              else
              {
              ava="LEA";
              }
              dsControl.updateRecord(jtfScheduleID2.getText(),ava);
              //}
           }
           }
       });
      jbtInactive.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
            if(jtfScheduleID.getText().isEmpty())
           {
            JOptionPane.showMessageDialog(null, "Please enter the schedule ID.","WARNING",JOptionPane.WARNING_MESSAGE); 
           }
           else
           {
               int dialogResult=JOptionPane.showConfirmDialog(null,"Are you sure you want to inactive schedule ID "+jtfScheduleID.getText()+" 's records","Inactive Confirmation",JOptionPane.YES_NO_OPTION);
              if(dialogResult == 0) 
              {
              dsControl.updateRecord(jtfScheduleID2.getText(),"INC");
              
              }
           }
           
           }});
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
     
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
                jtfSearch.setText("Please enter Schedule ID to read");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
      
      jpanel.addMouseListener(new MouseAdapter()
       {
            public void mouseClicked(MouseEvent e)
            {
                jtfSearch.setText("Please enter Schedule ID to read");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
  
      menuPanel_r1.add(jbtCreateDS);
      menuPanel_r2.add(jbtViewDS);
      menuPanel_r3.add(jbtUpdateDS);
      menuPanel_r4.add(jbtMenu);
      menuPanel_r5.add(jbtHome);
      
      subPanel_r1.add(jtfSearch);
      subPanel_r2.add(jbtRead);
      subPanel_r2.add(jbtReset);
      
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
    
      jp3.setOpaque(false);
      jp3.add(subPanel_r1);
      jp3.add(subPanel_r2);
      
     subPanel_r3.setOpaque(false);
     subPanel_r3.setBorder(buttonBorder2);
     jp5.setOpaque(false);
     
     jlbCurrentDS.setFont(buttonFont4);
     jlbScheduleID.setFont(buttonFont2);
     jlbScheduleDate.setFont(buttonFont2);
     jlbAvailability.setFont(buttonFont2);
     jlbDriverID.setFont(buttonFont2);
     
     jlbUpdateDS.setFont(buttonFont4);
     jlbScheduleID2.setFont(buttonFont2);
     jlbScheduleDate2.setFont(buttonFont2);
     jlbAvailability2.setFont(buttonFont2);
     jlbDriverID2.setFont(buttonFont2);
     
     jtfScheduleID.setFont(buttonFont2);
     jtfScheduleDate.setFont(buttonFont2);
     jtfAvailability.setFont(buttonFont2);
     jtfDriverID.setFont(buttonFont2);
     
     jtfScheduleID2.setFont(buttonFont2);
     jtfScheduleDate2.setFont(buttonFont2);
     jcboDSList.setFont(buttonFont2);
     jtfDriverID2.setFont(buttonFont2);
     
     jtfScheduleID.setPreferredSize(new Dimension(200,39));
     jtfScheduleID2.setPreferredSize(new Dimension(100,30));
     
     jtfScheduleID.setEditable(false);
     jtfScheduleDate.setEditable(false);
     jtfAvailability.setEditable(false);
     jtfDriverID.setEditable(false);
     
     jtfScheduleID2.setEditable(false);
     jtfScheduleDate2.setEditable(false);
     jtfDriverID2.setEditable(false);
             
     jp5.add(jlbCurrentDS);
     jp5.add(new JLabel(""));
     jp5.add(jlbScheduleID);
     jp5.add(jtfScheduleID);
     jp5.add(jlbScheduleDate);
     jp5.add(jtfScheduleDate);
     jp5.add(jlbDriverID);
     jp5.add(jtfDriverID);
     jp5.add(jlbAvailability);
     jp5.add(jtfAvailability);
     subPanel_r3.add(jp5);
     
     jp6.setOpaque(true);
     subPanel_r4.setOpaque(true);
     jp6.setBackground(Color.WHITE);
     subPanel_r4.setBackground(Color.WHITE);
     subPanel_r4.setBorder(buttonBorder2);
     jp6.add(jlbUpdateDS);
     jp6.add(new JLabel(""));
     jp6.add(jlbScheduleID2);
     jp6.add(jtfScheduleID2);
     jp6.add(jlbScheduleDate2);
     jp6.add(jtfScheduleDate2);
     jp6.add(jlbDriverID2);
     jp6.add(jtfDriverID2);
     jp6.add(jlbAvailability2);
     jp6.add(jcboDSList);
     jp6.add(new JLabel(""));
     subPanel_r4.add(jp6);
     
     subPanel_r5.add(jbtClear);
     subPanel_r5.add(jbtUpdate);
     subPanel_r5.add(jbtInactive);
     jp6.add(subPanel_r5);
     subPanel_r5.setOpaque(true);
     subPanel_r5.setBackground(Color.WHITE);
     //subPanel_r4.add(jp6);
     
    
     jp4.add(subPanel_r3);
     jp4.add(subPanel_r4);
     subPanel_r4.setBackground(Color.WHITE);
     subPanel_r4.setOpaque(true);
     jp4.setOpaque(true);
     jp4.setBackground(Color.WHITE);
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp3,BorderLayout.CENTER);
     jpanel.add(jp4,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Update Driver Schedule");
     setSize(1350,640);
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
      public void closeFrame() {
                this.dispose();
        }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
       private class ReadListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
          {
             
              if(!jtfSearch.getText().isEmpty())
              {
                DriverScheduleClass ds = dsControl.getRecord(jtfSearch.getText());
              
              if(ds!=null)
              {
                  String ava="";
                 jtfScheduleID.setText(ds.getScheduleid());
                 jtfScheduleID2.setText(ds.getScheduleid());
                 DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
                 String str3 = df3.format(ds.getScheduledate());
                 jtfScheduleDate.setText(str3);
                 jtfScheduleDate2.setText(str3);
                 jtfDriverID.setText(ds.getDriverid());
                 jtfDriverID2.setText(ds.getDriverid());
                 if(ds.getAvailability().compareTo("AVL")==0)
                 {
                     ava="Available";
                 }
                 else if(ds.getAvailability().compareTo("DTY")==0)
                 {
                     ava="On Duty";
                 }
                 else if(ds.getAvailability().compareTo("LEA")==0)
                 {
                     ava="On Leave";
                 }
                 else
                 {
                     ava="Inactive";
                 }
                 
                 jtfAvailability.setText(ava);
                 
                 if(jtfAvailability.getText().compareTo("Inactive")==0)
                 {
                     jbtUpdate.setEnabled(false);
                     jbtInactive.setEnabled(false);
                     jtfScheduleID2.setText("");
                     jtfScheduleDate2.setText("");
                     jtfDriverID2.setText("");
                     jcboDSList.setEnabled(false);
                 }
                 else
                 {
                     jbtUpdate.setEnabled(true);
                     jbtInactive.setEnabled(true);
                     jcboDSList.setEnabled(true);
                  
                 }
                  
              }
              else
              {
                   JOptionPane.showMessageDialog(null, "scheduleID entered did not exist in database.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                   jtfSearch.setText("");
              }
              }
               else
              {
                  JOptionPane.showMessageDialog(null, "Empty string is detected.\nPlease enter scheduleID to read.","WARNING",JOptionPane.WARNING_MESSAGE); 
              }
              
            initComboBox(jtfAvailability.getText());   
          }
       
       }
       private void initComboBox(String ava){
     jcboDSList.removeAllItems();
     dcbomDSList.removeAllElements();
     
     for(int i=0; i<avaList.size(); i++){
            
         dcbomDSList.addElement(avaList.get(i));
         
           //System.out.println(avaList.get(i));
            if(ava.compareTo(avaList.get(i))==0)
            {
                 String str = avaList.get(i);
                 Object obj = str;
                 //System.out.print(obj);
                 int index=dcbomDSList.getIndexOf(obj);
                 dcbomDSList.removeElementAt(index);
                 //System.out.print(index);
            }
                 
        }
      
       
       }
      public static void main(String[]args)
    {
        new UpdateDriverSchedule('U');
    }
}