//Sum
//V1.00 24MAR16 1152AM
package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;
import java.text.ParseException;

import da.*;
import ui.*;
import domain.*;
import control.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class homePage extends JFrame
{
    public static String now(String dateFormat) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(cal.getTime());
  }
    private char accType;
    TripControl tripControl;
    ArrayList<TripClass> tripList=new ArrayList<TripClass>();
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/homePageBackground.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
     ImageIcon iconLogo=new ImageIcon(getClass().getResource("../images/ezWayLogo.jpg"));
     
    private ImageIcon securityIcon = new ImageIcon(getClass().getResource("../images/security.png"));
    private ImageIcon staffIcon = new ImageIcon(getClass().getResource("../images/staff.png"));
    private ImageIcon seatIcon = new ImageIcon(getClass().getResource("../images/seat.png"));
    private ImageIcon ticketIcon = new ImageIcon(getClass().getResource("../images/ticket.png"));
    private ImageIcon reportIcon = new ImageIcon(getClass().getResource("../images/report.png"));
    private ImageIcon logoutIcon = new ImageIcon(getClass().getResource("../images/logout.png"));
   
     Font buttonFont=new Font("French Script MT",Font.ITALIC,32);
     Font buttonFont2=new Font("Century",Font.ITALIC,18);
     JLabel jlogo=new JLabel(iconLogo);
     JLabel jslogan=new JLabel("Easiest and Fastest way to reach your destination."); 
     JPanel jp2=new JPanel(new GridLayout(6,1));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
    JButton jbtSecurity=new JButton("Security Features",securityIcon);
    JButton jbtStaff=new JButton("Staff Details",staffIcon);
    JButton jbtSeat=new JButton("Seat and Scheduling",seatIcon);
    JButton jbtTicket=new JButton("Ticket Purchasing",ticketIcon);
    JButton jbtReport=new JButton("Generating Report",reportIcon);
    JButton jbtLogOut=new JButton("Log out",logoutIcon);
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
     
     private JMenuItem jmiSecurity,jmiStaff, jmiSeat, jmiTicket, jmiReport,jmiLogOut,jmiClose;
    
    public homePage(){
        
    } 
     public homePage(final char accType)
    {
        this.accType = accType;
        //authorization
        if(accType == 'U'){

            jbtSecurity.setEnabled(true);
            jbtStaff.setEnabled(false);
            jbtSeat.setEnabled(true);
            jbtTicket.setEnabled(true);
            jbtReport.setEnabled(true); 
            
            
        }
        else{
            
            jbtSecurity.setEnabled(true);
            jbtStaff.setEnabled(true);
            jbtSeat.setEnabled(true);
            jbtTicket.setEnabled(true);
            jbtReport.setEnabled(true);
            
        }
       
     tripControl=new TripControl(); 
     autoDetectDate();   
     setLayout(new BorderLayout());
     
     jlogo.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jlogo);
     jpanel.add(jslogan);
     jslogan.setFont(buttonFont);
      
     jbtSecurity.setPreferredSize(new Dimension(250, 50));
     jbtStaff.setPreferredSize(new Dimension(250, 50));
     jbtSeat.setPreferredSize(new Dimension(250, 50));
     jbtTicket.setPreferredSize(new Dimension(250, 50));
     jbtReport.setPreferredSize(new Dimension(250, 50));
     jbtLogOut.setPreferredSize(new Dimension(250, 50));
     
      jbtSecurity.setFont(buttonFont2);
      jbtStaff.setFont(buttonFont2);
      jbtSeat.setFont(buttonFont2);
      jbtTicket.setFont(buttonFont2);
      jbtReport.setFont(buttonFont2);
      jbtLogOut.setFont(buttonFont2);
      
       jbtSecurity.setBackground(Color.WHITE);
       jbtStaff.setBackground(Color.WHITE);
       jbtSeat.setBackground(Color.WHITE);
       jbtTicket.setBackground(Color.WHITE);
       jbtReport.setBackground(Color.WHITE);
       jbtLogOut.setBackground(Color.WHITE);
       
       jbtSecurity.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSecurity.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSecurity.setBackground(Color.WHITE);
        
    }
});
        jbtSeat.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSeat.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSeat.setBackground(Color.WHITE);
        
    }
});
         jbtReport.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtReport.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtReport.setBackground(Color.WHITE);
        
    }
});
       jbtStaff.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtStaff.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtStaff.setBackground(Color.WHITE);
        
    }
});
        jbtTicket.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtTicket.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtTicket.setBackground(Color.WHITE);
        
    }
});
         jbtLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtLogOut.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtLogOut.setBackground(Color.WHITE);
        
    }
});
     
       jbtSecurity.setBorder(buttonBorder);
       jbtSeat.setBorder(buttonBorder);
       jbtReport.setBorder(buttonBorder);
       
       jbtStaff.setBorder(buttonBorder2);
       jbtTicket.setBorder(buttonBorder2);
       jbtLogOut.setBorder(buttonBorder2);
       
      jbtSecurity.setMnemonic('F');
      jbtStaff.setMnemonic('D');
      jbtSeat.setMnemonic('S');
      jbtTicket.setMnemonic('T');
      jbtReport.setMnemonic('R');
      jbtLogOut.setMnemonic('L');
     
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
      menuPanel_r6.setOpaque(false);
      
      menuPanel_r1.add(jbtSecurity);
      menuPanel_r2.add(jbtStaff);
      menuPanel_r3.add(jbtSeat);
      menuPanel_r4.add(jbtTicket);
      menuPanel_r5.add(jbtReport);
      menuPanel_r6.add(jbtLogOut);
      
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
      jp2.add( menuPanel_r6);
      
     jpanel.add(jp2,BorderLayout.CENTER);
     add(jpanel,BorderLayout.CENTER);
     
     JMenuBar jmb = new JMenuBar();
       setJMenuBar(jmb);
       
        JMenu operationMenu = new JMenu("Operation");
        operationMenu.setMnemonic('O');
        jmb.add(operationMenu);
        
        JMenu exitMenu = new JMenu("Exit");
        exitMenu.setMnemonic('E');
        jmb.add(exitMenu);
         if(accType == 'U'){
         operationMenu.add(jmiSecurity = new JMenuItem("Security Features", 'F'));
        operationMenu.add(jmiSeat = new JMenuItem("Seats and Scheduling", 'S'));
        operationMenu.add(jmiTicket = new JMenuItem("Ticket Purchasing", 'T'));
        operationMenu.add(jmiReport = new JMenuItem("Generating Report", 'R'));
        operationMenu.add(jmiLogOut = new JMenuItem("Log out", 'L'));
        exitMenu.add(jmiClose = new JMenuItem("Close", 'C'));
        
        jmiSecurity.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        jmiSeat.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        jmiTicket.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        jmiReport.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        jmiLogOut.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        jmiClose.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
         
         }else
         {
        operationMenu.add(jmiSecurity = new JMenuItem("Security Features", 'F'));
        operationMenu.add(jmiStaff = new JMenuItem("Staff Details", 'D'));
        operationMenu.add(jmiSeat = new JMenuItem("Seats and Scheduling", 'S'));
        operationMenu.add(jmiTicket = new JMenuItem("Ticket Purchasing", 'T'));
        operationMenu.add(jmiReport = new JMenuItem("Generating Report", 'R'));
        operationMenu.add(jmiLogOut = new JMenuItem("Log out", 'L'));
        exitMenu.add(jmiClose = new JMenuItem("Close", 'C'));
        
         jmiSecurity.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        jmiStaff.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        jmiSeat.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        jmiTicket.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        jmiReport.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        jmiLogOut.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        jmiClose.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        
        jmiStaff.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
              new StaffMenu(accType);
            }
        });
        
        
         }
         
        
        
       
        //register button listener
        jbtSecurity.addActionListener(new ButtonListener());
        jbtStaff.addActionListener(new ButtonListener());
        jbtSeat.addActionListener(new ButtonListener());
        jbtTicket.addActionListener(new ButtonListener());
        jbtReport.addActionListener(new ButtonListener());
        jbtLogOut.addActionListener(new ButtonListener());
        
        jmiSecurity.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
              new SecurityFeaturesMenu(accType);
            }
        });
        
        
         jmiSeat.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
              new ScheduleMenu(accType);
            }
        });
         
         jmiTicket.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
             new TicketPurchasingMenu(accType);
            }
        });
          jmiReport.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
            //new ReportMenu(accType);
            }
        });
          
         jmiLogOut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
            new LoginPage();
            }
        });
         
         jmiClose.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              closeFrame();
            new LoginPage();
            }
        });
        
        //register window listener
        addWindowListener(new WindowListener());
        
     setIcon();
     setTitle("Home");
     setSize(850,600);
     setVisible(true);
     setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
    }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      
      private class ButtonListener implements ActionListener{
          public void actionPerformed(ActionEvent e){
              if(e.getSource() == jbtSecurity){
                  dispose();
                  new SecurityFeaturesMenu(accType);
              }
              else if(e.getSource() == jbtStaff){
                  dispose();
                  new StaffMenu(accType);
              }
              else if(e.getSource() == jbtSeat){
                  dispose();
                  new ScheduleMenu(accType);
              }
              else if(e.getSource() == jbtTicket){
                  dispose();
                  new TicketPurchasingMenu(accType);
              }
              else if(e.getSource() == jbtReport){
                  dispose();
                  //new ReportMenu(accType);
              }
              else if(e.getSource() == jbtLogOut){
                  dispose();
                  new LoginPage();
              }
          }
      }
      public static void main(String[]args)
    {
        new homePage('A'); //dev only////
    }
      public void closeFrame() {
                this.dispose();
        }
   
      private void autoDetectDate()
      {
         /*  tripList=tripControl.getRecordbyDate();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date convertedDate = dateFormat.parse(homePage.now("yyyy-MM-dd"));
            for(int i=0;i<tripList.size();i++)
            {
            if(tripList.get(i).getDepartdate().compareTo(convertedDate)<0)
            {
            tripControl.inactiveBackEndRecord(tripList.get(i).getTripno(), 'X');
            
            }
            }
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
      }
      private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            int confirm = JOptionPane.showConfirmDialog(null,"Return to Login Page?","Return?",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                    
                    dispose();
                    new LoginPage();
        }

       }
    }
}