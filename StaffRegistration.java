//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.sql.*;

import da.*;
import ui.*;
import domain.*;
import control.*;

public class StaffRegistration extends JFrame{

    private char accType;
    
    private Staff staffRead;
    
    private Staff staffIn;
    
    private MaintainStaff staffControl;

    private JButton jbtSave = new JButton("Save");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack = new JButton("Back");
    private JButton jbtMainMenu = new JButton("Main Menu");
    
    //gender radio buttons
    private ButtonGroup genderBtg = new ButtonGroup();
    private JRadioButton jrbMale = new JRadioButton("Male");
    private JRadioButton jrbFemale = new JRadioButton("Female");
    
    private String[] states = new String[]{
        "Kedah",
        "Pulau Pinang",
        "Selangor",
        "Perlis",
        "Pahang",
        "Terengganu",
        "Kelantan",
        "Perak",
        "Melaka",
        "Negeri Sembilan",
        "Johor",
        "Sabah",
        "Sarawak",
        "W. Persekutuan",
        "Putrajaya",
        "Labuan",
        
    };
//    
//    //combo box
//    private JComboBox jcboCountries = new JComboBox(countries);
    private JComboBox jcboStates = new JComboBox(states);
    
    // Top portion labels
    private JLabel lb_welcome = new JLabel("Welcome to the ezWay Bus Ticketing System",SwingConstants.CENTER);
    private JLabel lb_instruction = new JLabel("Please fill in the following particulars accordingly.",SwingConstants.CENTER);
     
    //Group A: Personal Information JLabels
    private JLabel lb_fname = new JLabel("First Name:");
    private JLabel lb_lname = new JLabel("Last Name:");
    private JLabel lb_gender = new JLabel("Gender:");
//    private JLabel lb_NRIC = new JLabel("NRIC: ");
//    private JLabel lb_nation = new JLabel("Nationality:");
//    private JLabel lb_DOB = new JLabel("Date of Birth:");
//    private JLabel lb_bankAccNo = new JLabel("Bank Account Number:");
    
    
    //Group B: Address Information
    private JLabel lb_street_add1 = new JLabel("Street Address 1:");
    private JLabel lb_street_add2 = new JLabel("Street Address 2:");
    private JLabel lb_city = new JLabel("CIty:");
    //private JLabel lb_postcode = new JLabel("Postcode:");
    private JLabel lb_state = new JLabel("State:");
//    private JLabel lb_country = new JLabel("Country:");
    
    //Group C: Contact Information
    private JLabel lb_mobileNo = new JLabel("Phone Number (Mobile):");
    private JLabel lb_homeNo = new JLabel("Phone Number (Home):");
    private JLabel lb_email = new JLabel("Email Address:");
    
