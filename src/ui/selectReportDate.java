//Sum NEW
//V1.01 1129PM 25MAR16
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
import java.util.*;
import javax.*;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTextField;

public class selectReportDate extends JFrame{
    
    private char accType;
    
    private String reportType;
    
    private java.util.Date startDate = null;
    
    private java.util.Date endDate = null;
    
    private JXDatePicker startDatePicker;
    
    private JXDatePicker endDatePicker;
    
    private SimpleDateFormat dateFormat;
    
    private ReportMenu targetFrame;
    
    private JLabel jlbInstr = new JLabel("Please select a report start date from the date picker.");
    private JLabel jlbInstr2 = new JLabel("The report end date will be automatically generated based on the selected start date.");
    private JLabel jlbInstr3 = new JLabel("The report end date generated will be a month later from the selected report start date.");
    private JLabel jlbStartDate = new JLabel("Report Start Date: ");
    private JLabel jlbEndDate = new JLabel("Report End Date: ");
    
    private JButton jbtOK = new JButton("OK");
    
    private JTextField jtfEndDate = new JTextField(14);
    
    //private JPanel jpNORTH = new JPanel(new FlowLayout());
    private JPanel jpNORTH = new JPanel(new GridLayout(4, 1, 5, 5));
    private JPanel jpCENTER = new JPanel(new FlowLayout());
    private JPanel jpSOUTH = new JPanel(new FlowLayout(FlowLayout.CENTER,30,5)); //for OK button
    
    private JPanel jp_NORTH_r1 = new JPanel(new FlowLayout());
    private JPanel jp_NORTH_r2 = new JPanel(new FlowLayout());
    private JPanel jp_NORTH_r3 = new JPanel(new FlowLayout());
    private JPanel jp_NORTH_r4 = new JPanel(new FlowLayout());
    
    private JPanel global = new JPanel(new BorderLayout()){  

        public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     EnterQuantity.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    public selectReportDate(){
        
    }
    
    public selectReportDate(char accType, String reportType, ReportMenu targetFrame){
        
        
        
        this.accType = accType;
        
        this.reportType = reportType;
        
        this.targetFrame = targetFrame;
        
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        startDatePicker = new JXDatePicker(new java.util.Date(System.currentTimeMillis()));
        
        endDatePicker = new JXDatePicker(new java.util.Date(System.currentTimeMillis()));
        
        startDatePicker.setFormats(new String[]{"dd-MM-yyyy", "yyyy-MM-dd"});
        endDatePicker.setFormats(new String[]{"dd-MM-yyyy", "yyyy-MM-dd"});
        
        jtfEndDate.setEditable(false);
        
        jpNORTH.setOpaque(false);
        jpCENTER.setOpaque(false);
        jpSOUTH.setOpaque(false);
        
        jp_NORTH_r1.setOpaque(false);
        jp_NORTH_r2.setOpaque(false);
        jp_NORTH_r3.setOpaque(false);
        jp_NORTH_r4.setOpaque(false);
        
//        jpNORTH.add(jlbStartDate);
//        jpNORTH.add(startDatePicker);
        jp_NORTH_r1.add(jlbInstr);
        jp_NORTH_r2.add(jlbInstr2);
        jp_NORTH_r3.add(jlbStartDate);
        jp_NORTH_r3.add(startDatePicker);
        jp_NORTH_r4.add(jlbInstr3);
        
        jpNORTH.add(jp_NORTH_r1);
        jpNORTH.add(jp_NORTH_r2);
        jpNORTH.add(jp_NORTH_r3);
        jpNORTH.add(jp_NORTH_r4);
        
        jpCENTER.add(jlbEndDate);
        jpCENTER.add(jtfEndDate);
        jpSOUTH.add(jbtOK);
        
        global.add(jpNORTH, BorderLayout.NORTH);
        global.add(jpCENTER, BorderLayout.CENTER);
        global.add(jpSOUTH, BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(global,BorderLayout.CENTER);
        
        startDatePicker.addActionListener(new DatePickerListener());
        jbtOK.addActionListener(new DatePickerListener());
        
        addWindowListener(new WindowListener());
        
        setIcon();
        
        setTitle("Select Report Date");
        setSize(550,250);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //temp dev
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    
    private class DatePickerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == startDatePicker){
                
//                java.util.Date startDate;
//                java.util.Date endDate;
                String endDateStr;
                
                //test
                System.out.println(startDatePicker.getDate().toString());
                
                //START DATE
                startDate = startDatePicker.getDate();
                
//                //assign to class variable startDate, to be used by OK button later
//                startDate = 
                
                Calendar cal = Calendar.getInstance();
                //try{
                    cal.setTime(startDatePicker.getDate());
//                }
//                catch(Exception ex){
//                    System.out.println("startDate Parsing Failed, by SimpleDateFormat formatter dateFormat.");
//                }
                
                cal.add(Calendar.MONTH, 1);
                
                //END DATE
                endDate = cal.getTime();
                
                endDateStr = dateFormat.format(endDate);
                
                jtfEndDate.setText(endDateStr);
                
                //test
                System.out.println("The end date is: "+endDateStr);
                
                //reportMenu.receiveDates(startDate, endDate);
            }
            
            else if(e.getSource() == jbtOK){
                
                if(!(endDate == null)){
                    targetFrame.reportCentralHub(startDate, endDate, reportType, accType);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select the report start date at least once,\n to obtain a report end date,\nbefore clicking \"OK\".", "No Selection", JOptionPane.WARNING_MESSAGE);
                }
                
            }
        }
    }
    
     private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Return to report submenu?", "Return?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                //tripControl.closeDB();
                //orderControl.closeDB();
               targetFrame.dispose();
               new ReportMenu(accType);
               dispose();
                //new ShowAvailableTrips(accType,orderLineList);
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new selectReportDate('A',"", null);
    }
}