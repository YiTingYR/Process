// Name: Sum Weng Fai       Tutorial Group: 2DIA2
//Sum
//V1.00 24MAR16 1152AM
package ui;

import domain.Authentication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

import da.*;
import ui.*;
import domain.*;
import control.*;


public class ChangePasswordPage extends JFrame{
    
    private char accType;
    
    private MaintainLogin loginControl;
    
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    private JPanel logoPanel = new JPanel(new FlowLayout());
    
    private JLabel jlbTitle = new JLabel("Change Password", SwingConstants.CENTER);
    private JLabel jlbUserName = new JLabel("Username: ");
    private JLabel jlbCurPassword = new JLabel("Current Password: ");
    private JLabel jlbNewPassword = new JLabel("New Password: ");
    private JLabel jlbConfirmNewPW = new JLabel("Confirm New Password: ");
    
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtSubmit = new JButton("Submit");
    private JButton jbtBack = new JButton("Back");
    
    private JTextField jtfUsername = new JTextField(12);
    private JPasswordField jtfCurPassword = new JPasswordField(20);
    private JPasswordField jtfNewPassword = new JPasswordField(20);
    private JPasswordField jtfConfirmNewPW = new JPasswordField(20);
    
    
    
    
    private JPanel global = new JPanel(new BorderLayout()) {  
    public void paintComponent(Graphics g) {  
     //Image img1 = Toolkit.getDefaultToolkit().getImage(  
     //AddNewUser.class.getResource("../images/green4.jpg"));  
     //g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  };
    
    private JPanel upperPanel = new JPanel(new BorderLayout());
    private JPanel middlePanel = new JPanel(new GridLayout(8,1)); //11, 1
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel middle_r1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
//    private JPanel middle_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private JPanel middle_r7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private JPanel middle_r8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
    private JPanel containMiddle = new JPanel(new FlowLayout());
    
    // Fonts
    private Font myFont1 = new Font("Comic Sans MS",Font.PLAIN,14);
    private Font myFont2 = new Font("Comic Sans MS",Font.PLAIN,18);
     //Font Color
    private Color fontColor = new Color(0,0,0);
    
    private Color btnColor = new Color(214, 239, 159);
    
    public ChangePasswordPage(){
        
    }
    
    public ChangePasswordPage(char accType){
        
        this.accType = accType;
        
        setLayout(new BorderLayout());
        
        loginControl = new MaintainLogin();
        
        //set TextFields max limit
        jtfUsername.setDocument(new JTextFieldLimit(15));
        jtfCurPassword.setDocument(new JTextFieldLimit(20));
        jtfNewPassword.setDocument(new JTextFieldLimit(20));
        jtfConfirmNewPW.setDocument(new JTextFieldLimit(20));
        
        jlbTitle.setFont(myFont2);
        jlbUserName.setFont(myFont1);

        jlbTitle.setForeground(fontColor);
        jlbUserName.setForeground(fontColor);
        
        upperPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        containMiddle.setOpaque(false);
        middle_r1.setOpaque(false);
        middle_r2.setOpaque(false);
        middle_r3.setOpaque(false);
        middle_r4.setOpaque(false);
        middle_r5.setOpaque(false);
        middle_r6.setOpaque(false);
//        middle_r7.setOpaque(false);
//        middle_r8.setOpaque(false);
        logoPanel.setOpaque(false);
        
        jbtBack.setBackground(btnColor);
        jbtReset.setBackground(btnColor);
        jbtSubmit.setBackground(btnColor);
        
        logoPanel.add(logo);
        
        upperPanel.add(logoPanel, BorderLayout.NORTH);
        upperPanel.add(jlbTitle, BorderLayout.SOUTH);
        
        middle_r1.add(jlbUserName);
        middle_r1.add(jtfUsername);
        middle_r2.add(jlbCurPassword);
        middle_r2.add(jtfCurPassword);
        middle_r3.add(jlbNewPassword);
        middle_r3.add(jtfNewPassword);
        middle_r4.add(jlbConfirmNewPW);
        middle_r4.add(jtfConfirmNewPW);
        middle_r5.add(new JLabel());
        middle_r6.add(jbtSubmit);
        middle_r6.add(jbtReset);
        middle_r6.add(jbtBack);
        
        middlePanel.add(new JLabel());
        middlePanel.add(middle_r1);
        middlePanel.add(middle_r2);
        middlePanel.add(middle_r3);
        middlePanel.add(middle_r4);
        middlePanel.add(middle_r5);
        middlePanel.add(middle_r6);
//        middlePanel.add(middle_r7);
//        middlePanel.add(new JLabel());
//        middlePanel.add(middle_r8);
        containMiddle.add(middlePanel);
        
        
        
        global.add(upperPanel, BorderLayout.NORTH);
        global.add(containMiddle, BorderLayout.CENTER);
        
        add(global, BorderLayout.CENTER);
        
        //register button listener
        jbtReset.addActionListener(new ButtonListener());
        jbtSubmit.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener());
        
        addWindowListener(new WindowListener());
        
        jbtReset.setMnemonic('R');
        jbtSubmit.setMnemonic('S');
        jbtBack.setMnemonic('B');
        
        getRootPane().setDefaultButton(jbtSubmit);
        
        
        setIcon();
        setTitle("Change Password Page");
        setSize(730,500);//830,550
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtReset){
                jtfUsername.setText("");
                jtfUsername.setEditable(true);
                
                jtfCurPassword.setText("");
                jtfNewPassword.setText("");
                jtfConfirmNewPW.setText("");

                jtfUsername.requestFocusInWindow();
            }
            else if(e.getSource() == jbtSubmit){
                Authentication authIn = new Authentication();
                Authentication authUpPW = new Authentication();
                boolean inValidity = false;
                
                if(jtfUsername.getText().trim().equals("") || new String(jtfCurPassword.getPassword()).trim().equals("") || new String(jtfNewPassword.getPassword()).trim().equals("") || new String(jtfConfirmNewPW.getPassword()).trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please do not leave any fields blank", "Blank Field(s)", JOptionPane.WARNING_MESSAGE);
                    jtfUsername.requestFocusInWindow();
                }
                else{
                    
                    authIn.setUsername(jtfUsername.getText());
                    authIn.setPassword(new String(jtfCurPassword.getPassword()));

                    Authentication authChk;


                    authChk = loginControl.selectAuth(authIn);


                    if(authChk != null){
                        inValidity = loginControl.verifyLogin(authIn);

                        if(inValidity){

                            int updateResult = 99;

                            if(new String(jtfNewPassword.getPassword()).equals(new String(jtfConfirmNewPW.getPassword()))){
                                if(!new String(jtfNewPassword.getPassword()).equals(new String(jtfCurPassword.getPassword()))){

                                    authUpPW.setUsername(jtfUsername.getText());
                                    authUpPW.setPassword(new String(jtfNewPassword.getPassword()));

                                    updateResult = loginControl.updatePassword(authUpPW);

                                    if(updateResult > 0){
                                        JOptionPane.showMessageDialog(null, "The password for username: " + jtfUsername.getText() + " has been successfully changed.", "Password Change Successful", JOptionPane.INFORMATION_MESSAGE);
                                        clearFields();
                                    }
                                    else{ //SQL level error
                                        JOptionPane.showMessageDialog(null, "The password change for username: " + jtfUsername.getText() + " has failed.", "Password Change Failed", JOptionPane.ERROR_MESSAGE);
                                    }

                                }
                                else{ // new password same with current password
                                    JOptionPane.showMessageDialog(null, "The new password is the current password.\nPlease enter a new password.", "Old Password Entered", JOptionPane.WARNING_MESSAGE);
                                    jtfNewPassword.setText("");
                                    jtfConfirmNewPW.setText("");
                                    jtfNewPassword.requestFocusInWindow();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "The new passwords entered does not match each other.", "Password Mismatch", JOptionPane.WARNING_MESSAGE);
                                jtfNewPassword.setText("");
                                jtfConfirmNewPW.setText("");
                                jtfNewPassword.requestFocusInWindow();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "The current password entered is invalid.", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                            jtfCurPassword.setText("");
                            jtfCurPassword.requestFocusInWindow();
                        }//
                }
                    else{ //username does not exist
                        JOptionPane.showMessageDialog(null, "The username entered does not exist.", "Username does not exist", JOptionPane.ERROR_MESSAGE);
                        jtfUsername.setText("");
                        jtfUsername.requestFocusInWindow();
                    }
                
                }
            }
            else if(e.getSource() == jbtBack){
                dispose();
                loginControl.closeDB();
                new SecurityFeaturesMenu(accType);
              //back to the previous page
            }
            
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the Login Page?", "Confirm?", JOptionPane.WARNING_MESSAGE);
           if(confirm == JOptionPane.YES_OPTION){
                loginControl.closeDB();
                dispose();
                new SecurityFeaturesMenu(accType);
           }
       }
    }
    
    private void clearFields(){
        jtfUsername.setText("");
        jtfCurPassword.setText("");
        jtfNewPassword.setText("");
        jtfConfirmNewPW.setText("");
        jtfUsername.requestFocusInWindow();
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new ChangePasswordPage('U');
    }
}