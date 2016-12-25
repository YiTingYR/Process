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
import java.util.ArrayList;
import control.*;

public class SeatSelection extends JFrame{
    
    private char accType;
    
    private int reqQuantity;
    
    private String tripNo;
    
    private String orderID;
    
    //seat Counter
    //private int seatCounter = 0;
    
    //seat Array
    ArrayList<String> selectedSeatNo; //may be not used
    
    private MaintainTripSeat tripSeatControl;
    
    private ArrayList<TripSeat2> tripSeatList;
    
    private ArrayList<OrderLine> orderLineList;
    
    private JLabel jlbTitle = new JLabel("Seat Selection");
    private JLabel jlbInstr = new JLabel("Please choose the seat(s) by ticking the checkboxes beside the desired seat.");
    
    
    private JPanel jpLowDeck =  new JPanel(new GridLayout(10,1));
    private JPanel jpUpDeck =  new JPanel(new GridLayout(10,1));
    
    private JPanel jpLowDeck_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpLowDeck_r10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    private JPanel jpUpDeck_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel jpUpDeck_r10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    private JPanel jpSOUTH = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
    
    private JButton jbtOK = new JButton("OK");
    private JButton jbtCancel = new JButton("Cancel");
    
//    private JCheckBox jchkSA01 = new JCheckBox();
//    private JCheckBox jchkSA02 = new JCheckBox();
//    private JCheckBox jchkSA03 = new JCheckBox();
//    private JCheckBox jchkSA04 = new JCheckBox();
//    private JCheckBox jchkSA05 = new JCheckBox();
//    private JCheckBox jchkSA06 = new JCheckBox();
//    private JCheckBox jchkSA07 = new JCheckBox();
//    private JCheckBox jchkSA08 = new JCheckBox();
//    private JCheckBox jchkSA09 = new JCheckBox();
//    private JCheckBox jchkSA10 = new JCheckBox();
//    private JCheckBox jchkSA11 = new JCheckBox();
//    private JCheckBox jchkSA12 = new JCheckBox();
//    private JCheckBox jchkSA13 = new JCheckBox();
//    private JCheckBox jchkSA14 = new JCheckBox();
//    private JCheckBox jchkSA15 = new JCheckBox();
//    private JCheckBox jchkSA16 = new JCheckBox();
//    private JCheckBox jchkSA17 = new JCheckBox();
//    private JCheckBox jchkSA18 = new JCheckBox();
//    private JCheckBox jchkSA19 = new JCheckBox();
//    private JCheckBox jchkSA20 = new JCheckBox();
//    private JCheckBox jchkSA21 = new JCheckBox();
//    private JCheckBox jchkSA22 = new JCheckBox();
//    private JCheckBox jchkSA23 = new JCheckBox();
//    private JCheckBox jchkSA24 = new JCheckBox();
//    private JCheckBox jchkSA25 = new JCheckBox();
//    private JCheckBox jchkSA26 = new JCheckBox();
//    private JCheckBox jchkSA27 = new JCheckBox();
//    private JCheckBox jchkSA28 = new JCheckBox();
//    private JCheckBox jchkSA29 = new JCheckBox();
//    private JCheckBox jchkSA30 = new JCheckBox();
//    private JCheckBox jchkSA31 = new JCheckBox();
//    private JCheckBox jchkSA32 = new JCheckBox();
//    private JCheckBox jchkSA33 = new JCheckBox();
//    private JCheckBox jchkSA34 = new JCheckBox();
//    private JCheckBox jchkSA35 = new JCheckBox();
//    private JCheckBox jchkSA36 = new JCheckBox();
//    private JCheckBox jchkSA37 = new JCheckBox();
//    private JCheckBox jchkSA38 = new JCheckBox();
//    private JCheckBox jchkSA39 = new JCheckBox();
//    private JCheckBox jchkSA40 = new JCheckBox();
//    private JCheckBox jchkSA41 = new JCheckBox();
//    private JCheckBox jchkSA42 = new JCheckBox();
//    private JCheckBox jchkSA43 = new JCheckBox();
//    private JCheckBox jchkSA44 = new JCheckBox();
//    private JCheckBox jchkSA45 = new JCheckBox();
//    private JCheckBox jchkSA46 = new JCheckBox();
//    private JCheckBox jchkSA47 = new JCheckBox();
//    private JCheckBox jchkSA48 = new JCheckBox();
//    private JCheckBox jchkSA49 = new JCheckBox();
//    private JCheckBox jchkSA50 = new JCheckBox();
//    private JCheckBox jchkSA51 = new JCheckBox();
//    private JCheckBox jchkSA52 = new JCheckBox();
//    private JCheckBox jchkSA53 = new JCheckBox();
//    private JCheckBox jchkSA54 = new JCheckBox();
    
    //We change it to array for better processing
    private JCheckBox[] jchkSeatArr = new JCheckBox[54];
    
