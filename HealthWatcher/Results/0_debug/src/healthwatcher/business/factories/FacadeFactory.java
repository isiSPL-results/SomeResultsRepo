
//#if -1463413100 
// Compilation Unit of /FacadeFactory.java 
 

//#if -1670920363 
package healthwatcher.business.factories;
//#endif 


//#if -2048711799 
public class FacadeFactory  { 

//#if 55330349 
protected static AbstractFacadeFactory instance = null;
//#endif 


//#if 388187891 
public static AbstractFacadeFactory getRepositoryFactory()
    { 

//#if 1997433150 
if(instance == null)//1
{ 

//#if -120528734 
instance = new RMIFacadeFactory();
//#endif 

} 

//#endif 


//#if -1895441371 
return instance;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

