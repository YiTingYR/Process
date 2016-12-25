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
import da.RouteTable;
import da.RouteDA;
import control.RouteControl;
import domain.Route;

public class RouteMgmt extends JFrame
{
    private RouteControl routeControl;
    private RouteTable tableModel;
    private JTable productTable;
     
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
     JLabel jroute=new JLabel("Route Management"); 
     JPanel jp2=new JPanel(new GridLayout(1,4));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new GridLayout(1,2));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.LEFT));
     
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));

    JButton jbtCreateRoute=new JButton("Create New Route");
    JButton jbtViewRoute=new JButton("View Route Table");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    
    JTextField jtfSearch=new JTextField("Search your route here",40);
    JButton jbtSearch=new JButton("Search");
    JButton jbtViewAll=new JButton("View All");
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
     public RouteMgmt(final char accType)
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
     jbtSearch.setPreferredSize(new Dimension(100, 28));
     jbtViewAll.setPreferredSize(new Dimension(100, 28));
     
      jbtCreateRoute.setFont(buttonFont2);
      jbtViewRoute.setFont(buttonFont2);
      jbtMenu.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      jbtSearch.setFont(buttonFont2);
      jbtViewAll.setFont(buttonFont2);
      //jtfSearch.setFont(buttonFont2);
      
      jbtCreateRoute.setBackground(Color.WHITE);
      jbtViewRoute.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtSearch.setBackground(Color.WHITE);
      jbtViewAll.setBackground(Color.WHITE);
      
       jbtCreateRoute.setBorder(buttonBorder);
       jbtViewRoute.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtSearch.setBorder(buttonBorder2);
       jbtViewAll.setBorder(buttonBorder2);
      
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
          jbtCreateRoute.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new CreateNewRoute(accType);
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
                jtfSearch.setText("Search your route here");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
      
      jpanel.addMouseListener(new MouseAdapter()
       {
            public void mouseClicked(MouseEvent e)
            {
                jtfSearch.setText("Search your route here");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
  
      menuPanel_r1.add(jbtCreateRoute);
      menuPanel_r2.add(jbtViewRoute);
      menuPanel_r3.add(jbtMenu);
      menuPanel_r4.add(jbtHome);
      
      subPanel_r1.add(jtfSearch);
      subPanel_r2.add(jbtSearch);
      subPanel_r2.add(jbtViewAll);
      
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      
      jp3.setOpaque(false);
      jp3.add(subPanel_r1);
      jp3.add(subPanel_r2);
      
      tableModel=new RouteTable();
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
      subPanel_r3.add(pane);
      subPanel_r3.setOpaque(false);
      pane.getViewport().setBackground(new Color(255,255,255));
      
      jp4.add(subPanel_r3);
      jp4.add(subPanel_r4);
      subPanel_r4.setOpaque(false);
     jp4.setOpaque(false);
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp3,BorderLayout.CENTER);
     jpanel.add(jp4,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Route Management");
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
     private class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
        if(jtfSearch.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter route information to search.","WARNING",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
            Route route = routeControl.selectRecord(jtfSearch.getText().toUpperCase());
            if (route!= null) {
            tableModel.retrieveRecordsByCode(jtfSearch.getText());
            }
            else
            {
                tableModel.retrieveRecordsByString(jtfSearch.getText().toLowerCase());
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
      public void refreshTable()
      {
      subPanel_r3.removeAll();
      tableModel=new RouteTable();
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
      subPanel_r3.add(pane);
      subPanel_r3.setOpaque(false);
      pane.getViewport().setBackground(new Color(255,255,255));
      subPanel_r3.revalidate();
      subPanel_r3.repaint();
      jp4.add(subPanel_r3);
      jp4.add(subPanel_r4);
     
      }
      public static void main(String[]args)
    {
        new RouteMgmt('U');
    }
}