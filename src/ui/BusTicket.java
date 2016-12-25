package ui; 
import control.PaymentControl;
import control.RouteControl;
import domain.OrderDetailForPayment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import control.TripControl;
import domain.Route;
import domain.TripClass;
import control.TripSeatControlForSchedule;
import domain.Seat;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
//import org.jdesktop.swingx.JXLabel;
public class BusTicket extends JFrame{
    
   JPanel jp1=new JPanel(new BorderLayout());
   
   JPanel jpNorth=new JPanel(new BorderLayout());
   //JPanel subPanel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
   JPanel subPanel2=new JPanel(new FlowLayout(FlowLayout.CENTER));
   JPanel subPanel3=new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel subPanel4=new JPanel(new FlowLayout(FlowLayout.CENTER));
 
JScrollPane pane = new JScrollPane(subPanel3);
JTextArea textarea=new JTextArea();
LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);

   ImageIcon iconLogo=new ImageIcon(getClass().getResource("../images/SmallSizeLogo.jpg"));
   Font buttonFont=new Font("French Script MT",Font.PLAIN,50);
   Font buttonFont2=new Font("Century",Font.PLAIN,18);
   JLabel jlogo=new JLabel(iconLogo);
   JLabel jticket=new JLabel("EzWay Express Bus Ticket");
   
   PaymentControl payControl;
   TripControl tripControl;
   RouteControl routeControl;
   TripSeatControlForSchedule seatControl;
   ArrayList<OrderDetailForPayment> orderList = new ArrayList<OrderDetailForPayment>();
   
    JButton jbtPrint=new JButton("Print Bus Ticket");
   
  public BusTicket(final String orderid,final String paymentID){
      
     setLayout(new BorderLayout());
     payControl=new PaymentControl();
     tripControl=new TripControl();
     routeControl=new RouteControl();
     seatControl=new TripSeatControlForSchedule();
    
     jticket.setIcon(iconLogo);
     jticket.setHorizontalAlignment(SwingConstants.LEFT);
     subPanel2.add(jticket);
     
     jticket.setFont(buttonFont);
     //jpNorth.add(subPanel1,BorderLayout.WEST);
     jpNorth.add(subPanel2,BorderLayout.CENTER);
     
     //subPanel1.setOpaque(true);
     subPanel2.setOpaque(true);
     jpNorth.setOpaque(true);
     //subPanel1.setBackground(new Color(179, 255, 179));
     subPanel2.setBackground(new Color(179, 255, 179));
     jpNorth.setBackground(new Color(179, 255, 179));
     
     TripClass trip=null;
     Route route=null;
     Seat seat=null;
     orderList=payControl.getOrderListById(orderid);
     int totalTicket=orderList.size();
     
     String str="";
     for(int i=0;i<totalTicket;i++)
     {
         trip=tripControl.selectRecord(orderList.get(i).getTripNo());
         
         route=routeControl.selectRecord(trip.getRouteid());
       
         seat=seatControl.selectDeck(orderList.get(i).getSeatNo());
        
         str+="\n===========================================================\n"
                 + "------------------------------EZWAY EXPRESS-----------------------------\nPayment ID: "
                 +paymentID+"\nOrder ID: "+orderid+"\nTrip Number: "+orderList.get(i).getTripNo()+"\nSeat Number: "+
                 orderList.get(i).getSeatNo()+"\nDeck: "+seat.getDeck()+"\nOrigin: "+route.getOrigin()+"\nDestination: "
                 +route.getDestination()+"\nTrip Date: "+trip.getDepartdate().toString()+"\nTrip Time (24 hrs): "+
                 trip.getDeparttime()+"\nTrip Price: RM"+String.format("%.2f",trip.getTripprice())+"\n\n";
         
     }
     textarea.setText(str);
     textarea.setOpaque(true);
     textarea.setBackground(new Color(255, 255, 255));
     textarea.setFont(buttonFont2);
     subPanel3.setOpaque(true);
     subPanel3.setBackground(new Color(204, 255, 204));
     textarea.setBorder(buttonBorder);
     subPanel3.add(textarea);
     textarea.setEditable(false);
     
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

     pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     pane.getVerticalScrollBar().setValue(0);
     
     jp1.add(jpNorth,BorderLayout.NORTH);
     jp1.add(pane,BorderLayout.CENTER);
     jp1.setBackground(new Color(204, 255, 204));
     add(jp1,BorderLayout.CENTER);
     add(subPanel4,BorderLayout.SOUTH);
    
     pane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
     setIcon();
     setTitle("Bus Ticket");
     setSize(900,700);
     setVisible(true);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     //setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     
  }
  private class PrintListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          try {
              Boolean complete=textarea.print();
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
    public static void main(String[]args)
    {
         new BusTicket("ODA0000002","");
//JPanel content = new JPanel();//this is the panel that will be scrolled
//JScrollPane pane = new JScrollPane(content);
//frame.getContentPane().add(pane);
        
    }
}