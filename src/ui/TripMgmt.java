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
import da.TripTable;


public class TripMgmt extends JFrame
{
    private TripTable tableModel;
    private JTable productTable;
    //private char accType;
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
     JLabel jtrip=new JLabel("Trip Management"); 
     JPanel jp2=new JPanel(new GridLayout(1,6));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new FlowLayout());
     
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
    
    JTextField jtfSearch=new JTextField("Please enter routeID to search",40);
    JButton jbtSearch=new JButton("Search");
    JButton jbtViewAll=new JButton("View All");
    
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
    
     public TripMgmt(final char accType)
    {
     this.accType=accType;       
     setLayout(new BorderLayout());
     
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
     jbtViewAll.setPreferredSize(new Dimension(100, 28));
     
      jbtCreateTrip.setFont(buttonFont2);
      jbtViewTrip.setFont(buttonFont2);
      jbtRetrieveTrip.setFont(buttonFont2);
      jbtUpdateTrip.setFont(buttonFont2);
      jbtMenu.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      jbtSearch.setFont(buttonFont2);
      jbtViewAll.setFont(buttonFont2);
      //jtfSearch.setFont(buttonFont2);
      
      jbtCreateTrip.setBackground(Color.WHITE);
      jbtViewTrip.setBackground(Color.WHITE);
      jbtRetrieveTrip.setBackground(Color.WHITE);
      jbtUpdateTrip.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtSearch.setBackground(Color.WHITE);
      jbtViewAll.setBackground(Color.WHITE);
      
       jbtCreateTrip.setBorder(buttonBorder);
       jbtViewTrip.setBorder(buttonBorder);
       jbtRetrieveTrip.setBorder(buttonBorder);
       jbtUpdateTrip.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtSearch.setBorder(buttonBorder2);
       jbtViewAll.setBorder(buttonBorder2);
      
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
      menuPanel_r6.setOpaque(false);
      
      subPanel_r1.setOpaque(false);
      subPanel_r2.setOpaque(false);
      
  jtfSearch.addKeyListener(new KeyAdapter() {

  public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
  }
});
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
                jtfSearch.setText("Please enter routeID to search");
                jtfSearch.setForeground(Color.GRAY);
            }
       });
      
      jpanel.addMouseListener(new MouseAdapter()
       {
            public void mouseClicked(MouseEvent e)
            {
                jtfSearch.setText("Please enter routeID to search");
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
      subPanel_r2.add(jbtViewAll);
      
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
      
      tableModel=new TripTable();
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
      pane.getViewport().setBackground(new Color(255,255,255));
      pane.setPreferredSize(new Dimension(1050,250));
    
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp3,BorderLayout.CENTER);
     jpanel.add(pane,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
   
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Trip Management");
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
      private class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             if(jtfSearch.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter routeID to search.","WARNING",JOptionPane.WARNING_MESSAGE);
            }
             else
            {
                  tableModel.retrieveRecordsByCode(jtfSearch.getText());
            }
             
        }
        }
      public void refreshTable()
      {
      jpanel.removeAll();
      tableModel=new TripTable();
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
      pane.getViewport().setBackground(new Color(255,255,255));
      pane.setPreferredSize(new Dimension(1050,250));
    
      jtrip.setHorizontalAlignment(SwingConstants.CENTER);
      jpanel.add(jtrip);
      jtrip.setFont(buttonFont);
      jpanel.add(jp2,BorderLayout.NORTH);
      jpanel.add(jp3,BorderLayout.CENTER);
      jpanel.add(pane,BorderLayout.SOUTH);
      this.add(jpanel,BorderLayout.CENTER);
      
      jpanel.revalidate();
      jpanel.repaint();
      }
      public void closeFrame() {
                this.dispose();
        }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      public static void main(String[]args)
    {
        new TripMgmt('U');
    }
}