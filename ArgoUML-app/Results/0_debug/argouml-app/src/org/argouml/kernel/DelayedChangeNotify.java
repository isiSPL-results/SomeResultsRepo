
//#if 1625799230 
// Compilation Unit of /DelayedChangeNotify.java 
 

//#if 1254540091 
package org.argouml.kernel;
//#endif 


//#if 1783830104 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1955319124 
public class DelayedChangeNotify implements 
//#if -260955734 
Runnable
//#endif 

  { 

//#if 460811225 
private DelayedVChangeListener listener;
//#endif 


//#if 474996872 
private PropertyChangeEvent pce;
//#endif 


//#if -1700097901 
public DelayedChangeNotify(DelayedVChangeListener l,
                               PropertyChangeEvent p)
    { 

//#if -941226520 
listener = l;
//#endif 


//#if -2128711194 
pce = p;
//#endif 

} 

//#endif 


//#if 809810018 
public void run()
    { 

//#if -1137018531 
listener.delayedVetoableChange(pce);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

