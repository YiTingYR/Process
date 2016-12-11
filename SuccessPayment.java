package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;

public class SuccessPayment extends JFrame
{
     static int countTicket=0;
     static int countReceipt=0;
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background3.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
   ImageIcon iconHome=new ImageIcon(getClass().getResource("../images/homepageicon.png"));
     Font buttonFont=new Font("French Script MT",Font.PLAIN,45);
     Font buttonFont2=new Font("Century",Font.PLAIN,18);
     
     JPanel jp1=new JPanel(new GridLayout(3,1));
     JPanel jp3=new JPanel(new GridLayout(1,3));
 
     JLabel jlbSuccess=new JLabel("Your payment has been processed successfully");
     JLabel jlbTR=new JLabel("Continue printing Bus Ticket / Receipt");
     JButton jbtTicket=new JButton("Bus Ticket");
     JButton jbtReceipt=new JButton("Receipt");
     JButton jbtHome=new JButton("Main Menu",iconHome);
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
    
     public SuccessPayment(final char accType,final String orderid,final String paymentID)
    {
     this.accType=accType;  
     setLayout(new BorderLayout());
    
      jp1.setOpaque(false);
      jp1.add(jlbSuccess);
      jp1.add(jlbTR);
      jlbSuccess.setFont(buttonFont2);
     jlbSuccess.setHorizontalAlignment(SwingConstants.CENTER);
     
     jlbTR.setFont(buttonFont2);
     jlbTR.setHorizontalAlignment(SwingConstants.CENTER);
     
     jbtTicket.setPreferredSize(new Dimension(150, 38));
     jbtReceipt.setPreferredSize(new Dimension(150, 38));
     jbtHome.setPreferredSize(new Dimension(150, 38));
     subPanel_r1.add(jbtTicket);
     subPanel_r2.add(jbtReceipt);
     subPanel_r3.add(jbtHome);
     
     jbtTicket.setBackground(Color.WHITE);
     jbtReceipt.setBackground(Color.WHITE);
     jbtHome.setBackground(Color.WHITE);
     jbtTicket.setBorder(buttonBorder);
     jbtReceipt.setBorder(buttonBorder);
     jbtHome.setBorder(buttonBorder);
     jbtTicket.setFont(buttonFont2);
     jbtReceipt.setFont(buttonFont2);
     jbtHome.setFont(buttonFont2);
     jbtTicket.setMnemonic('B');
     jbtReceipt.setMnemonic('R');
     jbtHome.setMnemonic('M');
     
     jbtTicket.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e)
         {
             countTicket++;
             new BusTicket(orderid,paymentID);
         }
     });
      jbtReceipt.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e)
         {
             countReceipt++;
             new Receipt(orderid,paymentID);
         }
     });
     jbtHome.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e)
         {
           if(countReceipt==0)
           {
            JOptionPane.showMessageDialog(null, "Please print out the receipt.","WARNING",JOptionPane.WARNING_MESSAGE);
           }
           else if(countTicket==0)
           {
            JOptionPane.showMessageDialog(null, "Please print out the bus tickets.","WARNING",JOptionPane.WARNING_MESSAGE);
           }
           else{
             closeFrame();
             new homePage(accType);}
         }
     });
     
     jbtTicket.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtTicket.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtTicket.setBackground(Color.WHITE);
        
    }
});
     jbtReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtReceipt.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtReceipt.setBackground(Color.WHITE);
        
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
     
    
     jp3.add(subPanel_r1);
     jp3.add(subPanel_r2);
     jp3.add(subPanel_r3);
     jp1.add(jp3);
     subPanel_r1.setOpaque(false);
     subPanel_r2.setOpaque(false);
     subPanel_r3.setOpaque(false);
     jp3.setOpaque(false);
    
     jpanel.add(jp1,BorderLayout.NORTH);
     add(jpanel,BorderLayout.CENTER);
     
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Success Payment");
     pack();
     setSize(530,380);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
     
    }
     private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
         int confirm = JOptionPane.showConfirmDialog(null, "Confirm return to the Home Page?", "Confirm?", JOptionPane.WARNING_MESSAGE);
           if(confirm == JOptionPane.YES_OPTION){
          
           
           if(countReceipt==0)
           {
            JOptionPane.showMessageDialog(null, "Please print out the receipt.","WARNING",JOptionPane.WARNING_MESSAGE);
           }
           else if(countTicket==0)
           {
            JOptionPane.showMessageDialog(null, "Please print out the bus tickets.","WARNING",JOptionPane.WARNING_MESSAGE);
           }
           else
           {
           dispose();
           new homePage(accType);
           }
           }
        
        }
       
       }
      
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
       public void closeFrame() {
                this.dispose();
        }
      public static void main(String[]args)
    {
        new SuccessPayment('U',"","");
    }
}