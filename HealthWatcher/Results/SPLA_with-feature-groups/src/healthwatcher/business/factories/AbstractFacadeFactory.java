
//#if -1426558568 
// Compilation Unit of /AbstractFacadeFactory.java 
 
package healthwatcher.business.factories;

//#if -371171813 
import healthwatcher.view.IFacade;
//#endif 


//#if 274508569 
import lib.exceptions.CommunicationException;
//#endif 

public abstract class AbstractFacadeFactory  { 
public abstract IFacade createClientFacade() throws CommunicationException;
public abstract void createServerFacade() throws CommunicationException;
 } 


//#endif 

