
//#if -26234030 
// Compilation Unit of /ConcurrencyManager.java 
 

//#if -1127852628 
package lib.concurrency;
//#endif 


//#if -887753795 
import java.util.HashMap;
//#endif 


//#if 3266942 
public class ConcurrencyManager  { 

//#if 1149994124 
private final static String ERROR_MESSAGE = "Invallid Execution --- possible programming error at aspects.concurrencyControl.util.ConcurrencyManager";
//#endif 


//#if 1816773508 
private HashMap keys;
//#endif 


//#if -869483733 
public synchronized void endExecution(Object key)
    { 

//#if 239160338 
try //1
{ 

//#if -979753107 
if(keys.containsKey(key))//1
{ 

//#if -1020794806 
keys.remove(key);
//#endif 

} 
else
{ 

//#if -265718608 
throw new RuntimeException(ERROR_MESSAGE);
//#endif 

} 

//#endif 

} 

//#if -490072328 
catch (Exception ex) //1
{ 

//#if 2097135205 
System.out.println(ERROR_MESSAGE + ex.getMessage());
//#endif 

} 

//#endif 

finally { 

//#if -1177354202 
notifyAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2049794084 
public ConcurrencyManager()
    { 

//#if 1490580777 
keys = new HashMap();
//#endif 

} 

//#endif 


//#if 287837753 
public synchronized void beginExecution(Object key)
    { 

//#if -357090831 
while (keys.containsKey(key)) //1
{ 

//#if 1185708072 
try //1
{ 

//#if 1769492764 
wait();
//#endif 

} 

//#if 1361220446 
catch (InterruptedException ex) //1
{ 

//#if -556914564 
throw new RuntimeException(ERROR_MESSAGE + ex.getMessage());
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 358665389 
keys.put(key, null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

