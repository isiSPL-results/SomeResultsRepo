
//#if 1549299179 
// Compilation Unit of /RMIFacadeFactory.java 
 

//#if 583806999 
package healthwatcher.business.factories;
//#endif 


//#if 1056711305 
import healthwatcher.Constants;
//#endif 


//#if -2107353213 
import healthwatcher.business.RMIFacadeAdapter;
//#endif 


//#if -583255868 
import healthwatcher.view.IFacade;
//#endif 


//#if -1107069873 
import healthwatcher.view.RMIServletAdapter;
//#endif 


//#if 1631239376 
import lib.exceptions.CommunicationException;
//#endif 


//#if -609320697 
public class RMIFacadeFactory extends 
//#if 1936633497 
AbstractFacadeFactory
//#endif 

  { 

//#if 12178450 
public void createServerFacade() throws CommunicationException
    { 

//#if -741337299 
try //1
{ 

//#if 688953388 
RMIFacadeAdapter.getInstance();
//#endif 

} 

//#if 763963309 
catch (Exception e) //1
{ 

//#if 332662009 
throw new CommunicationException(e.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 585798221 
public IFacade createClientFacade() throws CommunicationException
    { 

//#if 1226380524 
return new RMIServletAdapter("//" + Constants.SERVER_NAME + "/" + Constants.SYSTEM_NAME);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

