//Sum
//V1.00 24MAR16 1152AM
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import da.*;
import ui.*;
import domain.*;
import control.*;

public class TicketPurchasingMenu extends JFrame{
    
    private char accType;
    
    private ArrayList<OrderLine> orderLineList;
    
    private ImageIcon logoIcon = new ImageIcon(getClass().getResource("../images/ezWay150x129.jpg"));
    
    private JLabel logo = new JLabel(logoIcon,SwingConstants.CENTER);
    
//    private ImageIcon addUserIcon = new ImageIcon(getClass().getResource("../images/addUser1 35x35.png"));
//    private ImageIcon remUserIcon = new ImageIcon(getClass().getResource("../images/remUser2 35x35.png"));
//    private ImageIcon chgPWIcon = new ImageIcon(getClass().getResource("../images/chgPW1 35x35.png"));
    
    private ImageIcon orderIcon = new ImageIcon(getClass().getResource("../images/order1 35x35.png"));
    private ImageIcon ticChangeIcon = new ImageIcon(getClass().getResource("../images/ticketChange1 35x35.png"));
    
    private JPanel jpCenter = new JPanel(new GridLayout(10,1,0,0));
    
    private JPanel jpNorth = new JPanel(new BorderLayout());
    
    //private JPanel jpNorth_r1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
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
    
//    private JButton jbtNewUser = new JButton("New User Registration", addUserIcon);
//    private JButton jbtRemUser = new JButton("Remove User from the System", remUserIcon);
//    private JButton jbtChangePW = new JButton("Change Password", chgPWIcon);
    
    private JButton jbtView = new JButton("View and order available trip(s)", orderIcon);
    private JButton jbtChange = new JButton("Change Ticket", ticChangeIcon);
    
    private JLabel jlbTitle = new JLabel("Ticket Purchasing Menu");
    
    private JPanel global = new JPanel(new BorderLayout()){  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(TicketPurchasingMenu.class.getResource("../images/green1.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }};  
    
    private Color btnColor = new Color(214, 239, 159);
    
    Font groupTitle = new Font("Old Century",Font.BOLD,16);
    
    //Font titleFont = new Font("Comic Sans MS",Font.BOLD,18);
    public TicketPurchasingMenu(){
        
    }
    public TicketPurchasingMenu(char accType){
        
        this.accType = accType;
        
        //INSTANTIATION OF ORDERLINE LIST ARRAYLIST IS HERE
        orderLineList = new ArrayList<>();
        
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
        
//        jbtNewUser.setBackground(btnColor);
//        jbtRemUser.setBackground(btnColor);
//        jbtChangePW.setBackground(btnColor);
        
        jbtView.setBackground(btnColor);
        jbtChange.setBackground(btnColor);
        
//        jbtNewUser.setPreferredSize(new Dimension(340, 35));
//        jbtRemUser.setPreferredSize(new Dimension(340, 35));
//        jbtChangePW.setPreferredSize(new Dimension(340, 35));
        
        jbtView.setPreferredSize(new Dimension(340, 35));
        jbtChange.setPreferredSize(new Dimension(340, 35));
        
        jlbTitle.setFont(groupTitle);
        
        jpCenter_r1.add(new JLabel(""));
        jpCenter_r2.add(jlbTitle);
        jpCenter_r3.add(new JLabel(""));
        jpCenter_r4.add(new JLabel(""));
        jpCenter_r5.add(jbtView);
        jpCenter_r6.add(new JLabel(""));
        jpCenter_r7.add(jbtChange);
        jpCenter_r8.add(new JLabel(""));
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
        
        //jpNorth_r1.add(new JLabel(""));
        
        //jpNorth.add(jpNorth_r1, BorderLayout.NORTH);
        jpNorth.add(new JLabel(" "), BorderLayout.NORTH);
        jpNorth.add(logo, BorderLayout.CENTER);
        //jpNorth.add(logo, BorderLayout.NORTH);
        //jpNorth.add(jlbTitle, BorderLayout.CENTER);
        
        //global.add(jlbTitle, BorderLayout.NORTH);
        global.add(jpNorth, BorderLayout.NORTH);
        global.add(jpCenter, BorderLayout.CENTER);
        
        add(global, BorderLayout.CENTER);
        
//        jbtNewUser.addActionListener(new ButtonListener());
//        jbtRemUser.addActionListener(new ButtonListener());
//        jbtChangePW.addActionListener(new ButtonListener());
        
        jbtView.addActionListener(new ButtonListener());
        jbtChange.addActionListener(new ButtonListener());
        
        //register window listener
        addWindowListener(new WindowListener());
        
        setIcon();
        setTitle("Ticket Purchasing Menu");
        setSize(400,600);
        //pack();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == jbtView){
                
                dispose();
                new ShowAvailableTrips(accType, orderLineList);
            }
            else if(e.getSource() == jbtChange){
                //new RetrieveStaffInfo();
                dispose();
                new TicketChangePage(accType);
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
        
        new TicketPurchasingMenu('U');///////////////////////////dev///////////////////
    }
}