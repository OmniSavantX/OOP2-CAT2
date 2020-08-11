/**
 * <h2></h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ImplGUIModel class is to facilitate the connection of the ImplGUIController Class to the database
 */
public class ImplGUIModel {
    //Declaring variables
    Connection connection;

    public ImplGUIModel(){
        try {
            this.connection = dbConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ImplGUIModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.connection == null){
            System.exit(1);
        }
    }

    /**
     * The boolean method checks for the database connection.
     * @return
     */
    public boolean isDatabaseConnected() {
        return this.connection != null;
    }

}
