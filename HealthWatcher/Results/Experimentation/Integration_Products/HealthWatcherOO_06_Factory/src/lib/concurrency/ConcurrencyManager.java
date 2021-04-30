package lib.concurrency;
import java.util.HashMap;
public class ConcurrencyManager  { 
private final static String ERROR_MESSAGE = "Invallid Execution --- possible programming error at aspects.concurrencyControl.util.ConcurrencyManager";
private HashMap keys;
public synchronized void endExecution(Object key)
    { 
try//1
{ 
if(keys.containsKey(key))//1
{ 
keys.remove(key);
} 
else
{ 
throw new RuntimeException(ERROR_MESSAGE);
} 
} 
catch (Exception ex) //1
{ 
System.out.println(ERROR_MESSAGE + ex.getMessage());
} 
finally { 
notifyAll();
} 
} 
public ConcurrencyManager()
    { 
keys = new HashMap();
} 
public synchronized void beginExecution(Object key)
    { 
while (keys.containsKey(key)) //1
{ 
try//1
{ 
wait();
} 
catch (InterruptedException ex) //1
{ 
throw new RuntimeException(ERROR_MESSAGE + ex.getMessage());
} 
} 
keys.put(key, null);
} 

 } 
