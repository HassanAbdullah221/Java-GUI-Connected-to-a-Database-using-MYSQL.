/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author hassan
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;
import javax.swing.*;
import java.sql.Connection;
import java.sql.*;



public class Delete extends JFrame implements ActionListener {
    
    static JLabel lb1 = new JLabel("Delete Form");
    static JTextField username = new JTextField("Enter Your Username",20);
    static JButton deBtn = new JButton ("Delete");
    static JButton cancelBtn = new JButton ("Cancel");
    Connection con = null;
    PreparedStatement p;
    
    
    public Delete()
    {
     this.setTitle("Delete");
     this.setVisible(true);
     this.setSize(250,200);
     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     this.setLayout(new FlowLayout());
     this.add(lb1);
     this.add(username);
     this.add(deBtn);
     this.add(cancelBtn);
     
      deBtn.addActionListener(this);
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
        
         if(e.getSource() == deBtn ){
            
             try{
             p = con.prepareStatement(" Delete from users where username = ? ");
             p.setString(1, username.getText() );
             p.executeUpdate();
             JOptionPane.showMessageDialog(rootPane, "Record deleted successfully");
             
         }
             catch(SQLException se){
                 System.out.println(se.getMessage());
             }
         }
    }
    }