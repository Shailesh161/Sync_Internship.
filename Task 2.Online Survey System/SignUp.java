package survey;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp {
	public void signUpView() {
		JFrame frame = new JFrame();
		frame.setSize(450, 450);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel heading = new JLabel("SURVEY SYSTEM");
		heading.setBounds(0, 50, 450, 50);
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 40));
		frame.add(heading);
		
		JLabel fName = new JLabel("Name : ");
		fName.setBounds(50, 120, 150, 50);
		frame.add(fName);
		
		JTextField fNameField = new JTextField();
		fNameField.setBounds(50, 160, 350, 30);
		frame.add(fNameField);
		
		JLabel uName = new JLabel("Username : ");
		uName.setBounds(50, 190, 150, 50);
		frame.add(uName);
		
		JTextField uNameField = new JTextField();
		uNameField.setBounds(50, 230, 350, 30);
		frame.add(uNameField);
		
		JLabel uPass = new JLabel("Password : ");
		uPass.setBounds(50, 260, 150, 50);
		frame.add(uPass);
		
		JPasswordField uPassField = new JPasswordField();
		uPassField.setBounds(50, 300, 150, 30);
		frame.add(uPassField);
		
		JLabel uPass2 = new JLabel("Confirm Password : ");
		uPass2.setBounds(250, 260, 150, 50);
		frame.add(uPass2);
		
		JPasswordField uPassField2 = new JPasswordField();
		uPassField2.setBounds(250, 300, 150, 30);
		frame.add(uPassField2);
		
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(175, 350, 100, 40);
		frame.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fname = fNameField.getText();
				String uname = uNameField.getText();
				String pass1 = uPassField.getText();
				String pass2 = uPassField2.getText();
				if(fname.isEmpty() || uname.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please Enter All Details!!!", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(pass1.equals(pass2)) {
                                            SQLManage manage = null;
                                            try {
                                                manage = new SQLManage();
                                            } catch (SQLException ex) {
                                                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            try {
                                                manage.newUser(fname, uname, pass1);
                                            } catch (SQLException ex) {
                                                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            fNameField.setText("");
                                            uNameField.setText("");
                                            uPassField.setText("");
                                            uPassField2.setText("");
                                            JOptionPane.showMessageDialog(frame, "User Created Succesfully!!!", "User Created", JOptionPane.PLAIN_MESSAGE);
                                            frame.dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(frame, "Password Mismatch", "Warning Message", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		
		frame.setVisible(true);
	}
}