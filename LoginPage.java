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

public class LoginPage extends JFrame{
    
    private String currentUser;
    
    private char curAccType;
    
    private String currentStaff;
    
    private Authentication auth;
    private MaintainLogin loginControl;
    
    
    private JButton jbtLogin = new JButton("Login");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtExit = new JButton("Exit");
    private JButton jbtForget = new JButton("Forgot Password");
    
    //Logo
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    //Welcome message
    private JLabel wlcMsg = new JLabel("Welcome to ezWay Express Bus Ticketing System.",SwingConstants.CENTER);
    private JLabel instr = new JLabel("Please login by using the credentials provided by your system administrator.",SwingConstants.CENTER);
    
    //SOUTH
    private JLabel lbUsername = new JLabel("Username:");
    private JLabel lbPassword = new JLabel("Password:");
    
    private JTextField jtfUsername = new JTextField(12);
    private JPasswordField jtfPassword = new JPasswordField(12);
    
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
     LoginPage.class.getResource("../images/green2.jpg"));  
     g.drawImage(img1, 0, 0, this.getWidth(), this.getHeight(), this);  
     } };
     
     // Fonts
    private Font myFont1 = new Font("Comic Sans MS",Font.PLAIN,14);
     
     //Font Color
    //private Color fontColor = new Color(255, 255, 153);
    private Color fontColor = new Color(0,0,0);
    
    private Color btnColor = new Color(214, 239, 159);
    
    public LoginPage(){
        
        loginControl = new MaintainLogin();
        
        //set TextFields max limit
        jtfUsername.setDocument(new JTextFieldLimit(15));
        jtfPassword.setDocument(new JTextFieldLimit(20));
        
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
        lbUsername.setFont(myFont1);
        lbPassword.setFont(myFont1);
        
        //setting font colors for JLabels
        wlcMsg.setForeground(fontColor);
        instr.setForeground(fontColor);
        lbUsername.setForeground(fontColor);
        lbPassword.setForeground(fontColor);
        
        //setting Fonts for JButtons
        jbtLogin.setFont(myFont1);
        jbtReset.setFont(myFont1);
        jbtExit.setFont(myFont1);
        jbtForget.setFont(myFont1);
        
        //setting background color for JButtons
        jbtLogin.setBackground(btnColor); //peach color, same color as font color of JLabels
        jbtReset.setBackground(btnColor);
        jbtExit.setBackground(btnColor);
        jbtForget.setBackground(btnColor);
        
        logoPanel.add(logo);

        jp1_CENTER_BIG.add(logoPanel,BorderLayout.NORTH);
        
        //jp1_2_CENTER_SMALL.add(new JLabel("\n"));
        jp1_2_CENTER_SMALL.add(wlcMsg);
        jp1_2_CENTER_SMALL.add(instr);
        jp1_CENTER_BIG.add(jp1_2_CENTER_SMALL,BorderLayout.SOUTH);
        
        jp5_input_r1.add(lbUsername);
        jp5_input_r1.add(jtfUsername);
        
        jp6_input_r2.add(lbPassword);
        jp6_input_r2.add(jtfPassword);
        
        jp7_BIG_INPUT.add(new JLabel());
        jp7_BIG_INPUT.add(jp5_input_r1);
        jp7_BIG_INPUT.add(jp6_input_r2);
        
        jp2_SOUTH_BIG.add(jp7_BIG_INPUT,BorderLayout.CENTER);
        
        jp4_SOUTH.add(jbtLogin);
        jp4_SOUTH.add(jbtReset);
        jp4_SOUTH.add(jbtForget);
        jp4_SOUTH.add(jbtExit);
        
        jp2_SOUTH_BIG.add(jp4_SOUTH,BorderLayout.SOUTH);
        
        global.add(jp1_CENTER_BIG);
        global.add(jp2_SOUTH_BIG);
        
        add(global,BorderLayout.CENTER);
        
        //place focus in username textfield once program is running
        jtfUsername.requestFocusInWindow();
        
        //setting Mnemonics
        jbtLogin.setMnemonic('L');
        jbtReset.setMnemonic('R');
        jbtExit.setMnemonic('E');
        jbtForget.setMnemonic('A');
        
        // register button listener
        jbtLogin.addActionListener(new ButtonListener());
        jbtReset.addActionListener(new ButtonListener());
        jbtExit.addActionListener(new ButtonListener());
        jbtForget.addActionListener(new ButtonListener());
        
        getRootPane().setDefaultButton(jbtLogin);
        
        addWindowListener(new WindowListener());
        
        setIcon();
        setTitle("ezWay Express Bus Ticketing System");
        setSize(830,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtLogin){
                String enteredUsername = jtfUsername.getText();
                String enteredPassword = new String(jtfPassword.getPassword());
                
                if(!enteredUsername.equals("") && !enteredPassword.equals("")){
                    auth = new Authentication(enteredUsername, enteredPassword);
                    //test
//                    String username = auth.getUsername();
//                    if(auth != null){
//                        JOptionPane.showMessageDialog(null,"Username is "+username,"NULL",JOptionPane.INFORMATION_MESSAGE);
//                    }
                    boolean validity = loginControl.verifyLogin(auth);
                    
                    if(validity){
                        //JOptionPane.showMessageDialog(null,"Congrats login successful!","Welcome",JOptionPane.INFORMATION_MESSAGE);
                        currentUser = enteredUsername;
                        curAccType = (loginControl.selectAuth(auth)).getAccounttype();
                        
                        //check whether default password is used.
                        boolean defaultPassword = false;
                        defaultPassword = loginControl.verifyDefaultPassword(auth);
                        loginControl.closeDB();
                        
                        if(defaultPassword){
                            JOptionPane.showMessageDialog(null, "System has detected you are using default password.\nPlease be reminded that you should change your password\nas soon as possible to protect your account.\nYou will be automatically redirected to the Change Password Page.", "Default Password Used", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new ChangePasswordPage(curAccType);
                        }
                        else{
                            dispose();
                            new homePage(curAccType);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid username or password.","Login Failed",JOptionPane.ERROR_MESSAGE);
                        jtfUsername.setText("");
                        jtfPassword.setText("");
                        jtfUsername.requestFocusInWindow();
                    }
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Both username and password fields cannot be blank!","Attention",JOptionPane.WARNING_MESSAGE);
                    jtfUsername.requestFocusInWindow();
                    
                }
            }
            else if(e.getSource() == jbtReset){
                jtfUsername.setText("");
                jtfPassword.setText("");
                jtfUsername.requestFocusInWindow();
            }
            else if(e.getSource() == jbtForget){
                
                dispose();
                new PasswordRecoveryPage();
            }
            else{ //exit button
               loginControl.closeDB();
               System.exit(0); 
            }
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            
            dispose();
            loginControl.closeDB();
       }
    }
    
    public static void main(String[] args){
        //LoginPage login = new LoginPage();
        new LoginPage();
    }
    
    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWayLogo.jpg")));
    }        
    
    
}