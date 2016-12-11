package ui; //Author:Teh Yi Ting
import control.PaymentControl;
import control.TripControl;
import control.TripSeatControlForSchedule;
import da.OrderDetailForPaymentDA;
import da.OrderForPaymentDA;
import domain.OrderDetailForPayment;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.text.ParseException;
import javax.swing.JPanel;  
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import domain.PaymentIDGenerator;
import java.util.ArrayList;

public class CashPayment extends JFrame
{
    PaymentControl payControl;
    OrderForPaymentDA paymentDA;
    OrderDetailForPaymentDA detailPaymentDA;
    PaymentIDGenerator randomID;
    ArrayList<OrderDetailForPayment> orderList = new ArrayList<OrderDetailForPayment>();
    TripSeatControlForSchedule seatControl;
    TripSeatControlForSchedule seatControl2;
    TripControl tripControl;
    public String cookieOrderID="";
    JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background2.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
   
     Font buttonFont=new Font("French Script MT",Font.PLAIN,45);
     Font buttonFont2=new Font("Century",Font.PLAIN,18);
     
     JPanel jp1=new JPanel(new BorderLayout());
     JPanel jp2=new JPanel(new GridLayout(4,3,5,5));
     JPanel jp3=new JPanel(new GridLayout(6,2));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r7=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r8=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r9=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r10=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r11=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r12=new JPanel(new FlowLayout(FlowLayout.CENTER));
 
     JLabel jlbMethod=new JLabel("Cash Payment");
     JLabel jlbOrderID=new JLabel("Order ID");
     JLabel jlbTotalAmount=new JLabel("Total Amount (RM)");
     JLabel jlbPaidAmt=new JLabel("Paid Amount (RM)");
     JLabel jlbCashChange=new JLabel("Cash Change (RM)");
     
     JTextField jtfOrderID=new JTextField(15);
     JTextField jtfTotalAmount=new JTextField(15);
     JTextField jtfPaidAmt=new JTextField(15);
     JTextField jtfCashChange=new JTextField(15);
     
     JButton jbtPay=new JButton("Pay");
     JButton jbtClear=new JButton("Clear");
     
     JButton jbtOne=new JButton("1");
     JButton jbtTwo=new JButton("2");
     JButton jbtThree=new JButton("3");
     JButton jbtFour=new JButton("4");
     JButton jbtFive=new JButton("5");
     JButton jbtSix=new JButton("6");
     JButton jbtSeven=new JButton("7");
     JButton jbtEight=new JButton("8");
     JButton jbtNine=new JButton("9");
     JButton jbtZero=new JButton("0");
     JButton jbtDot=new JButton(".");
     JButton jbtBackSpace=new JButton("←");
    
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
    
     public CashPayment(final char accType,final String orderid,final double totAmount)
    {
      this.accType=accType;     
     cookieOrderID=orderid; 
     paymentDA=new OrderForPaymentDA();
     detailPaymentDA=new OrderDetailForPaymentDA();
     payControl=new PaymentControl();
     seatControl=new TripSeatControlForSchedule();
     seatControl2=new TripSeatControlForSchedule();
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
     jp3.add(jlbPaidAmt);
     jp3.add(jtfPaidAmt);
     jp3.add(jlbCashChange);
     jp3.add(jtfCashChange);
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
     jtfPaidAmt.setFont(buttonFont2);
     jlbPaidAmt.setFont(buttonFont2);
     jlbCashChange.setFont(buttonFont2);
     jtfCashChange.setFont(buttonFont2);
     jbtPay.setFont(buttonFont2);
     jbtClear.setFont(buttonFont2);
     
     jtfOrderID.setText(orderid);
     jtfTotalAmount.setText(String.format("%.2f",totAmount));
     
     jtfPaidAmt.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent e){
                ValidatePaidAmt();
            }
            
            public void removeUpdate(DocumentEvent e){
                jtfCashChange.setText("");
            }
            