    //Group D: Employment Related Information
    private JLabel lb_staffID = new JLabel("Staff ID:");
    private JLabel lb_position = new JLabel("Position:");
    private JLabel lb_salary = new JLabel("Salary: ");
//    private JLabel lb_wage = new JLabel("Wage (If applicable): ");
//    private JLabel lb_hireDate = new JLabel("Hire Date:");
//    private JLabel lb_emp_stat = new JLabel("Employment Status:");
//    
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
    //private JTextField jtf_state = new JTextField(15);
//    private JTextField jtf_country = new JTextField(25);
    
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
     Image img = Toolkit.getDefaultToolkit().getImage(  
     StaffRegistration.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    private JPanel outer_NORTH = new JPanel(new GridLayout(5,1));
    
    private JPanel outer_SOUTH = new JPanel(new GridLayout(2,1));
    
    private JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,30,5));
     
    private JPanel big_container = new JPanel(new GridLayout(2,2,0,0));
    private JPanel groupA = new JPanel(new GridLayout(6,1,0,0)); //10 1 0 0
    private JPanel groupB = new JPanel(new GridLayout(6,1,0,0)); //8 1 0 0
    private JPanel groupC = new JPanel(new GridLayout(5,1,0,0));
    private JPanel groupD = new JPanel(new GridLayout(5,1,0,0));
    
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
    //Note: The color for city and state label is specially set to white and do not follow jlbColor to make it visible under dark background
    Color jlbColor = new Color(0, 0, 0);
    
    //Staff class obj variable
    //Staff staff;
    
    //Staff variable for checking existence
    //Staff staffRead;
    
    //Staff class variables
    //data fields are in db form(what db receive or give out)
    private String staffID;
    private String fname;
    private String lname;
    private String gender;
    private String NRIC;
    private java.sql.Date DOB;
    private String nationality;
    private String bankAccNo;
    private String street_add_1;
    private String street_add_2;
    private String postcode;
    private String city;
    private String state;
    private String country;
    private String homePhoneNo;
    private String mobilePhoneNo;
    private String email;
    private String position;
    private String empStat;
    private double salary;
    private double wages;
    private java.sql.Date hireDate;
    
    public StaffRegistration(){
        
    }
    
    public StaffRegistration(char accType){
        
        this.accType = accType;
        
        staffControl = new MaintainStaff();
        
        //set Max limit for TextFields
        jtf_fname.setDocument(new JTextFieldLimit(15));
        jtf_lname.setDocument(new JTextFieldLimit(15));
        jtf_street_add1.setDocument(new JTextFieldLimit(25));
        jtf_street_add2.setDocument(new JTextFieldLimit(25));
        jtf_city.setDocument(new JTextFieldLimit(15));
        jtf_email.setDocument(new JTextFieldLimit(30));
        jtf_position.setDocument(new JTextFieldLimit(15));
        //salary textfield cannot be set
        jtf_mobileNo_p1.setDocument(new JTextFieldLimit(3));
        jtf_mobileNo_p2.setDocument(new JTextFieldLimit(8));
        jtf_homeNo_p1.setDocument(new JTextFieldLimit(2));
        jtf_homeNo_p2.setDocument(new JTextFieldLimit(7));
        
        //setting Fonts for group title
        lb_groupA.setFont(groupTitle);
        lb_groupB.setFont(groupTitle);
        lb_groupC.setFont(groupTitle);
        lb_groupD.setFont(groupTitle);
        
        //setting Fonts for welcome message
        lb_welcome.setFont(wlcFont);
        lb_instruction.setFont(wlcFont);

        //adding border
        outer_NORTH.setBorder(new LineBorder(Color.BLACK));
        big_container.setBorder(new LineBorder(Color.BLACK));
        
        //setting JButton colors
        jbtSave.setBackground(jbtColor);
        jbtReset.setBackground(jbtColor);
        jbtBack.setBackground(jbtColor);
        jbtMainMenu.setBackground(jbtColor);
        
        //setting color for wording
        //lb_Title.setForeground(jlbColor);
        lb_city.setForeground(new Color(255,255,255));//specially set to make the label visible in the darker green background
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
        //lb_notice.setForeground(jlbColor);
        lb_position.setForeground(jlbColor);
        lb_salary.setForeground(jlbColor);
        lb_staffID.setForeground(jlbColor);
        lb_state.setForeground(new Color(255,255,255));//specially set to make the label visible in the darker green background
        lb_street_add1.setForeground(jlbColor);
        lb_street_add2.setForeground(jlbColor); 
        //lbstaffIDup.setForeground(jlbColor);
        
        //setting Mnemonics
        jbtSave.setMnemonic('S');
        jbtReset.setMnemonic('R');
        jbtBack.setMnemonic('B');
        jbtMainMenu.setMnemonic(('M'));
        
        //setOpaque for all upper JPanels
        outer_NORTH.setOpaque(false);
        big_container.setOpaque(false);
        outer_SOUTH.setOpaque(false);
        
        groupA.setOpaque(false);
        groupB.setOpaque(false);
        groupC.setOpaque(false);
        groupD.setOpaque(false);
        groupA_r1.setOpaque(false);
        groupA_r2.setOpaque(false);
        groupA_r3.setOpaque(false);
        groupA_r4.setOpaque(false);
        groupA_r5.setOpaque(false);
//        groupA_r6.setOpaque(false);
//        groupA_r7.setOpaque(false);
//        groupA_r8.setOpaque(false);
//        groupA_r9.setOpaque(false);
        
        groupB_r1.setOpaque(false);
        groupB_r2.setOpaque(false);
        groupB_r3.setOpaque(false);
        groupB_r4.setOpaque(false);
        groupB_r5.setOpaque(false);
        groupB_r6.setOpaque(false);
        groupB_r7.setOpaque(false);
//        groupB_r8.setOpaque(false);
        
        groupC_r1.setOpaque(false);
        groupC_r2.setOpaque(false);
        groupC_r3.setOpaque(false);
        groupC_r4.setOpaque(false);
        
        groupD_r1.setOpaque(false);
        groupD_r2.setOpaque(false);
        groupD_r3.setOpaque(false);
        groupD_r4.setOpaque(false);
        groupD_r5.setOpaque(false);
//        groupD_r6.setOpaque(false);
//        groupD_r7.setOpaque(false);
//        groupD_r8.setOpaque(false);

        jrbMale.setOpaque(false);
        jrbFemale.setOpaque(false);
        jrbMale.setSelected(true);
        
        //add radio buttons to button group
        genderBtg.add(jrbMale);
        genderBtg.add(jrbFemale);
        
        //ToBeDisabled
//        jrbPT.setOpaque(false);
//        jrbPM.setOpaque(false);
//        jrbPT.setSelected(true);
//        
        //ToBeDisabled
//        empStatBtg.add(jrbPT);
//        empStatBtg.add(jrbPM);
//        
        
        buttonPanel.setOpaque(false);
 
        setLayout(new BorderLayout());
        setTitle("Staff Registration");
        setSize(900,705);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

         //top portion panel
        outer_NORTH.add(new JLabel());
        outer_NORTH.add(lb_welcome);
        outer_NORTH.add(lb_instruction);
        
        groupA_r1.add(lb_groupA);
        //groupA_r2.add(new JLabel());
        groupA_r3.add(lb_fname);
        groupA_r3.add(jtf_fname);
        groupA_r4.add(lb_lname);
        groupA_r4.add(jtf_lname);
        groupA_r5.add(lb_gender);
        groupA_r5.add(jrbMale);
        groupA_r5.add(jrbFemale);
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
        //groupB_r2.add(new JLabel());
        groupB_r3.add(lb_street_add1);
        groupB_r3.add(jtf_street_add1);
        groupB_r4.add(lb_street_add2);
        groupB_r4.add(jtf_street_add2);
        groupB_r5.add(lb_city);
        groupB_r5.add(jtf_city);
//        groupB_r6.add(lb_postcode);
//        groupB_r6.add(jtf_postcode);
        groupB_r7.add(lb_state);
        groupB_r7.add(jcboStates);
//        groupB_r7.add(jtf_state);
//        groupB_r8.add(lb_country);
//        groupB_r8.add(jcboCountries);
        
        groupB.add(groupB_r1);
        //groupB.add(groupB_r2);
        groupB.add(groupB_r3);
        groupB.add(groupB_r4);
        groupB.add(groupB_r5);
        //groupB.add(groupB_r6);
        groupB.add(groupB_r7);
//        groupB.add(groupB_r8);
        
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
        //groupD_r2.add(new JLabel());
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
//        groupD_r8.add(jrbPT);
//        groupD_r8.add(jrbPM);
        
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
        
        //buttonPanels
        buttonPanel.add(jbtSave);
        buttonPanel.add(jbtReset);
        buttonPanel.add(jbtBack);
        buttonPanel.add(jbtMainMenu);
        
        //adding blank JLabels and buttonPanel to outer_SOUTH
        outer_SOUTH.add(new JLabel());
        outer_SOUTH.add(buttonPanel);
        
        global.add(outer_NORTH,BorderLayout.NORTH);
        global.add(big_container,BorderLayout.CENTER);
        global.add(outer_SOUTH,BorderLayout.SOUTH);
        
        add(global,BorderLayout.CENTER);
        
        
        jtf_fname.requestFocusInWindow();
        
        //register button listeners
        jbtSave.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener());
        jbtMainMenu.addActionListener(new ButtonListener());
        
        /*jcboCountries.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                int selectedIndex = jcboCountries.getSelectedIndex();
                
                country = countries[selectedIndex];
            }
                    });*/
        //jcboCountries.setSelectedItem("Malaysia");
        country = "Malaysia";
        
        jcboStates.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                int selectedIndex = jcboStates.getSelectedIndex();
                
                /*if(states[selectedIndex].equals("Others")){
                    jtf_state.setEditable(true);
                    jtf_state.requestFocusInWindow();
                    //DO NOT REMOVE
                    state = states[selectedIndex]; //temporarily store "Others" for entering the if statement in the bottom code,which will then update the state variable with the value of the state textfield
                    //DO NOT REMOVE
                    
                }
                else{
                    jtf_state.setEditable(false);
                    state = states[selectedIndex];
                }*/
                
                //newly added
                state = states[selectedIndex];
            }
        });
        
        jcboStates.setSelectedItem("Kedah");
        state = "Kedah";
        //jtf_state.setEditable(false);
        
        jtf_staffID.setEditable(false);
        
        //register window listener
        addWindowListener(new WindowListener());
        
        getRootPane().setDefaultButton(jbtSave);
        
