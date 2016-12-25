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
import control.PaymentControl;
import da.PaymentDA;
import domain.OrderDetailForPayment;
import domain.PaymentIDGenerator;
import java.util.ArrayList;
import control.TripSeatControlForSchedule;
import control.TripControl;
import da.OrderDetailForPaymentDA;
import da.OrderForPaymentDA;

public class CreditCardPayment extends JFrame
{
    PaymentControl payControl;
    OrderForPaymentDA paymentDA;
    OrderDetailForPaymentDA detailPaymentDA;
    PaymentIDGenerator randomID;
    ArrayList<OrderDetailForPayment> orderList = new ArrayList<OrderDetailForPayment>();
    TripSeatControlForSchedule seatControl;
    TripControl tripControl;
    public String cookieOrderID="";
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
     JPanel jp3=new JPanel(new GridLayout(5,2));
 
     JLabel jlbMethod=new JLabel("Credit Card Payment");
     JLabel jlbOrderID=new JLabel("Order ID");
     JLabel jlbTotalAmount=new JLabel("Total Amount (RM)");
     JLabel jlbCardNo=new JLabel("Card Serial Number");
     
     JTextField jtfOrderID=new JTextField(15);
     JTextField jtfTotalAmount=new JTextField(15);
     JTextField jtfCardNo=new JTextField(15);
     
     JButton jbtPay=new JButton("Pay");
     JButton jbtClear=new JButton("Clear");
    
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
    
     public CreditCardPayment(final char accType,final String orderid,final double totAmount)
    {
     this.accType=accType;     
     cookieOrderID=orderid; 
     paymentDA=new OrderForPaymentDA();
     detailPaymentDA=new OrderDetailForPaymentDA();
     
     payControl=new PaymentControl();
     seatControl=new TripSeatControlForSchedule();
     tripControl=new TripControl();
     setLayout(new BorderLayout());
    
      jp1.setOpaque(false);
      //jp1.add(jlbMethod);
      jlbMethod.setFont(buttonFont);
     jlbMethod.setHorizontalAlignment(SwingConstants.CENTER);
    
     jp3.add(jlbOrderID);
     jp3.add(jtfOrderID);
     jp3.add(jlbTotalAmount);
     jp3.add(jtfTotalAmount);
     
     jtfOrderID.setText(orderid);
     jtfTotalAmount.setText(String.format("%.2f",totAmount));
     
     jp3.add(jlbCardNo);
     jp3.add(jtfCardNo);
     
     jtfCardNo.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                ValidateCardNo();
            }
            
            public void removeUpdate(DocumentEvent e){
                //ValidateCardNo();
            }
            