            public void insertUpdate(DocumentEvent e){
                ValidatePaidAmt();
            }        
        });
     
     jbtClear.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            jtfPaidAmt.setText("");
            jtfCashChange.setText("");
        }
     });
     jbtZero.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"0";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtOne.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"1";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtTwo.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"2";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtThree.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"3";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtFour.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"4";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtFive.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"5";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtSix.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"6";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtSeven.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"7";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtEight.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"8";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtNine.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+"9";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtDot.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
            paidamt=paidamt+".";
            jtfPaidAmt.setText(paidamt);
        }
     });
     jbtBackSpace.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
            String paidamt=jtfPaidAmt.getText();
           
            //char lastChar=paidamt.charAt(paidamt.length());
            if(jtfPaidAmt.getText().isEmpty())
            {
                jtfPaidAmt.setText("");
            }
            else
            { 
                String subString=paidamt.substring(0, paidamt.length()-1);
                jtfPaidAmt.setText(subString);
            }
            
        }
     });
     
     jbtPay.addActionListener(new PayListener());
     
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
     jbtZero.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtZero.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtZero.setBackground(Color.WHITE);
        
    }
});
     jbtDot.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtDot.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtDot.setBackground(Color.WHITE);
        
    }
});
     jbtBackSpace.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtBackSpace.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtBackSpace.setBackground(Color.WHITE);
        
    }
});
     jbtFour.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtFour.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtFour.setBackground(Color.WHITE);
        
    }
});
     jbtFive.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtFive.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtFive.setBackground(Color.WHITE);
        
    }
});
     jbtSix.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSix.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSix.setBackground(Color.WHITE);
        
    }
});
     jbtSeven.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSeven.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSeven.setBackground(Color.WHITE);
        
    }
});
     jbtEight.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtEight.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtEight.setBackground(Color.WHITE);
        
    }
});
     jbtNine.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtNine.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtNine.setBackground(Color.WHITE);
        
    }
});
     jbtOne.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtOne.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtOne.setBackground(Color.WHITE);
        
    }
});
     jbtTwo.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtTwo.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtTwo.setBackground(Color.WHITE);
        
    }
});
     jbtThree.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtThree.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtThree.setBackground(Color.WHITE);
        
    }
});
     jbtPay.setMnemonic('P');
     jbtClear.setMnemonic('C');
     
     jtfOrderID.setEditable(false);
     jtfTotalAmount.setEditable(false);
     jtfCashChange.setEditable(false);
     jp1.add(jp3,BorderLayout.WEST);
     subPanel_r1.setOpaque(false);
     subPanel_r2.setOpaque(false);
     jp3.setOpaque(false);
     jp2.setOpaque(false);
     jp2.add(jbtSeven);
     jp2.add(jbtEight);
     jp2.add(jbtNine);
     jp2.add(jbtFour);
     jp2.add(jbtFive);
     jp2.add(jbtSix);
     jp2.add(jbtOne);
     jp2.add(jbtTwo);
     jp2.add(jbtThree);
     jp2.add(jbtZero);
     jp2.add(jbtDot);
     jp2.add(jbtBackSpace);
   
     jbtSeven.setPreferredSize(new Dimension(85,85));
     
     jbtSeven.setBackground(Color.WHITE);
     jbtEight.setBackground(Color.WHITE);
     jbtNine.setBackground(Color.WHITE);
     jbtFour.setBackground(Color.WHITE);
     jbtFive.setBackground(Color.WHITE);
     jbtSix.setBackground(Color.WHITE);
     jbtOne.setBackground(Color.WHITE);
     jbtTwo.setBackground(Color.WHITE);
     jbtThree.setBackground(Color.WHITE);
     jbtZero.setBackground(Color.WHITE);
     jbtDot.setBackground(Color.WHITE);
     jbtBackSpace.setBackground(Color.WHITE);
     
     jbtSeven.setBorder(buttonBorder);
     jbtEight.setBorder(buttonBorder);
     jbtNine.setBorder(buttonBorder);
     jbtFour.setBorder(buttonBorder);
     jbtFive.setBorder(buttonBorder);
     jbtSix.setBorder(buttonBorder);
     jbtOne.setBorder(buttonBorder);
     jbtTwo.setBorder(buttonBorder);
     jbtThree.setBorder(buttonBorder);
     jbtZero.setBorder(buttonBorder);
     jbtDot.setBorder(buttonBorder);
     jbtBackSpace.setBorder(buttonBorder);
     
     jbtSeven.setFont(buttonFont2);
     jbtEight.setFont(buttonFont2);
     jbtNine.setFont(buttonFont2);
     jbtFour.setFont(buttonFont2);
     jbtFive.setFont(buttonFont2);
     jbtSix.setFont(buttonFont2);
     jbtOne.setFont(buttonFont2);
     jbtTwo.setFont(buttonFont2);
     jbtThree.setFont(buttonFont2);
     jbtZero.setFont(buttonFont2);
     jbtDot.setFont(buttonFont2);
     jbtBackSpace.setFont(buttonFont2);
     
     jp1.add(jp2,BorderLayout.EAST);
    
     jpanel.add(jlbMethod,BorderLayout.NORTH);
     jpanel.add(jp1,BorderLayout.CENTER);
    
     add(jpanel,BorderLayout.CENTER);
     
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Cash Payment");
     pack();
     setSize(825,500);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
     
    }
      private void ValidatePaidAmt()
     {
         String paidamt=jtfPaidAmt.getText();
         int countDot=0;
         for(int i=0;i<paidamt.length();i++)
         {
             char ch=paidamt.charAt(i);
             if(Character.compare(ch, '.')==0)
             {
             countDot++;
             }
         }
         if(countDot>0)
         {
             jbtDot.setEnabled(false);
         }
         else
         {
             jbtDot.setEnabled(true);
         }
         try{
         double totalAmount=Double.parseDouble(jtfTotalAmount.getText());
         double paidAmount=Double.parseDouble(paidamt);
         double change=paidAmount-totalAmount;
         
         jtfCashChange.setText(String.format("%.2f",change));
         jtfPaidAmt.setBackground(new Color(240, 255, 240));
         
         }catch(NumberFormatException ex)
         {
             jtfPaidAmt.setBackground(new Color(255, 230, 230));
             JOptionPane.showMessageDialog(null, "Alphabetic input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
              jtfCashChange.setText("");
         }
                 
        
     }
      private class PayListener implements ActionListener
      {
      public void actionPerformed(ActionEvent e)
      {
         try{
             
         double totalAmount=Double.parseDouble(jtfTotalAmount.getText());
         double paidAmount=Double.parseDouble(jtfPaidAmt.getText());
         if(paidAmount<totalAmount)
         {
             jtfPaidAmt.setBackground(new Color(255, 230, 230));
             JOptionPane.showMessageDialog(null, "The paid amount must exceed the total amount.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
             jtfCashChange.setText("");
             jtfPaidAmt.setText("");
         }
         else
         {
              int counter=0;
              int totalSeat=0;
             double change=paidAmount-totalAmount;
              randomID=new PaymentIDGenerator("PY",8);
              String paymentID=randomID.generateID();
              String cardNo="";
              for(int i=1;i<=16;i++)
              {
                 cardNo+="0";
              }
              
              payControl.createRecord(paymentID, totalAmount, "CASH", cardNo, paidAmount, change,
              jtfOrderID.getText());
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
                    totalSeat=seatControl2.getTotalSeat(orderList.get(i).getTripNo(), "Y");
                 }
               seatControl.closeDB();
               seatControl2.closeDB();
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
         }catch(NumberFormatException ex)
         {
             jtfPaidAmt.setBackground(new Color(255, 230, 230));
             JOptionPane.showMessageDialog(null, "Alphabetic input is invalid.\nPlease reenter.","WARNING",JOptionPane.WARNING_MESSAGE);
             jtfCashChange.setText("");
             jtfPaidAmt.setText("");
         }
        
      }
      
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
        new CashPayment('U',"",0.0);
    }
}