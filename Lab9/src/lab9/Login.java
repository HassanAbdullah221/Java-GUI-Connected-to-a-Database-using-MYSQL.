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
import java.beans.*;

/**
 *
 
@author hassan*/
public class Login extends JFrame implements ActionListener{


        static JLabel lb1 = new JLabel("Login Form");
        static JTextField username = new JTextField(20);
        static JPasswordField password = new JPasswordField(20);
        static JButton loginBtn = new JButton ("Login");
        static JButton cancelBtn = new JButton ("Cancel");
        Connection con = null;
       
        public Login (){
           this.setTitle("Login");
            this.setVisible(true);
            this.setSize(300,200);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.add(lb1);
            username.setText("Enter Your Username");
            password.setText("Enter Your Login");
            this.add(username);
            this.add(password);
            this.add(loginBtn);
            this.add(cancelBtn);
            loginBtn.addActionListener(this);
            cancelBtn.addActionListener(this);
            
           try {
                String db_url = "jdbc:mysql://localhost:3306/mydb?useSSL=true";
                String db_username = "root";
                String db_password = "#221430830Hh";
                con = DriverManager.getConnection(db_url , db_username , db_password);
            }
            catch(SQLException sql ){
                System.out.println(sql.getMessage());
            }
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn){
            String uname = username.getText();
            String pass = password.getText();
            String sql = "SELECT username , pass FROM mydb.users;";
           
             try{
                Statement s = con.createStatement();
                ResultSet resultset = s.executeQuery(sql);
               while(resultset.next()){
                   if(uname.equals(resultset.getObject(1))&&
                           pass.equals(resultset.getObject(2))){
                      
                     JOptionPane.showMessageDialog(rootPane , "Logged in!!!");
                   }
               }
            }
            catch(SQLException sqlexception ){
                System.out.println(sqlexception.getMessage());
            }
            
        }
        if(e.getSource() == cancelBtn){
            
        }
    }

}


