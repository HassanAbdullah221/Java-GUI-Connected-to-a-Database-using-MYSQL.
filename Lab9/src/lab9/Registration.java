/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author hassan
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;



public class Registration extends JFrame implements ActionListener{

        static JLabel lb1 = new JLabel("Registration Form");
        static JButton regBtn = new JButton ("Register");
        static JButton cancelBtn = new JButton ("Cancel");
        static JTextField fstname = new JTextField(20);
        static JTextField lstname = new JTextField(20);
        static JTextField username = new JTextField(20);
        static JPasswordField password = new JPasswordField(20);
        Connection con = null;
        public Registration(){

            this.setTitle("Registration");
            this.setVisible(true);
            this.setSize(300,200);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLayout(new FlowLayout());
            this.add(lb1);
            fstname.setText("Enter Your First Name");
            lstname.setText("Enter Your Last Name");
            username.setText("Enter Your Username");
            password .setText("Enter Your Password");
            this.add(fstname);
            this.add(lstname);
            this.add(username);
            this.add(password);
            this.add(regBtn);
            this.add(cancelBtn);

            regBtn.addActionListener(this);
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
        if(e.getSource() == regBtn ){
            String fname = fstname.getText();
            String lname = lstname.getText();
            String uname = username.getText();
            String pass = password.getText();
            String sql = String.format("Insert Into users(fname,lname,username,pass) values ('%s','%s','%s','%s')",fname,lname,uname,pass );
            
            try{
                Statement s = con.createStatement();
                s.executeUpdate(sql);
            }
             catch(SQLException  sqlException ){
                System.out.println(sqlException.getMessage());
            }
        }
        if (e.getSource() == cancelBtn){

        }
    }



}