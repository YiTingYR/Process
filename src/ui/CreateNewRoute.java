package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.sql.*;
import javax.swing.JPanel;  
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.lang.NumberFormatException;
import domain.Route;
import control.RouteControl;

public class CreateNewRoute extends JFrame
{
    private String host = "jdbc:derby://localhost:1527/ezwaydb";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private RouteControl routeControl;
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
     
     ImageIcon iconHome=new ImageIcon(getClass().getResource("../images/homepageicon.png"));
     
     Font buttonFont=new Font("French Script MT",Font.ITALIC,40);
     Font buttonFont2=new Font("Century",Font.ITALIC,18);
     Font buttonFont3=new Font("Century",Font.PLAIN,15);
     JLabel jroute=new JLabel("Route Management - Create New Route"); 
     JPanel jp2=new JPanel(new GridLayout(1,4));
     JPanel jp3=new JPanel(new GridLayout(4,2));
     JPanel jp4=new JPanel(new GridLayout(2,2));
     JPanel jp5=new JPanel(new GridLayout(5,2));
     JPanel jp6=new JPanel(new FlowLayout(FlowLayout.LEFT));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
   
    JButton jbtCreateRoute=new JButton("Create New Route");
    JButton jbtViewRoute=new JButton("View Route");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    JButton jbtClear=new JButton("Clear");
    JButton jbtCreate=new JButton("Create");
    
    JLabel jlbOneWay=new JLabel("One-Way Route");
    JLabel jlabel=new JLabel("");
    JLabel jlbRouteID=new JLabel("Route ID");
    JLabel jlbOrigin=new JLabel("Origin");
    JLabel jlbDestination=new JLabel("Destination");
    
    JLabel jlbTwoWay=new JLabel("Two-Way Route");
    JLabel jlabel2=new JLabel("");
    JLabel jlbRouteID2=new JLabel("Route ID");
    JLabel jlbOrigin2=new JLabel("Origin");
    JLabel jlbDestination2=new JLabel("Destination");
    JLabel jlabel3=new JLabel("");
   
    JTextField jtfRouteID=new JTextField("XXXX",18);
    JTextField jtfOrigin=new JTextField(18);
    JTextField jtfDestination=new JTextField(18);
    
    JTextField jtfRouteID2=new JTextField(18);
    JTextField jtfOrigin2=new JTextField(18);
    JTextField jtfDestination2=new JTextField(18);
    
    LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
    LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
    private char accType; 
     public CreateNewRoute(final char accType)
    {
     this.accType=accType;
      if(accType=='U')
     {
     jbtCreateRoute.setEnabled(false);
     
     }
     else
     {
     jbtCreateRoute.setEnabled(true);
     
     }  
     routeControl = new RouteControl();   
     setLayout(new BorderLayout());
     
     jroute.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jroute);
     jroute.setFont(buttonFont);
     
     jbtCreateRoute.setPreferredSize(new Dimension(200, 40));
     jbtViewRoute.setPreferredSize(new Dimension(200, 40));
     jbtMenu.setPreferredSize(new Dimension(200, 40));
     jbtHome.setPreferredSize(new Dimension(200, 40));
    
      jbtCreateRoute.setFont(buttonFont2);
      jbtViewRoute.setFont(buttonFont2);
      jbtMenu.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      
      jbtCreateRoute.setBackground(Color.WHITE);
      jbtViewRoute.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtClear.setBackground(Color.WHITE);
      jbtCreate.setBackground(Color.WHITE);
      
   
       jbtCreateRoute.setBorder(buttonBorder);
       jbtViewRoute.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtCreate.setBorder(buttonBorder2);
       jbtClear.setBorder(buttonBorder2);
       
       jbtCreate.setPreferredSize(new Dimension(100, 28));
       jbtClear.setPreferredSize(new Dimension(100, 28));
       
       jbtClear.setFont(buttonFont2);
       jbtCreate.setFont(buttonFont2);
     
      jbtCreateRoute.setMnemonic('C');
      jbtViewRoute.setMnemonic('V');
      jbtMenu.setMnemonic('B');
      jbtHome.setMnemonic('M');
      
