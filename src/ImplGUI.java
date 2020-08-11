/**
 * <h2>Implementing the Remote Interface</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <p>The remote interface 'RMIApp' is implemented here. There are two options of implementing a Remote Interface. The
 * implementation class can be written separately or make the server program implement this interface. In this case, the
 * implementation class has been created separately with the name 'ImplGUI'. Since the application has a Graphical User
 * Interface (GUI) that is then displayed, it is also a child class of (extends) Application which has been imported
 * from javafx.application.Application library.</p>
 */
public class ImplGUI extends Application implements RMIApp {
    /**
     * <p>This simply implements the interface method.</p>
     */
    @Override
    public void animation() {
        launch();
    }

    /**
     * This method is for loading a Window and it contains all the objects of a JavaFX application. It is represented by
     * Stage class of the package javafx.stage. The primary stage is created by the platform itself. The created stage
     * object is passed as an argument to the start() method of the Application class. A stage has two parameters
     * determining its position namely Width and Height. It is divided as Content Area and Decorations (Title Bar and Borders).
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        /**
         * <p>The application loads a gui.fxml file that contains all the information regarding how the interface should
         * look like with 'root' as the Parent node. The reason why a .fxml file has been used in place of hard coding on
         * this file is to enable easy styling and editing. Moreover, it gives more compatibility to incorporate .css files
         * especially when the application is needed to be appealing to the eye.</p>
         */
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));

        /**
         * <p>The following code creates a Scene Object. The scene represents the physical contents of a JavaFX application.
         * It contains all the contents of a scene graph.</p>
         */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cars Console");
        stage.setResizable(false);
        stage.show();
    }
}
