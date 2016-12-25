//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import da.*;
import ui.*;
import domain.*;
import control.*;

public class RemoveUserPage extends JFrame{
    
    private char accType;
    
    public String currentUser;
    
    public String currentStaff;
    
    private String criteriaChosen = "";
    
    
//    private Login login;
    private MaintainLogin loginControl;
    
    
    
    
    
    
    private JButton jbtRemove = new JButton("Remove");
    private JButton jbtReset = new JButton("Reset");
    //private JButton jbtExit = new JButton("Exit");
    private JButton jbtBack = new JButton("Back");
    
    //Logo
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    //Welcome message
    private JLabel wlcMsg = new JLabel("Welcome to ezWay Express Bus Ticketing System.",SwingConstants.CENTER);
    private JLabel instr = new JLabel("Please enter username or staff ID to remove user from the system.",SwingConstants.CENTER);
    
    //SOUTH
    //private JLabel lbUsername = new JLabel("Username:");
    //private JLabel lbPassword = new JLabel("Password:");
    
    private JButton jbtUsername = new JButton("Username");
    private JButton jbtStaffID = new JButton("Staff ID");
    private JTextField jtfUsername = new JTextField(12);
    private JTextField jtfStaffID = new JTextField(7);
    //private JPasswordField jtfPassword = new JPasswordField(12);
    
    private JPanel jp1_CENTER_BIG = new JPanel(new BorderLayout());
    
    private JPanel jp2_SOUTH_BIG = new JPanel(new BorderLayout());
    
    private JPanel jp4_SOUTH = new JPanel(new FlowLayout(FlowLayout.CENTER,30,5));
    
    private JPanel jp1_2_CENTER_SMALL = new JPanel(new GridLayout(2,1,20,10));

    private JPanel logoPanel = new JPanel(new FlowLayout());
    
    private JPanel jp7_BIG_INPUT = new JPanel(new GridLayout(4,1,10,5));
    
    private JPanel jp5_input_r1 = new JPanel(new FlowLayout());
    private JPanel jp6_input_r2 = new JPanel(new FlowLayout());
    
