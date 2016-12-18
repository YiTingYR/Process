//Sum
//V1.01 25MAR16 1129PM *Note: heavily modified, added class variables, button listener, method.
package ui; //Author:Teh Yi Ting
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;  
import javax.swing.border.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
 
public class ReportMenu extends JFrame
{
    
    private char accType;
    
    private Date startDate; //added sum
    
    private Date endDate; //added sum
    
    private String reportType; //added sum
    
    private ReportMenu thisFrame; //added sum
    
     JPanel jpanel=new JPanel() { 
  
   public void paintComponent(Graphics g) {  
     Image img = Toolkit.getDefaultToolkit().getImage(  
     homePage.class.getResource("../images/homePageBackground.jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
     }  
   }; 
     ImageIcon iconLogo=new ImageIcon(getClass().getResource("../images/ezWayLogo.jpg"));
     ImageIcon iconHome=new ImageIcon(getClass().getResource("../images/homepageicon.png"));

     Font buttonFont=new Font("French Script MT",Font.ITALIC,45);
     Font buttonFont2=new Font("Century",Font.ITALIC,18);
     JLabel jlogo=new JLabel(iconLogo);
     JLabel jschedule=new JLabel("ezWay Express- Generating Report"); 
     JPanel jp2=new JPanel(new GridLayout(5,1));
     
     JPanel menuPanel_r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r2=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r3=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r4=new JPanel(new FlowLayout(FlowLayout.CENTER));
     JPanel menuPanel_r5=new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    JButton jbtEReport=new JButton("Top 3 Routes of the Month Report");
    JButton jbtSReport=new JButton("Gross Profits Monthly Report");
    JButton jbtSReport2=new JButton("No of Tickets Sold Monthly Report"); 
    JButton jbtTReport=new JButton("Daily Sales Transaction Report");
    JButton jbtHome=new JButton("Back",iconHome);
  
     LineBorder buttonBorder=new LineBorder(new Color(60,179,113),3);
     LineBorder buttonBorder2=new LineBorder(new Color(128,128,128),3);
   public ReportMenu(){
       
   }
     public ReportMenu(final char accType)
    {
        
        this.accType = accType;
        if(accType == 'U'){
            jbtTReport.setEnabled(true);
            jbtSReport.setEnabled(false);
            jbtSReport2.setEnabled(false);
            jbtEReport.setEnabled(false);
        }
        else{
            jbtTReport.setEnabled(true);
            jbtSReport.setEnabled(true);
            jbtSReport2.setEnabled(true);
            jbtEReport.setEnabled(true);
        }
        
     setLayout(new BorderLayout());
     
     jlogo.setHorizontalAlignment(SwingConstants.CENTER);
     jpanel.add(jlogo);
     jpanel.add(jschedule);
     jschedule.setFont(buttonFont);
      
     jbtEReport.setPreferredSize(new Dimension(300, 50));
     jbtSReport.setPreferredSize(new Dimension(300, 50));
     jbtSReport2.setPreferredSize(new Dimension(300, 50));
     jbtHome.setPreferredSize(new Dimension(300, 50));
     jbtTReport.setPreferredSize(new Dimension(300, 50));
    
      jbtEReport.setFont(buttonFont2);
      jbtSReport.setFont(buttonFont2);
      jbtSReport2.setFont(buttonFont2);
      jbtHome.setFont(buttonFont2);
      jbtTReport.setFont(buttonFont2);
     
       jbtEReport.setBackground(Color.WHITE);
       jbtSReport.setBackground(Color.WHITE);
       jbtSReport2.setBackground(Color.WHITE);
       jbtHome.setBackground(Color.WHITE);
       jbtTReport.setBackground(Color.WHITE);
       
       jbtEReport.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtEReport.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtEReport.setBackground(Color.WHITE);
        
    }
});
        jbtSReport.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSReport.setBackground(new Color(230, 230, 230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSReport.setBackground(Color.WHITE);
        
    }
});
         jbtSReport2.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtSReport2.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtSReport2.setBackground(Color.WHITE);
        
    }
});
       jbtTReport.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtTReport.setBackground(new Color(230,230,230));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtTReport.setBackground(Color.WHITE);
        
    }
});
       
        jbtHome.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        jbtHome.setBackground(new Color(179, 255, 226));
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        jbtHome.setBackground(Color.WHITE);
        
    }
});
        jbtHome.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               closeFrame();
               new homePage(accType);
           }
       });
        
        //disabled
//        jbtSReport.addActionListener(new ActionListener()
//       {
//           public void actionPerformed(ActionEvent e)
//           {
//               //closeFrame();
//              // new ();
//           }
//       });
        
//        jbtTReport.addActionListener(new ActionListener()
//       {
//           public void actionPerformed(ActionEvent e)
//           {
//               //closeFrame();
//               //new ();
//           }
//       });
        
        
        //disabled
