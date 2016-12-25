//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffMenu extends JFrame{
    
    private char accType;
    
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
    private ImageIcon createIcon = new ImageIcon(getClass().getResource("../images/create 25x25.png"));
    private ImageIcon retrieveIcon = new ImageIcon(getClass().getResource("../images/retrieve 25x25.png"));
    private ImageIcon updateIcon = new ImageIcon(getClass().getResource("../images/update 25x26.png"));
    private ImageIcon deleteIcon = new ImageIcon(getClass().getResource("../images/delete 25x25.png"));
    
    private JPanel jpCenter = new JPanel(new GridLayout(11,1,0,0));
    
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
    private JPanel jpCenter_r11 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    private JButton jbtStaffReg = new JButton("New Staff Registration", createIcon);
    private JButton jbtRetrieveStaff = new JButton("Retrieve Staff Information", retrieveIcon);
    private JButton jbtUpdateStaff = new JButton("Update Staff Information", updateIcon);
    private JButton jbtDeleteStaff = new JButton("Delete Staff Record", deleteIcon);
    
    private JLabel jlbTitle = new JLabel("Staff Menu");
    
    private JPanel global = new JPanel(new BorderLayout()){  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(StaffMenu.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    private Color btnColor = new Color(214, 239, 159);
    
    Font groupTitle = new Font("Old Century",Font.BOLD,16);
    
    //Font titleFont = new Font("Comic Sans MS",Font.BOLD,18);
    
    public StaffMenu(){
        
    }
    
    public StaffMenu(char accType){
        this.accType = accType;
        
        
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
        jpCenter_r11.setOpaque(false);
        jpNorth.setOpaque(false);
        
        jbtStaffReg.setBackground(btnColor);
        jbtRetrieveStaff.setBackground(btnColor);
        jbtUpdateStaff.setBackground(btnColor);
        jbtDeleteStaff.setBackground(btnColor);
        
        jbtStaffReg.setPreferredSize(new Dimension(340, 35));
        jbtRetrieveStaff.setPreferredSize(new Dimension(340, 35));
        jbtUpdateStaff.setPreferredSize(new Dimension(340, 35));
        jbtDeleteStaff.setPreferredSize(new Dimension(340, 35));
        
        jlbTitle.setFont(groupTitle);
        
        jpCenter_r1.add(new JLabel(""));
        jpCenter_r2.add(jlbTitle);
        jpCenter_r3.add(new JLabel(""));
        jpCenter_r4.add(jbtStaffReg);
        jpCenter_r5.add(new JLabel(""));
        jpCenter_r6.add(jbtRetrieveStaff);
        jpCenter_r7.add(new JLabel(""));
        jpCenter_r8.add(jbtUpdateStaff);
        jpCenter_r9.add(new JLabel(""));
        jpCenter_r10.add(jbtDeleteStaff);
        
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
        jpCenter.add(jpCenter_r11);
        
        //jpNorth.add(logo, BorderLayout.NORTH);
        //jpNorth.add(jlbTitle, BorderLayout.CENTER);
        
        jpNorth.add(new JLabel(" "), BorderLayout.NORTH);
        jpNorth.add(logo, BorderLayout.CENTER);

        
        //global.add(jlbTitle, BorderLayout.NORTH);
        global.add(jpNorth, BorderLayout.NORTH);
        global.add(jpCenter, BorderLayout.CENTER);
        
        add(global, BorderLayout.CENTER);
        
        jbtStaffReg.addActionListener(new ButtonListener());
        jbtRetrieveStaff.addActionListener(new ButtonListener());
        jbtUpdateStaff.addActionListener(new ButtonListener());
        jbtDeleteStaff.addActionListener(new ButtonListener());
        
        //register window listener
        addWindowListener(new WindowListener());
        
        setIcon();
        setTitle("Staff Menu");
        setSize(400,650);
        //pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtStaffReg){
                
                dispose();
                //new StaffRegistration(accType);
            }
            else if(e.getSource() == jbtRetrieveStaff){
                //new RetrieveStaffInfo();
                dispose();
                new StaffInfoRetrieval(accType);
            }
            else if(e.getSource() == jbtUpdateStaff){
                //new UpdateStaffInfo();
                dispose();
                //new StaffInfoUpdate(accType);
            }
            else if(e.getSource() == jbtDeleteStaff){
                
                dispose();
                //new StaffRecordDeletion(accType);
            }
            
        }
    }
    
    private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
            int confirm = JOptionPane.showConfirmDialog(null,"Return to Main Menu?","Return?",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                    
                    dispose();
                    new homePage(accType);
        }
            
       }
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/ezWaylogo.jpg")));
    }
    
    public static void main(String[] args){
        
        new StaffMenu('A');
    }
}