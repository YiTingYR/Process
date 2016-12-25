// Name: Sum Weng Fai       Tutorial Group: 2DIA2
//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import da.*;
import ui.*;
import domain.*;
import control.*;


public class AddNewUser extends JFrame{
    
    private char accType;
    
    Staff staffResult;
    
    private MaintainStaff staffControl;
    
    private MaintainLogin loginControl;
    
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    private JPanel logoPanel = new JPanel(new FlowLayout());
    
    private JLabel jlbTitle = new JLabel("Add a new user", SwingConstants.CENTER);
    private JLabel jlbUserName = new JLabel("Username: ");
    private JLabel jlbPassword = new JLabel("Password: ");
    private JLabel jlbConfirmPW = new JLabel("Confirm password: ");
    private JLabel jlbStaffID = new JLabel("Staff ID: ");
    private JLabel jlbAccType = new JLabel("Account Type: ");
    private JLabel jlbSecQues = new JLabel("Security Question: ");
    private JLabel jlbSecAns = new JLabel("Security Answer: ");
    
    
    private JButton jbtRegister = new JButton("Register");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack = new JButton("Back");
    private JButton jbtCheck = new JButton("Check");
    private JButton jbtClear = new JButton("Reset");
    
    private JTextField jtfUsername = new JTextField(12);
    private JTextField jtfStaffID = new JTextField(7);
//    private JPasswordField jpfPassword = new JPasswordField(12);
//    private JPasswordField jpfConfirmPW = new JPasswordField(12);
    private JTextField jtfPassword = new JTextField(12);
    private JTextField jtfConfirmPW = new JTextField(12);
    private JComboBox jcbAccType = new JComboBox(new String[]{"Admin", "User"});
    
    //stored in a String array because the database will only store question number
    private String[] secQues = {"1. What is your favourite food?","2. What is your favourite movie?", "3. What is your year of marriage?", "4. What is your hobby?"};
    private JComboBox jcbSecQues = new JComboBox(secQues);
    private JTextField jtfSecAns = new JTextField(25);
    
    
    