       jbtCreateRoute.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCreateRoute.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCreateRoute.setBackground(Color.WHITE);
        
    }
});
       jbtViewRoute.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtViewRoute.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtViewRoute.setBackground(Color.WHITE);
        
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
         jbtClear.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtClear.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtClear.setBackground(Color.WHITE);
        
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
          jbtViewRoute.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new RouteMgmt(accType);
           }
       });
          jbtCreateRoute.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new CreateNewRoute(accType);
           }
       });
          jbtClear.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
              jtfRouteID.setText("");
              jtfRouteID2.setText("");
              jtfOrigin.setText("");
              jtfOrigin2.setText("");
              jtfDestination.setText("");
              jtfDestination2.setText("");
           }
       });
     
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      
      menuPanel_r1.add(jbtCreateRoute);
      menuPanel_r2.add(jbtViewRoute);
      menuPanel_r3.add(jbtMenu);
      menuPanel_r4.add(jbtHome);
 
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      
      jp3.setOpaque(false);
      jp3.add(jlbOneWay);
      jp3.add(jlabel);
      jp3.add(jlbRouteID);
      jp3.add(jtfRouteID);
      jp3.add(jlbOrigin);
      jp3.add(jtfOrigin);
      jp3.add(jlbDestination);
      jp3.add(jtfDestination);
      
      jp5.setOpaque(false);
      jp5.add(jlbTwoWay);
      jp5.add(jlabel2);
      jp5.add(jlbRouteID2);
      jp5.add(jtfRouteID2);
      jp5.add(jlbOrigin2);
      jp5.add(jtfOrigin2);
      jp5.add(jlbDestination2);
      jp5.add(jtfDestination2);
      
      jroute.setForeground(new Color(32, 178, 170));
      jlbOneWay.setForeground(new Color(32, 178, 170));
      jlbTwoWay.setForeground(new Color(32, 178, 170));
      
      jp6.add(jbtClear);
      jp6.add(jbtCreate);
      
      jbtCreate.addActionListener(new CreateListener());
      jbtClear.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
          {
               jtfRouteID.setText("");
               jtfRouteID.setForeground(Color.GRAY);
               jtfRouteID2.setText("");
               jtfOrigin.setText("");
               jtfDestination.setText("");
          }
      });
      
      jp6.setOpaque(false);
      jp5.add(jp6);
      jp5.add(jlabel3);
      
      jlbOneWay.setFont(buttonFont);
      jlbRouteID.setFont(buttonFont2);
      jlbOrigin.setFont(buttonFont2);
      jlbDestination.setFont(buttonFont2);
      
      jlbTwoWay.setFont(buttonFont);
      jlbRouteID2.setFont(buttonFont2);
      jlbOrigin2.setFont(buttonFont2);
      jlbDestination2.setFont(buttonFont2);
      
      jtfRouteID.setFont(buttonFont3);
      jtfRouteID2.setFont(buttonFont3);
      jtfOrigin.setFont(buttonFont3); 
      jtfOrigin2.setFont(buttonFont3);
      jtfDestination.setFont(buttonFont3);
      jtfDestination2.setFont(buttonFont3);
      
      jtfRouteID2.setEditable(false);
      jtfOrigin2.setEditable(false);
      jtfDestination2.setEditable(false);
      
      jtfRouteID.setForeground(Color.GRAY);
      jtfRouteID.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                jtfRouteID.setText("");
            }
            
        }); 
      
      
      jtfOrigin.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                DestDetails();
            }
            
            public void removeUpdate(DocumentEvent e){
                DestDetails();
            }
            
            public void insertUpdate(DocumentEvent e){
                DestDetails();
            }        
        });
      jtfDestination.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                OriDetails();
            }
            
            public void removeUpdate(DocumentEvent e){
                OriDetails();
            }
            
            public void insertUpdate(DocumentEvent e){
                OriDetails();
            }        
        });
      
      jtfRouteID.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                RouteIDDetails();
            }
            
            public void removeUpdate(DocumentEvent e){
                //RouteIDDetails();
            }
            
            public void insertUpdate(DocumentEvent e){
                RouteIDDetails();
            }        
        });

  jtfRouteID.addKeyListener(new KeyAdapter() {

  public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
  }
});
      subPanel_r1.add(jp3);
      subPanel_r3.add(jp5);
      jp4.add(subPanel_r1);
      jp4.add(subPanel_r2);
      jp4.add(subPanel_r3);
      jp4.add(subPanel_r4);
      
      subPanel_r1.setOpaque(false);
      subPanel_r2.setOpaque(false);
      subPanel_r3.setOpaque(false);
      subPanel_r4.setOpaque(false);
      jp4.setOpaque(false);
      
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp4,BorderLayout.WEST);
     add(jpanel,BorderLayout.CENTER);
     
     createConnection();
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Create New Route");
     setSize(1050,640);
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
     private void DestDetails(){
        if(!jtfOrigin.getText().equals("")){
            jtfDestination2.setText(jtfOrigin.getText());
        }else{
            jtfDestination2.setText("");
        }
    }
     private void OriDetails()
     {
         if(!jtfDestination.getText().equals("")){
            jtfOrigin2.setText(jtfDestination.getText());
        }else{
            jtfOrigin2.setText("");
        }
     }
     private void RouteIDDetails()
     {
         jtfRouteID.setBackground(new Color(255, 230, 230));
         if(!jtfRouteID.getText().equals(""))
         {
             String str="";
             str+=jtfRouteID.getText();
             try
             {
                 int num=Integer.parseInt(str);
                  JOptionPane.showMessageDialog(null, "Numeric input is invalid. Please reenter. "
                            + "\n(Example: KLAS)","WARNING",JOptionPane.WARNING_MESSAGE);
                  //jtfRouteID.setText("");
                  jtfRouteID2.setText("");
             
             }catch(NumberFormatException ex)
             {
             if(str.length()==4)
             {
                 String substr1=str.substring(0,2);
                 String substr2=str.substring(2,str.length());
                
                 if(substr1.equals(substr2))
                 {
                    JOptionPane.showMessageDialog(null, "The route ID entered is inappropriate. Please reenter. "
                            + "\n(Example: KLAS)","WARNING",JOptionPane.WARNING_MESSAGE);
                    this.addWindowListener( new WindowAdapter() {
                    public void windowOpened( WindowEvent e ){ 
                    jtfRouteID.setText("");
                    jtfRouteID.repaint();
                    jtfRouteID.revalidate();
                    jtfRouteID.requestFocus();
                    jtfRouteID.grabFocus(); 
                   
                    }
                    });
                 }
                 else
                 { 
                int counterDigit=0;
                for (int i = 0; i < jtfRouteID.getText().length(); i++) {
                char ch = jtfRouteID.getText().charAt(i);
               
                if (Character.isDigit(ch)) {
                    counterDigit++;}
                
                }
                if(counterDigit>0){
                JOptionPane.showMessageDialog(null, "Numeric input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                
                }
                else
                {
                 String twoWayID=substr2+substr1;
                 jtfRouteID2.setText(twoWayID.toUpperCase());
                 jtfRouteID.setBackground(new Color(240, 255, 240));
                }
                  
                 }
             }
              else if(str.length()>4)
             {
                     jtfRouteID2.setText("");
                     JOptionPane.showMessageDialog(null, "Maximum 4 characters for RouteID. Please reenter. "
                            + "\n(Example: KLAS)","WARNING",JOptionPane.WARNING_MESSAGE);
                       
             }
             }
           
         }
     }
     
     private class CreateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            boolean value=ValidateCreate();
            if(value)
            {
            Route route = routeControl.selectRecord(jtfRouteID.getText());
            if (route!= null) {
            JOptionPane.showMessageDialog(null, "The route ID already exists in database.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
            jtfRouteID.setText("");
            jtfRouteID2.setText("");
            }
            else
            {
                routeControl.createRecord(jtfRouteID.getText(),jtfOrigin.getText(),jtfDestination.getText(),
                jtfRouteID2.getText(),jtfOrigin2.getText(),jtfDestination2.getText());
                 closeFrame();
                 new RouteMgmt(accType);
            }
            }
            
        }
    }
      private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
      public void closeFrame() {
                this.dispose();
        }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      public static void main(String[]args)
    {
        new CreateNewRoute('U');
    }
      public boolean ValidateCreate(){
            int counter=0;
            try
            {
                
                String str=jtfRouteID.getText();
                int num=Integer.parseInt(str);
              
                JOptionPane.showMessageDialog(null, "Numeric input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                return false;
            
            }catch(NumberFormatException ex)
            {
                counter++;
                System.out.println(counter);
            if(jtfRouteID.getText().isEmpty())
            {
             JOptionPane.showMessageDialog(null, "Empty string for route ID is detected.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
             return false;
            }
            else if(jtfRouteID.getText().compareTo("XXXX")==0)
            {
                 JOptionPane.showMessageDialog(null, "The route ID entered is inappropriate. Please reenter. "
                            + "\n(Example: KLAS)","WARNING",JOptionPane.WARNING_MESSAGE);
                 jtfRouteID.setText("");
                 return false;
            }
            else if(jtfRouteID.getText().length()>4 || jtfRouteID.getText().length()<4 )
            {
                jtfRouteID2.setText("");
                JOptionPane.showMessageDialog(null, " 4 characters for RouteID. Please reenter. "
                            + "\n(Example: KLAS)","WARNING",JOptionPane.WARNING_MESSAGE);
                jtfRouteID.setText("");
                return false;
            }
            else if(jtfRouteID.getText().substring(0, 2).compareTo(jtfRouteID.getText().substring(2,jtfRouteID.getText().length()))==0)
            {
                 JOptionPane.showMessageDialog(null, "The route ID entered is inappropriate. Please reenter. "
                            + "\n(Example: KLAS)","WARNING",JOptionPane.WARNING_MESSAGE);
                 jtfRouteID.setText("");
                 return false;
            }
            else if(jtfOrigin.getText().isEmpty() || jtfDestination.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Empty string for origin or destination is detected.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                return false;
            }
            else if(jtfOrigin.getText().compareTo(jtfDestination.getText())==0)
            {
                JOptionPane.showMessageDialog(null, "Origin and Destination could not be the same.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                jtfOrigin.setText("");
                jtfDestination.setText("");
                jtfOrigin2.setText("");
                jtfDestination2.setText("");
                return false;
            }
            int countDigit=0;
            for (int i = 0; i < jtfRouteID.getText().length(); i++) {
                char ch = jtfRouteID.getText().charAt(i);
                if (Character.isDigit(ch)) {
                    countDigit++;
                }
                
            }
            if(countDigit>0)
            {
                 JOptionPane.showMessageDialog(null, "Numeric input is invalid for routeID.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                 return false;
                    
            }
            
            
            }
           
            return true;
      }
}