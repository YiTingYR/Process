package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.*;
import da.BusTable;
import da.BusDA;
import domain.Bus;
import control.BusControl;
import java.util.ArrayList;

public class CreateNewBus extends JFrame
{
  
    BusDA b=new BusDA();
    BusControl busControl;
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
     
     JLabel jbus=new JLabel("Bus Information Management - Create New Bus"); 
     JLabel jlbBus=new JLabel("New Bus Details");
     JLabel jlbBlank=new JLabel("");
     
     JLabel jlbBusID=new JLabel("Bus ID");
     JLabel jlbPlateNo=new JLabel("Bus Plate Number");
     JLabel jlbType=new JLabel("Bus Type");
     
     JTextField jtfBusID=new JTextField(15);
     JTextField jtfPlateNo=new JTextField(15);
     //JTextField jtfType=new JTextField(15);
     
     JPanel jp2=new JPanel(new GridLayout(1,4));
     JPanel jp3=new JPanel(new GridLayout(5,2));
     JPanel jp4=new JPanel(new GridLayout(1,2));
     JPanel jp5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
    JButton jbtCreateBus=new JButton("Create New Bus");
    JButton jbtViewBus=new JButton("View Bus");
    JButton jbtMenu=new JButton("Back");
    JButton jbtHome=new JButton("Main Menu",iconHome);
    
    JButton jbtClear=new JButton("Clear");
    JButton jbtCreate=new JButton("Create");
    
    LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
    LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
     
    private DefaultComboBoxModel dcbomTypeList= new DefaultComboBoxModel();
    private JComboBox jcboTypeList = new JComboBox(dcbomTypeList);
    private ArrayList<String> typeList=new ArrayList<String>();
    private char accType; 
    
     public CreateNewBus(final char accType)
    {
        this.accType=accType;
         if(accType=='U')
     {
     jbtCreateBus.setEnabled(false);
     
     }
     else
     {
     jbtCreateBus.setEnabled(true);
     
     }  
     busControl=new BusControl();   
     setLayout(new BorderLayout());
     
     jbus.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jbus);
     jbus.setFont(buttonFont);
     jbus.setForeground(new Color(32, 178, 170));
     jlbBus.setFont(buttonFont);
     jlbBus.setForeground(new Color(32, 178, 170));
     
     jbtCreateBus.setPreferredSize(new Dimension(200, 40));
     jbtViewBus.setPreferredSize(new Dimension(200, 40));
     jbtMenu.setPreferredSize(new Dimension(200, 40));
     jbtHome.setPreferredSize(new Dimension(200, 40));
    
      jbtCreateBus.setFont(buttonFont2);
      jbtViewBus.setFont(buttonFont2);
      jbtMenu.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      
      jbtCreateBus.setBackground(Color.WHITE);
      jbtViewBus.setBackground(Color.WHITE);
      jbtMenu.setBackground(Color.WHITE);
      jbtHome.setBackground(Color.WHITE);
      jbtClear.setBackground(Color.WHITE);
      jbtCreate.setBackground(Color.WHITE);
      
   
       jbtCreateBus.setBorder(buttonBorder);
       jbtViewBus.setBorder(buttonBorder);
       jbtMenu.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtCreate.setBorder(buttonBorder2);
       jbtClear.setBorder(buttonBorder2);
       
       jbtCreate.setPreferredSize(new Dimension(100, 28));
       jbtClear.setPreferredSize(new Dimension(100, 28));
       
       jbtClear.setFont(buttonFont2);
       jbtCreate.setFont(buttonFont2);
     
      jbtCreateBus.setMnemonic('C');
      jbtViewBus.setMnemonic('V');
      jbtMenu.setMnemonic('B');
      jbtHome.setMnemonic('M');
      