    private JPanel global = new JPanel(new BorderLayout()) {  
    public void paintComponent(Graphics g) {  
     Image img1 = Toolkit.getDefaultToolkit().getImage(  
     AddNewUser.class.getResource("../images/green4.jpg"));  
     g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  };
    
    private JPanel upperPanel = new JPanel(new BorderLayout());
    private JPanel middlePanel = new JPanel(new GridLayout(12,1)); //4,1 7，1
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel middle_r1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
    private JPanel middle_r3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    private JPanel middle_r5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r9 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
    private JPanel containMiddle = new JPanel(new FlowLayout());
    
    // Fonts
    private Font myFont1 = new Font("Comic Sans MS",Font.PLAIN,14);
    private Font myFont2 = new Font("Comic Sans MS",Font.PLAIN,18);
     //Font Color
    private Color fontColor = new Color(0,0,0);
    
    private Color btnColor = new Color(214, 239, 159);
    
    
    public AddNewUser(){
        
    }
    
    public AddNewUser(char accType){
        
        this.accType = accType;
        
        setLayout(new BorderLayout());
        staffControl = new MaintainStaff();
        loginControl = new MaintainLogin();
        
        //set TextFields max limit
        jtfStaffID.setDocument(new JTextFieldLimit(7));
        jtfPassword.setDocument(new JTextFieldLimit(20));
        jtfConfirmPW.setDocument(new JTextFieldLimit(20));
        jtfUsername.setDocument(new JTextFieldLimit(15));
        jtfSecAns.setDocument(new JTextFieldLimit(25));
        
        jlbTitle.setFont(myFont2);
        jlbUserName.setFont(myFont1);
        jlbPassword.setFont(myFont1);
        jlbConfirmPW.setFont(myFont1);
        jlbStaffID.setFont(myFont1);
        jlbAccType.setFont(myFont1);
        jlbSecQues.setFont(myFont1);
        jlbSecAns.setFont(myFont1);
        
        jbtRegister.setFont(myFont1);
        jbtReset.setFont(myFont1);
        jbtBack.setFont(myFont1);
        
        jlbTitle.setForeground(fontColor);
        jlbUserName.setForeground(fontColor);
        jlbPassword.setForeground(fontColor);
        jlbConfirmPW.setForeground(fontColor);
        jlbStaffID.setForeground(fontColor);
        jlbAccType.setForeground(fontColor);
        jlbSecQues.setForeground(fontColor);
        jlbSecAns.setForeground(fontColor);
        
        jbtRegister.setBackground(btnColor);
        jbtReset.setBackground(btnColor);
        jbtBack.setBackground(btnColor);
        jbtCheck.setBackground(btnColor);
        jbtClear.setBackground(btnColor);
        
        
        upperPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        containMiddle.setOpaque(false);
        middle_r1.setOpaque(false);
        middle_r2.setOpaque(false);
        middle_r3.setOpaque(false);
        middle_r4.setOpaque(false);
        middle_r5.setOpaque(false);
        middle_r6.setOpaque(false);
        middle_r7.setOpaque(false);
        middle_r8.setOpaque(false);
        middle_r9.setOpaque(false);
        logoPanel.setOpaque(false);
        
        logoPanel.add(logo);
        
        upperPanel.add(logoPanel, BorderLayout.NORTH);
        upperPanel.add(jlbTitle, BorderLayout.SOUTH);
        middle_r1.add(jlbStaffID);
        middle_r1.add(jtfStaffID);
        middle_r2.add(jbtCheck);
        middle_r2.add(jbtClear);
        middle_r3.add(jlbUserName);
        middle_r3.add(jtfUsername);
        middle_r4.add(jlbPassword);
        middle_r4.add(jtfPassword);
        middle_r5.add(jlbConfirmPW);
        middle_r5.add(jtfConfirmPW);
//        middle_r4.add(jlbStaffID);
//        middle_r4.add(jtfStaffID);
        middle_r6.add(jlbAccType);
        middle_r6.add(jcbAccType);
        middle_r7.add(jlbSecQues);
        middle_r7.add(jcbSecQues);
        middle_r8.add(jlbSecAns);
        middle_r8.add(jtfSecAns);
        middle_r9.add(jbtRegister);
        middle_r9.add(jbtReset);
        middle_r9.add(jbtBack);
        
        
        middlePanel.add(new JLabel());
        middlePanel.add(middle_r1);
        middlePanel.add(middle_r2);
        middlePanel.add(new JLabel());
        middlePanel.add(middle_r3);
        middlePanel.add(middle_r4);
        middlePanel.add(middle_r5);
        middlePanel.add(middle_r6);
        middlePanel.add(middle_r7);
        middlePanel.add(middle_r8);
        //middlePanel.add(new JLabel());
        middlePanel.add(middle_r9);
        containMiddle.add(middlePanel);
        
        
        
        global.add(upperPanel, BorderLayout.NORTH);
        global.add(containMiddle, BorderLayout.CENTER);
        
        add(global, BorderLayout.CENTER);
        
        //register button listener
        jbtRegister.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener());
        jbtCheck.addActionListener(new ButtonListener());
        jbtClear.addActionListener(new ButtonListener());
        
        addWindowListener(new WindowListener());
        
        jbtRegister.setMnemonic('S');
        jbtReset.setMnemonic('R');
        jbtBack.setMnemonic('B');
        jbtCheck.setMnemonic('C');
        jbtClear.setMnemonic('E');
        
        
        getRootPane().setDefaultButton(jbtCheck);
        
        //disable initially
        jtfUsername.setEditable(false);
        jtfPassword.setEditable(false);
        jtfConfirmPW.setEditable(false);
        jcbAccType.setEnabled(false);
        jcbSecQues.setEnabled(false);
        jtfSecAns.setEditable(false);
        jbtRegister.setEnabled(false);
        jbtReset.setEnabled(false);
        
        //set initial combo box selection
        jcbAccType.setSelectedIndex(0);
        jcbSecQues.setSelectedIndex(0);
        
        setIcon();
        setTitle("Add New User");
        setSize(830,680);//830,550
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtRegister){
                //Login loginRead = null;
                boolean lengthValidity = true;
                //MaintainStaff staffControl = new MaintainStaff();
                    
                    if(jtfUsername.getText().equals("") || jtfPassword.getText().equals("") || jtfConfirmPW.getText().equals("") || jtfStaffID.getText().equals("") || jtfSecAns.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Please do not leave any fields blank.", "Blank Fields", JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        //Staff staffRead = staffControl.selectRecord(jtfStaffID.getText());
                        //if(staffResult != null){

                            if(jtfUsername.getText().length() <= 15){
                                Authentication authExist = new Authentication(); //used only for checking whether the new username entered has already exists.
                                String newUserName = jtfUsername.getText();
                                authExist.setUsername(newUserName);

                                char usernameExist = 'X';

                                usernameExist = loginControl.verifyExistence(authExist);
                                if(usernameExist == 'N'){
                                    if(jtfPassword.getText().length() <= 20){
                                        if(jtfSecAns.getText().length() <= 25){
                                            lengthValidity = true;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "The security answer entered is too long.\nPlease confirm that the length of security answer does not exceed 25 characters.", "Security Answer Length", JOptionPane.WARNING_MESSAGE);
                                            lengthValidity = false;
                                        }
                                    }
                                    else{
                                        lengthValidity = false;
                                        JOptionPane.showMessageDialog(null, "The password entered is too long.\nPlease confirm that the length of password does not exceed 20 characters.", "Password Length", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                                else{
                                    lengthValidity = false;
                                    JOptionPane.showMessageDialog(null, "The username entered already exists.\nPlease re-enter an unused username.", "Username Exists", JOptionPane.WARNING_MESSAGE);
                                    jtfUsername.setText("");
                                    jtfUsername.requestFocusInWindow();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "The username entered is too long.\nPlease confirm that the length of username does not exceed 15 characters.", "Username Length", JOptionPane.WARNING_MESSAGE);
                                lengthValidity = false;
                            }

                            if(lengthValidity){
                                
                                if(jtfPassword.getText().equals(jtfConfirmPW.getText())){
                                    
                                    int secQues = jcbSecQues.getSelectedIndex()+1; //combo box selection starts from 0
                                    char accType = 'X';
                                    
                                    int result = -99;
                                    
                                    if(jcbAccType.getSelectedIndex()+1 == 1){//Admin
                                        accType = 'A';
                                    }
                                    else{
                                        accType = 'U';
                                    }
                                    
                                    Authentication authWrite = new Authentication(jtfUsername.getText(), jtfPassword.getText(), accType, secQues, jtfSecAns.getText(), jtfStaffID.getText());
                                    result = loginControl.addUser(authWrite);
                                    
                                    if(result > 0){
                                        JOptionPane.showMessageDialog(null,"User: " + authWrite.getUsername() + " has been successfully created.","Success",JOptionPane.INFORMATION_MESSAGE);
                                        resetPage();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"Result returned is not larger than 0.\nError in creating new user.","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "The password entered does not match.\nPlease confirm your password entered are matched.", "Password Mismatch", JOptionPane.WARNING_MESSAGE);
                                    jtfPassword.setText("");
                                    jtfConfirmPW.setText("");
                                    jtfPassword.requestFocusInWindow();
                                }
                                
                          }//end
                    }
            }
            else if(e.getSource() == jbtReset){
              
//                jtfUsername.setText("");
//                jpfPassword.setText("");
//                jpfConfirmPW.setText("");
//                jcbAccType.setSelectedIndex(0);
//                jcbSecQues.setSelectedIndex(0);
//                jtfSecAns.setText("");
//                    
//                jtfUsername.requestFocusInWindow();
                
                clearFields();
            }
            else if(e.getSource() == jbtBack){
                int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Security Features Submenu?", "Confirm?", JOptionPane.WARNING_MESSAGE);
                if(confirm == JOptionPane.YES_OPTION){
                    
                    dispose();
                    new SecurityFeaturesMenu(accType);
                    
                }
                
            }
            else if(e.getSource() == jbtCheck){
                
                if(!jtfStaffID.getText().trim().equals("")){ // staffID not empty
                    
                    String enteredStaffID = jtfStaffID.getText();
                    Authentication authIn = new Authentication();
                    authIn.setStaffid(enteredStaffID);
                    
                    char existence;

                    staffResult = staffControl.getRecord(enteredStaffID);

                    existence = loginControl.verifyExistence(authIn);



                    if(staffResult != null){ //staffID exists
                        if(existence == 'N'){ //no account exists for this particular staffID in the database
                        //enable now
                            jtfUsername.setEditable(true);
                            jtfPassword.setEditable(true);
                            jtfConfirmPW.setEditable(true);
                            jcbAccType.setEnabled(true);
                            jcbSecQues.setEnabled(true);
                            jtfSecAns.setEditable(true);
                            jbtRegister.setEnabled(true);
                            jbtReset.setEnabled(true);

                            //disable upper field and buttons
                            jtfStaffID.setEditable(false);
                            jbtCheck.setEnabled(false);
                            getRootPane().setDefaultButton(jbtRegister);
                            
                            //get the next number of the record in authentication table
                            int nextNumber = 0;
                            nextNumber = loginControl.getNextNumber() + 1; //+1 for the next number
                            
                            //set default values
                            String defaultUSN;
                            String lowCaseUsername = staffResult.getFirstname().toLowerCase();
                            defaultUSN = lowCaseUsername + nextNumber;
                            jtfUsername.setText(defaultUSN);
                            jtfPassword.setText(staffResult.getStaffid());
                            jtfConfirmPW.setText(staffResult.getStaffid());
                            
                            jtfUsername.requestFocusInWindow();
                        }
                        else{ //staff ID exists, but has existing account binded with it
                            JOptionPane.showMessageDialog(null, "Staff ID: " + jtfStaffID.getText() + " has already been attached to another username.\nPlease enter another staff ID or delete the existing username first." , "Account Exists", JOptionPane.WARNING_MESSAGE);
                            jtfStaffID.setText("");
                            jtfStaffID.requestFocusInWindow();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Staff ID: " + jtfStaffID.getText() + " does not exist.\nPlease re-enter another staffID" , "Invalid Staff ID", JOptionPane.WARNING_MESSAGE);
                        jtfStaffID.setText("");
                        jtfStaffID.requestFocusInWindow();
                    }
                }
                else{ //staffID empty
                    JOptionPane.showMessageDialog(null, "Please do not leave the Staff ID field empty.", "Empty Staff ID", JOptionPane.WARNING_MESSAGE);
                    jtfStaffID.requestFocusInWindow();
                }
            }
            else if(e.getSource() == jbtClear){
                
                
                
//                jtfUsername.setEditable(false);
//                jpfPassword.setEditable(false);
//                jpfConfirmPW.setEditable(false);
//                jcbAccType.setEnabled(false);
//                jcbSecQues.setEnabled(false);
//                jtfSecAns.setEditable(false);
//                jbtRegister.setEnabled(false);
//                jbtReset.setEnabled(false);
//                
//                //clear lower fields
////                jtfUsername.setText("");
////                jpfPassword.setText("");
////                jpfConfirmPW.setText("");
////                jcbAccType.setSelectedIndex(0);
////                jcbSecQues.setSelectedIndex(0);
////                jtfSecAns.setText("");
//                
//                clearFields();
//                
//                jbtCheck.setEnabled(true);
//                jtfStaffID.setEditable(true);
//                jtfStaffID.setText("");
//                jtfStaffID.requestFocusInWindow();
                
                resetPage();
            }
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Security Features Submenu?", "Confirm?", JOptionPane.WARNING_MESSAGE);
           if(confirm == JOptionPane.YES_OPTION){
                loginControl.closeDB();
                dispose();
                new SecurityFeaturesMenu(accType);
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    private void clearFields(){
        jtfUsername.setText("");
        jtfPassword.setText("");
        jtfConfirmPW.setText("");
        jcbAccType.setSelectedIndex(0);
        jcbSecQues.setSelectedIndex(0);
        jtfSecAns.setText("");

        jtfUsername.requestFocusInWindow();
    }
    
    private void resetPage(){
        
        jtfUsername.setEditable(false);
        jtfPassword.setEditable(false);
        jtfConfirmPW.setEditable(false);
        jcbAccType.setEnabled(false);
        jcbSecQues.setEnabled(false);
        jtfSecAns.setEditable(false);
        jbtRegister.setEnabled(false);
        jbtReset.setEnabled(false);

        //clear lower fields
    //                jtfUsername.setText("");
    //                jpfPassword.setText("");
    //                jpfConfirmPW.setText("");
    //                jcbAccType.setSelectedIndex(0);
    //                jcbSecQues.setSelectedIndex(0);
    //                jtfSecAns.setText("");

        clearFields();

        jbtCheck.setEnabled(true);
        jtfStaffID.setEditable(true);
        jtfStaffID.setText("");
        jtfStaffID.requestFocusInWindow();
        getRootPane().setDefaultButton(jbtCheck);
    }
    
    public static void main(String[] args){
        new AddNewUser('A');
    }
}