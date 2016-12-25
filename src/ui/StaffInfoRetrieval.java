//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

import da.*;
import ui.*;
import domain.*;
import control.*;

public class StaffInfoRetrieval extends JFrame{
    
    private char accType;
    
    private MaintainStaff staffControl;
    
    private Staff staffRead;

    //declarations
    private JLabel lb_Title = new JLabel("Staff Information Retrieval",SwingConstants.CENTER);
    private JLabel lb_instruction = new JLabel("Please enter the Staff ID below to retrieve the information of the staff.",SwingConstants.CENTER);
    private JLabel lb_notice = new JLabel("Note: The staff record of the Staff ID entered must exist in the database to ensure successful retrieval.");
    
    private JButton jbtRead = new JButton("Read");
    private JButton jbtBack = new JButton("Back");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtMainMenu = new JButton("Main Menu");
    private JTextField jtfStaffID = new JTextField(7);
    private JLabel lbstaffIDup = new JLabel("Staff ID:");
    
    private JPanel outer_NORTH = new JPanel(new GridLayout(3,1,5,5));//3155
    
    private JPanel inner_NORTH = new JPanel(new FlowLayout(FlowLayout.LEFT,30,5));
    
    private String staffID;
    
    //Group A: Personal Information JLabels
    private JLabel lb_fname = new JLabel("First Name:");
    private JLabel lb_lname = new JLabel("Last Name:");
    private JLabel lb_gender = new JLabel("Gender:");
    //private JLabel lb_NRIC = new JLabel("NRIC: ");
    //private JLabel lb_nation = new JLabel("Nationality:");
    //private JLabel lb_DOB = new JLabel("Date of Birth:");
    //private JLabel lb_bankAccNo = new JLabel("Bank Account Number:");
    
    //Group B: Address Information
    private JLabel lb_street_add1 = new JLabel("Street Address 1:");
    private JLabel lb_street_add2 = new JLabel("Street Address 2:");
    private JLabel lb_city = new JLabel("CIty:");
    //private JLabel lb_postcode = new JLabel("Postcode:");
    private JLabel lb_state = new JLabel("State:");
    //private JLabel lb_country = new JLabel("Country:");
    
    //Group C: Contact Information
    private JLabel lb_mobileNo = new JLabel("Phone Number (Mobile):");
    private JLabel lb_homeNo = new JLabel("Phone Number (Home):");
    private JLabel lb_email = new JLabel("Email Address:");
    
    //Group D: Employment Related Information
    private JLabel lb_staffID = new JLabel("Staff ID:");
    private JLabel lb_position = new JLabel("Position:");
    private JLabel lb_salary = new JLabel("Salary (If applicable):");
    //private JLabel lb_wage = new JLabel("Wage (If applicable): ");
    //private JLabel lb_hireDate = new JLabel("Hire Date:");
    //private JLabel lb_emp_stat = new JLabel("Employment Status (PM for Permanent, PT for Part Time):");
    
    //JLabels for each group
    private JLabel lb_groupA = new JLabel("Part A: Personal Information");
    private JLabel lb_groupB = new JLabel("Part B: Address Information");
    private JLabel lb_groupC = new JLabel("Part C: Contact Information");
    private JLabel lb_groupD = new JLabel("Part D: Employment Related Information");
    
    
    //JTextFields
    // Group A
    private JTextField jtf_fname = new JTextField(9);
    private JTextField jtf_lname = new JTextField(15);
    private JTextField jtf_gender = new JTextField(1); 
//    private JTextField jtf_IC_p1 = new JTextField(6);
//    private JTextField jtf_IC_p2 = new JTextField(2);
//    private JTextField jtf_IC_p3 = new JTextField(4);
//    private JTextField jtf_nation = new JTextField(15); 
//    private JTextField jtf_DOB_dd = new JTextField(2);
//    private JTextField jtf_DOB_mm = new JTextField(2);
//    private JTextField jtf_DOB_yyyy = new JTextField(4);
//    private JTextField jtf_bankAccNo = new JTextField(12);
    
