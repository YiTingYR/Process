//Sum
//V1.01 25MAR16 0756PM
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.swing.*;

import da.*;
import ui.*;
import domain.*;
import control.*;
import java.util.ArrayList;

public class EnterQuantity extends JFrame{
    
    private MaintainTrip tripControl;
    
    private int quantity; // This is quantity requested by customer
    
    private int availableQty;
    
    private int qtyInCart;
    
    private char accType;
    
    private String tripNo;
    
    private String orderID;
    
    private ArrayList<OrderLine> orderLineList;
    
    private Trip tripResult; //for available quantity checking
    
    private JLabel jlbInstr = new JLabel("Please enter the quantity needed: ");
    private JLabel jlbQty = new JLabel("Currently available seat(s): ");
    
    private JTextField jtfQuantity = new JTextField(2);
    
    private JButton jbtOK = new JButton("OK");
    
    private JPanel jp_Main = new JPanel(new GridLayout(4,1));
    
    private JPanel jp_Main_r1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jp_Main_r2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jp_Main_r3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jp_Main_r4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
   private JPanel global = new JPanel(new BorderLayout()){  

        public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     EnterQuantity.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
   public EnterQuantity(){
       
   }
   
    public EnterQuantity(char accType, String tripNo, String orderID, ArrayList<OrderLine> orderLineList){
        
        tripControl = new MaintainTrip();
        
        this.accType = accType;
        
        this.tripNo = tripNo;
        
        this.orderID = orderID;
        
        this.orderLineList = orderLineList;
        
        Trip tripIn = new Trip();
        tripIn.setTripno(tripNo);

        tripResult = tripControl.getTripByTripNo(tripIn);
        //int availableQty;
        this.availableQty = tripResult.getAvailableseat();//may cause error if this attribute value is not consistent with the number of rows that 'Y' with this particular tripno in TRIPSEAT table.
        
        
        
        
        //minus available quantity from db to minus the already ordered but not yet paid seat for a particular tripno
        qtyInCart = 0;
        for(int i = 0; i < orderLineList.size(); i++){
            if(orderLineList.get(i).getTripNo().equals(tripNo)){
                qtyInCart ++;
            }
        }
        
        availableQty = availableQty - qtyInCart;
        
        //test
        System.out.println("qtyInCart for tripno: "+tripNo+"is "+qtyInCart);
        System.out.println("available qty is now: "+availableQty);
        
        
        //customize JLabel based on available quantity
        jlbQty = new JLabel("Currently available seat(s): " + availableQty);
        //////////////////////////////////////////
        

        
        jp_Main_r1.add(jlbInstr);
        jp_Main_r2.add(jlbQty);
        jp_Main_r3.add(jtfQuantity);
        jp_Main_r4.add(jbtOK);
        
        jp_Main.add(jp_Main_r1);
        jp_Main.add(jp_Main_r2);
        jp_Main.add(jp_Main_r3);
        jp_Main.add(jp_Main_r4);
        
        jp_Main.setOpaque(false);
        jp_Main_r1.setOpaque(false);
        jp_Main_r2.setOpaque(false);
        jp_Main_r3.setOpaque(false);
        jp_Main_r4.setOpaque(false);
        
        
        global.add(jp_Main, BorderLayout.CENTER);
        
        setLayout(new BorderLayout());
        add(global,BorderLayout.CENTER);
        
        jbtOK.addActionListener(new ButtonListener());
        
        addWindowListener(new WindowListener());
        
        getRootPane().setDefaultButton(jbtOK);
        
        setIcon();
        
        setTitle("Enter Quantity");
        setSize(300,220);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //temp dev
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtOK){
                //int quantity = 0;
                boolean qtyValidity = false;
                try{
                    quantity = Integer.parseInt(jtfQuantity.getText());
                    qtyValidity = true;
                    //test
                    System.out.println("quantity is: "+quantity);
                    
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Please enter only integers for quantity","Invalid Quantity",JOptionPane.ERROR_MESSAGE);
                    qtyValidity = false;
                }
                
                if(qtyValidity){
                    
                    //disabled because it does not consider unpaid but ordered seats
//                    Trip tripIn = new Trip();
//                    tripIn.setTripno(tripNo);
//
//                    tripResult = tripControl.getTripByTripNo(tripIn);
//                    int availableQty;
//                    availableQty = tripResult.getAvailableseat();//may cause error if this attribute value is not consistent with the number of rows that 'Y' with this particular tripno in TRIPSEAT table.

                    if(quantity <= availableQty && quantity > 0){
                        dispose();
                        new SeatSelection(accType, quantity, tripNo, orderID, orderLineList);
                    }
                    else{
                        //JOptionPane.showMessageDialog(null, "The quantity entered has exceeded the available seat quantity of:\n" + availableQty + " seat(s) left","Exceeded Available Quantity",JOptionPane.WARNING_MESSAGE);
                        JOptionPane.showMessageDialog(null, "Please ensure that the quantity entered is more than 0 and less then the availble quantity.\n" + availableQty + " seat(s) left","Invalid Quantity",JOptionPane.WARNING_MESSAGE);
                    }
                }
                else{
                    //do nothing
                }
            }
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Show Available Trips page?", "Confirm?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                tripControl.closeDB();
                //orderControl.closeDB();
                dispose();
                new ShowAvailableTrips(accType,orderLineList);
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new EnterQuantity('A',"","", null);
    }


}
