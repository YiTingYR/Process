package ui; 
import control.PaymentControl;
import control.TripControl;
import domain.OrderDetailForPayment;
import domain.PaymentClass;
import domain.TripClass;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.SwingUtilities;
public class Receipt extends JFrame{
    
public static String now(String dateFormat) {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(cal.getTime());

  }
JPanel jp1=new JPanel(new BorderLayout());

JPanel jpNorth=new JPanel(new FlowLayout());
JPanel subPanel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
JPanel jpCenter=new JPanel(new FlowLayout(FlowLayout.CENTER));
//JPanel jpSouth=new JPanel(new BorderLayout());

JPanel subPanel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
JPanel subPanel4=new JPanel(new FlowLayout(FlowLayout.CENTER));
final JScrollPane pane = new JScrollPane(jpCenter);

 JTextArea textarea=new JTextArea();
 LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
 LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);

   ImageIcon iconLogo=new ImageIcon(getClass().getResource("../images/SmallSizeLogo.jpg"));
   Font buttonFont=new Font("French Script MT",Font.PLAIN,50);
   Font buttonFont2=new Font("Century",Font.PLAIN,15);
   JLabel jlb=new JLabel("EzWay Express Receipt");
   JTextArea text1=new JTextArea();
   JTextArea text2=new JTextArea();
   
   PaymentControl payControl;
   TripControl tripControl;
   ArrayList<OrderDetailForPayment> orderList = new ArrayList<OrderDetailForPayment>();
   JButton jbtPrint=new JButton("Print Receipt");

public Receipt(final String orderid,final String paymentID){
     run();
     setLayout(new BorderLayout());
     payControl=new PaymentControl();
     tripControl=new TripControl();
     
     jlb.setIcon(iconLogo);
     jlb.setFont(buttonFont);
     subPanel1.add(jlb);
     
     jpNorth.add(subPanel1);
     jpNorth.setBackground(new Color(179, 255, 179));
     subPanel1.setBackground(new Color(179, 255, 179));
     
     String strTitle="";
     strTitle+="\n----------------------------------------------------------EZWAY EXPRESS RECEIPT"
             + "-------------------------------------------------------------------\n Payment ID: "
             +paymentID+"\n OrderID: "+orderid+"\n Printing Date: "+Receipt.now("dd MMMMM yyyy")
            +"\n Printing Time: "+Receipt.now("h:mm a")+"\n\n================================"
             + "===================================================\n"
             +String.format("%30s\t%15s\t%15s","============","============","============")
             +String.format("\n%30s\t%15s\t%18s","Trip Number","Seat Number","Trip Price (RM)")
             +String.format("\n%30s\t%15s\t%15s","============","============","============\n");
     
     orderList=payControl.getOrderListById(orderid);
     int totalTicket=orderList.size();
     TripClass trip=null;
     String strDetails="";
     for(int i=0;i<totalTicket;i++)
     {
     trip=tripControl.selectRecord(orderList.get(i).getTripNo());
     strDetails+=String.format("\n%30s\t%15s\t%15s",orderList.get(i).getTripNo(),orderList.get(i).getSeatNo(),
             String.format("%35.2f", trip.getTripprice()));
     }
     strTitle+=strDetails+"\n---------------------------------------------------------------------"
             + "----------------------------------------------------------------------------------\n";
     PaymentClass payment=null;
     payment = payControl.getPaymentList(paymentID);
     String strPay="";
     strPay+=" TOTAL AMOUNT: RM"+String.format("%.2f",payment.getTotalamt())+"\n Total Paid: RM"+
             String.format("%.2f",payment.getPaidamt())+"\n Cash Change: RM"+
             String.format("%.2f",payment.getCashchange())+"\n Payment method: "+payment.getPaymethod();
     strTitle+=strPay+"\n\n\n---------------------------------------------------------------------"
             + "----------------------------------------------------------------------------------\n";
     String strHeader="\t\t\tThank you. Have a nice day :)\n";
     strTitle+=strHeader;
     
     text1.setText(strTitle);
     text1.setFont(buttonFont2);
     text1.setBorder(buttonBorder2);
     text1.setEditable(false);
     text1.setOpaque(true);
     //text1.setBackground(new Color(204, 255, 204));
     jpCenter.add(text1);
     
   
     
     jpCenter.setBackground(new Color(204, 255, 204));
     jp1.add(jpNorth,BorderLayout.NORTH);
     jp1.add(pane,BorderLayout.CENTER);
     //jp1.add(jpSouth,BorderLayout.SOUTH);
     jp1.setBackground(new Color(204, 255, 204));
     
     subPanel4.add(jbtPrint);
     jbtPrint.setBorder(buttonBorder2);
     jbtPrint.setBackground(Color.WHITE);
     jbtPrint.setFont(buttonFont2);
     jbtPrint.setPreferredSize(new Dimension(150, 40));
     jbtPrint.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtPrint.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtPrint.setBackground(Color.WHITE);
        
    }
});
     jbtPrint.addActionListener(new PrintListener());
     
     subPanel4.setOpaque(true);
     subPanel4.setBackground(new Color(179, 255, 179));
     
     add(jp1,BorderLayout.CENTER);
     add(subPanel4,BorderLayout.SOUTH);
     pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     pane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
     pane.getVerticalScrollBar().setValue(0);
     
     setIcon();
     setTitle("Receipt");
     setSize(900,650);
     setVisible(true);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
}
private class PrintListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          try {
              Boolean complete=text1.print();
              if(complete)
              {
                  JOptionPane.showMessageDialog(null, "Done Printing");
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Printing");
              }
          } catch (PrinterException ex) {
              Logger.getLogger(BusTicket.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }
private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
private void run()
{
     pane.getVerticalScrollBar().setValue(0);
    
}

public static void main(String[]args)
    {
      new Receipt("ODA0000002","PY71779573");
        
    }

}