/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 
@author hassan*/
public class Lab9 extends JFrame implements ActionListener {
        static JLabel lb1 = new JLabel("Welcome to My Project");
        static JButton regBtn = new JButton ("Register");
        static JButton loginBtn = new JButton ("Login");
        static JButton UpdateBtn = new JButton ("Update");
        static JButton DeleteBtn = new JButton ("Delete");

    public static void main(String[] args) {
        try{
        String de_url = "jdbc:mysql://localhost:3306/mydb";
        String de_username = "root";
        String de_password = "#221430830Hh";
        Connection con = DriverManager.getConnection(de_url ,de_username , de_password );

        }
        catch(SQLException s){
            System.out.println(s.getMessage());

        }

        Lab9 frm = new Lab9();
        frm.setTitle("Home");
        frm.setVisible(true);
        frm.setSize(200,200);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new FlowLayout());
        frm.add(lb1);
        frm.add(regBtn);
        frm.add(loginBtn);
        frm.add(DeleteBtn);
        frm.add(UpdateBtn);

           regBtn.addActionListener(frm);
           loginBtn.addActionListener(frm);
           DeleteBtn.addActionListener(frm);
            UpdateBtn.addActionListener(frm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regBtn){
            Registration regFrm = new Registration();
        }
        if (e.getSource() == loginBtn){
            Login loginFrm = new Login();
        }
        if (e.getSource() == DeleteBtn){
            Delete DeleteFrm = new Delete();
        }
       if (e.getSource() == UpdateBtn){
            Update updateFrm = new Update();
        }
       

    }

}