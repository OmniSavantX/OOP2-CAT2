/**
 * <h2>Connecting the Application to the database</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>The dbConnection class is the class that contains the credentials to access the database. This includes the
 * connection link named as conn_url, username named as username for accessing the database and password is the password
 * for accessing the database. It is important that correct credentials should be entered so as to avoid running into errors.</p>
 */
public class dbConnection {
    //Declaring Connection variables
    private static final String conn_url = "jdbc:mysql://localhost/javafxrmi";//Connection link
    private static final String username = "javafx";//Username for accessing the database
    private static final String password = "javafx";//Password for accessing the database

    /**
     * <p>This method gets a connection from the database and throws a SQLException if there's no connection. This method is where
     * the JDBC driver is called from.</p>
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");//JDBC Driver
            return DriverManager.getConnection(conn_url, username, password);
        } catch (ClassNotFoundException ce) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        return null;
    }
}