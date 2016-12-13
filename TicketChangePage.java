//Sum
//V1.00 24MAR16 1152AM
package ui;

import control.MaintainTicketChange;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.swing.*;
import da.*;
import ui.*;
import domain.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TicketChangePage extends JFrame{
    
    private char accType;
    
    private MaintainTicketChange ticketControl;
    
    private SimpleDateFormat dateFormat;
    
    private SimpleDateFormat dateTimeFormat;
    
    private ArrayList<TripSeat2> tripSeatList; //list of selectable trips from db
    
    private TripSeat2 tripSeatOld;
    
    private TripSeat2 tripSeatNew;//new Trip Info
    
    //needed for confirm button
    String enteredOrderID;
    String enteredTripNo;
    String enteredSeatNo;
    
    private JLabel jlbTitle = new JLabel("Ticket Change");
    private JLabel jlbInstr = new JLabel("Please enter the following information printed on the original ticket");
    private JLabel jlbOrderID = new JLabel("Order ID: ");
    private JLabel jlbTripNo = new JLabel("Trip No: ");
    private JLabel jlbSeatNo = new JLabel("Seat No: ");
    private JLabel jlbCurHeader = new JLabel("Current Ticket Information");
    private JLabel jlbOrigin = new JLabel("Origin: ");
    private JLabel jlbDestination = new JLabel("Destination: ");
    private JLabel jlbCurDepDate = new JLabel("Departure Date: ");
    private JLabel jlbCurDepTime = new JLabel("Departure Time: ");
    private JLabel jlbInstrTwo = new JLabel("Please select a new trip no: ");
    private JLabel jlbNewHeader = new JLabel("New Ticket Information");
    
    private JLabel jlbCurSeatNo = new JLabel("Seat No: ");
    private JLabel jlbNewSeatNo = new JLabel("Seat No: ");
    
    private JLabel jlbNewDepDate = new JLabel("Departure Date: ");
    private JLabel jlbNewDepTime = new JLabel("Departure Time: ");
    
//    private JComboBox jcbTripNo = new JComboBox(new String[]{"TEST 1","TEST 2","TEST 3"});
    private DefaultComboBoxModel dcbomTripNo = new DefaultComboBoxModel();
    private JComboBox jcbTripNo;
    
    private JTextField jtfOrderID = new JTextField(10);
    private JTextField jtfTripNo = new JTextField(15);
    private JTextField jtfSeatNo = new JTextField(4);
    private JTextField jtfOrigin = new JTextField(25);
    private JTextField jtfDestination = new JTextField(25);
    
    private JTextField jtfCurDepDate = new JTextField(10);
    private JTextField jtfCurDepTime = new JTextField(10);
    private JTextField jtfCurSeatNo = new JTextField(4);
    
    private JTextField jtfNewDepDate = new JTextField(10);
    private JTextField jtfNewDepTime = new JTextField(10);
    private JTextField jtfNewSeatNo = new JTextField(4);
    
    private JButton jbtRead = new JButton("Read");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtConfirm = new JButton("Confirm");
    private JButton jbtCancel = new JButton("Cancel");
    
    private JPanel jp_NORTH = new JPanel(new GridLayout(6,1));
    private JPanel jp_CENTER = new JPanel(new GridLayout(4,1));
    private JPanel jp_SOUTH = new JPanel(new GridLayout(5,1));
    
    private JPanel jp_NORTH_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_NORTH_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER,40,5));
    
    private JPanel jp_CENTER_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_CENTER_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_CENTER_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_CENTER_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    private JPanel jp_SOUTH_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_SOUTH_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_SOUTH_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_SOUTH_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jp_SOUTH_r5 = new JPanel(new FlowLayout(FlowLayout.CENTER,40,5));
    
    
    private JPanel global = new JPanel(new BorderLayout()){  

        public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     EnterQuantity.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    Font wlcFont = new Font("Comic Sans MS",Font.BOLD,15);
    Font headerFont = new Font("Comic Sans MS",Font.BOLD,13);
    
    private Color btnColor = new Color(214, 239, 159);
    
    public TicketChangePage(){
        this.jcbTripNo = new JComboBox(dcbomTripNo);
        
    }
    
    public TicketChangePage(char accType){
        
        this.jcbTripNo = new JComboBox(dcbomTripNo);
        
        this.accType = accType;
        
        ticketControl = new MaintainTicketChange();
        
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        //set TextFields max limit
        jtfOrderID.setDocument(new JTextFieldLimit(10));
        jtfTripNo.setDocument(new JTextFieldLimit(15));
        jtfSeatNo.setDocument(new JTextFieldLimit(4));
        
        //set button colours
        jbtConfirm.setBackground(btnColor);
        jbtCancel.setBackground(btnColor);
        jbtRead.setBackground(btnColor);
        jbtReset.setBackground(btnColor);
        
        //setMnemonics
        jbtRead.setMnemonic('E');
        jbtReset.setMnemonic('R');
        jbtConfirm.setMnemonic('C');
        jbtCancel.setMnemonic('N');
        
        jlbTitle.setFont(wlcFont);
        jlbCurHeader.setFont(headerFont);
        jlbNewHeader.setFont(headerFont);
        
        jp_NORTH.setBorder(new LineBorder(Color.BLACK));
        jp_CENTER.setBorder(new LineBorder(Color.BLACK));
        jp_SOUTH.setBorder(new LineBorder(Color.BLACK));
        
        jlbNewHeader.setForeground(new Color(255,255,255));
        //jlbNewDepDate.setForeground(new Color(255, 255, 255));
        //jlbNewDepTime.setForeground(new Color(255, 255, 255));
        
        jp_NORTH.setOpaque(false);
        jp_CENTER.setOpaque(false);
        jp_SOUTH.setOpaque(false);
        
        jp_NORTH_r1.setOpaque(false);
        jp_NORTH_r2.setOpaque(false);
        jp_NORTH_r3.setOpaque(false);
        jp_NORTH_r4.setOpaque(false);
        jp_NORTH_r5.setOpaque(false);
        jp_NORTH_r6.setOpaque(false);
        
        jp_CENTER_r1.setOpaque(false);
        jp_CENTER_r2.setOpaque(false);
        jp_CENTER_r3.setOpaque(false);
        jp_CENTER_r4.setOpaque(false);
        
        jp_SOUTH_r1.setOpaque(false);
        jp_SOUTH_r2.setOpaque(false);
        jp_SOUTH_r3.setOpaque(false);
        jp_SOUTH_r4.setOpaque(false);
        jp_SOUTH_r5.setOpaque(false);
        
        jtfOrigin.setEditable(false);
        jtfDestination.setEditable(false);
        jtfCurDepDate.setEditable(false);
        jtfCurDepTime.setEditable(false);
        jtfCurSeatNo.setEditable(false);
        jtfNewDepDate.setEditable(false);
        jtfNewDepTime.setEditable(false);
        jtfNewSeatNo.setEditable(false);
        
        jbtConfirm.setEnabled(false);
        
        jp_NORTH_r1.add(jlbTitle);
        jp_NORTH_r2.add(jlbInstr);
        jp_NORTH_r3.add(jlbOrderID);
        jp_NORTH_r3.add(jtfOrderID);
        jp_NORTH_r4.add(jlbTripNo);
        jp_NORTH_r4.add(jtfTripNo);
        jp_NORTH_r5.add(jlbSeatNo);
        jp_NORTH_r5.add(jtfSeatNo);
        jp_NORTH_r6.add(jbtRead);
        jp_NORTH_r6.add(jbtReset);
        
        jp_NORTH.add(jp_NORTH_r1);
        jp_NORTH.add(jp_NORTH_r2);
        jp_NORTH.add(jp_NORTH_r3);
        jp_NORTH.add(jp_NORTH_r4);
        jp_NORTH.add(jp_NORTH_r5);
        jp_NORTH.add(jp_NORTH_r6);
        
        jp_CENTER_r1.add(jlbCurHeader);
        jp_CENTER_r2.add(jlbOrigin);
        jp_CENTER_r2.add(jtfOrigin);
        jp_CENTER_r2.add(new JLabel("              "));
        jp_CENTER_r2.add(jlbDestination);
        jp_CENTER_r2.add(jtfDestination);
        jp_CENTER_r3.add(jlbCurDepDate);
        jp_CENTER_r3.add(jtfCurDepDate);
        jp_CENTER_r3.add(new JLabel("                                                    "));
        jp_CENTER_r3.add(jlbCurDepTime);
        jp_CENTER_r3.add(jtfCurDepTime);
        jp_CENTER_r4.add(jlbCurSeatNo);
        jp_CENTER_r4.add(jtfCurSeatNo);
        
        jp_CENTER.add(jp_CENTER_r1);
        jp_CENTER.add(jp_CENTER_r2);
        jp_CENTER.add(jp_CENTER_r3);
        jp_CENTER.add(jp_CENTER_r4);
        
        jp_SOUTH_r1.add(jlbInstrTwo);
        jp_SOUTH_r1.add(jcbTripNo);
        jp_SOUTH_r2.add(jlbNewHeader);
        jp_SOUTH_r3.add(jlbNewDepDate);
        jp_SOUTH_r3.add(jtfNewDepDate);
        jp_SOUTH_r3.add(new JLabel("                                                    "));
        jp_SOUTH_r3.add(jlbNewDepTime);
        jp_SOUTH_r3.add(jtfNewDepTime);
        jp_SOUTH_r4.add(jlbNewSeatNo);
        jp_SOUTH_r4.add(jtfNewSeatNo);
        jp_SOUTH_r5.add(jbtConfirm);
        jp_SOUTH_r5.add(jbtCancel);
        
        jp_SOUTH.add(jp_SOUTH_r1);
        jp_SOUTH.add(jp_SOUTH_r2);
        jp_SOUTH.add(jp_SOUTH_r3);
        jp_SOUTH.add(jp_SOUTH_r4);
        jp_SOUTH.add(jp_SOUTH_r5);
        
        global.add(jp_NORTH, BorderLayout.NORTH);
        global.add(jp_CENTER, BorderLayout.CENTER);
        global.add(jp_SOUTH, BorderLayout.SOUTH);
        
    
        setLayout(new BorderLayout());
        add(global,BorderLayout.CENTER);
        
        jbtRead.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtConfirm.addActionListener(new ButtonListener());
        jbtCancel.addActionListener(new ButtonListener());
        
        //register window listener
        addWindowListener(new WindowListener());
        
        //add - to combo box
        //dcbomTripNo.addElement("-");
        //jcbTripNo.setSelectedIndex(0);
        
        jcbTripNo.addItemListener(new ComboBoxListener()); //disabled for maintenance
        
        //disable combo box initially
        jcbTripNo.setEnabled(false);
        
        setIcon();
        
        setTitle("Ticket Change");
        setSize(800,600);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //temp dev
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        
}
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtRead){
                boolean orderIDValidity = true;
                boolean tripNoValidity = true;
                boolean seatNoValidity = true;
                
                //inputs will be saved to class variables
                enteredOrderID = jtfOrderID.getText();
                enteredTripNo = jtfTripNo.getText();
                enteredSeatNo = jtfSeatNo.getText();

                //input validations
                //Validation for orderID***********************************
                //length check
                if(enteredOrderID.length() != 10){
                    orderIDValidity = false;
                }
                
                for(int i = 0; i < enteredOrderID.length(); i++){
                    if(i == 0){//O
                        if(!(enteredOrderID.charAt(i) == 'O')){ // if not O
                            orderIDValidity = false;
                            break;
                        }
                    }
                    
                    if(i == 1){//D
                        if(!(enteredOrderID.charAt(i) == 'D')){ // if not O
                            orderIDValidity = false;
                            break;
                        }
                    }
                    
                    if(i == 2){//A-Z
                        if(!Character.isLetter(enteredOrderID.charAt(i))){
                            orderIDValidity = false;
                            break;
                        }
                    }
                    
                    if(i != 0 && i != 1 && i != 2){ //0-9
                        if(!Character.isDigit(enteredOrderID.charAt(i))){
                            orderIDValidity = false;
                            break;
                        }
                    }
                }
                
                if(!orderIDValidity){
                    JOptionPane.showMessageDialog(null, "OrderID is invalid.", "Invalid Order ID", JOptionPane.WARNING_MESSAGE);
                    jtfOrderID.requestFocusInWindow();
                }
                //*************************************************
                
                //Validation for TripNo^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                //length check
                if(enteredTripNo.length() != 15){
                    tripNoValidity = false;
                }
                
                for(int i = 0; i < enteredTripNo.length(); i++){
                    if(i == 0 || i == 1 || i == 2 || i == 3){ //ROUTEID XXXX (alphabets)
                        if(!Character.isLetter(enteredTripNo.charAt(i))){
                            tripNoValidity = false;
                            break;
                        }
                    }
                    
                    if(i == 4){
                        if(!(enteredTripNo.charAt(i) == 'D' || enteredTripNo.charAt(4) == 'S')){ //BUS type, S - single deck or D - double deck
                            tripNoValidity = false;
                            break;
                        }
                    }
                    
                    if(i > 4){
                        if(!Character.isDigit(enteredTripNo.charAt(i))){
                            tripNoValidity = false;
                            break;
                        }
                    }
                }
                
                if(!tripNoValidity){
                    JOptionPane.showMessageDialog(null, "Trip No is invalid.", "Invalid Trip No", JOptionPane.WARNING_MESSAGE);
                    jtfTripNo.requestFocusInWindow();
                }
                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                
                //Validation for SeatNozzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
                //length check
                if(enteredSeatNo.length() != 4){
                    seatNoValidity = false;
                }
                
                for(int i = 0; i < enteredSeatNo.length(); i++){
                    if(i == 0){
                        if(!(enteredSeatNo.charAt(i) == 'S')){
                            seatNoValidity = false;
                            break;
                        }
                    }
                    
                    if(i == 1){
                        if(!(enteredSeatNo.charAt(i) == 'A')){
                            seatNoValidity = false;
                            break;
                        }
                    }
                    
                    if(i > 1){
                        if(!Character.isDigit(enteredSeatNo.charAt(i))){
                            seatNoValidity = false;
                            break;
                        }
                    }
                }
                
                if(!seatNoValidity){
                    JOptionPane.showMessageDialog(null, "Seat No is invalid.", "Invalid Seat No", JOptionPane.WARNING_MESSAGE);
                    jtfSeatNo.requestFocusInWindow();
                }
                //zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
                
                
                if(orderIDValidity && seatNoValidity && tripNoValidity){
                    tripSeatOld = new TripSeat2();
                    OrderLine ol = new OrderLine();
                    ol.setOrderID(enteredOrderID);
                    Trip trip = new Trip();
                    trip.setTripno(enteredTripNo);
                    Seat seat = new Seat();
                    seat.setSeatno(enteredSeatNo);
                    tripSeatOld.setOrderLine(ol);
                    tripSeatOld.setSeat(seat);
                    tripSeatOld.setTrip(trip);

                    //remove all combo box selections
                    dcbomTripNo.removeAllElements();

                    //retrieve current informarion
                    TripSeat2 tripSeatResult;

                    tripSeatResult = ticketControl.initiateTicketChange(tripSeatOld); //throw this object in to getSelectableTrips, origin, destination required in tripSeatResult.

                    if(tripSeatResult != null){
                        jcbTripNo.setEnabled(true);
                        tripSeatList = ticketControl.getSelectableTrips(tripSeatResult); //used in combo box

                        //set textfields
                        jtfOrigin.setText(tripSeatResult.getTrip().getRoute().getOrigin());
                        jtfDestination.setText(tripSeatResult.getTrip().getRoute().getDestination());
                        jtfCurDepDate.setText(dateFormat.format(tripSeatResult.getTrip().getDepartdate()));
                        jtfCurDepTime.setText(tripSeatResult.getTrip().getDeparttime());
                        jtfCurSeatNo.setText(tripSeatResult.getSeat().getSeatno());

                        //feed combo box
                         //add - to combo box --> position 0
                        dcbomTripNo.addElement("-");
                        jcbTripNo.setSelectedIndex(0);

                        for(int i = 0; i < tripSeatList.size(); i++){


                        System.out.println("This is in jbtRead. Now is: "+tripSeatList.get(i).getTrip().getTripno());
                        dcbomTripNo.addElement(tripSeatList.get(i).getTrip().getTripno());


                        }

                        ///////////////Date CHecking PARt/////////////////////////////////////////////////////
                        String curDepartDate = dateFormat.format(tripSeatResult.getTrip().getDepartdate());
                        Calendar cal = Calendar.getInstance();
                        Calendar calTwo = Calendar.getInstance();

                        //cal --> get the day month year only
                        try{
                            cal.setTime(dateFormat.parse(curDepartDate));
                        }
                        catch(Exception ex){
                            System.out.println("curDepartDate Parsing Failed, by SimpleDateFormat formatter dateFormat.");
                        }
                        cal.add(Calendar.DATE, -2);  // 2 days to minus

                        String thresholdDateStr = dateFormat.format(cal.getTime());  // unused DATE ONLY NO TIME


                        // set the threshold date obtained from cal just now, plus setting time to 23:59:59, otherwise the exact 2days before will not be allowed to change ticket because system will default to 00:00:00 which is 12am if time of the threshold date is not manually set to 23:59:59
                        try{
                            calTwo.setTime(dateTimeFormat.parse(thresholdDateStr+" "+"23:59:59"));
                        }
                        catch(Exception ex){
                            System.out.println("thresholdDate and Time Parsing Failed, by SimpleDateFormat formatter dateTimeFormat.");
                        }




                        // actual thresholdDate object used for comparison, will use the result from calTwo instead of cal, so that it is more accurate and logic
                        java.util.Date thresholdDate = calTwo.getTime();

                        //test
                        System.out.println("Threshold Date: " + thresholdDate);

                        //checking starts
                        String todayDateStr = dateFormat.format(new java.util.Date()); //unused
                        java.util.Date todayDate = new java.util.Date();

                        //test
                        System.out.println("Today Date: " + todayDate);

                        //comparing now
                        if(todayDate.before(thresholdDate) || todayDate.equals(thresholdDate)){
                            //the departure date of the ori ticket must be at least 2 days ahead
                            //do nothing in back end, allows continue process
                        }
                        else{
                            //do not fulfil requirement
                            JOptionPane.showMessageDialog(null, "The particular ticket cannot be changed.\nThe specified ticket did not fullfil the requirement because\n the departure date of the specified ticket is less than two days from now.", "Less Than Two Days", JOptionPane.WARNING_MESSAGE);
                            resetPage();
                        }


                        }
                        else{
                            JOptionPane.showMessageDialog(null, "The particular ticket cannot be found.\nPlease re-enter the above information to search again.", "Ticket Not Found", JOptionPane.WARNING_MESSAGE);
                            jtfOrderID.requestFocusInWindow();
                            jcbTripNo.setEnabled(false);
                        }
                }
                else{
                    //do nothing, because message already shown previously
                }
                
                
            }
            else if(e.getSource() == jbtReset){
//                jtfOrderID.setText("");
//                jtfTripNo.setText("");
//                jtfSeatNo.setText("");
//                jtfCurDepDate.setText("");
//                jtfCurDepTime.setText("");
//                jtfCurSeatNo.setText("");
//                jtfNewDepDate.setText("");
//                jtfNewDepTime.setText("");
//                jtfNewSeatNo.setText("");
//                jcbTripNo.setEnabled(false);
//                jbtConfirm.setEnabled(false);
//                jtfOrderID.requestFocusInWindow();
                resetPage();
            }
            else if(e.getSource() == jbtConfirm){
                int result;
                result = ticketControl.saveTicketChanges(tripSeatOld, tripSeatNew); //the data in tripSeatNew is saved at the end of the check box listener
                
                if(result > 0){
                    JOptionPane.showMessageDialog(null, "The ticket change has been processed successfully.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    resetPage();
                    ////Link To//////Yi Ting///////Print Ticket, use tripSeatNew, is a TripSeat2 object.
                    //tripSeatNew.getOrderLine().getOrderID();
                    //tripSeatNew.getTrip().getTripno();
                    //tripSeatNew.getSeat().getSeatno();
                    
                    //DONOT use the tripSeat.getTripno() or tripSeat.getSeatno(), they are unused.
                }
                else{
                    JOptionPane.showMessageDialog(null, "The ticket change has failed", "Failed", JOptionPane.ERROR_MESSAGE);
                    jtfOrderID.requestFocusInWindow();
                }
            }
            else if(e.getSource() == jbtCancel){
                int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Ticket Purchasing Submenu?", "Confirm?", JOptionPane.WARNING_MESSAGE);
                if(confirm == JOptionPane.YES_OPTION){
                    ticketControl.closeDB();
                    dispose();
                    new TicketPurchasingMenu(accType);
            }
        }
    }
}
    
    private class ComboBoxListener implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            // change the new info textfields according to the selection of the combo box
            
            if(jcbTripNo.getSelectedIndex() == 0 || jcbTripNo.getSelectedIndex() == -1 ){
                jbtConfirm.setEnabled(false);
                jtfNewDepDate.setText("");
                jtfNewDepTime.setText("");
                jtfNewSeatNo.setText("");
            }
            else{
                //selected trip no
                String selTripNo = tripSeatList.get(jcbTripNo.getSelectedIndex()-1).getTrip().getTripno(); //minus one, to compensate for the "-" in position one
                
                //test
                for(int i = 0; i < tripSeatList.size(); i++){
                    System.out.println("tripSeatList.get("+i+")"+": "+tripSeatList.get(i).getTrip().getTripno());
                }
                
                System.out.println("Hallo, This is itemListener selTripNo: "+selTripNo);

                //container
                TripSeat2 tripSeatIn = new TripSeat2();
                Trip tripNewIn = new Trip();
                tripNewIn.setTripno(selTripNo);
                tripSeatIn.setTrip(tripNewIn);

                //container for result(s)
                ArrayList<TripSeat2> tripSeatRList;

                tripSeatRList = ticketControl.getSelectedTrip(tripSeatIn);

                //next SeatNo is selected and assigned automatically.
                String nextSeatNo = tripSeatRList.get(0).getSeat().getSeatno();

                String newDepDate = dateFormat.format(tripSeatRList.get(0).getTrip().getDepartdate());
                String newDepTime = tripSeatRList.get(0).getTrip().getDeparttime();

                //Set textfields for new ticket information
                jtfNewDepDate.setText(newDepDate);
                jtfNewDepTime.setText(newDepTime);
                jtfNewSeatNo.setText(nextSeatNo);

                //enable the confirm button
                jbtConfirm.setEnabled(true);

                //save the currently selected trip into a class variable for the confirm button and also the printing of new ticket
                //save tripNo (NEW)
    //            Trip tripNewIn = new Trip();
    //            tripNewIn.setTripno(selTripNo);
    //            tripSeatNew = new TripSeat2();
    //            tripSeatNew.setTrip(tripNewIn);
    //            
    //            //save new seatNo
    //            Seat seatIn = new Seat();
    //            seatIn = new Seat();
    //            seatIn.setSeatno(nextSeatNo);
    //            tripSeatNew.setSeat(seatIn);

                //new data to be passed together with the old data to be replaced

                //save the new ticket information into the tripSeatNew class variable to be used by jbtConfirm
                //instantiate the TripSeat2 container first
                tripSeatNew = new TripSeat2();

                Trip newTrip = new Trip();
                newTrip.setTripno(selTripNo);
                Seat newSeat = new Seat();
                newSeat.setSeatno(nextSeatNo);
                tripSeatNew.setTrip(newTrip);
                tripSeatNew.setSeat(newSeat);
            }
        }
    }
    
    private void resetPage(){
        jtfOrderID.setText("");
        jtfTripNo.setText("");
        jtfSeatNo.setText("");
        jtfOrigin.setText("");
        jtfDestination.setText("");
        jtfCurDepDate.setText("");
        jtfCurDepTime.setText("");
        jtfCurSeatNo.setText("");
        jtfNewDepDate.setText("");
        jtfNewDepTime.setText("");
        jtfNewSeatNo.setText("");
        dcbomTripNo.removeAllElements();
        dcbomTripNo.addElement("-");
        //test
        System.out.println("Tesla 1");
        jcbTripNo.setSelectedIndex(-1);
        jcbTripNo.setEnabled(false);
        System.out.println("Tesla 2");
        jbtConfirm.setEnabled(false);
        jtfOrderID.requestFocusInWindow();
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Ticket Purchasing Submenu?", "Confirm?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                ticketControl.closeDB();
                //orderControl.closeDB();
                dispose();
                new TicketPurchasingMenu(accType);
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new TicketChangePage('U');
    }
    
}