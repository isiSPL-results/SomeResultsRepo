
//#if -613044611 
// Compilation Unit of /ConnectionPersistenceMechanismException.java 
 

//#if 201205369 
package lib.exceptions;
//#endif 


//#if -2013277508 
import java.util.logging.Level;
//#endif 


//#if 1303771064 
import lib.logging.LogMechanism;
//#endif 


//#if -2028136647 
public class ConnectionPersistenceMechanismException extends 
//#if -1052377793 
PersistenceMechanismException
//#endif 

  { 

//#if 1503102037 
public String db_url = null;
//#endif 


//#if 1921394825 
public ConnectionPersistenceMechanismException(String erro, String db_url)
    { 

//#if -333222495 
super(erro);
//#endif 


//#if 580408950 
this.db_url = db_url;
//#endif 


//#if -755728788 
LogMechanism.createOccurrence();
//#endif 


//#if -816605700 
LogMechanism.addLog(Level.SEVERE, "Conection problem with DB:"+db_url);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

