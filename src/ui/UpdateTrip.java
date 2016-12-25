package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;
import domain.*;
import control.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.DocumentEvent;
import javax.swing.event.*;

public class UpdateTrip extends JFrame
{
    BusControl busControl;
    RouteControl routeControl;
    TripControl tripControl;
    TripSeatControlForSchedule tripSeatControl;
    public ArrayList<Bus> busList = new ArrayList<Bus>();
    ArrayList<String> busIDOnSameDate = new ArrayList<String>();
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
     Font buttonFont3=new Font("French Script MT",Font.ITALIC,35);
     
     JLabel jtrip=new JLabel("Trip Management- Update Trip Details"); 
     JPanel jp2=new JPanel(new GridLayout(1,6));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new GridLayout(10,2));
     JPanel jp5=new JPanel(new GridLayout(1,2,10,10));
     JPanel jp6=new JPanel(new GridLayout(10,2));
     JPanel jp7=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel jp8=new JPanel(new FlowLayout(FlowLayout.RIGHT));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.LEFT));
   
    JButton jbtCreateTrip=new JButton("Create New Trip");
    JButton jbtViewTrip=new JButton("View Trip Table");
    JButton jbtRetrieveTrip=new JButton("Retrieve Trip");
    JButton jbtUpdateTrip=new JButton("Update Trip");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    
    JTextField jtfSearch=new JTextField("Please enter Trip Number to read",40);
    JButton jbtSearch=new JButton("Read");
    JButton jbtReset=new JButton("Reset");
    JButton jbtUpdate=new JButton("Update");
    JButton jbtClear=new JButton("Clear");
    JButton jbtInactive=new JButton("Inactive");
    
    JLabel jlbCurrent=new JLabel("Current Details");
    JLabel jlbBlank=new JLabel("");
    JLabel jlbTripNo=new JLabel("Trip Number");
    JLabel jlbRouteID=new JLabel("RouteID");
    JLabel jlbDepDate=new JLabel("Departure Date");
    JLabel jlbDepTime=new JLabel("Departure Time (24hrs)");
    JLabel jlbTotSeat=new JLabel("Total Seat (s)");
    JLabel jlbAvailableSeat=new JLabel("Available Seat (s)");
    JLabel jlbPrice=new JLabel("Trip Price (RM)");
    JLabel jlbBusID=new JLabel("Bus ID");
    JLabel jlbStatus=new JLabel("Status");
    
    JLabel jlbUpdate=new JLabel("Update Details");
    JLabel jlbBlank2=new JLabel("");
    JLabel jlbTripNo2=new JLabel("Trip Number");
    JLabel jlbRouteID2=new JLabel("RouteID");
    
    JLabel jlbDepDate2=new JLabel("Departure Date");
    JLabel jlbDepTime2=new JLabel("Departure Time (24hrs)");
    JLabel jlbTotSeat2=new JLabel("Total Seat (s)");
    JLabel jlbAvailableSeat2=new JLabel("Available Seat (s)");
    JLabel jlbPrice2=new JLabel("Trip Price (RM)");
    JLabel jlbBusID2=new JLabel("Bus ID");
   
    JTextField jtfTripNo2=new JTextField(15);
    JTextField jtfRouteID2=new JTextField(15);
    
    JTextField jtfDepDate2=new JTextField(15);
    JTextField jtfDepTime2=new JTextField(15);
    JTextField jtfTotSeat2=new JTextField(15);
    JTextField jtfAvailableSeat2=new JTextField(15);
    JTextField jtfPrice2=new JTextField(15);
     private DefaultComboBoxModel dcbomBusList= new DefaultComboBoxModel();
    private JComboBox jcboBusList = new JComboBox(dcbomBusList);
    
    JTextField jtfTripNo=new JTextField(15);
    JTextField jtfRouteID=new JTextField(15);
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
     public UpdateTrip(final char accType)
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
        
     busControl = new BusControl();
     routeControl=new RouteControl();
     tripControl=new TripControl();
     tripSeatControl=new TripSeatControlForSchedule();
        
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
     jbtUpdate.setPreferredSize(new Dimension(100, 28));
     jbtClear.setPreferredSize(new Dimension(100, 28));
     jbtInactive.setPreferredSize(new Dimension(100,28));
     
     jtfTripNo.setPreferredSize(new Dimension(150, 40));
     
      jbtCreateTrip.setFont(buttonFont2);
      jbtViewTrip.setFont(buttonFont2);
      jbtRetrieveTrip.setFont(buttonFont2);
      jbtUpdateTrip.setFont(buttonFont2);
      jbtMenu.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      jbtSearch.setFont(buttonFont2);
      jbtReset.setFont(buttonFont2);
      jbtUpdate.setFont(buttonFont2);
      jbtClear.setFont(buttonFont2);
      jbtInactive.setFont(buttonFont2);
      
      jlbTripNo.setFont(buttonFont2);
      jtfTripNo.setFont(buttonFont2);
      jlbRouteID.setFont(buttonFont2);
      jtfRouteID.setFont(buttonFont2);
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
      
      jlbTripNo2.setFont(buttonFont2);
      jtfTripNo2.setFont(buttonFont2);
      jlbRouteID2.setFont(buttonFont2);
      jlbDepDate2.setFont(buttonFont2);
      jtfDepDate2.setFont(buttonFont2);
      jlbDepTime2.setFont(buttonFont2);
      jtfDepTime2.setFont(buttonFont2);
      jlbTotSeat2.setFont(buttonFont2);
      jtfTotSeat2.setFont(buttonFont2);
      jlbAvailableSeat2.setFont(buttonFont2);
      jtfAvailableSeat2.setFont(buttonFont2);
      jlbPrice2.setFont(buttonFont2);
      jtfPrice2.setFont(buttonFont2);
      jlbBusID2.setFont(buttonFont2);
      jcboBusList.setFont(buttonFont2);
     
      jtfTripNo.setEditable(false);
      jtfRouteID.setEditable(false);
      jtfDepDate.setEditable(false);
      jtfDepTime.setEditable(false);
      jtfTotSeat.setEditable(false);
      jtfAvailableSeat.setEditable(false);
      jtfPrice.setEditable(false);
      jtfBusID.setEditable(false);
      jtfStatus.setEditable(false);
      
      jtfTripNo2.setEditable(false);
      jtfRouteID2.setEditable(false);
      jtfDepDate2.setEditable(false);
      jtfDepTime2.setEditable(false);
      jtfTotSeat2.setEditable(false);
      jtfAvailableSeat2.setEditable(false);
      jtfPrice.setEditable(false);
      jtfBusID.setEditable(false);
      
      jbtCreateTrip.setBackground(Color.WHITE);
      jbtViewTrip.setBackground(Color.WHITE);
      jbtRetrieveTrip.setBackground(Color.WHITE);
      jbtUpdateTrip.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtSearch.setBackground(Color.WHITE);
      jbtReset.setBackground(Color.WHITE);
      jbtInactive.setBackground(Color.WHITE);
      
       jbtCreateTrip.setBorder(buttonBorder);
       jbtViewTrip.setBorder(buttonBorder);
       jbtRetrieveTrip.setBorder(buttonBorder);
       jbtUpdateTrip.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtSearch.setBorder(buttonBorder2);
       jbtReset.setBorder(buttonBorder2);
       jbtClear.setBorder(buttonBorder2);
       jbtUpdate.setBorder(buttonBorder2);
       jbtInactive.setBorder(buttonBorder2);
      
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
               new UpdateTrip(accType);
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
        
      //initComboBox();   
      
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
      jtfSearch.addKeyListener(new KeyAdapter() {

  public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
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
      
     
      jlbCurrent.setFont(buttonFont3);
      jlbUpdate.setFont(buttonFont3);
      jlbCurrent.setForeground(new Color(32, 178, 170));
      jlbUpdate.setForeground(new Color(32, 178, 170));
   
      jp4.setOpaque(false);
      jp4.add(jlbCurrent);
      jp4.add(jlbBlank);
      jp4.add(jlbTripNo);
      jp4.add(jtfTripNo);
      jp4.add(jlbRouteID);
      jp4.add(jtfRouteID);
      jp4.add(jlbDepDate);
      jp4.add(jtfDepDate);
      jp4.add(jlbDepTime);
      jp4.add(jtfDepTime);
      jp4.add(jlbBusID);
      jp4.add(jtfBusID);
      jp4.add(jlbTotSeat);
      jp4.add(jtfTotSeat);
      jp4.add(jlbAvailableSeat);
      jp4.add(jtfAvailableSeat);
      jp4.add(jlbPrice);
      jp4.add(jtfPrice);
      jp4.add(jlbStatus);
      jp4.add(jtfStatus);
      
      jp4.setBorder(buttonBorder2);
      jp6.setBorder(buttonBorder2);
      
      jp7.setOpaque(false);
      jp7.add(jbtUpdate);
      jp7.add(jbtInactive);
      
      jbtUpdate.setBackground(Color.WHITE);
      jbtClear.setBackground(Color.WHITE);
      jbtInactive.setBackground(Color.WHITE);
      
      jp8.setOpaque(false);
      jp8.add(jbtClear);
      
      jbtClear.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
          {
              jtfTripNo.setText("");
              jtfDepDate.setText("");
              jtfDepTime.setText("");
              jtfTotSeat.setText("");
              jtfAvailableSeat.setText("");
              jtfRouteID.setText("");
              jtfPrice.setText("");
              jtfBusID.setText("");
              jtfStatus.setText("");
              
              jtfTripNo2.setText("");
              jtfDepDate2.setText("");
              jtfDepTime2.setText("");
              jtfTotSeat2.setText("");
              jtfAvailableSeat2.setText("");
              jtfRouteID2.setText("");
              jtfPrice2.setText("");
              jcboBusList.removeAllItems();
              
          }
      });
      
      jbtUpdate.addActionListener(new UpdateListener());
      jbtInactive.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
          {
             
              if(jtfSearch.getText().isEmpty())
              {
              JOptionPane.showMessageDialog(null, "Emptry string detected for trip number. Please enter the trip number","WARNING",JOptionPane.WARNING_MESSAGE);
              }
              else
              {
              TripClass trip = tripControl.selectRecord(jtfSearch.getText());
              if(trip!=null)
              {
              int dialogResult=JOptionPane.showConfirmDialog(null,"Are you sure you want to inactive trip number "+jtfSearch.getText()+" 's records","Inactive Confirmation",JOptionPane.YES_NO_OPTION);
              if(dialogResult == 0) 
              {
                tripControl.inactiveRecord(jtfTripNo.getText(),'X');
              }
              }
              else
              {
              JOptionPane.showMessageDialog(null, "Trip number entered did not exist in the database","WARNING",JOptionPane.WARNING_MESSAGE);    
              }
              }
             
          }
      });
      
      jp6.setOpaque(true);
      jp6.setBackground(Color.WHITE);
      jp6.add(jlbUpdate);
      jp6.add(jlbBlank2);
      jp6.add(jlbTripNo2);
      jp6.add(jtfTripNo2);
      jp6.add(jlbRouteID2);
      jp6.add(jtfRouteID2);
      jp6.add(jlbDepDate2);
      jp6.add(jtfDepDate2);
      jp6.add(jlbDepTime2);
      jp6.add(jtfDepTime2);
      jp6.add(jlbBusID2);
      jp6.add(jcboBusList);
      jp6.add(jlbTotSeat2);
      jp6.add(jtfTotSeat2);
      jp6.add(jlbAvailableSeat2);
      jp6.add(jtfAvailableSeat2);
      jp6.add(jlbPrice2);
      jp6.add(jtfPrice2);
      jp6.add(jp8);
      jp6.add(jp7);
      
      jtfPrice2.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                ValidatePrice();
            }
            
            public void removeUpdate(DocumentEvent e){
                //ValidatePrice();
            }
            
            public void insertUpdate(DocumentEvent e){
                ValidatePrice();
            }        
        });
      
    jcboBusList.addActionListener(new ActionListener () {
    public void actionPerformed(ActionEvent e) {
        
         int index=jcboBusList.getSelectedIndex();
         System.out.print(index);
          for(int i=0; i<jcboBusList.getItemCount(); i++){
            if(index==i)
            {
                String selectedBusID=jcboBusList.getItemAt(i).toString();
                Bus bus = busControl.selectRecord(selectedBusID);
                if(bus!=null)
                {
                    if(jtfTripNo2.getText().isEmpty())
                    {
                         jtfTotSeat2.setText("");
                         jtfAvailableSeat2.setText("");
                    }
                    else if(bus.getBustype().compareTo('S')==0)
                    {
                    System.out.println(busList.get(i).getBustype());
                    jtfTotSeat2.setText("24");
                    jtfAvailableSeat2.setText("24");
                    } 
                    else if(bus.getBustype().compareTo('D')==0)
                    {
                    System.out.println(busList.get(i).getBustype());
                    jtfTotSeat2.setText("54");
                    jtfAvailableSeat2.setText("54");
                    
                    }
                    
                }
               
            }
          }
      }});
      
     
      jp5.setOpaque(false);
      jp5.add(jp4);
      jp5.add(jp6);
      
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp3,BorderLayout.CENTER);
     jpanel.add(jp5,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Update Trip Details");
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
     private void initComboBox(char busType,Date sameDepDate){
       
        busList = busControl.getBusList();
        busIDOnSameDate=tripControl.selectBusIDbyDate(busType,sameDepDate);
        //System.out.println(busIDOnSameDate);
        for(int i=0; i<busList.size(); i++){
             
        if(busList.get(i).getBustype().compareTo(busType)==0)
        {
         dcbomBusList.addElement(busList.get(i).getBusid());
         
         for(int j=0;j<busIDOnSameDate.size();j++)
            {
               if(busIDOnSameDate.get(j).compareTo(busList.get(i).getBusid())==0 && jtfBusID.getText().compareTo(busIDOnSameDate.get(j))!=0)
               {
                   String str = busIDOnSameDate.get(j);
                   Object obj = str;

                int index=dcbomBusList.getIndexOf(obj);
                System.out.println(index);
                if(index!=-1)
                {
                    dcbomBusList.removeElementAt(index);
                }
                
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
                 System.out.print(trip.getDepartdate());
                 jtfDepDate.setText(str3);
                 jtfDepTime.setText(trip.getDeparttime());
                 jtfTotSeat.setText(trip.getTotalseat()+"");
                 jtfAvailableSeat.setText(trip.getAvailableseat()+"");
                 jtfPrice.setText(String.format("%.2f",trip.getTripprice()));
                 jtfBusID.setText(trip.getBusid());
                 jtfStatus.setText(trip.getStatus());
                 jtfRouteID.setText(trip.getRouteid());
                 
                 jtfTripNo2.setText(trip.getTripno());
                 jtfDepDate2.setText(str3);
                 jtfDepTime2.setText(trip.getDeparttime());
                 jtfTotSeat2.setText(trip.getTotalseat()+"");
                 jtfAvailableSeat2.setText(trip.getAvailableseat()+"");
                 jtfRouteID2.setText(trip.getRouteid());
                 jtfRouteID2.setFont(buttonFont2);
                 
                 if(jtfStatus.getText().compareTo("Y")==0 ||jtfStatus.getText().compareTo("X")==0)
                 {
                    jtfTripNo2.setText("");
                    jtfDepDate2.setText("");
                    jtfDepTime2.setText("");
                    jtfTotSeat2.setText("");
                    jtfAvailableSeat2.setText("");
                    jtfRouteID2.setText("");
                    
                    jtfPrice2.setEditable(false);
                    jcboBusList.setEnabled(false);
                    
                    jbtUpdate.setEnabled(false);
                    //jbtClear.setEnabled(false);
                    jbtInactive.setEnabled(false);
                 }
                 else
                 {
                    jtfPrice2.setEditable(true);
                    jcboBusList.setEnabled(true);
                    jbtUpdate.setEnabled(true);
                    //jbtClear.setEnabled(true);
                    jbtInactive.setEnabled(true);
                 }
                  jcboBusList.removeAllItems();
                  initComboBox(jtfTripNo.getText().charAt(4),trip.getDepartdate());
                 
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
       private void ValidatePrice()
     {
         
         try{
         double price=Double.parseDouble(jtfPrice2.getText());
          jtfPrice2.setBackground(new Color(240, 255, 240));
         }catch(NumberFormatException ex)
         {
             jtfPrice2.setBackground(new Color(255, 230, 230));
             JOptionPane.showMessageDialog(null, "Alphabetic input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
             //jtfPrice2.setText("");
         }
     
     }
       private class UpdateListener implements ActionListener{
       public void actionPerformed(ActionEvent e)
       {
           int countAlpha=0;
           int countNegative=0;
            for (int i = 0; i < jtfPrice2.getText().length(); i++) {
                char ch = jtfPrice2.getText().charAt(i);
                if (Character.isAlphabetic(ch)) {
                    countAlpha++;
                }
                
            }
            for (int j = 0; j < jtfPrice2.getText().length(); j++) {
                char ch = jtfPrice2.getText().charAt(j);
                if (ch=='-') {
                    countNegative++;
                }
                
            }
            
           if(jtfTripNo2.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Please enter trip number in order to perform update function.","WARNING",JOptionPane.WARNING_MESSAGE);
           }
           else if(countNegative>0)
           {
           JOptionPane.showMessageDialog(null, "Invalid input. Trip price could not be negative value.","WARNING",JOptionPane.WARNING_MESSAGE);
           jtfPrice2.setText("");    
           }
           /*else if(jtfPrice2.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Please enter the trip price.","WARNING",JOptionPane.WARNING_MESSAGE);
           }*/
           else if(countAlpha>0)
            {
                JOptionPane.showMessageDialog(null, "Alphabetic input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                jtfPrice2.setText("");    
            }
           else
           {
              
           if(jtfPrice2.getText().isEmpty() || Double.parseDouble(jtfPrice2.getText())==0 )
           {   
            tripControl.updateRecord(jtfTripNo2.getText(),0.0,'N',jcboBusList.getSelectedItem().toString());
            closeFrame();
            new TripMgmt(accType);
           }
            else
            {
            tripControl.updateRecord(jtfTripNo2.getText(),Double.parseDouble(jtfPrice2.getText()),'Y',jcboBusList.getSelectedItem().toString());
            String seatPrefix = "SA";
            String seatno="";
            int countSuccess=0;
            for(int i=1;i<=Integer.parseInt(jtfTotSeat.getText());i++)
            {
                seatno=seatPrefix+String.format("%02d",i );
                //System.out.println(seatno);
                countSuccess+= tripSeatControl.createRecord(jtfTripNo2.getText(),seatno ,'Y');
               
            } 
            if(countSuccess==Integer.parseInt(jtfTotSeat.getText()))
            {
                JOptionPane.showMessageDialog(null, countSuccess+" trip seats are successfully created.");
                closeFrame();
                new TripMgmt(accType);
            }
            }
            }
       }
       
       }
      
      public static void main(String[]args)
    {
        new UpdateTrip('U');
    }
}