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


public class PasswordRecoveryPage extends JFrame{
    
    
    private MaintainLogin loginControl;
    
    private Authentication authResult;
    
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/eZway150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    private JPanel logoPanel = new JPanel(new FlowLayout());
    
    private JLabel jlbTitle = new JLabel("Password Recovery", SwingConstants.CENTER);
    private JLabel jlbUserName = new JLabel("Username: ");
    private JLabel jlbStaffID = new JLabel("Staff ID: ");
    private JLabel jlbSecQues = new JLabel("Security Question: ");
    private JLabel jlbSecAns = new JLabel("Security Answer: ");
    
    private JButton jbtSearch = new JButton("Search");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtSubmit = new JButton("Submit");
    private JButton jbtBack = new JButton("Back");
    
    private JTextField jtfUsername = new JTextField(12);
    private JTextField jtfStaffID = new JTextField(7);
    
    //stored in a String array because the database will only store question number
    private String[] secQues = {"1. What is your favourite food?","2. What is your favourite movie?", "3. What is your year of marriage?", "4. What is your hobby?"};
    private JTextField jtfSecQues = new JTextField(30); //only question numbers are stored in db.
    private JTextField jtfSecAns = new JTextField(25);
    
    
    
    private JPanel global = new JPanel(new BorderLayout()) {  
    public void paintComponent(Graphics g) {  
     //Image img1 = Toolkit.getDefaultToolkit().getImage(  
     //AddNewUser.class.getResource("../images/green4.jpg"));  
     //g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  };
    
    private JPanel upperPanel = new JPanel(new BorderLayout());
    private JPanel middlePanel = new JPanel(new GridLayout(11,1)); //4,1 7，1
    private JPanel bottomPanel = new JPanel(new FlowLayout());
    private JPanel middle_r1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    private JPanel middle_r5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel middle_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private JPanel middle_r7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//    private JPanel middle_r8 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
    private JPanel containMiddle = new JPanel(new FlowLayout());
    
    // Fonts
    private Font myFont1 = new Font("Comic Sans MS",Font.PLAIN,14);
    private Font myFont2 = new Font("Comic Sans MS",Font.PLAIN,18);
     //Font Color
    private Color fontColor = new Color(0,0,0);
    
    private Color btnColor = new Color(214, 239, 159);
    
    
    
    public PasswordRecoveryPage(){
        
                
        setLayout(new BorderLayout());
        loginControl = new MaintainLogin();
        
        //set TextField max limit
        jtfUsername.setDocument(new JTextFieldLimit(15));
        jtfStaffID.setDocument(new JTextFieldLimit(7));
        //security question is predefined and not editable
        jtfSecAns.setDocument(new JTextFieldLimit(25));
        
        jlbTitle.setFont(myFont2);
        jlbUserName.setFont(myFont1);
        jlbStaffID.setFont(myFont1);
        jlbSecQues.setFont(myFont1);
        jlbSecAns.setFont(myFont1);
        
        jlbTitle.setForeground(fontColor);
        jlbUserName.setForeground(fontColor);
        jlbStaffID.setForeground(fontColor);
        jlbSecQues.setForeground(fontColor);
        jlbSecAns.setForeground(fontColor);
        
        jbtSearch.setBackground(btnColor);
        jbtBack.setBackground(btnColor);
        jbtReset.setBackground(btnColor);
        jbtSubmit.setBackground(btnColor);
        
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
        
        logoPanel.add(logo);
        
        upperPanel.add(logoPanel, BorderLayout.NORTH);
        upperPanel.add(jlbTitle, BorderLayout.SOUTH);
        middle_r1.add(jlbUserName);
        middle_r1.add(jtfUsername);
        middle_r2.add(jlbStaffID);
        middle_r2.add(jtfStaffID);
        middle_r3.add(jbtSearch);
        middle_r3.add(jbtReset);
        middle_r4.add(jlbSecQues);
        middle_r4.add(jtfSecQues);
        middle_r5.add(jlbSecAns);
        middle_r5.add(jtfSecAns);
        middle_r6.add(jbtSubmit);
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
        jbtSearch.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtSubmit.addActionListener(new ButtonListener());
        jbtBack.addActionListener(new ButtonListener());
        
        addWindowListener(new WindowListener());
        
        jbtSearch.setMnemonic('A');
        jbtReset.setMnemonic('R');
        jbtSubmit.setMnemonic('S');
        jbtBack.setMnemonic('B');
        
        getRootPane().setDefaultButton(jbtSearch);
        
        //initiate button and textfield status
        jtfSecQues.setEditable(false);
        jtfSecAns.setEditable(false);
        jbtSubmit.setEnabled(false);
        
        setIcon();
        setTitle("Password Recovery Page");
        setSize(830,650);//830,550
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtSearch){
                
                //pass in dummy value for unused fields in domain
                Authentication authInput = new Authentication(jtfUsername.getText(), "", 'X', 0, "", jtfStaffID.getText());
                
                authResult = loginControl.passwordRecoveryVerification(authInput);
                   //If the username and staffID exists in the database and corresponding to each other
                    //DO
                if(authResult != null){
                    jtfUsername.setEditable(false);
                    jtfStaffID.setEditable(false);
                    jbtSearch.setEnabled(false);
                    jbtSubmit.setEnabled(true);
                    jtfSecAns.setEditable(true);
                    jtfSecAns.requestFocusInWindow();
                    getRootPane().setDefaultButton(jbtSubmit);
                    //show the security question in record in a non-editable textfield and disable the username and staffID textfields.
                    //Note: to re-enable the username and staffID textfields, simply click the "Reset" button.
                    
                    switch(authResult.getSecurityquestion()){
                        case 1:
                            jtfSecQues.setText(secQues[0]);
                            break;
                        case 2:
                            jtfSecQues.setText(secQues[1]);
                            break;
                        case 3:
                            jtfSecQues.setText(secQues[2]);
                            break;
                        case 4:
                            jtfSecQues.setText(secQues[3]);
                            break;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or staffID,\nor the username does not matches with the staffID.","Verification Failed",JOptionPane.ERROR_MESSAGE);
                }
                        
                
                
            }
            else if(e.getSource() == jbtReset){
                jtfUsername.setText("");
                jtfStaffID.setText("");
                jtfUsername.setEditable(true);
                jtfStaffID.setEditable(true);
                jtfSecAns.setEditable(false);
                jtfSecQues.setText("");
                jtfSecAns.setText("");
                jbtSubmit.setEnabled(false);
                
                jbtSearch.setEnabled(true);

                jtfUsername.requestFocusInWindow();
            }
            else if(e.getSource() == jbtSubmit){
                
              //submit sec ans
                String enteredSecAns = jtfSecAns.getText();
                
                if(enteredSecAns.equals(authResult.getSecurityanswer())){
                    //call proceed
                    loginControl.closeDB();
                    dispose();
                    new PasswordRecoveryProceed(authResult);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid security answer.\nThe security answer entered does not match our record.","Verification Failed",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(e.getSource() == jbtBack){
                 int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the login page?", "Confirm?", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                     loginControl.closeDB();
                     dispose();
                     new LoginPage(); //no need accType
                }
            }
            
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Any unsaved changes will be discarded!\nConfirm return to the login page?", "Confirm?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){
                loginControl.closeDB();
                dispose();
                new LoginPage();
           }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        new PasswordRecoveryPage();
    }
}