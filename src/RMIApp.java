/**
 * <h2>Defining the Remote Interface</h2>
 * @author Bill Glinton
 * @author Mandy Achieng
 * @author Dennis Gikunju
 * @version 1.0
 */

//Importing Libraries
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>The remote interface provides the Description of all methods of the remote object.</p>
 */
//Creating the remote interface of the Application
public interface RMIApp extends Remote {
    /**
     * <p>The defined interface 'RMIApp' and the method 'animation()' is used to open up a Graphical User Interface for
     * the Application.</p>
     * @throws RemoteException
     * <p>During Remote Calls, there are chances that network issues might occur. An exception named 'RemoteException'
     * is thrown.</p>
     */
    void animation() throws RemoteException;
}