//        jbtEReport.addActionListener(new ActionListener()
//       {
//           public void actionPerformed(ActionEvent e)
//           {
//               //closeFrame();
//               //new ();
//               
//           }
//       });
//        jbtSReport2.addActionListener(new ActionListener()
//       {
//           public void actionPerformed(ActionEvent e)
//           {
//               //closeFrame();
//               //new ();
//           }
//       });
        
        //sum added
        thisFrame = this;
        
        jbtEReport.addActionListener(new ButtonListener());
        jbtSReport.addActionListener(new ButtonListener());
        jbtSReport2.addActionListener(new ButtonListener());
        jbtTReport.addActionListener(new ButtonListener());
       
       jbtEReport.setBorder(buttonBorder);
       jbtSReport2.setBorder(buttonBorder);
       jbtHome.setBorder(buttonBorder);
       
       jbtSReport.setBorder(buttonBorder2);
       jbtTReport.setBorder(buttonBorder2);
      
      jbtEReport.setMnemonic('T');
      jbtSReport.setMnemonic('G');
      jbtSReport2.setMnemonic('M');
      jbtHome.setMnemonic('B');
      jbtTReport.setMnemonic('D');
     
      menuPanel_r1.setOpaque(false);
      menuPanel_r2.setOpaque(false);
      menuPanel_r3.setOpaque(false);
      menuPanel_r4.setOpaque(false);
      menuPanel_r5.setOpaque(false);
     
      menuPanel_r1.add(jbtEReport);
      menuPanel_r2.add(jbtSReport);
      menuPanel_r3.add(jbtSReport2);
      menuPanel_r4.add(jbtTReport); 
      menuPanel_r5.add(jbtHome);
     
      jp2.setOpaque(false);
      jp2.add( menuPanel_r1);
      jp2.add( menuPanel_r2);
      jp2.add( menuPanel_r3);
      jp2.add( menuPanel_r4);
      jp2.add( menuPanel_r5);
       
     jpanel.add(jp2,BorderLayout.CENTER);
     add(jpanel,BorderLayout.CENTER);
     
     addWindowListener(new WindowListener());
     
     setIcon();
     setTitle("Report Menu");
     setSize(850,600);
     setVisible(true);
     setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
     setLocationRelativeTo(null);
    }
      public void closeFrame() {
                this.dispose();
        }
      private void setIcon() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/ezWayLogo.jpg")));
    }
      
      //added Sum
      private class ButtonListener implements ActionListener{
          public void actionPerformed(ActionEvent e){
              if(e.getSource() == jbtEReport){
                  
                  //temporarily hide this frame while the select date frame is active
                  setVisible(false);
                  reportType = "Top3";
                  new selectReportDate(accType, reportType, thisFrame);

              }
              else if(e.getSource() == jbtSReport){
                  
                  //temporarily hide this frame while the select date frame is active
                  setVisible(false);
                  reportType = "GrossProfits";
                  new selectReportDate(accType, reportType, thisFrame);
              }
              else if(e.getSource() == jbtSReport2){
                  
                  //temporarily hide this frame while the select date frame is active
                  setVisible(false);
                  reportType = "NoOfTickets";
                  new selectReportDate(accType, reportType, thisFrame);
              }
              else if(e.getSource() == jbtTReport){////////////////////////////Yi TIng 's report
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");;
                  
                String reportSource = "././src/ui/report2yt.jrxml"; 

                //test
                //String reportSource = "././src/test1.jrxml"; 
                
                // this is parameter object to pass to the report, it is empty now,
                // example of passing  parameters into template will be discussed later
                Map<String, Object> params = new HashMap<String, Object>(); 
                
                
                
                try{
                    
                    //temp dev
                    //params.put("startDate", dateFormat.parse("01-03-2016")); //tested OK
                    //params.put("endDate", dateFormat.parse("31-03-2016")); //tested OK
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "error in parsing startDate and endDate.", "Error", JOptionPane.WARNING_MESSAGE);
                }

                try
                {	
                        String host = "jdbc:derby://localhost:1527/ezwaydb";
                        String user = "nbuser";
                        String password = "nbuser";
                        // connect to DB 
                        Class.forName("org.apache.derby.jdbc.ClientDriver"); 

                        Connection conn = 
                                    DriverManager.getConnection(host,user,password);
                 JasperReport jasperReport =
                        JasperCompileManager.compileReport(reportSource);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,conn);

                JasperViewer.viewReport(jasperPrint, false); 
                } 
                 catch (JRException jrex)
                        {
                            JOptionPane.showMessageDialog(null, "error in generating report");
                             jrex.printStackTrace();
                             System.out.println(jrex.toString());
                        }
                 catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, "Unble to generate report~!");
                                ex.printStackTrace();
                        }
                              }
          }
      }
      
      private class WindowListener extends WindowAdapter{
        public void windowClosing(WindowEvent e) {
        
           int confirm = JOptionPane.showConfirmDialog(null, "Return to Main Menu?", "Return?", JOptionPane.YES_NO_OPTION);
           if(confirm == JOptionPane.YES_OPTION){

                dispose();
                new homePage(accType);
           }
       }
    }
      
    //sum added
