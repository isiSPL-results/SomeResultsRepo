
//#if 774806695 
// Compilation Unit of /OpenException.java 
 

//#if 2094662167 
package org.argouml.persistence;
//#endif 


//#if -1110255177 
import java.io.PrintStream;
//#endif 


//#if -1920326876 
import java.io.PrintWriter;
//#endif 


//#if 2128662628 
import org.xml.sax.SAXException;
//#endif 


//#if 1944709086 
public class OpenException extends 
//#if -522880794 
PersistenceException
//#endif 

  { 

//#if 1824465530 
private static final long serialVersionUID = -4787911270548948677L;
//#endif 


//#if -885547147 
public OpenException(String message)
    { 

//#if 228751314 
super(message);
//#endif 

} 

//#endif 


//#if -1295077942 
public void printStackTrace(PrintStream ps)
    { 

//#if 1005498765 
super.printStackTrace(ps);
//#endif 


//#if 886639033 
if(getCause() instanceof SAXException
                && ((SAXException) getCause()).getException() != null)//1
{ 

//#if 915610451 
((SAXException) getCause()).getException().printStackTrace(ps);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1910067315 
public void printStackTrace(PrintWriter pw)
    { 

//#if 2087556870 
super.printStackTrace(pw);
//#endif 


//#if -704851602 
if(getCause() instanceof SAXException
                && ((SAXException) getCause()).getException() != null)//1
{ 

//#if -230405227 
((SAXException) getCause()).getException().printStackTrace(pw);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -191909448 
public void printStackTrace()
    { 

//#if 7783139 
super.printStackTrace();
//#endif 


//#if 332039762 
if(getCause() instanceof SAXException
                && ((SAXException) getCause()).getException() != null)//1
{ 

//#if -895373450 
((SAXException) getCause()).getException().printStackTrace();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2009711736 
public OpenException(String message, Throwable cause)
    { 

//#if 755986467 
super(message, cause);
//#endif 

} 

//#endif 


//#if -2012803330 
public OpenException(Throwable cause)
    { 

//#if 167629237 
super(cause);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

