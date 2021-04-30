
//#if -959178123 
// Compilation Unit of /RepositoryFactory.java 
 
package healthwatcher.data.factories;

//#if -1033606193 
import healthwatcher.Constants;
//#endif 


//#if 824294604 
import healthwatcher.business.HealthWatcherFacade;
//#endif 

public class RepositoryFactory  { 
protected static AbstractRepositoryFactory instance = null;
public static AbstractRepositoryFactory getRepositoryFactory()
    { 
if(instance == null)//1
{ 
if(Constants.isPersistent())//1
{ 
instance = new RDBRepositoryFactory(HealthWatcherFacade.getPm());
} 
else
{ 
instance = new ArrayRepositoryFactory();
} 

} 

return instance;
} 

 } 


//#endif 

