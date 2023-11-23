
package lab9;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Update extends JFrame implements ActionListener {
    
     static JTextField username = new JTextField(20);
     static JTextField fstname = new JTextField("Enter Your First Name",20);
     static JTextField lstname = new JTextField("Enter Your Second Name",20);
     static JLabel lb1 = new JLabel("Update Form");
     static JButton upBtn = new JButton ("Update");
     static JButton cancelBtn = new JButton ("Cancel");
     static JPasswordField password = new JPasswordField("Enter Your Password",20);
    Connection con = null;
    PreparedStatement p = null ;
     
public Update()
{
     this.setTitle("Update");
     this.setVisible(true);
     this.setSize(300,200);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.setLayout(new FlowLayout());
     this.add(lb1);
     username.setText("Enter Your Username");
     this.add(username);
     this.add(fstname);
     this.add(lstname);
     this.add(password);
     this.add(upBtn);
     this.add(cancelBtn);
     
      upBtn.addActionListener(this);
      cancelBtn.addActionListener(this);
      
       try{
        String de_url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
        String de_username = "root";
        String de_password = "#221430830Hh";
        con = DriverManager.getConnection(de_url ,de_username , de_password );

        }
        catch(SQLException s){
            System.out.println(s.getMessage());

        }
     
     
          
}
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == upBtn )
        {
              try{
             String uname = username.getText();
             p = con.prepareStatement("update users set fname = ? , lname = ? , pass = ? where username = ?");
             p.setString(1, fstname.getText());
             p.setString(2, lstname.getText());
             p.setString(3, password.getText());
             p.setString(4,username.getText());
             p.executeUpdate();
             JOptionPane.showMessageDialog(rootPane, "Record updated successfully");
             
         }
             catch(SQLException se){
                 System.out.println(se.getMessage());
             }
        }
        
        if(e.getSource() == cancelBtn )
        {
            username.setText("");
            fstname.setText("");
            lstname.setText("");
            password.setText("");
        }
        
    }
    
}