// Compilation Unit of /AwtExceptionHandler.java 
 
package org.argouml.util.logging;
import org.apache.log4j.Logger;
public class AwtExceptionHandler  { 
private static final Logger LOG =
        Logger.getLogger(AwtExceptionHandler.class);
public static void registerExceptionHandler()
    { 
System.setProperty("sun.awt.exception.handler",
                           AwtExceptionHandler.class.getName());
} 

public void handle(Throwable t)
    { 
try //1
{ 
LOG.error("Last chance error handler in AWT thread caught", t);
} 
catch (Throwable t2) //1
{ 
} 


} 

 } 


