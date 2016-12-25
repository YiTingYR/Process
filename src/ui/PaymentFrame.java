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
import da.PaymentTable;
import da.PaymentDA;
import java.util.ArrayList;


public class PaymentFrame extends JFrame
{
    PaymentDA p=new PaymentDA();
    OrderForPaymentDA paymentDA;
    OrderDetailForPaymentDA detailPaymentDA;
    private PaymentTable tableModel;
    private JTable productTable;
     ArrayList<String> priceList = new ArrayList<String>();
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/background2.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
   
     Font buttonFont=new Font("French Script MT",Font.ITALIC,45);
     Font buttonFont2=new Font("Century",Font.PLAIN,18);
     
     JPanel jp1=new JPanel(new GridLayout(2,1));
     //JPanel jp2=new JPanel(new GridLayout(6,1));
     JPanel jp2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel jp3=new JPanel(new GridLayout(1,2));
     JPanel jp4=new JPanel(new GridLayout(2,2));
     
     JPanel subPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r2=new JPanel(new FlowLayout(FlowLayout.LEFT));
     
     JPanel subPanel_r3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
     JPanel subPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel subPanel_r5=new JPanel(new FlowLayout(FlowLayout.LEFT));
     JPanel subPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r6=new JPanel(new FlowLayout(FlowLayout.CENTER));
     
     JLabel jlbPayment=new JLabel("Payment");
     JLabel jlbOrderID=new JLabel("OrderID");
     JLabel jlbTotalAmount=new JLabel("Total Amount (RM)");
     JTextField jtfOrderID=new JTextField(15);
     JTextField jtfTotalAmount=new JTextField(15);
     JButton jbtPayment=new JButton("Payment");
     
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
      private char accType;
    
      
     public PaymentFrame(final char accType)
    {
     this.accType=accType;       
     setLayout(new BorderLayout());
     
      paymentDA=new OrderForPaymentDA();
      detailPaymentDA=new OrderDetailForPaymentDA();
      
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
      menuPanel_r6.setOpaque(false);
      
      jp1.setOpaque(false);
      jp1.add(jlbPayment);
      jlbPayment.setFont(buttonFont);
      jlbPayment.setHorizontalAlignment(SwingConstants.CENTER);
      
      subPanel_r1.setOpaque(false);
      subPanel_r2.setOpaque(false);
      jlbOrderID.setFont(buttonFont2);
      jtfOrderID.setFont(buttonFont2);
      jtfOrderID.setEditable(false);
      jtfOrderID.setText("ODA0000018");
      //jtfOrderID.setText(lastOrderID());
     
      subPanel_r1.add(jlbOrderID);
      subPanel_r2.add(jtfOrderID);
      jp3.setOpaque(false);
      jp3.add(subPanel_r1);
      jp3.add(subPanel_r2);
      jp1.add(jp3);
     
      jp2.setOpaque(false);
      tableModel=new PaymentTable(jtfOrderID.getText());
      productTable = new JTable(tableModel);
      productTable.setOpaque(false);
      JScrollPane pane=new JScrollPane(productTable);
      pane.setPreferredSize(new Dimension(850,200));
      jp2.setBorder(buttonBorder);
      jp2.add(pane);
      pane.getViewport().setBackground(new Color(255,255,255));
      
      jlbTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
      subPanel_r3.add(jlbTotalAmount);
      jlbTotalAmount.setFont(buttonFont2);
      subPanel_r4.add(jtfTotalAmount);
      jtfTotalAmount.setFont(buttonFont2);
      jtfTotalAmount.setEditable(false);
      subPanel_r4.add(jbtPayment);
      jbtPayment.setFont(buttonFont2);
      
      jbtPayment.setBorder(buttonBorder2);
      jbtPayment.setBackground(Color.WHITE);
      jbtPayment.setPreferredSize(new Dimension(100, 28));
      jbtPayment.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtPayment.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtPayment.setBackground(Color.WHITE);
        
    }
});
      jbtPayment.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new PaymentMethod(accType,jtfOrderID.getText(),Double.parseDouble(jtfTotalAmount.getText()));
               
           }
       });
      
      jp4.setOpaque(false);
      subPanel_r3.setOpaque(false);
      subPanel_r4.setOpaque(false);
      subPanel_r5.setOpaque(false);
      subPanel_r6.setOpaque(false);
      
      jp4.add(subPanel_r5);
      jp4.add(subPanel_r6);
      jp4.add(subPanel_r3);
      jp4.add(subPanel_r4);
      
     jpanel.add(jp1,BorderLayout.NORTH);
     jpanel.add(jp2,BorderLayout.CENTER);
     jpanel.add(jp4,BorderLayout.SOUTH);
     add(jpanel,BorderLayout.CENTER);
     
     double totalPrice=calculateTotal();
     jtfTotalAmount.setText(String.format("%.2f", totalPrice));
     
     setIcon();
     addWindowListener(new WindowListener());
     setTitle("Payment");
     setSize(920,570);
     setVisible(true);
     setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
     
     
    }
     private double calculateTotal() {
         
     int totalRow=tableModel.getRowCount();
     for(int i=0;i<totalRow;i++)
     {
         priceList.add(tableModel.getValueAt(i, 3).toString());
         
     }
     int totalPrice=0;
     for(int j=0;j<priceList.size();j++)
     {
         totalPrice+=Double.parseDouble(priceList.get(j));
     }
     return totalPrice;
     
     }
      public String lastOrderID()
      {
          String lastOrderID="";
         lastOrderID=p.displayLastOrderID();
          System.out.print(lastOrderID);
          return lastOrderID;
          
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
               String orderid=jtfOrderID.getText();
                detailPaymentDA.deleteOrderDetailRecord(orderid);
                paymentDA.deleteRecord(orderid);
                closeFrame();
                new homePage(accType);
           
           }
         
        }
        }
      public static void main(String[]args)
    {
        new PaymentFrame('U');
    }
}