    private ImageIcon iconAvail = new ImageIcon(getClass().getResource("../images/available40x40.jpg"));
    private ImageIcon iconOccupied = new ImageIcon(getClass().getResource("../images/occupied40x40.jpg"));
    private ImageIcon iconSelected = new ImageIcon(getClass().getResource("../images/selected40x40.jpg"));
    private ImageIcon iconOrdered = new ImageIcon(getClass().getResource("../images/ordered40x40.png")); //for ordered seat for the same trip but not yet paid
    
//    private JLabel jlbSA01 = new JLabel("SA01", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA02 = new JLabel("SA02", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA03 = new JLabel("SA03", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA04 = new JLabel("SA04", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA05 = new JLabel("SA05", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA06 = new JLabel("SA06", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA07 = new JLabel("SA07", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA08 = new JLabel("SA08", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA09 = new JLabel("SA09", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA10 = new JLabel("SA10", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA11 = new JLabel("SA11", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA12 = new JLabel("SA12", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA13 = new JLabel("SA13", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA14 = new JLabel("SA14", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA15 = new JLabel("SA15", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA16 = new JLabel("SA16", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA17 = new JLabel("SA17", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA18 = new JLabel("SA18", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA19 = new JLabel("SA19", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA20 = new JLabel("SA20", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA21 = new JLabel("SA21", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA22 = new JLabel("SA22", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA23 = new JLabel("SA23", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA24 = new JLabel("SA24", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA25 = new JLabel("SA25", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA26 = new JLabel("SA26", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA27 = new JLabel("SA27", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA28 = new JLabel("SA28", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA29 = new JLabel("SA29", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA30 = new JLabel("SA30", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA31 = new JLabel("SA31", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA32 = new JLabel("SA32", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA33 = new JLabel("SA33", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA34 = new JLabel("SA34", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA35 = new JLabel("SA35", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA36 = new JLabel("SA36", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA37 = new JLabel("SA37", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA38 = new JLabel("SA38", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA39 = new JLabel("SA39", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA40 = new JLabel("SA40", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA41 = new JLabel("SA41", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA42 = new JLabel("SA42", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA43 = new JLabel("SA43", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA44 = new JLabel("SA44", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA45 = new JLabel("SA45", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA46 = new JLabel("SA46", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA47 = new JLabel("SA47", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA48 = new JLabel("SA48", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA49 = new JLabel("SA49", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA50 = new JLabel("SA50", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA51 = new JLabel("SA51", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA52 = new JLabel("SA52", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA53 = new JLabel("SA53", iconAvail, SwingConstants.CENTER);
//    private JLabel jlbSA54 = new JLabel("SA54", iconAvail, SwingConstants.CENTER);
    
    private JLabel[] jlbSeatArr = new JLabel[54];
   
    private ImageIcon iconBusDoor = new ImageIcon(getClass().getResource("../images/busDoor35x28.jpg"));
    private ImageIcon iconDriver = new ImageIcon(getClass().getResource("../images/driver.jpg"));
    private ImageIcon iconStairs = new ImageIcon(getClass().getResource("../images/stairs35x35.jpg"));
    
    private JLabel jlbExit = new JLabel("Exit", iconBusDoor, SwingConstants.CENTER);
    private JLabel jlbDriver = new JLabel("Driver", iconDriver, SwingConstants.CENTER);
    private JLabel jlbStairs = new JLabel("Stairs", iconStairs, SwingConstants.CENTER);
    private JLabel jlbStairs2 = new JLabel("Stairs", iconStairs, SwingConstants.CENTER);

    private JTabbedPane jtpSeats = new JTabbedPane();
    
