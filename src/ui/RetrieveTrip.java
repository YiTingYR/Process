package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;
import da.*;
import domain.*;
import control.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RetrieveTrip extends JFrame
{
    TripControl tripControl;
    RouteControl routeControl;
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
     
     JLabel jtrip=new JLabel("Trip Management- Retrieve Trip Details"); 
     JPanel jp2=new JPanel(new GridLayout(1,6));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new GridLayout(10,2));
     JPanel jp5=new JPanel(new GridLayout(1,2));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton jbtCreateTrip=new JButton("Create New Trip");
    JButton jbtViewTrip=new JButton("View Trip Table");
    JButton jbtRetrieveTrip=new JButton("Retrieve Trip");
    JButton jbtUpdateTrip=new JButton("Update Trip");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    
    JTextField jtfSearch=new JTextField("Please enter Trip Number to read",40);
    JButton jbtSearch=new JButton("Read");
    JButton jbtReset=new JButton("Reset");
    
    JLabel jlbTripNo=new JLabel("Trip Number");
    JLabel jlbOrigin=new JLabel("Origin");
    JLabel jlbDestination=new JLabel("Destination");
    JLabel jlbDepDate=new JLabel("Departure Date");
    JLabel jlbDepTime=new JLabel("Departure Time (24hrs)");
    JLabel jlbTotSeat=new JLabel("Total Seat (s)");
    JLabel jlbAvailableSeat=new JLabel("Available Seat (s)");
    JLabel jlbPrice=new JLabel("Trip Price (RM)");
    JLabel jlbBusID=new JLabel("Bus ID");
    JLabel jlbStatus=new JLabel("Status");
    
    JTextField jtfTripNo=new JTextField(15);
    JTextField jtfOrigin=new JTextField(15);
    JTextField jtfDestination=new JTextField(15);
    JTextField jtfDepDate=new JTextField(15);
    JTextField jtfDepTime=new JTextField(15);
    JTextField jtfTotSeat=new JTextField(15);
    JTextField jtfAvailableSeat=new JTextField(15);
    JTextField jtfPrice=new JTextField(15);
    JTextField jtfBusID=new JTextField(15);
    JTextField jtfStatus=new JTextField(15);
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
     public RetrieveTrip(final char accType)
    {
     this.accType=accType;     
     if(accType=='U')
     {
     jbtCreateTrip.setEnabled(false);
     jbtUpdateTrip.setEnabled(false);
     }
     else
     {
     jbtCreateTrip.setEnabled(true);
     jbtUpdateTrip.setEnabled(true);
     }
     
      tripControl=new TripControl(); 
      routeControl=new RouteControl();
     setLayout(new BorderLayout());
     
     jtrip.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jtrip);
     jtrip.setFont(buttonFont);
     
     jbtCreateTrip.setPreferredSize(new Dimension(150, 40));
     jbtViewTrip.setPreferredSize(new Dimension(150, 40));
     jbtRetrieveTrip.setPreferredSize(new Dimension(150, 40));
     jbtUpdateTrip.setPreferredSize(new Dimension(150, 40));
     jbtMenu.setPreferredSize(new Dimension(150, 40));
     jbtHome.setPreferredSize(new Dimension(150, 40));
     
     jbtSearch.setPreferredSize(new Dimension(100, 28));
     jbtReset.setPreferredSize(new Dimension(100, 28));
     
     jtfTripNo.setPreferredSize(new Dimension(150, 40));
     
      jbtCreateTrip.setFont(buttonFont2);
      jbtViewTrip.setFont(buttonFont2);
      jbtRetrieveTrip.setFont(buttonFont2);
      jbtUpdateTrip.setFont(buttonFont2);
      jbtMenu.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      jbtSearch.setFont(buttonFont2);
      jbtReset.setFont(buttonFont2);
      
      jlbTripNo.setFont(buttonFont2);
      jtfTripNo.setFont(buttonFont2);
      jlbOrigin.setFont(buttonFont2);
      jtfOrigin.setFont(buttonFont2);
      jlbDestination.setFont(buttonFont2);
      jtfDestination.setFont(buttonFont2);
      jlbDepDate.setFont(buttonFont2);
      jtfDepDate.setFont(buttonFont2);
      jlbDepTime.setFont(buttonFont2);
      jtfDepTime.setFont(buttonFont2);
      jlbTotSeat.setFont(buttonFont2);
      jtfTotSeat.setFont(buttonFont2);
      jlbAvailableSeat.setFont(buttonFont2);
      jtfAvailableSeat.setFont(buttonFont2);
      jlbPrice.setFont(buttonFont2);
      jtfPrice.setFont(buttonFont2);
      jlbBusID.setFont(buttonFont2);
      jtfBusID.setFont(buttonFont2);
      jlbStatus.setFont(buttonFont2);
      jtfStatus.setFont(buttonFont2);
      
      jtfTripNo.setEditable(false);
      jtfOrigin.setEditable(false);
      jtfDestination.setEditable(false);
      jtfDepDate.setEditable(false);
      jtfDepTime.setEditable(false);
      jtfTotSeat.setEditable(false);
      jtfAvailableSeat.setEditable(false);
      jtfPrice.setEditable(false);
      jtfBusID.setEditable(false);
      jtfStatus.setEditable(false);
      
      
  jtfSearch.addKeyListener(new KeyAdapter() {

  public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
  }
});
      
      jbtCreateTrip.setBackground(Color.WHITE);
      jbtViewTrip.setBackground(Color.WHITE);
      jbtRetrieveTrip.setBackground(Color.WHITE);
      jbtUpdateTrip.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtSearch.setBackground(Color.WHITE);
      jbtReset.setBackground(Color.WHITE);
      
       jbtCreateTrip.setBorder(buttonBorder);
       jbtViewTrip.setBorder(buttonBorder);
       jbtRetrieveTrip.setBorder(buttonBorder);
       jbtUpdateTrip.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtSearch.setBorder(buttonBorder2);
       jbtReset.setBorder(buttonBorder2);
      
      jbtCreateTrip.setMnemonic('C');
      jbtViewTrip.setMnemonic('V');
      jbtRetrieveTrip.setMnemonic('R');
      jbtUpdateTrip.setMnemonic('U');
      jbtMenu.setMnemonic('B');
      jbtHome.setMnemonic('M');
      
       jbtCreateTrip.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCreateTrip.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCreateTrip.setBackground(Color.WHITE);
        
    }
});
       jbtViewTrip.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtViewTrip.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtViewTrip.setBackground(Color.WHITE);
        
    }
});
       jbtRetrieveTrip.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtRetrieveTrip.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtRetrieveTrip.setBackground(Color.WHITE);
        
    }
});
       jbtUpdateTrip.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtUpdateTrip.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtUpdateTrip.setBackground(Color.WHITE);
        
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
        jbtReset.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtReset.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtReset.setBackground(Color.WHITE);
        
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
          jbtCreateTrip.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               //new CreateNewTrip(accType);
           }
       });
          
          jbtViewTrip.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new TripMgmt(accType);
           }
       });
          jbtRetrieveTrip.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new RetrieveTrip(accType);
           }
       });
          jbtUpdateTrip.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               //new UpdateTrip(accType);
           }
       });
        
        jbtSearch.addActionListener(new ReadListener());
        jtfSearch.addActionListener(new ReadListener());
        
        jbtReset.addActionListener(new ActionListener()
        { 
          public void actionPerformed(ActionEvent e)
          {
                jtfSearch.setText("");
          }
        });
      
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
      menuPanel_r6.setOpaque(false);
      
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
                jtfSearch.setText("Please enter Trip Number to read");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
      
      jpanel.addMouseListener(new MouseAdapter()
       {
            public void mouseClicked(MouseEvent e)
            {
                jtfSearch.setText("Please enter Trip Number to read");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
  
      menuPanel_r1.add(jbtCreateTrip);
      menuPanel_r2.add(jbtViewTrip);
      menuPanel_r3.add(jbtRetrieveTrip);
      menuPanel_r4.add(jbtUpdateTrip);
      menuPanel_r5.add(jbtMenu);
      menuPanel_r6.add(jbtHome);
      
      subPanel_r1.add(jtfSearch);
      subPanel_r2.add(jbtSearch);
      subPanel_r2.add(jbtReset);
      
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
      jp2.add( menuPanel_r6);
      
      jp3.setOpaque(false);
      jp3.add(subPanel_r1);
      jp3.add(subPanel_r2);
      
      jp4.setOpaque(false);
      jp4.add(jlbTripNo);
      jp4.add(jtfTripNo);
      jp4.add(jlbOrigin);
      jp4.add(jtfOrigin);
      jp4.add(jlbDestination);
      jp4.add(jtfDestination);
      jp4.add(jlbDepDate);
      jp4.add(jtfDepDate);
      jp4.add(jlbDepTime);
      jp4.add(jtfDepTime);
      jp4.add(jlbTotSeat);
      jp4.add(jtfTotSeat);
      jp4.add(jlbAvailableSeat);
      jp4.add(jtfAvailableSeat);
      jp4.add(jlbPrice);
      jp4.add(jtfPrice);
      jp4.add(jlbBusID);
      jp4.add(jtfBusID);
      jp4.add(jlbStatus);
      jp4.add(jtfStatus);
      
      jp4.setBorder(buttonBorder2);
      
      jp5.setOpaque(false);
      jp5.add(jp4);
      subPanel_r3.setOpaque(false);
      jp5.add(subPanel_r3);
      
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp3,BorderLayout.CENTER);
     jpanel.add(jp5,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Retrieve Trip Details");
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
              TripClass trip = tripControl.selectRecord(jtfSearch.getText());
              if(trip!=null)
              {
                 jtfTripNo.setText(trip.getTripno());
                 DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
                 String str3 = df3.format(trip.getDepartdate());
                 jtfDepDate.setText(str3);
                 jtfDepTime.setText(trip.getDeparttime());
                 jtfTotSeat.setText(trip.getTotalseat()+"");
                 jtfAvailableSeat.setText(trip.getAvailableseat()+"");
                 jtfPrice.setText(String.format("%.2f",trip.getTripprice()));
                 jtfBusID.setText(trip.getBusid());
                 jtfStatus.setText(trip.getStatus());
                 
                 String routeid=trip.getRouteid();
                 Route route = routeControl.selectRecord(routeid);
                 if(route!=null){
                 jtfOrigin.setText(route.getOrigin());
                 jtfDestination.setText(route.getDestination());
                 
              }
              }
              else
              {
                   JOptionPane.showMessageDialog(null, "Trip number entered did not exist in database.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                   jtfSearch.setText("");
              }
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Empty string is detected.\nPlease enter trip number to read.","WARNING",JOptionPane.WARNING_MESSAGE); 
              }
          }
      }
      public static void main(String[]args)
    {
        new RetrieveTrip('U');
    }
}