//        // To auto generate staffID
//        String latestStaffID = "";
//        String nextStaffID = "";
//        int sqnNo = 0;
//        String nextSqnNo = "";
//        latestStaffID = staffControl.getLatestID();
//        
//        //temporary assigned value
//        //latestStaffID = "STF0001";
//        
//        sqnNo = Integer.parseInt(latestStaffID.substring(3));
//        sqnNo+=1;
//        nextSqnNo = String.valueOf(sqnNo);
//        int nextSqnLength = 0;
//        nextSqnLength = nextSqnNo.length();
//        while(nextSqnLength < 4){
//            nextSqnNo = "0" + nextSqnNo;
//            nextSqnLength = nextSqnNo.length();
//        }
//        
//        nextStaffID = "STF" + nextSqnNo;
//
//        jtf_staffID.setText(nextStaffID);
//        staffID = nextStaffID;
        
        setIcon();
        setVisible(true);
        resetPage(); //includes initialization of auto generated next staffID
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtSave){
                boolean inputValidity = true;
                
                boolean fnameValidity = true;
                boolean lnameValidity = true;
//                boolean NRICValidity = true;
//                boolean DOBValidity = true;
//                boolean nationalityValidity = true;
//                boolean bankAccNoValidity = true;
                boolean cityValidity = true;
                boolean emailValidity = true;
//                boolean postcodeValidity = true;
                boolean homePhoneNoValidity = true;
                boolean mobilePhoneNoValidity = true;
                boolean positionValidity = true;
//                boolean empStatValidity = true;
                boolean salaryValidity = true;
//                boolean wagesValidity = true;
//                boolean hireDateValidity = true;
                
                boolean emptyField = false;

                    if(jtf_fname.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_lname.getText().equals("")){
                        emptyField = true;
                    }
                    /*if(jtf_IC_p1.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_IC_p2.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_IC_p3.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_DOB_dd.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_DOB_mm.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_DOB_yyyy.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_bankAccNo.getText().equals("")){
                        emptyField = true;
                    }*/
                    if(jtf_street_add1.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_street_add2.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_city.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_homeNo_p1.getText().equals("")){
                        emptyField = true;
                    }
                    else if(jtf_homeNo_p2.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_mobileNo_p1.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_mobileNo_p2.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_email.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_position.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_salary.getText().equals("")){
                        emptyField = true;
                    }
                    /*if(jtf_wage.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_hireDate_dd.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_hireDate_mm.getText().equals("")){
                        emptyField = true;
                    }
                    if(jtf_hireDate_yyyy.getText().equals("")){
                        emptyField = true;
                    }*/
                    
                    //display a message if emptyField is true
                    if(emptyField){
                        JOptionPane.showMessageDialog(null, "Some fields are left empty. Please fill in all the fields before clicking the save button.\n Enter \"000000 00 0000\" for NRIC, \"0.0\" for salary or \"0.0\" wage if the field is not applicable.\n Enter \"-\" for street address 2 is it is not applicable.\n DO NOT leave any fields blank.","Empty field(s)",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        
                    //first name validation    
                    fname = jtf_fname.getText().trim();
                    for(int n = 0; n < fname.length(); n++){
                        if(Character.isLetter(fname.charAt(n))){
                            fnameValidity = true;
                        }
                        else{
                            fnameValidity = false;
                            break;
                        }
                    }
                    if(!fnameValidity){
                        JOptionPane.showMessageDialog(null, "Invalid first name.\nFirst name must consists of alphabets only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        jtf_fname.requestFocusInWindow();
                    }
                    
                    //last name validation
                    lname = jtf_lname.getText().trim();
                    for(int v = 0; v < lname.length(); v++){
                        if(Character.isLetter(lname.charAt(v))){
                            lnameValidity = true;
                        }
                        else{
                            lnameValidity = false;
                            break;
                        }
                    }
                    if(!lnameValidity){
                        JOptionPane.showMessageDialog(null, "Invalid last name.\nLast name must consists of alphabets only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        jtf_lname.requestFocusInWindow();
                    }
                    
                    //new handling for gender for radio buttons
                    if(jrbMale.isSelected()){
                        gender = "M";
                    }
                    else if(jrbFemale.isSelected()){
                        gender = "F";
                    }
                                                            
                    // special handling for NRIC
                    /*String NRIC_combi = jtf_IC_p1.getText().trim() + jtf_IC_p2.getText().trim() + jtf_IC_p3.getText().trim();
                    if(jtf_IC_p1.getText().trim().length() != 6 || jtf_IC_p2.getText().trim().length() != 2 || jtf_IC_p3.getText().trim().length() != 4){
                        JOptionPane.showMessageDialog(null,"Invalid NRIC format, please enter a valid NRIC number.\nPlease enter 000000 00 0000 if NRIC is not applicable to the current staff.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        NRICValidity = false;
                        jtf_IC_p1.setText("");
                        jtf_IC_p2.setText("");
                        jtf_IC_p3.setText("");
                        jtf_IC_p1.requestFocusInWindow();
                    }
                    else{
                        
                        for(int i = 0;i < NRIC_combi.length();i++){
                        if(!Character.isDigit(NRIC_combi.charAt(i))){
                            JOptionPane.showMessageDialog(null,"Invalid NRIC format, please enter a valid NRIC number.\nPlease enter 000000 00 0000 if NRIC is not applicable to the current staff.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                            jtf_IC_p1.setText("");
                            jtf_IC_p2.setText("");
                            jtf_IC_p3.setText("");
                            jtf_IC_p1.requestFocusInWindow();
                            NRICValidity = false;
                            break;
                        }
                        else{
                            NRICValidity = true;
                        }
                      }
                    }
    
                    NRIC = NRIC_combi;*/
                    
                                        
                    //handling for DOB
                    /*int DOB_dd = 0;
                    int DOB_mm = 0;
                    int DOB_yyyy = 0;
                            
                    try{
                        DOB_dd = Integer.parseInt(jtf_DOB_dd.getText());
                        DOB_mm = Integer.parseInt(jtf_DOB_mm.getText());
                        DOB_yyyy = Integer.parseInt(jtf_DOB_yyyy.getText());
                        
                        if(DOB_dd < 1 || DOB_dd > 31){
                            DOBValidity = false;
                        }
                        else{
                            DOBValidity = true;
                        }
                        if(DOB_mm < 1 || DOB_mm > 12){
                            DOBValidity = false;
                        }
                        else{
                            DOBValidity = true;
                        }
                        if(DOB_yyyy < 1930){
                            DOBValidity = false;
                        }
                        else{
                            DOBValidity = true;
                        }
                        
                    }catch(NumberFormatException ex){
                        if(!emptyField){ // if emptyField is not triggered
                            JOptionPane.showMessageDialog(null, "Invalid date of birth.\n Please ensure that the date of birth is correct.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                            jtf_DOB_dd.setText("");
                            jtf_DOB_mm.setText("");
                            jtf_DOB_yyyy.setText("");
                            jtf_DOB_dd.requestFocusInWindow();
                            DOBValidity = false;
                        }
                    }
                    catch(Exception ex){
                        if(!emptyField){ // if emptyField is not triggered
                            JOptionPane.showMessageDialog(null, "Invalid date of birth.\n Please ensure that the date of birth is correct.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                            jtf_DOB_dd.setText("");
                            jtf_DOB_mm.setText("");
                            jtf_DOB_yyyy.setText("");
                            jtf_DOB_dd.requestFocusInWindow();
                            DOBValidity = false;
                        }
                    }
                    if(DOBValidity == false){
                        JOptionPane.showMessageDialog(null, "Invalid date of birth.\n Please ensure that the date of birth is correct.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        jtf_DOB_dd.setText("");
                        jtf_DOB_mm.setText("");
                        jtf_DOB_yyyy.setText("");
                        jtf_DOB_dd.requestFocusInWindow();
                    }
                    try{
                        DOB = java.sql.Date.valueOf(DOB_yyyy + "-" + DOB_mm + "-" + DOB_dd);
                    }catch(IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(null, "Invalid date of birth.\n Please ensure that the date of birth is correct.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        jtf_DOB_dd.setText("");
                        jtf_DOB_mm.setText("");
                        jtf_DOB_yyyy.setText("");
                        jtf_DOB_dd.requestFocusInWindow();
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Invalid date of birth.\n Please ensure that the date of birth is correct.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        jtf_DOB_dd.setText("");
                        jtf_DOB_mm.setText("");
                        jtf_DOB_yyyy.setText("");
                        jtf_DOB_dd.requestFocusInWindow();
                    }
                    
                    nationality = jtf_nation.getText().trim();
                    for(int k = 0; k < nationality.length(); k++){
                            if(Character.isLetter(nationality.charAt(k)) || nationality.charAt(k) == ' '){
                                nationalityValidity = true;
                            }
                            else{
                                nationalityValidity = false;
                                break;
                            }
                        }
                        if(!nationalityValidity){
                            JOptionPane.showMessageDialog(null, "Invalid nationality.\nNationality must consists of alphabets only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                            jtf_nation.requestFocusInWindow();
                        }
                    
                    //input checking for bank acc no
                    bankAccNo = jtf_bankAccNo.getText().trim();
                    for(int j = 0; j < bankAccNo.length(); j++){
                        if(!Character.isDigit(bankAccNo.charAt(j))){
                            JOptionPane.showMessageDialog(null,"Invalid bank account number, please enter a valid bank account number.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                            jtf_bankAccNo.setText("");
                            jtf_bankAccNo.requestFocusInWindow();
                            bankAccNoValidity = false;
                            break;
                            
                        }
                        else{
                            bankAccNoValidity = true;
                        }
                    }*/
                    
                    street_add_1 = jtf_street_add1.getText().trim();
                    street_add_2 = jtf_street_add2.getText().trim();

                    /*postcode = jtf_postcode.getText().trim();
                    if(postcode.length() != 5){
                        JOptionPane.showMessageDialog(null,"Invalid postcode, please enter a valid postcode.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        postcodeValidity = false;
                        jtf_postcode.setText("");
                        jtf_postcode.requestFocusInWindow();
                    }
                    else{
                        for(int z = 0; z < postcode.length(); z++){
                            if(!Character.isDigit(postcode.charAt(z))){
                                JOptionPane.showMessageDialog(null,"Invalid postcode, please enter a valid postcode.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                                postcodeValidity = false;
                                jtf_postcode.setText("");
                                jtf_postcode.requestFocusInWindow();
                            }
                            else{
                                postcodeValidity = true;
                            }
                        }
                    }*/
                    
                    city = jtf_city.getText().trim();
                    for(int g = 0; g < city.length(); g++){
                            if(Character.isLetter(city.charAt(g)) || city.charAt(g) == ' '){
                                cityValidity = true;
                            }
                            else{
                                cityValidity = false;
                                break;
                            }
                        }
                        if(!cityValidity){
                            JOptionPane.showMessageDialog(null, "Invalid city.\nCity must consists of alphabets only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                            jtf_city.requestFocusInWindow();
                        }

                    
                    //handling for home phone number
                    String homePhoneNo_combi = jtf_homeNo_p1.getText() + jtf_homeNo_p2.getText();
                    //checking length
                    if(jtf_homeNo_p1.getText().length() != 2 || jtf_homeNo_p2.getText().length() != 7){
                        JOptionPane.showMessageDialog(null, "Invalid home phone number detected.\nPlease enter a valid home phone number.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        homePhoneNoValidity = false;
                        jtf_homeNo_p1.setText("");
                        jtf_homeNo_p2.setText("");
                        jtf_homeNo_p1.requestFocusInWindow();
                    }
                    else{
                        for(int k = 0; k < homePhoneNo_combi.length(); k++){
                            if(!Character.isDigit(homePhoneNo_combi.charAt(k))){
                                JOptionPane.showMessageDialog(null,"Invalid home phone number, please enter a valid home phone number.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                                jtf_homeNo_p1.setText("");
                                jtf_homeNo_p2.setText("");
                                jtf_homeNo_p1.requestFocusInWindow();
                                homePhoneNoValidity = false;
                                break;
                            }
                            else{
                                homePhoneNoValidity = true;
                            }
                        }
                    }
                    homePhoneNo = homePhoneNo_combi;
                    
                                        
                    //handling for mobile phone number
                    String mobilePhoneNo_combi =jtf_mobileNo_p1.getText() + jtf_mobileNo_p2.getText();
                    //check length of mobile phone no
                    if(jtf_mobileNo_p1.getText().length() != 3 || jtf_mobileNo_p2.getText().length() < 7){
                        JOptionPane.showMessageDialog(null, "Invalid mobile phone number detected.\nPlease enter a valid mobile phone number.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        mobilePhoneNoValidity = false;
                        jtf_mobileNo_p1.setText("");
                        jtf_mobileNo_p2.setText("");
                        jtf_mobileNo_p1.requestFocusInWindow();
                    }
                    else{
                        for(int x = 0; x < mobilePhoneNo_combi.length(); x++){
                            if(!Character.isDigit(mobilePhoneNo_combi.charAt(x))){
                                JOptionPane.showMessageDialog(null,"Invalid mobile phone number, please enter a valid mobile phone number.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                                jtf_mobileNo_p1.setText("");
                                jtf_mobileNo_p2.setText("");
                                jtf_mobileNo_p1.requestFocusInWindow();
                                mobilePhoneNoValidity = false;
                                break;


                            }
                            else{
                                mobilePhoneNoValidity = true;
                            }
                        }
                    }
                    
                    mobilePhoneNo = mobilePhoneNo_combi;
                    
                    email = jtf_email.getText().trim();
                    int allianceExistence = -1;
                    int dotExistence = -1;
                    allianceExistence = email.indexOf('@');
                    dotExistence = email.indexOf('.');
                    if(allianceExistence == -1 || dotExistence == -1 || email.charAt(0) == '@'){ //mod to add a validation to ensure @ will not be the first character
                        emailValidity = false;
                        JOptionPane.showMessageDialog(null, "Invalid email address format.\n Email addresses should have the following format:\nxxx@yyy.com or xxx@yyy.com.zz\nKindly re-enter a valid email address.", "Invalid Input",JOptionPane.WARNING_MESSAGE);
                        jtf_email.requestFocusInWindow();
                    }
                    else{
                        emailValidity = true;
                    }
                    position = jtf_position.getText().trim();
                    for(int w = 0; w < position.length(); w++){
                            if(Character.isLetter(position.charAt(w)) || position.charAt(w) == ' '){
                                positionValidity = true;
                            }
                            else{
                                positionValidity = false;
                                break;
                            }
                        }
                        if(!positionValidity){
                            JOptionPane.showMessageDialog(null, "Invalid postition.\nPosition must consists of alphabets only.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                            jtf_position.requestFocusInWindow();
                        }

                    //handling for salary (double)
                    double salaryVR = 0.0;
                    try{
                        salaryVR = Double.parseDouble(jtf_salary.getText());
                        salaryValidity = true;
                        
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null,"Invalid salary, please enter a valid salary.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        jtf_salary.setText("");
                        jtf_salary.requestFocusInWindow();
                        salaryValidity = false;
                        
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(null,"Invalid salary, please enter a valid salary.","Invalid Input",JOptionPane.WARNING_MESSAGE);
                        jtf_salary.setText("");
                        jtf_salary.requestFocusInWindow();
                        salaryValidity = false;
                    }
                    salary = salaryVR;

                    //new check
                    if(emptyField == false && fnameValidity && lnameValidity && cityValidity && homePhoneNoValidity && mobilePhoneNoValidity && emailValidity && positionValidity && salaryValidity){
                        inputValidity = true;
                    }
                    else{
                        inputValidity = false;
                    }
                    if(inputValidity == true){ //to prevent execution of query when some input is invalid or left blank
                        staffIn = new Staff(staffID,fname,lname,gender.charAt(0),street_add_1,street_add_2,city,state,position,salary,homePhoneNo,mobilePhoneNo,email);
                        
                        staffRead = staffControl.getRecord(staffID);
                        if(staffRead != null){
                            JOptionPane.showMessageDialog(null,"Unable to create the staff record.\nThe record for the staff ID: " + staffID + " has already exists in the database.\nPlease re-enter a another staff ID or \nuse the update function to update existing staff record.", "Unable To Create Record",JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            int addResult;
                            addResult = staffControl.addRecord(staffIn);
                            
                                        if(addResult > 0){
                                            JOptionPane.showMessageDialog(null,"New record for staff ID: " + staffIn.getStaffid() + " has been created.");
                                            resetPage();
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"Result returned is not a positive integer, new record is not created.","Error",JOptionPane.ERROR_MESSAGE);
                            
                                                }
                        }
                        
                        
                    }
                
                    } 
                
            }
            else if(e.getSource() == jbtReset){
                resetPage();
                
            }
            else if(e.getSource() == jbtBack){
                
                int confirm = JOptionPane.showConfirmDialog(null,"All unsaved changes will be discarded! Confirm go back to previous page?","Confirm?",JOptionPane.YES_NO_OPTION);
                
                if(confirm == JOptionPane.YES_OPTION){
                    dispose();
                    staffControl.closeDB();
                    //call submenu
                    new StaffMenu(accType);
                }
                
            }
            else if(e.getSource() == jbtMainMenu){
                
                int confirm = JOptionPane.showConfirmDialog(null,"All unsaved changes will be discarded! Confirm go back to Main Menu?","Confirm?",JOptionPane.YES_NO_OPTION);
                
                if(confirm == JOptionPane.YES_OPTION){
                    dispose();
                    staffControl.closeDB();
                    new homePage(accType);
                }
                
            }
            
        }
    }
    
     private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            int confirm = JOptionPane.showConfirmDialog(null,"All unsaved changes will be discarded!\nConfirm return to the Staff Submenu?","Return?",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                    
                    staffControl.closeDB();
                    dispose();
                    new StaffMenu(accType);
        }
            else{
                
            }
       }
    }
     
     private void resetPage(){
         
        jtf_fname.setText("");
        jtf_lname.setText("");
        /*jtf_IC_p1.setText("");
        jtf_IC_p2.setText("");
        jtf_IC_p3.setText("");
        jtf_nation.setText("");
        jtf_DOB_dd.setText("");
        jtf_DOB_mm.setText("");
        jtf_DOB_yyyy.setText("");
        jtf_bankAccNo.setText("");*/
        jtf_street_add1.setText("");
        jtf_street_add2.setText("");
        jtf_city.setText("");
//                jtf_postcode.setText("");
        //jtf_state.setText("");
        jtf_mobileNo_p1.setText("");
        jtf_mobileNo_p2.setText("");
        jtf_homeNo_p1.setText("");
        jtf_homeNo_p2.setText("");
        jtf_email.setText("");
        jtf_staffID.setText("");
        jtf_position.setText("");
        jtf_salary.setText("");
        /*jtf_wage.setText("");
        jtf_hireDate_dd.setText("");
        jtf_hireDate_mm.setText("");
        jtf_hireDate_yyyy.setText("");*/

        jrbMale.setSelected(true);
        //jrbPT.setSelected(true);
        jcboStates.setSelectedItem("Kedah");
        //jtf_state.setEditable(false);
        //jcboCountries.setSelectedItem("Malaysia");

        String latestStaffID = "";
        String nextStaffID = "";
        int sqnNo = 0;
        String nextSqnNo = "";
        latestStaffID = staffControl.getLatestID();

        sqnNo = Integer.parseInt(latestStaffID.substring(3));
        sqnNo++;
        nextSqnNo = String.valueOf(sqnNo);
        int nextSqnLength = 0;
        nextSqnLength = nextSqnNo.length();
        while(nextSqnLength < 4){
            nextSqnNo = "0" + nextSqnNo;
            nextSqnLength = nextSqnNo.length();
        }
        
        nextStaffID = "STF" + nextSqnNo;
        jtf_staffID.setText(nextStaffID);
        staffID = nextStaffID;
        
        getRootPane().setDefaultButton(jbtSave);


        jtf_fname.requestFocusInWindow();
     }
     
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
     
    public static void main(String[] args){
        new StaffRegistration('A');//////////////////////////dev//////////////////////
    }
            
}