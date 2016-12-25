//Sum
//V1.01 26MAR16 0115PM
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.swing.*;
import da.*;
import ui.*;
import domain.*;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.*;

import control.*;

public class ShowOrderCart extends JFrame{
    
    private char accType;
    
    private String orderID;
    
    private ArrayList<OrderLine> orderLineList;
    
    private ArrayList<Trip> tripListSpecial;
    
    private MaintainOrder orderControl;
    
    private MaintainTrip tripControl;
    
    private JLabel jlbTitle = new JLabel("Order Cart");
    private JLabel jlbOrderID = new JLabel("Order ID: ");
    
    private JTextField jtfOrderID = new JTextField(10);
    
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtRemove = new JButton("Remove");
    private JButton jbtCheckout = new JButton("Checkout");
    
    //private JPanel jp_NORTH = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH = new JPanel(new GridLayout(2, 1, 5, 5));
    private JPanel jp_NORTH_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    //private JPanel jp_CENTER = new JPanel(new FlowLayout());
    private JPanel jp_CENTER = new JPanel(new BorderLayout());
    private JPanel jp_containCenter = new JPanel(new FlowLayout());
    
    private JPanel jp_SOUTH = new JPanel(new FlowLayout());
    private JPanel global = new JPanel(new BorderLayout()){  
   
        
        public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     ShowOrderCart.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    private JTable OrderCartTable;
    private OrderCartTableModel cartTBModel;
    
    Font wlcFont = new Font("Comic Sans MS",Font.BOLD,15);
    
    public ShowOrderCart(){
        
    }
    
    public ShowOrderCart(char accType, String orderID, ArrayList<OrderLine> orderLineList){
        
        this.accType = accType;
        this.orderID = orderID;
        this.orderLineList = orderLineList;
        
         //initialize JTable
        cartTBModel = new OrderCartTableModel();
        OrderCartTable =  new JTable(cartTBModel);
        
        tripControl = new MaintainTrip();
        orderControl = new MaintainOrder();
        
        jlbTitle.setFont(wlcFont);
        
        jp_NORTH.setOpaque(false);
        jp_CENTER.setOpaque(false);
        jp_containCenter.setOpaque(false);
        jp_SOUTH.setOpaque(false);
        jp_NORTH_r1.setOpaque(false);
        jp_NORTH_r2.setOpaque(false);
        
        //jp_NORTH.add(jlbTitle);
        jp_NORTH_r1.add(jlbTitle);
        jp_NORTH_r2.add(jlbOrderID);
        jp_NORTH_r2.add(jtfOrderID);
        
        jp_NORTH.add(jp_NORTH_r1);
        jp_NORTH.add(jp_NORTH_r2);
        
        jp_CENTER.add(new JScrollPane(OrderCartTable),BorderLayout.CENTER);
        jp_CENTER.setPreferredSize(new Dimension(770,400));
        
        jp_SOUTH.add(jbtAdd);
        jp_SOUTH.add(jbtRemove);
        jp_SOUTH.add(jbtCheckout);
        
        jp_containCenter.add(jp_CENTER);
        
        global.add(jp_NORTH, BorderLayout.NORTH);
//        global.add(jp_CENTER, BorderLayout.CENTER);
        global.add(jp_containCenter, BorderLayout.CENTER);
        global.add(jp_SOUTH, BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(global,BorderLayout.CENTER);
        
        //register window listener
        addWindowListener(new WindowListener());
        
        jtfOrderID.setEditable(false);
        
        tripListSpecial = new ArrayList<>();
        Trip tripIn = new Trip();
        Trip tripOut;
        
        //temporarily disable for frame size adjustments xx
        //add row
        for(int i = 0; i < orderLineList.size(); i++){
            tripIn.setTripno(orderLineList.get(i).getTripNo());
            tripOut = tripControl.getTripByTripNo(tripIn);
            
            //collecting side by side trip origin, destination and price
            tripListSpecial.add(tripOut);
        }
        
        //feed JTable
        for(int k = 0; k < orderLineList.size(); k++){
            cartTBModel.addRow(orderLineList.get(k), tripListSpecial.get(k));
        }
        //temp xx
        
        jbtAdd.addActionListener(new ButtonListener());
        jbtRemove.addActionListener(new ButtonListener());
        jbtCheckout.addActionListener(new ButtonListener());
        
        
        jtfOrderID.setText(orderID);
        
        setIcon();
        
        setTitle("Show Order Cart");
        setSize(900,600);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //temp dev
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtAdd){
                //go back to showavailabletrip with orderline arraylist
                dispose();
                new ShowAvailableTrips(accType,orderLineList);
            }
            else if(e.getSource() == jbtRemove){
                int row = OrderCartTable.getSelectedRow();
                
                if(row != -1){
                    
                    cartTBModel.removeRow(row);
                    orderLineList.remove(row);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No item selected!","Warning",JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(e.getSource() == jbtCheckout){
                //Date date = new Date();
                Ordertable order = new Ordertable(orderID, new java.util.Date());
                int result = -1;
                result = orderControl.saveOrder(order, orderLineList);
                
                //temp dev
                if(result > 0){
                    orderLineList.clear();
                }
                
                //close connection and resultset
                ///////////////////////////
                tripControl.closeDB();
                orderControl.closeDB();
                ///////////////////////////
                //link to payment
                dispose();
                new PaymentFrame(accType);
                
            }
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Show Available Trips page?", "Confirm?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                tripControl.closeDB();
                orderControl.closeDB();
                dispose();
                new ShowAvailableTrips(accType,orderLineList);
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }

    
    public static void main(String[] args){
        new ShowOrderCart('A',"",null);
    }
}