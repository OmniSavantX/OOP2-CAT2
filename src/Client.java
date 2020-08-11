/**
 * <h2>Client Program</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * <p>The Client Program Class fetches the remote object and invokes the required method which in this case is 'animation()'.</p>
 */
public class Client {
    private Client() {}
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            RMIApp stub = (RMIApp) registry.lookup("RMIApp");
            stub.animation();
        } catch (Exception e) {
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
