package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;

public class ScheduleMenu extends JFrame
{
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/homePageBackground.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
     ImageIcon iconLogo=new ImageIcon(getClass().getResource("../images/ezWayLogo.jpg"));
     ImageIcon iconHome=new ImageIcon(getClass().getResource("../images/homepageicon.png"));

     Font buttonFont=new Font("French Script MT",Font.ITALIC,45);
     Font buttonFont2=new Font("Century",Font.ITALIC,18);
     JLabel jlogo=new JLabel(iconLogo);
     JLabel jschedule=new JLabel("Seat and Scheduling Management"); 
     JPanel jp2=new JPanel(new GridLayout(5,1));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton jbtTrip=new JButton("Trip Management");
    JButton jbtRoute=new JButton("Route Management");
    JButton jbtDriver=new JButton("Driver Schedule Management"); 
    JButton jbtBus=new JButton("Bus Information Management");
    JButton jbtHome=new JButton("Back",iconHome);
  
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
     private char accType;
     public ScheduleMenu(final char accType)
    {
     this.accType=accType;    
     setLayout(new BorderLayout());
     
     jlogo.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jlogo);
     jpanel.add(jschedule);
     jschedule.setFont(buttonFont);
      
     jbtTrip.setPreferredSize(new Dimension(300, 50));
     jbtRoute.setPreferredSize(new Dimension(300, 50));
     jbtDriver.setPreferredSize(new Dimension(300, 50));
     jbtHome.setPreferredSize(new Dimension(300, 50));
     jbtBus.setPreferredSize(new Dimension(300, 50));
    
      jbtTrip.setFont(buttonFont2);
      jbtRoute.setFont(buttonFont2);
      jbtDriver.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      jbtBus.setFont(buttonFont2);
     
       jbtTrip.setBackground(Color.WHITE);
       jbtRoute.setBackground(Color.WHITE);
       jbtDriver.setBackground(Color.WHITE);
       jbtHome.setBackground(Color.WHITE);
       jbtBus.setBackground(Color.WHITE);
       
       jbtTrip.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtTrip.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtTrip.setBackground(Color.WHITE);
        
    }
});
        jbtRoute.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtRoute.setBackground(new Color(230, 230, 230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtRoute.setBackground(Color.WHITE);
        
    }
});
         jbtDriver.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtDriver.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtDriver.setBackground(Color.WHITE);
        
    }
});
       jbtBus.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtBus.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtBus.setBackground(Color.WHITE);
        
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
        jbtHome.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new homePage(accType);
           }
       });
        
        jbtRoute.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new RouteMgmt(accType);
           }
       });
        
        jbtBus.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               //new BusMgmt(accType);
           }
       });
        
        jbtTrip.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new TripMgmt(accType);
           }
       });
        jbtDriver.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new DriverMgmt(accType);
           }
       });
       
       jbtTrip.setBorder(buttonBorder);
       jbtDriver.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtRoute.setBorder(buttonBorder2);
       jbtBus.setBorder(buttonBorder2);
      
      jbtTrip.setMnemonic('T');
      jbtRoute.setMnemonic('R');
      jbtDriver.setMnemonic('D');
      jbtHome.setMnemonic('H');
      jbtBus.setMnemonic('B');
     
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
     
      menuPanel_r1.add(jbtTrip);
      menuPanel_r2.add(jbtRoute);
      menuPanel_r3.add(jbtDriver);
      menuPanel_r4.add(jbtBus); 
      menuPanel_r5.add(jbtHome);
     
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
       
     jpanel.add(jp2,BorderLayout.CENTER);
     add(jpanel,BorderLayout.CENTER);
     
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Schedule Menu");
     setSize(850,600);
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
      public static void main(String[]args)
    {
        new ScheduleMenu('U');
    }
}