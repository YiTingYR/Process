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

public class PasswordRecoveryProceed extends JFrame{
    
    private MaintainLogin loginControl;
    
    //container
    private Authentication auth;
    
    public String currentUser;
    
    public String currentStaff;
    
    private String criteriaChosen = "";

    
    private JButton jbtSubmit = new JButton("Submit");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack = new JButton("Back");
    
    //Logo
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    //Welcome message
    private JLabel wlcMsg = new JLabel("Welcome to ezWay Express Bus Ticketing System.",SwingConstants.CENTER);
    private JLabel instr = new JLabel("Please enter and confirm new password (case sensitive).",SwingConstants.CENTER);
    
    //SOUTH
    private JPasswordField jtfPassword = new JPasswordField(20);
    private JPasswordField jtfConfirmPW = new JPasswordField(20);
    private JLabel jlbPassword = new JLabel("Password: ");
    private JLabel jlbConfirmPW = new JLabel("Confirm Password: ");
    
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
    
    public PasswordRecoveryProceed(){
        
    }
    
    public PasswordRecoveryProceed(Authentication authResult){
        
        loginControl = new MaintainLogin();
        
        this.auth = authResult;
        
        //set max TextFields limit
        jtfPassword.setDocument(new JTextFieldLimit(20));
        jtfConfirmPW.setDocument(new JTextFieldLimit(20));
        
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
        
        //setting font colors for JLabels
        wlcMsg.setForeground(fontColor);
        instr.setForeground(fontColor);
        
        //setting Fonts for JButtons
        jbtSubmit.setFont(myFont1);
        jbtReset.setFont(myFont1);
        jbtBack.setFont(myFont1);
        
        //setting background color for JButtons
        jbtSubmit.setBackground(btnColor); //peach color, same color as font color of JLabels
        jbtReset.setBackground(btnColor);
        jbtBack.setBackground(btnColor);
        
        logoPanel.add(logo);

        jp1_CENTER_BIG.add(logoPanel,BorderLayout.NORTH);
        
        //jp1_2_CENTER_SMALL.add(wlcMsg);
        jp1_2_CENTER_SMALL.add(new JLabel());
        jp1_2_CENTER_SMALL.add(instr);
        jp1_CENTER_BIG.add(jp1_2_CENTER_SMALL,BorderLayout.SOUTH);
        
        jp5_input_r1.add(jlbPassword);
        jp5_input_r1.add(jtfPassword);
        
        jp6_input_r2.add(jlbConfirmPW);
        jp6_input_r2.add(jtfConfirmPW);
        
        jp7_BIG_INPUT.add(new JLabel());
        jp7_BIG_INPUT.add(jp5_input_r1);
        jp7_BIG_INPUT.add(jp6_input_r2);
        
        jp2_SOUTH_BIG.add(jp7_BIG_INPUT,BorderLayout.CENTER);
        
        jp4_SOUTH.add(jbtSubmit);
        jp4_SOUTH.add(jbtReset);
        jp4_SOUTH.add(jbtBack);
        
        jp2_SOUTH_BIG.add(jp4_SOUTH,BorderLayout.SOUTH);
        
        global.add(jp1_CENTER_BIG);
        global.add(jp2_SOUTH_BIG);
        
        add(global,BorderLayout.CENTER);
        
        //place focus in username textfield once program is running
        jtfPassword.requestFocusInWindow();
        
        //setting Mnemonics
        jbtSubmit.setMnemonic('S');
        jbtReset.setMnemonic('R');
        jbtBack.setMnemonic('B');
        
        // register button listener
        jbtSubmit.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener());
        
        getRootPane().setDefaultButton(jbtSubmit);
        
        addWindowListener(new WindowListener());
        
        setIcon();
        setTitle("Password Recovery Proceed");
        setSize(600,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtSubmit){
                String enteredPW = new String(jtfPassword.getPassword());
                String confirmedPW = new String(jtfConfirmPW.getPassword());
                int result;
                
                if(new String(jtfPassword.getPassword()).trim().equals("") || new String(jtfConfirmPW.getPassword()).trim().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please do not leave any fields blank.","Blank Field(s).",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    if(enteredPW.equals(confirmedPW)){
                        auth.setPassword(enteredPW);

                        //update password in DB
                        result = loginControl.updatePassword(auth);

                        if(result > 0){ //update is success
                            JOptionPane.showMessageDialog(null, "The new password is now saved.\nPlease keep the password properly to avoid from \nlosing it again. You will now be redirected back to the login page.","Password Update Successful.",JOptionPane.INFORMATION_MESSAGE);
                            
                            loginControl.closeDB();
                            dispose();
                            new LoginPage();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Some error(s) has occured when system is trying to save the password.\nPlease try again","Password Update Failed.",JOptionPane.ERROR_MESSAGE);
                        }



                    }else{
                        JOptionPane.showMessageDialog(null, "The passwords entered does not match.\n Please re-enter and confirm the new password.","Password Does Not Match.",JOptionPane.WARNING_MESSAGE);
                        jtfConfirmPW.setText("");
                        jtfPassword.setText("");
                        jtfPassword.requestFocusInWindow();
                    }
                }
                
            }
            else if(e.getSource() == jbtReset){
                jtfPassword.setText("");
                jtfConfirmPW.setText("");
                jtfPassword.requestFocusInWindow();
            }
            else if(e.getSource() == jbtBack){
               int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Login Page?", "Confirm?", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                     loginControl.closeDB();
                     dispose();
                     new LoginPage();

            }
            }
            else{ //exit button --> 1131 030316 removed Exit button
               loginControl.closeDB();
               System.exit(0); 
            }
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Login Page?", "Confirm?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                loginControl.closeDB();
                dispose();
                new LoginPage();
                
       }
    }
 }
    
    public static void main(String[] args){
        //PasswordRecoveryProceed prp = new PasswordRecoveryProceed();
        new PasswordRecoveryProceed();
    }
    
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }        
    
    
}