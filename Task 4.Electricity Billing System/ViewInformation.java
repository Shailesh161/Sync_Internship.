import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewInformation extends JFrame{

    ViewInformation(String meter) {
        setBounds(350, 150, 500, 300);
        getContentPane().setBackground(new Color(0X78DEC7));
        setLayout(null);
        
        
        JLabel heading = new JLabel("CUSTOMER INFORMATION");
        heading.setBounds(150, 20, 500, 40);
        heading.setFont(new Font("MV Boli", Font.BOLD, 15));
        add(heading);
        
        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("MV Boli", Font.BOLD, 15));
        lblname.setBounds(100, 60, 100, 40);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setFont(new Font("MV Boli", Font.BOLD, 15));
        name.setBounds(250, 60, 100, 40);
        add(name);
        
        JLabel lblmeternumber = new JLabel("Meter No:");
        lblmeternumber.setFont(new Font("MV Boli", Font.BOLD, 15));
        lblmeternumber.setBounds(70, 130, 100, 40);
        add(lblmeternumber);
        
        JLabel meternumber = new JLabel("");
        meternumber.setFont(new Font("MV Boli", Font.BOLD, 20));
        meternumber.setBounds(250, 130, 100, 40);
        add(meternumber);
 
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
            while(rs.next()) {
                name.setText(rs.getString("name"));

                meternumber.setText(rs.getString("meter_no"));
            }
        } catch (Exception e) {
        }
  
        setVisible(true);
    }
   
    public static void main(String[] args) {
        new ViewInformation("");
    }
}