    private JPanel global = new JPanel(new BorderLayout()){  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     ShowAvailableTrips.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    public SeatSelection(){
        
    }
    public SeatSelection(char accType, int quantity, String tripNo, String orderID, ArrayList orderLineList){
        
        this.tripNo = tripNo;
        
        tripSeatControl = new MaintainTripSeat();
        
        this.accType = accType;
        
        this.reqQuantity = quantity;
        
        this.orderID = orderID;
        
        this.orderLineList = orderLineList;
        
        selectedSeatNo = new ArrayList<>();
        
        //initialization///////////////////////////////
        for(int i = 0; i < jchkSeatArr.length; i++){
            jchkSeatArr[i] = new JCheckBox();
        }
        
        for(int k = 0; k < jlbSeatArr.length; k++){
            String number = String.valueOf((k+1));
            
            if(number.length() != 2){
                number = "0" + number;
            }
            jlbSeatArr[k] = new JLabel("SA"+number,iconAvail,SwingConstants.CENTER);
        }
        ////////////////////////////////////////////////////////////////////////////
        
        
        
//        for(JLabel jlb:jlbSeatArr){
//            jlb = new JLabel("SA"+(i+1))
//        }
        
//        jtpSeats.setOpaque(false);
//        jpLowDeck.setOpaque(false);
//        jpUpDeck.setOpaque(false);
//        jpLowDeck_r1.setOpaque(false);
//        jpLowDeck_r2.setOpaque(false);
//        jpLowDeck_r3.setOpaque(false);
//        jpLowDeck_r4.setOpaque(false);
//        jpLowDeck_r5.setOpaque(false);
//        jpLowDeck_r6.setOpaque(false);
//        jpLowDeck_r7.setOpaque(false);
//        jpLowDeck_r8.setOpaque(false);
//        jpLowDeck_r9.setOpaque(false);
//        jpLowDeck_r10.setOpaque(false);
        jpSOUTH.setOpaque(false);
        
//        //set names for each JLabel
//        jlbSA01.setName("jlbSA01");
//        
//        //set names for each JCheckBox
//        jchkSA01.setName("jchkSA01");
        
        //register JCheckbox with ItemEvent >ARR
        //jchkSA01.addItemListener(new CheckBoxListener());
        for(JCheckBox jchk:jchkSeatArr){
            jchk.addItemListener(new CheckBoxListener());
        }
        
        //Lower Deck
        jpLowDeck_r1.add(jlbExit);
        jpLowDeck_r1.add(new JLabel("                                                                                                                                       "));
        jpLowDeck_r1.add(jlbDriver);
        jpLowDeck_r2.add(jlbStairs);
        jpLowDeck_r3.add(jlbSeatArr[0]);
        jpLowDeck_r3.add(jchkSeatArr[0]);
        jpLowDeck_r3.add(new JLabel("                                                                       "));
        jpLowDeck_r3.add(jlbSeatArr[8]);
        jpLowDeck_r3.add(jchkSeatArr[8]);
        jpLowDeck_r3.add(new JLabel("           "));
        jpLowDeck_r3.add(jlbSeatArr[16]);
        jpLowDeck_r3.add(jchkSeatArr[16]);
        jpLowDeck_r4.add(jlbSeatArr[1]);
        jpLowDeck_r4.add(jchkSeatArr[1]);
        jpLowDeck_r4.add(new JLabel("                                                                       "));
        jpLowDeck_r4.add(jlbSeatArr[9]);
        jpLowDeck_r4.add(jchkSeatArr[9]);
        jpLowDeck_r4.add(new JLabel("           "));
        jpLowDeck_r4.add(jlbSeatArr[17]);
        jpLowDeck_r4.add(jchkSeatArr[17]);
        jpLowDeck_r5.add(jlbSeatArr[2]);
        jpLowDeck_r5.add(jchkSeatArr[2]);
        jpLowDeck_r5.add(new JLabel("                                                                       "));
        jpLowDeck_r5.add(jlbSeatArr[10]);
        jpLowDeck_r5.add(jchkSeatArr[10]);
        jpLowDeck_r5.add(new JLabel("           "));
        jpLowDeck_r5.add(jlbSeatArr[18]);
        jpLowDeck_r5.add(jchkSeatArr[18]);
        jpLowDeck_r6.add(jlbSeatArr[3]);
        jpLowDeck_r6.add(jchkSeatArr[3]);
        jpLowDeck_r6.add(new JLabel("                                                                       "));
        jpLowDeck_r6.add(jlbSeatArr[11]);
        jpLowDeck_r6.add(jchkSeatArr[11]);
        jpLowDeck_r6.add(new JLabel("           "));
        jpLowDeck_r6.add(jlbSeatArr[19]);
        jpLowDeck_r6.add(jchkSeatArr[19]);
        jpLowDeck_r7.add(jlbSeatArr[4]);
        jpLowDeck_r7.add(jchkSeatArr[4]);
        jpLowDeck_r7.add(new JLabel("                                                                       "));
        jpLowDeck_r7.add(jlbSeatArr[12]);
        jpLowDeck_r7.add(jchkSeatArr[12]);
        jpLowDeck_r7.add(new JLabel("           "));
        jpLowDeck_r7.add(jlbSeatArr[20]);
        jpLowDeck_r7.add(jchkSeatArr[20]);
        jpLowDeck_r8.add(jlbSeatArr[5]);
        jpLowDeck_r8.add(jchkSeatArr[5]);
        jpLowDeck_r8.add(new JLabel("                                                                       "));
        jpLowDeck_r8.add(jlbSeatArr[13]);
        jpLowDeck_r8.add(jchkSeatArr[13]);
        jpLowDeck_r8.add(new JLabel("           "));
        jpLowDeck_r8.add(jlbSeatArr[21]);
        jpLowDeck_r8.add(jchkSeatArr[21]);
        jpLowDeck_r9.add(jlbSeatArr[6]);
        jpLowDeck_r9.add(jchkSeatArr[6]);
        jpLowDeck_r9.add(new JLabel("                                                                       "));
        jpLowDeck_r9.add(jlbSeatArr[14]);
        jpLowDeck_r9.add(jchkSeatArr[14]);
        jpLowDeck_r9.add(new JLabel("           "));
        jpLowDeck_r9.add(jlbSeatArr[22]);
        jpLowDeck_r9.add(jchkSeatArr[22]);
        jpLowDeck_r10.add(jlbSeatArr[7]);
        jpLowDeck_r10.add(jchkSeatArr[7]);
        jpLowDeck_r10.add(new JLabel("                                                                       "));
        jpLowDeck_r10.add(jlbSeatArr[15]);
        jpLowDeck_r10.add(jchkSeatArr[15]);
        jpLowDeck_r10.add(new JLabel("           "));
        jpLowDeck_r10.add(jlbSeatArr[23]);
        jpLowDeck_r10.add(jchkSeatArr[23]);
        
        jpLowDeck.add(jpLowDeck_r1);
        jpLowDeck.add(jpLowDeck_r2);
        jpLowDeck.add(jpLowDeck_r3);
        jpLowDeck.add(jpLowDeck_r4);
        jpLowDeck.add(jpLowDeck_r5);
        jpLowDeck.add(jpLowDeck_r6);
        jpLowDeck.add(jpLowDeck_r7);
        jpLowDeck.add(jpLowDeck_r8);
        jpLowDeck.add(jpLowDeck_r9);
        jpLowDeck.add(jpLowDeck_r10);
        
        //Upper Deck
        //jpUpDeck_r1.add(jlbExit);
        jpUpDeck_r1.add(new JLabel("                                                                                                         "));
        jpUpDeck_r1.add(jlbSeatArr[34]);
        jpUpDeck_r1.add(jchkSeatArr[34]);
        jpUpDeck_r1.add(new JLabel("           "));
        jpUpDeck_r1.add(jlbSeatArr[44]);
        jpUpDeck_r1.add(jchkSeatArr[44]);
        jpUpDeck_r2.add(jlbStairs2);
        jpUpDeck_r2.add(new JLabel("                                                                                "));
        jpUpDeck_r2.add(jlbSeatArr[35]);
        jpUpDeck_r2.add(jchkSeatArr[35]);
        jpUpDeck_r2.add(new JLabel("          "));
        jpUpDeck_r2.add(jlbSeatArr[45]);
        jpUpDeck_r2.add(jchkSeatArr[45]);
        jpUpDeck_r3.add(jlbSeatArr[24]);
        jpUpDeck_r3.add(jchkSeatArr[24]);
        jpUpDeck_r3.add(new JLabel("                                                                       "));
        jpUpDeck_r3.add(jlbSeatArr[36]);
        jpUpDeck_r3.add(jchkSeatArr[36]);
        jpUpDeck_r3.add(new JLabel("           "));
        jpUpDeck_r3.add(jlbSeatArr[46]);
        jpUpDeck_r3.add(jchkSeatArr[46]);
        jpUpDeck_r4.add(jlbSeatArr[25]);
        jpUpDeck_r4.add(jchkSeatArr[25]);
        jpUpDeck_r4.add(new JLabel("                                                                       "));
        jpUpDeck_r4.add(jlbSeatArr[37]);
        jpUpDeck_r4.add(jchkSeatArr[37]);
        jpUpDeck_r4.add(new JLabel("           "));
        jpUpDeck_r4.add(jlbSeatArr[47]);
        jpUpDeck_r4.add(jchkSeatArr[47]);
        jpUpDeck_r5.add(jlbSeatArr[26]);
        jpUpDeck_r5.add(jchkSeatArr[26]);
        jpUpDeck_r5.add(new JLabel("                                                                       "));
        jpUpDeck_r5.add(jlbSeatArr[38]);
        jpUpDeck_r5.add(jchkSeatArr[38]);
        jpUpDeck_r5.add(new JLabel("           "));
        jpUpDeck_r5.add(jlbSeatArr[48]);
        jpUpDeck_r5.add(jchkSeatArr[48]);
        jpUpDeck_r6.add(jlbSeatArr[27]);
        jpUpDeck_r6.add(jchkSeatArr[27]);
        jpUpDeck_r6.add(new JLabel("                                                                       "));
        jpUpDeck_r6.add(jlbSeatArr[39]);
        jpUpDeck_r6.add(jchkSeatArr[39]);
        jpUpDeck_r6.add(new JLabel("           "));
        jpUpDeck_r6.add(jlbSeatArr[49]);
        jpUpDeck_r6.add(jchkSeatArr[49]);
        jpUpDeck_r7.add(jlbSeatArr[28]);
        jpUpDeck_r7.add(jchkSeatArr[28]);
        jpUpDeck_r7.add(new JLabel("                                                                       "));
        jpUpDeck_r7.add(jlbSeatArr[40]);
        jpUpDeck_r7.add(jchkSeatArr[40]);
        jpUpDeck_r7.add(new JLabel("           "));
        jpUpDeck_r7.add(jlbSeatArr[50]);
        jpUpDeck_r7.add(jchkSeatArr[50]);
        jpUpDeck_r8.add(jlbSeatArr[29]);
        jpUpDeck_r8.add(jchkSeatArr[29]);
        jpUpDeck_r8.add(new JLabel("                                                                       "));
        jpUpDeck_r8.add(jlbSeatArr[41]);
        jpUpDeck_r8.add(jchkSeatArr[41]);
        jpUpDeck_r8.add(new JLabel("           "));
        jpUpDeck_r8.add(jlbSeatArr[51]);
        jpUpDeck_r8.add(jchkSeatArr[51]);
        jpUpDeck_r9.add(jlbSeatArr[30]);
        jpUpDeck_r9.add(jchkSeatArr[30]);
        jpUpDeck_r9.add(new JLabel("    "));
        jpUpDeck_r9.add(jlbSeatArr[32]);
        jpUpDeck_r9.add(jchkSeatArr[32]);
        jpUpDeck_r9.add(new JLabel("                               "));
        jpUpDeck_r9.add(jlbSeatArr[42]);
        jpUpDeck_r9.add(jchkSeatArr[42]);
        jpUpDeck_r9.add(new JLabel("           "));
        jpUpDeck_r9.add(jlbSeatArr[52]);
        jpUpDeck_r9.add(jchkSeatArr[52]);
        jpUpDeck_r10.add(jlbSeatArr[31]);
        jpUpDeck_r10.add(jchkSeatArr[31]);
        jpUpDeck_r10.add(new JLabel("    "));
        jpUpDeck_r10.add(jlbSeatArr[33]);
        jpUpDeck_r10.add(jchkSeatArr[33]);
        jpUpDeck_r10.add(new JLabel("                               "));
        jpUpDeck_r10.add(jlbSeatArr[43]);
        jpUpDeck_r10.add(jchkSeatArr[43]);
        jpUpDeck_r10.add(new JLabel("           "));
        jpUpDeck_r10.add(jlbSeatArr[53]);
        jpUpDeck_r10.add(jchkSeatArr[53]);
        
        jpUpDeck.add(jpUpDeck_r1);
        jpUpDeck.add(jpUpDeck_r2);
        jpUpDeck.add(jpUpDeck_r3);
        jpUpDeck.add(jpUpDeck_r4);
        jpUpDeck.add(jpUpDeck_r5);
        jpUpDeck.add(jpUpDeck_r6);
        jpUpDeck.add(jpUpDeck_r7);
        jpUpDeck.add(jpUpDeck_r8);
        jpUpDeck.add(jpUpDeck_r9);
        jpUpDeck.add(jpUpDeck_r10);
        
        
        jpSOUTH.add(jbtOK);
        jpSOUTH.add(jbtCancel);
        
        jtpSeats.add("Lower Deck", jpLowDeck);
        jtpSeats.add("Upper Deck", jpUpDeck);
        
        global.add(jtpSeats, BorderLayout.CENTER);
        global.add(jpSOUTH, BorderLayout.SOUTH);
        
        
        setLayout(new BorderLayout());
        add(global,BorderLayout.CENTER);
        
        
        
        //test trace string received
        System.out.println("The tripNo received in SeatSelection is: "+tripNo);
        
        ///Initialization and setting of seat labels and checkboxes
        TripSeat2 tsTemp = new TripSeat2();
        tsTemp.setTripNo(this.tripNo);
        
        tripSeatList = tripSeatControl.getRecord(tsTemp);
        
        System.out.println("The size of tripSeatList is: "+tripSeatList.size());
        
//        int numberOfSeats = 0; //XAXAXAXAXA
//        numberOfSeats = tripSeatList.size();
//        
//        if(numberOfSeats == 24){ //single deck bus --> 24 seats only   //INITIALIZE SEATS
//            for(int i = 0; i < tripSeatList.size(); i++){ //0 - 23
//                if(tripSeatList.get(i).getSeatAvailability() == 'Y'){ //seat available
//                    jlbSeatArr[i].setIcon(iconAvail);
//                    jchkSeatArr[i].setEnabled(true);
//                }
//                else{ //seatAvailability is 'N', seat not available
//                    jlbSeatArr[i].setIcon(iconOccupied);
//                    jchkSeatArr[i].setEnabled(false);
//                }
//            }
//            
//            //deselect and disable all upper deck checkboxes
//            for(int j = 24; j < jchkSeatArr.length; j++){
//                jchkSeatArr[j].setSelected(false);
//                jchkSeatArr[j].setEnabled(false);
//            }
//            
//            //remove upper deck tab
//            jtpSeats.remove(jpUpDeck);
//        }
//        else{ //double deck bus --> 54 seats
//            for(int i = 0; i < tripSeatList.size(); i++){
//                if(tripSeatList.get(i).getSeatAvailability() == 'Y'){ //seat available
////                    jlbSeatArr[i].setIcon(iconAvail);
////                    jchkSeatArr[i].setEnabled(true);
////                    for(int r = 0; r < orderLineList.size(); r++){//*****
////                        
////                        if(orderLineList.size() != 0){ //first run the orderLineList is empty
////                            if(this.orderLineList.get(r).getTripNo().equals(tripNo) && this.orderLineList.get(r).getSeatNo().equals(tripSeatList.get(i).getSeatNo())){//this is the constructor where the original list is passed in, officialy there are two list, one local variable, one class variable, thus this. is required.
////                                //means seat is available in tripseat table, but ordered in order cart, not yet paid, also cannot be chosen any more.
////                                //applicable when the seat selection for the same trip is opened again.
////                                jlbSeatArr[i].setIcon(iconOrdered);
////                                jchkSeatArr[i].setEnabled(false);
////                            }////
////                        }
////                        else{ //seat still available even the seat selection screen for the same trip is reopened
////                            
////                            jlbSeatArr[i].setIcon(iconAvail);
////                            jchkSeatArr[i].setEnabled(true);
////                        }
////                    
////                    
////                    }//***
//                    if(!orderLineList.isEmpty()){ //Revamped
//                        for(int c = 0; c < orderLineList.size(); c++){
//                            for(int l = 0; l < tripSeatList.size(); l++){
//                                if(tripSeatList.get(l).getTripNo().equals(this.orderLineList.get(c).getTripNo()) && tripSeatList.get(l).getSeatNo().equals(this.orderLineList.get(c).getSeatNo())){
//                                    jlbSeatArr[l].setIcon(iconOrdered);
//                                    jchkSeatArr[l].setEnabled(false);
//                                }
//                                else{
//                                    jlbSeatArr[l].setIcon(iconAvail);
//                                    jchkSeatArr[l].setEnabled(true);
//                                }
//                            }
//                        }
//                    }
//                }//****
//                else{ //seatAvailability is 'N', seat not available
//                    jlbSeatArr[i].setIcon(iconOccupied);
//                    jchkSeatArr[i].setEnabled(false);
//                }//*****
//            }//******
//        }/XAXAXAXAX
        
//        if(!orderLineList.isEmpty()){ //Revamped //Subsequent run(s) //GG also
//            for(int c = 0; c < orderLineList.size(); c++){
//                for(int l = 0; l < tripSeatList.size(); l++){
//                    if(this.tripSeatList.get(l).getSeatAvailability() == 'Y'){
//                        if(tripSeatList.get(l).getTripNo().equals(this.orderLineList.get(c).getTripNo()) && tripSeatList.get(l).getSeatNo().equals(this.orderLineList.get(c).getSeatNo())){
//                            jlbSeatArr[l].setIcon(iconOrdered);
//                            jchkSeatArr[l].setEnabled(false);
//                        }
//                        else{
//                            jlbSeatArr[l].setIcon(iconAvail);
//                            jchkSeatArr[l].setEnabled(true);
//                        }
//                    }
//                    else{
//                        jlbSeatArr[l].setIcon(iconOccupied);
//                        jchkSeatArr[l].setEnabled(false);
//                    }
//                }
//            }
//        } //GG also
//        else{ //first run //GG also
//            for(int u = 0; u < tripSeatList.size(); u++){
//                if(this.tripSeatList.get(u).getSeatAvailability() == 'Y'){
//                    jlbSeatArr[u].setIcon(iconAvail);
//                    jchkSeatArr[u].setEnabled(true);
//                }
//                else{
//                    jlbSeatArr[u].setIcon(iconOccupied);
//                    jchkSeatArr[u].setEnabled(false);
//                }
//            }
//        }//GG also
        
        //remove second tab for 24 seats trip
        if(this.tripSeatList.size() == 24){
            jtpSeats.remove(jpUpDeck);
        } //no else because both the jpLowDeck and jpUpDeck are added in the preceeding statement before this checking
        
        
        //run this first
        for(int u = 0; u < tripSeatList.size(); u++){
            if(this.tripSeatList.get(u).getSeatAvailability() == 'Y'){
                jlbSeatArr[u].setIcon(iconAvail);
                jchkSeatArr[u].setEnabled(true);
            }
            else{
                jlbSeatArr[u].setIcon(iconOccupied);
                jchkSeatArr[u].setEnabled(false);
            }
        }
        
        //run this again
        if(!this.orderLineList.isEmpty()){
            for(int w = 0; w < this.orderLineList.size(); w++){
                for(int t = 0; t < tripSeatList.size(); t++){
                    if(tripSeatList.get(t).getTripNo().equals(this.orderLineList.get(w).getTripNo()) && tripSeatList.get(t).getSeatNo().equals(this.orderLineList.get(w).getSeatNo())){
                        jlbSeatArr[t].setIcon(iconOrdered);
                        jchkSeatArr[t].setEnabled(false);
                    } //no else here, because else has been served by the upper loop
                }//no else here, because else has been served by the upper loop
            }
        }
        
        jbtOK.addActionListener(new ButtonListener());
        jbtCancel.addActionListener(new ButtonListener());
        
        addWindowListener(new WindowListener());
        
        jbtOK.setEnabled(false);
        
        setIcon();
        
        setTitle("Select Seat(s)");
        setSize(620,600);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //temp dev
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class CheckBoxListener implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            
            //loop handling //revise order................................reversed order with the counter handling
//            for(int i = 0; i < tripSeatList.size(); i++){ // changed to tripSeatList.size()since total no of seats depend on that //A***
//                System.out.println("This is A.");
//                if(e.getSource() == jchkSeatArr[i]){//B
//                    System.out.println("This is B.");
//                    if(jchkSeatArr[i].isSelected()){ //when selected//C
//                        System.out.println("This is C.");
//                        jlbSeatArr[i].setIcon(iconSelected);
//                        
//                        selectedSeatNo.add(tripSeatList.get(i).getSeatNo());//////null pointer exception
//                        seatCounter++;
//                        
//                    }
//                    else{ //when deselected //D
//                        System.out.println("This is D.");
////                        if(jchkSeatArr[i].isEnabled()){ //cannot be used with the quantity restriction//means available originally, then when deselected baru set back available
////                            jlbSeatArr[i].setIcon(iconAvail);
////                        }
////                        else{ //check box is originally disabled because it is already occupied.
////                            jlbSeatArr[i].setIcon(iconOccupied); //or this statement can be turned off oso, since no changes.
////                        }
//                        //decrement seatCounter
//                        seatCounter --;
//                        
//                        if(tripSeatList.get(i).getSeatAvailability() == 'Y'){ //seat available //E
//                            System.out.println("This is E.");
//                            jlbSeatArr[i].setIcon(iconAvail);
//                            //jchkSeatArr[i].setEnabled(true);
//                        }
//                        else{ //seatAvailability is 'N', seat not available //F
//                            System.out.println("This is F.");
//                            jlbSeatArr[i].setIcon(iconOccupied);
//                            //jchkSeatArr[i].setEnabled(false);
//                        }
//                        
//                        selectedSeatNo.remove(tripSeatList.get(i).getSeatNo());
//                    }
//                }
//                
//            }//
            
            if(selectedSeatNo.size() < reqQuantity){ //G //quantity still valid
                System.out.println("This is G.");
                
                for(int i = 0; i < tripSeatList.size(); i++){ // changed to tripSeatList.size()since total no of seats depend on that //A
                System.out.println("This is A.");
                if(e.getSource() == jchkSeatArr[i]){//B
                    System.out.println("This is B.");
                    if(jchkSeatArr[i].isSelected()){ //when selected//C
                        System.out.println("This is C.");
                        jlbSeatArr[i].setIcon(iconSelected);
                        
                        selectedSeatNo.add(tripSeatList.get(i).getSeatNo());//////null pointer exception
                        //seatCounter++;/AA
                        
                    }
                    else{ //when deselected //D
                        System.out.println("This is D.");
//                        if(jchkSeatArr[i].isEnabled()){ //cannot be used with the quantity restriction//means available originally, then when deselected baru set back available
//                            jlbSeatArr[i].setIcon(iconAvail);
//                        }
//                        else{ //check box is originally disabled because it is already occupied.
//                            jlbSeatArr[i].setIcon(iconOccupied); //or this statement can be turned off oso, since no changes.
//                        }
                        //decrement seatCounter
                       // seatCounter --;//AA
                        
                        if(tripSeatList.get(i).getSeatAvailability() == 'Y'){ //seat available //E
                            System.out.println("This is E.");
                            jlbSeatArr[i].setIcon(iconAvail);
                            //jchkSeatArr[i].setEnabled(true);
                        }
                        else{ //seatAvailability is 'N', seat not available //F
                            System.out.println("This is F.");
                            jlbSeatArr[i].setIcon(iconOccupied);
                            //jchkSeatArr[i].setEnabled(false);
                        }
                        
                        selectedSeatNo.remove(tripSeatList.get(i).getSeatNo());
                    }
                }
                
            }//
                
//                for(int m = 0; m < tripSeatList.size(); m++){ //disable all checkbox after reqQuantity is reached EXCEPT seats selected in current session //H
//                    System.out.println("This is H.");
//                    for(int g = 0; g < selectedSeatNo.size(); g++){ //newly added, yet to test //I
//                        System.out.println("This is I.");
//                        if(tripSeatList.get(m).getSeatNo().equals(selectedSeatNo.get(g))){//J
//                            System.out.println("This is J.");
//                            jchkSeatArr[m].setEnabled(true);
//                        }
//                        else{ //K
//                            System.out.println("This is K.");
//                            jchkSeatArr[m].setEnabled(false);
//                        }
//                    }
//                    
//                }/////
                
                //reverse inside and outside loop***
//                    for(int m = 0; m < selectedSeatNo.size(); m++){ //disable all checkbox after reqQuantity is reached EXCEPT seats selected in current session //H
//                    System.out.println("This is H.");
//                    for(int g = 0; g < tripSeatList.size(); g++){ //newly added, yet to test //I
//                        System.out.println("This is I.");
//                        if((selectedSeatNo.get(m)).equals(tripSeatList.get(g).getSeatNo())){//J
//                            System.out.println("This is J.");
//                            jchkSeatArr[g].setEnabled(true);
//                        }
//                        else{ //K
//                            System.out.println("This is K.");
//                            jchkSeatArr[g].setEnabled(false);
//                        }
//                    }
//                    
//                }/////

                
            }
            else{ //reach or exceeding counter
                System.out.println("This is L.");
//                for(int n = 0; n < jlbSeatArr.length; n++){//Index out of bound when adding a new 24 seat trip from a previously 54 seats trip seats trip
//                for(int n = 0; n < tripSeatList.size(); n++){//M****
//                    System.out.println("This is M.");
//                if(tripSeatList.get(n).getSeatAvailability() == 'Y'){ //seat available //N
//                    //test step
//                    System.out.println("This is N.");
//                    for(int r = 0; r < orderLineList.size(); r++){ //O
//                        System.out.println("This is O.");
//                        
//                        if(!orderLineList.isEmpty()){ //first run the orderLineList is empty //P //unnecessary, since the for loop can also filter this.
//                            System.out.println("This is P.");
//                            if(orderLineList.get(r).getTripNo().equals(tripNo) && orderLineList.get(r).getSeatNo().equals(tripSeatList.get(n).getSeatNo())){ //Q
//                                System.out.println("This is Q.");
//                                //means seat is available in tripseat table, but ordered in order cart, not yet paid, also cannot be chosen any more.
//                                //applicable when the seat selection for the same trip is opened again.
//                                jlbSeatArr[n].setIcon(iconOrdered);
//                                jchkSeatArr[n].setEnabled(false);
//                            }////
//                        }
//                        else{ //seat still available even the seat selection screen for the same trip is reopened //R
//                            System.out.println("This is R.");
//                            jlbSeatArr[n].setIcon(iconAvail);
//                            jchkSeatArr[n].setEnabled(true);
//                        }
//                    
//                    
//                    }
//                    
////                    jlbSeatArr[n].setIcon(iconAvail);
////                    jchkSeatArr[n].setEnabled(true);
//                }
//                else{ //seatAvailability is 'N', seat not available //S
//                    System.out.println("This is S.");
//                    jlbSeatArr[n].setIcon(iconOccupied);
//                    jchkSeatArr[n].setEnabled(false);
//                }
//            }*****
                for(int b = 0; b < tripSeatList.size(); b++){
                    if(e.getSource() == jchkSeatArr[b]){
                        if(jchkSeatArr[b].isSelected()){ //no counter
                            JOptionPane.showMessageDialog(null, "You have already selected " + reqQuantity + " seat(s).", "Quantity Exceeded.", JOptionPane.WARNING_MESSAGE);
                            jchkSeatArr[b].setSelected(false);
                        }
                        else{ //deselection
                            selectedSeatNo.remove(tripSeatList.get(b).getSeatNo());
                            
                            if(tripSeatList.get(b).getSeatAvailability() == 'Y'){ //seat available //X
                            System.out.println("This is X.");
                            jlbSeatArr[b].setIcon(iconAvail);
                            //jchkSeatArr[i].setEnabled(true);
                            }
                            else{ //seatAvailability is 'N', seat not available //Y
                                System.out.println("This is Y.");
                                jlbSeatArr[b].setIcon(iconOccupied);
                                //jchkSeatArr[i].setEnabled(false);
                            }
                            //seatCounter --; //AA
                        }
                    }
                }
                
                
            }
            
            System.out.println("-------------------------\n");
            System.out.println("reqQuantity: "+reqQuantity);
            System.out.println("seatCounter: "+selectedSeatNo.size());
            
            //test synchronization, IMPORTANT to keep the counter valid
            //seatCounter = selectedSeatNo.size();
            
            //enable/disable the OK button when the no of selected seat reach/unreach the required quantity
            if(selectedSeatNo.size() == reqQuantity){
                jbtOK.setEnabled(true);
            }
            else{
                jbtOK.setEnabled(false);
            }
            
//            //manual handling
//            if(e.getSource() == jchkSA01){
//                if(jchkSA01.isSelected()){ //when selected
//                    jlbSA01.setIcon(iconSelected);
//                }
//                else{ //when deselected
//                    if(jchkSA01.isEnabled()){ //means available originally, then when deselected baru set back available
//                        jlbSA01.setIcon(iconAvail);
//                    }
//                    else{ //check box is originally disabled because it is already occupied.
//                        jlbSA01.setIcon(iconOccupied); //or this statement can be turned off oso, since no changes.
//                    }
//                }
//            }
            
            
        }
    }
    
//    private void initializeSeats(){
//        int numberOfSeats = 0;
//        numberOfSeats = tripSeatList.size();
//        
//        if(numberOfSeats == 24){ //single deck bus --> 24 seats only   //INITIALIZE SEATS
//            for(int i = 0; i < tripSeatList.size(); i++){ //0 - 23
//                if(tripSeatList.get(i).getSeatAvailability() == 'Y'){ //seat available
//                    jlbSeatArr[i].setIcon(iconAvail);
//                    jchkSeatArr[i].setEnabled(true);
//                }
//                else{ //seatAvailability is 'N', seat not available
//                    jlbSeatArr[i].setIcon(iconOccupied);
//                    jchkSeatArr[i].setEnabled(false);
//                }
//            }
//            
//            //deselect and disable all upper deck checkboxes
//            for(int j = 24; j < jchkSeatArr.length; j++){
//                jchkSeatArr[j].setSelected(false);
//                jchkSeatArr[j].setEnabled(false);
//            }
//            
//            //remove upper deck tab
//            jtpSeats.remove(jpUpDeck);
//        }
//        else{ //double deck bus --> 54 seats
//            for(int i = 0; i < jlbSeatArr.length; i++){
//                if(tripSeatList.get(i).getSeatAvailability() == 'Y'){ //seat available
//                    jlbSeatArr[i].setIcon(iconAvail);
//                    jchkSeatArr[i].setEnabled(true);
//                }
//                else{ //seatAvailability is 'N', seat not available
//                    jlbSeatArr[i].setIcon(iconOccupied);
//                    jchkSeatArr[i].setEnabled(false);
//                }
//            }
//        }
//        
//        ////////////////////////////////////////////
//        
//        
//    } //unused method, to be removed
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtOK){
                
                for(int f = 0; f < selectedSeatNo.size(); f++){
                    orderLineList.add(new OrderLine(orderID, tripNo, selectedSeatNo.get(f)));
                    }
                dispose();
                new ShowOrderCart(accType, orderID, orderLineList);
            }
            else if(e.getSource() == jbtCancel){
                int choice = JOptionPane.showConfirmDialog(null, "Return to Show Available Trips page?\nCurrently selected seat(s) will not be saved.","Confirm?",JOptionPane.YES_NO_OPTION);
                if(choice == JOptionPane.YES_OPTION){
                    dispose();
                    new ShowAvailableTrips(accType, orderLineList);
                }
            }
        }
    }
    
    
     private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            
            int confirm = JOptionPane.showConfirmDialog(null, "Return to Show Available Trips screen?\nCurrent changes will be discarded.", "Return?", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    //loginControl.closeDB();
                    tripSeatControl.closeDB();
                    dispose();
                    new ShowAvailableTrips(accType, orderLineList);
                    //new SecurityFeaturesMenu(accType);
                }
       }
    }
     
     private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new SeatSelection('A',3,"","",null);
    }
}