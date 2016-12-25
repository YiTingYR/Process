//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecurityFeaturesMenu extends JFrame{
    
    private char accType;
    
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    private ImageIcon addUserIcon = new ImageIcon(getClass().getResource("../images/addUser1 35x35.png"));
    private ImageIcon remUserIcon = new ImageIcon(getClass().getResource("../images/remUser2 35x35.png"));
    private ImageIcon chgPWIcon = new ImageIcon(getClass().getResource("../images/chgPW1 35x35.png"));
    
    private JPanel jpCenter = new JPanel(new GridLayout(10,1,0,0));
    
    private JPanel jpNorth = new JPanel(new BorderLayout());
    
    private JPanel jpCenter_r1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel jpCenter_r10 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    private JButton jbtNewUser = new JButton("New User Registration", addUserIcon);
    private JButton jbtRemUser = new JButton("Remove User from the System", remUserIcon);
    private JButton jbtChangePW = new JButton("Change Password", chgPWIcon);
    
    private JLabel jlbTitle = new JLabel("Security Features Menu");
    
    private JPanel global = new JPanel(new BorderLayout()){  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(SecurityFeaturesMenu.class.getResource("../images/green4.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    private Color btnColor = new Color(214, 239, 159);
    
    Font groupTitle = new Font("Old Century",Font.BOLD,16);
    
    //Font titleFont = new Font("Comic Sans MS",Font.BOLD,18);
    
    public SecurityFeaturesMenu(){
        
    }
    
    public SecurityFeaturesMenu(char accType){
        
        this.accType = accType;
        
        if(accType == 'U'){
            jbtNewUser.setEnabled(false);
            jbtRemUser.setEnabled(false);
            jbtChangePW.setEnabled(true);
        }
        else{
            jbtNewUser.setEnabled(true);
            jbtRemUser.setEnabled(true);
            jbtChangePW.setEnabled(true);
        }
    
        
        jpCenter.setOpaque(false);
        jpCenter_r1.setOpaque(false);
        jpCenter_r2.setOpaque(false);
        jpCenter_r3.setOpaque(false);
        jpCenter_r4.setOpaque(false);
        jpCenter_r5.setOpaque(false);
        jpCenter_r6.setOpaque(false);
        jpCenter_r7.setOpaque(false);
        jpCenter_r8.setOpaque(false);
        jpCenter_r9.setOpaque(false);
        jpCenter_r10.setOpaque(false);
        jpNorth.setOpaque(false);
        
        jbtNewUser.setBackground(btnColor);
        jbtRemUser.setBackground(btnColor);
        jbtChangePW.setBackground(btnColor);
        
        jbtNewUser.setPreferredSize(new Dimension(340, 35));
        jbtRemUser.setPreferredSize(new Dimension(340, 35));
        jbtChangePW.setPreferredSize(new Dimension(340, 35));
        
        jlbTitle.setFont(groupTitle);
        
        jpCenter_r1.add(new JLabel(""));
        jpCenter_r2.add(jlbTitle);
        jpCenter_r3.add(new JLabel(""));
        jpCenter_r4.add(jbtNewUser);
        jpCenter_r5.add(new JLabel(""));
        jpCenter_r6.add(jbtRemUser);
        jpCenter_r7.add(new JLabel(""));
        jpCenter_r8.add(jbtChangePW);
        jpCenter_r9.add(new JLabel(""));
        jpCenter_r10.add(new JLabel(""));
        
        jpCenter.add(jpCenter_r1);
        jpCenter.add(jpCenter_r2);
        jpCenter.add(jpCenter_r3);
        jpCenter.add(jpCenter_r4);
        jpCenter.add(jpCenter_r5);
        jpCenter.add(jpCenter_r6);
        jpCenter.add(jpCenter_r7);
        jpCenter.add(jpCenter_r8);
        jpCenter.add(jpCenter_r9);
        jpCenter.add(jpCenter_r10);
        
        //jpNorth.add(logo, BorderLayout.NORTH);
        //jpNorth.add(jlbTitle, BorderLayout.CENTER);
        
        jpNorth.add(new JLabel(" "), BorderLayout.NORTH);
        jpNorth.add(logo, BorderLayout.CENTER);

        
        //global.add(jlbTitle, BorderLayout.NORTH);
        global.add(jpNorth, BorderLayout.NORTH);
        global.add(jpCenter, BorderLayout.CENTER);
        
        add(global, BorderLayout.CENTER);
        
        jbtNewUser.addActionListener(new ButtonListener());
        jbtRemUser.addActionListener(new ButtonListener());
        jbtChangePW.addActionListener(new ButtonListener());
        
        //register window listener
        addWindowListener(new WindowListener());
        
        setIcon();
        setTitle("Security Features Menu");
        setSize(400,600);
        //pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtNewUser){
                //new StaffRegistration();
                dispose();
                //new AddNewUser(accType);
            }
            else if(e.getSource() == jbtRemUser){
                //new RetrieveStaffInfo();
                dispose();
                //new RemoveUserPage(accType);
            }
            else if(e.getSource() == jbtChangePW){
                //new UpdateStaffInfo();
                dispose();
                //new ChangePasswordPage(accType);
            }
            
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            int confirm = JOptionPane.showConfirmDialog(null,"Return to Main Menu?","Return?",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                    setVisible(false);
                    dispose();
                    new homePage(accType);
                    //new Home();
        }
            else{
                
            }
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        
        new SecurityFeaturesMenu('U');
    }
}