            public void insertUpdate(DocumentEvent e){
                ValidateCardNo();
            }        
        });  
     
     subPanel_r3.setOpaque(false);
     subPanel_r4.setOpaque(false);
     jp3.add(subPanel_r3);
     subPanel_r4.add(jbtPay);
     subPanel_r4.add(jbtClear);
     jp3.add(subPanel_r4);
     jp3.add(subPanel_r1);
     jp3.add(subPanel_r2);
     
     jlbOrderID.setFont(buttonFont2);
     jtfOrderID.setFont(buttonFont2);
     jlbTotalAmount.setFont(buttonFont2);
     jtfTotalAmount.setFont(buttonFont2);
     jlbCardNo.setFont(buttonFont2);
     jtfCardNo.setFont(buttonFont2);
     jbtPay.setFont(buttonFont2);
     jbtClear.setFont(buttonFont2);
     
     jbtPay.setBackground(Color.WHITE);
     jbtClear.setBackground(Color.WHITE);
     jbtPay.setBorder(buttonBorder);
     jbtClear.setBorder(buttonBorder);
     jbtPay.setPreferredSize(new Dimension(80, 38));
     jbtClear.setPreferredSize(new Dimension(80, 38));
     
     jbtPay.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtPay.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtPay.setBackground(Color.WHITE);
        
    }
});
     jbtClear.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtClear.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtClear.setBackground(Color.WHITE);
        
    }
});
     jbtPay.setMnemonic('P');
     jbtClear.setMnemonic('C');
     jbtClear.addActionListener(new ActionListener()
     {
         public void actionPerformed(ActionEvent e)
         {
             jtfCardNo.setText("");
         }
     });
     jbtPay.addActionListener(new PayListener());
     jtfOrderID.setEditable(false);
     jtfTotalAmount.setEditable(false);
     jp1.add(jp3);
     subPanel_r1.setOpaque(false);
     subPanel_r2.setOpaque(false);
     jp3.setOpaque(false);
    
     jpanel.add(jlbMethod,BorderLayout.NORTH);
     jpanel.add(jp1,BorderLayout.CENTER);
    
     add(jpanel,BorderLayout.CENTER);
     
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Credit Card Payment");
     pack();
     setSize(550,350);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
     
    }
      
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      private class PayListener implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
        int countAlpha=0;
         for(int i=0;i<jtfCardNo.getText().length();i++)
             {
                 char ch=jtfCardNo.getText().charAt(i);
                 if(Character.isAlphabetic(ch)){
                 countAlpha++;}
             }
             if(countAlpha>0)
             {
                  JOptionPane.showMessageDialog(null, "Alphabetic input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
                  jtfCardNo.setText("");
             }
             else if(jtfCardNo.getText().length()!=16)
             {
             JOptionPane.showMessageDialog(null, "Invalid input.\nPlease reenter in 16 characters format.","WARNING",JOptionPane.WARNING_MESSAGE);
             jtfCardNo.setText("");
             }
             else
             {
                  int counter=0;
                  int totalSeat=0;
                 randomID=new PaymentIDGenerator("PY",8);
                 String paymentID=randomID.generateID();
                 //System.out.print(paymentID);
                 payControl.createRecord(paymentID, Double.parseDouble(jtfTotalAmount.getText()), 
                         "CREDIT", jtfCardNo.getText(), Double.parseDouble(jtfTotalAmount.getText()), 
                        0.0, jtfOrderID.getText());
                 //payControl.closeDB();
                 
                 orderList=payControl.getOrderListById(jtfOrderID.getText());
                 payControl.closeDB();
                 //System.out.println(orderList);
                 for(int i=0;i<orderList.size();i++)
                 {
                    counter+=seatControl.updateRecord(orderList.get(i).getTripNo(), orderList.get(i).getSeatNo(),
                            "N");
                    totalSeat=seatControl.getTotalSeat(orderList.get(i).getTripNo(), "Y");
                    tripControl.updateSeat(orderList.get(i).getTripNo(), totalSeat);
                 }
                 /*for(int i=0;i<orderList.size();i++)
                 {
                    counter+=seatControl.updateRecord(orderList.get(i).getTripNo(), orderList.get(i).getSeatNo(),
                            "N");
                    //seatControl.closeDB();
                    //totalSeat=seatControl.getTotalSeat(orderList.get(i).getTripNo(), "Y");
                    //tripControl.updateSeat(orderList.get(i).getTripNo(), totalSeat);
                 }
                 seatControl.closeDB();
               for(int j=0;j<orderList.size();j++)
                 {
                    //counter+=seatControl.updateRecord(orderList.get(i).getTripNo(), orderList.get(i).getSeatNo(),
                          //  "N");
                    totalSeat=seatControl.getTotalSeat(orderList.get(j).getTripNo(), "Y");
                   
                    //tripControl.updateSeat(orderList.get(i).getTripNo(), totalSeat);
                 } 
               seatControl.closeDB();
               for(int k=0;k<orderList.size();k++)
                 {
                    //counter+=seatControl.updateRecord(orderList.get(i).getTripNo(), orderList.get(i).getSeatNo(),
                          //  "N");
                    //totalSeat=seatControl.getTotalSeat(orderList.get(k).getTripNo(), "Y");
                    tripControl.updateSeat(orderList.get(k).getTripNo(), totalSeat);
                    tripControl.closeDB();
                 }*/
                 JOptionPane.showMessageDialog(null, counter+" Trip seat (s) have been successfully updated.");
                 
                 closeFrame();
                 new SuccessPayment(accType,jtfOrderID.getText(),paymentID);
             }
      }
      }
       private void ValidateCardNo()
     {
         jtfCardNo.setBackground(new Color(255, 230, 230));
          int countAlpha=0;
         for(int i=0;i<jtfCardNo.getText().length();i++)
             {
                 char ch=jtfCardNo.getText().charAt(i);
                 if(Character.isAlphabetic(ch)){
                 countAlpha++;}
             }
             if(countAlpha>0)
             {
                  JOptionPane.showMessageDialog(null, "Alphabetic input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
             }
             else
             {
            if(jtfCardNo.getText().length()==16)
            {
            jtfCardNo.setBackground(new Color(240, 255, 240));
            }
            else if(jtfCardNo.getText().length()>16)
            {
             JOptionPane.showMessageDialog(null, "Maximum 16 characters for credit card serial number","WARNING",JOptionPane.WARNING_MESSAGE);
            }
            }
       
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
        new CreditCardPayment('U',"",0.0);
    }
}