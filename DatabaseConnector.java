import java.sql.DriverManager;
import java.sql.Connection;
public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/votetrack";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
