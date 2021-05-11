
//#if -1156821263 
// Compilation Unit of /AwtExceptionHandler.java 
 

//#if 712318795 
package org.argouml.util.logging;
//#endif 


//#if 1926392940 
import org.apache.log4j.Logger;
//#endif 


//#if -1186222608 
public class AwtExceptionHandler  { 

//#if -496800038 
private static final Logger LOG =
        Logger.getLogger(AwtExceptionHandler.class);
//#endif 


//#if 66135553 
public static void registerExceptionHandler()
    { 

//#if -756100344 
System.setProperty("sun.awt.exception.handler",
                           AwtExceptionHandler.class.getName());
//#endif 

} 

//#endif 


//#if -481212887 
public void handle(Throwable t)
    { 

//#if 698333037 
try //1
{ 

//#if 2144281070 
LOG.error("Last chance error handler in AWT thread caught", t);
//#endif 

} 

//#if -1120578237 
catch (Throwable t2) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

