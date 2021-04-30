
//#if -554514480 
// Compilation Unit of /HWServer.java 
 
package healthwatcher.business;

//#if -1609620431 
import healthwatcher.business.factories.FacadeFactory;
//#endif 


//#if 460397114 
import healthwatcher.Constants;
//#endif 


//#if -1800443959 
import lib.logging.*;
//#endif 

public class HWServer  { 
public static void main(String[] args)
    { 
try //1
{ 

//#if 1053756296 
LogMechanism.configure(Constants.LOG_PATH);
//#endif 

FacadeFactory.getRepositoryFactory().createServerFacade();

//#if -52443964 
LogMechanism.addLogToThreads();
//#endif 

} 

//#if 791361220 
catch (Exception e) //1
{ 
e.printStackTrace();
} 

//#endif 


} 

 } 


//#endif 

