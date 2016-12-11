//Sum
//V1.00 24MAR16 1152AM
package ui;

import da.TripTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

import da.*;
import ui.*;
import domain.*;
import control.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ShowAvailableTrips extends JFrame{
    
    private char accType;
    
    private MaintainTrip tripControl;
    
    private MaintainOrder orderControl;
    
    private String[] tripSelection;
    
    private SimpleDateFormat dateFormat;
    
    // a shared data source as a reference for combo boxes in both initData() and also jbtSearch 
    private ArrayList<Trip> tripList;
    
    // a shared data source as a reference for combo boxes in both initData() and also jbtSearch 
    private ArrayList<Route> routeList;
    
    //based on Show All trip numbers or after search trip numbers
    private ArrayList<Trip> tripComboBoxCurrentReference; //needed for reference after a search has been performed, in which the options in the combo box will no longer based on tripList but tripResult instead
    
    private String orderID;
    
    //Carrying orderLineList
    private ArrayList<OrderLine> orderLineList;
    
    //private int depTimeSelIndex;
    
    //Labels
    private JLabel jlbTitle = new JLabel("Show Available Trips");
    private JLabel jlbInstr = new JLabel("Please choose the following criteria, to search for specific trip(s).  Click \"Show All\" to show all the available trips.  Click \"Reset\" to reset all the criteria.");
    private JLabel jlbInstr2 = new JLabel("Please choose the intended trip no from the combo box below the table.  You can also click \"Show Cart\" to open the Order Cart.");
    private JLabel jlbOrigin = new JLabel("Origin: ");
    private JLabel jlbDestination = new JLabel("Destination: ");
    private JLabel jlbDepDate = new JLabel("Departure Date: ");
    private JLabel jlbDepTime = new JLabel("Departure Time: ");
    private JLabel jlbTripNo = new JLabel("Trip No: ");
    
    //Combo boxes // ALL INITIALIZATION ARE DONE IN initData()
    private DefaultComboBoxModel dcbomOrigin = new DefaultComboBoxModel();
    private JComboBox jcbOrigin = new JComboBox(dcbomOrigin);
    private DefaultComboBoxModel dcbomDestination = new DefaultComboBoxModel();
    private JComboBox jcbDestination = new JComboBox(dcbomDestination);
    private DefaultComboBoxModel dcbomDepDate = new DefaultComboBoxModel();
    private JComboBox jcbDepDate = new JComboBox(dcbomDepDate);
    private DefaultComboBoxModel dcbomDepTime = new DefaultComboBoxModel();
    private JComboBox jcbDepTime = new JComboBox(dcbomDepTime);
    
    private DefaultComboBoxModel dcbomTripNo = new DefaultComboBoxModel();
    private JComboBox jcbTripNo = new JComboBox(dcbomTripNo);
    

    
         
    
    //Buttons
    private JButton jbtSearch = new JButton("Search");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtShowAll = new JButton("Show All");
    private JButton jbtShowCart = new JButton("Show Cart");
    private JButton jbtSelSeats = new JButton("Select Seats");
    
    //JPanels
    private JPanel jp_NORTH = new JPanel(new GridLayout(6, 1, 0, 5));//5105
    private JPanel jp_NORTH_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
    private JPanel jp_NORTH_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 5));
    private JPanel jp_NORTH_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
    
    private JPanel jp_CENTER = new JPanel(new BorderLayout());
    
    private JPanel jp_SOUTH = new JPanel(new BorderLayout());
    
    private JPanel jp_SOUTH_r1 = new JPanel(new FlowLayout());
    
    //private JPanel jp_containTable = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    
    //private JPanel jp_SOUTH = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
    //private JPanel jp_containTable = new JPanel(new BorderLayout());
    
    private JPanel global = new JPanel(new BorderLayout()){  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     ShowAvailableTrips.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    //JTable Things
    private TripTableModel tripTBModel;
    private JTable AvailTripTable;
    
    private Color btnColor = new Color(214, 239, 159);
    
    Font headerFont = new Font("Comic Sans MS",Font.BOLD,15);
    
    public ShowAvailableTrips(){
        
    }
    
    public ShowAvailableTrips(char accType, ArrayList<OrderLine> orderLineList){ //can accept accType and orderID from OrderCart, but orderID is not necessary since the constructor of ShowAvailableTrips will run the generateOrderID() everytime it is opened.
        
        this.accType = accType;
        
        this.orderLineList = orderLineList;
        
        tripControl = new MaintainTrip();
        
        orderControl = new MaintainOrder();
        
        //initialize JTable
        tripTBModel = new TripTableModel();
        AvailTripTable =  new JTable(tripTBModel);
        
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        initData(); //POSITION FIXED --> all jcombobox must be instantiated and initialized before can be added to panel
        
        //set Header Fount
        jlbTitle.setFont(headerFont);
        
        jp_NORTH.setOpaque(false);
        jp_NORTH_r1.setOpaque(false);
        jp_NORTH_r2.setOpaque(false);
        jp_NORTH_r3.setOpaque(false);
        jp_NORTH_r4.setOpaque(false);
        jp_NORTH_r5.setOpaque(false);
        jp_NORTH_r6.setOpaque(false);
        jp_CENTER.setOpaque(false);
        jp_SOUTH.setOpaque(false);
        jp_SOUTH_r1.setOpaque(false);
        global.setOpaque(false);
        
        //set Button colours
        jbtSearch.setBackground(btnColor);
        jbtReset.setBackground(btnColor);
        jbtSelSeats.setBackground(btnColor);
        jbtShowAll.setBackground(btnColor);
        jbtShowCart.setBackground(btnColor);
        
        //set Mnemonics
        jbtSearch.setMnemonic('S');
        jbtReset.setMnemonic('R');
        jbtShowAll.setMnemonic('A');
        jbtShowCart.setMnemonic('C');
        jbtSelSeats.setMnemonic('E');
        
        
        jp_NORTH_r1.add(new JLabel("  ")); //border protection
        jp_NORTH_r1.add(jlbTitle);
        jp_NORTH_r2.add(new JLabel("  ")); //border protection
        jp_NORTH_r2.add(jlbInstr);
        jp_NORTH_r3.add(new JLabel("  ")); //border protection
        jp_NORTH_r3.add(jlbInstr2);
        jp_NORTH_r4.add(jlbOrigin);
        jp_NORTH_r4.add(new JLabel("       "));
        jp_NORTH_r4.add(jcbOrigin);
        jp_NORTH_r4.add(new JLabel("                          "));
        jp_NORTH_r4.add(jlbDestination);
        jp_NORTH_r4.add(new JLabel(""));
        jp_NORTH_r4.add(jcbDestination);
        //jp_NORTH_r4.add(new JLabel("  ")); //border protection
        jp_NORTH_r5.add(jlbDepDate);
        jp_NORTH_r5.add(jcbDepDate);
        jp_NORTH_r5.add(new JLabel("                          "));
        jp_NORTH_r5.add(jlbDepTime);
        //jp_NORTH_r4.add(new JLabel(""));
        jp_NORTH_r5.add(jcbDepTime);
        jp_NORTH_r6.add(new JLabel("  ")); //border protection
        jp_NORTH_r6.add(jbtSearch);
        jp_NORTH_r6.add(jbtReset);
        jp_NORTH_r6.add(jbtShowAll);
        jp_NORTH_r6.add(jbtShowCart);
        
        jp_NORTH.add(jp_NORTH_r1);
        jp_NORTH.add(jp_NORTH_r2);
        jp_NORTH.add(jp_NORTH_r3);
        jp_NORTH.add(jp_NORTH_r4);
        jp_NORTH.add(jp_NORTH_r5);
        jp_NORTH.add(jp_NORTH_r6);
        
        //jp_containTable.add(new JScrollPane(AvailTripTable), BorderLayout.CENTER);
        
        jp_CENTER.add(new JScrollPane(AvailTripTable),BorderLayout.CENTER);
        //jp_SOUTH.add(jp_containTable,BorderLayout.CENTER);
        //jp_SOUTH.add(jp_containTable);
        
        jp_SOUTH_r1.add(jlbTripNo);
        jp_SOUTH_r1.add(jcbTripNo);
        jp_SOUTH_r1.add(jbtSelSeats);
        
        jp_SOUTH.add(jp_SOUTH_r1);
        
        global.add(jp_NORTH,BorderLayout.NORTH);
        global.add(jp_CENTER,BorderLayout.CENTER);
        global.add(jp_SOUTH,BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(global,BorderLayout.CENTER);
        
        //register button listener
        jbtSearch.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtShowAll.addActionListener(new ButtonListener());
        jbtShowCart.addActionListener(new ButtonListener());
        jbtSelSeats.addActionListener(new ButtonListener());
        
        addWindowListener(new WindowListener());
        
        //register Item Listener
//        jcbDepTime.addItemListener(new ComboBoxListener());
        
        //generate orderID
        generateOrderID(); //this method will always be ran whenever this frame opens, this will not cause problem because the new orderID is never been saved into the ORDERTABLE yet.

        setIcon();
        
        setTitle("Show Available Trips");
        setSize(1150,705);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //temp dev
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            
            if(e.getSource() == jbtSearch){
                
                tripTBModel.clearTable();
                //tripTBModel = new TripTableModel();
                //Containers
                Trip tripContainer = new Trip();
                Route routeContainer = new Route();
                ArrayList<Trip> tripResult;
                
                //get selected actual values, tripno is not used here
                String selOrigin;//because the dash makan post 0 in jcb
                String selDestination;
                String selDepDate;
                String selDepTime;
                
                
                
                if(jcbOrigin.getSelectedIndex() == 0){
                    selOrigin = "-";
                }
                else{
                    //selOrigin = routeList.get(jcbOrigin.getSelectedIndex()-1).getOrigin();
                    selOrigin = (String)(dcbomOrigin.getElementAt(jcbOrigin.getSelectedIndex())); //I suppose no need index-1 here 
                }
                
                if(jcbDestination.getSelectedIndex() == 0){
                    selDestination = "-";
                }
                else{
                    //selDestination = routeList.get(jcbDestination.getSelectedIndex()-1).getDestination();
                    selDestination = (String)(dcbomDestination.getElementAt(jcbDestination.getSelectedIndex()));
                }
                
                if(jcbDepDate.getSelectedIndex() == 0){
                    selDepDate = "-";
                }
                else{
                    //selDepDate = dateFormat.format(tripList.get(jcbDepDate.getSelectedIndex()-1).getDepartdate());//need special handling
                    selDepDate = (String)(dcbomDepDate.getElementAt(jcbDepDate.getSelectedIndex()));
                }
                //test
                
                System.out.println("\njcbDepTime.getSelectedIndex() is: "+jcbDepTime.getSelectedIndex());
                System.out.println("jcbDepTime Item Count is now: "+jcbDepTime.getItemCount());
                if(jcbDepTime.getSelectedIndex() == 0){
                    selDepTime = "-";
                }
                else{
                    //selDepTime = tripList.get(jcbDepTime.getSelectedIndex()-1).getDeparttime();
                    selDepTime = (String)(dcbomDepTime.getElementAt(jcbDepTime.getSelectedIndex()));
                }
               
                
                //test input
                System.out.println("Input Test");
                System.out.println("SelOrigin: "+selOrigin);
                System.out.println("selDestination: "+selDestination);
                System.out.println("selDepDate: "+selDepDate);
                System.out.println("selDepTime: "+selDepTime);
                
                //keep into the container to be transported
                tripContainer.setDateString(selDepDate);
                tripContainer.setDeparttime(selDepTime);
                
                routeContainer.setOrigin(selOrigin);
                routeContainer.setDestination(selDestination);
                //containers ready------------>>>>>>>>>
                tripTBModel.clearTable();
                tripResult = tripControl.searchTrip(tripContainer, routeContainer);
                
                //test
                System.out.println("In UI Search button, size is : "+tripResult.size());
                System.out.println("\n");
                
                for(int k = 0; k < tripResult.size(); k++){
                    tripTBModel.addRow(tripResult.get(k));
                }
                
                initializeTripCombo(tripResult);
                
                
            }
            else if(e.getSource() == jbtReset){
                jcbOrigin.setSelectedIndex(0);
                jcbDestination.setSelectedIndex(0);
                jcbDepDate.setSelectedIndex(0);
                jcbDepTime.setSelectedIndex(0);
                jcbTripNo.setSelectedIndex(0);
            }
            else if(e.getSource() == jbtShowAll){
                
                initData();
                               
            }
            else if(e.getSource() == jbtShowCart){
                dispose();
                new ShowOrderCart(accType, orderID, orderLineList);
            }
            else if(e.getSource() == jbtSelSeats){
                
                //new SeatSelection(accType,tripComboBoxCurrentReference.get(jcbTripNo.getSelectedIndex()).getTripno());
                Trip tripIn = new Trip();
                //tripIn.setTripno(tripComboBoxCurrentReference.get(jcbTripNo.getSelectedIndex()).getTripno());
                tripIn.setTripno((String)(dcbomTripNo.getElementAt(jcbTripNo.getSelectedIndex()))); //safer
                int availableQty = tripControl.getTripByTripNo(tripIn).getAvailableseat();
                
                if(availableQty != 0){ //still got seat(s)
                    dispose();
                    //new EnterQuantity(accType, tripComboBoxCurrentReference.get(jcbTripNo.getSelectedIndex()).getTripno(), orderID, orderLineList);
                    new EnterQuantity(accType, (String)(dcbomTripNo.getElementAt(jcbTripNo.getSelectedIndex())), orderID, orderLineList); //safer
                }
                else{ //No more seat(s) available
//                    JOptionPane.showMessageDialog(null, "There is no more seat(s) left for this trip,\nTrip No: " + tripComboBoxCurrentReference.get(jcbTripNo.getSelectedIndex()).getTripno() + "\nPlease select other trip.","No More Seat(s)",JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null, "There is no more seat(s) left for this trip,\nTrip No: " + (String)(dcbomTripNo.getElementAt(jcbTripNo.getSelectedIndex())) + "\nPlease select another trip.","No More Seat(s)",JOptionPane.WARNING_MESSAGE);
                }
            }
            
        }
    }
    
    
    public void initData(){
         //////////////////////////
        tripList = tripControl.getActiveTrips();
        routeList = tripControl.getAvailableRouteInfo();
       
        
        //important codes, to allow updating of JComboBox selections
        dcbomDepTime.removeAllElements();
        dcbomDepDate.removeAllElements();
        dcbomDestination.removeAllElements();
        dcbomOrigin.removeAllElements();
        dcbomTripNo.removeAllElements();
        
        
        tripTBModel.clearTable();
        
        //initialize JTable
        for(int i = 0; i < tripList.size(); i++){
            
            System.out.println("UI/////initData()//// "+tripList.size()+"\n"+tripList.get(i).getTripno());
            tripTBModel.addRow(tripList.get(i));
        }
        

        //dev test
        dcbomOrigin.addElement("-");
        dcbomDestination.addElement("-");
        dcbomDepDate.addElement("-");
        dcbomDepTime.addElement("-");
        
        
        initializeTripCombo(tripList);

        //initialize origin combo box
//        for(int j = 0; j < routeList.size(); j++){
//            if(j == 0){
//                dcbomOrigin.addElement(routeList.get(j).getOrigin());
//            }
//            else{
//                if(!routeList.get(j-1).getOrigin().equals(routeList.get(j).getOrigin())){ //not the same as previous
//                    dcbomOrigin.addElement(routeList.get(j).getOrigin());
//                }
//                else{
//                    //do nothing
//                }
//            }
//        }
        
        //test repair --> Success
        boolean existingOrigin = false;
        for(int i = 0; i < routeList.size(); i++){
            if(i == 0){
                dcbomOrigin.addElement(routeList.get(i).getOrigin());
            }
            else{
                for(int j = 0; j < dcbomOrigin.getSize(); j++){
                    
                    //test demo
                    //System.out.println("New Test: "+"i: "+ i+"  j:  "+j+ " -->"+routeList.get(i).getOrigin()+"  "+dcbomOrigin.getElementAt(j)+"    -->"+ routeList.get(i).getOrigin().equals(dcbomOrigin.getElementAt(j)));
                    
                    if(routeList.get(i).getOrigin().equals(dcbomOrigin.getElementAt(j))){
                        existingOrigin = true;
                        break;
                    }
                    else{
                        existingOrigin = false;
                    }
                }
                
                if(!existingOrigin){
                    dcbomOrigin.addElement(routeList.get(i).getOrigin());
                }
                else{
                    //Do nothing because the origin already exists.
                }
            }
        }
        //////////////////////////
        //initialize destination combo box
//        for(int k = 0; k < routeList.size(); k++){
//            if(k == 0){
//                dcbomDestination.addElement(routeList.get(k).getDestination());
//            }
//            else{
//                if(!routeList.get(k-1).getDestination().equals(routeList.get(k).getDestination())){ //not the same as previous
//                    dcbomDestination.addElement(routeList.get(k).getDestination());
//                }
//                else{
//                    //do nothing
//                }
//            }
//        }
        boolean existingDestination = false;
        for(int i = 0; i < routeList.size(); i++){
            //test
            //System.out.println(routeList.get(i).getDestination() + "      "+i);
            if(i == 0){
                //System.out.println(routeList.get(i).getDestination() + "  chosen    "+i);
                dcbomDestination.addElement(routeList.get(i).getDestination());
            }
            else{
                for(int j = 0; j < dcbomDestination.getSize(); j++){
                    //test
                    //if(i == 1 || i == 3){
                        //System.out.println("New Test: "+"i: "+ i+"  j:  "+j+ " -->"+routeList.get(i).getDestination()+"  "+dcbomDestination.getElementAt(j)+"    -->"+ routeList.get(i).getDestination().equals(dcbomDestination.getElementAt(j)));
                    //}
                    //////////////////
                    if(routeList.get(i).getDestination().equals(dcbomDestination.getElementAt(j))){
                        //System.out.println((String)dcbomDestination.getElementAt(j) + "  dcbom    "+i);
                        existingDestination = true;
                        break;
                    }
                    else{
                        existingDestination = false;
                    }
                }
                
                if(!existingDestination){
                    //System.out.println(routeList.get(i).getDestination() + "      "+i);
                    dcbomDestination.addElement(routeList.get(i).getDestination());
                }
                else{
                    //Do nothing because the destination already exists.
                }
            }
        }
        
        //test
//        for(int j = 0; j < dcbomDestination.getSize(); j++){
//                    System.out.println((String)dcbomDestination.getElementAt(j) + "  dcbom    "+j);
//                }
        //////////////////////////////////
        //initialize departure time combo box
//        for(int m = 0; m < tripList.size(); m++){
//            if(m == 0){
//                dcbomDepTime.addElement(tripList.get(m).getDeparttime());
//            }
//            else{
//                if(!tripList.get(m-1).getDeparttime().equals(tripList.get(m).getDeparttime())){ //not the same as previous
//                    dcbomDepTime.addElement(tripList.get(m).getDeparttime());
//                }
//                else{
//                    //do nothing
//                }
//            }
//        }
        boolean existingDepartTime = false;
        for(int i = 0; i < tripList.size(); i++){
            if(i == 0){
                dcbomDepTime.addElement(tripList.get(i).getDeparttime());
            }
            else{
                for(int j = 0; j < dcbomDepTime.getSize(); j++){
                    if(tripList.get(i).getDeparttime().equals(dcbomDepTime.getElementAt(j))){
                        existingDepartTime = true;
                        break;
                    }
                    else{
                        existingDepartTime = false;
                    }
                }
                
                if(!existingDepartTime){
                    dcbomDepTime.addElement(tripList.get(i).getDeparttime());
                }
                else{
                    //Do nothing because the dep time already exists.
                }
            }
        }
        ////////////////////////////////////////////
        //initialize departure date combo box
//        for(int n = 0; n < tripList.size(); n++){
//            if(n == 0){
//                dcbomDepDate.addElement(dateFormat.format(tripList.get(n).getDepartdate()));
//            }
//            else{
//                if(!dateFormat.format(tripList.get(n-1).getDepartdate()).equals(dateFormat.format(tripList.get(n).getDepartdate()))){ //not the same as previous
//
//                        dcbomDepDate.addElement(dateFormat.format(tripList.get(n).getDepartdate()));
//
//                }
//                else{
//                    //do nothing
//                }
//            }
//        }
        boolean existingDepartDate = false;
        for(int i = 0; i < tripList.size(); i++){
            if(i == 0){
                dcbomDepDate.addElement(dateFormat.format(tripList.get(i).getDepartdate()));
            }
            else{
                for(int j = 0; j < dcbomDepDate.getSize(); j++){
                    //if(dateFormat.format(tripList.get(i).getDepartdate()).equals(dateFormat.format((String)((dcbomDepDate.getElementAt(j)))))){
                    if(dateFormat.format(tripList.get(i).getDepartdate()).equals((String)(dcbomDepDate.getElementAt(j)))){
                        existingDepartDate = true;
                        break;
                    }
                    else{
                        existingDepartDate = false;
                    }
                }
                
                if(!existingDepartDate){
                    dcbomDepDate.addElement(dateFormat.format(tripList.get(i).getDepartdate()));
                }
                else{
                    //Do nothing because the dep time already exists.
                }
            }
        }


        jcbOrigin.setSelectedIndex(0);
        jcbDestination.setSelectedIndex(0);
        jcbDepDate.setSelectedIndex(0);
        jcbDepTime.setSelectedIndex(0);
        //jcbTripNo.setSelectedIndex(0);
    }
    
    private void initializeTripCombo(ArrayList<Trip> trip){
        // Trip combo box is not affected by the "-" and its subsequent impacts.
        
        //update the current data refernce for the trip combo box
        tripComboBoxCurrentReference = trip; //this local trip can be tripList in initData() or tripResult in jbtSearch
        
        tripSelection = new String[trip.size()];
        
        dcbomTripNo.removeAllElements();
        
        
        //supposing there is a check to skip execution of loop when search result is empty, but the cond in loop can eliminate this because 0=0
        for(int i = 0; i < tripSelection.length; i++){
            tripSelection[i] = trip.get(i).getTripno();
            dcbomTripNo.addElement(tripSelection[i]);

        }
        
        //disable the select seats button when trip no combo box is empty
        if(trip.size() == 0){
            jbtSelSeats.setEnabled(false);
        }
        else{
            jbtSelSeats.setEnabled(true);
        }
        
    }
    
    private void generateOrderID(){
        ArrayList<Ordertable> orderList;
        
        orderList = orderControl.getOrderList();
        
        if(orderList.size() == 0){ //no existing record
            this.orderID = "ODA0000001";
        }
        else{ //There are/is existing record(s)
            String orderPrefix = "OD";
            String lastOrderID = orderList.get(orderList.size()-1).getOrderid(); //directly get the last record in the arraylist or table
            String numericPart = lastOrderID.substring(3);
            String alphabet = lastOrderID.substring(2,3);
            String newNumeric;
            String newAlphabet;
            String newOrderID = "";
            
            if(lastOrderID.equals("ODZ9999999")){ //OrderID used up, no more space
                JOptionPane.showMessageDialog(null, "The Order ID has been used up.\nContact your system administrator for further assistance.\nThe system will now exit.", "Order ID Used Up.", JOptionPane.ERROR_MESSAGE);
                tripControl.closeDB();
                orderControl.closeDB();
                System.exit(0);
            }
            else{ //still have order ID, not used up yet
                if(numericPart.equals("9999999")){
                    newAlphabet = String.valueOf((char)(alphabet.charAt(0)+1));//works ady...
                    newNumeric = "0000001";
                    newOrderID = orderPrefix + newAlphabet + newNumeric;
                }
                else{
                    newAlphabet = alphabet; // Alphabet no change, number still have
                    newNumeric = String.valueOf(Integer.parseInt(numericPart)+1); //Increment the numericPart by one (+1)


                    while(newNumeric.length() != 7){
                        newNumeric = "0" + newNumeric;
                    }

                    newOrderID = orderPrefix + newAlphabet + newNumeric;
                }
            
            }//
            //final step pass up orderID
            this.orderID = newOrderID;
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Ticket Purchasing Submenu?", "Confirm?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                tripControl.closeDB();
                orderControl.closeDB();
                dispose();
                new TicketPurchasingMenu(accType);
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new ShowAvailableTrips('U',null);
    }
}