package ui; //Author:Teh Yi Ting
import da.OrderDetailForPaymentDA;
import da.OrderForPaymentDA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import javax.swing.JPanel;  
import javax.swing.border.*;

public class PaymentMethod extends JFrame
{
    OrderForPaymentDA paymentDA;
    OrderDetailForPaymentDA detailPaymentDA;
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background3.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
   
     Font buttonFont=new Font("French Script MT",Font.PLAIN,45);
     Font buttonFont2=new Font("Century",Font.PLAIN,18);
     
     JPanel jp1=new JPanel(new GridLayout(2,1));
     JPanel jp3=new JPanel(new GridLayout(1,2));
 
     JLabel jlbMethod=new JLabel("Payment Method");
     JButton jbtCash=new JButton("Cash");
     JButton jbtCreditCard=new JButton("Credit Card");
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
     public String cookieOrderID="";
     private char accType;
     public PaymentMethod(final char accType,final String orderid,final double TotAmount)
    {
      this.accType=accType;       
     cookieOrderID=orderid; 
     paymentDA=new OrderForPaymentDA();
     detailPaymentDA=new OrderDetailForPaymentDA();
     setLayout(new BorderLayout());
    
      jp1.setOpaque(false);
      jp1.add(jlbMethod);
      jlbMethod.setFont(buttonFont);
     jlbMethod.setHorizontalAlignment(SwingConstants.CENTER);
     
     jbtCash.setPreferredSize(new Dimension(150, 38));
     jbtCreditCard.setPreferredSize(new Dimension(150, 38));
     subPanel_r1.add(jbtCash);
     subPanel_r2.add(jbtCreditCard);
     
     jbtCash.setBackground(Color.WHITE);
     jbtCreditCard.setBackground(Color.WHITE);
     jbtCash.setBorder(buttonBorder);
     jbtCreditCard.setBorder(buttonBorder);
     jbtCash.setFont(buttonFont2);
     jbtCreditCard.setFont(buttonFont2);
     jbtCash.setMnemonic('C');
     jbtCreditCard.setMnemonic('R');
     
     jbtCash.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCash.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCash.setBackground(Color.WHITE);
        
    }
});
     jbtCreditCard.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtCreditCard.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtCreditCard.setBackground(Color.WHITE);
        
    }
});
     
     jbtCreditCard.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new CreditCardPayment(accType,orderid,TotAmount);
           }
       });
     
     jbtCash.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new CashPayment(accType,orderid,TotAmount);
           }
       });
     
     
     jp3.add(subPanel_r1);
     jp3.add(subPanel_r2);
     jp1.add(jp3);
     subPanel_r1.setOpaque(false);
     subPanel_r2.setOpaque(false);
     jp3.setOpaque(false);
    
     jpanel.add(jp1,BorderLayout.NORTH);
     add(jpanel,BorderLayout.CENTER);
     
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Payment Method");
     pack();
     setSize(430,300);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
     
    }
      
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
       public void closeFrame() {
                this.dispose();
        }
       private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
           int confirm = JOptionPane.showConfirmDialog(null, "The current order will be deleted. Confirm return to the Home Page? ", "Confirm?", JOptionPane.WARNING_MESSAGE);
           if(confirm == JOptionPane.YES_OPTION){
               //String orderid=jtfOrderID.getText();
                detailPaymentDA.deleteOrderDetailRecord(cookieOrderID);
                paymentDA.deleteRecord(cookieOrderID);
                closeFrame();
                new homePage(accType);
           
           }
         
        }
        }
      public static void main(String[]args)
    {
        //new PaymentMethod("",0.0);
        
    }
}