    private JPanel global=new JPanel() {  
    public void paintComponent(Graphics g) {  
     Image img1 = Toolkit.getDefaultToolkit().getImage(  
     LoginPage.class.getResource("../images/green4.jpg"));  
     g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);  
     } };
     
     // Fonts
    private Font myFont1 = new Font("Comic Sans MS",Font.PLAIN,14);
     
     //Font Color
    private Color fontColor = new Color(0,0,0);
    
    private Color btnColor = new Color(214, 239, 159);
    
    public RemoveUserPage(){
        
    }
    
    public RemoveUserPage(char accType){

        this.accType = accType;
        
        loginControl = new MaintainLogin();
        
        //set max TextFields limit
        jtfStaffID.setDocument(new JTextFieldLimit(7));
        jtfUsername.setDocument(new JTextFieldLimit(15));
        
        jp1_CENTER_BIG.setOpaque(false);
        jp2_SOUTH_BIG.setOpaque(false);
        jp4_SOUTH.setOpaque(false);
        jp1_2_CENTER_SMALL.setOpaque(false);
        logoPanel.setOpaque(false);
        jp7_BIG_INPUT.setOpaque(false);
        jp5_input_r1.setOpaque(false);
        jp6_input_r2.setOpaque(false);
        
        setLayout(new BorderLayout());
        
        
        //setting Fonts for Jlabels
        wlcMsg.setFont(myFont1);
        instr.setFont(myFont1);
        //lbUsername.setFont(myFont1);
        //lbPassword.setFont(myFont1);
        
        //setting font colors for JLabels
        wlcMsg.setForeground(fontColor);
        instr.setForeground(fontColor);
        //lbUsername.setForeground(fontColor);
        //lbPassword.setForeground(fontColor);
        
        //setting Fonts for JButtons
        jbtRemove.setFont(myFont1);
        jbtReset.setFont(myFont1);
        //jbtExit.setFont(myFont1);
        jbtBack.setFont(myFont1);
        
        //setting background color for JButtons
        jbtRemove.setBackground(btnColor); //peach color, same color as font color of JLabels
        jbtReset.setBackground(btnColor);
        //jbtExit.setBackground(fontColor);
        jbtBack.setBackground(btnColor);
        jbtStaffID.setBackground(btnColor);
        jbtUsername.setBackground(btnColor);
        
        logoPanel.add(logo);

        jp1_CENTER_BIG.add(logoPanel,BorderLayout.NORTH);
        
        jp1_2_CENTER_SMALL.add(wlcMsg);
        jp1_2_CENTER_SMALL.add(instr);
        jp1_CENTER_BIG.add(jp1_2_CENTER_SMALL,BorderLayout.SOUTH);
        
        jp5_input_r1.add(jbtUsername);
        jp5_input_r1.add(jtfUsername);
        
        jp6_input_r2.add(jbtStaffID);
        jp6_input_r2.add(jtfStaffID);
        
        jp7_BIG_INPUT.add(new JLabel());
        jp7_BIG_INPUT.add(jp5_input_r1);
        jp7_BIG_INPUT.add(jp6_input_r2);
        
        jp2_SOUTH_BIG.add(jp7_BIG_INPUT,BorderLayout.CENTER);
        
        jp4_SOUTH.add(jbtRemove);
        jp4_SOUTH.add(jbtReset);
        jp4_SOUTH.add(jbtBack);
        //jp4_SOUTH.add(jbtExit);
        
        jp2_SOUTH_BIG.add(jp4_SOUTH,BorderLayout.SOUTH);
        
        global.add(jp1_CENTER_BIG);
        global.add(jp2_SOUTH_BIG);
        
        add(global,BorderLayout.CENTER);
        
        //place focus in username textfield once program is running
        jtfUsername.requestFocusInWindow();
        
        //setting Mnemonics
        jbtRemove.setMnemonic('E');
        jbtReset.setMnemonic('R');
        //jbtExit.setMnemonic('E');
        jbtBack.setMnemonic('B');
        
        // register button listener
        jbtUsername.addActionListener(new ButtonListener());
        jbtStaffID.addActionListener(new ButtonListener());
        jbtRemove.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        //jbtExit.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener());
        
        getRootPane().setDefaultButton(jbtRemove);
        
        addWindowListener(new WindowListener());
        
        criteriaChosen = "username";
        jtfUsername.setEditable(true);
        jtfStaffID.setEditable(false);
        jtfUsername.requestFocusInWindow();
        
        setIcon();
        setTitle("Remove User Page");
        setSize(800,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtUsername){
                jtfStaffID.setText("");
                jtfStaffID.setEditable(false);
                jtfUsername.setEditable(true);
                jtfUsername.requestFocusInWindow();
                
                criteriaChosen = "username";
                
                //verifyUser(criteriaChosen);
            }
            else if(e.getSource() == jbtStaffID){
                jtfUsername.setText("");
                jtfUsername.setEditable(false);
                jtfStaffID.setEditable(true);
                jtfStaffID.requestFocusInWindow();
                
                criteriaChosen = "staffID";
                
                //verifyUser(criteriaChosen);
                
//                Authentication authIn = new Authentication();
//                char result = 'O';
//                
//                authIn.setUsername(jtfUsername.getText());
//                authIn.setStaffid(jtfStaffID.getText());
//                
//                result = loginControl.verifyExistence(authIn);
//                
//                if(result == 'Y'){
//                    JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the user?","Confirm?",JOptionPane.YES_NO_OPTION);
//                }
            }
            else if(e.getSource() == jbtRemove){
                
//                if(criteriaChosen.equals("username")){
//                    //xxxxxxxx
//                }
//                else if(criteriaChosen.equals("staffID")){
//                    //xxxxxxxx
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Error in removing the user.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
                
                verifyUser(criteriaChosen);
                
            }
            else if(e.getSource() == jbtReset){
                jtfUsername.setText("");
                jtfStaffID.setText("");
                jtfUsername.requestFocusInWindow();
            }
            else if(e.getSource() == jbtBack){
                //String enteredUsername = jtfUsername.getText();
                
                int confirm = JOptionPane.showConfirmDialog(null, "Return to Security Features Submenu?", "Return?", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                loginControl.closeDB();
                dispose();
                new SecurityFeaturesMenu(accType);
                }
                //String enteredPassword = new String(jtfPassword.getPassword());
                
                /*if(!enteredUsername.equals("") && !enteredPassword.equals("")){
                    
                    
                    //login = new Login(enteredUsername, enteredPassword);
                    //boolean validity = loginControl.verifyLogin(login);
                    
                    if(validity){
                        //Login loginReadStaff = loginControl.selectUser(enteredUsername);
                        //currentStaff = loginReadStaff.getStaffID();
                        dispose();
                        //new AddUserPage();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Authentication failed.\nInvalid username or password.\nYou must login as a user to be able to add user.","Login Failed",JOptionPane.ERROR_MESSAGE);
                        jtfUsername.setText("");
                        jtfPassword.setText("");
                        jtfUsername.requestFocusInWindow();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Both username and password fields cannot be blank!","Attention",JOptionPane.WARNING_MESSAGE);
                    jtfUsername.requestFocusInWindow();
                }*/
            }
            else{ //exit button --> 1131 030316 removed Exit button
               //loginControl.closeDB();
               System.exit(0); 
            }
        }
    }
    
    private void verifyUser(String criteriaChosen){
        Authentication authIn = new Authentication();
        char result = 'O';

        authIn.setUsername(jtfUsername.getText());
        authIn.setStaffid(jtfStaffID.getText());

        result = loginControl.verifyExistence(authIn);

        if(result == 'Y'){
            int choice = 0;
            if(criteriaChosen.equals("staffID"))
                choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the account of Staff ID: " + jtfStaffID.getText() + " ?","Confirm?",JOptionPane.YES_NO_OPTION);
            else
                choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the account of Username: " + jtfUsername.getText() + " ?","Confirm?",JOptionPane.YES_NO_OPTION);
            
            if(choice == JOptionPane.YES_OPTION){
                //delete the user
                int opResult = 99;
                opResult = loginControl.deleteAccount(authIn);
                
                if(opResult > 0){
                        if(criteriaChosen.equals("staffID")){
                            JOptionPane.showMessageDialog(null, "The account with Staff ID: " + jtfStaffID.getText() + " has been deleted successfully.", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                            jtfStaffID.setText("");
                            jtfStaffID.requestFocusInWindow();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "The account with Username: "+ jtfUsername.getText() + " has been deleted successfully.", "Deletion Successful",JOptionPane.INFORMATION_MESSAGE);
                            jtfUsername.setText("");
                            jtfUsername.requestFocusInWindow();
                        }
                    }
                else{
                    
                        JOptionPane.showMessageDialog(null, "The deletion has failed.","Deletion Failed", JOptionPane.ERROR_MESSAGE);
                        
                        if(criteriaChosen.equals("staffID")){
                            jtfStaffID.setText("");
                            jtfStaffID.requestFocusInWindow();
                        }
                        else{
                            jtfUsername.setText("");
                            jtfUsername.requestFocusInWindow();
                        }
                    }
                }
                else{
                    // do nothing
                }
            }
        
        else{
            if(criteriaChosen.equals("staffID"))
                JOptionPane.showMessageDialog(null, "The account with Staff ID: " + jtfStaffID.getText() + " does not exist.", "Account Not Found", JOptionPane.WARNING_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "The account with Username: "+ jtfUsername.getText() + " does not exist.","Account Not Found",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            
            int confirm = JOptionPane.showConfirmDialog(null, "Return to Security Features Submenu?", "Return?", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    loginControl.closeDB();
                    dispose();
                    new SecurityFeaturesMenu(accType);
                }
       }
    }
    
    public static void main(String[] args){
       new RemoveUserPage('A');
    }
    
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }        
    
    
}