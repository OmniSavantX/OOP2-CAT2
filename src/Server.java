/**
 * <h2>Server Program</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * <p>The Server Program implements the remote interface 'RMIApp' and extends the implementation class 'Application'. In this
 * class, a remote object is created and bound to the registry with the name 'RMIApp'</p>
 */
public class Server extends ImplGUI{

    public Server() {}

    public static void main(String[] args) {
        try {
            //Instantiating the implementation class
            ImplGUI obj = new ImplGUI();
            //Binding the remote object(stub) of the implementation class
            //(The remote object is exported to the stub)
            RMIApp stub = (RMIApp) UnicastRemoteObject.exportObject(obj, 0);
            // The remote object is bound to the Registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RMIApp", stub);
            System.err.println("Server Ready");
        } catch (Exception e){
            System.err.println("Server Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
