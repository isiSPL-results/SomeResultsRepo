package healthwatcher.business.factories;
import healthwatcher.Constants;
import healthwatcher.business.RMIFacadeAdapter;
import healthwatcher.view.IFacade;
import healthwatcher.view.RMIServletAdapter;
import lib.exceptions.CommunicationException;
public class RMIFacadeFactory extends AbstractFacadeFactory
  { 
public void createServerFacade() throws CommunicationException
    { 
try//1
{ 
RMIFacadeAdapter.getInstance();
} 
catch (Exception e) //1
{ 
throw new CommunicationException(e.getMessage());
} 
} 
public IFacade createClientFacade() throws CommunicationException
    { 
return new RMIServletAdapter("//" + Constants.SERVER_NAME + "/" + Constants.SYSTEM_NAME);
} 

 } 