    //Group B
    private JTextField jtf_street_add1 = new JTextField(25);
    private JTextField jtf_street_add2 = new JTextField(25);
    private JTextField jtf_city = new JTextField(15);
    //private JTextField jtf_postcode = new JTextField(5);
    private JTextField jtf_state = new JTextField(15);
    //private JTextField jtf_country = new JTextField(25); 
    
    //Group C
    private JTextField jtf_mobileNo_p1 = new JTextField(3);
    private JTextField jtf_mobileNo_p2 = new JTextField(8);
    
    private JTextField jtf_homeNo_p1 = new JTextField(2);
    private JTextField jtf_homeNo_p2 = new JTextField(7);
    
    private JTextField jtf_email = new JTextField(30);
    
    //Group D
    private JTextField jtf_staffID = new JTextField(7);
    private JTextField jtf_position = new JTextField(15);
    private JTextField jtf_salary = new JTextField(8);
//    private JTextField jtf_wage = new JTextField(8);
//    private JTextField jtf_hireDate_dd = new JTextField(2);
//    private JTextField jtf_hireDate_mm = new JTextField(2);
//    private JTextField jtf_hireDate_yyyy = new JTextField(4);
//    private JTextField jtf_emp_stat = new JTextField(2);
    
    private JPanel global = new JPanel(new BorderLayout()){  
   public void paintComponent(Graphics g) {  
     Image img1 = Toolkit.getDefaultToolkit().getImage(  
     StaffInfoRetrieval.class.getResource("../images/green1.jpg"));  
     g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};
    
    private JPanel big_container = new JPanel(new GridLayout(2,2,0,0));
    private JPanel groupA = new JPanel(new GridLayout(6,1,0,0));//8100,9100
    private JPanel groupB = new JPanel(new GridLayout(6,1,0,0));//7100
    private JPanel groupC = new JPanel(new GridLayout(5,1,0,0));//4100
    private JPanel groupD = new JPanel(new GridLayout(5,1,0,0));//9100 10100
    
    // Row containers for groupA
    private JPanel groupA_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupA_r8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    private JPanel groupA_r9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
   
    // Row containers for groupB
    private JPanel groupB_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupB_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupB_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupB_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupB_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupB_r6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupB_r7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    //for empty JLabels
     private JPanel groupB_r8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    // Row containers for groupC
    private JPanel groupC_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupC_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupC_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupC_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    // Row containers for groupD
    private JPanel groupD_r1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel groupD_r8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    //Fonts
    Font groupTitle = new Font("Arial Black",Font.PLAIN,16);
    Font wlcFont = new Font("Comic Sans MS",Font.BOLD,15);
    Font lbText = new Font("Arial",Font.PLAIN,14);
    
     //Button colors
    Color jbtColor = new Color(204, 255, 204);
    
    //wording color
    //Note: The color for street address 2 label is specially set to white and do not follow jlbColor to make it visible under dark background
    Color jlbColor = new Color(0, 0, 0);
    
    public StaffInfoRetrieval(){
        
    }
    
    public StaffInfoRetrieval(char accType){
        staffControl = new MaintainStaff();
        setLayout(new BorderLayout());
        
        //set textfield max limit
        jtfStaffID.setDocument(new JTextFieldLimit(7));
        
        //grey out all the textfields as this is a READ function
        jtf_fname.setEditable(false);
        jtf_lname.setEditable(false);
        jtf_gender.setEditable(false);
//        jtf_IC_p1.setEditable(false);
//        jtf_IC_p2.setEditable(false);
//        jtf_IC_p3.setEditable(false);
//        jtf_nation.setEditable(false);
//        jtf_DOB_dd.setEditable(false);
//        jtf_DOB_mm.setEditable(false);
//        jtf_DOB_yyyy.setEditable(false);
//        jtf_bankAccNo.setEditable(false);
        jtf_street_add1.setEditable(false);
        jtf_street_add2.setEditable(false);
        jtf_city.setEditable(false);
        //jtf_postcode.setEditable(false);
        jtf_state.setEditable(false);
        //jtf_country.setEditable(false);
        jtf_mobileNo_p1.setEditable(false);
        jtf_mobileNo_p2.setEditable(false);
        jtf_homeNo_p1.setEditable(false);
        jtf_homeNo_p2.setEditable(false);
        jtf_email.setEditable(false);
        jtf_staffID.setEditable(false);
        jtf_position.setEditable(false);
        jtf_salary.setEditable(false);
//        jtf_wage.setEditable(false);
//        jtf_hireDate_dd.setEditable(false);
//        jtf_hireDate_mm.setEditable(false);
//        jtf_hireDate_yyyy.setEditable(false);
//        jtf_emp_stat.setEditable(false);
        
        jbtRead.setBackground(jbtColor);
        jbtReset.setBackground(jbtColor);
        jbtBack.setBackground(jbtColor);
        jbtMainMenu.setBackground(jbtColor);
        
        //setting color for wording
        lb_Title.setForeground(jlbColor);
        lb_city.setForeground(jlbColor);
        lb_email.setForeground(jlbColor);
        lb_fname.setForeground(jlbColor);
        lb_gender.setForeground(jlbColor);
        lb_groupA.setForeground(jlbColor);
        lb_groupB.setForeground(jlbColor);
        lb_groupC.setForeground(jlbColor);
        lb_groupD.setForeground(jlbColor);
        lb_homeNo.setForeground(jlbColor);
        lb_instruction.setForeground(jlbColor);
        lb_lname.setForeground(jlbColor);
        lb_mobileNo.setForeground(jlbColor);
        lb_notice.setForeground(jlbColor);
        lb_position.setForeground(jlbColor);
        lb_salary.setForeground(jlbColor);
        lb_staffID.setForeground(jlbColor);
        lb_state.setForeground(jlbColor);
        lb_street_add1.setForeground(jlbColor);
        lb_street_add2.setForeground(new Color(255, 255, 255)); //specially set to make the label visible in the darker green background
        lb_city.setForeground(new Color(255, 255, 255)); //specially set to make the label visible in the darker green background
        lbstaffIDup.setForeground(jlbColor);
        
        //setting mnemonics
        jbtRead.setMnemonic('A');
        jbtReset.setMnemonic('R');
        jbtBack.setMnemonic('B');
        
        inner_NORTH.add(lbstaffIDup);
        inner_NORTH.add(jtfStaffID);
        inner_NORTH.add(jbtRead);
        inner_NORTH.add(jbtReset);
        inner_NORTH.add(jbtBack);
        inner_NORTH.add(jbtMainMenu);
        
        outer_NORTH.add(lb_Title);
        outer_NORTH.add(lb_instruction);
        outer_NORTH.add(inner_NORTH);

        //adding border
        outer_NORTH.setBorder(new LineBorder(Color.BLACK));
        big_container.setBorder(new LineBorder(Color.BLACK));
        
        //setting Fonts for welcome title
        lb_Title.setFont(wlcFont);
        lb_instruction.setFont(wlcFont);
        
        //setting Fonts for group title
        lb_groupA.setFont(groupTitle);
        lb_groupB.setFont(groupTitle);
        lb_groupC.setFont(groupTitle);
        lb_groupD.setFont(groupTitle);
        
        //setOpaque for all upper JPanels
        inner_NORTH.setOpaque(false);
        outer_NORTH.setOpaque(false);
        big_container.setOpaque(false);
        
        groupA.setOpaque(false);
        groupB.setOpaque(false);
        groupC.setOpaque(false);
        groupD.setOpaque(false);
        groupA_r1.setOpaque(false);
        groupA_r2.setOpaque(false);
        groupA_r3.setOpaque(false);
        groupA_r4.setOpaque(false);
        groupA_r5.setOpaque(false);
        groupA_r6.setOpaque(false);
        groupA_r7.setOpaque(false);
        groupA_r8.setOpaque(false);
        groupA_r9.setOpaque(false);
        
        groupB_r1.setOpaque(false);
        groupB_r2.setOpaque(false);
        groupB_r3.setOpaque(false);
        groupB_r4.setOpaque(false);
        groupB_r5.setOpaque(false);
        groupB_r6.setOpaque(false);
        groupB_r7.setOpaque(false);
        groupB_r8.setOpaque(false);
        
        groupC_r1.setOpaque(false);
        groupC_r2.setOpaque(false);
        groupC_r3.setOpaque(false);
        groupC_r4.setOpaque(false);
        
        groupD_r1.setOpaque(false);
        groupD_r2.setOpaque(false);
        groupD_r3.setOpaque(false);
        groupD_r4.setOpaque(false);
        groupD_r5.setOpaque(false);
        groupD_r6.setOpaque(false);
        groupD_r7.setOpaque(false);
        groupD_r8.setOpaque(false);
        
        groupA_r1.add(lb_groupA);
        groupA_r2.add(new JLabel());
        groupA_r3.add(lb_fname);
        groupA_r3.add(jtf_fname);
        groupA_r4.add(lb_lname);
        groupA_r4.add(jtf_lname);
        groupA_r5.add(lb_gender);
        groupA_r5.add(jtf_gender);
//        groupA_r6.add(lb_NRIC);
//        groupA_r6.add(jtf_IC_p1);
//        groupA_r6.add(new JLabel(" - "));
//        groupA_r6.add(jtf_IC_p2);
//        groupA_r6.add(new JLabel(" - "));
//        groupA_r6.add(jtf_IC_p3);
//        groupA_r7.add(lb_nation);
//        groupA_r7.add(jtf_nation);
//        groupA_r8.add(lb_DOB);
//        groupA_r8.add(jtf_DOB_dd);
//        groupA_r8.add(new JLabel(" / "));
//        groupA_r8.add(jtf_DOB_mm);
//        groupA_r8.add(new JLabel(" / "));
//        groupA_r8.add(jtf_DOB_yyyy);
//        groupA_r9.add(lb_bankAccNo);
//        groupA_r9.add(jtf_bankAccNo);
        
        
        
        groupA.add(groupA_r1);
        //groupA.add(groupA_r2);
        groupA.add(groupA_r3);
        groupA.add(groupA_r4);
        groupA.add(groupA_r5);
//        groupA.add(groupA_r6);
//        groupA.add(groupA_r7);
//        groupA.add(groupA_r8);
//        groupA.add(groupA_r9);

        groupB_r1.add(lb_groupB);
        groupB_r2.add(new JLabel());
        groupB_r3.add(lb_street_add1);
        groupB_r3.add(jtf_street_add1);
        groupB_r4.add(lb_street_add2);
        groupB_r4.add(jtf_street_add2);
        groupB_r5.add(lb_city);
        groupB_r5.add(jtf_city);
//        groupB_r6.add(lb_postcode);
//        groupB_r6.add(jtf_postcode);
        groupB_r7.add(lb_state);
        groupB_r7.add(jtf_state);
//        groupB_r8.add(lb_country);
//        groupB_r8.add(jtf_country);
        
        groupB.add(groupB_r1);
        //groupB.add(groupB_r2);
        groupB.add(groupB_r3);
        groupB.add(groupB_r4);
        groupB.add(groupB_r5);
        //groupB.add(groupB_r6);
        groupB.add(groupB_r7);
        //groupB.add(groupB_r8);
        
        //Group C
        groupC_r1.add(lb_groupC);
        groupC_r2.add(lb_mobileNo);
        groupC_r2.add(jtf_mobileNo_p1);
        groupC_r2.add(new JLabel(" - "));
        groupC_r2.add(jtf_mobileNo_p2);
        groupC_r3.add(lb_homeNo);
        groupC_r3.add(jtf_homeNo_p1);
        groupC_r3.add(new JLabel(" - "));
        groupC_r3.add(jtf_homeNo_p2);
        groupC_r4.add(lb_email);
        groupC_r4.add(jtf_email);
        
        groupC.add(groupC_r1);
        groupC.add(groupC_r2);
        groupC.add(groupC_r3);
        groupC.add(groupC_r4);

        groupD_r1.add(lb_groupD);
        groupD_r2.add(new JLabel());
        groupD_r3.add(lb_staffID);
        groupD_r3.add(jtf_staffID);
        groupD_r4.add(lb_position);
        groupD_r4.add(jtf_position);
        groupD_r5.add(lb_salary);
        groupD_r5.add(jtf_salary);
//        groupD_r6.add(lb_wage);
//        groupD_r6.add(jtf_wage);
//        groupD_r7.add(lb_hireDate);
//        groupD_r7.add(jtf_hireDate_dd);
//        groupD_r7.add(new JLabel(" / "));
//        groupD_r7.add(jtf_hireDate_mm);
//        groupD_r7.add(new JLabel(" / "));
//        groupD_r7.add(jtf_hireDate_yyyy);
//        groupD_r8.add(lb_emp_stat);
//        groupD_r8.add(jtf_emp_stat);
        
        groupD.add(groupD_r1);
        //groupD.add(groupD_r2);
        groupD.add(groupD_r3);
        groupD.add(groupD_r4);
        groupD.add(groupD_r5);
//        groupD.add(groupD_r6);
//        groupD.add(groupD_r7);
//        groupD.add(groupD_r8);

        //adding the JPanels into JFrame
        big_container.add(groupA);
        big_container.add(groupC);
        big_container.add(groupB);
        big_container.add(groupD);
        
        global.add(outer_NORTH,BorderLayout.NORTH);
        global.add(big_container,BorderLayout.CENTER);
        
        add(global,BorderLayout.CENTER);
        
        //register action listener
        jbtRead.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener ());
        jbtMainMenu.addActionListener(new ButtonListener());
        
        //register WindowListener
        addWindowListener(new WindowListener());
        
         getRootPane().setDefaultButton(jbtRead);
        
        //createConnection();
        
        setIcon();
        setTitle("Staff Information Retrieval");
        setSize(900,705);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtRead){
                jtf_fname.setText("");
                jtf_lname.setText("");
                jtf_gender.setText("");
//                jtf_IC_p1.setText("");
//                jtf_IC_p2.setText("");
//                jtf_IC_p3.setText("");
//                jtf_nation.setText("");
//                jtf_DOB_dd.setText("");
//                jtf_DOB_mm.setText("");
//                jtf_DOB_yyyy.setText("");
//                jtf_bankAccNo.setText("");
                jtf_street_add1.setText("");
                jtf_street_add2.setText("");
                jtf_city.setText("");
                //jtf_postcode.setText("");
                jtf_state.setText("");
                //jtf_country.setText("");
                jtf_mobileNo_p1.setText("");
                jtf_mobileNo_p2.setText("");
                jtf_homeNo_p1.setText("");
                jtf_homeNo_p2.setText("");
                jtf_email.setText("");
                jtf_staffID.setText("");
                jtf_position.setText("");
                jtf_salary.setText("");
//                jtf_wage.setText("");
//                jtf_hireDate_dd.setText("");
//                jtf_hireDate_mm.setText("");
//                jtf_hireDate_yyyy.setText("");
//                jtf_emp_stat.setText("");
                
                    String staffID = jtfStaffID.getText();
                    if(staffID.equals("")){
                        JOptionPane.showMessageDialog(null,"Please enter a staff ID to retrieve information.","Empty staff ID",JOptionPane.WARNING_MESSAGE);
                        jtfStaffID.requestFocusInWindow();
                    }
                    else{
                        
                        //temporary assignment
                        //staffRead = null;
                        staffRead = staffControl.getRecord(staffID);
                        
                            if(staffRead != null){

                                jtf_fname.setText(staffRead.getFirstname());
                                jtf_lname.setText(staffRead.getLastname());
                                jtf_gender.setText(String.valueOf(staffRead.getGender()));
                                //split string for IC
//                                String IC = staff.getNRIC();
//                                //handling for string exception(s)
//                                try{
//                                    String IC_p1 = IC.substring(0, 6);
//                                    String IC_p2 = IC.substring(6, 8);
//                                    String IC_p3 = IC.substring(8);
//                                    jtf_IC_p1.setText(IC_p1);
//                                    jtf_IC_p2.setText(IC_p2);
//                                    jtf_IC_p3.setText(IC_p3);
//                                }catch(StringIndexOutOfBoundsException ex){
//                                    jtf_IC_p1.setText("N/A");
//                                    jtf_IC_p2.setText("NA");
//                                    jtf_IC_p3.setText("NA");
//                                }
//                                catch(Exception ex){
//                                    jtf_IC_p1.setText("N/A");
//                                    jtf_IC_p2.setText("NA");
//                                    jtf_IC_p3.setText("N/A");
//                                }
//
//                                jtf_nation.setText(staff.getNationality());
//                                //split string for DOB
//                                String DOB = (staff.getDOB()).toString();
//                                //System.out.println(DOB);
//                                String[] dateOfBirth = DOB.split("-");
//                                jtf_DOB_dd.setText(dateOfBirth[2]);
//                                jtf_DOB_mm.setText(dateOfBirth[1]);
//                                jtf_DOB_yyyy.setText(dateOfBirth[0]);
//                                jtf_bankAccNo.setText(staff.getBankAccNo());
                                jtf_street_add1.setText(staffRead.getStreetaddress1());
                                jtf_street_add2.setText(staffRead.getStreetaddress2());
                                jtf_city.setText(staffRead.getCity());
                                //jtf_postcode.setText(String.valueOf(staff.getPostcode()));
                                jtf_state.setText(staffRead.getState());
                                //jtf_country.setText(staff.getCountry());
                                String mobileNo = staffRead.getMobilephoneno();
                                //handling exceptions for substring
                                try{
                                    String mobileNo_p1 = mobileNo.substring(0,3);
                                    String mobileNo_p2 = mobileNo.substring(3);
                                    jtf_mobileNo_p1.setText(mobileNo_p1);
                                    jtf_mobileNo_p2.setText(mobileNo_p2);
                                }catch(StringIndexOutOfBoundsException ex){
                                    JOptionPane.showMessageDialog(null,"Oops, there is a problem displaying mobile phone number of the staff.\nSorry for the inconvenience caused","Error",JOptionPane.ERROR_MESSAGE);
                                    jtf_mobileNo_p1.setText("000");
                                    jtf_mobileNo_p2.setText("0000000");
                                }
                                catch(Exception ex){
                                    JOptionPane.showMessageDialog(null,"Oops, there is a problem displaying mobile phone number of the staff.\nSorry for the inconvenience caused","Error",JOptionPane.ERROR_MESSAGE);
                                    jtf_mobileNo_p1.setText("000");
                                    jtf_mobileNo_p2.setText("0000000");
                                }
                                try{
                                    String homeNo = staffRead.getHomephoneno();
                                    String homeNo_p1 = homeNo.substring(0,2);
                                    String homeNo_p2 = homeNo.substring(2);
                                    jtf_homeNo_p1.setText(homeNo_p1);
                                    jtf_homeNo_p2.setText(homeNo_p2);
                                }catch(StringIndexOutOfBoundsException ex){
                                    JOptionPane.showMessageDialog(null,"Oops, there is a problem displaying home phone number of the staff.\nSorry for the inconvenience caused","Error",JOptionPane.ERROR_MESSAGE);
                                    jtf_homeNo_p1.setText("00");
                                    jtf_homeNo_p2.setText("0000000");
                                }
                                catch(Exception ex){
                                    JOptionPane.showMessageDialog(null,"Oops, there is a problem displaying home phone number of the staff.\nSorry for the inconvenience caused","Error",JOptionPane.ERROR_MESSAGE);
                                    jtf_homeNo_p1.setText("00");
                                    jtf_homeNo_p2.setText("0000000");
                                }
                                jtf_email.setText(staffRead.getEmailaddress());
                                jtf_staffID.setText(staffRead.getStaffid());
                                jtf_position.setText(staffRead.getPosition());
                                jtf_salary.setText(String.valueOf(staffRead.getSalary()));
//                                jtf_wage.setText(String.valueOf(staff.getWages()));
//                                String hireDate = (staff.getHireDate()).toString();
//                                String[] hireDateArr = hireDate.split("-");
//                                jtf_hireDate_dd.setText(hireDateArr[2]);
//                                jtf_hireDate_mm.setText(hireDateArr[1]);
//                                jtf_hireDate_yyyy.setText(hireDateArr[0]);
//                                jtf_emp_stat.setText(staff.getEmpStat());
                        }
                            else{
                                JOptionPane.showMessageDialog(null, "The staff ID entered cannot be found.\nPlease re-enter another staff ID to retrieve information.", "Staff ID Not Found", JOptionPane.WARNING_MESSAGE);
                                jtfStaffID.setText("");
                                jtfStaffID.requestFocusInWindow();
                            }

                    }    
            }
            else if(e.getSource() == jbtReset){
                jtf_fname.setText("");
                jtf_lname.setText("");
                jtf_gender.setText("");
//                jtf_IC_p1.setText("");
//                jtf_IC_p2.setText("");
//                jtf_IC_p3.setText("");
//                jtf_nation.setText("");
//                jtf_DOB_dd.setText("");
//                jtf_DOB_mm.setText("");
//                jtf_DOB_yyyy.setText("");
//                jtf_bankAccNo.setText("");
                jtf_street_add1.setText("");
                jtf_street_add2.setText("");
                jtf_city.setText("");
                //jtf_postcode.setText("");
                jtf_state.setText("");
                //jtf_country.setText("");
                jtf_mobileNo_p1.setText("");
                jtf_mobileNo_p2.setText("");
                jtf_homeNo_p1.setText("");
                jtf_homeNo_p2.setText("");
                jtf_email.setText("");
                jtf_staffID.setText("");
                jtf_position.setText("");
                jtf_salary.setText("");
//                jtf_wage.setText("");
//                jtf_hireDate_dd.setText("");
//                jtf_hireDate_mm.setText("");
//                jtf_hireDate_yyyy.setText("");
//                jtf_emp_stat.setText("");
                
                jtfStaffID.setText("");
                jtfStaffID.requestFocusInWindow();
            }
            else if(e.getSource() == jbtBack){
                int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to return to previous page?","Confirm?",JOptionPane.YES_NO_OPTION);
                
                if(confirm == JOptionPane.YES_OPTION){
                    dispose();
                    staffControl.closeDB();
                    //call submenu
                    //new StaffAndMembershipMenu();
                    new StaffMenu(accType);
                
                }
            }
            else if(e.getSource() == jbtMainMenu){
                int confirm = JOptionPane.showConfirmDialog(null,"Are you sure to return to Main Menu?","Confirm?",JOptionPane.YES_NO_OPTION);
                
                if(confirm == JOptionPane.YES_OPTION){
                    dispose();
                    staffControl.closeDB();
                    //new Home();
                    new homePage(accType);
                }
            }
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            int confirm = JOptionPane.showConfirmDialog(null,"Return to the Staff Submenu?","Return?",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                    dispose();
                    staffControl.closeDB();
                    //new StaffAndMembershipMenu();
                    new StaffMenu(accType);
        }
            else{
                
            }
       }
    }
    
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        //////////////////////////////////
        new StaffInfoRetrieval('A');//test dev only, REMOVE BEFORE FINAL RELEASE
        ///////////////////////////////////////
    }
}