//    public void receiveDates(Date startDate, Date endDate){
//        this.startDate = startDate;
//        this.endDate = endDate;
//        
//    }
    
    public void reportCentralHub(Date startDate, Date endDate, String reportType, char accType){
        
        //show back this frame
        setVisible(true);
        
        this.reportType = reportType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accType = accType;
        
        if(reportType.equals("Top3")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");;
                  
                String reportSource = "././src/ui/Top3Routes.jrxml"; 

                //test
                //String reportSource = "././src/test1.jrxml"; 
                
                // this is parameter object to pass to the report, it is empty now,
                // example of passing  parameters into template will be discussed later
                Map<String, Object> params = new HashMap<String, Object>(); 
                
                
                
                try{
                    
//                    //temp dev
//                    params.put("startDate", dateFormat.parse("01-03-2016")); //tested OK
//                    params.put("endDate", dateFormat.parse("31-03-2016")); //tested OK
                    
                    params.put("startDate", startDate); //tested OK
                    params.put("endDate", endDate); //tested OK
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "error in parsing startDate and endDate.", "Error", JOptionPane.WARNING_MESSAGE);
                }

                try
                {	
                        String host = "jdbc:derby://localhost:1527/ezwaydb";
                        String user = "nbuser";
                        String password = "nbuser";
                        // connect to DB 
                        Class.forName("org.apache.derby.jdbc.ClientDriver"); 

                        Connection conn = 
                                    DriverManager.getConnection(host,user,password);
                 JasperReport jasperReport =
                        JasperCompileManager.compileReport(reportSource);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,conn);

                JasperViewer.viewReport(jasperPrint, false); 
                } 
                 catch (JRException jrex)
                        {
                            JOptionPane.showMessageDialog(null, "error in generating report");
                             jrex.printStackTrace();
                             System.out.println(jrex.toString());
                        }
                 catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, "Unble to generate report~!");
                                ex.printStackTrace();
                        }
                
        }
        else if(reportType.equals("NoOfTickets")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");;
                  
                String reportSource = "././src/ui/NoOfTickets.jrxml"; 

                //test
                //String reportSource = "././src/test1.jrxml"; 
                
                // this is parameter object to pass to the report, it is empty now,
                // example of passing  parameters into template will be discussed later
                Map<String, Object> params = new HashMap<String, Object>(); 
                
                
                
                try{
                    
//                    //temp dev
//                    params.put("startDate", dateFormat.parse("01-03-2016")); //tested OK
//                    params.put("endDate", dateFormat.parse("31-03-2016")); //tested OK
                    
                    params.put("startDate", startDate); //tested OK
                    params.put("endDate", endDate); //tested OK
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "error in parsing startDate and endDate.", "Error", JOptionPane.WARNING_MESSAGE);
                }

                try
                {	
                        String host = "jdbc:derby://localhost:1527/ezwaydb";
                        String user = "nbuser";
                        String password = "nbuser";
                        // connect to DB 
                        Class.forName("org.apache.derby.jdbc.ClientDriver"); 

                        Connection conn = 
                                    DriverManager.getConnection(host,user,password);
                 JasperReport jasperReport =
                        JasperCompileManager.compileReport(reportSource);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,conn);

                JasperViewer.viewReport(jasperPrint, false); 
                } 
                 catch (JRException jrex)
                        {
                            JOptionPane.showMessageDialog(null, "error in generating report");
                             jrex.printStackTrace();
                             System.out.println(jrex.toString());
                        }
                 catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, "Unble to generate report~!");
                                ex.printStackTrace();
                        }
        }
        else if(reportType.equals("GrossProfits")){
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");;
                  
                String reportSource = "././src/ui/GrossProfits.jrxml"; 

                //test
                //String reportSource = "././src/test1.jrxml"; 
                
                // this is parameter object to pass to the report, it is empty now,
                // example of passing  parameters into template will be discussed later
                Map<String, Object> params = new HashMap<String, Object>(); 
                
                
                
                try{
                    
//                    //temp dev
//                    params.put("startDate", dateFormat.parse("01-03-2016")); //tested OK
//                    params.put("endDate", dateFormat.parse("31-03-2016")); //tested OK
                    
                    params.put("startDate", startDate); //tested OK
                    params.put("endDate", endDate); //tested OK
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "error in parsing startDate and endDate.", "Error", JOptionPane.WARNING_MESSAGE);
                }

                try
                {	
                        String host = "jdbc:derby://localhost:1527/ezwaydb";
                        String user = "nbuser";
                        String password = "nbuser";
                        // connect to DB 
                        Class.forName("org.apache.derby.jdbc.ClientDriver"); 

                        Connection conn = 
                                    DriverManager.getConnection(host,user,password);
                 JasperReport jasperReport =
                        JasperCompileManager.compileReport(reportSource);

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,params,conn);

                JasperViewer.viewReport(jasperPrint, false); 
                } 
                 catch (JRException jrex)
                        {
                            JOptionPane.showMessageDialog(null, "error in generating report");
                             jrex.printStackTrace();
                             System.out.println(jrex.toString());
                        }
                 catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, "Unble to generate report~!");
                                ex.printStackTrace();
                        }
        }
    }
    
      public static void main(String[]args)
    {
        new ReportMenu('A');
    }
}