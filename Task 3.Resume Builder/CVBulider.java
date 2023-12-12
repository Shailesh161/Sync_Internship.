import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import javax.swing.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CVBulider extends JFrame {
    private JTextField nameField, SurNameField, cityField, emailField, skillsField, collegeField, degreeField, linkedInField, githubField, contactField, experienceField;
    private JPasswordField passwordField, confirmPasswordField;

    public CVBulider() {
        setTitle("Online Resume Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(14, 2, 5, 5));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel fatherNameLabel = new JLabel("Surname:");
        SurNameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField();
        JLabel cityLabel = new JLabel("City:");
        cityField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JLabel skillsLabel = new JLabel("Skills:");
        skillsField = new JTextField();
        JLabel collegeLabel = new JLabel("College:");
        collegeField = new JTextField();
        JLabel degreeLabel = new JLabel("Degree:");
        degreeField = new JTextField();
        JLabel linkedInLabel = new JLabel("LinkedIn:");
        linkedInField = new JTextField();
        JLabel githubLabel = new JLabel("GitHub:");
        githubField = new JTextField();
        JLabel contactLabel = new JLabel("Contact:");
        contactField = new JTextField();
        JLabel experienceLabel = new JLabel("Experience:");
        experienceField = new JTextField();

        JButton generateButton = new JButton("Generate CV");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCV();
            }
        });

        add(nameLabel);
        add(nameField);
        add(fatherNameLabel);
        add(SurNameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(cityLabel);
        add(cityField);
        add(emailLabel);
        add(emailField);
        add(skillsLabel);
        add(skillsField);
        add(collegeLabel);
        add(collegeField);
        add(degreeLabel);
        add(degreeField);
        add(linkedInLabel);
        add(linkedInField);
        add(githubLabel);
        add(githubField);
        add(contactLabel);
        add(contactField);
        add(experienceLabel);
        add(experienceField);
        add(new JLabel());
        add(generateButton);

        pack();
        setVisible(true);
    }

    private void generateCV() {
        // Get all the input values
        String name = nameField.getText();
        String fatherName = SurNameField.getText();
        String city = cityField.getText();
        String email = emailField.getText();
        String skills = skillsField.getText();
        String college = collegeField.getText();
        String degree = degreeField.getText();
        String linkedIn = linkedInField.getText();
        String github = githubField.getText();
        String contact = contactField.getText();
        String experience = experienceField.getText();

//        // Perform validation checks, e.g., password match, required fields filled, etc.
//        if (!passwordField.getPassword().equals(confirmPasswordField.getPassword())) {
//            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

        // Generate the PDF document
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("F:\\ResumeGene\\cv.pdf"));
            document.open();
            document.add(new Paragraph("Online Resume Builder"));
            document.add(new Paragraph("Name: " + name));
            String SurName = null;
            document.add(new Paragraph("Surname: " + SurName));
            document.add(new Paragraph("City: " + city));
            document.add(new Paragraph("Email: " + email));
            document.add(new Paragraph("Skills: " + skills));
            document.add(new Paragraph("College: " + college));
            document.add(new Paragraph("Degree: " + degree));
            document.add(new Paragraph("LinkedIn: " + linkedIn));
            document.add(new Paragraph("GitHub: " + github));
            document.add(new Paragraph("Contact: " + contact));
            document.add(new Paragraph("Experience: " + experience));
            document.close();
            JOptionPane.showMessageDialog(this, "CV generated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating CV.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CVBulider();
            }
        });
    }
}