       jbtCreateBus.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCreateBus.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCreateBus.setBackground(Color.WHITE);
        
    }
});
       jbtViewBus.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtViewBus.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtViewBus.setBackground(Color.WHITE);
        
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
          jbtViewBus.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new BusMgmt(accType);
           }
       });
          jbtCreateBus.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new CreateNewBus(accType);
           }
       });
          
          jbtClear.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
              jtfPlateNo.setText("");
              jcboTypeList.setSelectedIndex(0);
              //jtfType.setText("");
           }
       });
          
      jbtCreate.addActionListener(new CreateListener());
       
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
     
      menuPanel_r1.add(jbtCreateBus);
      menuPanel_r2.add(jbtViewBus);
      menuPanel_r3.add(jbtMenu);
      menuPanel_r4.add(jbtHome);
 
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      
      jp3.setOpaque(false);
      jp3.add(jlbBus);
      jp3.add(jlbBlank);
      jp3.add(jlbBusID);
      jp3.add(jtfBusID);
      jp3.add(jlbPlateNo);
      jp3.add(jtfPlateNo);
      jp3.add(jlbType);
      
      typeList.add("Single Deck");
      typeList.add("Double Deck");
     for(int i=0; i<typeList.size(); i++){
            dcbomTypeList.addElement(typeList.get(i));
        }
      jp3.add(jcboTypeList);
      jcboTypeList.setFont(buttonFont2);
      
      jtfPlateNo.setForeground(Color.GRAY);
      jtfPlateNo.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                jtfPlateNo.setText("");
            }
            
        });
      jtfPlateNo.addKeyListener(new KeyAdapter() {

    public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
    }
    });
      
    /*jtfType.addKeyListener(new KeyAdapter() {

    public void keyTyped(KeyEvent e) {
    char keyChar = e.getKeyChar();
    if (Character.isLowerCase(keyChar)) {
      e.setKeyChar(Character.toUpperCase(keyChar));
    }
    }
    });*/
       
      jtfPlateNo.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                ValidatePN();
            }
            
            public void removeUpdate(DocumentEvent e){
                ValidatePN();
            }
            
            public void insertUpdate(DocumentEvent e){
                ValidatePN();
            }        
        });
      /*jtfType.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                ValidateType();
            }
            
            public void removeUpdate(DocumentEvent e){
                ValidateType();
            }
            
            public void insertUpdate(DocumentEvent e){
                ValidateType();
                
            }        
        });*/
      
      jp5.setOpaque(false);
      jp5.add(jbtClear);
      jp5.add(jbtCreate);
      
      jp3.add(jp5);
      
      jtfBusID.setEditable(false);
      
      jtfBusID.setText(automatedCode());
              
      jlbBusID.setFont(buttonFont2);
      jtfBusID.setFont(buttonFont2);
      jlbPlateNo.setFont(buttonFont2);
      jtfPlateNo.setFont(buttonFont2);
      jlbType.setFont(buttonFont2);
      //jtfType.setFont(buttonFont2);
   
      subPanel_r1.add(jp3);
      jp4.add(subPanel_r1);
      jp4.add(subPanel_r2);
     
      subPanel_r1.setOpaque(false);
      subPanel_r2.setOpaque(false);
      jp4.setOpaque(false);
      
     jpanel.add(jp2,BorderLayout.NORTH);
     jpanel.add(jp4,BorderLayout.WEST);
     add(jpanel,BorderLayout.CENTER);

     setIcon();
     addWindowListener(new WindowListener());
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setTitle("Create New Bus");
     setSize(1050,640);
     setVisible(true);
     //setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     
      //createConnection();
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
      public String automatedCode()
      {
         String automatedCode="";
         automatedCode=b.displayAutomatedCode();
         return automatedCode;
      }
      
      private class CreateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
         boolean value=ValidateCreate();
         if(value)
         {
             Bus bus=busControl.selectPN(jtfPlateNo.getText());
             if(bus!=null)
             {
            JOptionPane.showMessageDialog(null, "The plate number already exists in database.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
            jtfPlateNo.setText("");
           
             }
             else
             {
                 String type="";
                 int index=jcboTypeList.getSelectedIndex();
                 if(index==0)
                 {
                     type="S";
                 }
                 else
                 {
                     type="D";
                 }
                 busControl.createRecord(jtfBusID.getText(), jtfPlateNo.getText(), type);
                 closeFrame();
                 new BusMgmt(accType);
             }
         }
        }
      }
     
      private void ValidatePN()
      {
          jtfPlateNo.setBackground(new Color(255, 230, 230));
          String str=jtfPlateNo.getText();
          if(str.length()==7)
          {
              int countAlpha=0;
              int countDigit=0;
              for(int i=0;i<str.length();i++)
              {
                  char ch=str.charAt(i);
                  if(Character.isAlphabetic(ch))
                  {
                      countAlpha++;
                  }else if(Character.isDigit(ch))
                  {
                      countDigit++;
                  }
              }
              if(countAlpha==0 || countDigit==0)
              {
                  JOptionPane.showMessageDialog(null, "The plate number must consists of alphabet and digit numbers.Please reenter","WARNING",JOptionPane.WARNING_MESSAGE);
              }else
              {
              jtfPlateNo.setBackground(new Color(240, 255, 240));
              }
              /*String subStr1=jtfPlateNo.getText().substring(0, 3);
              String subStr2=jtfPlateNo.getText().substring(3, str.length());
              int countAlpha=0;
              int countDigit=0;
              
              for (int i = 0; i < subStr1.length(); i++) {
                char ch = subStr1.charAt(i);
                if (Character.isLetter(ch)) {
                    countAlpha++;
                }
              }
              
              if(countAlpha==3)
              {
                for (int i = 0; i < subStr2.length(); i++) {
                char ch2 = subStr2.charAt(i);
                if (Character.isDigit(ch2)) {
                    countDigit++;
                }
              }
                if(countDigit==4)
                {
                    jtfPlateNo.setBackground(new Color(240, 255, 240));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid input.\nPlease reenter in format XXX9999.","WARNING",JOptionPane.WARNING_MESSAGE);
                }
              }
              else
              { 
                  JOptionPane.showMessageDialog(null, "Invalid input.\nPlease reenter in format XXX9999.","WARNING",JOptionPane.WARNING_MESSAGE);
              }*/
              //System.out.print(subStr1);
              //System.out.print(subStr2);
              
          }
          else if(str.length()>7)
          {
              JOptionPane.showMessageDialog(null, "Invalid input.Maximum 7 characters required.\nPlease reenter in format XXX9999.","WARNING",JOptionPane.WARNING_MESSAGE);
          }
          
      }
     /* private void ValidateType()
      {
          jtfType.setBackground(new Color(255, 230, 230));
          if(jtfType.getText().length()==1)
          {
          if(jtfType.getText().compareTo("S")==0 ||jtfType.getText().compareTo("D")==0)
          {
              jtfType.setBackground(new Color(240, 255, 240));
          }
          else
          {
               JOptionPane.showMessageDialog(null, "Invalid input.\nPlease reenter 'S' or 'D' only.","WARNING",JOptionPane.WARNING_MESSAGE);
          }
          }
          else if(jtfType.getText().length()>1)
          {
               JOptionPane.showMessageDialog(null, "Invalid input.Maximum 1 character required.\nPlease reenter 'S' or 'D' only.","WARNING",JOptionPane.WARNING_MESSAGE);
          }
          
          
      }*/
       public boolean ValidateCreate()
       {
           if(jtfPlateNo.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null, "Emptry string detected for plate number.\nPlease reenter in format XXX9999.","WARNING",JOptionPane.WARNING_MESSAGE);
               return false;
           }
          
           else if(jtfPlateNo.getText().length()!=7)
           {
               JOptionPane.showMessageDialog(null, "Invalid input.\nPlease reenter in format XXX9999.","WARNING",JOptionPane.WARNING_MESSAGE);
               jtfPlateNo.setText("");
               return false;
           }
           
           //String subStr1=jtfPlateNo.getText().substring(0, 3);
           //String subStr2=jtfPlateNo.getText().substring(3, jtfPlateNo.getText().length());
              int countAlpha=0;
              int countDigit=0;
              for(int i=0;i<jtfPlateNo.getText().length();i++)
              {
                  char ch=jtfPlateNo.getText().charAt(i);
                  if(Character.isAlphabetic(ch))
                  {
                      countAlpha++;
                  }else if(Character.isDigit(ch))
                  {
                      countDigit++;
                  }
              }
              if(countAlpha==0 || countDigit==0)
              {
                  JOptionPane.showMessageDialog(null, "The plate number must consists of alphabet and digit numbers.Please reenter","WARNING",JOptionPane.WARNING_MESSAGE);
                  jtfPlateNo.setText("");
                  return false;
              }
              
             /* for (int i = 0; i < subStr1.length(); i++) {
                char ch = subStr1.charAt(i);
                if (Character.isLetter(ch)) {
                    countAlpha++;
                }
              }
              
              if(countAlpha==3)
              {
                for (int i = 0; i < subStr2.length(); i++) {
                char ch2 = subStr2.charAt(i);
                if (Character.isDigit(ch2)) {
                    countDigit++;
                }
              }
                if(countDigit!=4)
                {
                    return false;
                }
              }
              else
              { 
                  return false;
              }*/
           return true;
       }
      public static void main(String[]args)
    {
        new CreateNewBus('U');
    }
      
}