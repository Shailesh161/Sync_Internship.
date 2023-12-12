import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "root"); // replace the password according to your account
            s = c.createStatement();
        } catch (Exception e) {
        }
    }
}


