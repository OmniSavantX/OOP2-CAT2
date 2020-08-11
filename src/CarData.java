/**
 * <h2>Car Data</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * <p>The CarData class with Getter and Setter Methods is for picking the values placed in the form fields ID, Make, Model and
 * Year in the .fxml file and for adding the same into a table present in the same .fxml file.</p>
 */
public class CarData {
    private final StringProperty ID;
    private final StringProperty Make;
    private final StringProperty Model;
    private final StringProperty Year;

    public CarData(String id, String make, String model, String year) {
        this.ID = new SimpleStringProperty(id);
        this.Make = new SimpleStringProperty(make);
        this.Model = new SimpleStringProperty(model);
        this.Year = new SimpleStringProperty(year);
    }

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getMake() {
        return Make.get();
    }

    public StringProperty makeProperty() {
        return Make;
    }

    public void setMake(String make) {
        this.Make.set(make);
    }

    public String getModel() {
        return Model.get();
    }

    public StringProperty modelProperty() {
        return Model;
    }

    public void setModel(String model) {
        this.Model.set(model);
    }

    public String getYear() {
        return Year.get();
    }

    public StringProperty yearProperty() {
        return Year;
    }

    public void setYear(String year) {
        this.Year.set(year);
    }
}
