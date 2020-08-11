/**
 * <h2>Back End</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Alert.AlertType;

/**
 * The ImplGUIController class is a controller class that does the backend work of the application. It holds all the main
 * Transactional capabilities of the application including Loading Entries(Load Data) Adding Entries (Create) and Delete
 * Entries (Delete). This is the class that controls the .fxml file created earlier.
 */
public class ImplGUIController implements Initializable {

    ImplGUIModel implGUIModel = new ImplGUIModel();
    /**
     * <p>The declared variables are from a .fxml file with each one corresponding to an 'id' on the .fxml file </p>
     */
    @FXML
    private Label connection;
    @FXML
    private TextField id;
    @FXML
    private TextField make;
    @FXML
    private TextField model;
    @FXML
    private TextField year;
    @FXML
    private TableView<CarData> cartable;
    @FXML
    private TableColumn<CarData, String> columnID;
    @FXML
    private TableColumn<CarData, String> columnMake;
    @FXML
    private TableColumn<CarData, String> columnModel;
    @FXML
    private TableColumn<CarData, String> columnYear;

    private ObservableList<CarData> data;

    // create an alert 
    Alert a = new Alert(AlertType.NONE); 

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (this.implGUIModel .isDatabaseConnected()){
            System.err.println("Success: Link to database established");
            this.connection.setText("Connected");
            // set alert type 
            a.setAlertType(AlertType.INFORMATION); 
  
            // set content text 
            a.setContentText("Database Connected"); 

            // show the dialog 
            a.show(); 
        } else {
            this.connection.setText("Offline");
            System.err.println("Error: No Link to database");
            // set alert type 
            a.setAlertType(AlertType.INFORMATION); 
            // set content text 
            a.setContentText("Database Not Connected"); 
            // show the dialog 
            a.show(); 
        }
    }

    /**
     * This method loads all the entries in the database when Load Data Button is clicked
     * @param event
     */
    @FXML
    private void RetrieveCarData(ActionEvent event) {
        try {
            //Get connection to the database
            Connection conn = dbConnection.getConnection();
            this.data = FXCollections.observableArrayList();
            //Execute the query that will display all entries in the database
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM car");
            //The while loop will keep executing the above query till all the entries in the database have been loaded.
            while (rs.next()){
                //This displays each entry in each column from the database
                this.data.add(new CarData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            System.err.println("Success: Data retrieved from database successfully!");
            
            // set alert type 
            a.setAlertType(AlertType.INFORMATION); 
            // set content text 
            a.setContentText("Data retrieved successfully"); 
            // show the dialog 
            a.show();

        } catch (SQLException e) {
            System.err.println("Error " + e);
            // set alert type 
            a.setAlertType(AlertType.ERROR); 
            // set content text 
            a.setContentText("Could not retrieve data"); 
            // show the dialog 
            a.show();
        }

        this.columnID.setCellValueFactory(new PropertyValueFactory<CarData, String>("ID"));
        this.columnMake.setCellValueFactory(new PropertyValueFactory<CarData, String>("Make"));
        this.columnModel.setCellValueFactory(new PropertyValueFactory<CarData, String>("Model"));
        this.columnYear.setCellValueFactory(new PropertyValueFactory<CarData, String>("Year"));

        this.cartable.setItems(null);
        this.cartable.setItems(this.data); 
    }

    /**
     * <p>This method is an Event Handler that adds an entry to the database when Create Button is clicked. The method
     * consists of an INSERT SQL statement that inserts data into the database.</p>
     * @param event
     */
    @FXML
    private void AddCarData(ActionEvent event){
        try {

            //A Connection is established from the database
            Connection conn = dbConnection.getConnection();
            //A SQL statement is prepared and values are bound with ? to avoid SQL injections
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO car (id, make, model, year) VALUES (?,?,?,?)");
            //The values bound are the inputs on the GUI form
            stmt.setString(1, this.id.getText());//ID field
            stmt.setString(2, this.make.getText());//Make field
            stmt.setString(3, this.model.getText());//Model field
            stmt.setString(4, this.year.getText());//Year field

            stmt.execute();//Executes the query
            conn.close();//Closes the connection

            System.err.println("Success: Data entered into database!");

            // set alert type 
            a.setAlertType(AlertType.INFORMATION); 
  
            // set content text 
            a.setContentText("Data entered successfully"); 

            // show the dialog 
            a.show();

        } catch (SQLException e) {
            System.err.println("Error: Cannot Add Car Data to the Database");
            System.err.println(e.getMessage());

            // set alert type 
            a.setAlertType(AlertType.ERROR);

            // set content text 
            a.setContentText("Invalid data entry");
            
            // show the dialog 
            a.show();           
        }
    }

    /**
     * <p>This method is an Event Handler that Deletes an Entry When the Delete button is clicked. The method uses the DELETE
     * SQL statement that removes the selected data from the database.</p>
     * @param event
     */
    public void DeleteCarData(ActionEvent event) {
        try {
            Connection conn = dbConnection.getConnection();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM car WHERE id = ? AND make = ? AND model = ? AND year = ?");

            stmt.setString(1, this.id.getText());
            stmt.setString(2, this.make.getText());
            stmt.setString(3, this.model.getText());
            stmt.setString(4, this.year.getText());

            stmt.execute();
            conn.close();//Close connection

            System.out.println("Success: Data deleted from database!");

            // set alert type 
            a.setAlertType(AlertType.WARNING); 
  
            // set content text 
            a.setContentText("Data deleted from database"); 

            // show the dialog 
            a.show(); 

        } catch (SQLException e) {
            System.err.println("Error: Got an Exception");           
        }
    }

    /**
     * <p>This method is an Event Handler that refreshes the form inputs when clicked. This is to easily allow entry of different data
     * in the form.</p>
     * @param event
     */
    public void RefreshForm(ActionEvent event) {
        this.id.setText("");//Refreshes the id field
        this.make.setText("");//Refreshes the make field
        this.model.setText("");//Refreshes the model field
        this.year.setText("");//Refreshes the year field

        System.err.println("Success: Form fields refreshed");

        // set alert type 
        a.setAlertType(AlertType.INFORMATION); 
  
        // set content text 
        a.setContentText("Form fields refreshed"); 

        // show the dialog 
        a.show(); 
    }
}
